import dk.dtu.student.programanalysis.implementation.ArithmeticExpression;
import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BooleanExpression;
import dk.dtu.student.programanalysis.implementation.RootTreeNode;
import dk.dtu.student.programanalysis.implementation.declaration.DeclarationInteger;
import dk.dtu.student.programanalysis.implementation.statement.*;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created by dx on 11/9/15.
 */
public class RuleContextFactory {

    public static BaseMutableTreeNode produceNode(Class nodeClass, ParserRuleContext context) {
        BaseMutableTreeNode retval = null;

        if (nodeClass == TheLangParser.ProgramContext.class) {
            retval = new RootTreeNode();
        }
        else if (nodeClass == TheLangParser.DeclContext.class) {
            retval = new DeclarationInteger();
        }
        else if (nodeClass == TheLangParser.AssignStmtContext.class) {
            retval = new StatementAssign();
        }
        else if (nodeClass == TheLangParser.WhileStmtContext.class) {
            retval = new StatementWhile();
        }
        else if (nodeClass == TheLangParser.ReadStmtContext.class) {
            retval = new StatementRead();
        }
        else if (nodeClass == TheLangParser.WriteStmtContext.class) {
            retval = new StatementWrite();
        }
        else if (nodeClass == TheLangParser.SkipStmtContext.class) {
            retval = new StatementSkip();
        }
        else if (nodeClass == TheLangParser.IfStmtContext.class) {
            retval = new StatementIf();
        }
        else if (nodeClass == TheLangParser.AexprContext.class ||
                nodeClass == TheLangParser.Aexpr1Context.class ||
                nodeClass == TheLangParser.Aexpr2Context.class ||
                nodeClass == TheLangParser.Aexpr3Context.class) {
            retval = new ArithmeticExpression();
        }
        else if (nodeClass == TheLangParser.BexprContext.class ||
                nodeClass == TheLangParser.Bexpr1Context.class ||
                nodeClass == TheLangParser.Bexpr2Context.class) {
            retval = new BooleanExpression();
        }
        else if (nodeClass == TheLangParser.AssignArrayStmtContext.class) {

        }
        else if (nodeClass == TheLangParser.ReadArrayStmtContext.class) {

        }

        if(retval != null)
            retval.parse(context);

        return retval;
    }

}