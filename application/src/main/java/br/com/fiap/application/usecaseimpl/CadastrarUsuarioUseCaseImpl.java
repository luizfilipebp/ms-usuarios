package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.CadastrarUsuarioGateway;
import br.com.fiap.core.model.Usuario;
import br.com.fiap.usecase.CadastrarUsuarioUseCase;
import br.com.fiap.usecase.PesquisarUsuarioUseCase;

public class CadastrarUsuarioUseCaseImpl implements CadastrarUsuarioUseCase {

    private final CadastrarUsuarioGateway cadastrarUsuarioGateway;
    private final PesquisarUsuarioUseCase pesquisarUsuarioUseCase;

    public CadastrarUsuarioUseCaseImpl(CadastrarUsuarioGateway cadastrarUsuarioGateway, PesquisarUsuarioUseCase pesquisarUsuarioUseCase) {
        this.cadastrarUsuarioGateway = cadastrarUsuarioGateway;
        this.pesquisarUsuarioUseCase = pesquisarUsuarioUseCase;
    }

    @Override
    public Usuario cadastrar(Usuario usuario) throws Exception {
        if (pesquisarUsuarioUseCase.pesquisarUsuario(usuario.getEmail()).isPresent()) {
            throw new Exception("Usuário já cadastrado");
        }
        return cadastrarUsuarioGateway.cadastrar(usuario);
    }
}
