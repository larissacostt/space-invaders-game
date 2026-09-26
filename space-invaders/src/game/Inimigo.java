package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Inimigo {

    private BufferedImage desenho;
    private int x;
    private int y;
    private int velocidade;
    private int direcao;

    public Inimigo(BufferedImage imagem, int inicioX, int inicioY, int direcao){
    
        this.desenho = imagem;
        this.x = inicioX;
        this.y= inicioY;
        this.direcao= direcao;
        this.velocidade = 2;

    }

    public void atualizar(){
        x += velocidade * direcao;
    }

    public void trocarDirecao(){

        direcao = direcao * -1;
        y += 5;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return  y;
    }
    
    public void pintar(Graphics2D g){
        if(desenho != null){

        g.drawImage(desenho, x, y, 50, 50,null);
        }
    }

    public int getTam() {
        return 50;
      
    }

    public int getDirecao() {
        return direcao;
    }

    


    
}
