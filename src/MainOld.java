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

public class MainOld {

    private static UndirectedGraph<String, BaseStatement> cfg =
            new SimpleGraph<String, BaseStatement>(BaseStatement.class);
/*
    public static void main(String[] args) throws Exception {
        // Check number of input
        if(args.length < 2) {
            System.out.println("Not enough parameter! java -jar programAnalysis.jar <Analysis> <Input file> ");
            return;
        }

        // Parse the analysis input
        String analysisString = args[0];

        // Get Analysis from factory
        AnalysisFactory analysisFactory = new AnalysisFactory();
        BaseAnalysis analysis = analysisFactory.getInstance(analysisString);

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

//            CommonTree t = (CommonTree) parserResult.getTree();
//            CommonTree t2 = (CommonTree) t.getChild(0);
//            int startToken = t2.getTokenStartIndex();
//            int stopToken = t2.getTokenStopIndex();
//            CommonToken token = (CommonToken) t2.getToken();
//            System.out.println(token.getText());
//
//            if (parserResult != null) {
//                CommonTree tree = (CommonTree) parserResult.tree;
//                System.out.println(tree.toStringTree());
//            }
        } catch (RecognitionException e) {
            e.printStackTrace();
        }

    }
    */
}