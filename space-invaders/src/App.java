import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame janela = new JFrame ("Space Invaders");
        
        janela.setSize(1366, 738);
        janela.setLocationRelativeTo(janela);
        janela.setLayout(null); // 
        SpaceInvaders invasaoAliegena = new SpaceInvaders();
        invasaoAliegena.setBounds(0, 0, 1366, 768);

        janela.add(invasaoAliegena);

        janela.setVisible(true);


        
       
    }
}

