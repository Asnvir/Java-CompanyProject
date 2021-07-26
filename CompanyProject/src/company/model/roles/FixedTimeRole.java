package company.model.roles;

import company.model.WorkingTime;

public class FixedTimeRole extends AbstractRole {
    static final long serialVersionUID = 126L;

    public FixedTimeRole(String name, WorkingTime start) {
        super(name, start);
    }

    @Override
    public WorkingTime endTime() {
        return new WorkingTime(startTime().getStartTime()+9);
    }

    @Override
    public boolean isChangeableTime() {
        return false;
    }

    @Override
    public void setStart(WorkingTime start) {
        throw new UnsupportedOperationException("This is Fixed time role");
    }

    @Override
    public String toString() {
        return getName() + " : fixed time";
    }
}
