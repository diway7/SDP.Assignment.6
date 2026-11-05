package catcafe;

import catcafe.element.Kitten;
import catcafe.element.SiamCat;
import catcafe.visitor.FeedingVisitor;
import catcafe.visitor.PettingVisitor;
import catcafe.visitor.ReportingVisitor;

public class Main {
    public static void main(String[] args) {
        CatCafe cafe = createCafe();

        FeedingVisitor feeding = new FeedingVisitor();
        PettingVisitor petting = new PettingVisitor();

        cafe.accept(feeding);
        cafe.accept(petting);

        print("FEEDING", feeding);
        print("PETTING", petting);
    }

    static CatCafe createCafe() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new SiamCat("Luna", 9));
        cafe.addCat(new SiamCat("Oscar", 4));
        cafe.addCat(new Kitten("Mimi", 9));
        return cafe;
    }

    private static void print(String title, ReportingVisitor visitor) {
        System.out.println("=== " + title + " ===");
        visitor.getReport().forEach(System.out::println);
        System.out.println();
    }
}
