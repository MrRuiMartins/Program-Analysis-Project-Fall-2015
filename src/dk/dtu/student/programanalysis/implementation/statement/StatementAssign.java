package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.IStatement;

/**
 * Created by dx on 9/21/15.
 */
public class StatementAssign extends Statement {

    public StatementAssign(IStatement parent) {
        super(parent);
    }

    @Override
    public String getType() {
        return "assign";
    }

    @Override
    public IStatement createInstance(IStatement parent) {
        return new StatementAssign(parent);
    }

    @Override
    public void parse() {
        start.setStopIndex(end.getStartIndex() - 2);
        String text = start.getText();
    }
}