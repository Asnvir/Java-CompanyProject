package company.model.employees;

import company.model.preferences.Preference;
import company.model.WorkingTime;
import company.model.EmployeeType;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 10L;

    public static final int HOURLY_PRICE = 10;
    public static final int EFFECTIVE_HOME_PERCENT = 10;
    public static final int EFFECTIVE_PERCENT = 20;
    public static final int HOURS_PER_DAY = 8;
//TODO может прописать для каждого рабочего номер рабочего , чтобы не было путаницы с рабочими, а его реализовать или с помощью статика, с каждым рабочем номер будет увеличивать на один или рандомно выдавать
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
                return (int) (HOURS_PER_DAY * HOURLY_PRICE * (1 + EFFECTIVE_HOME_PERCENT /100.0));
            } else {
                return HOURS_PER_DAY * HOURLY_PRICE;
            }
        } else {
            int factStart = factTime.getStartTime();
            int prefStart = preferredTime.getStartTime();

            int luckyHour = 0;
            int unluckyHour = 0;
            int normalHour = 0;
            // iteration by fact hours
            for (int i = factStart; i < factStart+9; i++) {
                if (i >= 8 && i < 17) normalHour++; // normal working time
                else if (i >= prefStart && i < prefStart + 9) luckyHour++; // preferred time
                else unluckyHour++; // unpreferred time
            }
            normalHour--; // lunch time - если учитывается в рабочее время - удалить
            return (int) (normalHour * HOURLY_PRICE +
                          luckyHour * HOURLY_PRICE * (1 + EFFECTIVE_PERCENT/100.0) +
                          unluckyHour * HOURLY_PRICE * (1 - EFFECTIVE_PERCENT/100.0));
        }
    }

    public void setHome(boolean homeAllowed) {
        home = homeAllowed && preference.preferredHome();
    }
}
