package company.model;

import company.util.JobTime;

public class FlowTimeRole extends AbstractRole {
    static final long serialVersionUID = 125L;

    public FlowTimeRole(String name, JobTime start) {
        super(name, start);
    }

    @Override
    public JobTime endTime() {
        return new JobTime(startTime().getHour()+9, startTime().getMinute());
    }
}
