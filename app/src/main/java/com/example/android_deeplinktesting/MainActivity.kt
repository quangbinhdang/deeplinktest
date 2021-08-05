package com.example.android_deeplinktesting

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.dynamiclinks.ktx.*
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = this.findViewById(R.id.button1)
        button2 = this.findViewById(R.id.button2)
        button3 = this.findViewById(R.id.button3)
//        FirebaseApp.initializeApp(this)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(
                button1,
                button2,
                button3,
            )

        for (item in clickableViews) {
            item.setOnClickListener {
                goToLink(it)
            }
        }
    }

    private fun goToLink(view: View){
        val imei = (view as Button).text
        val url = "https://airbikenetwork.page.link?apn=com.terrapages.airbike&link=https%3A%2F%2Fcloudev.terrapages.net%2Fabservice%2Fv2%2Fdeep-linking%2Fredirect%3Fos%3DAndroid%26imei%3D$imei"
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}