package bo;

import entity.BaseType;

public class BaseInputer {
    public static BaseType inputMenuAndCovertBase(int input) throws Exception {
        return switch (input) {
            case 1 -> BaseType.BIN;
            case 2 -> BaseType.DEC;
            case 3 -> BaseType.HEX;
            default -> throw new Exception("Please enter in the menu");
        };
    }
}
