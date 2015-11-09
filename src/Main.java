import dk.dtu.student.programanalysis.IStatement;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayDeque;
import java.util.Stack;

public class Main {

    private static Stack<DefaultMutableTreeNode> vertexStack = new Stack<>();
    private static ArrayDeque<IStatement> statementQueue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        TheLangParser parser = new TheLangParser(tokens);
        TheLangListener listener = new TheLangBaseListener();
        parser.addParseListener(listener);

        try {
            TheLangParser.ProgramContext parserResult = parser.program();

            System.out.println();
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
}
