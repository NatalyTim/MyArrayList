package ru.timofeeva;


import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
/**
 * @author Timofeeva Natalia
 * @see #readText(String)
 * @see #sortWordList(Comparator)
 * @see #printList()
 * @see #gatherStatistic()
 * @see #printStatistics()
 * @see #printMaxValueInMap()
 * @see #countWords()
 * @see #getAverage()
 * @see #getMedian()
 * @see #writeList(String)
 */

public class WordList {
    private List<String> wordList = new ArrayList<>();
    private Map<String, Integer> statistics;

    /*
     *Создаем метод для чтения файла.
     */
    public void readText(String file) throws Exception {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            wordList = new ArrayList<>();
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNext()) {
                String word = scan.useDelimiter(" ").next();
                wordList.add(word);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

    }

    /*
     *Создаем метод для сортировки слов в алфавитном порядке.
     */
    public void sortWordList(Comparator<String> comparator) {
        if (comparator == null) {
            Collections.sort(this.wordList);
        } else {
            Collections.sort(this.wordList, comparator);
        }
    }

    /*
     * Создаем метод для вывода коллекции.
     */
    public void printList() {
        for (String s : wordList) {
            System.out.println(s);
        }
    }

    /*
     * Создаем метод для вывода коллекции.
     */
    public Map<String, Integer> gatherStatistic() {
        statistics = countWords();
        return statistics;
    }

    /*
     * Создаем метод для вывода статистики.
     */
    public void printStatistics() {
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.print("Key: " + entry.getKey() + " Value: " + entry.getValue() + "\n");
        }
    }

    /*
     *Создаем метод для вывода слова с максимальным количеством повторений.
     */
    public void printMaxValueInMap() {
        int maxValueInMap = Collections.max(statistics.values());
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                System.out.println("The word " + entry.getKey() + " has the maximum number of repetitions - "
                        + entry.getValue() + ".");
            }
        }
    }

    /*
     *Создаем метод для вывода статистики по количеству слов.
     */
    private Map<String, Integer> countWords() {
        Map<String, Integer> quantityWords = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {
            if (quantityWords.get(wordList.get(i)) != null) {
                quantityWords.put(wordList.get(i), quantityWords.get(wordList.get(i)) + 1);
            } else {
                quantityWords.put(wordList.get(i), 1);
            }
        }
        return quantityWords;
    }

    /*
     *Находим среднее значение.
     */
    public double getAverage() {
        double average = 0.0;
        double sum = 0;
        double countElements = wordList.size();
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            sum += entry.getKey().length() * entry.getValue();
        }
        average = sum / countElements;
        System.out.println("The average value is: " + average);
        return average;
    }

    /*
     *Создаем метод для создания файла отсортированного массива.
     */
    public void writeList(String fileName) throws Exception {
        FileWriter file = null;
        try {
            file = new FileWriter(fileName);
            for (int i = 0; i < wordList.size(); i++) {
                file.write(wordList.get(i) + " ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (file != null) {
                file.close();
            }
        }

    }

    /*
     *Находим медиану.
     */
    public double getMedian() {
        double median;
        int len = wordList.size();
        if (len % 2 != 0) {
            median = wordList.get((len / 2) + 1).length();
        } else {
            median = ((wordList.get((len / 2) - 1)).length() + wordList.get((len / 2 + 1)).length()) / 2;
        }
        System.out.println("The median of words is: " + median);
        return median;
    }


}




