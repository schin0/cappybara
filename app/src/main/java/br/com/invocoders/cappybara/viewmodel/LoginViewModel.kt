package br.com.invocoders.cappybara.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth

    fun signInWithGoogleCredential(credential: AuthCredential, home:() -> Unit)
    = viewModelScope.launch {
        try {
            auth.signInWithCredential(credential)
                .addOnCompleteListener{task->
                    if (task.isSuccessful) {
                        Log.d("Autenticacao", "Logado")
                        home()
                    }
                }
                .addOnFailureListener{
                    Log.d("Autenticacao", "Falha ao logar")
                }
        }
        catch (ex: Exception) {
            Log.d("Autenticacao", "Falha ao logar com Google"+
                    ex.localizedMessage
            )

        }
    }

}