package dk.dtu.student.programanalysis.implementation.analysis;

import dk.dtu.student.programanalysis.implementation.BaseAnalysis;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.declaration.DeclarationArrayInteger;
import dk.dtu.student.programanalysis.implementation.declaration.DeclarationInteger;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import dk.dtu.student.programanalysis.implementation.label.LabelLine;
import dk.dtu.student.programanalysis.implementation.statement.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

/**
 * Created by dx on 11/12/15.
 */
public abstract class AnalysisReachingDefinition extends BaseAnalysis {
/*
    Map<LabelLine, Set<LabelLine>> RDEnter;
    Map<LabelLine, Set<LabelLine>> RDLeave;

    Map<LabelLine, Set<LabelLine>> killFunction;
    Map<LabelLine, Set<LabelLine>> genFunction;

    Map<String, LabelLine> extremeValuesList;

    public AnalysisReachingDefinition() {
        RDEnter = new HashMap<>();
        RDLeave = new HashMap<>();
        killFunction = new HashMap<>();
        genFunction = new HashMap<>();

        extremeValuesList = new HashMap<>();
    }

    @Override
    public String getName() {
        return "ReachingDefinition";
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

    @Override
    protected Set<? extends Label> getExtremeValue(Set<? extends Label> labels) {
        Set<Label> extremeValues = new HashSet<>();

        for(Label label : labels) {
            LabelLine ll = (LabelLine) label;
            ll = extremeValuesList.get(ll.getSymbol());
            if(ll != null) {
                extremeValues.add(ll);
            }
        }

        return extremeValues;
    }

    @Override
    protected Set<? extends Label> getBottomValue() {
        return new HashSet<>();
    }

    @Override
    public String printResult() {
        String result = "";
        Iterator it = this.RDLeave.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            LabelLine key = (LabelLine) pair.getKey();
            Set<LabelLine> labels = (Set<LabelLine>) pair.getValue();
            result += "RD after leaving line: " + key.getLineNumber() + "\n";
            for(LabelLine label : labels) {
                result += label + "\n";
            }
        }
        return result;
    }

    @Override
    protected Set<? extends Label> analyseComponent(Label l) {
        Set<LabelLine> result = new HashSet<>();
        result.addAll(RDEnter.get(l));
        result.removeAll(killFunction.get(l));
        result.addAll(genFunction.get(l));

        RDLeave.put((LabelLine) l, result);

        return result;
    }

    @Override
    protected Set<? extends Label> getAnalysisResult(Label l) {
        return RDEnter.get(l);
    }

    @Override
    protected void setAnalysisResult(Label l, Set<? extends Label> newSet) {
        RDEnter.put((LabelLine)l, (Set<LabelLine>) newSet);
    }

    private void produceExtremes(FlowGraph graph) {
        Set<LabelLine> labels = (Set<LabelLine>) graph.getLabels();

        for(Label label : labels) {
            LabelLine ll = (LabelLine) label;
            ll = extremeValuesList.get(ll.getSymbol());
            if(ll == null) {
                ll = (LabelLine) label;
                LabelLine newLabelLine = new LabelLine(ll.getStatementClass(),
                        ll.getSymbol(), ll.getLineNumber());
                newLabelLine.setLineNumber(LabelLine.LABELLINE_ANYWHERE);
                if(!ll.getStatementClass().equals(StatementSkip.class)
                        && !ll.getStatementClass().equals(StatementIf.class)
                        && !ll.getStatementClass().equals(StatementWhile.class)
                        && !ll.getStatementClass().equals(StatementWrite.class)
                        ) {
                    extremeValuesList.put(newLabelLine.getSymbol(), newLabelLine);
                }
            }
        }
    }

    private void populateFunctions(FlowGraph graph) {
        DirectedGraph<Label, DefaultEdge> flows = (DirectedGraph<Label, DefaultEdge>) graph.getFlow();
        Set<DefaultEdge> checkedEdge = new HashSet<>();

        Queue<DefaultEdge> edgeSet = new ArrayDeque<>();
        // Open the initEdge and put it in the checkedSet
        edgeSet.addAll(flows.edgesOf(graph.getInit()));

        // Repeat previous processes until all edges are visited
        while(edgeSet.size() > 0) {
            DefaultEdge edge = edgeSet.poll();

            // Open the edge and put it in the checkedSet
            checkedEdge.add(edge);
            // Process edge
            produceFunctions(graph, edge);

            // Get next edge
            Label nextVertex = flows.getEdgeTarget(edge);
            Set<DefaultEdge> nextEdgeCandidates = flows.edgesOf(nextVertex);
            // Only take where nextVertex is the source of the edge
            for(DefaultEdge nextEdgeCandidate : nextEdgeCandidates) {
                if(flows.getEdgeSource(nextEdgeCandidate).equals(nextVertex)) {
                    if(!checkedEdge.contains(nextEdgeCandidate)) {
                        edgeSet.add(nextEdgeCandidate);
                    }
                }
            }

            edgeSet.removeAll(checkedEdge);
        }
    }

    private void produceFunctions(FlowGraph graph, DefaultEdge edge) {
        DirectedGraph<LabelLine, DefaultEdge> flow = (DirectedGraph<LabelLine, DefaultEdge>) graph.getFlow();

        // Determine is last
        Label lpp = flow.getEdgeTarget(edge);
        Set<Label> finals = graph.getFinals();
        boolean isLast = finals.contains(lpp);

        LabelLine l;
        if(!isLast) {
            l = flow.getEdgeSource(edge);
        }
        else {
            l = flow.getEdgeTarget(edge);
        }

        // Generate Kill functions
        generateKill(l, (Set<LabelLine>) graph.getLabels());

        // Generate Gen functions
        generateGen(l, (Set<LabelLine>) graph.getLabels());
    }

    private void generateGen(LabelLine l, Set<LabelLine> labels) {
        Set<LabelLine> killSet = new HashSet<>();

        if(l.getStatementClass().equals(StatementAssign.class)
                || l.getStatementClass().equals(StatementAssignArray.class)
                || l.getStatementClass().equals(StatementRead.class)
                || l.getStatementClass().equals(DeclarationInteger.class)
                || l.getStatementClass().equals(StatementReadArray.class)) {
            killSet.add(l);
        }

        genFunction.put(l, killSet);
    }

    private void generateKill(LabelLine l, Set<LabelLine> labels) {
        Set<LabelLine> killSet = new HashSet<>();

        // Add all related to the symbol. This is same for
        // normal assignment and array assignment also same
        // for read and array read
        if(l.getStatementClass().equals(StatementAssign.class)
                || l.getStatementClass().equals(StatementAssignArray.class)
                || l.getStatementClass().equals(StatementRead.class)
                || l.getStatementClass().equals(StatementReadArray.class)) {
            Iterator<LabelLine> iterator = labels.iterator();
            while(iterator.hasNext()) {
                LabelLine checkLabel = (LabelLine) iterator.next();
                if(checkLabel.getSymbol().equals(l.getSymbol())) {
                    killSet.add(checkLabel);
                }
            }
        }

        // put the extreme function as well
        killSet.add(extremeValuesList.get(l.getSymbol()));

        killFunction.put(l, killSet);
    }
    */
}
