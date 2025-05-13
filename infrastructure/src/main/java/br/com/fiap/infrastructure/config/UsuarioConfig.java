package br.com.fiap.infrastructure.config;

import br.com.fiap.application.gateway.CadastrarUsuarioGateway;
import br.com.fiap.application.gateway.EditarUsuarioGateway;
import br.com.fiap.application.gateway.PesquisarUsuarioGateway;
import br.com.fiap.application.usecaseimpl.CadastrarUsuarioUseCaseImpl;
import br.com.fiap.application.usecaseimpl.DesativarUsuarioUseCaseImpl;
import br.com.fiap.application.usecaseimpl.EditarUsuarioUseCaseImpl;
import br.com.fiap.application.usecaseimpl.PesquisarUsuarioUseCaseImpl;
import br.com.fiap.usecase.CadastrarUsuarioUseCase;
import br.com.fiap.usecase.DesativarUsuarioUseCase;
import br.com.fiap.usecase.EditarUsuarioUseCase;
import br.com.fiap.usecase.PesquisarUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    PesquisarUsuarioUseCase pesquisarUsuarioUseCase(PesquisarUsuarioGateway pesquisarUsuarioGateway) {
        return new PesquisarUsuarioUseCaseImpl(pesquisarUsuarioGateway);
    }

    @Bean
    CadastrarUsuarioUseCase cadastrarUsuarioUseCase(CadastrarUsuarioGateway cadastrarUsuarioGateway, PesquisarUsuarioUseCase pesquisarUsuarioUseCase) {
        return new CadastrarUsuarioUseCaseImpl(cadastrarUsuarioGateway, pesquisarUsuarioUseCase);
    }

    @Bean
    DesativarUsuarioUseCase desativarUsuarioUseCase(PesquisarUsuarioGateway pesquisarUsuarioGateway, EditarUsuarioUseCase editarUsuarioUseCase) {
        return new DesativarUsuarioUseCaseImpl(pesquisarUsuarioGateway, editarUsuarioUseCase);
    }

    @Bean
    EditarUsuarioUseCase editarUsuarioUseCase(EditarUsuarioGateway editarUsuarioGateway) {
        return new EditarUsuarioUseCaseImpl(editarUsuarioGateway);
    }

}