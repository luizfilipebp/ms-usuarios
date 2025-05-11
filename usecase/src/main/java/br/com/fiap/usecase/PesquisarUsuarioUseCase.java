package br.com.fiap.usecase;

import br.com.fiap.core.model.Usuario;

import java.util.Optional;

public interface PesquisarUsuarioUseCase {
    Optional<Usuario> pesquisarUsuario(Long id) throws Exception;
}
