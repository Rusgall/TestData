package ru.idigital.fastgate.qa;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.TestException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.befree.qa.ibs.tools.util.steps.BaseSteps;
import ru.idigital.fastgate.qa.sql.*;

import java.sql.SQLException;

import static ru.idigital.fastgate.qa.sql.SqlProvider.oracle;
import static ru.idigital.fastgate.qa.sql.SqlProvider.postgresql;

public class BaseTestData extends BaseSteps{
    protected SqlProvider provider;
    protected static SqlData data;
    protected static String user, pass, host;

    @Parameters({"typeDB", "host", "user", "pass"})
    @BeforeSuite
    public void init(@Optional("") String typeDB, @Optional("") String host,
                     @Optional("") String user, @Optional("") String pass) throws ClassNotFoundException, SQLException, ConfigurationException {

        if (typeDB.equals("") || host.equals("") || user.equals("") || pass.equals("")) {
            throw new TestException("One or more parameter is empty. Please set: typeDB, host, user, pass");
        }

        if (typeDB.equals("${typeDB}") || host.equals("${host}") || user.equals("${user}") || pass.equals("${pass}")) {
            throw new TestException("One or more parameter is not set. Please set: typeDB, host, user, pass");
        }

        if (!(typeDB.equals(oracle.toString()) || typeDB.equals(postgresql.toString()))) {
            throw new TestException("typeDB is not equals " + oracle + " or " + postgresql);
        }

        provider = SqlProvider.valueOf(typeDB);
        this.user = user;
        this.pass = pass;

        switch (provider){
            case oracle:
                this.host = "jdbc:oracle:thin:@" + host;
                Class.forName ("oracle.jdbc.OracleDriver");
                data = new SqlDataOracle(host, user, pass);
                break;
            case postgresql:
                this.host = "jdbc:postgresql://" + host;
                Class.forName("org.postgresql.Driver");
                data = new SqlDataPG(host, user, pass);
                break;
        }

        String propertiesName = "fastgate." + typeDB;
        initProperties(propertiesName + ".properties");

        initDBComponents(propertiesName);
    }

    private void initProperties(String propertiesName) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration(propertiesName);
        config.setProperty("hibernate.connection.url", host);
        config.setProperty("hibernate.connection.username", user);
        config.setProperty("hibernate.connection.password", pass);
        config.save();
    }
}
