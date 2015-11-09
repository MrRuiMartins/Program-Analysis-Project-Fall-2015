package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.IStatement;
import dk.dtu.student.programanalysis.implementation.BaseStatement;

/**
 * Created by dx on 9/21/15.
 */
public class StatementRead extends BaseStatement {

    public StatementRead(IStatement parent) {
        super(parent);
    }

    @Override
    public String getType() {
        return "read";
    }

    @Override
    public IStatement createInstance(IStatement parent) {
        return new StatementRead(parent);
    }

    @Override
    public void parse() {

    }
}
