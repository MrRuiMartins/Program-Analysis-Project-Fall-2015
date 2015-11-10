package dk.dtu.student.programanalysis.implementation.graph;

import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import org.jgrapht.UndirectedGraph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by dx on 11/10/15.
 */
public class FlowGraph {

    Queue<BaseStatement> statements;

    private Set<BaseMutableTreeNode> labels;
    private BaseMutableTreeNode init;
    private Set<BaseMutableTreeNode> finals;
    private Set<UndirectedGraph<BaseMutableTreeNode, BaseMutableTreeNode>> flow;

    public FlowGraph() {
        statements = new ArrayDeque<>();

        labels = new HashSet<>();
        init = null;
        finals = new HashSet<>();
        flow = new HashSet<>();
    }

    /**
     * Applying statements in order
     * @param statement
     */
    public void processStatement(BaseStatement statement) {

        labels.addAll(statement.produceLabels());

        init = statement.produceInit();

        finals = statement.produceFinals();

        statements.add(statement);
    }

    public void produceFlow() {
        while(!statements.isEmpty()) {
            BaseStatement statement = statements.poll();
            flow.addAll(statement.produceFlows(this));
        }
    }

    public Set<BaseMutableTreeNode> getLabels() {
        return labels;
    }

    public BaseMutableTreeNode getInit() {
        return init;
    }

    public Set<BaseMutableTreeNode> getFinals() {
        return finals;
    }

    public Set<UndirectedGraph<BaseMutableTreeNode, BaseMutableTreeNode>> getFlow() {
        return flow;
    }
}
