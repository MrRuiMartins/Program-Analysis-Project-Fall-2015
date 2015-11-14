package dk.dtu.student.programanalysis.implementation.statement;

import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import org.antlr.v4.runtime.ParserRuleContext;
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
    public Collection<? extends UndirectedGraph<Label, Label>> produceFlows(FlowGraph graph) {
        Set<UndirectedGraph<Label, Label>> flows = new HashSet<>();

        BaseStatement endingStatement = super.getS2();

        //FLOW to S1
        UndirectedGraph<Label, Label> flowToS1 =
                new SimpleGraph<Label, Label>(Label.class);

        flowToS1.addVertex(getL());
        flowToS1.addVertex(S1.produceInit());
        flowToS1.addEdge(getL(), S1.produceInit());

        flows.add(flowToS1);

        //FLOW to S2
        UndirectedGraph<Label, Label> flowToS2 =
                new SimpleGraph<Label, Label>(Label.class);

        flowToS2.addVertex(getL());
        flowToS2.addVertex(S2.produceInit());
        flowToS2.addEdge(getL(), S2.produceInit());

        flows.add(flowToS2);

        if(endingStatement != null) {
            // Extract all S1es flows
            BaseStatement tempS1 = S1;
            while (tempS1.isSequence()) {
                tempS1 = tempS1.getS2();
            }

            // Add last S to ending S
            UndirectedGraph<Label, Label> flowS1tempToL =
                    new SimpleGraph<Label, Label>(Label.class);

            flowS1tempToL.addVertex(tempS1.produceInit());
            flowS1tempToL.addVertex(endingStatement.getL());
            flowS1tempToL.addEdge(tempS1.produceInit(), endingStatement.getL());

            flows.add(flowS1tempToL);

            // Extract all S2es flows
            BaseStatement tempS2 = S2;
            while(tempS2.isSequence()) {
                tempS2 = tempS2.getS2();
            }

            // Add last S2 to ending S
            UndirectedGraph<Label, Label> flowS2tempToL =
                    new SimpleGraph<Label, Label>(Label.class);

            flowS2tempToL.addVertex(tempS2.produceInit());
            flowS2tempToL.addVertex(endingStatement.getL());
            flowS2tempToL.addEdge(tempS2.produceInit(), endingStatement.getL());

            flows.add(flowS2tempToL);
        }

        return flows;
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
