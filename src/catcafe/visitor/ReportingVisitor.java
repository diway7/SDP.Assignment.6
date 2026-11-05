package catcafe.visitor;

import catcafe.element.Cat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Shared place where visitors write their results (no duplicated list/format code). */
public abstract class ReportingVisitor implements CatVisitor {
    private final List<String> lines = new ArrayList<>();

    protected void report(Cat cat, String message) {
        lines.add(cat.getName() + " (" + cat.getClass().getSimpleName() + "): " + message);
    }

    public List<String> getReport() {
        return Collections.unmodifiableList(lines);
    }
}
