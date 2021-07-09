package company.model;

import company.util.EmployeeType;

import java.io.Serializable;

public class HourlyEmployee implements EmployeeType, Serializable {
    static final long serialVersionUID = 123L;

    private final double hourlySalary;

    public HourlyEmployee(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public double hourProfit() {
        return hourlySalary;
    }
}
