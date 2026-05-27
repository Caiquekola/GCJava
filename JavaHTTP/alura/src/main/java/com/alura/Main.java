package com.alura;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {
    /**
     * Consumindo API OMDB.
     * Precisa passar a API KEY na execução, exemplo "java Aula1.java APIKEY"
     * 
     * @param args Argumentos de linha de comando que devem conter a API Key.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        String APIKEY = "";
        if (args.length == 0 || args[0].isBlank()) {
            System.out.println("Erro: Falta a chave da API nos argumentos de execução.");
            return; // Encerra o programa se não houver a chave
        }
        APIKEY = args[0];
        Scanner scan = new Scanner(System.in);
        HttpClient cliente = HttpClient.newHttpClient();
        Gson gson = new Gson();
        System.out.println("Digite o nome de um filme: ");
        var filme = scan.nextLine().replace(" ", "+");
        var endereco = "https://www.omdbapi.com/?t=" + filme + "&apikey=" + APIKEY;
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> httpResposta = cliente.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResposta.body());
        
    }
}