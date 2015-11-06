package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.IStatement;

/**
 * Created by dx on 9/21/15.
 */
public class StatementWrite extends Statement {

    public StatementWrite(IStatement parent) {
        super(parent);
    }

    @Override
    public String getType() {
        return "write";
    }

    @Override
    public IStatement createInstance(IStatement parent) {
        return new StatementWrite(parent);
    }

    @Override
    public void parse() {

    }
}
