package com.thoughtworks.android.view.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.thoughtworks.android.R
import com.thoughtworks.android.model.signup.SignUp
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var signUp: Button

    val signUpViewModel: SignUpViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        signUp = findViewById(R.id.signUp)
    }

    override fun onResume() {
        super.onResume()

        signUp.setOnClickListener {
            val signup = SignUp(firstName.text.toString(), lastName.text.toString(), email.text.toString(), password.text.toString())

            Toast.makeText(this, "${signup.firstName} - ${signup.lastName}", Toast.LENGTH_LONG).show()

            signUpViewModel.signUp(signup)
        }
    }
}
