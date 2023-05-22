package com.bemfis.algafoodapi.api.controller.expEstudo;

import com.bemfis.algafoodapi.domain.model.Cozinha;
import com.bemfis.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //é um controlador que tem um responseBody dentro
@RequestMapping("/cozinhasexp1") //uri para fazer o mapeamento do controlador
//@ResponseBody a resposta do método deve ser enviada como resposta da requisição http
public class CozinhaCtrlExp1 {
    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping //requisições com o verbo http get chegarão nesse método
    public List<Cozinha> listar(){
        return cozinhaRepository.listar();
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId){
        //ResponseEntity representa uma resposta http onde pode ter uma instância dentro

        Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

        //Instanciando o ResponseEntity, que é um builder, define qual status e o corpo.
        //return ResponseEntity.status(HttpStatus.OK).body(cozinha);

        //jeito mais simples, que é um atalho para a linha de cima.
        return ResponseEntity.ok(cozinha);
    }
}
