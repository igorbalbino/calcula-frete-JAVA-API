package br.com.igor.calcula_frete;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ViaCepServiceTest {

    @Test
    public void buscarEnderecoPorCep_deveRetornarEnderecoComSucesso() {
        // setup
        String cep = "12345678";
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        Endereco endereco = new Endereco();
        endereco.setCep(cep);
        ResponseEntity<Endereco> responseEntity = new ResponseEntity<>(endereco, HttpStatus.OK);

        RestTemplate restTemplate = mock(RestTemplate.class);
        ViaCepService viaCepService = new ViaCepService();
        ReflectionTestUtils.setField(viaCepService, "restTemplate", restTemplate);

        when(restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Endereco.class, cep))
                .thenReturn(responseEntity);

        // execute
        Endereco result = viaCepService.buscarEnderecoPorCep(cep);

        // assert
        assertNotNull(result);
        assertEquals(cep, result.getCep());
    }

    @Test
    public void buscarEnderecoPorCep_deveRetornarNullQuandoCepForInvalido() {
        // setup
        String cep = "12345";
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        RestTemplate restTemplate = mock(RestTemplate.class);
        ViaCepService viaCepService = new ViaCepService();
        ReflectionTestUtils.setField(viaCepService, "restTemplate", restTemplate);

        when(restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, Endereco.class, cep))
                .thenReturn(null);

        // execute
        Endereco result = viaCepService.buscarEnderecoPorCep(cep);

        // assert
        assertEquals(null, result);
    }
}
