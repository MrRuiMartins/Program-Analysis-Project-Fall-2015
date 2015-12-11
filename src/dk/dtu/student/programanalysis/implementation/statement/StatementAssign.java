package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.implementation.ArithmeticExpression;
import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jgrapht.UndirectedGraph;

import java.util.Collection;
import java.util.Set;

/**
 * Created by dx on 9/21/15.
 */
public class StatementAssign extends BaseStatement {

    private ArithmeticExpression expression;

    @Override
    public void parseTreeNode() {
        ParserRuleContext context = (ParserRuleContext) this.userObject;
        expression = (ArithmeticExpression) getChildAt(0);
        expression.setUserObject(context.getChild(2));
        expression.parseTreeNode();
    }

    public ArithmeticExpression getExpression() {
        return expression;
    }
}
