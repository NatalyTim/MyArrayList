package ru.timofeeva;

import java.util.Comparator;
/**
 * @author Timofeeva Natalia
 * @see #compare(String, String)
 */

public class WordListComparator implements Comparator<String> {
    /*
     *Создаем метод для сравнения элементов массива по длине.
     */
    @Override
    public int compare(String len1, String len2) {
        if (len1.length() == len2.length()) {
            return 0;
        } else if (len1.length() > len2.length()) {
            return 1;
        } else {
            return -1;
        }
    }
}