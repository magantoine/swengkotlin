package com.github.magantoine.bootcampkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
const val MIN_AGE : Int = 18
class GreetingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)
        val name : String? = intent.getStringExtra(EXTRA_NAME)
        val age : Int  = intent.getIntExtra(EXTRA_AGE, -1)
        showGreetings(name, age)

    }

    private fun showGreetings(name : String?, age : Int){

        val greets : TextView = findViewById<EditText>(R.id.textSlotGreeting)

        val sentence =
            if(name == null || age == -1)
                "Sorry, an error occurred"
            else
                    if (age >= MIN_AGE)
                        "Hi, $name ($age), we're glad to see you!\nEnjoy the ride!"
                    else
                        "HI, sorry but $age is under the required age to enter..."

        greets.apply { text = sentence }
    }
}