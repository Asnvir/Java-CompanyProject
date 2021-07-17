package company.model;

import company.util.JobTime;

public class RoleAbstractFixedTime extends RoleAbstract {
    static final long serialVersionUID = 126L;

    public RoleAbstractFixedTime(String name, JobTime start) {
        super(name, start);
    }

    @Override
    public JobTime endTime() {
        return new JobTime(startTime().getHour()+9, startTime().getMinute());
    }

    @Override
    public void setStart(JobTime start) {
        throw new UnsupportedOperationException("This is Fixed time role");
    }
}
