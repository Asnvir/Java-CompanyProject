package company.model;

import company.model2.WorkingTime;
import company.util.JobTime;

import java.util.ArrayList;
import java.util.List;

public class Department implements DepartmentInterface {
    private boolean homeAllowed;
    private WorkingTime time;
    private String name;
    private boolean isSynchronous;
    private boolean isFixedTime;

    private List<Employee> employees;

    public Department(String name, WorkingTime time, boolean sync, boolean fixed, boolean homeAllowed) {
        this.time = time;
        this.name = name;
        this.employees = new ArrayList<>();
        isSynchronous = sync;
        isFixedTime = fixed;
        this.homeAllowed = homeAllowed;
    }

    public WorkingTime startTime() {
        return time;
    }

    @Override
    public WorkingTime endTime() {
        return new WorkingTime(startTime().getStartTime() + 9);
    }

    @Override
    public boolean isHomeAllowed() {
        return homeAllowed;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        if (isSynchronous) {
            employee.setFactStartTime(time);
        } else {
            employee.setFactStartTimeAsPreferred();
        }
        employee.setHome(isHomeAllowed());
    }

    public String getName() {
        return name;
    }

    public void setTime(WorkingTime time) {
        if (isFixedTime) throw new UnsupportedOperationException("This department can't change work time");
        else {
            this.time = time;
            if (isSynchronous) {
                for (Employee employee : employees) {
                    employee.setFactStartTime(time);
                }
            }
        }
    }


}
