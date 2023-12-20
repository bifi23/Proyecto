package Command;

import Pizarra.*;


import java.io.Serializable;

public class CommandGuardarArchivoPizarra implements Command, Serializable {
    private ArchivoPizarra ar;
    private Pizarra pi;

    /**
     * @param ar: Instancia de la clase ArchivoPizarra para poder usar metodo guardar
     * @param pi: Instancia de la pizarra que se esta manejando para ser guardada
     */
    public CommandGuardarArchivoPizarra(ArchivoPizarra ar, Pizarra pi){
        this.ar = ar;
        this.pi = pi;
    }

    @Override
    public void execute() {
        ar.guardar(pi);
    }

}