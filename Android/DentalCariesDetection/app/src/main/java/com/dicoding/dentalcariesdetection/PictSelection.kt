package com.dicoding.dentalcariesdetection

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import retrofit2.*
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_pict_selection.*
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class PictSelection : AppCompatActivity() {
    private lateinit var imageInput : ImageView
    private var imageUri : Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pict_selection)

        imageUri = intent.getParcelableExtra("imageUri")
        imageInput = findViewById(R.id.img_input)
        imageInput.setImageURI(imageUri)

        btnRetake.setOnClickListener {
            startImagePicker()
        }

        btnContinueResult.setOnClickListener{
            postImageToApi()
        }
    }

    private fun postImageToApi() {
        val file = imageUri?.path
        val requestFile: RequestBody = file.toString().toRequestBody("multipart/form-data".toMediaTypeOrNull())
        val body: MultipartBody.Part = MultipartBody.Part.createFormData("file", file, requestFile)

        val client = ApiConfig.getApiService().postImage(body)
        client.enqueue(object : Callback<PostImageResponse> {
            override fun onResponse(call: Call<PostImageResponse>, response: Response<PostImageResponse>) {
                if (response.isSuccessful) {
                    if (response.body()?.message == "Gigi Karies."){
                        badResultIntent()
                    } else {
                        goodResultIntent()
                    }
                } else {
                    Log.e(TAG, "Already response but fail to post: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<PostImageResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    private fun badResultIntent() {
        val badResultIntent = Intent(this, BadResultActivity::class.java)
        startActivity(badResultIntent)
    }

    private fun goodResultIntent() {
        val goodResultIntent = Intent(this, GoodResultActivity::class.java)
        startActivity(goodResultIntent)
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
        if (resultCode == Activity.RESULT_OK){
            val uri : Uri = data?.data!!
            imageUri = uri
            imageInput.setImageURI(imageUri)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}