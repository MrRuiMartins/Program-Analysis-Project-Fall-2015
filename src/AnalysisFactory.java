import dk.dtu.student.programanalysis.implementation.BaseAnalysis;
import dk.dtu.student.programanalysis.implementation.analysis.AnalysisDetectionSigns;
import dk.dtu.student.programanalysis.implementation.analysis.AnalysisReachingDefinition;

import java.util.HashMap;

/**
 * Created by dx on 11/12/15.
 */
public class AnalysisFactory {

    private HashMap<String, BaseAnalysis> analyses;

    public AnalysisFactory() {
        analyses = new HashMap<>();

        AnalysisReachingDefinition rd = new AnalysisReachingDefinition();
        AnalysisDetectionSigns ds = new AnalysisDetectionSigns();

        analyses.put(rd.getName(), rd);
        analyses.put(ds.getName(), ds);

    }

    public BaseAnalysis getInstance(String name) {
        return analyses.get(name);
    }
}
