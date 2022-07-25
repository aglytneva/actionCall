package com.example.activity

import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity(R.layout.activity_second) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val number: TextView =findViewById<TextView>(R.id.tvNumberCall)


        var numberFromFirstActivity :String = intent.getStringExtra("number").toString()
        number.setText("Выполняем вызов на номер \n $numberFromFirstActivity")

        val numberForCall ="+7"+numberFromFirstActivity



        val intentNumber = Intent (ACTION_CALL)
        intentNumber.data = Uri.parse ("tel:" + numberForCall)
        startActivity (intentNumber)
    }

}