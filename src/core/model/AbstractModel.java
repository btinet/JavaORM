package core.model;

import core.config.ConfigReader;
import core.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AbstractModel {

    private final DatabaseConfig dbConfig;

    protected Connection connection;

    AbstractModel()
    {
        ConfigReader $reader = new ConfigReader();
        this.dbConfig = new ConfigReader().ConfigReader().getDatabase();
    }

    public Connection getConnection(){

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.dbConfig.getUsername());
        connectionProps.put("password", this.dbConfig.getPassword());

        if (this.dbConfig.getDriver().equals("mysql")) {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:" + this.dbConfig.getDriver() + "://" +
                                this.dbConfig.getHost() +
                                ":" + this.dbConfig.getPort() + "/",
                        connectionProps);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (this.dbConfig.getDriver().equals("derby")) {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:" + this.dbConfig.getDriver() + ":" +
                                this.dbConfig.getDbname() +
                                ";create=true",
                        connectionProps);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Connected to database");
        this.connection = conn;
        return this.connection;
    }

}
