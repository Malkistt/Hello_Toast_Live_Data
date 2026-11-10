package com.example.hellotoast
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val judul = findViewById<TextView>(R.id.Judul)
        val subjudul = findViewById<TextView>(R.id.Subjudul)
        val konten = findViewById<TextView>(R.id.konten)

    }
}