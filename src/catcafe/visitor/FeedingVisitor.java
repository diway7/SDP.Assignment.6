package catcafe.visitor;

import catcafe.element.Kitten;
import catcafe.element.SiamCat;

/** Operation: feed every cat with its own food and portion. */
public class FeedingVisitor extends ReportingVisitor {

    @Override
    public void visitSiamCat(SiamCat cat) {
        report(cat, "80 g high-protein wet food (very active)");
    }

    @Override
    public void visitKitten(Kitten cat) {
        report(cat, "50 g kitten food, 4 times a day");
    }
}
