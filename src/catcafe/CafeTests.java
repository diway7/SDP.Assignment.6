package catcafe;

import catcafe.element.Kitten;
import catcafe.element.SiamCat;
import catcafe.visitor.CatVisitor;
import catcafe.visitor.FeedingVisitor;
import catcafe.visitor.PettingVisitor;

/** Simple tests without any library. Run: java -cp out catcafe.CafeTests */
public class CafeTests {
    private static int failed = 0;

    public static void main(String[] args) {
        feedingGivesOneLinePerCat();
        pettingUsesCatData();
        newVisitorNeedsNoChangeInCats();

        if (failed > 0) {
            System.out.println(failed + " test(s) FAILED");
            System.exit(1);
        }
        System.out.println("All tests passed");
    }

    private static void feedingGivesOneLinePerCat() {
        FeedingVisitor visitor = new FeedingVisitor();
        Main.createCafe().accept(visitor);
        check("feeding: 3 lines", visitor.getReport().size() == 3);
        check("feeding: kitten gets kitten food", visitor.getReport().get(2).contains("kitten food"));
    }

    private static void pettingUsesCatData() {
        PettingVisitor visitor = new PettingVisitor();
        Main.createCafe().accept(visitor);
        check("petting: Luna purrs at 9", visitor.getReport().get(0).contains("level 9/10"));
        check("petting: Mimi scratches", visitor.getReport().get(2).contains("WARNING"));
    }

    /** A brand-new operation, added without touching any cat class. */
    private static void newVisitorNeedsNoChangeInCats() {
        class CatCounterVisitor implements CatVisitor {
            int count;

            public void visitSiamCat(SiamCat cat) { count++; }

            public void visitKitten(Kitten cat) { count++; }
        }
        CatCounterVisitor counter = new CatCounterVisitor();
        Main.createCafe().accept(counter);
        check("extensibility: counter sees 3 cats", counter.count == 3);
    }

    private static void check(String name, boolean condition) {
        System.out.println((condition ? "PASS  " : "FAIL  ") + name);
        if (!condition) {
            failed++;
        }
    }
}
