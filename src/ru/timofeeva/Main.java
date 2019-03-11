package ru.timofeeva;

import java.io.FileWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("or");
        list.add("ice");
        list.add("word");
        list.add("pizza");
        list.add("museum");
        list.add("balcony");
        list.add("constant");
        list.add("september");
        list.add("apartments");

        System.out.println("\t Test case: Формируем файл из слов.");
        writeText(list, 10000, "MyFile.txt");


        WordList wordList = new WordList();

        System.out.println("\t Test case: Считываем файл.");
        wordList.readText("MyFile.txt");

        System.out.println("\t Test case: Сортируем коллекцию.");
        wordList.sortWordList(null);

        System.out.println("\t Test case: Выводим на печать статистику.");
        wordList.gatherStatistic();
        wordList.printStatistics();

        System.out.println("\t Test case: Cортируем коллекцию в алфавитном порядке.");

        System.out.println("\t Test case: Выводим слово с максимальным количеством повторений.");
        wordList.printMaxValueInMap();

        System.out.println("\t Test case: Выводим среднее значение длины слов.");
        wordList.getAverage();

        System.out.println("\t Test case: Сортируем коллекцию  по длине.");
        wordList.sortWordList(new WordListComparator());

        System.out.println("\t Test case: Выводим медиану.");
        wordList.getMedian();

        System.out.println("\t Test case: Зписываем файл.");
        wordList.writeList("SortList.txt");

    }

    /*
     *Создаем метод для создания файла формата txt.
     */
    public static void writeText(List<String> wordList, int count, String file) throws Exception {
        FileWriter fileRandom = null;
        try {
            fileRandom = new FileWriter(file);
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                int random1 = random.nextInt(wordList.size());
                fileRandom.write(wordList.get(random1) + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (fileRandom != null) {
                fileRandom.close();
            }

        }
    }
}







