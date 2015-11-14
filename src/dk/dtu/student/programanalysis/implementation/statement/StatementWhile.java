package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BaseSet;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jgrapht.UndirectedGraph;
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
    public Collection<? extends UndirectedGraph<Label, Label>> produceFlows(FlowGraph graph) {
        Set<UndirectedGraph<Label, Label>> flows = new HashSet<>();

        flows.addAll(super.produceFlows(graph));

        UndirectedGraph<Label, Label> flowLToInitS =
                new SimpleGraph<Label, Label>(Label.class);

        flowLToInitS.addVertex(getL());
        flowLToInitS.addVertex(S.produceInit());
        flowLToInitS.addEdge(getL(), S.produceInit());

        flows.add(flowLToInitS);

        // Extract all Ses flows
        BaseStatement tempS = S;
        while(tempS.isSequence()) {
//            flows.addAll(tempS.produceFlows(graph));
            tempS = tempS.getS2();
        }

        // Add last S to this while S
        UndirectedGraph<Label, Label> flowStempToL =
                new SimpleGraph<Label, Label>(Label.class);

        flowStempToL.addVertex(tempS.produceInit());
        flowStempToL.addVertex(getL());
        flowStempToL.addEdge(tempS.produceInit(), getL());

        flows.add(flowStempToL);

        return flows;
    }

    public BaseStatement getS() {
        return S;
    }

    public void setS(BaseStatement s) {
        S = s;
    }
}
