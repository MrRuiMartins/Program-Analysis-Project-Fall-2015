package dk.dtu.student.programanalysis.implementation.analysis;

import dk.dtu.student.programanalysis.implementation.ArithmeticExpression;
import dk.dtu.student.programanalysis.implementation.BaseAnalysis;
import dk.dtu.student.programanalysis.implementation.GeneralAnalysis;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.declaration.DeclarationArrayInteger;
import dk.dtu.student.programanalysis.implementation.declaration.DeclarationInteger;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import dk.dtu.student.programanalysis.implementation.label.LabelDS;
import dk.dtu.student.programanalysis.implementation.set.Signs;
import dk.dtu.student.programanalysis.implementation.statement.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import javax.xml.soap.DetailEntry;
import java.util.*;

/**
 * Created by ruimartins on 23/11/2015.
 */
public class AnalysisDetectionSigns extends GeneralAnalysis {

    DetectionSignsLattice iota;
    DetectionSignsLattice zeroLattice;
    DetectionSignsLattice negativeLattice;
    DetectionSignsLattice positiveLattice;
    DetectionSignsAnalysisType extremalValue;

    DetectionSignsAnalysisType bottom;
    Map<LabelDS, DetectionSignsAnalysisType> DSEnter;
    Map<LabelDS, DetectionSignsAnalysisType> DSLeave;


    public AnalysisDetectionSigns() {

        zeroLattice = new DetectionSignsLattice();
        zeroLattice.add(Signs.ZERO);

        negativeLattice = new DetectionSignsLattice();
        negativeLattice.add(Signs.NEGATIVE);

        positiveLattice = new DetectionSignsLattice();
        positiveLattice.add(Signs.POSITIVE);

        iota = new DetectionSignsLattice();
        iota.add(Signs.ZERO);
        iota.add(Signs.POSITIVE);
        iota.add(Signs.NEGATIVE);
        extremalValue = new DetectionSignsAnalysisType();
        bottom = new DetectionSignsAnalysisType();
        DSLeave = new HashMap<>();
        DSEnter = new HashMap<>();

    }

    @Override
    public String getName() {
        return "DetectionSigns";
    }
    @Override
    public void parse(StatementAssign node, ParserRuleContext context) {
        ArithmeticExpression e = new ArithmeticExpression();
        e.setUserObject(context.getChild(2));
        e.parseTreeNode();
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelDS(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine(), e);

        node.setL(label);
    }

    @Override
    public void parse(StatementAssignArray node, ParserRuleContext context) {

        ArithmeticExpression e = new ArithmeticExpression();
        e.setUserObject(context.getChild(2));
        e.parseTreeNode();

        ArithmeticExpression e2 = new ArithmeticExpression();
        e2.setUserObject(context.getChild(5));
        e2.parseTreeNode();
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelDS(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine(), e, e2);

        node.setL(label);
    }

    @Override
    public void parse(StatementIf node, ParserRuleContext context) {
        super.parse(node, context);

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelDS(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementRead node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new LabelDS(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementReadArray node, ParserRuleContext context) {
        ArithmeticExpression e = new ArithmeticExpression();
        e.setUserObject(context.getChild(3));
        e.parseTreeNode();

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new LabelDS(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine(), e);

        node.setL(label);
    }

    @Override
    public void parse(StatementSkip node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelDS(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWhile node, ParserRuleContext context) {
        super.parse(node, context);

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelDS(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(StatementWrite node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(0);
        Label label = new LabelDS(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(DeclarationInteger node, ParserRuleContext context) {
        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new LabelDS(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine());

        node.setL(label);
    }

    @Override
    public void parse(DeclarationArrayInteger node, ParserRuleContext context) {
        // Initiating our ArithmeticExpression
        ArithmeticExpression e = new ArithmeticExpression();
        e.setUserObject(context.getChild(3));
        e.parseTreeNode();

        // Get Symbol for line
        TerminalNodeImpl firstTerminal = (TerminalNodeImpl) context.getChild(1);
        Label label = new LabelDS(node.getClass(), firstTerminal.getSymbol().getText(),
                context.getStart().getLine(), e);

        node.setL(label);
    }

    @Override
    public void doAnalysis(FlowGraph graph) {
        assignBottomAndProduceExtremes(graph);
        super.doAnalysis(graph);
        System.out.println();
    }

    private void assignBottomAndProduceExtremes(FlowGraph graph) {

        Set<LabelDS> labels =  (Set<LabelDS>) graph.getLabels();

        for(LabelDS label : labels) {
            bottom.addValue(label.getSymbol(), new DetectionSignsLattice());
            //produce extremes.
            extremalValue.addValue(label.getSymbol(), iota);
        }

    }


    private void populateFunctions(FlowGraph graph) {

        Set<LabelDS> labels = (Set<LabelDS>) graph.getLabels();
        for(LabelDS l : labels) {
            DetectionSignsLattice lat = calculateSignsOfLabel(l);
        }


    }

    private DetectionSignsLattice calculateSignsOfLabel(LabelDS l) {

        return new DetectionSignsLattice();
    }

    private void produceFunctions(FlowGraph graph, Label l) {


    }

    @Override
    protected DetectionSignsAnalysisType getExtremeValue(Set<? extends Label> labels) {
        return extremalValue;
    }



    @Override
    protected  DetectionSignsAnalysisType getBottomValue() {
        return bottom;

    }

    protected DetectionSignsLattice getZeroLattice() {
        return zeroLattice;
    }

    @Override
    protected DetectionSignsAnalysisType analyseComponent(Label l) {

        if(l.getStatementClass() == DeclarationInteger.class)
        {
            String symbol = ((LabelDS) l).getSymbol();
            DetectionSignsAnalysisType current = DSEnter.get(l);
            current.addValue(symbol, getZeroLattice());
            setAnalysisResult(l, current);
            DSLeave.put((LabelDS) l, current);
            return current;

        }
        if(l.getStatementClass() == DeclarationArrayInteger.class)
        {
            String symbol = ((LabelDS) l).getSymbol();
            DetectionSignsAnalysisType current = DSEnter.get(l);


            if(ExpressionGreaterThanZero(((LabelDS) l).getExpression())) {
                current.addValue(symbol, getZeroLattice());
                setAnalysisResult(l, current);
                DSLeave.put((LabelDS) l, current);
                return current;
            }
            else
            {
                throw new IllegalArgumentException("Array declarations can not start with non-positive numbers.");
            }
        }
        if(l.getStatementClass() == StatementAssign.class)
        {
            String symbol = ((LabelDS) l).getSymbol();
            DetectionSignsAnalysisType current = DSEnter.get(l);

            current.addValue(symbol, calculateLatticeFromExpression(((LabelDS) l).getExpression()));
            setAnalysisResult(l, current);
            DSLeave.put((LabelDS) l, current);
            return current;

        }

        if(l.getStatementClass() == StatementAssignArray.class)
        {
            String symbol = ((LabelDS) l).getSymbol();
            DetectionSignsAnalysisType current = DSEnter.get(l);

            if(ExpressionGreaterThanZero(((LabelDS) l).getExpression())) {

                DetectionSignsLattice newLattice = current.unionValue(symbol, calculateLatticeFromExpression(((LabelDS) l).getExpression2()));
                DetectionSignsAnalysisType newAnalysis = new DetectionSignsAnalysisType();

                for (Map.Entry<String, DetectionSignsLattice> entry : current.GetValue().entrySet()) {
                    newAnalysis.addValue(entry.getKey(), entry.getValue());
                }
                newAnalysis.addValue(symbol, newLattice);
                setAnalysisResult(l, newAnalysis);
                DSLeave.put((LabelDS) l, newAnalysis);
                return newAnalysis;
            }
            else
            {
                throw new IllegalArgumentException("Array declarations can not start with non-positive numbers.");
            }

        }

        if(l.getStatementClass() == StatementReadArray.class)
        {
            String symbol = ((LabelDS) l).getSymbol();
            DetectionSignsAnalysisType current = DSEnter.get(l);

            if(ExpressionGreaterThanOrEqualToZero(((LabelDS) l).getExpression())) {
                current.addValue(symbol, iota);
                setAnalysisResult(l, current);
                DSLeave.put((LabelDS) l, current);
                return current;
            }
            else
            {
                throw new IllegalArgumentException("Array declarations can not start with non-positive numbers.");
            }
        }
        if(l.getStatementClass() == StatementSkip.class)
        {
            DetectionSignsAnalysisType current = DSEnter.get(l);
            setAnalysisResult(l, current);
            DSLeave.put((LabelDS) l, current);
            return current;

        }
        if(l.getStatementClass() == StatementWhile.class)
        {
            DetectionSignsAnalysisType current = DSEnter.get(l);
            setAnalysisResult(l, current);
            DSLeave.put((LabelDS) l, current);
            return current;

        }
        if(l.getStatementClass() == StatementWrite.class)
        {
            DetectionSignsAnalysisType current = DSEnter.get(l);
            setAnalysisResult(l, current);
            DSLeave.put((LabelDS) l, current);
            return current;

        }
        if(l.getStatementClass() == StatementRead.class)
        {
            String symbol = ((LabelDS) l).getSymbol();
            DetectionSignsAnalysisType current = DSEnter.get(l);
            current.addValue(symbol, iota);
            setAnalysisResult(l, current);
            DSLeave.put((LabelDS) l, current);
            return current;
        }

        return new DetectionSignsAnalysisType();
    }

    private DetectionSignsLattice calculateLatticeFromExpression(ArithmeticExpression expression) {
        DetectionSignsLattice result = new DetectionSignsLattice();

        if(expression.getOperand() != null ) {
            switch (expression.getOperand()) {
                case ADDITION:
                    if(expression.getLeftValue() > 0 && expression.getRightValue() < 0) {
                        result.add(Signs.POSITIVE);
                        result.add(Signs.NEGATIVE);
                        result.add(Signs.ZERO);
                    }
                    else if(expression.getLeftValue() < 0 && expression.getRightValue() > 0) {
                        result.add(Signs.POSITIVE);
                        result.add(Signs.NEGATIVE);
                        result.add(Signs.ZERO);
                    }
                    else if(expression.getLeftValue() == 0 && expression.getRightValue() == 0) {
                        result.add(Signs.ZERO);
                    }
                    else if(expression.getLeftValue() < 0 || expression.getRightValue() < 0) {
                        result.add(Signs.NEGATIVE);
                    }
                    else {
                        result.add(Signs.POSITIVE);
                    }

                    break;
                case SUBTRACTION:
                    if(expression.getLeftValue() < 0 && expression.getRightValue() < 0) {
                        result.add(Signs.POSITIVE);
                        result.add(Signs.NEGATIVE);
                        result.add(Signs.ZERO);
                    }
                    else if(expression.getLeftValue() > 0 && expression.getRightValue() > 0) {
                        result.add(Signs.POSITIVE);
                        result.add(Signs.NEGATIVE);
                        result.add(Signs.ZERO);
                    }
                    else if(expression.getLeftValue() == 0 && expression.getRightValue() == 0) {
                        result.add(Signs.ZERO);
                    }
                    else if(expression.getLeftValue() > 0 || expression.getRightValue() < 0) {
                        result.add(Signs.POSITIVE);
                    }
                    else {
                        result.add(Signs.NEGATIVE);
                    }
                    break;
                case MULTIPLICATION:
                    if(expression.getLeftValue() == 0 || expression.getRightValue() == 0) {
                        result.add(Signs.ZERO);
                    }
                    else if(expression.getLeftValue() > 0 && expression.getRightValue() > 0) {
                        result.add(Signs.POSITIVE);
                    }
                    else if(expression.getLeftValue() < 0 && expression.getRightValue() < 0) {
                        result.add(Signs.POSITIVE);
                    }
                    else result.add(Signs.NEGATIVE);
                    break;
                case DIVISION:
                    if(expression.getRightValue() == 0) {
                        throw new IllegalArgumentException("Division by zero.");
                    }
                    else if(expression.getLeftValue() == 0 ) {
                        result.add(Signs.ZERO);
                    }
                    else if(expression.getLeftValue() < 0 && expression.getRightValue() < 0) {
                        result.add(Signs.POSITIVE);
                    }
                    else if(expression.getLeftValue() > 0 && expression.getRightValue() > 0) {
                        result.add(Signs.POSITIVE);
                    }
                    else result.add(Signs.NEGATIVE);
                    break;
            }
            return result;
        }
        else {
            if(expression.getLeftValue() >0 ) {
                return positiveLattice;
            }
            else if(expression.getLeftValue() < 0) {
                return negativeLattice;
            }
            else{
                return zeroLattice;
            }
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
    protected DetectionSignsAnalysisType getAnalysisResult(Label l) {
        return DSEnter.get((LabelDS)l);
    }


    @Override
    protected void setAnalysisResult(Label l, AnalysisType newSet) {
        DSEnter.put((LabelDS)l, (DetectionSignsAnalysisType) newSet);
    }

    @Override
    public String printResult()
    {
        String result = "";
        Iterator it = this.DSLeave.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            LabelDS key = (LabelDS) pair.getKey();
            DetectionSignsAnalysisType response = (DetectionSignsAnalysisType) pair.getValue();
            result += "DS after leaving line: " + key.getLineNumber() + "\n";
            for (Map.Entry<String, DetectionSignsLattice> entry : response.GetValue().entrySet())
            {
                result += entry.getKey() + "\n";
                for(Signs s : entry.getValue().getSigns()) {
                        result += "/" + s.name() + "\n";
                }
            }
        }
        return result;
    }
}
