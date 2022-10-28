package controller;

import bo.BaseConvert;
import bo.BaseInputer;
import entity.BaseType;

public class BaseConverterController {

    private BaseType originalType;
    private BaseType convertType;
    private BaseConvert convert;


    public BaseConverterController() {
        convert = new BaseConvert();
    }

    public String inputNumberAndBase(int originalChoice, int convertChoice, String originalNumber) throws Exception {
        originalType = BaseInputer.inputMenuAndCovertBase(originalChoice);
        convertType = BaseInputer.inputMenuAndCovertBase(convertChoice);
        return convert.convertToOutput(originalNumber, originalType, convertType);
    }
}
