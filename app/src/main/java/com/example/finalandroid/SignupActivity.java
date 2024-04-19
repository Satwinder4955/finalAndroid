import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

private lateinit var mAuth: FirebaseAuth

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        mAuth = FirebaseAuth.getInstance()

        // Set onClickListener for signup button
        signup_button.setOnClickListener {
        val email = email_edit_text.text.toString()
        val password = password_edit_text.text.toString()
        signUpUser(email, password)
        }
        }

private fun signUpUser(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(this) { task ->
        if (task.isSuccessful) {
        // Signup successful, navigate to Dashboard
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
        } else {
        // If sign up fails, display a message to the user.
        Toast.makeText(
        this, "Authentication failed.",
        Toast.LENGTH_SHORT
        ).show()
        }
        }
        }
        }
