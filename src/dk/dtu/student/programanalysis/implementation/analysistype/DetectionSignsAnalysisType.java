package dk.dtu.student.programanalysis.implementation.analysistype;

import dk.dtu.student.programanalysis.implementation.IAnalysisType;

import java.util.HashSet;

/**
 * Created by ruimartins on 23/11/2015.
 */
public class DetectionSignsAnalysisType implements IAnalysisType {

    public enum Signs {
        NEGATIVE, POSITIVE, ZERO;
    }

    private String symbol;
    private Signs sign;

    public DetectionSignsAnalysisType(String symbol) {
        super();
        this.symbol = symbol;
    }

    public DetectionSignsAnalysisType(String symbol, Signs sign) {
        super();
        this.symbol = symbol;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign.toString();
    }
}
