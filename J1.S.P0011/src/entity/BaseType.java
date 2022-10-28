package entity;


public enum BaseType {
    BIN, DEC, HEX;

    public int getIntbyType() {
        return switch (this) {
            case BIN -> 2;
            case DEC -> 10;
            case HEX -> 16;
            default -> throw new AssertionError();
        };
    }
}
