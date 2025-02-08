package splitter;

/**
 * Représente le découpage d'une image en plusieurs morceaux.
 *
 * @author Florian Pépin
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        if (args.length == 4) {
            try {
                String name = args[0];
                String format = args[1];
                int rows = Integer.parseInt(args[2]);
                int columns = Integer.parseInt(args[3]);
                ImageCutter cutter = new ImageCutter(name, format, rows, columns);
                cutter.cut();
            } catch (NumberFormatException e) {
                System.err.println("Paramètres incorrects.");
            }
        } else {
            System.out.println("#####################################################################");
            System.out.println("Paramètres incorrects.\n");
            System.out.println("SUR LINUX:");
            System.out.println("Usage: ./run-splitter.sh <image> <format> <rows> <columns>\n");
            System.out.println("SUR WINDOWS:");
            System.out.println("Usage: run-splitter.bat <image> <format> <rows> <columns>\n");
            System.out.println("PAR DÉFAUT:");
            System.out.println("Usage: java -jar splitter.jar <image> <format> <rows> <columns>");
            System.out.println("#####################################################################\n");
        }
    }
}
