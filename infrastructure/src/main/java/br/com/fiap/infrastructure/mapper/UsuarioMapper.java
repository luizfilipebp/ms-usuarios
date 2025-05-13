package br.com.fiap.infrastructure.mapper;

import br.com.fiap.core.model.Usuario;
import br.com.fiap.infrastructure.dto.UsuarioPostReqBody;
import br.com.fiap.infrastructure.dto.UsuarioPutReqBody;
import br.com.fiap.infrastructure.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    UsuarioEntity usuarioToUsuarioEntity(Usuario usuario);
    Usuario usuarioEntityToUsuario(UsuarioEntity usuarioEntity);

//    UsuarioEntity usuarioPostReqBodyToUsuarioEntity(UsuarioPostReqBody usuario);

    Usuario usuarioPostReqBodyToUsuario(UsuarioPostReqBody usuarioPostReqBody);

    Usuario usuarioPutReqBodyToUsuario(UsuarioPutReqBody usuarioPutReqBody);
}
