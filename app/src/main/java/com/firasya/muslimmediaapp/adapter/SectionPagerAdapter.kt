package com.firasya.muslimmediaapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.firasya.muslimmediaapp.Fragment.AboutAlQuranFragment
import com.firasya.muslimmediaapp.Fragment.AlJazeeraFragment
import com.firasya.muslimmediaapp.Fragment.CommonFragment
import com.firasya.muslimmediaapp.Fragment.WarningFragment

class SectionPagerAdapter(fa: FragmentActivity)
: FragmentStateAdapter(fa){
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CommonFragment()
            1 -> AboutAlQuranFragment()
            2 -> AlJazeeraFragment()
            3 -> WarningFragment()
            else -> AlJazeeraFragment()
        }


    }

}