package dk.dtu.student.programanalysis.implementation.label;

import dk.dtu.student.programanalysis.implementation.ArithmeticExpression;
import dk.dtu.student.programanalysis.implementation.Label;

/**
 * Created by ruimartins on 29/11/2015.
 */
public class LabelDS extends Label {
    private String symbol;
    private int lineNumber;
    private ArithmeticExpression expression;
    private ArithmeticExpression expression2;

    public static final int LABELLINE_ANYWHERE = Integer.MAX_VALUE;

    public LabelDS(Class statementClass, String symbol, int lineNumber, ArithmeticExpression e) {
        super(statementClass);
        this.symbol = symbol;
        this.lineNumber = lineNumber;
        this.expression = e;
    }
    public LabelDS(Class statementClass, String symbol, int lineNumber, ArithmeticExpression e, ArithmeticExpression e2) {
        super(statementClass);
        this.symbol = symbol;
        this.lineNumber = lineNumber;
        this.expression = e;
        this.expression2 = e2;
    }
    public LabelDS(Class statementClass, String symbol, int lineNumber) {
        super(statementClass);
        this.symbol = symbol;
        this.lineNumber = lineNumber;
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
    public ArithmeticExpression getExpression() {return expression;}
    public ArithmeticExpression getExpression2() {return expression2;}

    @Override
    public String toString() {
        return "(" + symbol + " , " + lineNumber + ")";
    }
}
