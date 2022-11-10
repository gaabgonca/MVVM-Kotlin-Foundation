# MVVM Foundation

This projects aims to speed up development of Android apps by providing a solid base to extend

# Libraries 

- Jetpack Fragment
- Material3 : for UI components and theming.
- ViewPager2 : for ViewPager UI component. Used in sliding tabs.
- EasyBinding : Abstract classes for Activities and Fragments that use viewBinding.
- Hilt : dependency injection.
- Room : local SQLite database.
- RxJava3 : reactive programming in Android (so far not used, but good to have for the future).

# Architecture

```markdown
├── BaseApplication.kt
├── constants
│   └── NavigationConstants.kt
├── di_modules
│   ├── DatabaseModule.kt
│   └── DispatcherModule.kt
├── MainActivity.kt
├── model
│   ├── database
│   │   ├── AppDatabase.kt
│   │   ├── entities
│   │   │   └── TimeRecord.kt
│   │   └── TimeRecordsDao.kt
│   └── repository
│       └── TimeRecordsRepository.kt
├── view
│   ├── ButtonControlsFragment.kt
│   ├── FeedFragment.kt
│   └── navigation
│       └── ViewPagerAdapter.kt
└── viewmodel
    └── ButtonControlsViewModel.kt
```

- BaseApplication is the entry point to the app. Annotated with @HiltAndroidApp to use dependency injection.
- constants contains constants.
- di_modules contains dependency injection providers (When Hilt is unable to figure out a dependency to inject, create a module to explicitly define how to provide the dependency).
- model contains data related logic and infrastructure.
  - database contains classes related to database.
    - entities are data classes used by the database.
  - repoitory contains repositories (used to abstract database operations).
- view contains Activities, Fragments and related UI classes (adapters, viewholders, etc).
- viewmodel contains viewModels. 

## How does this work
Consider we need to show a list of TimeRecords (provided entity) in  FeedFragment

1. `TimeRecordsDao` defines a method for retrieving the list from the database `TimeRecordsDao.getAll() : List<TimeRecord>` by executing an annotated SQL query.
2. `TimeRecordsRepository` defines a method `TimeRecordsRepository.getAllRecords(): List<TimeRecord>` that calls the Dao method with a Dispatcher Context (to avoid blocking the UI thread).
3. `ButtonControlsViewModel` creates a coroutine `ButtonControlsViewModel.getAllRecords()` that calls the repository method within a coroutineScope and posts results to `timeRecordsLiveData`.
4. `FeedFragment` **observes** `ButtonControlsViewModel.timeRecordsLiveData` and reacts to changes in the data, updating the UI.
5. `ButtonControlsFragment` calls `ButtonControlsViewModel.getAllRecords()` to start the flow 

## Takeaways 

- The Dao is an interface that provides abstract suspend functions to communicate (execute queries) with the Database. Methods do not have a body, the annotation generates the code under the hood.
- The Repository knows nothing about the Database, it only knows what the injected Dao can do and defines the injected Dispatcher to use.
- The ViewModel knows nothing about the Dao, it only knows the methods that the injected Repository can provide and creates coroutines.
- The ViewModel knows nothing about the View either, it uses callbacks to interact with Activities/Fragments and liveData to provide data to the observers (Activities/Fragments).
- The View only knows about the ViewModel, it has absolutely no idea regarding the Database or the Repository.
- This separation of concerns allows us to change specific components (for example, the Dispatcher injected to the Repository or the Repository injected to the ViewModel) with ease.
- Sharing ViewModels across Fragments/Activities allows sharing state and methods (we call `getDataAllRecords()` in ButtonControlsFragment and observe the state changes results on FeedFragment)
- Dependency injection (di) allows to change/update dependencies with less code and less memory allocation. For instance, we need the same instance of `ButtonControlsViewModel` for `FeedFragment` and `ButtonControlsFragment`, so we inject the ViewModel in the activity scope `byActivityViewModels()` to make the same instance available for both fragments. Without Hilt sharing a ViewModel in this case would require to make it a Singleton (and implement the singleton logic)


