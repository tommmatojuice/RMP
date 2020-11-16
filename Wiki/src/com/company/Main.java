package com.company;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your request: ");
        String request = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch="+'"'+URLEncoder.encode(scanner.nextLine(), StandardCharsets.UTF_8)+'"';
        new NewThread(request).start();
    }
}
