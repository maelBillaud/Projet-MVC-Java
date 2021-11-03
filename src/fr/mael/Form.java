package fr.mael;

import java.awt.*;
import java.util.ArrayList;

public abstract class Form implements Drawable {

    //Attribut

    private ArrayList<Point> centersForm = new ArrayList<>();
    private double baseX, baseY;
    private View view;
    private int speed;//Vitesse de déplacement de la forme

    //Constructeur

    public Form (Point c){
        centersForm.add(c);
        baseX = centersForm.get(0).getx();
        baseY = centersForm.get(0).gety();
        speed = 10;
    }

    //Méthodes

    public ArrayList<Point> getCentersForm() {
        return centersForm;
    }

    public void moreSpeed(){
        speed ++;
    }

    public void lessSpeed(){
        speed --;
    }

    public abstract void draw(Graphics g);// Comme le cercle et le carre ne sont pas dessinés pareils, on va redef draw dans leurs classes

    public abstract Color getColor();// Retourne la couleur actuelle de la forme

    public abstract void setColor(Color color);// Change la couleur de la forme

    public Form getForm(){ // Retourne la forme
        return this;
    }

    public abstract boolean contains(int x, int y);

    public void evolveL(){
        Way lemniscate = new Lemniscate("Lemniscate", 300);
        ((Lemniscate) lemniscate).baseWay(0.01);
        for (int i = 0; i < lemniscate.getRoad().size(); i++){
            translate(lemniscate.getRoad().get(i));
            try {
                Thread.sleep(speed);
            } catch (Exception e){}
        }
    }

    public void evolveS(){
        Way spirale = new Spirale("Spirale", 600);
        ((Spirale) spirale).baseWay(1);
        for (int i = 0; i < spirale.getRoad().size(); i++){
            translate(spirale.getRoad().get(i));
            try {
                Thread.sleep(speed);
            } catch (Exception e){}
        }
    }

    public void translate(Point p){
        double x = baseX + p.getx();
        double y = baseY + p.gety();
        centersForm.add(new Point(x, y));
        if(view != null){
            view.update();
        }
    }

    //Lie l'objet à une vue
    public void setView(View view){
        this.view = view;
    }

}
