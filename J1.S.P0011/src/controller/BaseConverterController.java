package controller;

import bo.BaseConvert;
import entity.BaseType;

public class BaseConverterController {

    private BaseType originalType;
    private BaseType convertType;
    private BaseConvert convert;


    public BaseConverterController() {
        convert = new BaseConvert();
    }

    public String inputNumberAndBase(int originalChoice, int convertChoice, String originalNumber) throws Exception {
        originalType = BaseType.inputNumberAndCovertBase(originalChoice);
        convertType = BaseType.inputNumberAndCovertBase(convertChoice);
        return convert.convertToOutput(originalNumber, originalType, convertType);
    }
}
