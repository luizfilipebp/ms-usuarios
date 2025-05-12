package br.com.fiap.usecase;

import br.com.fiap.core.model.Usuario;

public interface DesativarUsuarioUseCase {
    Usuario desativar(String email) throws Exception;
}
