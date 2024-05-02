package eone.grim.volleymaster.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.ActivityPagesBinding
import eone.grim.volleymaster.ui.main.playerstats.collecting.OnCollectingFinishedListener
import eone.grim.volleymaster.ui.main.playerstats.collecting.ViewPagerFragment

class PagesActivity : AppCompatActivity(), OnCollectingFinishedListener {

    private val binding: ActivityPagesBinding by lazy {
        ActivityPagesBinding.inflate(layoutInflater)
    }
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(binding.psv.id) as NavHostFragment
        val navController = navHostFragment.navController

        if (isCollectingPlayerStatsFinished()) {
            navController.navigate(R.id.pagesControllerFragment)
        }


    }
    private fun isCollectingPlayerStatsFinished():Boolean {
        val sharedPref = getSharedPreferences("collectingPlayerStats", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }

    override fun onCollectingFinished() {
        val currentFragment = navHostFragment.childFragmentManager.fragments.firstOrNull() as ViewPagerFragment
        currentFragment.saveToFirebase()
    }
}