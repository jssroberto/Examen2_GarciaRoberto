package garcia.roberto.examen2_garciaroberto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContactDetailActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var txtName: TextView
    private lateinit var txtCompany: TextView
    private lateinit var txtEmail: TextView
    private lateinit var txtPhone: TextView
    private lateinit var btnCallContact: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageView = findViewById(R.id.image_contact_detail)
        txtName = findViewById(R.id.name_contact_detail)
        txtCompany = findViewById(R.id.company_contact_detail)
        txtEmail = findViewById(R.id.email_contact_detail)
        txtPhone = findViewById(R.id.phone_contact_detail)
        btnCallContact = findViewById(R.id.btn_call_contact_detail)

        val image = intent.getIntExtra("image", 0)
        val name = intent.getStringExtra("name") ?: ""
        val lastname = intent.getStringExtra("lastname") ?: ""
        val company = intent.getStringExtra("company") ?: ""
        val email = intent.getStringExtra("email") ?: ""
        val phone = intent.getStringExtra("phone") ?: ""

        val contact = Contact(image, name, lastname, company, email, phone)

        imageView.background.setTint(image)
        txtName.text = contact.name + " " + contact.lastname
        txtCompany.text = contact.company
        txtEmail.text = contact.email
        txtPhone.text = contact.phone
        btnCallContact.text = "Call ${contact.name}"

        btnCallContact.setOnClickListener {
            val intent = Intent(this, FakeCallActivity::class.java)
            intent.putExtra("image", contact.image)
            intent.putExtra("name", contact.name)
            intent.putExtra("lastname", contact.lastname)
            intent.putExtra("phone", contact.phone)
            startActivity(intent)
        }

    }
}