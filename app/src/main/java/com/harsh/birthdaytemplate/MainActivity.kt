package com.harsh.birthdaytemplate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.harsh.birthdaytemplate.R.id.nameInputText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_BirthdayTemplate)

        this.title = "eGreet"

        setContentView(R.layout.activity_main)

    }

    fun createButton(view: View) {

        //findViewById<EditText>(nameInputText)

        val nameInputText = findViewById<EditText>(R.id.nameInputText)
        val name = nameInputText.editableText.toString()
         //Toast.makeText(this,"Name is $name", Toast.LENGTH_LONG).show()

        val intent = Intent(this, BirthdayGreetingActivity::class.java)
        intent.putExtra(BirthdayGreetingActivity.NAME_EXTRA, name)
        startActivity(intent)
    }

    override fun getSupportActionBar(): ActionBar? {
        return super.getSupportActionBar()
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 3000)
    }

}