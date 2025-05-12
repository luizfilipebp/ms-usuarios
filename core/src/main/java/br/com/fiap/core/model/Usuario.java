package br.com.fiap.core.model;

import br.com.fiap.core.exception.UsuarioInvalidoException;
import br.com.fiap.core.model.enums.TipoUsuario;

public class Usuario {
    private String email;
    private String nome;
    private TipoUsuario tipoUsuario;
    private boolean ativado;

    public Usuario(String email, String nome,  TipoUsuario tipoUsuario, boolean ativado) {
        this.email = validaEmailUsuario(email);
        this.nome = validaNomeUsuario(nome);
        this.tipoUsuario = tipoUsuario;
        this.ativado = ativado;
    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;                 
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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

    public static String validaEmailUsuario(String email) {
        if (email == null || email.isEmpty() || email.indexOf("@") == 0 || !email.contains("@") || !email.contains(".") || email.length() < 5 || email.length() > 50) {
            throw new UsuarioInvalidoException("Email inválido");
        }
        return email;
    }

    public static String validaNomeUsuario(String nome) {
        if (nome == null || nome.length() < 3 || nome.length() > 50) {
            throw new UsuarioInvalidoException("Nome inválido");
        }
        return nome;
    }
}
