package company.model;

import company.model.employees.Employee;
import company.model.roles.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Department> departments = new ArrayList<>();
    private List<Role> roles = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public void add(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addEmployee(Employee employee, DepartmentInterface department, Role role) {
        employees.add(employee);
        department.addEmployee(employee);
        //role.addEmployee(employee);
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
