package com.zfy.mytakeout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.zfy.mytakeout.ui.fragment.HomeFragment
import com.zfy.mytakeout.ui.fragment.MoreFragment
import com.zfy.mytakeout.ui.fragment.OrderFragment
import com.zfy.mytakeout.ui.fragment.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val fragments: List<Fragment> = listOf(HomeFragment(), OrderFragment(), UserFragment(), MoreFragment())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomBar()
        changeIndex(0)
    }

    private fun initBottomBar() {
        for (i in 0 until main_bottom_bar.childCount) {
            main_bottom_bar.getChildAt(i).setOnClickListener {
                changeIndex(i)
            }
        }
    }

    private fun changeIndex(indax: Int) {
        supportFragmentManager.beginTransaction().replace(R.id.main_content, fragments[indax]).commit()
        for (i in 0 until main_bottom_bar.childCount) {
            if (i == indax) {
                setEnable(main_bottom_bar.getChildAt(i), false)
            } else {
                setEnable(main_bottom_bar.getChildAt(i), true)
            }
        }
    }

    private fun setEnable(view: View?, b: Boolean) {
        view?.let { it.isEnabled = b }
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                view.getChildAt(i).isEnabled = b
            }
        }
    }
}
