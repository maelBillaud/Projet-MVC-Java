package fr.mael;

import java.awt.*;

public class Point {

    //Attributs :
    private double x, y;

    //Constructeur :
    public Point(double x, double y){
        this.x = x;
        this.y  =y;
    }

    public double getx(){return x;}
    public double gety(){return y;}

    public void setx(double x){this.x = x;}
    public void sety(double y){this.y = y;}

    //Méthodes :
    public String toString(){
        return "(" + this.getx() + "," + this.gety() + ")";
    }

    //Fonction qui retourne la distance entre deux points
    public double distance(Point p1){
        return Math.sqrt(Math.pow(p1.getx()-x, 2) + Math.pow(p1.gety()-y, 2));
    }
}
