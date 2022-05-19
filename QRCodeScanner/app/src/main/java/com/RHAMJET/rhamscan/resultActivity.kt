package com.RHAMJET.rhamscan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.RHAMJET.rhamscan.R
import android.content.Intent
import android.widget.TextView
import com.RHAMJET.rhamscan.QRPage

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        //define new variable
        val textResults = findViewById<TextView>(R.id.resultText)

        //Call key and output value as variable msg
        val msg = intent.getStringExtra("Key")
        textResults.text = msg
    }

}