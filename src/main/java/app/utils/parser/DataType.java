package app.utils.parser;

enum DataType {
    INTEGER("Integers", "integers.txt"),
    FLOAT("Floats", "floats.txt"),
    STRING("Strings", "strings.txt");

    private final String label;
    private final String fileName;

    DataType(String label, String fileName) {
        this.label = label;
        this.fileName = fileName;
    }

    public String getLabel() {
        return label;
    }

    public String getFileName() {
        return fileName;
    }
}
