package eone.grim.volleymaster.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import eone.grim.volleymaster.databinding.ActivitySignInBinding
import eone.grim.volleymaster.ui.home.PagesActivity

class LoginActivity : AppCompatActivity() {

    private val binding : ActivitySignInBinding by lazy {
        ActivitySignInBinding.inflate(layoutInflater)
    }
    private lateinit var auth : FirebaseAuth
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        login()
    }

    private fun storeInRoom() {
        //TODO Implement logic of storing UserData in Room
    }

    private fun login() {


        val users = db.collection("USERS")
        binding.login.setOnClickListener {
            var username = binding.usernameEnter.text.toString()
            var password = binding.passwordEnter.text.toString()
            users.whereEqualTo("email", username).get().addOnSuccessListener { emailUser ->
                if (emailUser.isEmpty) {
                    users.whereEqualTo("username", username).get()
                        .addOnSuccessListener { usernameUsers ->
                            if (usernameUsers.isEmpty) {
                                //TODO Handle it with UI (Show state not found user with this username)
                                Toast.makeText(
                                    this,
                                    "USER WITH ${username} NOT FOUND",
                                    Toast.LENGTH_LONG
                                ).show()
                            } else {
                                for (usernameUser in usernameUsers) {
                                    val email:String = usernameUser.data["email"].toString()
                                    authenticate(email, password)
                                }

                            }
                        }
                } else {
                    val email = username
                    authenticate(email,password)
                }
            }
        }

    }

    private fun authenticate(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                startActivity(Intent(this@LoginActivity, PagesActivity::class.java))
                finish()
            } else {
                //TODO Handle it with UI (Show state not found user with this username)
                Toast.makeText(
                    this,
                    "UNCORRECTED PASSWORD",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}