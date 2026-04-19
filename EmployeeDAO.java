package ebook581;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // DB Connection
    static Connection getDBConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Updated driver
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/24wh1a0581",
                    "root",
                    "1234"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 🔹 READ
    public List<Employee> getEmployees() {

        List<Employee> list = new ArrayList<>();

        try {
            Connection con = getDBConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Employee");

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("empid"),
                        rs.getString("name"),
                        rs.getInt("salary"),
                        rs.getString("department")
                ));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
