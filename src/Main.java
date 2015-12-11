import dk.dtu.student.programanalysis.implementation.BaseAnalysis;
import dk.dtu.student.programanalysis.implementation.BaseMutableTreeNode;
import dk.dtu.student.programanalysis.implementation.BaseStatement;
import dk.dtu.student.programanalysis.implementation.Label;
import dk.dtu.student.programanalysis.implementation.graph.FlowGraph;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Enumeration;

public class Main {

    private static UndirectedGraph<String, BaseStatement> cfg =
            new SimpleGraph<String, BaseStatement>(BaseStatement.class);

    public static void main(String[] args) throws Exception {
        // Check number of input
        if(args.length < 2) {
            System.out.println("Not enough parameter! java -jar programAnalysis.jar <Analysis> <Input file> " +
                    "[Worklist Algorithm]");
            return;
        }

        long startTime = System.currentTimeMillis();

        // Parse the analysis input
        String analysisString = args[0];

        // Get Analysis from factory
        AnalysisFactory analysisFactory = new AnalysisFactory();
        BaseAnalysis analysis = analysisFactory.getInstance(analysisString);

        // Get Worklist algorithm if specified
        if(args.length > 2) {
            String worklist = args[2];
            if(worklist.equals("LIFO")) {
                analysis.setWorklistAlgorithm(BaseAnalysis.WorklistAlgorithm.LIFO);
            }
            else if(worklist.equals("FIFO")) {
                analysis.setWorklistAlgorithm(BaseAnalysis.WorklistAlgorithm.FIFO);
            }
        }

        TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(args[1]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        TheLangParser parser = new TheLangParser(tokens);
        ProgramAnalysisListener listener = new ProgramAnalysisListener(analysis);
        parser.addParseListener(listener);

        try {
            TheLangParser.ProgramContext parserResult = parser.program();

            BaseMutableTreeNode rootTree = listener.getRootTree();
            FlowGraph graph = new FlowGraph();

            Enumeration en = rootTree.preorderEnumeration();
            int i = 1;
            while (en.hasMoreElements()) {

                // Unfortunately the enumeration isn't genericised so we need to downcast
                // when calling nextElement():
                BaseMutableTreeNode node = (BaseMutableTreeNode) en.nextElement();
                ParserRuleContext object = (ParserRuleContext) node.getUserObject();

                if(BaseStatement.class.isAssignableFrom(node.getClass())) {
                    BaseStatement statement = (BaseStatement) node;
                    graph.processStatement(statement);

                    System.out.println("label-" + i++ + ": " + object.getText());
                }

            }

            analysis.doAnalysis(graph);

            System.out.println(analysis.printResult());

        } catch (RecognitionException e) {
            e.printStackTrace();
        } finally {
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Program is running for: " + totalTime + " ms");

            System.out.println("Iteration : " + analysis.getNumberOfIteration() + " times");

        }

    }

}