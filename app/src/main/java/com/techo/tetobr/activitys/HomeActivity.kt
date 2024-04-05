package com.techo.tetobr.activitys

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.techo.tetobr.R
import com.techo.tetobr.adapters.AdapterViewPager
import com.techo.tetobr.databinding.ActivityHomeBinding
import com.techo.tetobr.fragments.EventsFragment
import com.techo.tetobr.fragments.HomeFragment
import com.techo.tetobr.fragments.ProfileFragment
import com.techo.tetobr.fragments.SearchFragment
import com.techo.tetobr.fragments.UsersFragment


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //-----------
        val statusBarHeight = getStatusBarHeight()
        binding.let {
            val hometoolbar = it.toolbar
            val layoutParams = hometoolbar.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.setMargins(0, statusBarHeight, 0, 0)
            hometoolbar.layoutParams = layoutParams }
        //-----------
        initializeLogic(binding)
    }
    private fun initializeLogic(it: ActivityHomeBinding) {
        val fragmentArrayList: ArrayList<Fragment> = ArrayList<Fragment>()
        val ArrayList: ArrayList<Fragment> = ArrayList<Fragment>()
        fragmentArrayList.add(HomeFragment())
        fragmentArrayList.add(UsersFragment())
        fragmentArrayList.add(EventsFragment())
        fragmentArrayList.add(ProfileFragment())
        val adapterViewPager = AdapterViewPager(this, fragmentArrayList)
        it.viewpager.adapter = adapterViewPager
        it.viewpager.isUserInputEnabled = false
        it.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> it.bottomNavigationView.selectedItemId = R.id.mInicio
                    1 -> it.bottomNavigationView.selectedItemId = R.id.mPesquisar
                    2 -> it.bottomNavigationView.selectedItemId = R.id.mEventos
                    3 -> it.bottomNavigationView.selectedItemId = R.id.mPerfil
                }
                super.onPageSelected(position)
            }
        })
        val colorStateList = ContextCompat.getColorStateList(this, R.color.bottom_nav_colors)
        // Define a cor do estado do ícone e texto para a BottomNavigationView
        it.bottomNavigationView.itemIconTintList = colorStateList
        it.bottomNavigationView.itemTextColor = colorStateList

        it.bottomNavigationView.setOnItemSelectedListener { item ->
            val itemId = item.itemId // Obtenha o ID do item de menu selecionado
            when (itemId) {
                R.id.mInicio -> it.viewpager.setCurrentItem(0, false)
                R.id.mPesquisar -> it.viewpager.setCurrentItem(1, false)
                R.id.mEventos -> it.viewpager.setCurrentItem(2, false)
                R.id.mPerfil -> it.viewpager.setCurrentItem(3, false)
            }
            true
        }
    }
    @SuppressLint("DiscouragedApi", "InternalInsetResource")
    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }
}