package lat.pam.utsproject

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    private lateinit var regUsername: EditText
    private lateinit var regPassword: EditText
    private lateinit var registerButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        // Initialize UI elements
        regUsername = findViewById(R.id.regUsername)
        regPassword = findViewById(R.id.regPassword)
        registerButton = findViewById(R.id.RegisterBtn)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)

        // Set on click listener for the register button
        registerButton.setOnClickListener {
            registerUser()
        }

        // Set up edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun registerUser() {
        val username = regUsername.text.toString()
        val password = regPassword.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()) {
            // Save new username and password in SharedPreferences
            with(sharedPreferences.edit()) {
                putString("username", username)
                putString("password", password)
                apply() // Save the changes
            }

            Toast.makeText(this, "User registered successfully!", Toast.LENGTH_SHORT).show()
            finish() // Close the RegisterActivity and return to the previous one
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
        }
    }
}
