package com.example.indonesiansingers.Main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.indonesiansingers.Data.Singers
import com.example.indonesiansingers.R

class DetailActivity : AppCompatActivity() {
    private lateinit var data: Singers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        changeName("Detail Indonesian Singers")
        data = (intent.extras.getSerializable("data") as? Singers)!!

        showDetail()
    }

    private fun showDetail(){
        val nameView = findViewById<TextView>(R.id.detail_name)
        nameView.setText(data.name)

        val fromView = findViewById<TextView>(R.id.detail_from)
        fromView.setText(data.from)

        val imgView = findViewById<ImageView>(R.id.detail_photo)
        Glide.with(this)
            .load(data.photo)
            .into(imgView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun changeName(title: String){
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setMode(itemId: Int) {
        when(itemId) {
            android.R.id.home -> {
                finish()
            }
        }
    }
}