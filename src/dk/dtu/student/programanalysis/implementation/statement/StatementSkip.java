package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.IStatement;

/**
 * Created by dx on 9/21/15.
 */
public class StatementSkip extends Statement {

    public StatementSkip(IStatement parent) {
        super(parent);
    }

    @Override
    public String getType() {
        return "skip";
    }

    @Override
    public IStatement createInstance(IStatement parent) {
        return new StatementSkip(parent);
    }

    @Override
    public void parse() {

    }
}
