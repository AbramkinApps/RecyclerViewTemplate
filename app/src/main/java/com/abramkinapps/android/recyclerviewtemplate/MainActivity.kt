package com.abramkinapps.android.recyclerviewtemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.abramkinapps.android.recyclerviewtemplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = ThingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
            adapter.addThings(TestData.getThingList())
            adapter.setOnItemClickListener(object: ThingAdapter.onItemClickListener{

                override fun onItemClick(position: Int) {
                    Toast.makeText(this@MainActivity,"Item ${position+1} clicked", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }
}