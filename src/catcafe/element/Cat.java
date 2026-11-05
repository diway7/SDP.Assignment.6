package catcafe.element;

import catcafe.visitor.CatVisitor;

/** Element interface: every cat in the cafe can be visited. */
public interface Cat {
    void accept(CatVisitor visitor);

    String getName();
}
