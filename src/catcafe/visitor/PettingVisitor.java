package catcafe.visitor;

import catcafe.element.Kitten;
import catcafe.element.SiamCat;

/** Operation: pet every cat and report the purr level (or a scratch warning). */
public class PettingVisitor extends ReportingVisitor {
    private static final int SCRATCH_PLAYFULNESS = 8;

    @Override
    public void visitSiamCat(SiamCat cat) {
        report(cat, "purring at level " + cat.getLoudnessLevel() + "/10");
    }

    @Override
    public void visitKitten(Kitten cat) {
        if (cat.getPlayfulnessLevel() >= SCRATCH_PLAYFULNESS) {
            report(cat, "WARNING: too playful, it scratches!");
        } else {
            report(cat, "purring at level 5/10");
        }
    }
}
