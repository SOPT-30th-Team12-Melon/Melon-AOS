package org.sopt.jointseminar.melon.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import org.sopt.jointseminar.melon.R
import org.sopt.jointseminar.melon.databinding.ActivityMainBinding
import org.sopt.jointseminar.melon.presentation.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavi()
    }

    private fun initBottomNavi() {
        supportFragmentManager.commit {
            replace<HomeFragment>(R.id.fcv_main)
        }
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> replaceFragment<HomeFragment>()
                R.id.menu_chart -> replaceFragment<ChartFragment>()
                R.id.menu_live -> replaceFragment<LiveFragment>()
                R.id.menu_search -> replaceFragment<SearchFragment>()
                else -> replaceFragment<StorageFragment>()
            }
            return@setOnItemSelectedListener true
        }
    }

    private inline fun <reified T : Fragment> replaceFragment() {
        supportFragmentManager.commit {
            replace<T>(R.id.fcv_main)
        }
    }
}
