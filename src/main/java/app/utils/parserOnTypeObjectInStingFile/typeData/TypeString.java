package app.utils.parserOnTypeObjectInStingFile.typeData;

public class TypeString implements TypeNumberOrString {
    private final String value;

    public TypeString(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}