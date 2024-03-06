package com.example.surveywithoutcompose.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.surveywithoutcompose.R
import com.example.surveywithoutcompose.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        activityMainBinding.activity = this@MainActivity

    }

    fun onClickButtom(isPostMethod : Boolean){
        if(isPostMethod){
            startActivity(Intent(this@MainActivity, ProductListActivity::class.java))
        }else{
            startActivity(Intent(this@MainActivity, PostListActivity::class.java))
        }
    }
}