class Number {

    private int value;
    private ArabRome type;

    Number(int value, ArabRome type) {
        this.value = value;
        this.type = type;
    }

    int getValue() {
        return value;
    }

    ArabRome getType() {
        return type;
    }
}
