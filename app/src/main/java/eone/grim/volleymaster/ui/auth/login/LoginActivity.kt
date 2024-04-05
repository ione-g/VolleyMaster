package eone.grim.volleymaster.ui.auth.login

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eone.grim.volleymaster.R
import eone.grim.volleymaster.databinding.ActivitySignInBinding

class LoginActivity : AppCompatActivity() {

    private val binding : ActivitySignInBinding by lazy {
        ActivitySignInBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}