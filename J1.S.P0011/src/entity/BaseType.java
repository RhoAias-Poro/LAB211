package entity;

public class BaseType {

    private baseType t;

    public BaseType() {

    }

    public baseType getBaseType() {
        return t;
    }

    public void setBaseType(baseType t) {
        this.t = t;
    }

    public enum baseType {
        BIN, DEC, HEX;

        public int getIntbyType() {
            switch (this) {
                case BIN:
                    return 2;
                case DEC:
                    return 10;
                case HEX:
                    return 16;
                default:
                    throw new AssertionError();
            }
        }
    }
}
