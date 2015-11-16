package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BaseSet;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jgrapht.DirectedGraph;
import org.jgrapht.Graph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.security.acl.LastOwnerException;
import java.util.*;

/**
 * Created by dx on 9/21/15.
 */
public class StatementWhile extends BaseStatement {

    private BaseStatement S;

    public StatementWhile() {
    }

    @Override
    public Collection<? extends Label> produceLabels() {
        Set<Label> labels = (Set<Label>) super.produceLabels();

        labels.add(getL());
        labels.addAll(S.produceLabels());

        return labels;
    }

    @Override
    public DirectedGraph<Label, DefaultEdge> produceFlows(DirectedGraph<Label, DefaultEdge> graph) {
        graph = super.produceFlows(graph);

        graph.addVertex(getL());
        graph.addVertex(S.produceInit());
        graph.addEdge(getL(), S.produceInit());

        System.out.println("Adding flow from " + getL().toString() + " to " + S.produceInit().toString());

        // Extract all Ses flows
        BaseStatement tempS = S;
        while(tempS.isSequence()) {
//            flows.addAll(tempS.produceFlows(graph));
            tempS = tempS.getS2();
        }

        // Add last S to this while S
        graph.addVertex(tempS.produceInit());
        graph.addVertex(getL());
        graph.addEdge(tempS.produceInit(), getL());

        System.out.println("Adding flow from " + tempS.produceInit().toString() + " to " + getL().toString());

        return graph;
    }

    public BaseStatement getS() {
        return S;
    }

    public void setS(BaseStatement s) {
        S = s;
    }
}
