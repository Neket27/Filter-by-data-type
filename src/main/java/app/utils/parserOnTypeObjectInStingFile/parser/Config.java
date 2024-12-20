package app.utils.parserOnTypeObjectInStingFile.parser;

import java.util.ArrayList;
import java.util.List;

class Config {
    private String outputPath = "";
    private String prefix = "";
    private boolean appendMode = false;
    private boolean fullStats = false;
    private List<String> inputFiles = new ArrayList<>();



    static Config parseArguments(String[] args) {
        Config config = new Config();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if (i + 1 < args.length) config.outputPath = args[++i];
                    break;
                case "-p":
                    if (i + 1 < args.length) config.prefix = args[++i];
                    break;
                case "-a":
                    config.appendMode = true;
                    break;
                case "-s":
                    config.fullStats = false;
                    break;
                case "-f":
                    config.fullStats = true;
                    break;
                default:
                    config.inputFiles.add(args[i]);
            }
        }
        return config;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isAppendMode() {
        return appendMode;
    }

    public boolean isFullStats() {
        return fullStats;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }
}
