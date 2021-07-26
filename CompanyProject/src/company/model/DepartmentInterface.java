package company.model;

import company.model.employees.Employee;

import java.io.Serializable;

public interface DepartmentInterface extends Serializable {

    WorkingTime startTime();

    WorkingTime endTime();

    boolean isHomeAllowed();

    void addEmployee(Employee employee);
}
