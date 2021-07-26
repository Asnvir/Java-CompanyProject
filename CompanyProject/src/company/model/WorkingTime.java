package company.model;

public class WorkingTime {
    static final long serialVersionUID = 201L;

    private int startTime;

    public WorkingTime(int startTime) {
        this.startTime = startTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getDifference(WorkingTime other) {
        return other.startTime - startTime;
    }
}
