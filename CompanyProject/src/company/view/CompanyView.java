package company.view;

import company.controller.Controller;
import company.model.Department;
import company.model.employees.Employee;
import company.model.roles.Role;
import company.util.CompanyUtil;
import company.util.exceptions.IllegalNameException;
import company.util.exceptions.IllegalTimeException;
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

public class CompanyView {

    private final Stage primaryStage;
    private final BorderPane rootPane;

    //Department
    private ListView<Department> departmentsListView;
    private TableView<Department> departmentDetailTable;
    private ListView<Role> rolesByDepartmentListView;
    private TextField nameOfDepartmentTextField;
    private TextField startTimeOfDepartmentTextField;
    private TextField endTimeOfDepartmentTextField;
    private CheckBox fixedTimeOfDepartmentChckBox;
    private CheckBox synchronisableDepartmentChckBox;
    private CheckBox homeAllowedChckBox;
    private ComboBox<Role> roleCMBoxDepartTab;
    //Role
//    private ListView<AbstractRole> rolesListView;
    private TableView<Role> detailsOfRoleTable;
    //    private ListView<Employee> employeesByRoleListView;
    private TextField nameOfRoleTextField;
    private TextField startTimeOfRoleTextField;
    private TextField endTimeOfRoleTextField;
    private CheckBox changeableTimeOfRoleChckBox;
    //    private ComboBox roleCMBoxRoleTab;
//    private ComboBox employeeCMBoxRoleTab;
    //Employee
    private ListView<Department> departmentListView;
    private TableView<Employee> employeeDetailTable;
    private TextField nameOfEmployeeTextField;
    private ComboBox<String> preferenceOfEmployeeCMbox;
    private ComboBox<String> typeOfSalaryCMbox;
    private ComboBox<Role> roleOfEmployeeCMbox;
    private TextField startTimeOfEmployeeTextField;
    private TextField endTimeOfEmployeeTextField;

    public CompanyView(Stage primaryStage, Controller controller) {
        //Configure the main BorderPane
        BorderPane rootPane = new BorderPane();
//        rootPane.setMinWidth(1150);
//        rootPane.setPrefWidth(1150);
//        rootPane.setMinHeight(800);
//        rootPane.setPrefHeight(800);

        VBox topRootVbox = new VBox();

//HBbox  with calc and show buttons
        HBox hboxWithBtns = new HBox();
        hboxWithBtns.setPadding(new Insets(10));

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button showResultsPerEmployeeBtn = new Button("Show results per employee");
        showResultsPerEmployeeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button showResultsPerDepartmentBtn = new Button("Show results per departments");
        showResultsPerDepartmentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button showResultsPerCompanyBtn = new Button("Show results per company");
        showResultsPerCompanyBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        hboxWithBtns.getChildren().addAll(calculateBtn, showResultsPerEmployeeBtn, showResultsPerDepartmentBtn, showResultsPerCompanyBtn);
        topRootVbox.getChildren().addAll(hboxWithBtns);

//Creation of the rootTabPane
        TabPane rootTabPane = new TabPane();
        rootTabPane.setMinWidth(1150);
        rootTabPane.setPrefWidth(1150);
//        rootTabPane.setMinHeight(745);
//        rootTabPane.setPrefHeight(745);

//Start of Department Tab

        Tab departmentTab = new Tab("Department");
        departmentTab.setClosable(false);

        //departmentsBorderPane
        BorderPane departmentBorderPane = new BorderPane();
//        departmentBorderPane.setMinWidth(1150);
//        departmentBorderPane.setPrefWidth(1150);
////        departmentBorderPane.setMinHeight(720);
////        departmentBorderPane.setPrefHeight(720);
        Label departmentsDetailedInfoLbl = new Label("Department's detailed information");
        departmentsDetailedInfoLbl.setFont(new Font(18));
        BorderPane.setAlignment(departmentsDetailedInfoLbl, Pos.CENTER);

        //departmentsDetailTable TableView (Table of department's details)
        departmentDetailTable = new TableView<>();
//        departmentDetailTable.setMinWidth(750);
//        departmentDetailTable.setPrefWidth(750);


        //Department's name Column
        TableColumn<Department, String> nameOfDepartmentColumn = new TableColumn<>("Name");
//        nameOfDepartmentColumn.setMinWidth(230);
//        nameOfDepartmentColumn.setPrefWidth(230);
        nameOfDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Department's start time column
        TableColumn<Department, Integer> startTimeOfDepartmentColumn = new TableColumn<>("Start time");
//        startTimeOfDepartmentColumn.setMinWidth(125);
//        startTimeOfDepartmentColumn.setPrefWidth(125);
        startTimeOfDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("start"));

        //Department's end time column
        TableColumn<Department, String> endTimeOfDepartmentColumn = new TableColumn<>("End time");
//        endTimeOfDepartmentColumn.setMinWidth(120);
//        endTimeOfDepartmentColumn.setPrefWidth(120);
        endTimeOfDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("end"));

        //Department's changeable time column
        TableColumn<Department, Boolean> changeableTimeDepartmentColumn = new TableColumn<>("Fixed time");
//        changeableTimeDepartmentColumn.setMinWidth(120);
//        changeableTimeDepartmentColumn.setPrefWidth(120);
        changeableTimeDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("fixedTime"));

        //Department's synchronisable column
        TableColumn<Department, Boolean> synchronisableDepartmentColumn = new TableColumn<>("Synchronised");
//        synchronisableDepartmentColumn.setMinWidth(100);
//        synchronisableDepartmentColumn.setPrefWidth(100);
        synchronisableDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("synchronous"));

        TableColumn<Department, Boolean> homeAllowedDepartmentColumn = new TableColumn<>("Home allowed");
        homeAllowedDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("homeAllowed"));

        departmentDetailTable.getColumns().addAll(nameOfDepartmentColumn, startTimeOfDepartmentColumn, endTimeOfDepartmentColumn, changeableTimeDepartmentColumn, synchronisableDepartmentColumn, homeAllowedDepartmentColumn);

        //rolesByDepartment ListView (List of department's roles)
        rolesByDepartmentListView = new ListView<>();
//        rolesByDepartmentListView.setMinWidth(200);
//        rolesByDepartmentListView.setPrefWidth(200);
        departmentDetailTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Department>() {
            @Override
            public void changed(ObservableValue<? extends Department> observable, Department oldValue, Department newValue) {
                if (newValue != null) {
                    rolesByDepartmentListView.setItems(FXCollections.observableList(newValue.getRoles()));
                }
            }
        });

        //end creation of big table of department's details

        //VBox bottonRootVboxOfDepartment that consists 2 hboxes - 1 for department creation - 2nd for adding a role to department
        VBox bottonRootVboxOfDepartment = new VBox();
//        bottonRootVboxOfDepartment.setMinWidth(1150);
//        bottonRootVboxOfDepartment.setPrefWidth(1150);
////        bottonRootVboxOfDepartment.setMinHeight(110);
////        bottonRootVboxOfDepartment.setPrefHeight(110);
        bottonRootVboxOfDepartment.setPadding(new Insets(10));

        //HBox of department's creation
        HBox departmentCreationHBox = new HBox();
//        departmentCreationHBox.setMinWidth(1140);
//        departmentCreationHBox.setPrefWidth(1140);
////        departmentCreationHBox.setMinHeight(45);
////        departmentCreationHBox.setPrefHeight(45);
        departmentCreationHBox.setSpacing(10.0);
        departmentCreationHBox.setPadding(new Insets(5));
        departmentCreationHBox.setAlignment(Pos.CENTER_LEFT);

        Label newDepartmentLabel = new Label("New department :");
        nameOfDepartmentTextField = new TextField();
        nameOfDepartmentTextField.setPromptText("Name");
        startTimeOfDepartmentTextField = new TextField();
        startTimeOfDepartmentTextField.setPromptText("Start time");
        endTimeOfDepartmentTextField = new TextField();
        endTimeOfDepartmentTextField.setPromptText("End time");
        endTimeOfDepartmentTextField.setEditable(false);
        startTimeOfDepartmentTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    int v = Integer.parseInt(newValue) + 9;
                    endTimeOfDepartmentTextField.setText(CompanyUtil.convertTime(v));
                } catch (NumberFormatException ignored) {
                }
            }
        });
        fixedTimeOfDepartmentChckBox = new CheckBox("Fixed time?");
        synchronisableDepartmentChckBox = new CheckBox("Synchronised?");
        homeAllowedChckBox = new CheckBox("Allowed home?");
        Button createDepartmentBtn = new Button("Create");
        createDepartmentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    List<Department> departments = controller.createDepartment(nameOfDepartmentTextField, startTimeOfDepartmentTextField, fixedTimeOfDepartmentChckBox, synchronisableDepartmentChckBox, homeAllowedChckBox);
                    departmentDetailTable.setItems(FXCollections.observableList(departments));

                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect start/end time");
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.show();
                } catch (IllegalNameException | IllegalTimeException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.show();
                }
            }
        });

        departmentCreationHBox.getChildren().addAll(newDepartmentLabel, nameOfDepartmentTextField, startTimeOfDepartmentTextField, endTimeOfDepartmentTextField, fixedTimeOfDepartmentChckBox, synchronisableDepartmentChckBox, homeAllowedChckBox, createDepartmentBtn);

        //Hbox of adding a role to department
        HBox roleAddingToDepartmentHbox = new HBox();
//        roleAddingToDepartmentHbox.setMinWidth(1140);
//        roleAddingToDepartmentHbox.setPrefWidth(1140);
////        addingRoleToDepartmentHbox.setMinHeight(45);
////        addingRoleToDepartmentHbox.setPrefHeight(45);
        roleAddingToDepartmentHbox.setSpacing(10.0);
        roleAddingToDepartmentHbox.setPadding(new Insets(5));
        roleAddingToDepartmentHbox.setAlignment(Pos.CENTER_LEFT);

        Label addRoleToDepartmentLabel = new Label("Add a role to department : ");
//        departmentCMBoxDepartTab = new ComboBox<>();
//        departmentCMBoxDepartTab.setPromptText("Department");
        roleCMBoxDepartTab = new ComboBox<>();
        roleCMBoxDepartTab.setPromptText("Role");
        Button addRoleToDepartmentBtn = new Button("Add");
        addRoleToDepartmentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Department department = departmentDetailTable.getSelectionModel().getSelectedItem();
                if (department == null) return;
                Role role = roleCMBoxDepartTab.getValue();
                if (role == null) return;
                department.addRole(role);
                rolesByDepartmentListView.setItems(FXCollections.observableList(department.getRoles()));
            }
        });
        roleAddingToDepartmentHbox.getChildren().addAll(addRoleToDepartmentLabel, roleCMBoxDepartTab, addRoleToDepartmentBtn);

        bottonRootVboxOfDepartment.getChildren().addAll(departmentCreationHBox, roleAddingToDepartmentHbox);


        //Construct the departmentsBorderPane
        departmentBorderPane.setTop(departmentsDetailedInfoLbl);
//        departmentBorderPane.setLeft(departmentsListView);
        departmentBorderPane.setCenter(departmentDetailTable);
        departmentBorderPane.setRight(rolesByDepartmentListView);
        departmentBorderPane.setBottom(bottonRootVboxOfDepartment);

        //Construct the departmentTab
        departmentTab.setContent(departmentBorderPane);


//End of Department Tab

//Start Of Roles Tab

        Tab roleTab = new Tab("Roles");
        roleTab.setClosable(false);

        //rolesBorderPane
        BorderPane roleBorderPane = new BorderPane();
//        roleBorderPane.setMinWidth(1150);
//        roleBorderPane.setPrefWidth(1150);
//       rolesBorderPane.setMinHeight(716);
//       rolesBorderPane.setPrefHeight(716);
        Label rolesLabel = new Label("Role's detailed information");
        rolesLabel.setFont(new Font(18));
        BorderPane.setAlignment(rolesLabel, Pos.CENTER);  //TODO rolesBorderPane.setAlignment или BorderPane.setAlignment

        //rolesListView ( List of roles by names)
//        rolesListView = new ListView<>();
//        rolesListView.setMinWidth(200);
//        rolesListView.setPrefWidth(200);
//        rolesListView.setMinHeight(579);
//        rolesListView.setPrefHeight(579);

        //Start creation of big table of role's details
        //detailsOfRole TableView (Table of roles' details)
        detailsOfRoleTable = new TableView<>();
//        detailsOfRoleTable.setMinWidth(750);
//        detailsOfRoleTable.setPrefWidth(750);
//        detailsOfRoleTable.setMinHeight(579);
//        detailsOfRoleTable.setPrefHeight(579);


        //Role's name column
        TableColumn<Role, String> nameOfRoleColumn = new TableColumn<>("Name");
//        nameOfRoleColumn.setMinWidth(420);
//        nameOfRoleColumn.setPrefWidth(420);
        nameOfRoleColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Role's start time column
        TableColumn<Role, Integer> startTimeOfRoleColumn = new TableColumn<>("Start time");
//        startTimeOfRoleColumn.setMinWidth(101);
//        startTimeOfRoleColumn.setPrefWidth(101);
        startTimeOfRoleColumn.setCellValueFactory(new PropertyValueFactory<>("start"));

        //Role's end time column
        TableColumn<Role, String> endTimeOfRoleColumn = new TableColumn<>("End time");
//        endTimeOfRoleColumn.setMinWidth(119);
//        endTimeOfRoleColumn.setPrefWidth(119);
        endTimeOfRoleColumn.setCellValueFactory(new PropertyValueFactory<>("end"));   //TODO продумать где прописать endTime of department


        //Role's changeable time column
        TableColumn<Role, Boolean> changeableTimeRoleColumn = new TableColumn<>("Changeable time"); //TODO прописать где-то в полях объекта Role или можно менять часы работы true/false
//        changeableTimeRoleColumn.setMinWidth(106);
//        changeableTimeRoleColumn.setPrefWidth(106);
        changeableTimeRoleColumn.setCellValueFactory(new PropertyValueFactory<>("changeableTime"));

        detailsOfRoleTable.getColumns().addAll(nameOfRoleColumn, startTimeOfRoleColumn, endTimeOfRoleColumn, changeableTimeRoleColumn);

        //employeesByRole ListView ( Lise of role's employees )
//        employeesByRoleListView = new ListView<>();
//        employeesByRoleListView.setMinWidth(200);
//        employeesByRoleListView.prefWidth(200);

        //end creation of big table of department's details

        //VBox bottomRootVboxOfRole that consists 2 HBoxe 1 - for role creation  2nd for adding an employee to Role
        VBox bottomRootVboxOfRole = new VBox();
//        bottomRootVboxOfRole.setMinWidth(1150);
//        bottomRootVboxOfRole.setPrefWidth(1150);
//        bottomRootVboxOfRole.setMinHeight(110);
//        bottomRootVboxOfRole.setPrefHeight(110);

        //HBOX of role's creation
        HBox roleCreationHBox = new HBox();
//        roleCreationHBox.setMinWidth(1140);
//        roleCreationHBox.setPrefWidth(1140);
//        roleCreationHBox.setMinHeight(45);
//        roleCreationHBox.setPrefHeight(45);
        roleCreationHBox.setSpacing(10.0);
        roleCreationHBox.setPadding(new Insets(5));
        roleCreationHBox.setAlignment(Pos.CENTER_LEFT);

        Label newRoleLabel = new Label("New role : ");
        nameOfRoleTextField = new TextField();
        nameOfRoleTextField.setPromptText("Name");
        startTimeOfRoleTextField = new TextField();
        startTimeOfRoleTextField.setPromptText("Start time");
        endTimeOfRoleTextField = new TextField();
        endTimeOfRoleTextField.setPromptText("End time");
        endTimeOfRoleTextField.setEditable(false);
        startTimeOfRoleTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    int v = Integer.parseInt(newValue) + 9;
                    endTimeOfRoleTextField.setText(CompanyUtil.convertTime(v));
                } catch (NumberFormatException ignored) {
                }
            }
        });
        changeableTimeOfRoleChckBox = new CheckBox("Time could be changeable?");
        Button createRoleBtn = new Button("Create");
        createRoleBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    List<Role> roles = controller.createRole(nameOfRoleTextField, startTimeOfRoleTextField, changeableTimeOfRoleChckBox);
                    detailsOfRoleTable.setItems(FXCollections.observableList(roles));
                    roleCMBoxDepartTab.setItems(FXCollections.observableList(roles));
                    roleOfEmployeeCMbox.setItems(FXCollections.observableList(roles));
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Incorrect start/end time");
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.show();
                } catch (IllegalNameException | IllegalTimeException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.show();
                }
            }
        });

        roleCreationHBox.getChildren().addAll(newRoleLabel, nameOfRoleTextField, startTimeOfRoleTextField, endTimeOfRoleTextField, changeableTimeOfRoleChckBox, createRoleBtn);

//        //HBox adding an employee to Role
//        HBox employeeAddingToRoleHbox = new HBox();
//        employeeAddingToRoleHbox.setMinWidth(1140);
//        employeeAddingToRoleHbox.setPrefWidth(1140);
////        employeeAddingToRoleHbox.setMinHeight(45);
////        employeeAddingToRoleHbox.setPrefHeight(45);
//        employeeAddingToRoleHbox.setSpacing(10.0);
//        employeeAddingToRoleHbox.setPadding(new Insets(5));
//        roleAddingToDepartmentHbox.setAlignment(Pos.CENTER_LEFT);
//
//        Label addEmployeeToRoleLabel = new Label("Add an employee to role : ");
//        roleCMBoxRoleTab = new ComboBox();
//        roleCMBoxRoleTab.setPromptText("Role");
//        employeeCMBoxRoleTab = new ComboBox();
//        employeeCMBoxRoleTab.setPromptText("Employee");
//        Button addEmployeeToRoleBtn = new Button("Add");
//        addEmployeeToRoleBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//
//            }
//        });
//        employeeAddingToRoleHbox.getChildren().addAll(addEmployeeToRoleLabel, roleCMBoxRoleTab, employeeCMBoxRoleTab, addEmployeeToRoleBtn);

        bottomRootVboxOfRole.getChildren().addAll(roleCreationHBox);


        //Construct the rolesBorderPane
        roleBorderPane.setTop(rolesLabel);
//        roleBorderPane.setLeft(rolesListView);
        roleBorderPane.setCenter(detailsOfRoleTable);
//        roleBorderPane.setRight(employeesByRoleListView);
        roleBorderPane.setBottom(bottomRootVboxOfRole);

        //Construct the roleTab
        roleTab.setContent(roleBorderPane); //TODO не уверен или так собирается Tab

//End of Role Tab

//Start of employee Tab

        Tab employeeTab = new Tab("Employee");
        employeeTab.setClosable(false);

        //employeeBorderPane
        BorderPane employeeBorderPane = new BorderPane();
//        employeeBorderPane.setMinWidth(1150);
//        employeeBorderPane.setPrefWidth(1150);
//        employeeBorderPane.setMinHeight(716);
//        employeeBorderPane.setPrefHeight(716);
        Label employeeLabel = new Label("Employee's detailed information");
        employeeLabel.setFont(new Font(18));
        BorderPane.setAlignment(employeeLabel, Pos.CENTER);

        //Start creation of big table of employee's details

        //employeeListView (List of departments by name)
        departmentListView = new ListView<>();
//        employeeListView.setMinWidth(200);
//        employeeListView.setPrefWidth(200);
//        employeeListView.setMinHeight(634);
//        employeeListView.setPrefHeight(634);

        //employeeDetailTable TableView (Table of department's details)
        employeeDetailTable = new TableView<>();
//        employeeDetailTable.setMinWidth(950);
//        employeeDetailTable.setPrefWidth(950);
//        employeeDetailTable.setMinHeight(634);
//        employeeDetailTable.setPrefHeight(634);

        //employee's name column
        TableColumn<Employee, String> nameOfEmployeeColumn = new TableColumn<>("Name");
//        nameOfEmployeeColumn.setMinWidth(182);
//        nameOfEmployeeColumn.setPrefWidth(182);
        nameOfEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //employee's preference column
        TableColumn<Employee, String> preferenceOfEmployeeColumn = new TableColumn<>("Preference");
//        preferenceOfEmployeeColumn.setMinWidth(204);
//        preferenceOfEmployeeColumn.setPrefWidth(204);
        preferenceOfEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("preference"));

        //employee's type of salary column
        TableColumn<Employee, String> typeOfEmployeeColumn = new TableColumn<>("Type of salary");
//        typeOfEmployeeColumn.setMinWidth(185);
//        typeOfEmployeeColumn.setPrefWidth(185);
        typeOfEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        //employee's role column
        TableColumn<Employee, String> roleOfEmployeeColumn = new TableColumn<>("Role");
//        roleOfEmployeeColumn.setMinWidth(197);
//        roleOfEmployeeColumn.setPrefWidth(197);
        roleOfEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        //employee's start time column
        TableColumn<Employee, Integer> startTimeOfEmployeeColumn = new TableColumn<>("Start time");
//        startTimeOfEmployeeColumn.setMinWidth(92);
//        startTimeOfEmployeeColumn.setPrefWidth(92);
        startTimeOfEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));

        //employee's end time column
        TableColumn<Employee, Integer> endTimeOfEmployeeColumn = new TableColumn<>("End time");
//        endTimeOfEmployeeColumn.setMinWidth(92);
//        endTimeOfEmployeeColumn.setPrefWidth(92);
        endTimeOfEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));

        employeeDetailTable.getColumns().addAll(nameOfEmployeeColumn, preferenceOfEmployeeColumn, typeOfEmployeeColumn, roleOfEmployeeColumn, startTimeOfEmployeeColumn, endTimeOfEmployeeColumn);

        //HBox of creating an employee
        HBox employeeCreationHBox = new HBox();
//        employeeCreationHBox.setMinWidth(1140);
//        employeeCreationHBox.setPrefWidth(1140);
//        employeeCreationHBox.setMinHeight(45);
//        employeeCreationHBox.setPrefHeight(45);
        employeeCreationHBox.setSpacing(10.0);
        employeeCreationHBox.setPadding(new Insets(5));
        employeeCreationHBox.setAlignment(Pos.CENTER_LEFT);

        Label newEmployeeLabel = new Label("New employee : ");
        nameOfEmployeeTextField = new TextField();
        nameOfEmployeeTextField.setPromptText("Name");
        preferenceOfEmployeeCMbox = new ComboBox<>();
        preferenceOfEmployeeCMbox.setItems(FXCollections.observableArrayList("No changes", "Early", "Late", "Home"));
        preferenceOfEmployeeCMbox.setPromptText("Preference");
        typeOfSalaryCMbox = new ComboBox<>();
        typeOfSalaryCMbox.setPromptText("Type of salary");
        typeOfSalaryCMbox.setItems(FXCollections.observableArrayList("Base salary", "Base plus %", "Hourly"));
        startTimeOfEmployeeTextField = new TextField();
        roleOfEmployeeCMbox = new ComboBox<>();
        roleOfEmployeeCMbox.setPromptText("Role");
        startTimeOfEmployeeTextField.setPromptText("Start time");
        endTimeOfEmployeeTextField = new TextField();
        endTimeOfEmployeeTextField.setPromptText("End Time");
        Button createEmployeeBtn = new Button("Create");
        createEmployeeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        employeeCreationHBox.getChildren().addAll(newEmployeeLabel, nameOfEmployeeTextField, preferenceOfEmployeeCMbox, typeOfSalaryCMbox, roleOfEmployeeCMbox, startTimeOfEmployeeTextField, endTimeOfEmployeeTextField, createEmployeeBtn);

        //Construct the employeeBorderPane
        employeeBorderPane.setTop(employeeLabel);
        employeeBorderPane.setLeft(departmentListView);
        employeeBorderPane.setCenter(employeeDetailTable);
        employeeBorderPane.setBottom(employeeCreationHBox);

        //Construct the employee Tab
        employeeTab.setContent(employeeBorderPane);
//End of employee Tab

//Construct the root Tab Pane - rootTabPane
        rootTabPane.getTabs().add(departmentTab);
        rootTabPane.getTabs().add(roleTab);
        rootTabPane.getTabs().add(employeeTab);

//Construct the root border pane - rootPane
        rootPane.setTop(topRootVbox);
        rootPane.setCenter(rootTabPane);

        this.primaryStage = primaryStage;
        this.rootPane = rootPane;
    }

    public void show() {
        //Construct the stage
        primaryStage.setScene(new Scene(rootPane, 1150, 800));
        primaryStage.show();
    }
}
