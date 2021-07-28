package company.controller;

import company.model.Company;
import company.model.Department;
import company.model.WorkingTime;
import company.model.roles.FixedTimeRole;
import company.model.roles.FlowTimeRole;
import company.model.roles.Role;
import company.util.CompanyUtil;
import company.util.exceptions.IllegalNameException;
import company.util.exceptions.IllegalTimeException;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {

    private Company model;

    public Controller(Company company) {
        model = company;
    }

    public List<Role> createRole(TextField nameOfRoleTextField, TextField startTimeOfRoleTextField, CheckBox changeableTimeOfRoleChckBox) throws IllegalNameException, IllegalTimeException {
        String name = nameOfRoleTextField.getText();
        if (!CompanyUtil.isNameCorrect(name))
            throw new IllegalNameException("\"" + name + "\" is illegal. Name must contain english letters only!");
        int startTime = Integer.parseInt(startTimeOfRoleTextField.getText());
        if (!CompanyUtil.isTimeCorrect(startTime))
            throw new IllegalTimeException("\"" + startTime + "\" is illegal. Start time must be in 0..23");
        boolean isChangeableTime = changeableTimeOfRoleChckBox.isSelected();
        Role role;
        if (isChangeableTime) {
            role = new FlowTimeRole(name, new WorkingTime(startTime));
        } else {
            role = new FixedTimeRole(name, new WorkingTime(startTime));
        }
        model.addRole(role);
        return model.getRoles();
    }

    public List<Department> createDepartment(TextField nameOfDepartmentTextField, TextField startTimeOfDepartmentTextField, CheckBox fixedTimeOfDepartmentChckBox, CheckBox synchronisableDepartmentChckBox, CheckBox homeDepartmentChckBox) throws IllegalNameException, IllegalTimeException {
        String name = nameOfDepartmentTextField.getText();
        if (!CompanyUtil.isNameCorrect(name))
            throw new IllegalNameException("\"" + name + "\" is incorrect. Department's name must contain english letters only!");
        int startTime = Integer.parseInt(startTimeOfDepartmentTextField.getText());
        if (!CompanyUtil.isTimeCorrect(startTime))
            throw new IllegalTimeException("\"" + startTime + "\" is incorrect. Time must be in range 0-23 hours");
        boolean isFixedTime = fixedTimeOfDepartmentChckBox.isSelected();
        boolean isSynchronisable = synchronisableDepartmentChckBox.isSelected();
        boolean isHomeAllowed = homeDepartmentChckBox.isSelected();
        Department department = new Department(name, new WorkingTime(startTime), isSynchronisable, isFixedTime, isHomeAllowed);
        model.add(department);
        return model.getDepartments();
    }

//    public List<Department> getListOfDepartments() throws NullPointerException {
//        if (model.getDepartments() == null) throw new NullPointerException("The are no departments in company yet.");
//        return model.getDepartments();
//    }
}
