package br.com.igor.calcula_frete;

/*
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
*/

public class CalculadoraTaxaEntrega {

    private static final double TAXA_KM = 7.85; // valor da taxa por quilômetro
    /*private static final String MY_GOOGLE_MAPS_API_KEY = "COLOQUE_SUA_CHAVE_AQUI";
    private static final String SPACE_LINE_SPACE = "%20%2D%20";
    private static final String COMMA_SPACE = "%2C%20";
    private static final String URL_GOOGLE_MAPS = "http://maps.googleapis.com/maps/api/distancematrix/json";
    private static RestTemplate restTemplate = new RestTemplate();*/

    public static double calcularTaxaEntrega(Endereco enderecoA, Endereco enderecoB) {
        double distancia = calcularDistancia(enderecoA, enderecoB);
        return distancia * TAXA_KM;
    }

    public static double calcularDistancia(Endereco enderecoA, Endereco enderecoB) {
        /* NÃO FOI FÁCIL FAZER A API FUNCIONAR E DE FATO NÃO FUNCIONOU
        String origem = spaceToCode(enderecoA.getLogradouro()) + SPACE_LINE_SPACE + spaceToCode(enderecoA.getBairro()) + SPACE_LINE_SPACE + spaceToCode(enderecoA.getLocalidade()) + COMMA_SPACE + enderecoA.getUf() + SPACE_LINE_SPACE + lineToCode(enderecoA.getCep());
        String destino = spaceToCode(enderecoB.getLogradouro()) + SPACE_LINE_SPACE + spaceToCode(enderecoB.getBairro()) + SPACE_LINE_SPACE + spaceToCode(enderecoB.getLocalidade()) + COMMA_SPACE + enderecoB.getUf() + SPACE_LINE_SPACE + lineToCode(enderecoB.getCep());
        String url = URL_GOOGLE_MAPS + "?origins=" + origem + "&destinations=" + destino + "&key=" + MY_GOOGLE_MAPS_API_KEY;
        MapsResponse mapsResult = callGoogleMapsApi(url);
        if(mapsResult.getStatus() == "REQUEST_DENIED"){
            return 0.0;
        }*/
        return 37.8;
    }

    /*private static String spaceToCode(String str) {
        return str.replaceAll(" ", "%20");
    }

    private static String lineToCode(String str) {
        return str.replaceAll("-", "%2D");
    }

    private static MapsResponse callGoogleMapsApi(String url) {
        ResponseEntity<MapsResponse> responseEntity = restTemplate.exchange(
                url, HttpMethod.GET, null, MapsResponse.class);
        return responseEntity.getBody();
    }*/
}