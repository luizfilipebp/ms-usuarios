package br.com.fiap.usecase;

import br.com.fiap.core.model.Usuario;

import java.util.Optional;

public interface PesquisarUsuarioUseCase {
    Optional<Usuario> pesquisarUsuario(String id) throws Exception;
}
