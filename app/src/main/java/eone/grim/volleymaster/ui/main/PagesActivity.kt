package eone.grim.volleymaster.ui.main

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.ActivityPagesBinding

class PagesActivity : AppCompatActivity() {

    private val binding: ActivityPagesBinding by lazy {
        ActivityPagesBinding.inflate(layoutInflater)
    }
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.psv.id) as NavHostFragment
        val navController = navHostFragment.navController

        if (isCollectingPlayerStatsFinished()) {
            navController.navigate(R.id.pagesControllerFragment)
        }


    }
    private fun isCollectingPlayerStatsFinished():Boolean {
        val sharedPref = getSharedPreferences("collectingPlayerStats", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }
}