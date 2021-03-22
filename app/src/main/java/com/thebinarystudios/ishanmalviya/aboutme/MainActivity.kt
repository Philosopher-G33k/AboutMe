package com.thebinarystudios.ishanmalviya.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.content.Context
import androidx.databinding.DataBindingUtil
import com.thebinarystudios.ishanmalviya.aboutme.databinding.ActivityMain1Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain1Binding

    private val myName: MyName = MyName(name = "Ishan Malviya")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main1)
        binding.myName = myName

        binding.done.setOnClickListener {
            doneButtonClicked(it)
        }

    }

    fun doneButtonClicked(view: View) {
        var nickname_text = findViewById<TextView>(R.id.nickname_text)
        var nickname_edit = findViewById<TextView>(R.id.nickname_edit)

        binding.apply {
            myName?.nickname = nickname_edit.text.toString()
            invalidateAll()
            nickname_edit.visibility = View.GONE
            view.visibility = View.GONE
            nickname_text.visibility = View.VISIBLE
        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}