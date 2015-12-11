package dk.dtu.student.programanalysis.implementation.analysis;

import dk.dtu.student.programanalysis.implementation.IAnalysisType;
import dk.dtu.student.programanalysis.implementation.ArithmeticExpression;
import dk.dtu.student.programanalysis.implementation.BaseAnalysis;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.analysistype.DetectionSignsAnalysisType;
import dk.dtu.student.programanalysis.implementation.declaration.DeclarationArrayInteger;
import dk.dtu.student.programanalysis.implementation.declaration.DeclarationInteger;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import dk.dtu.student.programanalysis.implementation.set.SignSet;
import dk.dtu.student.programanalysis.implementation.statement.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import java.util.*;

/**
 * Created by ruimartins on 23/11/2015.
 */
public class AnalysisDetectionSigns extends BaseAnalysis {

    Map<String, SignSet> extremeValuesList;

    Map<Label, SignSet> DSEnter;
    Map<Label, SignSet> DSLeave;

    public AnalysisDetectionSigns() {
        extremeValuesList = new HashMap<>();
        DSLeave = new HashMap<>();
        DSEnter = new HashMap<>();

    }

    @Override
    public String getName() {
        return "DetectionSigns";
    }
    @Override
    public void parse(StatementAssign node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
        node.parseTreeNode();
    }

    @Override
    public void parse(StatementAssignArray node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
        node.parseTreeNode();
    }

    @Override
    public void parse(StatementIf node, ParserRuleContext context) {
        super.parse(node, context);

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementRead node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementReadArray node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
        node.parseTreeNode();
    }

    @Override
    public void parse(StatementSkip node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWhile node, ParserRuleContext context) {
        super.parse(node, context);

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWrite node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWriteArray node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(DeclarationInteger node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(DeclarationArrayInteger node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new Label(node.getClass(), node, firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
        node.parseTreeNode();
    }

    @Override
    public void doAnalysis(FlowGraph graph) {
        produceExtremes(graph);
        super.doAnalysis(graph);
        System.out.println();
    }

    private void produceExtremes(FlowGraph graph) {
        Set<Label> labels =  (Set<Label>) graph.getLabels();

        for(Label label : labels) {
            SignSet iota = new SignSet();
            iota.add(DetectionSignsAnalysisType.Signs.ZERO);
            iota.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
            iota.add(DetectionSignsAnalysisType.Signs.POSITIVE);

            //produce extremes.
            this.extremeValuesList.put(label.getSymbol(), iota);
        }

    }

    @Override
    protected Set<? extends IAnalysisType> getExtremeValue(Set<? extends Label> labels) {
        SignSet extremeValues = new SignSet();

        return extremeValues;
    }

    @Override
    protected Set<? extends IAnalysisType> getBottomValue() {
        return new SignSet<>();
    }

    @Override
    protected Set<? extends IAnalysisType> analyseComponent(Label l) {

        if(l.getStatementClass() == DeclarationInteger.class)
        {
            SignSet current = DSEnter.get(l);

            current.add(DetectionSignsAnalysisType.Signs.ZERO);
            setAnalysisResult(l, current);
            DSLeave.put(l, current);
            return current;
        }
        if(l.getStatementClass() == DeclarationArrayInteger.class)
        {
            SignSet current = DSEnter.get(l);

            current.add(DetectionSignsAnalysisType.Signs.ZERO);
            setAnalysisResult(l, current);
            DSLeave.put(l, current);
            return current;
        }
        if(l.getStatementClass() == StatementAssign.class)
        {
            String symbol = l.getSymbol();
            SignSet current = new SignSet();

            StatementAssign node = (StatementAssign)l.getNode();
            ArithmeticExpression expression = node.getExpression();

            current.addAll(calculateLatticeFromExpression(expression));
            setAnalysisResult(l, current);
            DSLeave.put(l, current);
            return current;

        }

        if(l.getStatementClass() == StatementAssignArray.class)
        {
            SignSet current = DSEnter.get(l);

            StatementAssignArray node = (StatementAssignArray)l.getNode();
            ArithmeticExpression expression = node.getExpression();

            if(ExpressionGreaterThanZero(expression)) {

                current.addAll(calculateLatticeFromExpression(expression));

                setAnalysisResult(l, current);
                DSLeave.put(l, current);
                return current;
            }
            else
            {
                throw new IllegalArgumentException("Array declarations can not start with non-positive numbers.");
            }

        }

        if(l.getStatementClass() == StatementReadArray.class)
        {
            SignSet current = DSEnter.get(l);

            StatementReadArray node = (StatementReadArray)l.getNode();
            ArithmeticExpression expression = node.getExpression();

            if(ExpressionGreaterThanOrEqualToZero(expression)) {
                current.add(DetectionSignsAnalysisType.Signs.ZERO);
                current.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
                current.add(DetectionSignsAnalysisType.Signs.POSITIVE);
                setAnalysisResult(l, current);
                DSLeave.put(l, current);
                return current;
            }
            else
            {
                throw new IllegalArgumentException("Array declarations can not start with non-positive numbers.");
            }
        }
        if(l.getStatementClass() == StatementSkip.class)
        {
            SignSet current = DSEnter.get(l);
            setAnalysisResult(l, current);
            DSLeave.put(l, current);
            return current;

        }
        if(l.getStatementClass() == StatementWhile.class)
        {
            SignSet current = DSEnter.get(l);
            setAnalysisResult(l, current);
            DSLeave.put(l, current);
            return current;

        }
        if(l.getStatementClass() == StatementWrite.class)
        {
            SignSet current = DSEnter.get(l);
            setAnalysisResult(l, current);
            DSLeave.put(l, current);
            return current;

        }
        if(l.getStatementClass() == StatementRead.class)
        {
            String symbol = l.getSymbol();
            SignSet current = DSEnter.get(l);

            SignSet iota = new SignSet();
            iota.add(DetectionSignsAnalysisType.Signs.ZERO);
            iota.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
            iota.add(DetectionSignsAnalysisType.Signs.POSITIVE);

            current.addAll(iota);
            setAnalysisResult(l, current);
            DSLeave.put(l, current);
            return current;
        }

        return new SignSet<>();
    }

    private Set<DetectionSignsAnalysisType.Signs> calculateLatticeFromExpression(ArithmeticExpression expression) {
        Set<DetectionSignsAnalysisType.Signs> result = new HashSet<>();

        if(expression.getOperand() != null ) {
            switch (expression.getOperand()) {
                case ADDITION:
                    if(expression.getLeftValue() > 0 && expression.getRightValue() < 0) {
                        result.add(DetectionSignsAnalysisType.Signs.POSITIVE);
                        result.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
                        result.add(DetectionSignsAnalysisType.Signs.ZERO);
                    }
                    else if(expression.getLeftValue() < 0 && expression.getRightValue() > 0) {
                        result.add(DetectionSignsAnalysisType.Signs.POSITIVE);
                        result.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
                        result.add(DetectionSignsAnalysisType.Signs.ZERO);
                    }
                    else if(expression.getLeftValue() == 0 && expression.getRightValue() == 0) {
                        result.add(DetectionSignsAnalysisType.Signs.ZERO);
                    }
                    else if(expression.getLeftValue() < 0 || expression.getRightValue() < 0) {
                        result.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
                    }
                    else {
                        result.add(DetectionSignsAnalysisType.Signs.POSITIVE);
                    }

                    break;
                case SUBTRACTION:
                    if(expression.getLeftValue() < 0 && expression.getRightValue() < 0) {
                        result.add(DetectionSignsAnalysisType.Signs.POSITIVE);
                        result.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
                        result.add(DetectionSignsAnalysisType.Signs.ZERO);
                    }
                    else if(expression.getLeftValue() > 0 && expression.getRightValue() > 0) {
                        result.add(DetectionSignsAnalysisType.Signs.POSITIVE);
                        result.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
                        result.add(DetectionSignsAnalysisType.Signs.ZERO);
                    }
                    else if(expression.getLeftValue() == 0 && expression.getRightValue() == 0) {
                        result.add(DetectionSignsAnalysisType.Signs.ZERO);
                    }
                    else if(expression.getLeftValue() > 0 || expression.getRightValue() < 0) {
                        result.add(DetectionSignsAnalysisType.Signs.POSITIVE);
                    }
                    else {
                        result.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
                    }
                    break;
                case MULTIPLICATION:
                    if(expression.getLeftValue() == 0 || expression.getRightValue() == 0) {
                        result.add(DetectionSignsAnalysisType.Signs.ZERO);
                    }
                    else if(expression.getLeftValue() > 0 && expression.getRightValue() > 0) {
                        result.add(DetectionSignsAnalysisType.Signs.POSITIVE);
                    }
                    else if(expression.getLeftValue() < 0 && expression.getRightValue() < 0) {
                        result.add(DetectionSignsAnalysisType.Signs.POSITIVE);
                    }
                    else result.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
                    break;
                case DIVISION:
                    if(expression.getRightValue() == 0) {
                        throw new IllegalArgumentException("Division by zero.");
                    }
                    else if(expression.getLeftValue() == 0 ) {
                        result.add(DetectionSignsAnalysisType.Signs.ZERO);
                    }
                    else if(expression.getLeftValue() < 0 && expression.getRightValue() < 0) {
                        result.add(DetectionSignsAnalysisType.Signs.POSITIVE);
                    }
                    else if(expression.getLeftValue() > 0 && expression.getRightValue() > 0) {
                        result.add(DetectionSignsAnalysisType.Signs.POSITIVE);
                    }
                    else result.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
                    break;
            }
            return result;
        }
        else {
            result.clear();
            if(expression.getLeftValue() > 0 ) {
                result.add(DetectionSignsAnalysisType.Signs.POSITIVE);
            }
            else if(expression.getLeftValue() < 0) {
                result.add(DetectionSignsAnalysisType.Signs.NEGATIVE);
            }
            else{
                result.add(DetectionSignsAnalysisType.Signs.ZERO);
            }
            return result;
        }
    }
    private boolean ExpressionGreaterThanOrEqualToZero(ArithmeticExpression expression) {
        float result = Integer.MIN_VALUE;

        if(expression.getOperand() != null ) {
            switch (expression.getOperand()) {
                case ADDITION:
                    result = expression.getLeftValue() + expression.getRightValue();
                    break;
                case SUBTRACTION:
                    result = expression.getLeftValue() - expression.getRightValue();
                    break;
                case MULTIPLICATION:
                    result = expression.getLeftValue() * expression.getRightValue();
                    break;
                case DIVISION:
                    result = expression.getLeftValue() / expression.getRightValue();
                    break;
            }
            return result >= 0;
        }
        else {
            return expression.getLeftValue() >= 0;
        }
    }

    private boolean ExpressionGreaterThanZero(ArithmeticExpression expression) {

        float result = Integer.MIN_VALUE;

        if(expression.getOperand() != null ) {
            switch (expression.getOperand()) {
                case ADDITION:
                    result = expression.getLeftValue() + expression.getRightValue();
                    break;
                case SUBTRACTION:
                    result = expression.getLeftValue() - expression.getRightValue();
                    break;
                case MULTIPLICATION:
                    result = expression.getLeftValue() * expression.getRightValue();
                    break;
                case DIVISION:
                    result = expression.getLeftValue() / expression.getRightValue();
                    break;
            }
            return result > 0;
        }
        else {
            return expression.getLeftValue() > 0;
        }
    }

    @Override
    protected Set<DetectionSignsAnalysisType> getAnalysisResult(Label l) {
        return DSEnter.get(l);
    }


    @Override
    protected void setAnalysisResult(Label l, Set<? extends IAnalysisType> newSet) {
        DSEnter.put(l, (SignSet) newSet);
    }

    @Override
    public String printResult()
    {
        String result = "";
        Iterator it = this.DSLeave.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Label key = (Label) pair.getKey();
            SignSet<DetectionSignsAnalysisType.Signs> response =
                    (SignSet<DetectionSignsAnalysisType.Signs>) pair.getValue();
            result += "DS after leaving line: " + key.getLineNumber() + "\n";
            result += key.getSymbol() + " could be: \n";
            for (DetectionSignsAnalysisType.Signs entry : response)
            {
                result += "> " + entry + "\n";
            }
        }
        return result;
    }
}
