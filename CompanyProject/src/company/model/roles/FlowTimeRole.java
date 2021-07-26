package company.model.roles;

import company.model.WorkingTime;

public class FlowTimeRole extends AbstractRole {
    static final long serialVersionUID = 125L;

    public FlowTimeRole(String name, WorkingTime start) {
        super(name, start);
    }

    @Override
    public WorkingTime endTime() {
        return new WorkingTime(startTime().getStartTime()+9);
    }

    @Override
    public boolean isChangeableTime() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + " : flow time";
    }
}
