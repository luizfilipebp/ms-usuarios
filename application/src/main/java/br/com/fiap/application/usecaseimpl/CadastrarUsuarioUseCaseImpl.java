package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.CadastrarUsuarioGateway;
import br.com.fiap.core.model.Usuario;
import br.com.fiap.usecase.CadastrarUsuarioUseCase;

public class CadastrarUsuarioUseCaseImpl implements CadastrarUsuarioUseCase {

    private final CadastrarUsuarioGateway cadastrarUsuarioGateway;

    public CadastrarUsuarioUseCaseImpl(CadastrarUsuarioGateway cadastrarUsuarioGateway) {
        this.cadastrarUsuarioGateway = cadastrarUsuarioGateway;
    }

    @Override
    public Usuario cadastrar(Usuario usuario) throws Exception {
        return cadastrarUsuarioGateway.cadastrar(usuario);
    }
}
