package org.sopt.jointseminar.melon.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.jointseminar.melon.R
import org.sopt.jointseminar.melon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavi()
    }

    private fun initBottomNavi(){
        val homeFragment = HomeFragment()
        val chartFragment = ChartFragment()
        val liveFragment = LiveFragment()
        val searchFragment = SearchFragment()
        val storageFragment = StorageFragment()

        supportFragmentManager.beginTransaction().add(R.id.fcv_main, homeFragment).commit()
        binding.bnvMain.setOnItemSelectedListener{
            val transaction = supportFragmentManager.beginTransaction()
            when(it.itemId){
                R.id.menu_home->{
                    transaction.replace(R.id.fcv_main,homeFragment)
                    transaction.commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_chart->{
                    transaction.replace(R.id.fcv_main,chartFragment)
                    transaction.commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_live->{
                    transaction.replace(R.id.fcv_main,liveFragment)
                    transaction.commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_search->{
                    transaction.replace(R.id.fcv_main,searchFragment)
                    transaction.commit()
                    return@setOnItemSelectedListener true
                }
                else->{
                    transaction.replace(R.id.fcv_main,storageFragment)
                    transaction.commit()
                    return@setOnItemSelectedListener true
                }
            }
        }
    }
}