package eone.grim.volleymaster.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PlayerViewModel : ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username


    fun fetchUserData() {
        val auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        val userEmail = auth.currentUser?.email.toString()
        db.collection("USERS").document(userEmail).get().addOnSuccessListener { document ->
            _username.value = document["username"] as? String ?: userEmail
        }
    }
}