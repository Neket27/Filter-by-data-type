package app.utils.parser;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class DataProcessor {
    private final Config config;
    private final DataStorage dataStorage;

    DataProcessor(Config config) {
        this.config = config;
        this.dataStorage = new DataStorage();
    }

    void processFiles() {
        for (String fileName : config.getInputFiles()) {
            try {
                List<String> lines = Files.readLines(new File(fileName), StandardCharsets.UTF_8);
                lines.forEach(dataStorage::addData);
            } catch (IOException e) {
                System.err.println("Failed to read file: " + fileName + " - " + e.getMessage());
            }
        }
    }

    void writeResults() {
        try {
            for (DataType type : DataType.values()) {
                dataStorage.writeToFile(getOutputFilePath(type.getFileName()), type, config.isAppendMode());
            }
        } catch (IOException e) {
            System.err.println("Failed to write output files: " + e.getMessage());
        }
    }

    void printStatistics() {
        dataStorage.printStatistics(config.isFullStats());
    }

    private String getOutputFilePath(String fileName) {
        Path path = config.getOutputPath().isEmpty() ? Paths.get(config.getPrefix() + fileName) : Paths.get(config.getOutputPath(), config.getPrefix() + fileName);
        return path.toString();
    }
}
