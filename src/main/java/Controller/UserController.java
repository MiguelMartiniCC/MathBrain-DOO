/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UserDao;
import Model.Usuario;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Miguel
 */
public class UserController {
    AuthenticationController auth = new AuthenticationController();
    

    public void editarUsuario(Usuario usuario, JFrame janelaAtual) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField nomeField = new JTextField(usuario.getNome());
        nomeField.setColumns(15);

        JLabel vitoriasLabel = new JLabel("Vitórias: " + usuario.getQntdVitorias());
        JLabel partidasLabel = new JLabel("Partidas: " + usuario.getQntdPartidas());

        panel.add(new JLabel("Novo nome:"));
        panel.add(nomeField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(vitoriasLabel);
        panel.add(partidasLabel);

        Object[] options = {"Salvar", "Deletar", "Cancelar"};
        int result = JOptionPane.showOptionDialog(null, panel, "Editar Usuário",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        if (result == JOptionPane.YES_OPTION) {
            String novoNome = nomeField.getText().trim();
            if (!novoNome.isEmpty()) {
                new UserDao().atualizarNomeUsuario(usuario.getId(), novoNome);
                usuario.setNome(novoNome); // atualiza na memória também
                JOptionPane.showMessageDialog(null, "Nome atualizado com sucesso!");
                auth.retornar(janelaAtual); // chama o método do AuthenticationController;
            } else {
                JOptionPane.showMessageDialog(null, "O nome não pode estar vazio.");
            }
        } else if (result == JOptionPane.NO_OPTION) {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Tem certeza que deseja deletar este usuário?", "Confirmar exclusão",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                new UserDao().deletarUsuario(usuario.getId());
                JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
                auth.retornar(janelaAtual);
            }
        }
    }
}
