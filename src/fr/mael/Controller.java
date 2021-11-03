package fr.mael;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Controller implements ActionListener {
    //Attributs
    private Form forme;
    private View view;
    private ArrayList<Color> colorArrayList = new ArrayList<>();
    private int colorNumber;

    //Constructeur
    public Controller(Form forme){
        this.forme = forme;


        //Ajout des couleurs dans le tableau :
        colorArrayList.add(Color.BLACK);
        colorArrayList.add(Color.BLUE);
        colorArrayList.add(Color.CYAN);
        colorArrayList.add(Color.GREEN);
        colorArrayList.add(Color.ORANGE);
        colorArrayList.add(Color.PINK);
        colorArrayList.add(Color.RED);
        colorArrayList.add(Color.YELLOW);
        colorArrayList.add(Color.MAGENTA);
        colorArrayList.add(Color.DARK_GRAY);

        colorNumber = 0;
    }

    public void linkView(View view) {
        this.view = view;
        forme.setView(view);
        view.setController(this);
    }

    public void setColorNumber(){
        double x = Math.random();
        colorNumber = (int)(x * 11);
    }

    public void mouseClicked(int x, int y){
        Form f = forme.getForm();
        if (f.contains(x, y)) {
            setColorNumber();
            //Verification que la nouvelle couleur tirée ne soit pas identique à la précédante
            while (colorArrayList.get(colorNumber) == f.getColor()){
                setColorNumber();
            }
            f.setColor(colorArrayList.get(colorNumber));
            view.update();
        }
    }

    //Je ne comprend pas

    public void keyPressed(int keyCode) {
        System.out.println("Press : "+ keyCode);
        if(keyCode == 107){
            forme.moreSpeed();
        } else {
            if (keyCode ==109){
                forme.lessSpeed();
            }
        }
    }

    public void keyReleased(int keyCode) {
        System.out.println("Release : "+ keyCode);
        if(keyCode == 107){
            forme.moreSpeed();
        } else {
            if (keyCode ==109){
                forme.lessSpeed();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
