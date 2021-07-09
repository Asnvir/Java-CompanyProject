package company.model;

import company.util.JobTime;

public class FlowTimeDepartment extends AbstractDepartment {

    private static final long serialVersionUID = 8L;

    public FlowTimeDepartment(String name, JobTime start) {
        super(name, start);
    }

    @Override
    public JobTime endTime() {
        return new JobTime(startTime().getHour()+9, startTime().getMinute());
    }
}
