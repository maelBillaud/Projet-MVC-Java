package fr.mael;

import java.awt.*;

public class Circle extends Form{

    //Attributs

    private double rad; // rayon d’un cercle
    private Color color;

    // constructeur

    public Circle(Point center, double r) {
        super(center);
        rad = r;
        color = Color.BLACK;
    }

    //Méthodes

    public void draw(Graphics g) {
        for (int i = 0; i < getCentersForm().size(); i+= 10) {
            int d = (int) (rad * 2),
                    x = (int) (super.getCentersForm().get(i).getx() - rad),
                    y = (int) (super.getCentersForm().get(i).gety() - rad);
            g.setColor(color);
            g.drawOval(x, y, d, d);
        }
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean contains(int x, int y) {
        Point p1 = new Point(x, y);
        return rad >= getCentersForm().get(getCentersForm().size()-1).distance(p1);
    }
}
