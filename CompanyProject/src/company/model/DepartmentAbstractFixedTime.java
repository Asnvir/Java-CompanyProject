package company.model;

import company.util.JobTime;

public class DepartmentAbstractFixedTime extends DepartmentAbstract {
    private static final long serialVersionUID = 9L;

    public DepartmentAbstractFixedTime(String name, JobTime start) {
        super(name, start);
    }

    @Override
    public JobTime endTime() {
        return new JobTime(startTime().getHour()+9, startTime().getMinute());
    }

    @Override
    public void setStart(JobTime start) {
        throw new UnsupportedOperationException("This is Fixed time department");
    }
}