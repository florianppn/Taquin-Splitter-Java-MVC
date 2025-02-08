package splitter;

/**
 * Représente le découpage d'une image en plusieurs morceaux.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        if (args.length == 3) {
            try {
                String name = args[0];
                int rows = Integer.parseInt(args[1]);
                int columns = Integer.parseInt(args[2]);
                ImageCutter cutter = new ImageCutter(name, rows, columns);
                cutter.cut();
            } catch (NumberFormatException e) {
                System.err.println("Paramètres incorrects.");
            }
        } else {
            System.out.println("#####################################################################");
            System.out.println("Paramètres incorrects.\n");
            System.out.println("SUR LINUX:");
            System.out.println("Usage: ./run-splitter.sh <image> <rows> <columns>\n");
            System.out.println("SUR WINDOWS:");
            System.out.println("Usage: run-splitter.bat <image> <rows> <columns>\n");
            System.out.println("PAR DÉFAUT:");
            System.out.println("Usage: java -jar splitter.jar <image> <rows> <columns>");
            System.out.println("#####################################################################\n");
        }
    }
}
