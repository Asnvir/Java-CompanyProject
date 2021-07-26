package company.model.roles;

import company.model.WorkingTime;

import java.io.Serializable;

public interface Role extends Serializable {

    String getName();

    WorkingTime startTime();

    WorkingTime endTime();

    default Integer getStart() {
        return startTime().getStartTime();
    }

    default Integer getEnd() {
        return startTime().getStartTime() + 9;
    }

    boolean isChangeableTime();
}
