package dk.dtu.student.programanalysis.implementation.analysis;

import dk.dtu.student.programanalysis.implementation.BaseAnalysis;
import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.label.LabelLine;
import dk.dtu.student.programanalysis.implementation.statement.StatementAssign;
import dk.dtu.student.programanalysis.implementation.statement.StatementIf;
import dk.dtu.student.programanalysis.implementation.statement.StatementWhile;
import dk.dtu.student.programanalysis.implementation.statement.StatementWrite;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by dx on 11/12/15.
 */
public class AnalysisReachingDefinition extends BaseAnalysis {
    @Override
    public String getName() {
        return "ReachingDefinition";
    }

    @Override
    public void parse(StatementAssign node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelLine(firstTerminal.getSymbol().getText(), context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWhile node, ParserRuleContext context) {
        super.parse(node, context);

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelLine(firstTerminal.getSymbol().getText(), context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWrite node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelLine(firstTerminal.getSymbol().getText(), context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementIf node, ParserRuleContext context) {
        super.parse(node, context);

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelLine(firstTerminal.getSymbol().getText(), context.getStart().getLine());

        node.setL(label);
    }
}
