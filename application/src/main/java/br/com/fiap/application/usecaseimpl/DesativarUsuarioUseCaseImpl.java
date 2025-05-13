package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.EditarUsuarioGateway;
import br.com.fiap.application.gateway.PesquisarUsuarioGateway;
import br.com.fiap.core.model.Usuario;
import br.com.fiap.usecase.DesativarUsuarioUseCase;
import br.com.fiap.usecase.EditarUsuarioUseCase;

public class DesativarUsuarioUseCaseImpl implements DesativarUsuarioUseCase {

    private final PesquisarUsuarioGateway pesquisarUsuarioGateway;
    private final EditarUsuarioUseCase editarUsuarioUseCase;

    public DesativarUsuarioUseCaseImpl(PesquisarUsuarioGateway pesquisarUsuarioGateway, EditarUsuarioUseCase editarUsuarioUseCase) {
        this.pesquisarUsuarioGateway = pesquisarUsuarioGateway;
        this.editarUsuarioUseCase = editarUsuarioUseCase;
    }

    @Override
    public Usuario desativar(String email) throws Exception {
        Usuario usuario = pesquisarUsuarioGateway.pesquisarPorEmail(email).orElseThrow(() -> new Exception("Usuário não encontrado"));
        usuario.setAtivado(false);
        return editarUsuarioUseCase.editarUsuario(email, usuario);
    }
}
