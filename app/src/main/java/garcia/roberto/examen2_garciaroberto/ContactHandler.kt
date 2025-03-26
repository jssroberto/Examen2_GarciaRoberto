package garcia.roberto.examen2_garciaroberto

object ContactHandler {
    private val contacts = mutableListOf<Contact>(
        Contact(
            0xFF3F51B5.toInt(),
            "Juan Carlos",
            "González",
            "Softtek",
            "juan.gonzalez@softtek.com",
            "55-1234-5678"
        ),
        Contact(
            0xFF4CAF50.toInt(),
            "María Fernanda",
            "López",
            "Wizeline",
            "maria.lopez@wizeline.com",
            "55-2345-6789"
        ),
        Contact(
            0xFFF44336.toInt(),
            "Carlos Alberto",
            "Martínez",
            "KIO Networks",
            "carlos.martinez@kio.com",
            "55-3456-7890"
        ),
        Contact(
            0xFF9C27B0.toInt(),
            "Luis Miguel",
            "Hernández",
            "IBM",
            "luis.hernandez@ibm.com",
            "55-5678-9012"
        ),
        Contact(
            0xFFFF9800.toInt(),
            "Gabriela",
            "Pérez",
            "Oracle",
            "gabriela.perez@oracle.com",
            "55-6789-0123"
        ),
        Contact(
            0xFF009688.toInt(),
            "José Antonio",
            "García",
            "Microsoft",
            "jose.garcia@microsoft.com",
            "55-7890-1234"
        ),
        Contact(
            0xFFE91E63.toInt(),
            "Sofía",
            "Ramírez",
            "Google",
            "sofia.ramirez@google.com",
            "55-8901-2345"
        ),
        Contact(
            0xFF607D8B.toInt(),
            "Alejandra",
            "Díaz",
            "Infosys",
            "alejandra.diaz@infosys.com",
            "55-0123-4567"
        )

    )

    fun addContact(contact: Contact) {
        contacts.add(contact)
    }

    fun getContacts(): List<Contact> {
        return contacts
    }

    fun removeContact(contact: Contact) {
        contacts.remove(contact)
    }

}