package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.IStatement;
import dk.dtu.student.programanalysis.implementation.BaseStatement;

/**
 * Created by dx on 9/21/15.
 */
public class StatementSkip extends BaseStatement {

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
