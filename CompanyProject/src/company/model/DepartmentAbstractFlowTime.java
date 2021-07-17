package company.model;

import company.util.JobTime;

public class DepartmentAbstractFlowTime extends DepartmentAbstract {

    private static final long serialVersionUID = 8L;

    public DepartmentAbstractFlowTime(String name, JobTime start) {
        super(name, start);
    }

    @Override
    public JobTime endTime() {
        return new JobTime(startTime().getHour()+9, startTime().getMinute());
    }
}
