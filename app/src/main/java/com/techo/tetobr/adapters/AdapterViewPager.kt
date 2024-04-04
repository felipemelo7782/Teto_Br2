package com.techo.tetobr.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AdapterViewPager(private val fragmentActivity: FragmentActivity, private val arr: ArrayList<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun createFragment(position: Int): Fragment {
        return arr[position]
    }
}
