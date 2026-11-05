package catcafe;

import catcafe.element.Cat;
import catcafe.visitor.CatVisitor;

import java.util.ArrayList;
import java.util.List;

/** Object structure: holds all cats and lets a visitor walk through them. */
public class CatCafe {
    private final List<Cat> cats = new ArrayList<>();

    public void addCat(Cat cat) {
        cats.add(cat);
    }

    public void accept(CatVisitor visitor) {
        for (Cat cat : cats) {
            cat.accept(visitor);
        }
    }
}
