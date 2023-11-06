package com.example.justyoutube

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.justyoutube.adapter.YoutubeItemAdapter
import com.example.justyoutube.databinding.ActivityMainBinding
import com.example.justyoutube.ui.DetailActivity
import com.example.justyoutube.ui.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var mainBinding: ActivityMainBinding
    private var youtubeItemAdapter: YoutubeItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setUpView()
        fetchAPI()
    }

    private fun fetchAPI() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getYoutubeList()
        viewModel.myResponse.observe(this, Observer {
            youtubeItemAdapter?.submitList(it.data)
            Log.d(TAG, it.data.toString())
            Log.d(TAG, it.statusCode.toString())
        })

    }

    private fun setUpView() {
        youtubeItemAdapter = YoutubeItemAdapter(this@MainActivity)
        mainBinding.mainScreenRecyclerView.apply {
            adapter = youtubeItemAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
        youtubeItemAdapter?.onItemClick = { youtube, context ->
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("youtubeKey", youtube)
            context.startActivity(intent)

        }

    }
}
