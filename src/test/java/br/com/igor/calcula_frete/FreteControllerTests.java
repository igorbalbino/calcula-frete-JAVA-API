package br.com.igor.calcula_frete;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class FreteControllerTests {
    @Mock
    private ViaCepService viaCepService;

    private final FreteController freteController = new FreteController();

    @Test
    public void testCalcularFreteComCepValido() {
        // Configuração dos mocks
        Endereco endereco = new Endereco();
        endereco.setCep("30130005");
        when(viaCepService.buscarEnderecoPorCep("30130005")).thenReturn(endereco);

        endereco = new Endereco();
        endereco.setCep("12345678");
        when(viaCepService.buscarEnderecoPorCep("12345678")).thenReturn(endereco);

        // Execução do método a ser testado
        ResponseEntity<String> response = freteController.calcularFrete("12345678");

        // Verificação do resultado
        assertEquals(ResponseEntity.ok("10.0"), response);
    }

    @Test
    public void testCalcularFreteComCepInvalido() {
        // Configuração dos mocks
        Endereco endereco = new Endereco();
        endereco.setCep("30130005");

        // Execução do método a ser testado
        ResponseEntity<String> response = freteController.calcularFrete("1234");

        // Verificação do resultado
        assertEquals(ResponseEntity.ok("CEP informado é inválido. Tente novamente."), response);
    }
}
