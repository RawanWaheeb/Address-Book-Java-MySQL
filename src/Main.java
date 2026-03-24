import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContactDAO dao = new ContactDAO();

        System.out.println(" --- Starting Address Book System --- \n");

        // 1. ADDING 7 DIVERSE CONTACTS
        System.out.println("Adding 7 new contacts...");
        addSampleData(dao);

        // 2. DISPLAY ALL CONTACTS (To see the initial list)
        System.out.println("\n--- Initial Contacts List ---");
        printAll(dao.getContacts());

        // 3. SEARCHING (Searching for Ghaidaa)
        System.out.println("\n Searching for 'Ghaidaa'...");
        List<ContactPerson> searchResult = dao.getContactByName("Ghaidaa");
        printAll(searchResult);

        // 4. UPDATING (Updating Mariam Mohamed - assuming ID 1)
        System.out.println("\n Updating Mariam Mohamed's details (ID: 1)...");
        ContactPerson updateP = createContact("Mariam Mohamed", "Mimi", "Alexandria", "034455", "036677", "012777888", "mariam.m@email.com", "2002-05-15", "www.mariam-dev.com", "Senior Artist");
        updateP.setId(1); // Targeting the first ID
        dao.updateContact(updateP);

        // 5. DELETING (Deleting ID 5 - Omar)
        System.out.println("\n Attempting to delete contact with ID: 5...");
        dao.deleteContact(5);

        // 6. FINAL LIST (Showing results after Update and Delete)
        System.out.println("\n --- Final Contacts List After Operations ---");
        printAll(dao.getContacts());
    }

    // Helper method to add 7 contacts quickly
    private static void addSampleData(ContactDAO dao) {
        dao.addContact(createContact("Mariam Mohamed", "Mariom", "Aswan", "09711", "09722", "012777", "mariam@mail.com", "2002-02-02", "www.mery.art", "Artist"));
        dao.addContact(createContact("Ghaidaa El-Sayed", "Ghaidaa", "Cairo", "02111", "02222", "010999", "ghaidaa@mail.com", "2001-08-20", "www.ghaidaa.com", "Software Engineer"));
        dao.addContact(createContact("Ahmed Ali", "Hamada", "Mansoura", "05011", "05022", "010111", "ahmed@mail.com", "1995-01-01", "www.ahmed.com", "Java Developer"));
        dao.addContact(createContact("Laila Hassan", "Lulu", "Giza", "02333", "02444", "011222", "laila@mail.com", "1998-05-12", "www.laila.design", "UI Designer"));
        dao.addContact(createContact("Omar Khalid", "Morry", "Alex", "03111", "03222", "012333", "omar@mail.com", "1992-11-20", "www.omar.me", "Civil Engineer"));
        dao.addContact(createContact("Mostafa Mahmoud", "Desha", "Suez", "06211", "06222", "010555", "mostafa@mail.com", "1988-07-22", "www.desha.net", "Teacher"));
        dao.addContact(createContact("Nour El-Din", "Nour", "Port Said", "06611", "06622", "011666", "nour@mail.com", "1999-12-30", "www.nour.com", "Accountant"));
    }

    // Helper to create a person object in one line
    private static ContactPerson createContact(String name, String nick, String addr, String hPh, String wPh, String cPh, String mail, String bday, String web, String prof) {
        ContactPerson p = new ContactPerson();
        p.setName(name); p.setNickName(nick); p.setAddress(addr);
        p.setHomePhone(hPh); p.setWorkPhone(wPh); p.setCellPhone(cPh);
        p.setEmail(mail); p.setBirthday(bday); p.setWebSite(web); p.setProfession(prof);
        return p;
    }

    // Helper to print lists
    private static void printAll(List<ContactPerson> list) {
        if (list.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (ContactPerson p : list) {
                System.out.println("ID: " + p.getId() + " | Name: " + p.getName() + " | Job: " + p.getProfession());
            }
        }
    }
}