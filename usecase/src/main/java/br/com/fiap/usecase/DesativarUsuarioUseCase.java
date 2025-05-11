package br.com.fiap.usecase;

import br.com.fiap.core.model.Usuario;

public interface DesativarUsuarioUseCase {
    Usuario desativarUsuario(String id) throws Exception;
}
