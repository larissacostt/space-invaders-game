import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Inimigo {

    private BufferedImage desenho;
    private int x;
    private int y;

    public Inimigo(int inicioX, int inicioY){
        try{
            desenho = ImageIO.read(
                getClass().getResource("/imagens/inimigo.png")
            );

            System.out.println("Nave carregada");
            
        }catch(IOException e){
            System.out.println("Não foi possivel carregar a imagem do inimigo");
            e.printStackTrace();
        }
        this.x = inicioX;
        this.y= inicioY;

    }

    public void atualizar(){
        x++;
        if(x > 1365){
            x = 0;
        }
    }
    
    public void pintar(Graphics2D g){
        g.drawImage(desenho, x, y, x + 50, y + 50, 0, 0, desenho.getWidth(), desenho.getHeight(), null);

    }
    
}
