package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.EditarUsuarioGateway;
import br.com.fiap.application.gateway.PesquisarUsuarioGateway;
import br.com.fiap.core.model.Usuario;
import br.com.fiap.usecase.DesativarUsuarioUseCase;

public class DesativarUsuarioUseCaseImpl implements DesativarUsuarioUseCase {

    private final PesquisarUsuarioGateway pesquisarUsuarioGateway;
    private final EditarUsuarioGateway editarUsuarioGateway;

    public DesativarUsuarioUseCaseImpl(PesquisarUsuarioGateway pesquisarUsuarioGateway, EditarUsuarioGateway editarUsuarioGateway) {
        this.pesquisarUsuarioGateway = pesquisarUsuarioGateway;
        this.editarUsuarioGateway = editarUsuarioGateway;
    }

    @Override
    public Usuario desativar(String email) throws Exception {
        Usuario usuario = pesquisarUsuarioGateway.pesquisarPorEmail(email).orElseThrow(() -> new Exception("Usuário não encontrado"));
        usuario.setAtivado(false);
        return editarUsuarioGateway.editar(email, usuario);
    }
}
