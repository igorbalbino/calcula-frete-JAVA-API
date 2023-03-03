package br.com.igor.calcula_frete;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json/";
    private RestTemplate restTemplate;

    public ViaCepService() {
        restTemplate = new RestTemplate();
    }

    public Endereco buscarEnderecoPorCep(String cep) {
        ResponseEntity<Endereco> responseEntity = restTemplate.exchange(
                VIA_CEP_URL, HttpMethod.GET, null, Endereco.class, cep);
        return responseEntity.getBody();
    }

}
