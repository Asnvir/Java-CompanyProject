package company.model;

import company.util.EmployeeType;

import java.io.Serializable;

public class BaseEmployee implements EmployeeType, Serializable {
    static final long serialVersionUID = 122L;

    private final double monthSalary;

    public BaseEmployee(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    @Override
    public double hourProfit() {
        return monthSalary / 160;
    }
}
