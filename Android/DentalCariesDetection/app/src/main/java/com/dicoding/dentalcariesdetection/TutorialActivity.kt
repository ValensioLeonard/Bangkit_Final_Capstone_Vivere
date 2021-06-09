package com.dicoding.dentalcariesdetection

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_tutorial.*

class TutorialActivity : AppCompatActivity() {
    private var imgUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        btnTutorialContinue.setOnClickListener{
            startImagePicker()
        }
    }

    private fun pictSelectionIntent() {
        val moveIntent = Intent(this, PictSelection::class.java)
        moveIntent.putExtra("imageUri", imgUri)
        startActivity(moveIntent)
    }

    private fun startImagePicker() {
        ImagePicker.with(this)
            .galleryMimeTypes(arrayOf("image/*"))
            .setImageProviderInterceptor { imageProvider -> //Intercept ImageProvider
                Log.d("ImagePicker", "Selected ImageProvider: "+imageProvider.name)
            }
            .crop()
            .compress(1024)
            .start()
    }

    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val uri: Uri = data?.data!!
            imgUri = uri
            pictSelectionIntent()
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}




