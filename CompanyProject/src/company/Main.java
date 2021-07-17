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
    //Roles
    private ListView<RoleAbstract> rolesListView;
    private TableView<RoleAbstract> detailsOfRoleTable;
    private ListView<? extends Employee> employeesByRoleListView;
    private TextField nameOfRoleTextField;
    private TextField startTimeOfRoleTextField;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
//Configure the main BoarderPane
        BorderPane root = new BorderPane();
        VBox vBox = new VBox();
        root.setTop(vBox);
//ToolBar with calc and show buttons
        ToolBar toolBar = new ToolBar();

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
//end of ToolBar configurations

//Start of Department Tab

        Tab departmentsTab = new Tab("Departments");
        departmentsTab.setClosable(false);
    //departmentsBorderPane
        BorderPane departmentsBorderPane = new BorderPane();
        departmentsBorderPane.setMinWidth(800);
        departmentsBorderPane.setPrefWidth(800);
        Label departmentsLabel = new Label("Departments");
        departmentsLabel.setFont(new Font(18));
        departmentsBorderPane.setAlignment(departmentsLabel, Pos.CENTER);  //TODO departmentsBorderPane.setAlignment или BorderPane.setAlignment тот же самый вопрос и в RolesTab



    //Start creation of big table of department's details

    //departmentsListView  (List Of departments by names)
        departmentsListView = new ListView<>();
        departmentsListView.setMinWidth(250);
        departmentsListView.setPrefWidth(250);


    //detailsOfDepartment TableView (Table of department's details)
        detailsOfDepartmentTable = new TableView<>();
        /*//Department's name Column                //TODO по идее эта колонка на требуется так как в 79 строке объявили departmentsListView, в котором будет отоброжаться имя department'a
        TableColumn<DepartmentAbstract,String> nameOfDepartmentColumn = new TableColumn<>("Name");
        nameOfDepartmentColumn.setMinWidth(200);
        nameOfDepartmentColumn.setPrefWidth(200);
        nameOfDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("name"));*/

        //Department's start time column
        TableColumn<DepartmentAbstract, JobTime> startTimeOfDepartmentColumn = new TableColumn<>("Start time");
        startTimeOfDepartmentColumn.setMinWidth(100);
        startTimeOfDepartmentColumn.setPrefWidth(100);
        startTimeOfDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("start"));
        //Department's end time column
        TableColumn<DepartmentAbstract, JobTime> endTimeOfDepartmentColumn = new TableColumn<>("End time");
        endTimeOfDepartmentColumn.setMinWidth(100);
        endTimeOfDepartmentColumn.setPrefWidth(100);
        endTimeOfDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("end"));   //TODO продумать где прописать endTime of department
        //Department's changeable time column
        //TODO прописать где-то в полях объекта department или можно менять часы работы true/false
        //Department's synchronisable column
        //TODO прописать где-то в полях объекта department требует ли department синхронизированной работы сотрудников true/false

        detailsOfDepartmentTable.getColumns().addAll(startTimeOfDepartmentColumn, endTimeOfDepartmentColumn, //changeableDepartmentColumn, synchronisableDepartmentColumn);

    //rolesByDepartment ListView (List of department's roles)
        rolesByDepartmentListView = new ListView<>();
        rolesByDepartmentListView.setMinWidth(300);
        rolesByDepartmentListView.setPrefWidth(300);

    //end creation of big table of department's details

    //HBox of department's creation
        HBox departmentCreationHBox = new HBox();
        departmentCreationHBox.setSpacing(10.0);
        departmentCreationHBox.setPadding( new Insets(5));
        departmentCreationHBox.setAlignment(Pos.CENTER_LEFT);

        Label newDepartmentLabel = new Label("New department");

        nameOfDepartmentTextField = new TextField();
        nameOfDepartmentTextField.setPromptText("Name");

        startTimeOfDepartmentTextField = new TextField();
        startTimeOfDepartmentTextField.setPromptText("Start time");

        //TODO не знаю как это называется но сделать окошко для endTimeOfDepartment, которое нельзя изменять и в нем будет показано конец работы departament'a +9 часов относительно startTimeOfDepartment, которое ввели ранее

        CheckBox changeableDepartmentChkBox = new CheckBox("If the the work time of department is changeable?");
        CheckBox synchronisableChkBox = new CheckBox("If the work in the department should be synchronisable");

        Button newDepartmentBtn = new Button("Add");
        newDepartmentBtn.prefWidth(65);
        synchronisableChkBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        departmentCreationHBox.getChildren().addAll(newDepartmentLabel,nameOfDepartmentTextField,startTimeOfDepartmentTextField,//то что хотел добавить в 138 строке ,changeableDepartmentChkBox, synchronisableChkBox);


    //Construct the departmentsBorderPane
        departmentsBorderPane.setTop(departmentsLabel);
        departmentsBorderPane.setLeft(departmentsListView);
        departmentsBorderPane.setCenter(detailsOfDepartmentTable);
        departmentsBorderPane.setRight(rolesByDepartmentListView);
        departmentsBorderPane.setBottom(departmentCreationHBox);

//End of Department Tab

//Start Of Roles Tab

        Tab rolesTab = new Tab("Roles");
        rolesTab.setClosable(false);

        //rolesBorderPane
        BorderPane rolesBorderPane = new BorderPane();
        rolesBorderPane.setMinWidth(800);
        rolesBorderPane.setPrefWidth(800);
        Label rolesLabel = new Label("Roles");
        rolesLabel.setFont(new Font(18));
        rolesBorderPane.setAlignment(rolesLabel,Pos.CENTER);

        //rolesListView ( List of roles by names)
        rolesListView = new ListView<>();
        rolesListView.setMinWidth(250);
        rolesListView.setPrefWidth(250);

        //Start creation of big table of role's details
        //detailsOfRole TableView (Table of roles' details)
        detailsOfRoleTable = new TableView<>();

        //Role's start time column
        TableColumn<RoleAbstract,JobTime> startTimeOfRoleColumn = new TableColumn<>("Start time");
        startTimeOfRoleColumn.setMinWidth(100);
        startTimeOfRoleColumn.setPrefWidth(100);
        startTimeOfRoleColumn.setCellValueFactory(new PropertyValueFactory<>("start"));

        //Role's end time column
        TableColumn<RoleAbstract,JobTime> endTimeOfRoleColumn = new TableColumn<>("End time");
        endTimeOfRoleColumn.setMinWidth(100);
        endTimeOfRoleColumn.setPrefWidth(100);
        endTimeOfRoleColumn.setCellValueFactory(new PropertyValueFactory<>("end"));   //TODO продумать где прописать endTime of department

        //Role's changeable time column
        //TODO прописать где-то в полях объекта role или можно менять часы работы -  true/false

        detailsOfRoleTable.getColumns().addAll(startTimeOfRoleColumn,endTimeOfRoleColumn, //Role's changeable time column);

         //employeesByRole ListView ( Lise of role's employees )
        employeesByRoleListView = new ListView<>();
        employeesByRoleListView.setMinWidth(300);
        employeesByRoleListView.prefWidth(300);

        //end creation of big table of department's details

        //HBOX of role's creation
        HBox roleCreationHBox = new HBox();
        roleCreationHBox.setSpacing(10.0);
        roleCreationHBox.setPadding(new Insets(5));
        roleCreationHBox.setAlignment(Pos.CENTER_LEFT);

        Label newRoleLabel = new Label("New role");

        nameOfRoleTextField = new TextField();
        nameOfRoleTextField.setPromptText("Name");

        startTimeOfRoleTextField = new TextField();
        startTimeOfRoleTextField.setPromptText("Start time");

        //TODO не знаю как это называется но сделать окошко для endTimeOfRole, которое нельзя изменять и в нем будет показано конец работы role'a +9 часов относительно startTimeOfRole, которое ввели ранее

        CheckBox changeableRoleChkBox = new CheckBox("If the the work time of role is changeable?");

        Button newRoleBtn = new Button("Add");
        newDepartmentBtn.prefWidth(65);
        synchronisableChkBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

    //Construct the rolesBorderPane
        rolesBorderPane.setTop(rolesLabel);

    }
}
