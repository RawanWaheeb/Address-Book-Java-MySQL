

import  java.util.ArrayList;
import  java.util.List;
import  java.sql.*;
public class ContactDAO {


    public void  addContact(ContactPerson person){
        String sql = "INSERT INTO contact (name, nick_name, address, home_phone, work_phone, cell_phone, email, birthday, web_site, profession) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,person.getName());
            pstmt.setString(2,person.getNickName());
            pstmt.setString(3,person.getAddress());
            pstmt.setString(4,person.getHomePhone());
            pstmt.setString(5,person.getWorkPhone());
            pstmt.setString(6,person.getCellPhone());
            pstmt.setString(7,person.getEmail());
            pstmt.setString(8,person.getBirthday());
            pstmt.setString(9,person.getWebSite());
            pstmt.setString(10,person.getProfession());


            pstmt.executeUpdate();
            System.out.println("Contact " + person.getName() + " added successfully! ");

        } catch (SQLException e) {
            System.out.println("Error adding contact: " + e.getMessage());
        }
        }







public List<ContactPerson> getContacts() {
    List<ContactPerson> list = new ArrayList<>();
    String sql = "SELECT * FROM contact";


    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            ContactPerson p = new ContactPerson();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setNickName(rs.getString("nick_name"));
            p.setAddress(rs.getString("address"));
            p.setHomePhone(rs.getString("home_phone"));
            p.setWorkPhone(rs.getString("work_phone"));
            p.setCellPhone(rs.getString("cell_phone"));
            p.setEmail(rs.getString("email"));
            p.setBirthday(rs.getString("birthday"));
            p.setWebSite(rs.getString("web_site"));
            p.setProfession(rs.getString("profession"));

            list.add(p);
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving data: " + e.getMessage());
    }
    return list;
}




    public List<ContactPerson> getContactByName(String name) {
        List<ContactPerson> list = new ArrayList<>();

        String sql = "SELECT * FROM contact WHERE name LIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setString(1, "%" + name + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ContactPerson p = new ContactPerson();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("name"));
                    p.setNickName(rs.getString("nick_name"));
                    p.setAddress(rs.getString("address"));
                    p.setHomePhone(rs.getString("home_phone"));
                    p.setWorkPhone(rs.getString("work_phone"));
                    p.setCellPhone(rs.getString("cell_phone"));
                    p.setEmail(rs.getString("email"));
                    p.setBirthday(rs.getString("birthday"));
                    p.setWebSite(rs.getString("web_site"));
                    p.setProfession(rs.getString("profession"));


                    list.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching for contact: " + e.getMessage());
        }
        return list;
    }



    public void updateContact(ContactPerson person) {

        String sql = "UPDATE contact SET name=?, nick_name=?, address=?, home_phone=?, " +
                "work_phone=?, cell_phone=?, email=?, birthday=?, web_site=?, " +
                "profession=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getNickName());
            pstmt.setString(3, person.getAddress());
            pstmt.setString(4, person.getHomePhone());
            pstmt.setString(5, person.getWorkPhone());
            pstmt.setString(6, person.getCellPhone());
            pstmt.setString(7, person.getEmail());
            pstmt.setString(8, person.getBirthday());
            pstmt.setString(9, person.getWebSite());
            pstmt.setString(10, person.getProfession());
            pstmt.setInt(11, person.getId()); // الـ ID اللي هنعدل على أساسه

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Contact " + person.getName() + " updated successfully! ");
            }
        } catch (SQLException e) {
            System.out.println("Error updating contact: " + e.getMessage());
        }
    }



    public void deleteContact(int id) {
        String sql = "DELETE FROM contact WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Contact with ID " + id + " deleted successfully! ");
            } else {
                System.out.println("No contact found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting contact: " + e.getMessage());
        }
    }





}






