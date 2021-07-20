package company.model;

import company.model2.WorkingTime;
import company.util.JobTime;

import java.io.Serializable;

public interface Role extends Serializable {

    WorkingTime startTime();

    WorkingTime endTime();

}
