package com.study.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import coil.transform.CircleCropTransformation
import com.study.mvvm.R
import com.study.mvvm.databinding.ActivityUserInfoBinding
import com.study.mvvm.viewmodel.GithubViewModel

class UserInfoActivity : AppCompatActivity() {

    private val viewModel by viewModels<GithubViewModel>()
    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")

        if (name != null) {
            viewModel.getGithubUser(name)
            viewModel.getGithub.observe(this) { data ->
                binding.profileImg.load(data.avatarUrl) {
                    transformations(CircleCropTransformation())
                }
                binding.userNameText.text = "${data.username}(${data.name})"
                binding.followInfo.text = "followers: ${data.followers}, following: ${data.following}"
                binding.companyText.text = "Company : ${data.company}"
                binding.locationText.text = "Location : ${data.location}"
                binding.linkText.text = "Blog : ${data.blog}"
            }
        }
    }
}