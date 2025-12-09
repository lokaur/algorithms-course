package ru.t1.education;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private final Node root = new Node();

    public Boolean search(String word) {
        // Нода последнего символа
        Node node = findNode(word);
        // Если ключ явный - нашли слово
        return node != null && node.isEvenKey;
    }

    public List<String> startWith(String prefix) {
        ArrayList<String> result = new ArrayList<>();
        // Нода последнего символа
        Node node = findNode(prefix);
        // Если ее нет - такого начала слова не существует
        if (node == null) {
            return result;
        }
        // Ищем все слова
        findWords(node, new StringBuilder(prefix), result);
        return result;
    }

    public void insert(String word) {
        // Берем корень дерева
        Node node = root;

        // Идем посимвольно
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // Если нет дочернего элемента - создаем
            if (!node.hasChild(c)) {
                node.addChild(c);
            }
            // Переходим на дочерний элемент
            node = node.getChild(c);
        }

        // Отмечаем конец слова
        node.isEvenKey = true;
    }

    private Node findNode(String word) {
        // Берем корень дерева
        Node node = root;

        // Идем посимвольно
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // Если символа нет - выходим
            if (!node.hasChild(c)) {
                return null;
            }

            // Переходим на дочерний элемент
            node = node.getChild(c);
        }
        return node;
    }

    private void findWords(Node node, StringBuilder word, ArrayList<String> result) {
        // Если нода является концом слова, то добавляем слово в результаты
        if (node.isEvenKey) {
            result.add(word.toString());
        }

        // Идем по всем дочерним элементам
        for (int i = 0; i < node.children.length; i++) {
            // Нас интересуют только заполненные элементы
            if (node.children[i] == null) {
                continue;
            }
            // Добавляем символ к результату
            word.append((char) ('a' + i));
            // Рекурсивно ищем слова глубже по дереву
            findWords(node.children[i], word, result);
            // Прошли все ветви с текущим символом. Удаляем его, чтобы пройти по остальным веткам
            word.deleteCharAt(word.length() - 1);
        }
    }
}
