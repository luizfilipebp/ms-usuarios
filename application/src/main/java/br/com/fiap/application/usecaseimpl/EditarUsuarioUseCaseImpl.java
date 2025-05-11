package br.com.fiap.application.usecaseimpl;

import br.com.fiap.application.gateway.EditarUsuarioGateway;
import br.com.fiap.core.model.Usuario;
import br.com.fiap.usecase.EditarUsuarioUseCase;

public class EditarUsuarioUseCaseImpl implements EditarUsuarioUseCase {

    private final EditarUsuarioGateway editarUsuarioGateway;

    public EditarUsuarioUseCaseImpl(EditarUsuarioGateway editarUsuarioGateway) {
        this.editarUsuarioGateway = editarUsuarioGateway;
    }

    @Override
    public Usuario editarUsuario(Long id, Usuario usuario) throws Exception {
        return editarUsuarioGateway.editar(Usuario.validaIdUsuario(id), usuario);
    }
}
