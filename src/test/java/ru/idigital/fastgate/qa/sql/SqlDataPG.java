package ru.idigital.fastgate.qa.sql;

import io.qameta.allure.Step;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDataPG extends SqlDataImpl implements SqlData {

    public SqlDataPG(String host, String user, String pass) throws SQLException {
        super(host, user, pass);
    }

    public void init() throws SQLException {

    }

    public String getInsertConnection() {
        return "insert into connections " +
                "(id,name, description, isdefault, creation_dt, modification_dt, owner_id, dep_id) " +
                "values(?, ?, ?, ?, now(), now(), ?, ?)";
    }

    @Override
    public String getInsertOutboundChannel() {
        return "insert into outbound_channels " +
                "(id, name, prefix, comments, protocol_name, creation_dt, modification_dt, owner_id, dep_id, start_hour, stop_hour, spam_ttl) " +
                "values(?, ?, ?, ?, ?, now(), now(), ?, ?, ?, ?, ?)";
    }

    @Override
    public String getInsertSender() {
        return "insert into info_sn " +
                "(service_number, creation_dt, modification_dt, owner_id, dep_id, contenttypes) " +
                "values(?, now(), now(), ?, ?, ?)";
    }

    @Override
    public String getInsertGrants() {
        return "insert into role_grants " +
                "(id, grant_name, filter, role_id) " +
                "values ((select max(id)+1 from role_grants), ?, '{}', ?)";
    }

    @Override
    public String getInsertRole() {
        return "insert into user_role " +
                "(id, name, description, data, admin, deleted, owner_id, dep_id) values " +
                "((select max(id)+1 from user_role), ?, ?, '', ?, ?, ?, ?)";
    }
}
