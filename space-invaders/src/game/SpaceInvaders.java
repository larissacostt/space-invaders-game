package game;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SpaceInvaders extends JPanel implements Runnable, KeyListener{


    private Font minhaFonte = new Font("Consolas", Font.BOLD, 20);
    private Nave nave;
    private int direcao = 0;
    private ArrayList<Tiro> tiros;
    private ArrayList<Inimigo> inimigos;
    private boolean ganhou;
    private boolean perdeu;
    private boolean spacePressionado = false;

    public SpaceInvaders(){

        nave = new Nave();
        tiros = new ArrayList<Tiro>();
        inimigos = new ArrayList<Inimigo>();
        ganhou = false;
        perdeu = false;

        BufferedImage imagemInimigo = null;
        try{
            imagemInimigo = ImageIO.read(
                getClass().getResource("/imagens/inimigo.png")
            );

            System.out.println("Inimigo carregada");
            
        }catch(IOException e){
            System.out.println("Não foi possivel carregar a imagem do inimigo");
            e.printStackTrace();
        }

        for(int i = 0; i< 60; i++){
            inimigos.add(
                new Inimigo (
                    imagemInimigo, 
                    50 + i % 15 * 50, 
                    50 + i/ 15 * 50, 
                    1));
        }

        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);

        Thread lacoDoJogo = new Thread(this);
        lacoDoJogo.start();
    }

    @Override
    public void run() {
       while(true){

        long tempoInicial = System.currentTimeMillis();

        update();
        repaint();

        long tempoFinal = System.currentTimeMillis();

        long diferenca = 16 -(tempoFinal - tempoInicial);


        if(diferenca > 0){
            dorme(diferenca);
        }
       }
    }

    private void update(){
        if(inimigos.size() == 0){
            ganhou = true;
        }
        nave.movimenta(direcao);

        if(spacePressionado && nave.podeAtirar()){
            tiros.add(nave.atirar());
        }

        for(int i = 0; i< inimigos.size(); i++){

            if(inimigos.get(i).getY()>= 450){
                perdeu = true;
            }
        }

        for(int i = 0; i< tiros.size(); i++){

            tiros.get(i).atualiza();

            if(tiros.get(i).destroy()){
                tiros.remove(i);
                i--;

            }else{
                for(int j = 0; j< inimigos.size(); j++){
                    if(tiros.get(i).colideCom(inimigos.get(j))){

                        inimigos.remove(j);
                        j--;

                        tiros.remove(i);

                        break;
                    }
                }
            }

        }

        boolean bateuNaBorda = false;

        for(int i = 0; i < inimigos.size(); i++){

            if((inimigos.get(i).getX() >= 750 && inimigos.get(i).getDirecao() == 1) ||
                (inimigos.get(i).getX() <= 25 && inimigos.get(i).getDirecao() == -1)){

                bateuNaBorda = true;
                break;
            }
        }

        if(bateuNaBorda){

            for(int i = 0; i < inimigos.size(); i++){
                inimigos.get(i).trocarDirecao();
            }

        } else {

            for(int i = 0; i < inimigos.size(); i++){
                inimigos.get(i).atualizar();
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

        if(ganhou){
            g.setColor(Color.white);
            g.setFont(minhaFonte);
            g.drawString("VOCÊ GANHOU !!", 300, 300);
        }
        if(perdeu){
            g.setColor(Color.white);
            g.setFont(minhaFonte);
            g.drawString("VOCÊ PERDEU!! :(", 300, 300);
        }

        g.dispose();

    }

    private void dorme(long duracao){
        try {
            Thread.sleep(duracao);
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
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            spacePressionado = true;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_D){
            direcao = 0;
        }if(e.getKeyCode() == KeyEvent.VK_A){
            direcao = 0;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
        spacePressionado = false;
}
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}

