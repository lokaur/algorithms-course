package ru.t1.education;

import java.util.List;

public class Trie {

    private final Node root = new Node();

    public Boolean search(String word) {
        // Берем корень дерева
        Node node = root;

        // Идем посимвольно
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // Выходим, если нужного элемента нет
            if (!node.hasChild(c)) {
                return false;
            }

            // Переходим на дочерний элемент
            node = node.getChild(c);
        }

        // Если ключ является явным - искомое слово найдено
        return node.isEvenKey;
    }

    public List<String> startWith(String prefix) {
        return List.of(); // TODO реализация поиска по префиксу
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
}
