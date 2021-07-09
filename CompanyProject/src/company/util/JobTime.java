package company.util;

import java.io.Serializable;
import java.util.Objects;

public class JobTime implements Serializable {

    private static final long serialVersionUID = 7L;

    private int hour;
    private int minute;

    public JobTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobTime jobTime = (JobTime) o;
        return hour == jobTime.hour && minute == jobTime.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute);
    }

    @Override
    public String toString() {
        return "time: "+ hour + ":" + minute;
    }
}
