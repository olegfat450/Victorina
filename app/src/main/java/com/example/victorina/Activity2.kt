package com.example.victorina

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {

         private lateinit var button: Button
         private lateinit var textTv: TextView

         private lateinit var quest1: RadioButton
         private lateinit var quest2: RadioButton
         private lateinit var quest3: RadioButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)

        button = findViewById(R.id.button)
        textTv = findViewById(R.id.textTv)

        quest1 = findViewById(R.id.quest1)
        quest2 = findViewById(R.id.quest2)
        quest3 = findViewById(R.id.quest3)


            var x = 0

        var i = intent.getIntExtra("key",0)
        var j = intent.getIntExtra("key1",0)


         if ( i < 5) { textTv.text = database().text[i];quest2.text = database().answ[i][1].toString()
                      quest1.text = database().answ[i][0].toString(); quest3.text = database().answ[i][2].toString()
        } else startActivity(Intent(this,ResultActivity::class.java).putExtra("key2",j))


            quest1.setOnClickListener{ x = 1 }
            quest2.setOnClickListener{ x = 2 }
            quest3.setOnClickListener { x = 3 }



        button.setOnClickListener {

            if ( x == database().answ[i][3]) j += 100
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("key",++i)
            intent.putExtra("key1",j)
             startActivity(intent)


        }

        }
    }
