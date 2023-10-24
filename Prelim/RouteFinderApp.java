//Joro Martin C. Cabreros
//ITCP 2A
import java.util.Scanner;

public class RouteFinderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DisplayText("Route Finder App");
        DisplayDefRoutes();

        int Route1Block = getUserInput(scanner, "Is Route 4.1 obstructed? (1 = Yes, 0 = No): ");
        String RecommendedRoute = "";
        int Distance = 0;

        if (Route1Block == 1) {
            DisplayRecommendedRoute();
            RecommendedRoute = "South Bus Terminal - Start\nMinglanilla - Route 1\nSan Fernando - Route 2\nCarcar - Route 3\nSibonga - Route 4.2\nDumanjug - Route 4.2.1\nAlcantara - Route 4.2.2\nMoalboal - END";
            Distance = 150;

            int Route4_2Block = getUserInput(scanner, "Is Route 4.2 obstructed? (1 = Yes, 0 = No): ");
            if (Route4_2Block == 1) {
                RecommendedRoute = "South Bus Terminal - Start\nMinglanilla - Route 1\nSan Fernando - Route 2\nCarcar - Route 3\nSibonga - Route 4.2\nArgao - Route 5\nRonda - Route 5.1\nAlcantara - Route 5.2\nMoalboal - END";
                Distance = 180;
            }
        } else {
            RecommendedRoute = "South Bus Terminal - Start\nMinglanilla - Route 1\nSan Fernando - Route 2\nCarcar - Route 3\nBarili - Route 4.1\nDumanjug - Route 4.1.1\nAlcantara - Route 4.1.2\nMoalboal - END";
            Distance = 200;
        }

        if (!RecommendedRoute.isEmpty()) {
            int Speed = getUserInput(scanner, "Speed (in km/h): ");

            DisplayFinalOutput(RecommendedRoute, Speed, Distance);

            int eTa = calculateETA(Speed, Distance);

            DisplayETA(eTa);
        }

        scanner.close();
    }

    private static void DisplayText(String text) {
        System.out.println(text + "\n");
    }

    private static void DisplayDefRoutes() {
        System.out.println("Default Route:");
        System.out.println("South Bus Terminal (Start)\nMinglanilla - Route 1\nSan Fernando - Route 2\nCarcar - Route 3\nBarili - Route 4.1\nDumanjug - Route 4.1.1\nAlcantara - Route 4.1.2\nMoalboal - END\n");
    }

    private static void DisplayRecommendedRoute() {
        System.out.println("Recommended Route:");
        System.out.println("South Bus Terminal - Start\nMinglanilla - Route 1\nSan Fernando - Route 2\nCarcar - Route 3\nSibonga - Route 4.2\nDumanjug - Route 4.2.1\nAlcantara - Route 4.2.2\nMoalboal - END\n");
    }

    private static int getUserInput(Scanner scanner, String prompt) {
        int UserInt;
        while (true) {
            try {
                System.out.print(prompt);
                UserInt = scanner.nextInt();
                if (UserInt >= 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive value.\n");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive value.\n");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
        return UserInt;
    }

    private static void DisplayFinalOutput(String routeName, int Speed, int Distance) {
        System.out.println("Recommended Route:\n" + routeName + "\nSpeed: " + Speed + " km/h\nDistance: " + Distance + " km\n");
    }

    private static void DisplayETA(int eTa) {
        System.out.println("ETA: " + eTa + " hours\n");
    }

    private static int calculateETA(int Speed, int Distance) {
        return Distance / Speed;
    }
}