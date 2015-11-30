package dk.dtu.student.programanalysis.implementation.analysis;

import dk.dtu.student.programanalysis.implementation.set.Signs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ruimartins on 23/11/2015.
 */
public class DetectionSignsLattice{

    private Set<Signs> signs;
    public DetectionSignsLattice()
    {
        signs = new HashSet<>();
    }

    public Set<Signs> getSigns()
    {
        return this.signs;
    }

    public void add(Signs s) {
        signs.add(s);
    }

    public void union(Set<Signs> s)
    {
        this.signs.addAll(s);
    }
}
