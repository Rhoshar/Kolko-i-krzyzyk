import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class KolkoKrzyzyk extends JFrame implements ActionListener {

    private static final int[][] WYGRANA = {{1,2,3},{4,5,6},{7,8,9},
                                            {1,4,7},{2,5,8},{3,6,9},
                                            {1,5,9},{3,5,7}};

     
    char wygrany;
    int[] gracz1 = new int[9];
    int i1=0;
    
    int[] gracz2 = new int[9];
    int i2=0;
    
    private int gracz = 1;

    private Komorka[] przycisk = new Komorka[9];
    
        public KolkoKrzyzyk(String string) {
        super(string);
        setLocation(310,150);
        setPreferredSize(new Dimension(600, 400));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        for(int i=0; i<9; i++){
            przycisk[i] = new Komorka("");
            przycisk[i].addActionListener(this);
            add(przycisk[i]);
        }
        
        setLayout(new GridLayout(3,3));
	setPreferredSize(new Dimension(600, 400));
        JOptionPane.showMessageDialog(null,"Zaczyna O");
        }
        public void resetGry(){
            for(int i=0; i<9; i++){
            przycisk[i].zajety = false;
            przycisk[i].setText("");
            gracz1[i]=0;
            i1=0;
            gracz2[i]=0;
            i2=0;
            wygrany = 0;
            gracz = 0;
            }
            JOptionPane.showMessageDialog(this,"Nowa gra. Zaczyna O");
        }
            @Override
            public void actionPerformed(ActionEvent e){
            Object source = e.getSource();
            Komorka przycisk = new Komorka();
            przycisk = (Komorka) source;

            if(przycisk.zajety)
                return;
            if(gracz == 1){
                gracz1[i1] = przycisk.numer;
                i1++;
                przycisk.setText("O");
                przycisk.setFont(przycisk.getFont().deriveFont(72.0f));
                przycisk.zajety = true;
                if(sprawdzWygrana1()){
                    System.out.println("Wygral O");
                    wygrany = 'O';
                    JOptionPane.showMessageDialog(this,"Wygra³ gracz "+wygrany);
                    resetGry();
                }
                if(i1==5){
                     JOptionPane.showMessageDialog(this,"Remis");
                     resetGry();
                }
            }
            else {
                gracz2[i2] = przycisk.numer;
                i2++;
                przycisk.setText("X");
                przycisk.setFont(przycisk.getFont().deriveFont(72.0f));
                przycisk.zajety = true;
                
                if(sprawdzWygrana2()){
                    System.out.println("Wygral X");
                    wygrany = 'X';
                    JOptionPane.showMessageDialog(this,"Wygra³ gracz "+wygrany);
                    resetGry();
                }
                if(i2==5){
                     JOptionPane.showMessageDialog(this,"Remis");
                     resetGry();
                }
            }
            gracz = (gracz + 1)%2;
            
            
        }
            
        private boolean sprawdzWygrana1(){
        int temp = 0;
        for(int j=0; j<WYGRANA.length; j++){
        for(int k=0; k<WYGRANA[j].length; k++)
        for(int i: gracz1){
        if( i == WYGRANA[j][k] )
        temp++;
        }
        if(temp == 3)
        return true;
        else temp = 0;
        
        }
        return false;
        }
              
              
        private boolean sprawdzWygrana2(){
           int temp = 0;
            for(int j=0; j<WYGRANA.length; j++){
                for(int k=0; k<WYGRANA[j].length; k++)
                    for(int i: gracz2){
                       if( i == WYGRANA[j][k] )
                           temp++;
                           }
                if(temp == 3){
                return true;
                }
                else temp = 0;
                
            }
        return false;          
        }
}