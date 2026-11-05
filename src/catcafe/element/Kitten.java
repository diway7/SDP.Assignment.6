package catcafe.element;

import catcafe.visitor.CatVisitor;

/** Small and chaotic. */
public class Kitten extends BaseCat {
    private final int playfulnessLevel; // 1..10

    public Kitten(String name, int playfulnessLevel) {
        super(name);
        this.playfulnessLevel = playfulnessLevel;
    }

    public int getPlayfulnessLevel() {
        return playfulnessLevel;
    }

    @Override
    public void accept(CatVisitor visitor) {
        visitor.visitKitten(this);
    }
}
