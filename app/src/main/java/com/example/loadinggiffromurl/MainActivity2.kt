package com.example.loadinggiffromurl

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.coroutines.*
import pl.droidsonroids.gif.GifImageView
import java.io.IOException
import java.net.URL

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // url of image
        val imageView = findViewById<GifImageView>(R.id.imageView)
        val urlImage:URL = URL("https://user-images.githubusercontent.com/512439/31472012-f0ca007a-aea0-11e7-882e-2b4ef259a954.gif")
        Glide.with(this).load("https://media.giphy.com/media/MuGSTsh3RbIgBIst4g/giphy.gif").into(imageView);
//        val button = findViewById<Button>(R.id.button)
//
//        button.setOnClickListener {
//            it.isEnabled = false // disable button
//
//            // async task to get bitmap from url
//            val result: Deferred<Bitmap?> = GlobalScope.async {
//                urlImage.toBitmap()
//            }
//
//            GlobalScope.launch(Dispatchers.Main) {
//                // show bitmap on image view when available
//                imageView.setImageBitmap(result.await())
//
//                it.isEnabled = true // enable button
//            }
//        }
    }
}


// extension function to get bitmap from url
fun URL.toBitmap(): Bitmap?{
    return try {
        BitmapFactory.decodeStream(openStream())
    }catch (e: IOException){
        null
    }
}