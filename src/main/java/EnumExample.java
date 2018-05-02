/**
 * Created by amit.k.mannur on 4/23/2018.
 */

public enum EnumExample {
    INSTANCE;

    int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
