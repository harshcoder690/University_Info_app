package com.example.universitylist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.universitylist.R
import kotlinx.android.synthetic.main.activity_universitydetail.*

class universitydetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universitydetail)

        var name: String? = intent.getStringExtra("UNIV_NAME").toString()
        var alpha_two_code: String? = intent.getStringExtra("ALPHA_TWO_CODE").toString()
        var web_pages: String? = intent.getStringExtra("WEB_PAGE").toString()
        var domain: String? = intent.getStringExtra("DOMAINS").toString()
        var country1: String? = intent.getStringExtra("COUNTRY").toString()

        univname.text = name
        alphaTwoCode.isVisible = true
        alphaTwoCode.text = alpha_two_code.toString()
        weblink.text = " webPages : $web_pages "
        domains.text = " Domains : $domain "
        country.text = " country : $country1 "
    }
}