package app.utils.parserOnTypeObjectInStingFile.parser;

import app.utils.parserOnTypeObjectInStingFile.typeData.TypeNumber;
import app.utils.parserOnTypeObjectInStingFile.typeData.TypeNumberOrString;
import app.utils.parserOnTypeObjectInStingFile.typeData.TypeString;

import java.util.Collections;
import java.util.List;

class Statistics<T extends TypeNumberOrString> {
    private final List<T> data;

    Statistics(List<T> data) {
        this.data = data;
    }

    void print(String label, boolean fullStats) {
        if (data.isEmpty()) {
            System.out.println(label + ": No data");
            return;
        }

        System.out.println(label + ": Count = " + data.size());

        if (fullStats) {
            if (data.get(0) instanceof TypeNumber) {
                printNumericStats(data.stream()
                        .map(e -> ((TypeNumber) e).getValue())
                        .toList());
            } else if (data.get(0) instanceof TypeString) {
                printStringStats(data.stream()
                        .map((e)->((TypeString)e).getValue())
                        .toList());
            }
        }
    }

    private void printNumericStats(List<java.lang.Number> numberData) {
        List<Double> numericData = numberData.stream()
                .map(java.lang.Number::doubleValue)
                .toList();

        System.out.println("  Min = " + Collections.min(numericData));
        System.out.println("  Max = " + Collections.max(numericData));
        System.out.println("  Sum = " + numericData.stream().mapToDouble(Double::doubleValue).sum());
        System.out.println("  Avg = " + numericData.stream().mapToDouble(Double::doubleValue).average().orElse(0.0));
    }

    private void printStringStats(List<String> stringData) {
        int minLength = stringData.stream().mapToInt(String::length).min().orElse(0);
        int maxLength = stringData.stream().mapToInt(String::length).max().orElse(0);

        System.out.println("  Min Length = " + minLength);
        System.out.println("  Max Length = " + maxLength);
    }

}
