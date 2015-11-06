package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.IStatement;

/**
 * Created by dx on 9/21/15.
 */
public class StatementWhile extends Statement {

    public StatementWhile(IStatement parent) {
        super(parent);
    }

    @Override
    public String getType() {
        return "while";
    }

    @Override
    public IStatement createInstance(IStatement parent) {
        return new StatementWhile(parent);
    }

    @Override
    public void parse() {

    }
}
