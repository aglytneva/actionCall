package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoUser: TextView = findViewById(R.id.tvInfoToUser)
        val buttonToStartCall: Button = findViewById(R.id.btnToCall)
        val editNumber: EditText = findViewById(R.id.editNumber)

        buttonToStartCall.setOnClickListener() {

            val number = editNumber.getText().toString()
             if (number.length == 10) {
                val intent = Intent(this, SecondActivity::class.java)
                Intent(intent)
                intent.putExtra("number", number)
                startActivity(intent);
            }
          else infoUser.text = "Введите 10 цифр номера телефона"

//        buttonToStartCall.setOnClickListener {
//            val number = in.getText().toString()
//            val intent = Intent(this, WeatherActivity::class.java)
//            Intent(intent)
//            intent.putExtra("city", city)
//            startActivity(intent);
//            val text = start.getText().toString()
//            val intent = Intent()
//            intent.putExtra("text", text)
//            startActivity(Intent(this,SecondActivity::class.java))
//

        }


    }


}



