package company;

import company.model.DepartmentAbstract;
import company.model.Employee;
import company.model.RoleAbstract;
import company.util.JobTime;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    //Department
    private ListView<DepartmentAbstract> departmentsListView;
    private TableView<RoleAbstract> detailsOfDepartmentTable;
    private ListView<? extends RoleAbstract> rolesByDepartmentListView;
    private TextField nameOfDepartmentTextField;
    private TextField startTimeOfDepartmentTextField;
    private TextField endTimeOfDepartmentTextField;
    private CheckBox changeableTimeOfDepartmentChckBox;
    private CheckBox synchronisableDepartmentChckBox;
    private ComboBox departmentCMBoxDepartTab;
    private ComboBox roleCMBoxDepartTab;
    //Roles
    private ListView<RoleAbstract> rolesListView;
    private TableView<RoleAbstract> detailsOfRoleTable;
    private ListView<? extends Employee> employeesByRoleListView;
    private TextField nameOfRoleTextField;
    private TextField startTimeOfRoleTextField;
    private TextField endTimeOfRoleTextField;
    private CheckBox  changeableTimeOfRoleChckBox;
    private ComboBox  roleCMBoxRoleTab;
    private ComboBox  employeeCMBoxRoleTab;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
//Configure the main BoarderPane
        BorderPane root = new BorderPane();
        root.setMinWidth(1150);
        root.setPrefWidth(1150);
        root.setMinHeight(800);
        root.setPrefHeight(800);

        VBox topRootVbox = new VBox();
        root.setTop(topRootVbox);
//HBbox  with calc and show buttons
        HBox hboxWithBtns = new HBox();
        hboxWithBtns.setPadding(new Insets(10));

        Button calculateBtn = new Button("Calculate");
        calculateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button showResultsPerEmployeesBtn = new Button("Show results per employee");
        showResultsPerEmployeesBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button showResultsPerDepartmentsBtn = new Button("Show results per departments");
        showResultsPerDepartmentsBtn.setOnAction(new EventHandler<ActionEvent>() {
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

        hboxWithBtns.getChildren().addAll(calculateBtn, showResultsPerEmployeesBtn, showResultsPerDepartmentsBtn, showResultsPerCompanyBtn);
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
        departmentBorderPane.setMinWidth(1150);
        departmentBorderPane.setPrefWidth(1150);
//        departmentBorderPane.setMinHeight(716);
//        departmentBorderPane.setPrefHeight(716);
        Label departmentsDetailedInfoLbl = new Label("Department's detailed information");
        departmentsDetailedInfoLbl.setFont(new Font(18));
        BorderPane.setAlignment(departmentBorderPane, Pos.CENTER);

        Label departmentsLabel = new Label("Departments");
        departmentsLabel.setFont(new Font(18));
        departmentBorderPane.setAlignment(departmentsLabel, Pos.CENTER);  //TODO departmentsBorderPane.setAlignment или BorderPane.setAlignment тот же самый вопрос и в RolesTab


        //Start creation of big table of department's details

        //departmentsListView  (List Of departments by names)
        departmentsListView = new ListView<>();
        departmentsListView.setMinWidth(200);
        departmentsListView.setPrefWidth(200);
//        departmentsListView.setMinHeight(579);
//        departmentsListView.setPrefHeight(579);


        //detailsOfDepartment TableView (Table of department's details)
        detailsOfDepartmentTable = new TableView<>();
        detailsOfDepartmentTable.setMinWidth(750);
        detailsOfDepartmentTable.setPrefWidth(750);


        //Department's name Column                //TODO по идее эта колонка на требуется так как в 79 строке объявили departmentsListView, в котором будет отоброжаться имя department'a
        TableColumn<DepartmentAbstract, String> nameOfDepartmentColumn = new TableColumn<>("Name");
        nameOfDepartmentColumn.setMinWidth(231);
        nameOfDepartmentColumn.setPrefWidth(231);
        nameOfDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Department's start time column
        TableColumn<DepartmentAbstract, JobTime> startTimeOfDepartmentColumn = new TableColumn<>("Start time");
        startTimeOfDepartmentColumn.setMinWidth(125);
        startTimeOfDepartmentColumn.setPrefWidth(125);
        startTimeOfDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("start"));
        //Department's end time column
        TableColumn<DepartmentAbstract, JobTime> endTimeOfDepartmentColumn = new TableColumn<>("End time");
        endTimeOfDepartmentColumn.setMinWidth(120);
        endTimeOfDepartmentColumn.setPrefWidth(120);
        endTimeOfDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("end"));   //TODO продумать где прописать endTime of department
        //Department's changeable time column
        TableColumn<DepartmentAbstract, Boolean> changeableTimeDepartmentColumn = new TableColumn<>("Changeable time"); //TODO прописать где-то в полях объекта department или можно менять часы работы true/false
        changeableTimeDepartmentColumn.setMinWidth(121);
        changeableTimeDepartmentColumn.setPrefWidth(121);
        changeableTimeDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("прописать свойство"));
        //Department's synchronisable column
        TableColumn<DepartmentAbstract, Boolean> synchronisableDepartmentColumn = new TableColumn<>("Synchronisable");
        synchronisableDepartmentColumn.setMinWidth(97);
        synchronisableDepartmentColumn.setPrefWidth(97);
        synchronisableDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("прописать свойство"));//TODO прописать где-то в полях объекта department требует ли department синхронизированной работы сотрудников true/false

        detailsOfDepartmentTable.getColumns().addAll(nameOfDepartmentColumn,startTimeOfDepartmentColumn, endTimeOfDepartmentColumn, changeableTimeDepartmentColumn, synchronisableDepartmentColumn);

        //rolesByDepartment ListView (List of department's roles)
        rolesByDepartmentListView = new ListView<>();
        rolesByDepartmentListView.setMinWidth(200);
        rolesByDepartmentListView.setPrefWidth(200);

        //end creation of big table of department's details

        //VBox bottonRootVboxOfDepartment that consistf 2 hboxes - 1 for creation of department - 2nd foradding a role to department
        VBox bottonRootVboxOfDepartment = new VBox();
        bottonRootVboxOfDepartment.setMinWidth(1150);
        bottonRootVboxOfDepartment.setPrefWidth(1150);
//        bottonRootVboxOfDepartment.setMinHeight(110);
//        bottonRootVboxOfDepartment.setPrefHeight(110);
        bottonRootVboxOfDepartment.setPadding(new Insets(10));
        //HBox of department's creation
        HBox departmentCreationHBox = new HBox();
        departmentCreationHBox.setMinWidth(1140);
        departmentCreationHBox.setPrefWidth(1140);
//        departmentCreationHBox.setMinHeight(45);
//        departmentCreationHBox.setPrefHeight(45);
        departmentCreationHBox.setSpacing(10.0);
        departmentCreationHBox.setPadding(new Insets(5));
        departmentCreationHBox.setAlignment(Pos.CENTER_LEFT);

        Label newDepartmentLabel = new Label("New department : ");
        nameOfDepartmentTextField = new TextField();
        nameOfDepartmentTextField.setPromptText("Name");
        startTimeOfDepartmentTextField = new TextField();
        startTimeOfDepartmentTextField.setPromptText("Start time");
        endTimeOfDepartmentTextField = new TextField();
        endTimeOfDepartmentTextField.setPromptText("End time");
        changeableTimeOfDepartmentChckBox = new CheckBox("Time could be changeable?");
        synchronisableDepartmentChckBox = new CheckBox("Department should be synchronisable");
        Button createDepartmentBtn = new Button("Create");
        createDepartmentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        departmentCreationHBox.getChildren().addAll(newDepartmentLabel, nameOfDepartmentTextField, startTimeOfDepartmentTextField, endTimeOfDepartmentTextField, changeableTimeOfDepartmentChckBox, synchronisableDepartmentChckBox, createDepartmentBtn);

        //Hbox of adding a role to department
        HBox roleAddingToDepartmentHbox = new HBox();
        roleAddingToDepartmentHbox.setMinWidth(1140);
        roleAddingToDepartmentHbox.setPrefWidth(1140);
//        addingRoleToDepartmentHbox.setMinHeight(45);
//        addingRoleToDepartmentHbox.setPrefHeight(45);
        roleAddingToDepartmentHbox.setSpacing(10.0);
        roleAddingToDepartmentHbox.setPadding(new Insets(5));
        roleAddingToDepartmentHbox.setAlignment(Pos.CENTER_LEFT);

        Label addRoleToDepartment = new Label("Add a role to department : ");
        departmentCMBoxDepartTab = new ComboBox();
        departmentCMBoxDepartTab.setPromptText("Department");
        roleCMBoxDepartTab = new ComboBox();
        roleCMBoxDepartTab.setPromptText("Role");
        Button addRoleToDepartmentBtn = new Button("Add");
        addRoleToDepartmentBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        roleAddingToDepartmentHbox.getChildren().addAll(addRoleToDepartment, departmentCMBoxDepartTab, roleCMBoxDepartTab, addRoleToDepartmentBtn);

        bottonRootVboxOfDepartment.getChildren().addAll(departmentCreationHBox, roleAddingToDepartmentHbox);


        //TODO не знаю как это называется но сделать окошко для endTimeOfDepartment, которое нельзя изменять и в нем будет показано конец работы departament'a +9 часов относительно startTimeOfDepartment, которое ввели ранее


        //Construct the departmentsBorderPane
        departmentBorderPane.setTop(departmentsLabel);
        departmentBorderPane.setLeft(departmentsListView);
        departmentBorderPane.setCenter(detailsOfDepartmentTable);
        departmentBorderPane.setRight(rolesByDepartmentListView);
        departmentBorderPane.setBottom(bottonRootVboxOfDepartment);


//End of Department Tab

//Start Of Roles Tab

        Tab rolesTab = new Tab("Roles");
        rolesTab.setClosable(false);

        //rolesBorderPane
        BorderPane rolesBorderPane = new BorderPane();
        rolesBorderPane.setMinWidth(1150);
        rolesBorderPane.setPrefWidth(1150);
//       rolesBorderPane.setMinHeight(716);
//       rolesBorderPane.setPrefHeight(716);
        Label rolesLabel = new Label("Roles");
        rolesLabel.setFont(new Font(18));
        rolesBorderPane.setAlignment(rolesLabel, Pos.CENTER);

        //rolesListView ( List of roles by names)
        rolesListView = new ListView<>();
        rolesListView.setMinWidth(200);
        rolesListView.setPrefWidth(200);
//        rolesListView.setMinHeight(579);
//        rolesListView.setPrefHeight(579);

        //Start creation of big table of role's details
        //detailsOfRole TableView (Table of roles' details)
        detailsOfRoleTable = new TableView<>();
        detailsOfRoleTable.setMinWidth(750);
        detailsOfRoleTable.setPrefWidth(750);
//        detailsOfRoleTable.setMinHeight(579);
//        detailsOfRoleTable.setPrefHeight(579);


        //Role's name column
        TableColumn<RoleAbstract, JobTime> nameOfRoleColumn = new TableColumn<>("Name");
        nameOfRoleColumn.setMinWidth(420);
        nameOfRoleColumn.setPrefWidth(420);
        nameOfRoleColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Role's start time column
        TableColumn<RoleAbstract, JobTime> startTimeOfRoleColumn = new TableColumn<>("Start time");
        startTimeOfRoleColumn.setMinWidth(101);
        startTimeOfRoleColumn.setPrefWidth(101);
        startTimeOfRoleColumn.setCellValueFactory(new PropertyValueFactory<>("start"));

        //Role's end time column
        TableColumn<RoleAbstract, JobTime> endTimeOfRoleColumn = new TableColumn<>("End time");
        endTimeOfRoleColumn.setMinWidth(119);
        endTimeOfRoleColumn.setPrefWidth(119);
        endTimeOfRoleColumn.setCellValueFactory(new PropertyValueFactory<>("end"));   //TODO продумать где прописать endTime of department


        //Role's changeable time column
        TableColumn<RoleAbstract, Boolean> changeableTimeRoleColumn = new TableColumn<>("Changeable time"); //TODO прописать где-то в полях объекта Role или можно менять часы работы true/false
        changeableTimeRoleColumn.setMinWidth(106);
        changeableTimeRoleColumn.setPrefWidth(106);
        changeableTimeRoleColumn.setCellValueFactory(new PropertyValueFactory<>("прописать свойство"));

        detailsOfRoleTable.getColumns().addAll(nameOfRoleColumn,startTimeOfRoleColumn,endTimeOfRoleColumn,changeableTimeRoleColumn);

        //employeesByRole ListView ( Lise of role's employees )
        employeesByRoleListView = new ListView<>();
        employeesByRoleListView.setMinWidth(200);
        employeesByRoleListView.prefWidth(200);

        //end creation of big table of department's details

        //VBox bottonRootVboxOfRole that consists 2 HBoxe 1 - for role creation  2nd for adding an employee to Role
        VBox bottonRootVboxOfRole = new VBox();
        bottonRootVboxOfRole.setMinWidth(1150);
        bottonRootVboxOfRole.setPrefWidth(1150);
//        bottonRootVboxOfRole.setMinHeight(110);
//        bottonRootVboxOfRole.setPrefHeight(110);
        //HBOX of role's creation
        HBox roleCreationHBox = new HBox();
        roleCreationHBox.setMinWidth(1140);
        roleCreationHBox.setPrefWidth(1140);
//        roleCreationHBox.setMinHeight(45);
//        roleCreationHBox.setPrefHeight(45);
        roleCreationHBox.setSpacing(10.0);
        roleCreationHBox.setPadding(new Insets(5));
        roleCreationHBox.setAlignment(Pos.CENTER_LEFT);

        Label newRoleLabel = new Label("New role");
        nameOfRoleTextField = new TextField();
        nameOfRoleTextField.setPromptText("Name");
        startTimeOfRoleTextField = new TextField();
        startTimeOfRoleTextField.setPromptText("Start time");
        endTimeOfRoleTextField = new TextField();
        endTimeOfRoleTextField.setPromptText("End time");
        changeableTimeOfRoleChckBox = new CheckBox("Time could be changeable?");
        Button createRoleBtn = new Button("Create");
        createRoleBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });

        roleCreationHBox.getChildren().addAll(newRoleLabel,nameOfRoleTextField,startTimeOfRoleTextField,endTimeOfRoleTextField,changeableTimeOfRoleChckBox,createRoleBtn);

       //HBox adding an employee to Role
        HBox employeeAddingToRoleHbox = new HBox();
        employeeAddingToRoleHbox.setMinWidth(1140);
        employeeAddingToRoleHbox.setPrefWidth(1140);
//        employeeAddingToRoleHbox.setMinHeight(45);
//        employeeAddingToRoleHbox.setPrefHeight(45);
        employeeAddingToRoleHbox.setSpacing(10.0);
        employeeAddingToRoleHbox.setPadding(new Insets(5));
        roleAddingToDepartmentHbox.setAlignment(Pos.CENTER_LEFT);

        Label addEmployeeToRole = new Label("Add an employee to role : ");
        roleCMBoxRoleTab = new ComboBox();
        roleCMBoxRoleTab.setPromptText("Role");
        employeeCMBoxRoleTab = new ComboBox();
        employeeCMBoxRoleTab.setPromptText("Employee");
        Button addEmployeeToRoleBtn = new Button("Add");
        addEmployeeToRoleBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
        employeeAddingToRoleHbox.getChildren().addAll(addEmployeeToRole,roleCMBoxRoleTab,employeeCMBoxRoleTab,addEmployeeToRoleBtn);

        bottonRootVboxOfRole.getChildren().addAll(roleCreationHBox,employeeAddingToRoleHbox);




        //Construct the rolesBorderPane
        rolesBorderPane.setTop(rolesLabel);
        rolesBorderPane.setLeft(rolesListView);
        rolesBorderPane.setCenter(detailsOfRoleTable);
        rolesBorderPane.setRight(employeesByRoleListView);
        rolesBorderPane.setBottom(bottonRootVboxOfRole);

//End of Role Tab
    }
}
