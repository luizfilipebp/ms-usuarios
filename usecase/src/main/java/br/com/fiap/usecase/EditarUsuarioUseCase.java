package br.com.fiap.usecase;

import br.com.fiap.core.model.Usuario;

public interface EditarUsuarioUseCase {
    Usuario editarUsuario(Long id, Usuario usuario) throws Exception;
}
