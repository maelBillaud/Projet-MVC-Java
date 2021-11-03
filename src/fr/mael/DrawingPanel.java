package fr.mael;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import javax.swing.*;

public class DrawingPanel extends JPanel implements MouseListener, KeyListener {

    //Attibuts
    private Drawable obj;
    private Controller control;

    //Constructeur
    public DrawingPanel() {
        super();
        addMouseListener(this);// ecouteur
        addKeyListener(this);
    }

    //methodes

    //lie le panel à un objet Drawable
    public void setDrawable(Drawable obj) {
        this.obj = obj;
    }

    public void setController(Controller control) {
        this.control = control;
    }

    //Dessin du composant
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (obj != null) {
            obj.draw(g);
        }

    }

    //Clics souris

    //4 Méthodes inutiles dans notre cas
    public void mousePressed (MouseEvent e){}
    public void mouseReleased (MouseEvent e){}
    public void mouseEntered (MouseEvent e){}
    public void mouseExited (MouseEvent e){}


    // Méthode appelée qund la souris à été pressée puis relachée
    public void mouseClicked (MouseEvent e){
        control.mouseClicked(e.getX(), e.getY());
    }

    //Touches du clavier
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


}