package org.sopt.jointseminar.melon.presentation.posting

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import org.sopt.jointseminar.melon.R
import org.sopt.jointseminar.melon.databinding.ActivityPostingBinding

class PostingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostingBinding
    private val postingViewModel by viewModels<PostingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        observeReview()
    }

    private fun initViewModel(){
        binding.viewModel=postingViewModel
        binding.lifecycleOwner=this
    }

    private fun observeReview(){
        postingViewModel.review.observe(this){
            postingViewModel.updateCount()
            if(postingViewModel.checkRegister()){
                binding.tvRegistration.isClickable=true
                binding.tvRegistration.setTextColor(ContextCompat.getColor(this, R.color.green_500))
            }
            else{
                binding.tvRegistration.isClickable=false
                binding.tvRegistration.setTextColor(ContextCompat.getColor(this, R.color.gray_500))
            }
            postingViewModel.makeString()
        }
    }
}