package com.example.hellotoast

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    private var mCount = 0
    private val model: NameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonberita = findViewById<Button>(R.id.button_berita)

        // Restore or initialize mCount with ViewModel value
        model.currentName.value?.let {
            mCount = it
        } ?: run {
            model.currentName.value = mCount
        }

        // Create the observer which updates the UI.
        val nameObserver = Observer<Int> { newName ->
            // Update the UI, in this case, a TextView.
            mShowCount.text = newName.toString()
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)


        buttonCountUp.setOnClickListener(View.OnClickListener {
            mCount = mCount + 1
            if (mShowCount != null)
                //mShowCount.text = mCount.toString()
                model.currentName.setValue(mCount)
        })
        buttonToast.setOnClickListener(View.OnClickListener {
            val tulisan: String = mShowCount?.text.toString()
            val toast: Toast = Toast.makeText(this, "Angka yang dimunculkan "+tulisan, Toast.LENGTH_LONG)
            toast.show()
        })
        buttonberita.setOnClickListener({
            val intent = Intent(this, MainActivity2::class.java)


            startActivity(intent)
        })
    }
}
