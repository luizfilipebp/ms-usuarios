package br.com.fiap.usecase;

import br.com.fiap.core.model.Usuario;

public interface EditarUsuarioUseCase {
    Usuario editarUsuario(String email, Usuario usuario) throws Exception ;
}
