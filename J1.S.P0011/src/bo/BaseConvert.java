package bo;

import entity.BaseType;

import java.math.BigInteger;


public class BaseConvert {
    private static final String NUMBER_BASE_STRING = "0123456789ABCDEF";

    private BigInteger baseToDec(String input, BaseType base) {
        BigInteger ret = BigInteger.ZERO;
        for (int i = 0; i < input.length(); i++) {
            ret = ret.add(BigInteger.valueOf((long) (NUMBER_BASE_STRING.indexOf(input.charAt(i)) * Math.pow(base.getIntbyType(), input.length() - i - 1))));
        }
        return ret;
    }

    private String decToBase(BigInteger input, BaseType base) {
        BigInteger baseBig = new BigInteger(String.valueOf(base.getIntbyType()));
        String ret = "";
        while (input.compareTo(BigInteger.ZERO) > 0) {
            ret += NUMBER_BASE_STRING.charAt(input.remainder(baseBig).intValue());
            input = input.divide(baseBig);
        }
        StringBuilder sb = new StringBuilder(ret);
        return sb.reverse().toString();
    }

//    private String checkType(BaseType type) throws Exception {
//        String regex = "";
//        switch (type) {
//            case BIN:
//                regex = "[0-1]+";
//                break;
//            case DEC:
//                regex = "[0-9]+";
//                break;
//            case HEX:
//                regex = "[0-9a-fA-F]+";
//                break;
//            default:
//                throw new Exception("Invalid base type");
//        }
//        return regex;
//    }

    private boolean checkInputByType(String input, BaseType type) {
        input = input.toUpperCase();
        String baseDigit = NUMBER_BASE_STRING.substring(0, type.getIntbyType());
        for (int i = 0; i < input.length(); i++) {
            String charAt = input.charAt(i) + "";
            if (!baseDigit.contains(charAt)) {
                return false;
            }
        }
        return true;
    }

    public String convertToOutput(String numString, BaseType originalType, BaseType convertType) throws Exception {
        if (originalType.equals(convertType)) {
            numString = numString.replaceAll("^0+", "");
            if (numString.isEmpty()) return "0";
            return numString;
        }
        if (!checkInputByType(numString, originalType))
            throw new Exception("Please enter a valid number of the base type");
        return decToBase(baseToDec(numString.toUpperCase(), originalType), convertType);
    }

//    private String binToHex(String numString) {
//        return decToBase(baseToDec(numString, baseType.BIN), baseType.HEX);
//    }
//
//    private String binToDec(String numString) {
//        return decToBase(baseToDec(numString, baseType.BIN), baseType.DEC);
//    }
//
//    private String decToHex(String numString) {
//        return decToBase(baseToDec(numString, baseType.DEC), baseType.HEX);
//    }
//
//    private String decToBin(String numString) {
//        return decToBase(baseToDec(numString, baseType.DEC), baseType.BIN);
//    }
//
//    private String hexToBin(String numString) {
//        return decToBase(baseToDec(numString, baseType.HEX), baseType.BIN);
//    }
//
//    private String hexToDec(String numString) {
//        return decToBase(baseToDec(numString, baseType.HEX), baseType.DEC);
//    }
}
