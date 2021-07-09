package company.model;

public class PreferenceEarly extends Preference {

    private static final long serialVersionUID = 6L;

    private int delta;

    public PreferenceEarly(int delta) {
        this.delta = delta;
    }

    @Override
    public boolean preferredHome() {
        return false;
    }

    @Override
    public int deltaTime() {
        return -delta;
    }
}
