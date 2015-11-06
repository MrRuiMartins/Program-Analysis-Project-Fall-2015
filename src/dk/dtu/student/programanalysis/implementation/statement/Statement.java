package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.IStatement;
import org.antlr.runtime.CommonToken;

/**
 * Created by dx on 11/5/15.
 */
public abstract class Statement implements IStatement {

    protected CommonToken start, end;
    protected IStatement parent;

    protected Statement(IStatement parent) {
        this.parent = parent;
    }

    @Override
    public IStatement getParent() {
        return parent;
    }

    @Override
    public void setStartToken(CommonToken start) {
        this.start = start;
    }

    @Override
    public void setEndToken(CommonToken end) {
        this.end = end;
    }
}
