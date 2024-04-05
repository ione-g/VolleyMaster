package eone.grim.volleymaster

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import eone.grim.volleymaster.databinding.ActivityRoadMapBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityRoadMapBinding by lazy {
        ActivityRoadMapBinding.inflate(layoutInflater)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)



    }


}

