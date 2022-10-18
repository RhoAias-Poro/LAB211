package controller;

import bo.BaseConvert;
import bo.BaseInputer;
import entity.BaseType.Base;

public class BaseConverterController {

    private Base originalType;
    private Base convertType;
    private BaseInputer input;
    private BaseConvert convert;

    public BaseConverterController() {
        input = new BaseInputer();
        convert = new BaseConvert();
    }

    public String inputNumberAndBase(int originalChoice, int convertChoice, String originalNumber) throws Exception {
        originalType = input.inputNumberAndCovertBase(originalChoice);
        convertType = input.inputNumberAndCovertBase(convertChoice);
        return convert.convertToOutput(originalNumber, originalType, convertType);
    }
}
