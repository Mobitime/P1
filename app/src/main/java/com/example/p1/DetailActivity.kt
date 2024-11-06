package com.example.p1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val person = intent.getSerializableExtra("person") as? Person
        val firstNameText = findViewById<TextView>(R.id.firstNameText)
        val lastNameText = findViewById<TextView>(R.id.lastNameText)
        val addressText = findViewById<TextView>(R.id.addressText)
        val phoneText = findViewById<TextView>(R.id.phoneText)


        person?.let {
            firstNameText.text = "Имя: ${it.firstName}"
            lastNameText.text = "Фамилия: ${it.lastName}"
            addressText.text = "Адрес: ${it.address}"
            phoneText.text = "Телефон: ${it.phone}"
        }
    }
}
