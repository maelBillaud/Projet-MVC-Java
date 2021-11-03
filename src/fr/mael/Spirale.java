package fr.mael;

import java.lang.Math;

import static java.lang.Math.*;
import static java.lang.Math.sin;

public class Spirale extends Way{
    //Attributs
    private double degrees;//Espacement des formes
    private double end;//Nombre de formes
    private final double a = 0;//Plus la valeur est grande, plus l'enroulement sur elle même au debut est faible
    private final double b = 20;//Espacement entre les boucles
    private final double c = 1;//Plus c est grand, plus la spirale est "recroquevillée"sur elle même

    //Constructeur
    public Spirale(String name, double end){
        super(name);
        this.end = end;
    }

    public void baseWay(double pas){
        this.degrees = toRadians(pas);
        this.end = end * degrees;
        for (double theta = 0; theta < end; theta += degrees) {
            double r = a + b * pow(theta, 1 / c);
            double x = r * cos(theta);
            double y = r * sin(theta);
            getRoad().add(new Point(x, y));
        }
    }
}
