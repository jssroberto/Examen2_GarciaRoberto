package garcia.roberto.examen2_garciaroberto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnAddNewContact: Button
    private lateinit var listViewContacts: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnAddNewContact = findViewById(R.id.btn_add_new_contact)
        listViewContacts = findViewById(R.id.list_view_contacts)

        btnAddNewContact.setOnClickListener {
            val intent = Intent(this, NewContactActivity::class.java)
            startActivity(intent)
        }

        val contacts = ContactHandler.getContacts()

        listViewContacts.adapter = ContactAdapter(this, contacts)
    }

}