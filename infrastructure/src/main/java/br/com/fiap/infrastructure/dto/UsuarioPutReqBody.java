package br.com.fiap.infrastructure.dto;

import br.com.fiap.core.model.enums.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioPutReqBody(
        @Email
        String email,
        @NotBlank
        String nome,
        TipoUsuario tipoUsuario
) {
}
