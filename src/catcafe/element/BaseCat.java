package catcafe.element;

/** Holds what every cat has (a name), so concrete cats do not repeat it. */
public abstract class BaseCat implements Cat {
    private final String name;

    protected BaseCat(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
