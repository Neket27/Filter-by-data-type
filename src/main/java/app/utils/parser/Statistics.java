package app.utils.parser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Statistics {
    private final List<?> data;

    Statistics(List<?> data) {
        this.data = data;
    }

    void print(String label, boolean fullStats) {
        if (data.isEmpty()) {
            System.out.println(label + ": No data");
            return;
        }

        System.out.println(label + ": Count = " + data.size());

        if (fullStats && !data.isEmpty()) {
            if (data.get(0) instanceof Number) {
                printNumericStats();
            } else if (data.get(0) instanceof String) {
                printStringStats();
            }
        }
    }

    private void printNumericStats() {
        List<Double> numericData = data.stream()
                .map(x -> ((Number) x).doubleValue())
                .collect(Collectors.toList());

        System.out.println("  Min = " + Collections.min(numericData));
        System.out.println("  Max = " + Collections.max(numericData));
        System.out.println("  Sum = " + numericData.stream().mapToDouble(Double::doubleValue).sum());
        System.out.println("  Avg = " + numericData.stream().mapToDouble(Double::doubleValue).average().orElse(0.0));
    }

    private void printStringStats() {
        List<String> stringData = (List<String>) data;
        int minLength = stringData.stream().mapToInt(String::length).min().orElse(0);
        int maxLength = stringData.stream().mapToInt(String::length).max().orElse(0);

        System.out.println("  Min Length = " + minLength);
        System.out.println("  Max Length = " + maxLength);
    }
}
