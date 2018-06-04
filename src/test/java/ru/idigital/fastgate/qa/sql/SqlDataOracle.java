package ru.idigital.fastgate.qa.sql;

import io.qameta.allure.Step;

import java.sql.SQLException;

public class SqlDataOracle extends SqlDataImpl implements SqlData {

    public SqlDataOracle(String host, String user, String pass) throws SQLException {
        super(host, user, pass);
    }

    public void init() {

    }

    @Override
    public String getInsertConnection() {
        return "INSERT INTO CONNECTIONS " +
                "(id,name, description, isdefault, creation_dt, modification_dt, owner_id, dep_id) " +
                "VALUES(?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ?, ?)";
    }

    @Override
    public String getInsertOutboundChannel() {
        return "INSERT INTO OUTBOUND_CHANNELS " +
                "(id, name, prefix, comments, protocol_name, creation_dt, modification_dt, owner_id, dep_id, start_hour, stop_hour, spam_ttl) " +
                "VALUES(?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getInsertSender() {
        return "INSERT INTO INFO_SN " +
                "(service_number, creation_dt, modification_dt, owner_id, dep_id, contenttypes) " +
                "VALUES(?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ?, ?, ?)";
    }

    @Override
    public String getInsertGrants() {
        return "INSERT INTO ROLE_GRANTS " +
                "(id, grant_name, filter, role_id) " +
                "VALUES ((SELECT MAX(id)+1 FROM ROLE_GRANTS), ?, '{}', ?)";
    }

    @Override
    public String getInsertRole() {
        return "INSERT INTO USER_ROLE " +
                "(id, name, description, data, admin, deleted, owner_id, dep_id) VALUES " +
                "((SELECT MAX(id)+1 FROM USER_ROLE), ?, ?, '', ?, ?, ?, ?)";
    }
}
