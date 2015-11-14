package dk.dtu.student.programanalysis.implementation.label;

import dk.dtu.student.programanalysis.implementation.Label;

/**
 * Created by dx on 11/12/15.
 */
public class LabelLine extends Label {

    private String symbol;
    private int lineNumber;

    public LabelLine(String symbol, int lineNumber) {
        this.symbol = symbol;
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "(" + symbol + " , " + lineNumber + ")";
    }
}