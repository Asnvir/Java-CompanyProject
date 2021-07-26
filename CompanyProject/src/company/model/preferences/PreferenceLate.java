package company.model.preferences;

public class PreferenceLate extends Preference {

    private static final long serialVersionUID = 5L;

    private int delta;

    public PreferenceLate(int delta) {
        this.delta = delta;
    }

    @Override
    public boolean preferredHome() {
        return false;
    }

    @Override
    public int deltaTime() {
        return delta;
    }
}
