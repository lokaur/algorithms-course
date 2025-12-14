package me.lokaur.algorithms;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import static java.util.stream.Collectors.*;

public class Streams {

    public static String convertToOneLine(List<String> input) {
        ConcurrentMap<Integer, List<String>> resultMap = input.stream()
                .parallel()
                .map(String::trim) // убираем незначащие пробелы
                .filter(s -> !s.isBlank()) // отбрасываем пустые строки
                .map(s -> s.split(":", 2)) // делим строку на 2 части по первому ':'
                .filter(parts -> parts.length == 2 && !parts[1].isBlank() && parts[1].matches("\\d+")) // отбрасываем людей без номера или с некорректным номером
                .collect(groupingByConcurrent(
                        parts -> Integer.parseInt(parts[1]), // группируем в мап, где ключ - номер человека
                        mapping(
                                parts -> capitalizeFirstLetter(parts[0]), // значение - список людей с исправленными именами
                                collectingAndThen(
                                        toList(),
                                        list -> list.stream().sorted().toList() // сортировка чтобы параллельное выполнение не влияло на конечный результат
                                )
                        )
                ));

        // для проверки в тестах, преобразовываю мап в строку
        return resultMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())) // сортируем номера от большего к меньшему
                .map(e -> e.getKey() + ":[" + String.join(", ", e.getValue()) + "]")
                .collect(joining(", ", "[", "]"));
    }

    private static String capitalizeFirstLetter(String input) {
        var lower = input.toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
}
