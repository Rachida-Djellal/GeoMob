package com.example.geomob.Adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.geomob.Fragments.MainFragment
import com.example.geomob.Fragments.TweetsFragment
import com.example.geomob.Fragments.VideosFragment

class CountryPagesAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT ) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return MainFragment()
            }
            1 -> {
                return VideosFragment()
            }
            2 -> {
                return TweetsFragment()
            }
            else -> return MainFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> {
                "Pays"
            }
            1 -> {
                "Videos"
            }
            2 -> {
                "Tweets"
            }
            else -> "Information du pays"
        }
    }



    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}