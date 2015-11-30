package dk.dtu.student.programanalysis.implementation;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by dx on 11/9/15.
 */
public class ArithmeticExpression extends BaseMutableTreeNode {
    private int leftValue;
    private int rightValue;
    private OPERAND operand;

    public ArithmeticExpression() {

    }

    public ArithmeticExpression(int l, int r, OPERAND o) {
        this.leftValue = l;
        this.rightValue = r;
        this.operand = o;
    }

    public int getLeftValue() {
        return leftValue;
    }

    public int getRightValue() {
        return rightValue;
    }

    public OPERAND getOperand() {
        return operand;
    }

    @Override
    public void parseTreeNode() {
        ParserRuleContext context = (ParserRuleContext) this.userObject;

        if(context.getChild(0).getChild(0).getChild(0).getClass() == TerminalNodeImpl.class) {
            this.leftValue = Integer.parseInt(context.getChild(0).getChild(0).getChild(1).getText()) * (-1);
        }
        else{
            this.leftValue = Integer.parseInt(context.getChild(0).getChild(0).getChild(0).getChild(0).getText());
        }
        if(context.getChildCount()>1) {
            this.operand = parseOperand(context.getChild(1).getText());

            if(context.getChild(2).getChild(0).getChild(0).getClass() == TerminalNodeImpl.class) {
                this.rightValue = Integer.parseInt(context.getChild(2).getChild(0).getChild(1).getChild(0).getText()) * (-1);
            }
            else
                this.rightValue = Integer.parseInt(context.getChild(2).getChild(0).getChild(0).getChild(0).getText());
        }
    }

    public OPERAND parseOperand(String stringOperand) {
        if(stringOperand.equals("+")) {
            return OPERAND.ADDITION;
        }
        else if(stringOperand.equals("-")) {
            return OPERAND.SUBTRACTION;
        }
        else if(stringOperand.equals("/")) {
            return OPERAND.DIVISION;
        }
        else if(stringOperand.equals("*")) {
            return OPERAND.MULTIPLICATION;
        }
        return null;
    }
}
