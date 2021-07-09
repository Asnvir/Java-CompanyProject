package company.model;

import company.util.EmployeeType;

import java.io.Serializable;

public class BasePlusPercentEmployee implements EmployeeType, Serializable {
    static final long serialVersionUID = 123L;

    private final double monthSalary;
    private double bonusPercentSum;

    public BasePlusPercentEmployee(double monthSalary, double percent) {
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
