
import  java.sql.*;
public class DatabaseConnection {
public  static  Connection getConnection(){
    final  String DB_SERVER="localhost";
    final  String PORT="3306";
    final  String DB_NAME="addressbook";
    final  String DB_URL="jdbc:mysql://"+DB_SERVER+":"+PORT+"/"+ DB_NAME;
    final  String USER="root";
    final  String PASS="";

    try{
        Connection conn=DriverManager.getConnection(DB_URL,USER, PASS);
        return conn;
    }
    catch (Exception e){
        System.out.println("DataBase is not Connect");
        e.printStackTrace();
    }
    return  null;
}
}
