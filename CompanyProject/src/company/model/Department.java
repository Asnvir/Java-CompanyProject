package company.model;

import company.model2.WorkingTime;
import company.util.JobTime;

import java.util.ArrayList;
import java.util.List;

public class Department implements DepartmentInterface {

    private String name;
    private WorkingTime time;
    private boolean isSynchronous;
    private boolean isFixedTime;
    private boolean homeAllowed;
    private List<Employee> employees;

    public Department(String name, WorkingTime time, boolean isSynchronous, boolean isFixedTime, boolean homeAllowed) {
        this.name = name;
        this.time = time;
        this.employees = new ArrayList<>();
        this.isSynchronous = isSynchronous;
        this.isFixedTime = isFixedTime;
        this.homeAllowed = homeAllowed;
    }

    public WorkingTime startTime() {
        return time;
    } //TODO можно ли тут написать this.time вместо time

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
        if (isSynchronous) { //TODO можно ли тут написать  this.isSynchronous вместо isSynchronous
            employee.setFactStartTime(time); //TODO можно ли тут написать this.time вместо time
        } else {
            employee.setFactStartTimeAsPreferred();
        }
        employee.setHome(isHomeAllowed()); //TODO можно ли эту строку написать внутри else сверху?
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
