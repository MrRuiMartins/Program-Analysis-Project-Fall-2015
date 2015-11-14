package dk.dtu.student.programanalysis.implementation.set;

import dk.dtu.student.programanalysis.implementation.BaseSet;
import dk.dtu.student.programanalysis.implementation.Label;

import java.util.Collection;
import java.util.Objects;

/**
 * Created by dx on 11/12/15.
 */
public class IntervalSet<Label> extends BaseSet<Label> {

    @Override
    public boolean add(Label label) {
        if(this.size() > 0) {
            // TODO Interval has different kind of union
            Label intervalLabel = this.iterator().next();
            return super.add(label);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends Label> c) {
        boolean retval = true;
        for(Label label : c) {
            retval = this.add(label);
            if(!retval) break;
        }
        return retval;
    }

    @Override
    public boolean remove(Object o) {
        if(this.size() > 0) {
            // TODO Interval has different kind of removal
            Label intervalLabel = this.iterator().next();
            return super.remove(intervalLabel);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean retval = true;
        for(Object label : c) {
            retval = this.remove(label);
            if(!retval) break;
        }
        return retval;
    }
}
