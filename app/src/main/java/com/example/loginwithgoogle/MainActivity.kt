package com.example.loginwithgoogle

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        Handler().postDelayed({
            if (user !=null){
                val dashboardActivity = Intent(this, DashboardActivity::class.java)
                startActivity(dashboardActivity)
            }else{
                val signInActivity = Intent (this,SignInActivity::class.java)
                startActivity(signInActivity)
            }
        }, 2000)
    }
}