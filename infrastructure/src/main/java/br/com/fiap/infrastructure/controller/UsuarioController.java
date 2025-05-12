package br.com.fiap.infrastructure.controller;


import br.com.fiap.core.model.Usuario;
import br.com.fiap.infrastructure.dto.UsuarioPostReqBody;
import br.com.fiap.infrastructure.mapper.UsuarioMapper;
import br.com.fiap.usecase.CadastrarUsuarioUseCase;
import br.com.fiap.usecase.DesativarUsuarioUseCase;
import br.com.fiap.usecase.EditarUsuarioUseCase;
import br.com.fiap.usecase.PesquisarUsuarioUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final CadastrarUsuarioUseCase cadastrarUsuarioUseCase;
    private final DesativarUsuarioUseCase desativarUsuarioUseCase;
    private final EditarUsuarioUseCase editarUsuarioUseCase;
    private final PesquisarUsuarioUseCase pesquisarUsuarioUseCase;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid UsuarioPostReqBody usuario) throws Exception {

        Usuario usu = UsuarioMapper.INSTANCE.usuarioPostReqBodyToUsuario(usuario);


        return ResponseEntity.ok(cadastrarUsuarioUseCase.cadastrar(usu));
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> pesquisar(@PathVariable String email) throws Exception {
        return pesquisarUsuarioUseCase.pesquisarUsuario(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> desativar(@PathVariable String email) throws Exception {
        desativarUsuarioUseCase.desativar(email);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{email}")
    public ResponseEntity<Usuario> editar(@PathVariable String email, @RequestBody Usuario usuario) throws Exception {
        return ResponseEntity.ok(editarUsuarioUseCase.editarUsuario(email, usuario));
    }
}
