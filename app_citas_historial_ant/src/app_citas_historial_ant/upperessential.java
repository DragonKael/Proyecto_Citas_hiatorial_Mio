
package app_citas_historial_ant;

import UpperEssential.UpperEssentialLookAndFeel;
import VISTA.frmmanusuario;
import javax.swing.GroupLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author DragonKael
 */
public class upperessential {
    public static void main(String[] args)  throws  UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
        //UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("/home/DragonKael/Documentos/Apache NetBeans/upperessential/DarwinTema.theme"));
        VISTA.frmmanusuario lib = new frmmanusuario();
        lib.setLocation(1000,500);
        //UpperEssential lib = new UpperEssential();
        lib.setVisible(true);
    }
}
