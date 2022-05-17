package org.sopt.jointseminar.melon.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import org.sopt.jointseminar.melon.R
import org.sopt.jointseminar.melon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavi()
    }

    private fun initBottomNavi() {
        val homeFragment = HomeFragment()
        val chartFragment = ChartFragment()
        val liveFragment = LiveFragment()
        val searchFragment = SearchFragment()
        val storageFragment = StorageFragment()

        supportFragmentManager.beginTransaction().add(R.id.fcv_main, homeFragment).commit()
        binding.bnvMain.setOnItemSelectedListener {
            val transaction = supportFragmentManager.beginTransaction()
            when (it.itemId) {
                R.id.menu_home -> replaceFragment(transaction, homeFragment)
                R.id.menu_chart -> replaceFragment(transaction, chartFragment)
                R.id.menu_live -> replaceFragment(transaction, liveFragment)
                R.id.menu_search -> replaceFragment(transaction, searchFragment)
                else -> replaceFragment(transaction, storageFragment)
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun replaceFragment(transaction: FragmentTransaction, fragment: Fragment) {
        transaction.replace(R.id.fcv_main, fragment)
        transaction.commit()
    }
}