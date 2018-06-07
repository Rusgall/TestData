package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.idigital.fastgate.qa.BaseTestData;
import ru.befree.qa.ibs.tools.util.constants.Constants;
import ru.idigital.fastgate.qa.data.utils.RoleGrants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Role extends BaseTestData {

    @Test(description = "Роль")
    public void insertRole() throws SQLException {
        try(java.sql.Connection connection = DriverManager.getConnection(host, user, pass);
            PreparedStatement statement = connection.prepareStatement(data.getInsertRole())) {

            statement.setString(1, Constants.DEFAULT_ROLE);
            statement.setString(2, "Description");
            statement.setString(3, "F");
            statement.setString(4, "F");
            statement.setInt(5, 1);
            statement.setInt(6, 0);
            statement.executeUpdate();
        }

        try(Connection connection = DriverManager.getConnection(host, user, pass)) {
            for(String grant : RoleGrants.getDefaultGrants()){
                try(PreparedStatement statement = connection.prepareStatement(data.getInsertGrants())){
                    statement.setString(1, grant);
                    statement.setInt(2, 2);
                    statement.executeUpdate();
                }
            }
        }
    }
}
