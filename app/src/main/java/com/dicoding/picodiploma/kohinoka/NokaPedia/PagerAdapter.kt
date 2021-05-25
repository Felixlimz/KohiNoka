package com.dicoding.picodiploma.kohinoka.NokaPedia

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.picodiploma.kohinoka.R


class PagerAdapter(private val mContext : Context, fm : FragmentManager):
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.pediasatu,
            R.string.pediadua
        )

    }

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> PediaFragment()
            1 -> DuaFragment()
            else -> Fragment()
        }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? =
        mContext.resources.getString(TAB_TITLES[position])
}