package company.model;

import company.model2.WorkingTime;
import company.util.JobTime;

public class RoleAbstractFixedTime extends RoleAbstract {
    static final long serialVersionUID = 126L;

    public RoleAbstractFixedTime(String name, WorkingTime start) {
        super(name, start);
    }

    @Override
    public WorkingTime endTime() {
        return new WorkingTime(startTime().getStartTime()+9);
    }

    @Override
    public void setStart(WorkingTime start) {
        throw new UnsupportedOperationException("This is Fixed time role");
    }
}
