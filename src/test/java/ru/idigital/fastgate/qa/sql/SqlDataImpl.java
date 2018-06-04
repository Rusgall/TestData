package ru.idigital.fastgate.qa.sql;

import java.sql.SQLException;

public abstract class SqlDataImpl {
    protected String host, user, pass;
    protected int ownerId;

    public SqlDataImpl(String host, String user, String pass) throws SQLException {
        this.host = host;
        this.user = user;
        this.pass = pass;

        this.init();
    }

    public abstract void init() throws SQLException;
}
