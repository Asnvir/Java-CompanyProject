package company.model;

import company.util.JobTime;

import java.io.Serializable;

public abstract class RoleAbstract implements Serializable, Role {
    static final long serialVersionUID = 124L;

    private String name;
    private JobTime start;
    private Employee employee;

    public RoleAbstract(String name, JobTime start) {
        this.name = name;
        this.start = start;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public JobTime startTime() {
        return start;
    }

    public String getName() {
        return name;
    }

    public void setStart(JobTime start) {
        this.start = start;
    }
}
