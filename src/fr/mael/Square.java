package fr.mael;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Square extends Form{
    //Attibuts :
    private float cote; //La longeur d'un côté
    private Color color;

    //Constructeur :
    public Square(Point center, float cote){
        super(center);
        this.cote = cote;
        color = Color.BLACK;
    }

    //Methodes :

    public void draw(Graphics g){
        for (int i = 0; i < getCentersForm().size(); i+= 10) {
            int x = (int) super.getCentersForm().get(i).getx(),
                    y = (int) super.getCentersForm().get(i).gety(),
                    c = (int) cote;
            g.setColor(color);
            g.drawRect(x, y, c, c);
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
        double xMax, xMin, yMax, yMin;
        xMax = getCentersForm().get(getCentersForm().size()-1).getx() + cote;
        xMin = getCentersForm().get(getCentersForm().size()-1).getx();
        yMax = getCentersForm().get(getCentersForm().size()-1).gety() + cote;
        yMin = getCentersForm().get(getCentersForm().size()-1).gety();

        System.out.println("\n\nZone cliquable :\n                  " + yMax + "\n\n" + xMin + "                  " + xMax + "\n\n                  " + yMin);
        System.out.println("Coordonnées clic souris : x = " + x + " y = " + y);
        boolean test = (xMax >= x && x >= xMin) && (yMax >= y && y >= yMin);
        System.out.println("Retour fonction contains : " + test);
        return test;
    }
}
