package company.model;

import company.util.EmployeeType;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 10L;

    private Preference preference;
    private EmployeeType type;

    public Employee(String name, Preference preference, EmployeeType type) {
        this.preference = preference;
        this.type = type;
    }

    public double hourProfit() {
        return type.hourProfit();
    }
}
