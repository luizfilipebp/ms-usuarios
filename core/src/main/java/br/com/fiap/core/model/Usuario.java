package br.com.fiap.core.model;

import br.com.fiap.core.exception.UsuarioInvalidoException;

public class Usuario {
    private long id;
    private String nome;
    private String email;

    public Usuario(long id, String nome, String email) {
        this.id = validaIdUsuario(id);
        this.nome = validaNomeUsuario(nome);
        this.email = validaEmailUsuario(email);
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private static Long validaIdUsuario(Long id) {
        if (id == null || id <= 0) {
            throw new UsuarioInvalidoException("ID inválido");
        }
        return id;
    }

    private static String validaEmailUsuario(String email) {
        if (email == null || email.isEmpty() || email.indexOf("@") == 0 || !email.contains("@") || !email.contains(".") || email.length() < 5 || email.length() > 50) {
            throw new UsuarioInvalidoException("Email inválido");
        }
        return email;
    }

    private static String validaNomeUsuario(String nome) {
        if (nome == null || nome.length() < 3 || nome.length() > 50) {
            throw new UsuarioInvalidoException("Nome inválido");
        }
        return nome;
    }
}
