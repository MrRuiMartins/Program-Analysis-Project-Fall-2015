package dk.dtu.student.programanalysis.implementation;

import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import org.antlr.runtime.CommonToken;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dx on 11/5/15.
 */
public abstract class BaseStatement extends BaseMutableTreeNode {

    private BaseStatement S1, S2;

    public Collection<? extends BaseMutableTreeNode> produceLabels() {
        Set<BaseStatement> labels = new HashSet<>();
        if(isSequence()) {
            labels.add(S1);
            labels.add(S2);
        }
        return labels;
    }

    public BaseMutableTreeNode produceInit() {
        if(isSequence()) {
            return S1.produceInit();
        }
        return this;
    }

    public Set<BaseMutableTreeNode> produceFinals() {
        Set<BaseMutableTreeNode> finals = new HashSet<>();
        if(isSequence()) {
            finals = S2.produceFinals();
        }
        return finals;
    }

    public Collection<? extends UndirectedGraph<BaseMutableTreeNode,BaseMutableTreeNode>> produceFlows(FlowGraph graph) {
        Set<UndirectedGraph<BaseMutableTreeNode, BaseMutableTreeNode>> flows = new HashSet<>();
        if(isSequence()) {
            flows.addAll(S1.produceFlows(graph));
            flows.addAll(S2.produceFlows(graph));
            if(graph.getFinals().contains(this)) {
                UndirectedGraph<BaseMutableTreeNode,BaseMutableTreeNode> flow =
                        new SimpleGraph<BaseMutableTreeNode, BaseMutableTreeNode>(BaseMutableTreeNode.class);
                flow.addVertex(S1);
                flow.addVertex(S2);
                flow.addEdge(S1, S2);
                flows.add(flow);
            }
        }
        return flows;
    }

    /**
     * Check if this statement is S1;S2. If it is then do also the S1;S2 function
     */
    private boolean isSequence() {
        if(parent.getIndex(this) + 1 == parent.getChildCount()) {
            // Nothing next, not a sequence
            return false;
        }
        else {
            // It is a sequence, assign S1 and S2
            S1 = this;
            S2 = (BaseStatement) parent.getChildAt(parent.getIndex(this) + 1);

            return true;
        }
    }
}
