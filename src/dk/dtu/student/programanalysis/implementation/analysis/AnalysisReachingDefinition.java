package dk.dtu.student.programanalysis.implementation.analysis;

import dk.dtu.student.programanalysis.implementation.IAnalysisType;
import dk.dtu.student.programanalysis.implementation.BaseAnalysis;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.analysistype.ReachingDefinitionAnalysisType;
import dk.dtu.student.programanalysis.implementation.declaration.DeclarationArrayInteger;
import dk.dtu.student.programanalysis.implementation.declaration.DeclarationInteger;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import dk.dtu.student.programanalysis.implementation.statement.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

/**
 * Created by dx on 11/12/15.
 */
public class AnalysisReachingDefinition extends BaseAnalysis {

    Map<Label, Set<ReachingDefinitionAnalysisType>> RDEnter;
    Map<Label, Set<ReachingDefinitionAnalysisType>> RDLeave;

    Map<Label, Set<ReachingDefinitionAnalysisType>> killFunction;
    Map<Label, Set<ReachingDefinitionAnalysisType>> genFunction;

    Map<String, ReachingDefinitionAnalysisType> extremeValuesList;
    Map<Label, ReachingDefinitionAnalysisType> reachingDefinitionAnalysisTypes;

    public AnalysisReachingDefinition() {
        RDEnter = new HashMap<>();
        RDLeave = new HashMap<>();
        killFunction = new HashMap<>();
        genFunction = new HashMap<>();

        extremeValuesList = new HashMap<>();
        reachingDefinitionAnalysisTypes = new HashMap<>();
    }

    @Override
    public String getName() {
        return "ReachingDefinition";
    }

    @Override
    public void parse(StatementAssign node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementAssignArray node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementIf node, ParserRuleContext context) {
        super.parse(node, context);

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementRead node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementReadArray node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementSkip node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWhile node, ParserRuleContext context) {
        super.parse(node, context);

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWrite node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWriteArray node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(DeclarationInteger node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(DeclarationArrayInteger node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
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
    protected Set<? extends IAnalysisType> getExtremeValue(Set<? extends Label> labels) {
        Set<ReachingDefinitionAnalysisType> extremeValues = new HashSet<>();

        for(Label label : labels) {
            ReachingDefinitionAnalysisType at = extremeValuesList.get(label.getSymbol());
            if(at != null) {
                extremeValues.add(at);
            }
        }

        return extremeValues;
    }

    @Override
    protected Set<? extends IAnalysisType> getBottomValue() {
        return new HashSet<>();
    }

    @Override
    public String printResult() {
        String result = "";
        Iterator it = this.RDLeave.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Label key = (Label) pair.getKey();
            Set<ReachingDefinitionAnalysisType> analysisTypes =
                    (Set<ReachingDefinitionAnalysisType>) pair.getValue();
            result += "RD after leaving line: " + key.getLineNumber() + "\n";
            for(ReachingDefinitionAnalysisType analysisType : analysisTypes) {
                result += analysisType + "\n";
            }
        }
        return result;
    }

    @Override
    protected Set<? extends IAnalysisType> analyseComponent(Label l) {
        Set<ReachingDefinitionAnalysisType> result = new HashSet<>();
        result.addAll(RDEnter.get(l));
        if(killFunction.get(l) == null) {
            System.out.print("test");
        }
        result.removeAll(killFunction.get(l));
        result.addAll(genFunction.get(l));

        RDLeave.put(l, result);

        return result;
    }

    @Override
    protected Set<? extends IAnalysisType> getAnalysisResult(Label l) {
        return RDEnter.get(l);
    }

    @Override
    protected void setAnalysisResult(Label l, Set<? extends IAnalysisType> newSet) {
        RDEnter.put(l, (Set<ReachingDefinitionAnalysisType>) newSet);
    }

    private void produceExtremes(FlowGraph graph) {
        Set<Label> labels = (Set<Label>) graph.getLabels();

        for(Label label : labels) {
            ReachingDefinitionAnalysisType at = extremeValuesList.get(label.getSymbol());
            if(at == null) {
                ReachingDefinitionAnalysisType newRDType = new ReachingDefinitionAnalysisType(
                        label.getLineNumber(), label.getSymbol());
                newRDType.setLineNumber(ReachingDefinitionAnalysisType.ANYWHERE);
                if(!label.getStatementClass().equals(StatementSkip.class)
                        && !label.getStatementClass().equals(StatementIf.class)
                        && !label.getStatementClass().equals(StatementWhile.class)
                        && !label.getStatementClass().equals(StatementWrite.class)
                        ) {
                    extremeValuesList.put(newRDType.getSymbol(), newRDType);
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
        DirectedGraph<Label, DefaultEdge> flow = (DirectedGraph<Label, DefaultEdge>) graph.getFlow();

        // Determine is last
        Label lpp = flow.getEdgeTarget(edge);
        Set<Label> finals = graph.getFinals();
        boolean isLast = finals.contains(lpp);

        Label l;
        if(!isLast) {
            l = flow.getEdgeSource(edge);
        }
        else {
            l = flow.getEdgeTarget(edge);
        }

        // Generate Kill functions
        generateKill(l, (Set<Label>) graph.getLabels());

        // Generate Gen functions
        generateGen(l);
    }

    private void generateGen(Label l) {
        Set<ReachingDefinitionAnalysisType> genSet = new HashSet<>();

        if(l.getStatementClass().equals(StatementAssign.class)
                || l.getStatementClass().equals(StatementAssignArray.class)
                || l.getStatementClass().equals(StatementRead.class)
                || l.getStatementClass().equals(DeclarationInteger.class)
                || l.getStatementClass().equals(DeclarationArrayInteger.class)
                || l.getStatementClass().equals(StatementReadArray.class)) {
            ReachingDefinitionAnalysisType rdAt = new ReachingDefinitionAnalysisType(
                    l.getLineNumber(), l.getSymbol());
            reachingDefinitionAnalysisTypes.put(l, rdAt);
            genSet.add(rdAt);
        }

        genFunction.put(l, genSet);
    }

    private void generateKill(Label l, Set<Label> labels) {
        Set<ReachingDefinitionAnalysisType> killSet = new HashSet<>();

        // Add all related to the symbol. This is same for
        // normal assignment and array assignment also same
        // for read and array read
        if(l.getStatementClass().equals(StatementAssign.class)
                || l.getStatementClass().equals(StatementAssignArray.class)
                || l.getStatementClass().equals(StatementRead.class)
                || l.getStatementClass().equals(StatementReadArray.class)) {
            Iterator<Label> iterator = labels.iterator();
            while(iterator.hasNext()) {
                Label checkLabel = iterator.next();
                if(checkLabel.getSymbol().equals(l.getSymbol())) {
                    killSet.add(reachingDefinitionAnalysisTypes.get(checkLabel));
                }
            }
        }

        // put the extreme function as well
        killSet.add(extremeValuesList.get(l.getSymbol()));

        killFunction.put(l, killSet);
    }

}
