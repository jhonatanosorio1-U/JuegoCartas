import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Carta {

    private int indice;
    private final int TOTAL_BARAJAS=3;
    /* private Random r  = new Random(); */

    public Carta(Random r){
        indice = r.nextInt(52* TOTAL_BARAJAS) +1;
    }

    public void mostrar(JPanel pnl, int x, int y){
        String rutaImagen= "imagenes/CARTA" + indice + ".JPG";
        ImageIcon imgCarta = new ImageIcon(getClass().getResource(rutaImagen));
        JLabel lbl = new JLabel(imgCarta);
        lbl.setBounds(x,y,imgCarta.getIconWidth(), imgCarta.getIconHeight());
        pnl.add(lbl);

        //TODO: no mostrar una carta más veces que la cantidad de barajas
        
        //evento para mostrar la identidad de la carta(Nombre y pinta)
        lbl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                JOptionPane.showMessageDialog(null, getNombre() + " de " + getPinta());
            }
        });
    }

    //Getters
    public Pinta getPinta(){
        if(indice <= 13){
            return Pinta.TREBOL;
        }else if(indice <= 26){
            return Pinta.PICA;
        }else if(indice <= 39){
            return Pinta.CORAZON;
        }else{
            return Pinta.DIAMANTE;
        }
    } 

    public NombreCarta getNombre(){
        int residuo = indice % 13;
        if(residuo == 0){
            residuo = 13;
        }
        return NombreCarta.values()[residuo-1];
    }
    
}
