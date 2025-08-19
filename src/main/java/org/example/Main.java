package org.example;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        double amount;
        int option;
        Scanner scanner = new Scanner(System.in);
        try {


            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://v6.exchangerate-api.com/v6/33b553e3a21ff5d66ae5e0f6/latest/USD"))
                    .GET() // Pode ser .POST, .PUT, etc.
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            Gson gson = new Gson();
            Currency currency = gson.fromJson(response.body(), Currency.class);

            do {
                System.out.println("=== Conversor de Moedas ===");
                System.out.println("1. Converter BRL -> USD");
                System.out.println("2. Converter USD -> BRL");
                System.out.println("3. Converter BRL -> EUR");
                System.out.println("4. Converter EUR -> BRL");
                System.out.println("5. Converter USD -> EUR");
                System.out.println("6. Converter EUR -> USD");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");

                option = scanner.nextInt();
                scanner.reset();

                switch (option){

                    case 1:
                        System.out.println("digite um valor em reais");
                        amount = scanner.nextDouble();
                        System.out.println(currency.brlToUsd(amount));
                        scanner.reset();
                        break;

                    case 2:
                        System.out.println("digite um valor em dólar");
                        amount = scanner.nextDouble();
                        System.out.println(currency.usdToBrl(amount));
                        scanner.reset();
                        break;

                    case 3:
                        System.out.println("digite um valor em reais");
                        amount = scanner.nextDouble();
                        System.out.println(currency.brlToEur(amount));
                        scanner.reset();
                        break;

                    case 4:
                        System.out.println("digite um valor em euro");
                        amount = scanner.nextDouble();
                        System.out.println(currency.eurToBrl(amount));
                        scanner.reset();
                        break;

                    case 5:
                        System.out.println("digite um valor em dólar");
                        amount = scanner.nextDouble();
                        System.out.println(currency.usdToEur(amount));
                        scanner.reset();
                        break;

                    case 6:
                        System.out.println("digite um  em euro");
                        amount = scanner.nextDouble();
                        System.out.println(currency.eurToUsd(amount));
                        scanner.reset();
                        break;

                    case 0:
                        break;

                    default:
                        System.out.println("opção invalida");
                }

            } while (option != 0);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}