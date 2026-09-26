import java.awt.Color;
import java.awt.Graphics2D;

public class Tiro {

    private int x;
    private int y;
    private int velocidade;


    public Tiro(int inciox, int incioy){

        this.x = inciox;
        this.y = incioy;
        this.velocidade = 10;

    }
    public void pintar(Graphics2D g){
        
        g.setColor(Color.red);
        g.fillRect(x, y, 5, 25);
    }
    public void atualiza() {
        y -= velocidade;

    }
    public boolean destroy() {
        return y < 0;

    }
    
}
