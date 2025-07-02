/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class AplicationController {
    public void sairAplicacao(JFrame parent){
        int confirm = JOptionPane.showConfirmDialog(parent, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
}
