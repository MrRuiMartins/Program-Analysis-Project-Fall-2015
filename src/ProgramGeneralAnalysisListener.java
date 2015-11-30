import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.GeneralAnalysis;
import dk.dtu.student.programanalysis.implementation.RootTreeNode;
import org.antlr.v4.runtime.ParserRuleContext;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Stack;

/**
 * Created by dx on 11/9/15.
 */
public class ProgramGeneralAnalysisListener extends TheLangBaseListener {

    Stack<BaseMutableTreeNode> parentNodes = new Stack<>();

    private BaseMutableTreeNode rootTree;

    private RuleContextGeneralFactory ruleContextFactory;

    public ProgramGeneralAnalysisListener(GeneralAnalysis analysis) {
        ruleContextFactory = new RuleContextGeneralFactory(analysis);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);

        BaseMutableTreeNode node = ruleContextFactory.produceNode(ctx.getClass(), ctx);

        if(node == null) return;

        node.setUserObject(ctx);

        if(node.getClass() == RootTreeNode.class) {
            rootTree = node;
        }
        if(parentNodes.size() > 0) {
            DefaultMutableTreeNode parent = parentNodes.peek();
            parent.add(node);
            node.setParent(parent);
        }
        parentNodes.push(node);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);

        if(parentNodes.size() > 0) {
            BaseMutableTreeNode node = parentNodes.peek();
            ParserRuleContext nodeCtx = (ParserRuleContext)node.getUserObject();

            if(nodeCtx == ctx) {
                parentNodes.pop();
                ruleContextFactory.parseNode(node, ctx);
            }
        }
    }

    public BaseMutableTreeNode getRootTree() {
        return rootTree;
    }
}
