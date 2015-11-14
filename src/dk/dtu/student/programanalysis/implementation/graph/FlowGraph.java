package dk.dtu.student.programanalysis.implementation.graph;

import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import dk.dtu.student.programanalysis.implementation.Label;
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

    private Set<Label> labels;
    private Label init;
    private Set<Label> finals;
    private Set<UndirectedGraph<Label, Label>> flow;

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

        // Only produce Init if it is the first statement
        if(((BaseMutableTreeNode)statement.getParent()).getChildBefore(statement) == null) {
            init = statement.produceInit();
        }

        // Only produce Init if it is the first statement
        if(((BaseMutableTreeNode)statement.getParent()).getChildAfter(statement) == null) {
            finals = statement.produceFinals();
        }

        flow.addAll(statement.produceFlows(this));

        statements.add(statement);
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public Label getInit() {
        return init;
    }

    public Set<Label> getFinals() {
        return finals;
    }

    public Set<UndirectedGraph<Label, Label>> getFlow() {
        return flow;
    }
}
