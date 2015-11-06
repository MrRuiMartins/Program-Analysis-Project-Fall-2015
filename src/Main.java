import dk.dtu.student.programanalysis.IStatement;
import dk.dtu.student.programanalysis.StatementFactory;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.util.ArrayDeque;

public class Main {

    private static ArrayDeque<IStatement> statementQueue = new ArrayDeque<>();

    public static void pushStatement(CommonToken start, String type) {
        StatementFactory factory = new StatementFactory();
        IStatement statement = factory.createInstance(type, null);

        statement.setStartToken(start);
        statementQueue.push(statement);
    }

    public static void popStatement(CommonToken end) {
        IStatement statement = statementQueue.pop();

        statement.setEndToken(end);
        statement.parse();
    }

    public static void main(String[] args) throws Exception {
        TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        TheLangParser parser = new TheLangParser(tokens);

        try {
            TheLangParser.program_return parserResult = parser.program();

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
