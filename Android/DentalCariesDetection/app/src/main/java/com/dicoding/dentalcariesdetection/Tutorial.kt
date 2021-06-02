package com.dicoding.dentalcariesdetection

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Tutorial : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        val btnTutorialContinue : Button = findViewById(R.id.btn_continue)
        btnTutorialContinue.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_continue -> {
                val moveIntent = Intent(this, PictSelection::class.java)
                startActivity(moveIntent)
            }
        }
    }
}



