package dk.dtu.student.programanalysis.implementation;

import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import dk.dtu.student.programanalysis.implementation.statement.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

/**
 * Created by dx on 11/12/15.
 */
public abstract class BaseAnalysis {

    protected Map<Label, Set<? extends Label>> infl;

    public abstract String getName();

    public void parse(BaseMutableTreeNode node, ParserRuleContext context) {
        Class nodeClass = node.getClass();

        if(nodeClass == StatementAssign.class) {
            parse((StatementAssign)node, context);
        }
        else if(nodeClass == StatementAssignArray.class) {
            parse((StatementAssignArray)node, context);
        }
        else if(nodeClass == StatementIf.class) {
            parse((StatementIf)node, context);
        }
        else if(nodeClass == StatementRead.class) {
            parse((StatementRead)node, context);
        }
        else if(nodeClass == StatementReadArray.class) {
            parse((StatementReadArray)node, context);
        }
        else if(nodeClass == StatementSkip.class) {
            parse((StatementSkip)node, context);
        }
        else if(nodeClass == StatementWrite.class) {
            parse((StatementWrite)node, context);
        }
        else if(nodeClass == StatementWhile.class) {
            parse((StatementWhile)node, context);
        }
    }

    public abstract void parse(StatementAssign node, ParserRuleContext context);

    public abstract void parse(StatementAssignArray node, ParserRuleContext context);

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

    public abstract void parse(StatementRead node, ParserRuleContext context);

    public abstract void parse(StatementReadArray node, ParserRuleContext context);

    public abstract void parse(StatementSkip node, ParserRuleContext context);

    public void parse(StatementWhile node, ParserRuleContext context) {
        BaseStatement child = (BaseStatement) node.getChildAt(1);
        node.setS(child);
    }

    public abstract void parse(StatementWrite node, ParserRuleContext context);

    private void produceInfl(FlowGraph graph) {
        infl = new HashMap<>();

        // Initialize infl
        Set<? extends Label> labels = graph.getLabels();
        for(Label label : labels) {
            Set<? extends Label> initInfl = new HashSet<>();

            infl.put(label, initInfl);
        }

        DirectedGraph<Label, DefaultEdge> flow = (DirectedGraph<Label, DefaultEdge>) graph.getFlow();
        Set<DefaultEdge> edges = flow.edgesOf(graph.getInit());
        for(DefaultEdge edge : edges) {
            if(flow.getEdgeSource(edge) != graph.getInit()) {
                edges.remove(edge);
            }
        }

        Set<DefaultEdge> checkedEdge = new HashSet<>();

        Queue<DefaultEdge> edgeSet = new ArrayDeque<>();
        edgeSet.addAll(edges);

        // Repeat previous processes until all edges are visited
        while(edgeSet.size() > 0) {
            DefaultEdge edge = edgeSet.poll();

            // Open the edge and put it in the checkedSet
            checkedEdge.add(edge);

            // Process edge
            Label source = flow.getEdgeSource(edge);
            Label target = flow.getEdgeTarget(edge);
            Set<Label> modifiedInfl = (Set<Label>) infl.get(source);
            modifiedInfl.add(target);
            infl.put(source, modifiedInfl);

            // Get next edge
            Set<DefaultEdge> nextEdgeCandidates = flow.edgesOf(target);
            // Only take where nextVertex is the source of the edge
            for(DefaultEdge nextEdgeCandidate : nextEdgeCandidates) {
                if(flow.getEdgeSource(nextEdgeCandidate).equals(target)) {
                    if(!checkedEdge.contains(nextEdgeCandidate)) {
                        edgeSet.add(nextEdgeCandidate);
                    }
                }
            }

            edgeSet.removeAll(checkedEdge);
        }

        System.out.println();
    }

    public void doAnalysis(FlowGraph graph) {
        produceInfl(graph);

        // W := nil;
        LinkedList<DefaultEdge> W;

        // for all (l,l') in F do W := cons((l,l'),W);
        DirectedGraph<Label, DefaultEdge> flows = (DirectedGraph<Label, DefaultEdge>) graph.getFlow();
        // Process initial edge
        W = constructWorklist(graph);

        Set<Label> labels = new HashSet<>();
        labels.addAll(graph.getLabels());
        // for all l in F or E do
        for(Label label : labels) {
            if(label.equals(graph.getInit())) {
                setAnalysisResult(label, getExtremeValue(graph.getLabels()));
            }
            else {
                setAnalysisResult(label, getBottomValue());
            }
        }

        // for all l in F or E do
        while(W.size() > 0) {
            // (l,l') := head(W); W := tail(W);
            DefaultEdge checkEdge = W.pop();
            Label l = flows.getEdgeSource(checkEdge);
            Label lprime = flows.getEdgeTarget(checkEdge);
            // if f(Analysis[l]) !<= Analysis[l']
            Set<Label> anal = (Set<Label>) analyseComponent(l);
            if(graph.getFinals().contains(lprime)) {
                analyseComponent(lprime);
            }
            Set<Label> fAnal = (Set<Label>) getAnalysisResult(lprime);
            if(!fAnal.containsAll(anal)) {
                // then Analysis[l'] := Analysis[l'] union f(Analysis[l]);
                Set<Label> unionResult = (Set<Label>) getAnalysisResult(lprime);
                unionResult.addAll(analyseComponent(l));
                setAnalysisResult(lprime, unionResult);
                // for all l'' with (l' , l'') in F do W := cons((l' , l''),W);
                W = applyConstraints(flows, l, W);
            }
        }
    }

    protected LinkedList<DefaultEdge> constructWorklist(FlowGraph graph) {
        LinkedList<DefaultEdge> result = new LinkedList<>();
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
            result.add(edge);

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

        return result;
    }

    private LinkedList<DefaultEdge> applyConstraints(DirectedGraph<Label, DefaultEdge> flows, Label l,
                                                     LinkedList<DefaultEdge> W) {
        Set<Label> cons = (Set<Label>) infl.get(l);
        for(Label c : cons) {
            Set<DefaultEdge> edgeSources = flows.edgesOf(c);
            for(DefaultEdge edgeSource : edgeSources) {
                if(flows.getEdgeSource(edgeSource).equals(c)) {
                    W.push(edgeSource);
                }
            }
        }
        return W;
    }

    protected abstract Set<? extends Label> getExtremeValue(Set<? extends Label> labels);

    protected abstract Set<? extends Label> getBottomValue();

    protected abstract Set<? extends Label> analyseComponent(Label l);

    protected abstract Set<? extends Label> getAnalysisResult(Label l);

    protected abstract void setAnalysisResult(Label l, Set<? extends Label> newSet);

    public abstract String printResult();
}
