package app.utils.parserOnTypeObjectInStingFile.parser;

import app.utils.parserOnTypeObjectInStingFile.typeData.TypeNumberOrString;
import app.utils.parserOnTypeObjectInStingFile.typeData.TypeNumber;
import app.utils.parserOnTypeObjectInStingFile.typeData.TypeString;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<TypeNumberOrString> listData = getDataByType(type);
        if (listData.isEmpty()) return;

        try (FileWriter writer = new FileWriter(filePath, append)) {
            for (TypeNumberOrString item : listData) {
                writer.write(item.getValue().toString() + System.lineSeparator());
            }
        }
    }

    void printStatistics(boolean fullStats) {
        for (DataType type : DataType.values()) {
            Statistics<TypeNumberOrString> statistics = new Statistics<>(getDataByType(type));
            statistics.print(type.getLabel(), fullStats);
        }
    }

    private List<TypeNumberOrString> getDataByType(DataType type) {
        return switch (type) {
            case INTEGER -> integers.stream().map(e -> new TypeNumber(e)).collect(Collectors.toList());
            case FLOAT -> floats.stream().map(e -> new TypeNumber(e)).collect(Collectors.toList());
            case STRING -> strings.stream().map(e -> new TypeString(e)).collect(Collectors.toList());
        };
    }
}
