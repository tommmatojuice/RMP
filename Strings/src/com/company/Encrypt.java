package com.company;

import java.util.Arrays;

public class Encrypt {
    private String text;
    private Integer[]  key;
    private int length;

    public Encrypt(String text, String key) {
        this.text = text;
        this.length = text.length();

        this.key = new Integer[key.length()];
        int i=0;
        for (Character c: key.toCharArray()) {
            this.key[i] = (int)c - 1071;
            i++;
        }
        Integer[] newKeyCopy = this.key.clone();
        Arrays.sort(newKeyCopy);
        for (i=0; i<this.key.length; i++)
            this.key[i] = Arrays.asList(newKeyCopy).indexOf(this.key[i])+1;
    }

    public void toEncrypt(){
        String result = "";
        for (int i = 0; i < text.length() % key.length; i++)
            text += text.toCharArray()[i];
        for (int i = 0; i < text.length(); i += this.key.length) {
            Character[] transposition = new Character[this.key.length];
            for (int j = 0; j < this.key.length; j++)
                transposition[this.key[j] - 1] = text.toCharArray()[i + j];
            for (int j = 0; j < this.key.length; j++)
                result += transposition[j];

        }
        this.text = result;
    }

    public void toDecrypt() {
        String result = "";
        for (int i = 0; i < text.length(); i += key.length) {
            char[] transposition = new char[key.length];
            for (int j = 0; j < key.length; j++)
                transposition[j] = text.toCharArray()[i + key[j] - 1];
            for (int j = 0; j < key.length; j++)
                result += transposition[j];
        }
        this.text = result;
        text = text.substring(0, length);
    }

    @Override
    public String toString() {
        return "Encrypt{" +
                "text='" + text + '\'' +
                '}';
    }
}
