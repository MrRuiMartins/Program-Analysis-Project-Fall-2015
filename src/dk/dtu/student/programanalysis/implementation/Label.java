package dk.dtu.student.programanalysis.implementation;

/**
 * Created by dx on 11/11/15.
 */
public class Label {

    private Class statementClass;

    public Label(Class statementClass) {
        this.statementClass = statementClass;
    }

    public Class getStatementClass() {
        return statementClass;
    }
}
