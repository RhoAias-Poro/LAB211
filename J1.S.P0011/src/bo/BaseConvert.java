package bo;

import entity.BaseType.Base;

import java.math.BigInteger;


public class BaseConvert {
    private static String NUMBER_BASE_STRING = "0123456789ABCDEF";
    private BaseInputer baseInputer = new BaseInputer();

    private BigInteger baseToDec(String input, Base base) {
        BigInteger ret = BigInteger.ZERO;
        for (int i = 0; i < input.length(); i++) {
            ret = ret.add(BigInteger.valueOf((long) (NUMBER_BASE_STRING.indexOf(input.charAt(i)) * Math.pow(base.getIntbyType(), input.length() - i - 1))));
        }
        return ret;
    }

    private String decToBase(BigInteger input, Base base) {
        BigInteger baseBig = new BigInteger(String.valueOf(base.getIntbyType()));
        String ret = "";
        while (input.compareTo(BigInteger.ZERO) > 0) {
            ret += NUMBER_BASE_STRING.charAt(input.remainder(baseBig).intValue());
            input = input.divide(baseBig);
        }
        StringBuilder sb = new StringBuilder(ret);
        return sb.reverse().toString();
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

    public String convertToOutput(String numString, Base originalType, Base convertType) throws Exception {
        if (originalType.equals(convertType)) {
            numString = numString.replaceAll("^0+", "");
            if (numString.isEmpty()) return "0";
            return numString;
        }
        if (!numString.matches(baseInputer.checkType(originalType)))
            throw new Exception("Please enter a valid number of the base type");
        return decToBase(baseToDec(numString.toUpperCase(), originalType), convertType);
    }
}
