package garcia.roberto.examen2_garciaroberto

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ContactAdapter(
    private val context: Context,
    private val contacts: List<Contact>

) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return contacts.size
    }

    override fun getItem(position: Int): Any? {
        return contacts[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {

        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.contact_layout, parent, false)
            viewHolder = ViewHolder()
            viewHolder.image = view.findViewById(R.id.image_contact)
            viewHolder.name = view.findViewById(R.id.name_contact)
            viewHolder.company = view.findViewById(R.id.company_contact)
            viewHolder.deleteContact = view.findViewById(R.id.delete_contact)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val currentContact = contacts[position]
        viewHolder.name.text = currentContact.name + " " + currentContact.lastname
        viewHolder.company.text = currentContact.company
        viewHolder.image.background.setTint(currentContact.image)

        view.setOnClickListener {
            val intent = Intent(context, ContactDetailActivity::class.java).apply {
                putExtra("image", currentContact.image)
                putExtra("name", currentContact.name)
                putExtra("lastname", currentContact.lastname)
                putExtra("company", currentContact.company)
                putExtra("email", currentContact.email)
                putExtra("phone", currentContact.phone)
            }
            context.startActivity(intent)
        }

        viewHolder.deleteContact.setOnClickListener {
            ContactHandler.removeContact(currentContact)
            Toast.makeText(context, "Contact: ${currentContact.name} deleted", Toast.LENGTH_SHORT).show()
            notifyDataSetChanged()
        }

        return view
    }

    private class ViewHolder {
        lateinit var image: ImageView
        lateinit var name: TextView
        lateinit var company: TextView
        lateinit var deleteContact: ImageView
    }

}