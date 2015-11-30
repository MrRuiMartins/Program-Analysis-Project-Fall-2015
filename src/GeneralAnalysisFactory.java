import dk.dtu.student.programanalysis.implementation.GeneralAnalysis;
import dk.dtu.student.programanalysis.implementation.analysis.AnalysisDetectionSigns;

import java.util.HashMap;

/**
 * Created by ruimartins on 23/11/2015.
 */
public class GeneralAnalysisFactory {

    private HashMap<String, GeneralAnalysis> analyses;

    public GeneralAnalysisFactory() {
        analyses = new HashMap<>();

        AnalysisDetectionSigns ds = new AnalysisDetectionSigns();

        analyses.put(ds.getName(), ds);

    }

    public GeneralAnalysis getInstance(String name) {
        return analyses.get(name);
    }
}
