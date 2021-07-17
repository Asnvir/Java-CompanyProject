package company.model;

import company.util.EmployeeType;

import java.io.Serializable;

public class EmployeeHourly implements EmployeeType, Serializable {
    static final long serialVersionUID = 123L;

    private final double hourlySalary;

    public EmployeeHourly(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public double hourProfit() {
        return hourlySalary;
    }
}
