package com.dicoding.dentalcariesdetection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bad_result.*

class GoodResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_good_result)

        btnHome.setOnClickListener{
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
            finish()
        }
        btnTryAgain.setOnClickListener{
            val tryAgainIntent = Intent(this, TutorialActivity::class.java)
            startActivity(tryAgainIntent)
            finish()
        }
    }
}