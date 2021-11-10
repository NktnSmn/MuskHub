package nktn.smn.muskhub.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import nktn.smn.muskhub.main.api.MainScreenFactory

class MainScreen : AppCompatActivity() {

    companion object : MainScreenFactory {
        override fun createMainScreenIntent(context: Context): Intent = Intent(context, MainScreen::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)
        findViewById<View>(R.id.backBtn).setOnClickListener { onBackPressed() }
    }
}