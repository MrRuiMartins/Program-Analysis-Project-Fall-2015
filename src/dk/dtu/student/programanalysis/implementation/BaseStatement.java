package dk.dtu.student.programanalysis.implementation;

import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import dk.dtu.student.programanalysis.implementation.label.LabelLine;
import dk.dtu.student.programanalysis.implementation.set.IntervalSet;
import org.antlr.runtime.CommonToken;
import org.jgrapht.DirectedGraph;
import org.jgrapht.Graph;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dx on 11/5/15.
 */
public abstract class BaseStatement extends BaseMutableTreeNode {

    private Label l;
    private BaseStatement S1, S2;
    private boolean isNotSequence = false;

    public Collection<? extends Label> produceLabels() {
        Set<Label> labels = new HashSet<>();
        labels.add(getL());
        if(isSequence()) {
            labels.add(S1.getL());
            labels.add(S2.getL());
        }
        return labels;
    }

    public Label produceInit() {
        if(isSequence() && S1 != this) {
            return S1.produceInit();
        }
        return this.getL();
    }

    public Set<Label> produceFinals() {
        Set<Label> finals = new HashSet<>();
        if(isSequence()) {
            finals.add(S2.getL());
        }
        else {
            finals.add(getL());
        }
        return finals;
    }

    public DirectedGraph<Label,DefaultEdge> produceFlows(DirectedGraph<Label,DefaultEdge> graph) {
        if(isSequence()) {
            System.out.println("Adding flow from " + S1.getL().toString() + " to " + S2.getL().toString());

            graph.addVertex(S1.getL());
            graph.addVertex(S2.getL());
            graph.addEdge(S1.getL(), S2.getL());
        }
        return graph;
    }

    /**
     * Check if this statement is S1;S2. If it is then do also the S1;S2 function
     */
    public boolean isSequence() {
        if(parent.getIndex(this) + 1 == parent.getChildCount() || isNotSequence) {
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

    public Label getL() {
        return l;
    }

    public void setL(Label l) {
        this.l = l;
    }

    public BaseStatement getS1() {
        return S1;
    }

    public BaseStatement getS2() {
        return S2;
    }

    public void setIsNotSequence(boolean isNotSequence) {
        this.isNotSequence = isNotSequence;
    }

}
