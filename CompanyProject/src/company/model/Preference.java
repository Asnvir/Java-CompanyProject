package company.model;

import java.io.Serializable;

public abstract class Preference implements Serializable {
    private static final long serialVersionUID = 2L;

    public abstract boolean preferredHome();

    public abstract int deltaTime();
}
