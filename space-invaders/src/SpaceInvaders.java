
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class SpaceInvaders extends JPanel implements Runnable, KeyListener{

    private Nave nave;
    private int direcao = 0;

    public SpaceInvaders(){

        nave = new Nave();

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

        g.setColor(Color.BLUE);
        g.fillRect(x++, 50, 50, 50);

        nave.pintar(g);
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
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            direcao = 1;
        }if(e.getKeyCode() == KeyEvent.VK_A){
            direcao = -1;
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_D){
            direcao = 0;
        }if(e.getKeyCode() == KeyEvent.VK_A){
            direcao = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    
}

