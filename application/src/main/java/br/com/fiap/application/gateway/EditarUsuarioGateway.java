package br.com.fiap.application.gateway;

import br.com.fiap.core.model.Usuario;

public interface EditarUsuarioGateway {
    Usuario editar(String email, Usuario usuario);
}
