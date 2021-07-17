package company.model;

import company.util.JobTime;

import java.util.ArrayList;
import java.util.List;

public abstract class DepartmentAbstract implements Department {
    private JobTime start;
    private String name;
    private List<Role> roles;


    public DepartmentAbstract(String name, JobTime start) {
        this.start = start;
        this.name = name;
        roles = new ArrayList<>();
    }

    public JobTime startTime() {
        return start;
    }

    @Override
    public void addRole(Role role) {
        roles.add(role);
    }

    public String getName() {
        return name;
    }

    public void setStart(JobTime start) {
        this.start = start;
    }

}
