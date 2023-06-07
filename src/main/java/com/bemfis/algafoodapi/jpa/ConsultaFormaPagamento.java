package com.bemfis.algafoodapi.jpa;

import com.bemfis.algafoodapi.AlgafoodApiApplication;
import com.bemfis.algafoodapi.domain.model.FormaPagamento;
import com.bemfis.algafoodapi.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaFormaPagamento {
    public static void main(String[] args) {
        //instanciando um construtor (builder) de springApplication, para informar, com alguns parâmetros,
        //que a nossa aplicação não é web.
        //passa a classe AlgaJpaIntroducaoApplication pois é a fonte primaria de configurações da nossa aplicação.

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE) //afirma que não é aplicação web1.
                .run(args); //argumentos do método main.

        //gera um bean do tipo CadastroCozinha, uma instância.

        FormaPagamentoRepository formasPagamento = applicationContext.getBean(FormaPagamentoRepository.class);

        List<FormaPagamento> todasFormasPagamento = formasPagamento.findAll();

        for (FormaPagamento formaPagamento : todasFormasPagamento) {
            System.out.println(formaPagamento.getDescricao());
        }

    }
}
