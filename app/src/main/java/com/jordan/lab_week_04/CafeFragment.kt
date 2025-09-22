package com.jordan.lab_week_04

import CafeAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.jordan.lab_week_04.R // Your R file import

// Define lists for both titles and descriptions
val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)
val TABS_DESC = listOf(
    R.string.starbucks_desc,
    R.string.janjijiwa_desc,
    R.string.kopikenangan_desc
)

class CafeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafe, container, false) // Use your correct layout file
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        val cafeAdapter = CafeAdapter(
            childFragmentManager,
            lifecycle,
            requireContext().resources
        )
        viewPager.adapter = cafeAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(TABS_FIXED[position])
        }.attach()
    }
}