package com.example.universitylist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.universitylist.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextBtn.setOnClickListener {

            var ctry = countryEt.text.toString()
            var nme = nameEt.text.toString()

            if(ctry.isNullOrEmpty() == false && nme.isNullOrEmpty() == false){

                val intent = Intent(this, University_List::class.java)

                intent.apply {
                    putExtra("country", ctry)
                    putExtra("name1", nme)
                }

                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Fill the Reqiured Fields",Toast.LENGTH_SHORT).show()
            }

        }

    }


}