package dk.dtu.student.programanalysis.implementation;

/**
 * Created by dx on 11/11/15.
 */
public class Label {

    protected String symbol;
    protected int lineNumber;

    private BaseMutableTreeNode node;
    private Class statementClass;

    public Label(Class statementClass, BaseMutableTreeNode node, String symbol, int lineNumber) {
        this.statementClass = statementClass;
        this.node = node;
        this.symbol = symbol;
        this.lineNumber = lineNumber;
    }

    public Class getStatementClass() {
        return statementClass;
    }

    public BaseMutableTreeNode getNode() {
        return node;
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

    @Override
    public String toString() {
        return "(" + symbol + " , " + lineNumber + ")";
    }
}
