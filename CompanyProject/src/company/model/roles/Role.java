package company.model.roles;

import company.model.WorkingTime;
import company.util.CompanyUtil;

import java.io.Serializable;

public interface Role extends Serializable {

    String getName();

    WorkingTime startTime();

    WorkingTime endTime();

    default Integer getStart() {
        return startTime().getStartTime();
    }

    default String getEnd() {
        return CompanyUtil.convertTime(startTime().getStartTime() + 9);
    }

    boolean isChangeableTime();
}
