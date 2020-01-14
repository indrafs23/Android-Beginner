package com.example.indonesiansingers.Main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.example.indonesiansingers.Data.Singers
import com.example.indonesiansingers.Data.SingersData
import com.example.indonesiansingers.Model.ListSingersAdapter
import com.example.indonesiansingers.R
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var lvSingers: RecyclerView
    private var list: ArrayList<Singers> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvSingers = findViewById(R.id.lvSingers)
        lvSingers.setHasFixedSize(true)

        list.addAll(SingersData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        lvSingers.layoutManager = LinearLayoutManager(this)
        val listSingersAdapter = ListSingersAdapter(list)
        lvSingers.adapter = listSingersAdapter

        listSingersAdapter.setOnItemClickCallback(object : ListSingersAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Singers) {
                val moveDetail = Intent(this@MainActivity, DetailActivity::class.java)
                moveDetail.putExtra("data", data as Serializable)
                startActivity(moveDetail)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(itemId: Int) {
        when(itemId) {
            R.id.image_profile -> {
                val moveProfile = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveProfile)
            }
        }
    }
}
