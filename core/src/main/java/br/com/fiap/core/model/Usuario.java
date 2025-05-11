package br.com.fiap.core.model;

import br.com.fiap.core.exception.UsuarioInvalidoException;
import br.com.fiap.core.model.enums.TipoUsuario;

public class Usuario {
    private long id;
    private String nome;
    private String email;
    private TipoUsuario tipoUsuario;
    private boolean ativado;

    public Usuario(long id, String nome, String email, TipoUsuario tipoUsuario, boolean ativado) {
        this.id = validaIdUsuario(id);
        this.nome = validaNomeUsuario(nome);
        this.email = validaEmailUsuario(email);
        this.tipoUsuario = tipoUsuario;
        this.ativado = ativado;
    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;                 
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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
