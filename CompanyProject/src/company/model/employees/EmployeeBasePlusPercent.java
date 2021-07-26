package company.model.employees;

import company.model.EmployeeType;

import java.io.Serializable;

public class EmployeeBasePlusPercent implements EmployeeType, Serializable {
    static final long serialVersionUID = 123L;

    private final double monthSalary;
    private double bonusPercentSum;

    public EmployeeBasePlusPercent(double monthSalary, double percent) {
        this.monthSalary = monthSalary;
        this.bonusPercentSum = percent;
    }

    public void setBonusPercentSum(double bonusPercentSum) {
        this.bonusPercentSum = bonusPercentSum;
    }

    @Override
    public double hourProfit() {
        return (monthSalary + bonusPercentSum) / 160;
    }
}
