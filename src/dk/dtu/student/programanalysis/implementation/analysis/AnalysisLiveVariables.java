package dk.dtu.student.programanalysis.implementation.analysis;

import dk.dtu.student.programanalysis.implementation.BaseAnalysis;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.declaration.DeclarationArrayInteger;
import dk.dtu.student.programanalysis.implementation.declaration.DeclarationInteger;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import dk.dtu.student.programanalysis.implementation.label.LabelLV;
import dk.dtu.student.programanalysis.implementation.label.LabelLine;
import dk.dtu.student.programanalysis.implementation.set.Signs;
import dk.dtu.student.programanalysis.implementation.statement.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

/**
 * Created by ruimartins on 22/11/2015.
 */
public class AnalysisLiveVariables extends BaseAnalysis{


    //String is used to represent variables (symbols.)
    Map<Label, Set<String>> LVEnter;

    Map<Label, Set<String>> LVLeave;

    Map<Label, Set<String>> killFunction;
    Map<Label, Set<String>> genFunction;

    Set<Signs> extremeValuesList = new HashSet<>();


    @Override
    public String getName() {
        return "LiveVariables";
    }

    @Override
    public void parse(StatementAssign node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelLine(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementAssignArray node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelLine(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementIf node, ParserRuleContext context) {
        super.parse(node, context);

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelLine(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementRead node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new LabelLine(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementReadArray node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new LabelLine(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementSkip node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelLine(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWhile node, ParserRuleContext context) {
        super.parse(node, context);

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelLine(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWrite node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelLine(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(DeclarationInteger node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new LabelLine(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(DeclarationArrayInteger node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new LabelLine(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void doAnalysis(FlowGraph graph) {
        produceExtremes(graph);
        populateFunctions(graph);
        super.doAnalysis(graph);

        System.out.println();
    }

    private void populateFunctions(FlowGraph graph) {

    }



    private void produceExtremes(FlowGraph graph) {
        //extremal value is the empty set here.
        return;
    }

    @Override
    protected Set<? extends Label> getExtremeValue(Set<? extends Label> labels) {
        return null;
    }

    @Override
    protected Set<? extends Label> getBottomValue() {
        return null;
    }

    @Override
    protected Set<? extends Label> analyseComponent(Label l) {
        return null;
    }

    @Override
    protected Set<? extends Label> getAnalysisResult(Label l) {
        return null;
    }

    @Override
    protected void setAnalysisResult(Label l, Set<? extends Label> newSet) {

    }

    @Override
    public String printResult() {
        return null;
    }
}
