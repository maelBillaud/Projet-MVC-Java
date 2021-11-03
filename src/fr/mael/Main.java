package fr.mael;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Form forme = new Square(new Point(350, 210), 20);
        Form forme = new Circle(new Point(350, 230), 20);
        Controller controller = new Controller(forme);
        SwingUtilities.invokeLater(
            new Runnable() {
                @Override
                public void run() {
                    View view = new View("Projet POO", 900, 500);
                    controller.linkView(view);
                    view.setDrawable(forme);
                    forme.setView(view);
                    view.setVisible(true);
                }
            }
        );
        forme.evolveL();
    }
}
