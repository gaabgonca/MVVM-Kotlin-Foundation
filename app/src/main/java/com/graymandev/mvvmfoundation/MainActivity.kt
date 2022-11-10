package com.graymandev.mvvmfoundation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import com.graymandev.mvvmfoundation.constants.NavigationConstants.ControlsTag
import com.graymandev.mvvmfoundation.constants.NavigationConstants.FeedTag
import com.graymandev.mvvmfoundation.databinding.ActivityMainBinding
import com.graymandev.mvvmfoundation.view.ButtonControlsFragment
import com.graymandev.mvvmfoundation.view.FeedFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var buttonControlsFragment: ButtonControlsFragment
    private lateinit var feedFragment: FeedFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        //This checks if the [Activity] was created before
        // If savedInstanceState is null, create fragments and show ButtonControlsFragment
        if (savedInstanceState == null) {
            createFragments()
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(binding.mainFragmentContainer.id, buttonControlsFragment, ControlsTag)
            }
        } else {
            restoreFragments(savedInstanceState)
        }

        //When clicking a tab, change the fragment to show
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_controls -> {
                    loadFragmentInContainer(buttonControlsFragment, ControlsTag)
                }
                R.id.page_feed -> {
                    loadFragmentInContainer(feedFragment, FeedTag)
                }
                else -> {
                    false
                }
            }

        }

        setContentView(view)
    }


    /**
     * Replaces current shown fragment
     */
    private fun loadFragmentInContainer(fragment: Fragment, tag: String) : Boolean {
        supportFragmentManager.commitNow(true) {
            replace(
                binding.mainFragmentContainer.id, fragment,
                tag
            )
        }
        return true
    }

    /**
     * On first launch fragments need to be initialized
     */
    private fun createFragments() {
        buttonControlsFragment = ButtonControlsFragment()
        feedFragment = FeedFragment()
    }

    /**
     * When [savedInstanceState] is not null, do not create fragments again.
     * Find them by tag.
     */
    private fun restoreFragments(savedInstanceState: Bundle) {
        buttonControlsFragment =
            supportFragmentManager.findFragmentByTag(ControlsTag) as ButtonControlsFragment
    }
}