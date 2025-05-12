package br.com.fiap.infrastructure.entity;


import br.com.fiap.core.model.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @Column(name = "usu_email", unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "usu_nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "usu_tipo_usuario", nullable = false, length = 25)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    @Column(name = "usu_ativado", nullable = false)
    private boolean ativado;
}
