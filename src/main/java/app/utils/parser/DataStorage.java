package app.utils.parser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DataStorage {
    private final List<Long> integers = new ArrayList<>();
    private final List<Double> floats = new ArrayList<>();
    private final List<String> strings = new ArrayList<>();
    private final TypeChecker typeChecker = new TypeChecker();

    void addData(String line) {
        if (typeChecker.isInteger(line)) {
            integers.add(Long.parseLong(line));
        } else if (typeChecker.isFloat(line)) {
            floats.add(Double.parseDouble(line));
        } else {
            strings.add(line);
        }
    }

    void writeToFile(String filePath, DataType type, boolean append) throws IOException {
        List<?> data = getDataByType(type);
        if (data.isEmpty()) return;

        try (FileWriter writer = new FileWriter(filePath, append)) {
            for (Object item : data) {
                writer.write(item.toString() + System.lineSeparator());
            }
        }
    }

    void printStatistics(boolean fullStats) {
        for (DataType type : DataType.values()) {
            Statistics statistics = new Statistics(getDataByType(type));
            statistics.print(type.getLabel(), fullStats);
        }
    }

    private List<?> getDataByType(DataType type) {
        return switch (type) {
            case INTEGER -> integers;
            case FLOAT -> floats;
            case STRING -> strings;
        };
    }
}
