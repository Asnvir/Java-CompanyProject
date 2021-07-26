package company.controller;

import company.Main;
import company.model.Company;
import company.model.WorkingTime;
import company.model.roles.FixedTimeRole;
import company.model.roles.FlowTimeRole;
import company.model.roles.Role;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {
    private Main view;
    private Company company;

    public Controller(Main view) {
        company = new Company();
        this.view = view;
    }

    public List<Role> createRole(TextField nameOfRoleTextField, TextField startTimeOfRoleTextField, CheckBox changeableTimeOfRoleChckBox) {
        String name = nameOfRoleTextField.getText();
        int startTime = Integer.parseInt(startTimeOfRoleTextField.getText());
        boolean isChangeableTime = changeableTimeOfRoleChckBox.isSelected();
        Role role;
        if (isChangeableTime) {
            role = new FlowTimeRole(name, new WorkingTime(startTime));
        } else {
            role = new FixedTimeRole(name, new WorkingTime(startTime));
        }
        company.addRole(role);
        return company.getRoles();
    }
}
