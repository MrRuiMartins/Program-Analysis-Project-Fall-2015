package dk.dtu.student.programanalysis;

import dk.dtu.student.programanalysis.implementation.statement.*;

import java.util.HashMap;

/**
 * Created by dx on 9/21/15.
 */
public class StatementFactory {

    HashMap<String, IStatement> statements;

    public StatementFactory() {
        statements = new HashMap<>();

        StatementAssign statementAssign = new StatementAssign(null);
        StatementIf statementIf = new StatementIf(null);
        StatementRead statementRead = new StatementRead(null);
        StatementSkip statementSkip = new StatementSkip(null);
        StatementWhile statementWhile = new StatementWhile(null);
        StatementWrite statementWrite = new StatementWrite(null);

        statements.put(statementAssign.getType(), statementAssign);
        statements.put(statementIf.getType(), statementIf);
        statements.put(statementRead.getType(), statementRead);
        statements.put(statementSkip.getType(), statementSkip);
        statements.put(statementWhile.getType(), statementWhile);
        statements.put(statementWrite.getType(), statementWrite);
    }

    public IStatement createInstance(String type, IStatement parent) {
        return statements.get(type).createInstance(parent);
    }

}
