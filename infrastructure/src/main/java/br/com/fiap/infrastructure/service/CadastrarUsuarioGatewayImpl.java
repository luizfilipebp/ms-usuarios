package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.CadastrarUsuarioGateway;
import br.com.fiap.core.model.Usuario;
import br.com.fiap.infrastructure.entity.UsuarioEntity;
import br.com.fiap.infrastructure.mapper.UsuarioMapper;
import br.com.fiap.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CadastrarUsuarioGatewayImpl implements CadastrarUsuarioGateway {
    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario cadastrar(Usuario usuario) {
        UsuarioEntity saved = usuarioRepository.save(UsuarioMapper.INSTANCE.usuarioToUsuarioEntity(usuario));
        return  UsuarioMapper.INSTANCE.usuarioEntityToUsuario(saved);
    }
}
