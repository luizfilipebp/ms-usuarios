package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.PesquisarUsuarioGateway;
import br.com.fiap.core.model.Usuario;
import br.com.fiap.usecase.PesquisarUsuarioUseCase;

import java.util.Optional;

public class PesquisarUsuarioUseCaseImpl implements PesquisarUsuarioUseCase {

    private final PesquisarUsuarioGateway pesquisarUsuarioGateway;

    public PesquisarUsuarioUseCaseImpl(PesquisarUsuarioGateway pesquisarUsuarioGateway) {
        this.pesquisarUsuarioGateway = pesquisarUsuarioGateway;
    }

    @Override
    public Optional<Usuario> pesquisarUsuario(String email) throws Exception {
        return pesquisarUsuarioGateway.pesquisarPorEmail(Usuario.validaEmailUsuario(email));
    }
}
