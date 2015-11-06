package dk.dtu.student.programanalysis;

import org.antlr.runtime.CommonToken;

/**
 * Created by dx on 9/21/15.
 */
public interface IStatement {

    public String getType();

    public IStatement getParent();

    public IStatement createInstance(IStatement parent);

    public void setStartToken(CommonToken start);

    public void setEndToken(CommonToken end);

    public void parse();
}
