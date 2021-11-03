package fr.mael;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class View extends JFrame {

    private JPanel panel;
    private DrawingPanel monPaneldeDessin;
    private Controller control;

    //Constructeur
    public View(String title, int width, int height){
        super(title);
        build(width, height);
    }

    //Méthodes

    public void setController(Controller controller) {
        monPaneldeDessin.setController(controller);
    }

    public void build(int width, int height){
        setPreferredSize(new Dimension(width, height));
        buildContentPane();
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    public void buildContentPane(){


        JPanel toolsPanel, form, way, nothing, intermediatePanel;
        JRadioButton square, circle, way1, way2;
        JButton run, quit;
        JLabel tool1, tool2;

        intermediatePanel = new JPanel(new BorderLayout());


        panel = new JPanel(new BorderLayout());
        monPaneldeDessin = new DrawingPanel();
        intermediatePanel.add(monPaneldeDessin, BorderLayout.CENTER);


        toolsPanel = new JPanel(new GridLayout(0,1));

        //Construction du panel form qui contient les bouttons radio square et circle
        form = new JPanel(new GridLayout(0,1));
        tool1 = new JLabel("Forme", JLabel.CENTER);
        form.add(tool1);

        //Création et ajout de Circle
        circle = new JRadioButton("Cercle");
        circle.setSelected(true);
        form.add(circle);
        //Création et ajout de square
        square = new JRadioButton("Carré");
        square.setSelected(false);
        form.add(square);
        //Ajout des boutons dans un groupe pour gérer l'exclusion mutuelle
        ButtonGroup group1 = new ButtonGroup();
        group1.add(square);
        group1.add(circle);

        //Construction du panel way qui contient les bouttons radio way1 et way2
        way = new JPanel(new GridLayout(0,1));
        tool2 = new JLabel("Chemin", JLabel.CENTER);
        way.add(tool2);

        //Création et ajout de way1
        way1 = new JRadioButton("Lemniscate");
        way1.setSelected(true);
        way.add(way1);
        //Création et ajout de way2
        way2 = new JRadioButton("Spirale");
        way2.setSelected(false);
        way.add(way2);
        //Ajout des boutons dans un groupe pour gérer l'exclusion mutuelle
        ButtonGroup group2 = new ButtonGroup();
        group2.add(way1);
        group2.add(way2);

        //Construction du panel nothing qui permet d'avoir une séparation enter form et way
        nothing = new JPanel();

        //Construction du bouton run qui va lancer le programme
        run = new JButton("Lancer le dessin");

        run.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        System.out.println("On relance !");
                        dispose();

                    if(circle.isSelected() && way1.isSelected()){
                        Form forme = new Circle(new Point(350, 210), 20);
                        Controller controller = new Controller(forme);
                        //Form forme = new Square(new Point(350, 230), 20);
                        SwingUtilities.invokeLater(
                            new Runnable() {
                                @Override
                                public void run() {
                                    View view = new View("Projet POO", 900, 500);
                                    controller.linkView(view);
                                    view.setDrawable(forme);
                                    forme.setView(view);
                                    view.setVisible(true);
                                    forme.evolveL();
                                }
                            }
                        );
                        //forme.evolve();
                    } else {
                        if(square.isSelected() && way1.isSelected()){
                            Form forme = new Square(new Point(350, 210), 20);
                            Controller controller = new Controller(forme);
                            //Form forme = new Square(new Point(350, 230), 20);
                            SwingUtilities.invokeLater(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        View view = new View("Projet POO", 900, 500);
                                        controller.linkView(view);
                                        view.setDrawable(forme);
                                        forme.setView(view);
                                        view.setVisible(true);
                                        forme.evolveL();
                                    }
                                }
                            );

                        } else {
                            if(circle.isSelected() && way2.isSelected()){
                                Form forme = new Circle(new Point(350, 210), 20);
                                Controller controller = new Controller(forme);
                                //Form forme = new Square(new Point(350, 230), 20);
                                SwingUtilities.invokeLater(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            View view = new View("Projet POO", 900, 500);
                                            controller.linkView(view);
                                            view.setDrawable(forme);
                                            forme.setView(view);
                                            view.setVisible(true);
                                            forme.evolveS();
                                        }
                                    }
                                );

                            } else {
                                if(square.isSelected() && way2.isSelected()){
                                    Form forme = new Square(new Point(350, 210), 20);
                                    Controller controller = new Controller(forme);
                                    //Form forme = new Square(new Point(350, 230), 20);
                                    SwingUtilities.invokeLater(
                                        new Runnable() {
                                            @Override
                                            public void run() {
                                                View view = new View("Projet POO", 900, 500);
                                                controller.linkView(view);
                                                view.setDrawable(forme);
                                                forme.setView(view);
                                                view.setVisible(true);
                                                forme.evolveS();
                                            }
                                        }
                                    );

                                }
                            }
                        }
                    }
                }
            }
        );

        //Construction du bouton quit qui va fermer le programme
        quit = new JButton("Quitter le programme");

        quit.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object source = e.getSource();

                    if (source == quit) // action a effectuer
                    dispose();
                }
            }
        );


        toolsPanel.add(run);
        toolsPanel.add(form);
        toolsPanel.add(nothing);
        toolsPanel.add(way);
        toolsPanel.add(quit);

        intermediatePanel.add(toolsPanel, BorderLayout.EAST);

        panel.add(intermediatePanel, BorderLayout.CENTER);

        getContentPane().add(panel);
        //getContentPane().addKeyListener(this);
    }

    //lie la vue à un objet Drawable
    public void setDrawable(Drawable obj) {
        monPaneldeDessin.setDrawable(obj);
    }

    //demande de rafraichissement de la vue transmise au panel
    public void update(){
        panel.repaint();
    }

    /*
    @Override
    public void keyPressed(KeyEvent e) {
        control.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        control.keyReleased(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {}

     */

}