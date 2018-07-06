package com.wwwhackcom.config.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import javax.annotation.Generated;

@Configuration
@ConfigurationProperties(prefix="com.wwwhackcom")
public class DBConfig {

    private String dbHost;

    private int dbPort;

    private String dbUser;

    private String dbPassword;

    private String dbName;

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost.trim();
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser.trim();
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword.trim();
    }

    public void setDbName(String dbName) {
        this.dbName = dbName.trim();
    }

    public String getDBHost() {
        return dbHost;
    }

    public int getDBPort() {
        return dbPort;
    }

    public String getDBUser() {
        return dbUser;
    }

    public String getDBPassword() {
        return dbPassword;
    }

    public String getDBName() {
        return dbName;
    }

}
