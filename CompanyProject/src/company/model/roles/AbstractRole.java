package company.model.roles;

import company.model.employees.Employee;
import company.model.WorkingTime;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractRole implements Serializable, Role {
    static final long serialVersionUID = 124L;

    private String name;
    private WorkingTime start;

    public AbstractRole(String name, WorkingTime start) {
        this.name = name;
        this.start = start;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractRole)) return false;
        AbstractRole that = (AbstractRole) o;
        return Objects.equals(name, that.name) && Objects.equals(start, that.start);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, start);
    }
}
