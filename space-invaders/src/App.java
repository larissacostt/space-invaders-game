import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame janela = new JFrame ("Space Invaders");
        
        janela.setSize(1366, 738);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null); // 
        
        SpaceInvaders invasaoAliegena = new SpaceInvaders();

        janela.add(invasaoAliegena);

        invasaoAliegena.setFocusable(true);
        invasaoAliegena.addKeyListener(invasaoAliegena);

        janela.setVisible(true);

    }
}

