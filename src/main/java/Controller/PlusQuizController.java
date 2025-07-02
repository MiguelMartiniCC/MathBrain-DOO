/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UserDao;
import Model.Usuario;
import Views.Quiz.ViewPlusQuiz;
import Views.ViewMenu;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class PlusQuizController {
    private final ViewPlusQuiz view;
    private final Usuario user;
    private int currentQuestion = 1;
    private int correctAnswers = 0;
    private int value1;
    private int value2;
    private final int totalQuestions = 10;

    public PlusQuizController(ViewPlusQuiz view, Usuario user) {
        this.view = view;
        this.user = user;
        generateNewQuestion();
    }

    public void handleNextQuestion(String userInput) {
        try {
            int userResult = Integer.parseInt(userInput);

            if (userResult == (value1 + value2)) {
                correctAnswers++;
                view.exibirMensagem("Correto!", new java.awt.Color(0, 153, 0));
            } else {
                view.exibirMensagem("Incorreto! Resposta correta: " + (value1 + value2), new java.awt.Color(204, 0, 0));
            }

            currentQuestion++;

            if (currentQuestion <= totalQuestions) {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        generateNewQuestion();
                    }
                }, 1000);
            } else {
                finalizarQuiz();
            }

        } catch (NumberFormatException e) {
            view.exibirMensagem("Por favor, insira um número válido.", new java.awt.Color(204, 0, 0));
        }
    }

    private void generateNewQuestion() {
        value1 = (int) (Math.random() * 50) + 1;
        value2 = (int) (Math.random() * 50) + 1;

        view.setPergunta(value1, value2, currentQuestion, totalQuestions);
    }

    private void finalizarQuiz() {
        JOptionPane.showMessageDialog(view,
                "Quiz Finalizado!\nVocê acertou " + correctAnswers + " de " + totalQuestions + " questões.",
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);

        user.setQntdPartidas(user.getQntdPartidas() + 1);
        if (correctAnswers == totalQuestions) {
            user.setQntdVitorias(user.getQntdVitorias() + 1);
        }

        new UserDao().atualizarUsuario(user); // Adicione esse método no UserDao (veja abaixo)
        ViewMenu menu = new ViewMenu(user);
        menu.setVisible(true);
        view.dispose();
    }
}
