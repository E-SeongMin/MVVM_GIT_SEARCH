package com.study.mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.study.mvvm.R
import com.study.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resultBtn.setOnClickListener {
            startActivity(Intent(this, UserInfoActivity::class.java).putExtra("name", binding.githubUserName.text.toString()))
        }

        binding.githubUserName.setOnEditorActionListener { textView, action, event ->
            var handled = false
            if (action == EditorInfo.IME_ACTION_DONE) {
                startActivity(Intent(this, UserInfoActivity::class.java).putExtra("name", binding.githubUserName.text.toString()))
                handled = true
            }
            handled
        }
    }
}