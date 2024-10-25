package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val foodName = intent.getStringExtra("FOOD_NAME")
        val foodDescription = intent.getStringExtra("FOOD_DESCRIPTION")

        val etServings: EditText = findViewById(R.id.etServings)
        val etName: EditText = findViewById(R.id.etName)
        val etNotes: EditText = findViewById(R.id.etNotes)

        val btnOrder: Button = findViewById(R.id.btnOrder)



        val tvFoodName: TextView = findViewById(R.id.etFoodName)
        tvFoodName.text = foodName


        btnOrder.setOnClickListener {
            val servings = etServings.text.toString()
            val orderingName = etName.text.toString()
            val notes = etNotes.text.toString()


            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("FOOD_NAME", foodName)
                putExtra("SERVINGS", servings)
                putExtra("DESCRIPTION",foodDescription)
                putExtra("ORDERING_NAME", orderingName)
                putExtra("NOTES", notes)
            }
            startActivity(intent)
            }
        }
}