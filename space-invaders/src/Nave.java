import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Nave {

    private BufferedImage desenho;
    private int x;

    public Nave(){
        
        try{
            desenho = ImageIO.read(
                getClass().getResource("/imagens/nave.png")
            );

            System.out.println("Nave carregada");
            
        }catch(IOException e){
            System.out.println("Não foi possivel carregar a imagem");
            e.printStackTrace();
        }

        x = 683;
    }

    public void pintar(Graphics2D g) {
        if(desenho != null){
            g.drawImage(desenho, 350, 480, 100, 100, null);
        }
    }

    public void movimento(int valor){
        
    }

}
