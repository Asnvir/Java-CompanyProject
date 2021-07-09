package company.model;

import company.util.JobTime;

import java.io.Serializable;

public interface Role extends Serializable {

    JobTime startTime();

    JobTime endTime();

}
