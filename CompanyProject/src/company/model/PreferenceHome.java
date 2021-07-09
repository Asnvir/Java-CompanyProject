package company.model;

public class PreferenceHome extends Preference {
    private static final long serialVersionUID = 3L;
    @Override
    public boolean preferredHome() {
        return true;
    }

    @Override
    public int deltaTime() {
        return 0;
    }
}
