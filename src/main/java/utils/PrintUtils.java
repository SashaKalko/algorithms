package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintUtils {

    private static String repeat(String s, int len) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.iterate(0, x -> ++x).limit(len).forEach(x -> stringBuilder.append(s));
        return stringBuilder.toString();
    }

    private static String addSpaces(String field, int len) {
        return field + repeat(" ", len - field.length());
    }

    private static String formatValues(Map<String, Integer> max, String field, String nextField) {
        Integer maxField = max.get(field);
        Integer maxNextField = max.get(nextField);
        if (maxField == null) {
            maxField = field.length();
        }
        return String.format("%s | %s", addSpaces(field, maxField), addSpaces(nextField, maxNextField));
    }

    private static String formatValues(Map<String, Integer> max, Map<String, Object> row, String field, String nextField) {
        Integer maxField = max.get(field);
        Integer maxNextField = max.get(nextField);
        if (maxField == null) {
            maxField = field.length();
        } else {
            field = row.get(field).toString();
        }
        nextField = row.get(nextField).toString();
        return String.format("%s | %s", addSpaces(field, maxField), addSpaces(nextField, maxNextField));
    }

    public static void printTable(List<Map<String, Object>> rows, List<String> header) {
        Map<String, Integer> max = rows.stream()
                .map(m -> m.entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                e -> Math.max(e.getKey().length(), e.getValue().toString().length()))))
                .reduce((row, rowNext) -> row.entrySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                e -> Math.max(e.getValue(), rowNext.get(e.getKey())))))
                .get();
        List<String> table = new ArrayList<>();
        rows.forEach(row -> {
            if (table.isEmpty()) {
                String head = "| " + header.stream().reduce((total, nextField) -> formatValues(max, total, nextField)).get() + " |";
                String splitLine = "+" + repeat("-", head.length() - 2) + "+";
                table.add(splitLine);
                table.add(head);
                table.add(splitLine);
            }
            table.add("| " + header.stream().reduce((total, nextField) -> formatValues(max, row, total, nextField)).get() + " |");
        });
        if (!table.isEmpty()) {
            table.add(table.get(0));
        }
        table.forEach(System.out::println);
    }

}