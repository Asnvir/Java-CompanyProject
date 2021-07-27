package company.model;

import company.model.employees.Employee;
import company.model.roles.Role;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Department implements DepartmentInterface {

    private String name;
    private WorkingTime time;
    private boolean isSynchronous;
    private boolean isFixedTime;
    private boolean homeAllowed;
    private final List<Employee> employees; // создается один раз, можно лишь добавлять и удалять людей из него.
    private final Set<Role> roles;

    public Department(String name, WorkingTime time, boolean isSynchronous, boolean isFixedTime, boolean homeAllowed) {
        this.name = name;
        this.time = time;
        this.employees = new ArrayList<>();
        this.roles = new LinkedHashSet<>(); // чтобы избежать добавления одинаковых ролей
        this.isSynchronous = isSynchronous;
        this.isFixedTime = isFixedTime;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Role> getRoles() {
        return new ArrayList<>(roles);
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

//    TODO if (deaprtament isFixedTime) {
//

}
