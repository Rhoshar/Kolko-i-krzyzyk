import java.awt.Color;
import javax.swing.JButton;


public class Komorka extends JButton{
    private static int gracz = 0;
    private static int numerator = 1;
    public int numer;
    public boolean zajety;
    
    public Komorka(String string){
        super(string);
        this.numer = numerator++;
        zajety = false;
        this.setBackground(Color.WHITE);
    }
        public Komorka(){
        super();
        this.numer = numerator++;
        zajety = false;
        this.setBackground(Color.WHITE);
    }
    
}
