package org.sopt.jointseminar.melon.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
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
        supportFragmentManager.commit {
            add<HomeFragment>(R.id.fcv_main)
        }
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    supportFragmentManager.commit {
                        replace<HomeFragment>(R.id.fcv_main)
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.menu_chart -> {
                    supportFragmentManager.commit {
                        replace<ChartFragment>(R.id.fcv_main)
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.menu_live -> {
                    supportFragmentManager.commit {
                        replace<LiveFragment>(R.id.fcv_main)
                    }
                    return@setOnItemSelectedListener true
                }
                R.id.menu_search -> {
                    supportFragmentManager.commit {
                        replace<SearchFragment>(R.id.fcv_main)
                    }
                    return@setOnItemSelectedListener true
                }
                else -> {
                    supportFragmentManager.commit {
                        replace<StorageFragment>(R.id.fcv_main)
                    }
                    return@setOnItemSelectedListener true
                }
            }
        }
    }
}
