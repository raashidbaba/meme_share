package com.example.memeshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoadMeme()
    }
fun LoadMeme(){
    // Instantiate the RequestQueue.
    val queue = Volley.newRequestQueue(this)
    val url = "https://meme-api.herokuapp.com/gimme"

// Request a string response from the provided URL.

    val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                val url = response.getString("url")
                Glide.with(this).load(url).into(imageView)
            },
/*    val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url,null
            Response.Listener{ response ->
val url = response.getString("url")
            },*/
            Response.ErrorListener {
                Toast.makeText(this,"something went wrong",Toast.LENGTH_LONG).show()
            })

// Add the request to the RequestQueue.
    queue.add(jsonObjectRequest)
}
    fun shareMeme(view: View) {}

    fun nextMeme(view: View) {}
}