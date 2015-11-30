package dk.dtu.student.programanalysis.implementation;

/**
 * Created by ruimartins on 29/11/2015.
 */
public enum OPERAND{
    ADDITION(0),
    SUBTRACTION(1),
    DIVISION(2),
    MULTIPLICATION(3);

    private final int value;

    OPERAND(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
