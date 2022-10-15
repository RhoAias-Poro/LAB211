package controller;

import bo.BaseConvert;
import bo.BaseInputer;
import entity.BaseType.baseType;

public class BaseConverterController {

    private baseType originalType;
    private BaseInputer input;
    private BaseConvert convert;

    public BaseConverterController() {
        input = new BaseInputer();
        convert = new BaseConvert();
    }

    public String inputNumberAndBase(baseType convertType) {
        String originalNumber = "";
        originalType = input.inputNumberAndCovertBase();
        originalNumber = input.inputNumberByBase(originalType);
        return convert.convertToOutput(originalNumber, originalType, convertType);
    }
}
