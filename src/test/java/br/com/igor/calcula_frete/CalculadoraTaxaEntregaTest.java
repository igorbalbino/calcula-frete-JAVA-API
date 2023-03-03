package br.com.igor.calcula_frete;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTaxaEntregaTest {

    @Test
    public void testCalcularTaxaEntrega() {
        Endereco enderecoA = new Endereco("12345-678", "Rua A", "", "Bairro A", "Cidade A", "AA", "0", "0", "00", "0");
        Endereco enderecoB = new Endereco("12345-679", "Rua B", "", "Bairro B", "Cidade B", "BB", "0", "0", "00", "0");
        double taxaEsperada = 2.5 * 37.8; //distância estimada de 37.8 km
        double taxaCalculada = CalculadoraTaxaEntrega.calcularTaxaEntrega(enderecoA, enderecoB);
        assertEquals(taxaEsperada, taxaCalculada);
    }

    @Test
    public void testCalcularDistancia() {
        Endereco enderecoA = new Endereco("12345-678", "Rua A", "", "Bairro A", "Cidade A", "AA", "0", "0", "00", "0");
        Endereco enderecoB = new Endereco("12345-679", "Rua B", "", "Bairro B", "Cidade B", "BB", "0", "0", "00", "0");
        double distanciaEsperada = 37.8;
        double distanciaCalculada = CalculadoraTaxaEntrega.calcularDistancia(enderecoA, enderecoB);
        assertEquals(distanciaEsperada, distanciaCalculada);
    }
}
