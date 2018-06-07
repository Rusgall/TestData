package ru.idigital.fastgate.qa.tests;

import org.testng.annotations.Test;
import ru.idigital.fastgate.qa.BaseTestData;
import ru.befree.qa.ibs.tools.util.constants.Constants;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Departaments extends BaseTestData{

    @Test(description = "Департаменты")
    public void insertDepartament() throws SQLException {
        createDepartment(Constants.DEFAULT_DEPARTAMENT);

        try(java.sql.Connection connection = DriverManager.getConnection(host, user, pass);
            PreparedStatement statement = connection.prepareStatement(data.getInsertRole())) {

            statement.setString(1, "Администратор (" + Constants.DEFAULT_DEPARTAMENT + ")");
            statement.setString(2, "Роль для департамента " + Constants.DEFAULT_DEPARTAMENT);
            statement.setString(3, "F");
            statement.setString(4, "F");
            statement.setInt(5, 1);
            statement.setInt(6, 1);
            statement.executeUpdate();
        }
    }
}
