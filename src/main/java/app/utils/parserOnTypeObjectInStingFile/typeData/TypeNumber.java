package app.utils.parserOnTypeObjectInStingFile.typeData;

public class TypeNumber implements TypeNumberOrString {
    private final java.lang.Number value;

    public TypeNumber(java.lang.Number value) {
        this.value = value;
    }

    @Override
    public java.lang.Number getValue() {
        return value;
    }
}