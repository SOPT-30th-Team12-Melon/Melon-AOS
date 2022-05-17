package org.sopt.jointseminar.melon.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.jointseminar.melon.databinding.ActivityPostingBinding

class PostingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPostingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPostingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}