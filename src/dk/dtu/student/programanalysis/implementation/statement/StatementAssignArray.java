package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.implementation.ArithmeticExpression;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created by dx on 11/14/15.
 */
public class StatementAssignArray extends BaseStatement {

    private ArithmeticExpression expression;

    @Override
    public void parseTreeNode() {
        ParserRuleContext context = (ParserRuleContext) this.userObject;
        expression = (ArithmeticExpression) getChildAt(1);
        expression.setUserObject(context.getChild(2));
        expression.parseTreeNode();
    }

    public ArithmeticExpression getExpression() {
        return expression;
    }
}
