package com.example.p1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val personList = mutableListOf<Person>()
    private lateinit var adapter: ArrayAdapter<String>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val firstNameInput = findViewById<EditText>(R.id.firstNameInput)
        val lastNameInput = findViewById<EditText>(R.id.lastNameInput)
        val addressInput = findViewById<EditText>(R.id.addressInput)
        val phoneInput = findViewById<EditText>(R.id.phoneInput)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val personListView = findViewById<ListView>(R.id.personListView)

        val nameList = mutableListOf<String>()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList)
        personListView.adapter = adapter


        saveButton.setOnClickListener{
            val firstName = firstNameInput.text.toString()
            val lastName = lastNameInput.text.toString()
            val address = addressInput.text.toString()
            val phone = phoneInput.text.toString()

            if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
                val person = Person(firstName, lastName, address, phone)
                personList.add(person)
                nameList.add("$firstName $lastName")
                adapter.notifyDataSetChanged()
                clearInputs(firstNameInput, lastNameInput, addressInput, phoneInput)
            }else {
                Toast.makeText(this, "Введите имя и фамилию", Toast.LENGTH_LONG).show()
            }
        }
        personListView.setOnItemClickListener {_, _, position, _ ->
            val selectedPerson = personList[position]
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("person", selectedPerson)
            }
            startActivity(intent)
        }
    }
    private fun clearInputs(vararg inputs: EditText){
        for (input in inputs){
            input.text.clear()
        }
    }
}