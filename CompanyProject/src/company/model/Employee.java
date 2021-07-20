package company.model;

import company.model2.WorkingTime;
import company.util.EmployeeType;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 10L;

    public static final int HOURLY_PRICE = 10;
    public static final int HOME_PERCENT = 10;
    public static final int EFFECTIVE_PERCENT = 20;
    public static final int HOURS_PER_DAY = 8;

    private String name;
    private Preference preference;
    private EmployeeType type;
    private WorkingTime factTime;
    private WorkingTime preferredTime;
    private boolean home = false;

    public Employee(String name, Preference preference, EmployeeType type) {
        this.preference = preference;
        this.type = type;
        this.name = name;
        preferredTime = new WorkingTime(8 + preference.deltaTime()) ;
    }

    public double hourProfit() {
        return type.hourProfit();
    }

    public void setFactStartTime(WorkingTime time) {
        factTime = time;
    }

    public void setFactStartTimeAsPreferred() {
        factTime = preferredTime;
    }

    public String getName() {
        return name;
    }

    public Preference getPreference() {
        return preference;
    }

    public EmployeeType getType() {
        return type;
    }

    public WorkingTime getFactTime() {
        return factTime;
    }

    public WorkingTime getPreferredTime() {
        return preferredTime;
    }

    public int performance() {
        if (preference.preferredHome()) {
            if (home) {
                return (int) (HOURS_PER_DAY * HOURLY_PRICE * (1 + HOME_PERCENT/100.0));
            }
            else {
                return HOURS_PER_DAY * HOURLY_PRICE;
            }
        } else {
            int factStart = factTime.getStartTime();
            int prefStart = preferredTime.getStartTime();
            int earlyWork = factStart < 8 ? 8 - factStart : 0;
            int lateWork = factStart > 8 ? factStart - 8 : 0;
        }
        // todo Дописать формулу
//         |-*-|-*-|---|---|---|---|---|---|---|---|---|---|---|---|---|
//           6   7   8   9   10  11  12  13  14  15  16  17  18  19  20
    }

    public void setHome(boolean homeAllowed) {
        home = homeAllowed && preference.preferredHome();
    }
}
