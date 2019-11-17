package `in`.squrlabs.koltin_koin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val i = Intent().setClassName(BuildConfig.APPLICATION_ID, "in.squrlabs.list.ListActivity")
        finish()
        startActivity(i)
    }
}