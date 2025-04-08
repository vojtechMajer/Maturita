import java.sql.*;

public class DbStudents {
    private static Connection connection = null;
    private static final String databaseName = "spojenijava";
    private static final String url = "jdbc:mysql://localhost/"+databaseName;
    private static final String username = "root";
    private static final String pasw = "";

    static void getStudentById(int id) throws SQLException {
        connection = DriverManager.getConnection(url, username, pasw);
        PreparedStatement st = connection.prepareStatement("select * from studenti where id = ?");
        st.setInt(1, id);
        ResultSet result = st.executeQuery();
        result.next();
        System.out.println("Id: " + result.getInt(1) + "\n" +
                           "Jmeno: " + result.getString(2) + "\n" +
                           "Prijmeni: "+ result.getString(3) + "\n" +
                           "Vek: " + result.getInt(4) + "\n-----------\n");
        connection.close();
    }

    static void getAllStudents() throws SQLException {
        connection = DriverManager.getConnection(url,username,pasw);
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery("select * from studenti");
        while(result.next())
            System.out.println("Id: " + result.getInt(1) + "\n" +
                    "Jmeno: " + result.getString(2) + "\n" +
                    "Prijmeni: "+ result.getString(3) + "\n" +
                    "Vek: " + result.getInt(4) + "\n-----------\n");
        connection.close();

    }
    static void deleteStudentById(int id) throws SQLException {
        connection = DriverManager.getConnection(url,username,pasw);
        Statement st = connection.createStatement();
        int status = st.executeUpdate("delete from studenti where id = " + id);
        connection.close();
    }
    static void insertStudent(String firstName, String lastName, int age) throws SQLException {
        connection = DriverManager.getConnection(url, username, pasw);
        PreparedStatement st = connection.prepareStatement("insert into studenti (jmeno, prijmeni, vek) values (?, ?, ?);");
        st.setString(1, firstName);
        st.setString(2, lastName);
        st.setInt(3, age);
        int status = st.executeUpdate();
        if(status != 1){
            System.out.println("Insert failed");
        }
        System.out.println("Inserted successfully");
        connection.close();
    }

    static void updateStudentById(int id, String firstName, String lastName, int age) throws SQLException {
        connection = DriverManager.getConnection(url,username,pasw);
        PreparedStatement st = connection.prepareStatement("update studenti set jmeno = ?, prijmeni = ?, vek = ? where id = ?");
        st.setString(1, firstName);
        st.setString(2, lastName);
        st.setInt(3, age);
        st.setInt(4, id);
        int status = st.executeUpdate();
        if(status != 1){
            System.out.println("Update failed");
        }
        System.out.println("Update successfully");
        connection.close();
    }
}
