package eone.grim.volleymaster.ui.auth.register

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import eone.grim.volleymaster.databinding.ActivityRegisterBinding
import eone.grim.volleymaster.ui.auth.login.LoginActivity
import eone.grim.volleymaster.ui.home.PagesActivity

class RegisterActivity : AppCompatActivity() {

    private val binding : ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }
    private lateinit var auth : FirebaseAuth
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        if (isAuthenticated()) {
            startActivity(Intent(this@RegisterActivity,PagesActivity::class.java))
            finish()
        }

        val signIn: TextView = binding.signIn
        signIn.setOnClickListener {
            startActivity(
                Intent(
                    this@RegisterActivity,
                    LoginActivity::class.java
                )
            )
        }

        signUp()
    }

    private fun signUp() {
        binding.register.setOnClickListener {
            if (validateEntries()) {
                val username: String = binding.usernameEnter.text.toString()
                val email: String = binding.emailEnter.text.toString()
                val password: String = binding.passwordEnter.text.toString()
                val userInfo = hashMapOf(
                    "username" to username,
                    "email" to email
                )


                val users = db.collection("USERS")
                val query = users.whereEqualTo("email", email).get().addOnSuccessListener {
                    if (it.isEmpty) {
                        auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    users.document(email).set(userInfo)
                                    startActivity(
                                        Intent(
                                            this@RegisterActivity,
                                            PagesActivity::class.java
                                        )
                                    )
                                    finish()
                                } else {
                                    Toast.makeText(this, "SOMETHING WENT WRONG. TRY AGAIN LATER", Toast.LENGTH_LONG)
                                        .show()
                                }
                            }
                    } else {
                        Toast.makeText(this, "USER ALREADY REGISTERED SIGN IN", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }


    private fun validateEntries (): Boolean {
        //TODO Write validation of entries from activity_register.xml
//        binding.usernameEnter
//        binding.emailEnter
//        binding.passwordEnter
        return true
    }

    private fun isAuthenticated() : Boolean {
        return auth.currentUser != null
    }


}