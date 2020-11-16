package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NewThread extends Thread{

    private final String request;

    public NewThread(String request) {
        this.request = request;
    }

    public void run(){
        try {
            URLConnection connection = new URL(request).openConnection();
            InputStream stream = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            char[] buffer = new char[256];
            int rc;
            StringBuilder sb = new StringBuilder();
            while ((rc = reader.read(buffer))!=-1)
                sb.append(buffer, 0, rc);
            reader.close();

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Example wiki = gson.fromJson(String.valueOf(sb), Example.class);
            if (wiki.getQuery().getSearch().isEmpty()){
                System.out.println("Нет данных по запросу");
            } else {
                System.out.println(wiki.getQuery());
            }
        } catch(Exception e){
            System.out.println("Неккоректный ввод!");
        }
    }
}
