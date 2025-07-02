/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Miguel
 */
public class UserDao {
    
    
    public void criarUsuario(Usuario usuario) {
    String sql = "INSERT INTO usuarios (nome, senha, nivel, qntdVitorias, qntdPartidas) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = ConexaoDAO.conectorBD();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
//testee
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getSenha());
        stmt.setInt(3, usuario.getNivel());
        stmt.setInt(4, usuario.getQntdVitorias());
        stmt.setInt(5, usuario.getQntdPartidas());

        stmt.executeUpdate();
        System.out.println("Usuário inserido com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao inserir usuário:");
        e.printStackTrace();
    }
}
    
    public Usuario autenticarUsuario(String nome, String senha) {
    String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";

    try (Connection conn = ConexaoDAO.conectorBD();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Usuario user = new Usuario(
            rs.getString("nome"),
            rs.getString("senha"),
            rs.getInt("nivel")
            );
            user.setId(rs.getInt("id"));
            user.setQntdVitorias(rs.getInt("qntdVitorias"));
            user.setQntdPartidas(rs.getInt("qntdPartidas"));
            return user;
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
}
    
//    adicionado por último
    public void atualizarNomeUsuario(int id, String novoNome) {
        String sql = "UPDATE usuarios SET nome = ? WHERE id = ?";
        try (Connection conn = ConexaoDAO.conectorBD();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setInt(2, id);

            stmt.executeUpdate();
            System.out.println("Nome do usuário atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar nome do usuário:");
            e.printStackTrace();
        }
    }
    public void deletarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = ConexaoDAO.conectorBD();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuário deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar usuário:");
            e.printStackTrace();
        }
    }
    public void atualizarUsuario(Usuario usuario) {
    String sql = "UPDATE usuarios SET qntdVitorias = ?, qntdPartidas = ? WHERE nome = ?";

    try (Connection conn = ConexaoDAO.conectorBD();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, usuario.getQntdVitorias());
        stmt.setInt(2, usuario.getQntdPartidas());
        stmt.setString(3, usuario.getNome());

        stmt.executeUpdate();
        System.out.println("Usuário atualizado com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao atualizar usuário:");
        e.printStackTrace();
    }
}
    
}
