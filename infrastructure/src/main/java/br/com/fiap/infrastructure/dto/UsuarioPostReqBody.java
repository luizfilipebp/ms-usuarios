package br.com.fiap.infrastructure.dto;

import br.com.fiap.core.model.enums.TipoUsuario;
import jakarta.validation.constraints.Email;

public record UsuarioPostReqBody (
        Long id,
        String nome,
        @Email
        String email,
        TipoUsuario tipoUsuario,
        boolean ativado
) {
}
