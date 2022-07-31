package com.example.activity

import android.Manifest.permission
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.content.Intent.ACTION_DIAL
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class SecondActivity: AppCompatActivity(R.layout.activity_second) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val number: TextView =findViewById<TextView>(R.id.tvNumberCall)
        val REQUEST_CODE=1
        if (
            //проверяет есть ли разрешение пользователя на доступ к звонкам из приложения
            ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),
            // надо инициализировать переменную REQUEST_CODE любым значением
                REQUEST_CODE)

        } else {
            //блок запускается если разрешение пользователя уже получено
            // else block means user has already accepted.And make your phone call here.
            var numberFromFirstActivity :String = intent.getStringExtra("number").toString()
            number.setText("Выполняем вызов на номер \n $numberFromFirstActivity")
            val numberForCall ="+7"+numberFromFirstActivity
            val intentNumber = Intent (ACTION_CALL)
            intentNumber.data = Uri.parse ("tel:" + numberForCall)
            startActivity (intentNumber)



        }

    }

}