package dk.dtu.student.programanalysis.implementation;

import org.antlr.v4.runtime.ParserRuleContext;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by dx on 11/9/15.
 */
public abstract class BaseMutableTreeNode extends DefaultMutableTreeNode {

    public abstract void parse(ParserRuleContext context);

}
