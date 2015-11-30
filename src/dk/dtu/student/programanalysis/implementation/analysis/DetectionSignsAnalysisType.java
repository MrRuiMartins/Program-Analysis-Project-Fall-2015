package dk.dtu.student.programanalysis.implementation.analysis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ruimartins on 23/11/2015.
 */
public class DetectionSignsAnalysisType extends AnalysisType{

    private Map<String, DetectionSignsLattice> value;

    public DetectionSignsAnalysisType()
    {
        value = new HashMap<>();
    }

    public DetectionSignsAnalysisType(String s, DetectionSignsLattice lat)
    {
        value = new HashMap<>();
        value.put(s, lat);

    }

    public Map<String, DetectionSignsLattice> GetValue()
    {
        return this.value;
    }

    public void addValue(String s, DetectionSignsLattice lat) {
        value.put(s, lat);
    }

    public DetectionSignsLattice unionValue(String s, DetectionSignsLattice lat) {
        DetectionSignsLattice old = this.value.get(s);
        lat.union(old.getSigns());
        return lat;
    }


    @Override
    public boolean containsAll(AnalysisType previous) {

        DetectionSignsAnalysisType ds2 = (DetectionSignsAnalysisType) previous;

        if(this.value.isEmpty()) return false;
        for (Map.Entry<String, DetectionSignsLattice> entry : ds2.GetValue().entrySet())
        {
            DetectionSignsLattice old = this.value.get(entry.getKey());
            if(!old.getSigns().containsAll(entry.getValue().getSigns())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void Union(AnalysisType previous) {

        DetectionSignsAnalysisType ds2 = (DetectionSignsAnalysisType) previous;

        for (Map.Entry<String, DetectionSignsLattice> entry : ds2.GetValue().entrySet())
        {
            DetectionSignsLattice old = this.value.get(entry.getKey());
            old.union(entry.getValue().getSigns());

        }
        return;
    }


}
