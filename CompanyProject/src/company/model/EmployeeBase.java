package company.model;

import company.util.EmployeeType;

import java.io.Serializable;

public class EmployeeBase implements EmployeeType, Serializable {
    static final long serialVersionUID = 122L;

    private final double monthSalary;

    public EmployeeBase(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    @Override
    public double hourProfit() {
        return monthSalary / 160;
    }
}
