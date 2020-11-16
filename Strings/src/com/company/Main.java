package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //1
//        List<String> strings = Arrays.asList("dddddddddddd", "ggggg", "hhhhhhhhhh", "aaaaaaa");
//        System.out.println(LongestLine(strings));

        //2
//        System.out.println(IsPalindrome("закаg"));

        //3
//        System.out.println(Сensorship("Апельсины, бяка, лимонты, яблоки"));

        //4
//        System.out.println(StringCount("Апельсины, лимоны, яблоки, груши, лимоны", "лимоны"));

        //5
//        System.out.println(WordsInversion("This is a test string"));

        //6
//        System.out.println(FrequencyDictionary("file.txt"));

        //7
        Encrypt string1 = new Encrypt("враг будет разбит", "памир");
        string1.toEncrypt();
        System.out.println(string1);
        string1.toDecrypt();
        System.out.println(string1);

        Encrypt string2 = new Encrypt("Раз в неделю ему позволяли ночевать не в домике по соседству", "дом");
        string2.toEncrypt();
        System.out.println(string2);
        string2.toDecrypt();
        System.out.println(string2);
    }

    //1 - Поиск самой длинной строки
    public static String LongestLine(List<String> Str){
        int largestString = Str.get(0).length(), index = 0;
        for(int i = 0; i < Str.size(); i++) {
            if(Str.get(i).length() > largestString) {
                largestString = Str.get(i).length();
                index = i;
            }
        }
        return Str.get(index);
    }

    //2 - Слово-палиндром
    public static boolean IsPalindrome(String word){
        return word.equals(new StringBuilder(word).reverse().toString());
    }

    //3 - Цензцра
    public static String Сensorship(String str){
        return str.replaceAll("бяка", "[вырезано цензурой]");
    }

    //4 - Вхождение подстроки в строку
    public static int StringCount(String main, String str){
        return (main.length() - main.replace(str, "").length()) / str.length();
    }

    //5 - Инверсия слов в строке
    public static String WordsInversion(String str){
        String[] newStr = str.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < newStr.length; i++) {
            StringBuilder newWord = new StringBuilder(newStr[i]);
            newStr[i] = newWord.reverse().toString();
            result.append(newStr[i]).append(" ");
        }
        return result.toString();
    }

    //6 - Частотный словать русского алфавита
    public static Map<Character, Integer> FrequencyDictionary(String file) throws IOException {
        char[] result = new String(Files.readAllBytes(Paths.get(file)), "UTF-8").toLowerCase().toCharArray();
        Map<Character, Integer> vacabulary = new HashMap<>();
        for (char c : result) {
            if (c > 191) {
                if (vacabulary.containsKey(c))
                    vacabulary.put(c, vacabulary.get(c) + 1);
                else
                    vacabulary.put(c, 1);
            }
        }
        return vacabulary;
    }
}
