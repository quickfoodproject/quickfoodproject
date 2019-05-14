package com.senai.quickfood.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repository {

    private Repository() {
    }

    private static Repository instance;

    public static Repository getInstace() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://us-cdbr-iron-east-02.cleardb.net:3306/heroku_bda16118a5482b1?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "bacf406b54e8ea";
    private static final String PASSWORD = "f7c9935339fea37";

    public Connection conection;
    public PreparedStatement preparedStatement;
    public Statement statement;
    public ResultSet resultSet;

    private void loadDriver() {
        try {
            System.out.println("Carregando Driver do Banco de dados...");
            Class.forName(DRIVER);
            System.out.println("Driver carregado com sucesso...");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do banco de dados não foi encontrado..." + e.getMessage());
        }
    }

    private void startConnection() {
        try {
            System.out.println("Conectando ao banco de dados...");
            conection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão efetuada com sucesso...");
        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados...");
        }
    }

    private void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            conection.close();
            System.out.println("Conexão com o Banco de dados encerrada...");
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão...");
        }
    }

    public void open() {
        loadDriver();
        startConnection();
    }

    public void close() {
        closeConnection();
    }

}
