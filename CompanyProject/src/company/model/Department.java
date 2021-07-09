package company.model;

import company.util.JobTime;

import java.io.Serializable;

public interface Department extends Serializable {

    JobTime startTime();

    JobTime endTime();

    void addRole(Role role);

}
