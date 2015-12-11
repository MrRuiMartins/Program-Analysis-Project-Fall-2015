package dk.dtu.student.programanalysis.implementation.analysistype;

import dk.dtu.student.programanalysis.implementation.IAnalysisType;

/**
 * Created by dx on 12/10/15.
 */
public class ReachingDefinitionAnalysisType implements IAnalysisType {

    public static final int ANYWHERE = Integer.MAX_VALUE;

    private int lineNumber;
    private String symbol;

    public ReachingDefinitionAnalysisType(int lineNumber, String symbol) {
        this.lineNumber = lineNumber;
        this.symbol = symbol;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "(" + symbol + " , " + lineNumber + ")";
    }
}
