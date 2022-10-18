package entity;

public class BaseType {

    private Base t;

    public BaseType() {

    }

    public Base getBaseType() {
        return t;
    }

    public void setBaseType(Base t) {
        this.t = t;
    }

    public enum Base {
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
