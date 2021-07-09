package company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Department> departments = new ArrayList<>();

    public void add(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

}
