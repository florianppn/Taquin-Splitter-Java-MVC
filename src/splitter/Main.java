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
                System.err.println("Invalid parameter.");
            }
        } else {
            System.out.println("No parameter provided.");
        }
    }
}
