package com.example.victorina

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

       private lateinit var resultTv: TextView
       private lateinit var textTv: TextView
       private lateinit var button1: Button
       private lateinit var button2: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

           resultTv = findViewById(R.id.resultTv)
           textTv = findViewById(R.id.textTv)
           button1 = findViewById(R.id.button1)
           button2 = findViewById(R.id.button2)

        val result = intent.getIntExtra("key2",0)
        var x = result/100-1; if ( x < 0 ) x = 0

        resultTv.text = result.toString()
          textTv.text = database().grade[x]


             button2.setOnClickListener { finishAffinity()}

            button1.setOnClickListener {startActivity(Intent(this,MainActivity::class.java)) }


        }
    }
