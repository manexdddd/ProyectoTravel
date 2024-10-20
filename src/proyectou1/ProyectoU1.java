package proyectou1;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import com.seaglasslookandfeel.*;
import java.awt.Dimension;

/**
 *
 * @author ManeV
 */
public class ProyectoU1 {

    public static void main(String[] args) {
        try {

            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
          
        } catch (Exception e) {
            e.printStackTrace();
        }
  
        //creamos un panel
        Panel panel = new Panel();
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(1130, 740);
       panel.setMinimumSize(new Dimension(1120, 740));
        //desactivamos el redimensionar la ventana
        panel.setResizable(false);
        panel.setVisible(true);
    }

}
