package catcafe.visitor;

import catcafe.element.Kitten;
import catcafe.element.SiamCat;

/** Visitor interface: one visit method per concrete cat type. */
public interface CatVisitor {
    void visitSiamCat(SiamCat cat);

    void visitKitten(Kitten cat);
}
