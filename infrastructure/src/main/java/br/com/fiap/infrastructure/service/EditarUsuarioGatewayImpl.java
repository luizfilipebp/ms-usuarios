package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.EditarUsuarioGateway;
import br.com.fiap.core.model.Usuario;
import br.com.fiap.infrastructure.entity.UsuarioEntity;
import br.com.fiap.infrastructure.mapper.UsuarioMapper;
import br.com.fiap.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditarUsuarioGatewayImpl implements EditarUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario editar(String email, Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioRepository.findByEmail(email)
                .map(existingUsuario -> {
                    existingUsuario.setNome(usuario.getNome());
                    existingUsuario.setEmail(usuario.getEmail());
                    existingUsuario.setTipoUsuario(usuario.getTipoUsuario());
                    return usuarioRepository.save(existingUsuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return UsuarioMapper.INSTANCE.usuarioEntityToUsuario(usuarioEntity);
    }
}
