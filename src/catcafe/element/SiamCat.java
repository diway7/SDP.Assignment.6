package catcafe.element;

import catcafe.visitor.CatVisitor;

/** Loud and hyperactive. */
public class SiamCat extends BaseCat {
    private final int loudnessLevel;

    public SiamCat(String name, int loudnessLevel) {
        super(name);
        this.loudnessLevel = loudnessLevel;
    }

    public int getLoudnessLevel() {
        return loudnessLevel;
    }

    @Override
    public void accept(CatVisitor visitor) {
        visitor.visitSiamCat(this); // double dispatch: the cat tells the visitor its exact type
    }
}
