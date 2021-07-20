package company.model;

import company.model2.WorkType;
import company.model2.WorkingTime;
import company.util.JobTime;

import java.io.Serializable;

public abstract class RoleAbstract implements Serializable, Role {
    static final long serialVersionUID = 124L;

    private String name;
    private WorkingTime start;
    private Employee employee;

    public RoleAbstract(String name, WorkingTime start) {
        this.name = name;
        this.start = start;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public WorkingTime startTime() {
        return start;
    }

    public String getName() {
        return name;
    }

    public void setStart(WorkingTime start) {
        this.start = start;
    }
}
