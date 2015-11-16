package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jgrapht.DirectedGraph;
import org.jgrapht.Graph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dx on 9/21/15.
 */
public class StatementIf extends BaseStatement {

    private BaseStatement S1;
    private BaseStatement S2;

    @Override
    public Collection<? extends Label> produceLabels() {
        Set<Label> labels = new HashSet<>();

        labels.add(getL());

        labels.addAll(S1.produceLabels());
        labels.addAll(S2.produceLabels());

        return labels;
    }

    @Override
    public Set<Label> produceFinals() {
        Set<Label> labels = new HashSet<>();

        labels.addAll(S1.produceFinals());
        labels.addAll(S2.produceFinals());

        return labels;
    }

    @Override
    public DirectedGraph<Label, DefaultEdge> produceFlows(DirectedGraph<Label, DefaultEdge> graph) {
        super.isSequence();
        BaseStatement endingStatement = super.getS2();

        //FLOW to S1
        graph.addVertex(getL());
        graph.addVertex(S1.produceInit());
        graph.addEdge(getL(), S1.produceInit());

        //FLOW to S2
        graph.addVertex(getL());
        graph.addVertex(S2.produceInit());
        graph.addEdge(getL(), S2.produceInit());

        if(endingStatement != null) {
            // Extract all S1es flows
            BaseStatement tempS1 = S1;
            while (tempS1.isSequence()) {
                tempS1 = tempS1.getS2();
            }

            // Add last S to ending S
            graph.addVertex(tempS1.produceInit());
            graph.addVertex(endingStatement.getL());
            graph.addEdge(tempS1.produceInit(), endingStatement.getL());

            // Extract all S2es flows
            BaseStatement tempS2 = S2;
            while(tempS2.isSequence()) {
                tempS2 = tempS2.getS2();
            }

            // Add last S2 to ending S
            graph.addVertex(tempS2.produceInit());
            graph.addVertex(endingStatement.getL());
            graph.addEdge(tempS2.produceInit(), endingStatement.getL());
        }

        return graph;
    }

    public BaseStatement getS1() {
        return S1;
    }

    public void setS1(BaseStatement s1) {
        S1 = s1;
    }

    public BaseStatement getS2() {
        return S2;
    }

    public void setS2(BaseStatement s2) {
        S2 = s2;
    }
}
