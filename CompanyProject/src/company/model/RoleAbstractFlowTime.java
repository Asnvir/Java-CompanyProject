package company.model;

import company.model2.WorkingTime;
import company.util.JobTime;

public class RoleAbstractFlowTime extends RoleAbstract {
    static final long serialVersionUID = 125L;

    public RoleAbstractFlowTime(String name, WorkingTime start) {
        super(name, start);
    }

    @Override
    public WorkingTime endTime() {
        return new WorkingTime(startTime().getStartTime()+9);
    }
}
