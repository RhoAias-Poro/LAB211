package entity;


public enum BaseType {
    BIN, DEC, HEX;

    public static BaseType inputNumberAndCovertBase(int input) throws Exception {
        return switch (input) {
            case 1 -> BaseType.BIN;
            case 2 -> BaseType.DEC;
            case 3 -> BaseType.HEX;
            default -> throw new Exception("Please enter in the menu");
        };
    }

    public int getIntbyType() {
        return switch (this) {
            case BIN -> 2;
            case DEC -> 10;
            case HEX -> 16;
            default -> throw new AssertionError();
        };
    }
}
