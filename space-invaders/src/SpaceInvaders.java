import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class SpaceInvaders extends JPanel implements Runnable, KeyListener{

    private Nave nave;
    private int direcao = 0;
    private ArrayList<Tiro> tiros;
    private ArrayList<Inimigo> inimigos;

    public SpaceInvaders(){

        nave = new Nave();
        tiros = new ArrayList<Tiro>();
        inimigos = new ArrayList<Inimigo>();

        for(int i = 0; i< 20; i++){
            inimigos.add(new Inimigo (50 + 100 * i, 50 + 50 * i % 10 ));
        }

        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);

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
        nave.movimenta(direcao);

        for(int i = 0; i< inimigos.size(); i++){
        inimigos.get(i).atualizar();
        }

        for(int i = 0; i< tiros.size(); i++){
            tiros.get(i).atualiza();

            if(tiros.get(i).destroy()){
                tiros.remove(i);
                i--;
            }
        }



    }
    int x = 0;
    public void paintComponent(Graphics g2){
        super.paintComponent(g2);

        Graphics2D g = (Graphics2D) g2.create();

        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );

        g.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );


        for(int i = 0; i< inimigos.size(); i++){
            inimigos.get(i).pintar(g);
        }

        nave.pintar(g);

        for(int i = 0; i< tiros.size(); i++){
            tiros.get(i).pintar(g);
        }
        
        g.dispose();


    }

    private void dorme(){
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            direcao = 1;
        }if(e.getKeyCode() == KeyEvent.VK_A){
            direcao = -1;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE && nave.podeAtirar()){
            tiros.add(nave.atirar());
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            direcao = 0;
        }if(e.getKeyCode() == KeyEvent.VK_A){
            direcao = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}

