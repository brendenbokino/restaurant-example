package edu.loyola.cs485.gfbb.model.dao;

import edu.loyola.cs485.gfbb.model.entity.AbstractEntity;

import java.sql.*;
import java.util.List;

public abstract class AbstractDAO<E extends AbstractEntity> {
    //By using Generics, we can make sure each DAO is bound to a specific Entity

    String ConUrl = "jdbc:mysql://localhost"; //protocol + url
    String Port = "3306"; //default MySQL port
    String Database = "restaurant_db"; // database/schema name
    String Username = "admin"; //read this from a local file
    String Password = "MvHUzGfa0t1xl0"; //Also read this from a file

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ConUrl+":"+Port+"/"+Database+ "?user="+Username+"&password="+Password);
    }

    public void setTestDatabase() {
        this.Database = "restaurant_db_test";
    }

    // Abstract Methods for each CRUD operation
    public abstract void create(E entity) throws SQLException;
    public abstract E read(int ID) throws SQLException;
    public abstract void update(E entity) throws SQLException;
    public abstract void delete(int ID) throws SQLException;
    public abstract List<E> list() throws SQLException;
}