package ru.t1.education;

public class Node {

    /**
     * Массив дочерних элементов.
     * Для оптимизации делаем массив под весь алфавит a-z.
     * Таким образом, сможем получать ребенка за O(1).
     */
    public Node[] children = new Node[26];

    /**
     * Признак явного ключа (конца слова).
     */
    public boolean isEvenKey = false;

    /**
     * Проверяет наличие дочернего элемента.
     *
     * @param c символ
     * @return признак наличия
     */
    public boolean hasChild(char c) {
        return children[getChildIndex(c)] != null;
    }

    /**
     * Добавляет дочерний элемент.
     *
     * @param c символ
     */
    public void addChild(char c) {
        children[getChildIndex(c)] = new Node();
    }

    /**
     * Возвращает дочерний элемент.
     *
     * @param c символ
     * @return дочерний элемент
     */
    public Node getChild(char c) {
        return children[getChildIndex(c)];
    }

    private static int getChildIndex(char c) {
        // Вычисляем позицию элемента в массиве (по нумерации алфавита)
        return c - 'a';
    }
}
