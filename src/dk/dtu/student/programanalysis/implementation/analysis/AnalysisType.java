package dk.dtu.student.programanalysis.implementation.analysis;

/**
 * Created by ruimartins on 23/11/2015.
 */
public abstract class AnalysisType {

    public abstract boolean containsAll( AnalysisType a2);
    public abstract void Union(AnalysisType a2);
}
