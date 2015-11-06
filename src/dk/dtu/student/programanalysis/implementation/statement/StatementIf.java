package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.IStatement;

/**
 * Created by dx on 9/21/15.
 */
public class StatementIf extends Statement {

    public StatementIf(IStatement parent) {
        super(parent);
    }

    @Override
    public String getType() {
        return "if";
    }

    @Override
    public IStatement createInstance(IStatement parent) {
        return new StatementIf(parent);
    }

    @Override
    public void parse() {

    }
}
