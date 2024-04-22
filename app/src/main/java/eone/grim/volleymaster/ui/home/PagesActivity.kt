package eone.grim.volleymaster.ui.home

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.ActivityHomeBinding

class PagesActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isCollectingPlayerStatsFinished()) {
            setContentView(
                R.layout.fragment_pages_controller
            )
        }
        else {
            setContentView(binding.root)
        }


    }
    private fun isCollectingPlayerStatsFinished():Boolean {
        val sharedPref = getSharedPreferences("collectingPlayerStats", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }
}