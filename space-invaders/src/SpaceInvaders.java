
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SpaceInvaders extends JPanel implements Runnable {

    private Nave nave;

    public SpaceInvaders(){

        nave = new Nave();

        Thread lacoDoJogo = new Thread(this);
        lacoDoJogo.start();
    }

    @Override
    public void run() {
       while(true){
        update();
        repaint();
        dorme();
       }

    }

    private void update(){

    }
    int x = 0;
    public void paintComponent(Graphics g){
        super.paintComponent(g); //limpa tela

        g.setColor(Color.black);
        g.fillRect(x++, 0,50, 50);
        
        nave.pinta();

    }

    private void dorme(){
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

