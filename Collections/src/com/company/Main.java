package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        //1
//        System.out.println(FrequencyDictionary("file.txt"));

//        //2
//        List<Integer> numlist = Arrays.asList(1, 2, 5, 9, 11, 1, 5, 7);
//        System.out.println(NoBagels(numlist));

        //3
//        System.out.println(ArrayList());
//        System.out.println(LinkedList());

        //4
//        Map<User, Integer> games = new HashMap<>();
//        games.put(new User("Alice"), 100);
//        games.put(new User("John"), 34);
//        games.put(new User("Kate"), 76);
//        games.put(new User("Oliver"), 54);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please give name: ");
//        String name = scanner.nextLine();
//        System.out.println(GetScore(games, name));

        //5
//        Integer[][] array = {{4, 6, 5}, {3, 7, 9}, {7, 8, 1}, {0, 7}};
//        Iterator<Integer> iterator = new ArrayIterator<>(array);
//        while (iterator.hasNext())
//            System.out.println(iterator.next());

        //6
//        System.out.println(CountElements(new Integer[]{1, 2, 3, 5, 1, 3, 2, 6, 8}));

        //7
//        Map<String, Integer> monthes = new HashMap<>();
//        monthes.put("September", 30);
//        monthes.put("October", 31);
//        monthes.put("November", 30);
//        monthes.put("December", 31);
//        monthes.put("January", 30);
//        monthes.put("February", 31);
//        System.out.println(mapToMap(monthes));
    }

    //1 - Частотный словарь
    public static Map<String, Integer> FrequencyDictionary(String file) throws IOException {
        Map<String, Integer> vacabulary = new HashMap<>();
        String[] words = Files.lines(Paths.get(file)).reduce("", String::concat).split(" ");
        for(int i=0; i<words.length; i++){
            words[i] = words[i].replaceAll("[.,-:;?!]", "");
            if(vacabulary.containsKey(words[i]))
                vacabulary.put(words[i], vacabulary.get(words[i])+1);
            else
                vacabulary.put(words[i], 1);
        }
        return vacabulary;
    }

    //2 - Коллекция без дубликатов
    public static <T> List<T> NoBagels(List<T> Str){
        Set<T> newCollection = new HashSet<>(Str);
        return new ArrayList<T>(newCollection);
    }

    //3 - ArrayList
    public static long ArrayList(){
        List<Integer> Alist = new ArrayList<>();
        for (int i =0; i < 1000000; i++)
            Alist.add((int) Math.round((Math.random() * 1000000) - 500000));
        Random rand = new Random();
        List<Integer> RandList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int randomIndex = rand.nextInt(Alist.size());
            RandList.add(Alist.get(randomIndex));
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    //3 - LinkedList
    public static long LinkedList(){
        List<Integer> Llist = new LinkedList<>();
        for (int i =0; i < 1000000; i++)
            Llist.add((int) Math.round((Math.random() * 1000000) - 500000));
        Random rand = new Random();
        List<Integer> RandList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            int randomIndex = rand.nextInt(Llist.size());
            RandList.add(Llist.get(randomIndex));
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    /*Вывод по 3:
    ArrayList = 17
    LinkedList = 117539
    ArrayList это список, реализованный на основе массива,
    а LinkedList — это классический связный список, основанный на объектах с ссылками между ними.
    Время поиска элемента в ArrayList происходит за постоянное время (так как это массив),
    В LinkedList доступ к произвольному элементу осуществляется за линейное время.*/

    //4 - User's games
    public static int GetScore(Map<User, Integer> games, String name){
        int score = 0;
        for (User key : games.keySet()){
            if(key.getName().equals(name)){
                score = games.get(key);
                break;
            } else {
                score = -1;
            }
        }
        return score;
    }

    //6 - Map<K, Integer>
    public static <T> Map<T, Integer> CountElements(T[] array){
        Map<T, Integer> count = new HashMap<>();
        for(T a:array){
            if (count.containsKey(a))
                count.put(a, count.get(a) + 1);
            else
                count.put(a, 1);
        }
        return count;
    }

    //7 - Map<K, V>
    public static <K, V> Map<V, List<K>> mapToMap(Map<K, V> map){
        Map<V, List<K>> newMap = new HashMap<>();
        for (K key : map.keySet()){
            List<K> list  = new ArrayList<>();
            if(newMap.containsKey(map.get(key)))
                list = newMap.get(map.get(key));
            list.add(key);
            newMap.put(map.get(key), list);
        }
        return newMap;
    }
}
