package bo;

import entity.BaseType.baseType;
import utils.utils.IntegerUtils;
import utils.utils.Validations;

public class BaseInputer {

    private baseType type;

    public String inputNumberByBase(baseType type) {
        String regex = checkType(type);
        return Validations.getStringByRegex("Please enter value that you want to convert: ", "Please enter value that satisfy the base you choose", regex);
    }

    public baseType inputNumberAndCovertBase() {
        int input = IntegerUtils.inputBase();
        switch (input) {
            case 1:
                type = baseType.BIN;
                break;
            case 2:
                type = baseType.DEC;
                break;
            case 3:
                type = baseType.HEX;
                break;
        }
        return type;
    }

    public String checkType(baseType type) {
        String regex = "";
        switch (type) {
            case BIN:
                regex = "[0-1]+";
                break;
            case DEC:
                regex = "[0-9]+";
                break;
            case HEX:
                regex = "[0-9a-fA-F]+";
                break;
        }
        return regex;
    }
}


