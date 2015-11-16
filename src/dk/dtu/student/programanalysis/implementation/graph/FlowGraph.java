package dk.dtu.student.programanalysis.implementation.graph;

import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import dk.dtu.student.programanalysis.implementation.Label;
import org.jgrapht.DirectedGraph;
import org.jgrapht.Graph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;

import java.util.*;

/**
 * Created by dx on 11/10/15.
 */
public class FlowGraph {

    Queue<BaseStatement> statements;

    private Set<Label> labels;
    private Label init;
    private Set<Label> finals;
    private DirectedGraph<Label, DefaultEdge> flow;
    private DefaultEdge initEdge;

    public FlowGraph() {
        statements = new ArrayDeque<>();

        labels = new HashSet<>();
        init = null;
        finals = new HashSet<>();
        flow = new SimpleDirectedGraph<Label, DefaultEdge>(DefaultEdge.class);
    }

    /**
     * Applying statements in order
     * @param statement
     */
    public void processStatement(BaseStatement statement) {

        labels.addAll(statement.produceLabels());

        // Only produce Init if it is the first statement
        if(((BaseMutableTreeNode)statement.getParent()).getChildBefore(statement) == null) {
            init = statement.produceInit();
        }

        // Only produce Init if it is the first statement
        if(((BaseMutableTreeNode)statement.getParent()).getChildAfter(statement) == null) {
            finals = statement.produceFinals();
        }

        boolean isAssigningInitFlow = false;
        if(flow.edgeSet().size() == 0) {
            isAssigningInitFlow = true;
        }
        flow = statement.produceFlows(flow);
        if(isAssigningInitFlow) {
            Set<DefaultEdge> edgeSet = flow.edgeSet();
            initEdge = edgeSet.iterator().next();
        }

        statements.add(statement);
    }

    public Set<? extends Label> getLabels() {
        return labels;
    }

    public Label getInit() {
        return init;
    }

    public Set<Label> getFinals() {
        return finals;
    }

    public DirectedGraph<? extends Label, DefaultEdge> getFlow() {
        return flow;
    }

    public DefaultEdge getInitEdge() {
        return initEdge;
    }
}
