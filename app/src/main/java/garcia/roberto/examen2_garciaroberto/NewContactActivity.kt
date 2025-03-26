package garcia.roberto.examen2_garciaroberto

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class NewContactActivity : AppCompatActivity() {
    private lateinit var txtFirstName: TextView
    private lateinit var txtLastname: TextView
    private lateinit var txtCompany: TextView
    private lateinit var txtEmail: TextView
    private lateinit var txtPhone: TextView
    private lateinit var btnSaveContact: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtFirstName = findViewById(R.id.input_first_name_new_contact)
        txtLastname = findViewById(R.id.input_last_name_new_contact)
        txtCompany = findViewById(R.id.input_company_new_contact)
        txtEmail = findViewById(R.id.input_email_new_contact)
        txtPhone = findViewById(R.id.input_phone_new_contact)
        btnSaveContact = findViewById(R.id.btn_save_new_contact)


        btnSaveContact.setOnClickListener {
            saveContact()
        }
    }

    private fun saveContact() {
        val image = generateRandomColor()
        val firstName = txtFirstName.text.toString()
        val lastName = txtLastname.text.toString()
        val company = txtCompany.text.toString()
        val email = txtEmail.text.toString()
        val phone = txtPhone.text.toString()

        if (!validateContact(firstName, lastName, company, email, phone)) return

        val contact = Contact(image, firstName, lastName, company, email, phone)
        ContactHandler.addContact(contact)
        Toast.makeText(this, "Contact: $firstName saved", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun generateRandomColor(): Int {
        val red = Random.nextInt(256)
        val green = Random.nextInt(256)
        val blue = Random.nextInt(256)

        return Color.rgb(red, green, blue)
    }

    private fun validateContact(
        firstName: String,
        lastName: String,
        company: String,
        email: String,
        phone: String
    ): Boolean {
        if (firstName.isEmpty() || lastName.isEmpty() || company.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}