package com.project.mvvm_pratice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.project.mvvm_pratice.R
import com.project.mvvm_pratice.databinding.ActivityMainBinding
import com.project.mvvm_pratice.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mbinding : ActivityMainBinding
    private val model : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mbinding.lifecycleOwner = this
        mbinding.viewModel = model

        val setMaxnum = findViewById<Button>(R.id.setMaxNumbtn)

        setMaxnum.setOnClickListener{
            val intent = Intent(this, SetMaxActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}