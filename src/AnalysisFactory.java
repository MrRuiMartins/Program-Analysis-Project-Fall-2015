import dk.dtu.student.programanalysis.implementation.BaseAnalysis;
import dk.dtu.student.programanalysis.implementation.analysis.AnalysisReachingDefinition;

import java.util.HashMap;

/**
 * Created by dx on 11/12/15.
 */
public class AnalysisFactory {

    private HashMap<String, BaseAnalysis> analysises;

    public AnalysisFactory() {
        analysises = new HashMap<>();

        AnalysisReachingDefinition rd = new AnalysisReachingDefinition();

        analysises.put(rd.getName(), rd);
    }

    public BaseAnalysis getInstance(String name) {
        return analysises.get(name);
    }
}
