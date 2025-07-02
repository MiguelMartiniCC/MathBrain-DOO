
import Controller.AuthenticationController;
import DAO.ConexaoDAO;
import DAO.DBInit;
import java.sql.Connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Miguel
 */
public class Main {
    public static void main(String[] args) {
        DBInit bd = new DBInit();
        bd.inicializar();
        AuthenticationController auth = new AuthenticationController();
        auth.inicializar();
    }
}
