package company.model.preferences;

public class PreferenceBase extends Preference {

    private static final long serialVersionUID = 4L;

    @Override
    public boolean preferredHome() {
        return false;
    }

    @Override
    public int deltaTime() {
        return 0;
    }
}
