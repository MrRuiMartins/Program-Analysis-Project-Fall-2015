package dk.dtu.student.programanalysis.implementation;

import dk.dtu.student.programanalysis.implementation.statement.StatementAssign;
import dk.dtu.student.programanalysis.implementation.statement.StatementIf;
import dk.dtu.student.programanalysis.implementation.statement.StatementWhile;
import dk.dtu.student.programanalysis.implementation.statement.StatementWrite;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import java.util.List;

/**
 * Created by dx on 11/12/15.
 */
public abstract class BaseAnalysis {

    public abstract String getName();

    public void parse(BaseMutableTreeNode node, ParserRuleContext context) {
        Class nodeClass = node.getClass();

        if(nodeClass == StatementAssign.class) {
            parse((StatementAssign)node, context);
        }
        else if(nodeClass == StatementIf.class) {
            parse((StatementIf)node, context);
        }
        else if(nodeClass == StatementWhile.class) {
            parse((StatementWhile)node, context);
        }
        else if(nodeClass == StatementWrite.class) {
            parse((StatementWrite)node, context);
        }
    }

    public abstract void parse(StatementAssign node, ParserRuleContext context);

    public void parse(StatementIf node, ParserRuleContext context) {
        for(int i = 0; i < context.getChildCount(); i++) {
            ParseTree child = context.getChild(i);
            if(TerminalNodeImpl.class.isAssignableFrom(child.getClass())) {
                TerminalNodeImpl terminalNode = (TerminalNodeImpl) child;
                // Parse token seek for then
                if(terminalNode.getText().equals("then")) {
                    ParseTree S1Context = context.getChild(i + 1).getChild(0);
                    // Get the context, iterate through our tree to assign S1
                    for(int j = 0; j < node.getChildCount(); j++) {
                        BaseMutableTreeNode checkedNode = (BaseMutableTreeNode) node.getChildAt(j);
                        if(BaseStatement.class.isAssignableFrom(checkedNode.getClass())) {
                            BaseStatement checkedStatement = (BaseStatement) checkedNode;
                            if(S1Context == checkedStatement.getUserObject()) {
                                node.setS1(checkedStatement);
                            }
                        }
                    }
                }
                // Parse token seek for else
                else if(terminalNode.getText().equals("else")) {
                    ParseTree S2Context = context.getChild(i + 1).getChild(0);
                    // Get the context, iterate through our tree to assign S1
                    for(int j = 0; j < node.getChildCount(); j++) {
                        BaseMutableTreeNode checkedNode = (BaseMutableTreeNode) node.getChildAt(j);
                        if(BaseStatement.class.isAssignableFrom(checkedNode.getClass())) {
                            BaseStatement checkedStatement = (BaseStatement) checkedNode;
                            if(S2Context == checkedStatement.getUserObject()) {
                                node.setS2(checkedStatement);
                                // Break the sequence for between Ses and link it to the end
                                BaseStatement previousStatement = (BaseStatement) node.getChildAt(j - 1);
                                previousStatement.setIsNotSequence(true);
                            }
                        }
                    }
                }
            }
        }

    }

    public void parse(StatementWhile node, ParserRuleContext context) {
        BaseStatement child = (BaseStatement) node.getChildAt(1);
        node.setS(child);
    }

    public abstract void parse(StatementWrite node, ParserRuleContext context);
}
