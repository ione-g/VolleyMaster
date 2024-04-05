package eone.grim.volleymaster.ui.auth.register

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import eone.grim.volleymaster.databinding.ActivityRegisterBinding
import eone.grim.volleymaster.ui.auth.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private val binding : ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val signIn: TextView = binding.signIn
        signIn.setOnClickListener {
            startActivity(
                Intent(
                    this@RegisterActivity,
                    LoginActivity::class.java
                )
            )
        }


    }
}