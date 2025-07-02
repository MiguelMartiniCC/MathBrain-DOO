/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Miguel
 */
public class DBInit {
    public void inicializar() {
        try (Connection conn = ConexaoDAO.conectorBD();
             Statement stmt = conn.createStatement()) {

            String sqlCriarTabela = "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "nome VARCHAR(100) NOT NULL,"
                    + "senha VARCHAR(100) NOT NULL,"
                    + "nivel INT DEFAULT 1,"
                    + "qntdVitorias INT DEFAULT 0,"
                    + "qntdPartidas INT DEFAULT 0"
                    + ")";

            stmt.executeUpdate(sqlCriarTabela);
            System.out.println("Tabela 'usuarios' verificada/criada com sucesso.");

        } catch (SQLException e) {
            System.err.println("Erro ao criar/verificar tabela:");
            e.printStackTrace();
        }
    }
}
