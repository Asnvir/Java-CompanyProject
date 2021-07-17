package company.model;

import company.util.JobTime;

public class RoleAbstractFlowTime extends RoleAbstract {
    static final long serialVersionUID = 125L;

    public RoleAbstractFlowTime(String name, JobTime start) {
        super(name, start);
    }

    @Override
    public JobTime endTime() {
        return new JobTime(startTime().getHour()+9, startTime().getMinute());
    }
}
