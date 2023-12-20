package Command;




import java.io.Serializable;
import Pizarra.*;

public class CommandConfiguracion implements Serializable {

    public static void CommandConfiguracion(Pizarra p) {

        ArchivoPizarra ar = new ArchivoPizarra();
        ElementosPizarra ep = new ElementosPizarra();

        /**Botones para crear clases con titulo y campos extras:
         * Boton1: Serializa y guarda pizarra p
         * Boton2: Serializa y carga pizarra p
         * Boton5: Borra todas las clases y conectores de pizarra p
         */
        p.setBoton1(new CommandGuardarArchivoPizarra(ar, p));
        p.setBoton2(new CommandCargarArchivoPizarra(ar, p));
        p.setBoton5(new CommandDeleteAllElementosPizarra(ep, p));

        /**Botones para crear clases con titulo y campos extras:
         * Boton3: Añade una clase con solo un atributo
         * Boton4: Añade una clase con solo Metodos
         * Boton6: Añade una clase con Atrbuto y metodos
         */
        p.setBoton3(new CommandAddClaseAtributoPizarra(ep,p));
        p.setBoton4(new CommandAddClaseMetodoPizarra(ep,p));
        p.setBoton6(new CommandAddClaseCompletaPizarra(ep,p));

    }
}