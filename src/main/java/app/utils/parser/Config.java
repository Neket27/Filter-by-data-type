package app.utils.parser;

import java.util.ArrayList;
import java.util.List;

class Config {
    String outputPath = "";
    String prefix = "";
    boolean appendMode = false;
    boolean fullStats = false;
    List<String> inputFiles = new ArrayList<>();

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
}
