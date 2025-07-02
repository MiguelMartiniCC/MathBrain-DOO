/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UserDao;
import Model.Usuario;
import Views.ViewCadastro;
import Views.ViewLogin;
import Views.ViewMenu;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class AuthenticationController {
    private UserDao userDao;

    public AuthenticationController() {
        this.userDao = new UserDao();
    }
//    Relacionado ao login do usuário
    public void inicializar(){
        ViewLogin sistema = new ViewLogin();
        sistema.setVisible(true);
    }

    public void autenticar(String nome, String senha, JFrame currentView) {
        if (nome == null || nome.isBlank() || senha == null || senha.isBlank()) {
            if (currentView instanceof ViewLogin loginView) {
                loginView.exibirErro("Preencha todos os campos!");
            }
            return;
        }

        Usuario user = userDao.autenticarUsuario(nome, senha);

        if (user != null) {
            // Fecha a tela atual e abre o menu
            ViewMenu menu = new ViewMenu(user);
            menu.setVisible(true);
            currentView.dispose();
        } else {
            if (currentView instanceof ViewLogin loginView) {
                loginView.exibirErro("Usuário ou senha incorretos!");
            }
        }
    }
//    Relacionado ao Cadastro do usuário
    public void entrarCadastro(JFrame janelaAtual){
        ViewCadastro cadastro = new ViewCadastro();
        cadastro.setVisible(true);
        janelaAtual.dispose();
    }
    public void retornar(JFrame janelaAtual){
        ViewLogin login = new ViewLogin();
        login.setVisible(true);
        janelaAtual.dispose();
    }
    
     public void cadastrarUsuario(String nome, String senha, JFrame telaAtual) {
        if (nome.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(telaAtual, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario user = new Usuario(nome, senha);
        user.setNivel(1); 
        user.setQntdVitorias(0);
        user.setQntdPartidas(0);

        UserDao dao = new UserDao();
        dao.criarUsuario(user);

        ViewMenu menu = new ViewMenu(user);
        menu.setVisible(true);
        telaAtual.dispose();
    }
}
