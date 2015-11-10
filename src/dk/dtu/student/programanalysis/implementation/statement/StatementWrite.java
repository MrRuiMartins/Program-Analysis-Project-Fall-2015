package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jgrapht.UndirectedGraph;

import java.util.Collection;
import java.util.Set;

/**
 * Created by dx on 9/21/15.
 */
public class StatementWrite extends BaseStatement {

    @Override
    public void parse(ParserRuleContext context) {
        
    }

    @Override
    public Collection<? extends BaseMutableTreeNode> produceLabels() {
        return null;
    }

    @Override
    public BaseMutableTreeNode produceInit() {
        return null;
    }

    @Override
    public Set<BaseMutableTreeNode> produceFinals() {
        return null;
    }

    @Override
    public Collection<? extends UndirectedGraph<BaseMutableTreeNode, BaseMutableTreeNode>> produceFlows(FlowGraph graph) {
        return null;
    }
}
