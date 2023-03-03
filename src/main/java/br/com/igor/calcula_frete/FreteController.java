package br.com.igor.calcula_frete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

import java.util.regex.Pattern;

@RequestMapping("/cep")
@RestController
public class FreteController {

    private ViaCepService viaCepService;
    private final Endereco ENDERECO_PADRAO;

    public FreteController() {
        viaCepService = new ViaCepService();
        ENDERECO_PADRAO = viaCepService.buscarEnderecoPorCep("30130005"); //main cep é do parque municipal
    }

    //O LINK PARA CHAMAR A API É: localhost:8080/cep/consulta/DIGITE_O_CEP_AQUI
    @GetMapping("/consulta/{cep}")
    public ResponseEntity<String> calcularFrete(@PathVariable("cep") String cep) {
        boolean isValid = Pattern.matches("^\\d{8}$", cep);
        if(isValid) {
            Endereco endereco = viaCepService.buscarEnderecoPorCep(cep);

            Double valorFrete = CalculadoraTaxaEntrega.calcularTaxaEntrega(ENDERECO_PADRAO, endereco);
            return ResponseEntity.ok(valorFrete.toString());
        }
        return ResponseEntity.ok("CEP informado é inválido. Tente novamente.");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
