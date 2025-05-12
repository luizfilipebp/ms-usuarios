package br.com.fiap.application.gateway;

import br.com.fiap.core.model.Usuario;

import java.util.Optional;

public interface PesquisarUsuarioGateway {
    Optional<Usuario> pesquisarPorEmail(String email);
}
