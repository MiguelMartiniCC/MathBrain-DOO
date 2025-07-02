/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Miguel
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private int nivel;
    private int qntdVitorias;
    private int qntdPartidas;
//teste

    public Usuario(String nome){
        this.nome = nome;
        this.nivel = 1;
    }
    
    public Usuario (String nome, String senha, int nivelAtual){
        this.nome = nome;
        this.senha = senha;
        this.nivel = nivelAtual;
    }
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.nivel = 1;
        this.qntdVitorias = 0;
        this.qntdPartidas = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getQntdVitorias() {
        return qntdVitorias;
    }

    public void setQntdVitorias(int qntdVitorias) {
        this.qntdVitorias = qntdVitorias;
    }

    public int getQntdPartidas() {
        return qntdPartidas;
    }

    public void setQntdPartidas(int qntdPartidas) {
        this.qntdPartidas = qntdPartidas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivelAtual() {
        return nivel;
    }

    public void setNivelAtual(int nivel) {
        this.nivel = nivel;
    }
    
}
