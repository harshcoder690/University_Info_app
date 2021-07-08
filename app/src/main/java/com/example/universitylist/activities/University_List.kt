package com.example.universitylist.activities

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.universitylist.R
import com.example.universitylist.UnversityresponseItem
import com.example.universitylist.adapters.Listadapter
import com.example.universitylist.networking.Client
import kotlinx.android.synthetic.main.activity_university__list.*
import kotlinx.android.synthetic.main.item_univ.*
import kotlinx.android.synthetic.main.item_univ.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class University_List : AppCompatActivity() {

    val originalList = arrayListOf<UnversityresponseItem>()
    var adapter = Listadapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university__list)

        var country1: String? = intent.getStringExtra("country")

        var name1: String? = intent.getStringExtra("name1")

        tvUserName.text = "Welcome,\n$name1"

        adapter.onItemClick = { s: String, s1: String, s2: String, s3: String, s4: String ->
            val intent = Intent(this, universitydetail::class.java)
            intent.putExtra("UNIV_NAME", s)
            intent.putExtra("ALPHA_TWO_CODE", s1)
            intent.putExtra("WEB_PAGE", s2)
            intent.putExtra("DOMAINS", s3)
            intent.putExtra("COUNTRY", s4)
            startActivity(intent)
        }

        userRv.apply {
            layoutManager = LinearLayoutManager(this@University_List)
            adapter = this@University_List.adapter
        }

        GlobalScope.launch(Dispatchers.Main){
            val response= withContext(Dispatchers.IO){ country1?.let { Client.api.getUniv(it) } }

            if(response?.isSuccessful == true){
                response?.body()?.let {
                    originalList.addAll(it)
                    adapter.swapData(it)
                }
            }
        }

    }


}