import java.io.Serializable;
import java.util.ArrayList;


import javax.swing.*;

public class main implements Serializable {

    //Los test estan en out>testconectores

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GestorPestanas gp = new GestorPestanas();
                gp.setVisible(true);
            }
        });
    }

}


