package br.com.fiap.infrastructure.service;

import br.com.fiap.application.gateway.PesquisarUsuarioGateway;
import br.com.fiap.core.model.Usuario;
import br.com.fiap.infrastructure.entity.UsuarioEntity;
import br.com.fiap.infrastructure.mapper.UsuarioMapper;
import br.com.fiap.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PesquisarUsuarioGatewayImpl implements PesquisarUsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> pesquisarPorEmail(String email){
        UsuarioEntity usuario = usuarioRepository.findByEmail(email).isPresent()
                ? usuarioRepository.findByEmail(email).get()
                : null;
        return Optional.ofNullable(UsuarioMapper.INSTANCE.usuarioEntityToUsuario(usuario));
    }
}
