package br.com.fiap.usecase;

import br.com.fiap.core.model.Usuario;

public interface CadastrarUsuarioUseCase {
    Usuario cadastrar(Usuario usuario) throws Exception;
}
