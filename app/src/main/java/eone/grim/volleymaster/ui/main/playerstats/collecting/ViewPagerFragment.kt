package eone.grim.volleymaster.ui.main.playerstats.collecting

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import eone.grim.volleymaster.R
import eone.grim.volleymaster.data.model.PlayerStats
import eone.grim.volleymaster.data.provider.PlayerStatsProvider
import eone.grim.volleymaster.utils.ViewPagerAdapter


class ViewPagerFragment : Fragment() {


    val fragmentList = arrayListOf<Fragment>(
        PSGenderFragment(),
        PSAgeFragment(),
        PSWeightFragment(),
        PSHeightFragment(),
        PSJumpHeightFragment(),
        PSVolleyLevelFragment(),
        PSGoalFragment()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)



        var adapter = ViewPagerAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)

        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)

        viewPager.adapter = adapter
        viewPager.isUserInputEnabled = false
        return view
    }

    private fun collectPlayerStats(): PlayerStats {
        val playerStats = PlayerStats(null, null, null, null, null, null, null)
        fragmentList.forEach { fragment ->
            if (fragment is PlayerStatsProvider) {
                fragment.provideData(playerStats)
            }
        }
        return playerStats
    }

    fun saveToFirebase() {
        val db = FirebaseFirestore.getInstance()
        val auth = FirebaseAuth.getInstance()

        db.collection("USERS").document(auth.currentUser?.email.toString()).update(collectPlayerStats().toMap()).addOnSuccessListener {
            collectingPlayerStatsFinished()
            Log.d("SUCCESS","URA")

        }.addOnFailureListener { it->
            Log.d("FAILURE", it.message.toString())
        }
    }



    private fun collectingPlayerStatsFinished() {
        val sharedPref = requireActivity().getSharedPreferences("collectingPlayerStats", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }


}