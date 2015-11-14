package dk.dtu.student.programanalysis.implementation.analysis;

import dk.dtu.student.programanalysis.implementation.BaseAnalysis;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import dk.dtu.student.programanalysis.implementation.label.LabelLine;
import dk.dtu.student.programanalysis.implementation.statement.StatementAssign;
import dk.dtu.student.programanalysis.implementation.statement.StatementIf;
import dk.dtu.student.programanalysis.implementation.statement.StatementWhile;
import dk.dtu.student.programanalysis.implementation.statement.StatementWrite;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

/**
 * Created by dx on 11/12/15.
 */
public class AnalysisReachingDefinition extends BaseAnalysis {

    Map<LabelLine, Set<LabelLine>> RDEnter;
    Map<LabelLine, Set<LabelLine>> RDLeave;

    Map<LabelLine, Set<LabelLine>> killFunction;
    Map<LabelLine, Set<LabelLine>> genFunction;

    public AnalysisReachingDefinition() {
        RDEnter = new HashMap<>();
        RDLeave = new HashMap<>();
        killFunction = new HashMap<>();
        genFunction = new HashMap<>();
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
    public void parse(StatementIf node, ParserRuleContext context) {
        super.parse(node, context);

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
    public void doAnalysis(FlowGraph graph) {
        populateFunctions(graph);
        populateRDs(graph);
        populateRDs(graph);
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

    private void populateFunctions(FlowGraph graph) {
        UndirectedGraph<Label, DefaultEdge> flows = graph.getFlow();
        DefaultEdge initEdge = graph.getInitEdge();
        Set<DefaultEdge> checkedEdge = new HashSet<>();

        // Open the initEdge and put it in the checkedSet
        checkedEdge.add(initEdge);

        // Process initial edge
        processFunctions(graph, initEdge, false);

        // Get the next edges
        Label targetVertex = flows.getEdgeTarget(initEdge);
        Set<DefaultEdge> edgeSet = new HashSet<>();
        edgeSet.addAll(flows.edgesOf(targetVertex));

        // Repeat previous processes until all edges are visited
        edgeSet.removeAll(checkedEdge);
        while(edgeSet.size() > 0) {
            Set<DefaultEdge> generatedEdges = new HashSet<>();
            // If edgeSet is bigger than 0, open all the edges
            Iterator<DefaultEdge> edgeIterator = edgeSet.iterator();
            while(edgeIterator.hasNext()) {
                DefaultEdge edge = edgeIterator.next();

                processFunctions(graph, edge, false);

                checkedEdge.add(edge);

                boolean isLastNode = true;

                targetVertex = flows.getEdgeTarget(edge);
                Set<DefaultEdge> generatedEdgesCandidate = flows.edgesOf(targetVertex);
                for(DefaultEdge generatedEdgeCandidate : generatedEdgesCandidate) {
                    if(flows.getEdgeSource(generatedEdgeCandidate) == targetVertex) {
                        generatedEdges.add(generatedEdgeCandidate);
                        isLastNode = false;
                    }
                }

                // Done, but last vertex has not been checked
                if(isLastNode) {
                    processFunctions(graph, edge, true);
                }
            }
            edgeSet.addAll(generatedEdges);
            edgeSet.removeAll(checkedEdge);
        }
    }

    private void processFunctions(FlowGraph graph, DefaultEdge edge, boolean isLast) {
        UndirectedGraph<Label, DefaultEdge> flow = graph.getFlow();
        LabelLine l;
        if(!isLast) {
            l = (LabelLine) flow.getEdgeSource(edge);
        }
        else {
            l = (LabelLine) flow.getEdgeTarget(edge);
        }

        // Generate Kill functions
        generateKill(l, graph.getLabels());

        // Generate Gen functions
        generateGen(l, graph.getLabels());
    }

    private void populateRDs(FlowGraph graph) {
        UndirectedGraph<Label, DefaultEdge> flows = graph.getFlow();
        DefaultEdge initEdge = graph.getInitEdge();
        Set<DefaultEdge> checkedEdge = new HashSet<>();

        // Open the initEdge and put it in the checkedSet
        checkedEdge.add(initEdge);

        // Process initial edge
        processRDs(graph, initEdge, false);

        // Get the next edges
        Label targetVertex = flows.getEdgeTarget(initEdge);
        Set<DefaultEdge> edgeSet = new HashSet<>();
        edgeSet.addAll(flows.edgesOf(targetVertex));

        // Repeat previous processes until all edges are visited
        edgeSet.removeAll(checkedEdge);
        while(edgeSet.size() > 0) {
            Set<DefaultEdge> generatedEdges = new HashSet<>();
            // If edgeSet is bigger than 0, open all the edges
            Iterator<DefaultEdge> edgeIterator = edgeSet.iterator();
            while(edgeIterator.hasNext()) {
                DefaultEdge edge = edgeIterator.next();

                processRDs(graph, edge, false);

                checkedEdge.add(edge);

                boolean isLastNode = true;

                targetVertex = flows.getEdgeTarget(edge);
                Set<DefaultEdge> generatedEdgesCandidate = flows.edgesOf(targetVertex);
                for(DefaultEdge generatedEdgeCandidate : generatedEdgesCandidate) {
                    if(flows.getEdgeSource(generatedEdgeCandidate) == targetVertex) {
                        generatedEdges.add(generatedEdgeCandidate);
                        isLastNode = false;
                    }
                }

                // Done, but last vertex has not been checked
                if(isLastNode) {
                    processRDs(graph, edge, true);
                }
            }
            edgeSet.addAll(generatedEdges);
            edgeSet.removeAll(checkedEdge);
        }
    }

    private void processRDs(FlowGraph graph, DefaultEdge edge, boolean isLast) {
        UndirectedGraph<Label, DefaultEdge> flow = graph.getFlow();
        LabelLine l;
        if(!isLast) {
            l = (LabelLine) flow.getEdgeSource(edge);
        }
        else {
            l = (LabelLine) flow.getEdgeTarget(edge);
        }

        // Generate R enter
        generateRDEnter(l, graph.getFlow(), graph.getInit());

        // Generate R leave
        generateRDLeave(l);
    }

    private void generateRDEnter(LabelLine l, UndirectedGraph<Label, DefaultEdge> flow, Label initLabel) {
        if(l == initLabel) {
            Set<LabelLine> labels = new HashSet<>();
            labels.add(l);

            RDEnter.put(l, labels);
        }
        else {
            Set<LabelLine> rEnterSet = new HashSet<>();

            Set<DefaultEdge> checkEdgeSet = flow.edgesOf(l);
            for(DefaultEdge checkEdge : checkEdgeSet) {
                LabelLine checkL = (LabelLine) flow.getEdgeSource(checkEdge);
                LabelLine checkLprime = (LabelLine) flow.getEdgeTarget(checkEdge);
                if(checkLprime.equals(l) && RDLeave.containsKey(checkL)) {
                    rEnterSet.addAll(RDLeave.get(checkL));
                }
            }

            RDEnter.put(l, rEnterSet);
        }
    }

    private void generateRDLeave(LabelLine l) {
        Set<LabelLine> rLeaveSet = new HashSet<>();
        rLeaveSet.addAll(RDEnter.get(l));
        rLeaveSet.removeAll(killFunction.get(l));
        rLeaveSet.addAll(genFunction.get(l));

        RDLeave.put(l, rLeaveSet);
    }

    private void generateGen(LabelLine l, Set<Label> labels) {
        Set<LabelLine> killSet = new HashSet<>();

        if(l.getStatementClass().equals(StatementAssign.class)) {
            killSet.add(l);
        }

        genFunction.put(l, killSet);
    }

    private void generateKill(LabelLine l, Set<Label> labels) {
        Set<LabelLine> killSet = new HashSet<>();

        if(l.getStatementClass().equals(StatementAssign.class)) {
            Iterator<Label> iterator = labels.iterator();
            while(iterator.hasNext()) {
                LabelLine checkLabel = (LabelLine) iterator.next();
                if(checkLabel.getSymbol().equals(l.getSymbol())) {
                    killSet.add(checkLabel);
                }
            }
        }

        killFunction.put(l, killSet);
    }
}
