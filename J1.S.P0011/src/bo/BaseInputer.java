package bo;

import entity.BaseType.Base;

public class BaseInputer {

    private Base type;

    public Base inputNumberAndCovertBase(int input) throws Exception {
        switch (input) {
            case 1:
                type = Base.BIN;
                break;
            case 2:
                type = Base.DEC;
                break;
            case 3:
                type = Base.HEX;
                break;
            default:
                throw new Exception("Please enter in the menu");
        }
        return type;
    }

    public String checkType(Base type) throws Exception {
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
            default:
                throw new Exception("Invalid base type");
        }
        return regex;
    }
}


