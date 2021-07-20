package company.model;

import company.model2.WorkingTime;
import company.util.JobTime;

import java.io.Serializable;

public interface DepartmentInterface extends Serializable {

    WorkingTime startTime();

    WorkingTime endTime();

    boolean isHomeAllowed();

    void addEmployee(Employee employee);
}
