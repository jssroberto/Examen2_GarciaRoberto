package garcia.roberto.examen2_garciaroberto

import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FakeCallActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var txtName: TextView
    private lateinit var txtPhone: TextView
    private lateinit var txtCalling : TextView
    private lateinit var btnEndCall: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fake_call)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageView = findViewById(R.id.image_contact_call)
        txtName = findViewById(R.id.name_contact_call)
        txtPhone = findViewById(R.id.phone_contact_call)
        txtCalling = findViewById(R.id.txt_calling)
        btnEndCall = findViewById(R.id.btn_end_call)

        val image = intent.getIntExtra("image", 0)
        val name = intent.getStringExtra("name") ?: ""
        val lastname = intent.getStringExtra("lastname") ?: ""
        val phone = intent.getStringExtra("phone") ?: ""

        val contact = Contact(image, name, lastname, "", "", phone)

        imageView.background.setTint(image)
        txtName.text = contact.name + " " + contact.lastname
        txtPhone.text = contact.phone
        btnEndCall.setOnClickListener {
            finish()
        }
    }
}