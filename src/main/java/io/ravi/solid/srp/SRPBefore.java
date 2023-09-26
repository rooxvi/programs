package io.ravi.solid.srp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SRPBefore {
}

class Employee{
    private Integer id;
    private String name;
    private Double salary;
    private Connection connection;

    public Double calculateSalary(){
        // Calculate salary
        return 0d;
    }

    public void save() throws SQLException {
        this.connection = DriverManager.getConnection("");
        Statement statement = this.connection.createStatement();
        String sql = "Select * from Employee";
        // Code
    }
}
