

public class TestRunner {

    public static void main(String[] args)
    {
            System.out.println("");
            System.out.println("========================");
            System.out.println("Running Entire Test Suite");
            System.out.println("========================");

            PieceTester pieceTester = new PieceTester();
            pieceTester.runTests();

            GameManagerTester gameManagerTester = new GameManagerTester();
            gameManagerTester.runTests();

            TileTester tileTester = new TileTester();
            tileTester.runTests();
    }
}
