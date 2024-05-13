package moedas.com.br;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversao {
    public static Double currencyApi(String moedaOrigem, String moedaDestino) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/5fad55cbefcefba20b381701/pair/"
                    + moedaOrigem + "/" + moedaDestino))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                String json = response.body();
                FormatacaoMoeda retorno = gson.fromJson(json, FormatacaoMoeda.class);
                return retorno.conversion_rate();
            } else {
                System.err.println("Erro ao obter taxa de cambio. Codigo de status: " +
                        response.statusCode());
                return  null;
            }
        } catch (IOException e) {
            System.err.println("Erro de E/S ao conectar a API: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            System.err.println("Thread interrompida durante a conexão à API: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}



















