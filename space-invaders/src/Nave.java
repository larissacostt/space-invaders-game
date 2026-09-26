import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Nave {

    private BufferedImage desenho;
    private int x;
    private int velocidade;
    private boolean podeAtirar;
    private int tempo;

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
        velocidade = 3;
        podeAtirar = true;
        tempo = 0;
    }

    public void pintar(Graphics2D g) {
        if(desenho != null){
            g.drawImage(desenho, x, 580, 100, 100, null);
        }
    }

    public Tiro atirar(){
        podeAtirar = false;
        Tiro novoTiro = new Tiro (x + 49, 550);
        return novoTiro;
    }

    public void movimenta(int valor) {
        if(valor == 1){
            x+= velocidade;
        } else if(valor == -1){
            x-= velocidade;
        }

        if(tempo >= 10){
            podeAtirar = true;
            tempo =0;
        }
        tempo++;
    }
    public boolean podeAtirar(){
        return podeAtirar;
    }

}
