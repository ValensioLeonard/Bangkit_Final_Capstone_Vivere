package com.dicoding.dentalcariesdetection

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.github.dhaval2404.imagepicker.ImagePicker

class PictSelection : AppCompatActivity(), View.OnClickListener {
    lateinit var imageInput : ImageView

    companion object{
        const val REQUEST_CAMERA = 101
        const val REQUEST_GALLERY = 102
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pict_selection)

        val buttonCamera : Button = findViewById(R.id.btn_camera)
        buttonCamera.setOnClickListener(this)

        val buttonGallery : Button = findViewById(R.id.btn_gallery)
        buttonGallery.setOnClickListener(this)

        imageInput = findViewById(R.id.img_input)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_camera -> {
                openCamera()
            }
            R.id.btn_gallery -> {
                openGallery()
            }
        }
    }

    private fun openGallery() {
        ImagePicker.with(this)
            .galleryOnly()
            .crop()
            .start(REQUEST_GALLERY)
    }

    private fun openCamera() {
        ImagePicker.with(this)
            .cameraOnly()
            .crop()
            .start(REQUEST_CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == REQUEST_CAMERA){
                imageInput.setImageURI(data!!.data)
            }
            else if (requestCode == REQUEST_GALLERY){
                imageInput.setImageURI(data!!.data)
            }
        }
    }
}