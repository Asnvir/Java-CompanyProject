package company;

import company.controller.Controller;
import company.model.Company;
import company.model.Department;
import company.model.employees.Employee;
import company.model.roles.AbstractRole;
import company.model.roles.Role;
import company.util.CompanyUtil;
import company.util.exceptions.IllegalNameException;
import company.util.exceptions.IllegalTimeException;
import company.view.CompanyView;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    public static final int HOURS_IN_MONTHS = 160;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Company model = new Company();
        Controller controller = new Controller(model);
        CompanyView view = new CompanyView(primaryStage, controller);
        view.show();
    }
}

//todo
//  1. Имена ?
//  2. Company (1) -> (M) Department
//  3. Company (1) -> (M) Role
//  4. Company (1) -> (M) Employee
//  5. Department (1) -> (M) Employee
//  6. Role (1) -> (M) Employee
//  7. Employee (1) -> (1) Preference
//  8. Role (1) -> (1) Preference ?????