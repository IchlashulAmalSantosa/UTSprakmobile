package lat.pam.utsproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // Ambil data dari Intent
        val foodName = intent.getStringExtra("FOOD_NAME") ?: "N/A"
        val servings = intent.getStringExtra("SERVINGS") ?: "N/A"
        val orderingName = intent.getStringExtra("ORDERING_NAME") ?: "N/A"
        val notes = intent.getStringExtra("NOTES") ?: "N/A"

        // Tampilkan data pada TextView
        val tvFoodName: TextView = findViewById(R.id.tvFoodName)
        val tvServings: TextView = findViewById(R.id.tvServings)
        val tvOrderingName: TextView = findViewById(R.id.tvOrderingName)
        val tvNotes: TextView = findViewById(R.id.tvNotes)

        tvFoodName.text = "Food Name: $foodName"
        tvServings.text = "Number of Servings: $servings"
        tvOrderingName.text = "Ordering Name: $orderingName"
        tvNotes.text = "Additional Notes: $notes"


        val backToMenuButton: Button = findViewById(R.id.backtoMenu)
        backToMenuButton.setOnClickListener {

            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish()
            }
        }
}