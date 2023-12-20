package Command;

import Pizarra.*;

import java.io.Serializable;

public class CommandCargarArchivoPizarra implements Command, Serializable {
    public ArchivoPizarra ar;
    public Pizarra pizarra;
    public CommandCargarArchivoPizarra(ArchivoPizarra ar, Pizarra pizarra){
        this.ar = ar;
        this.pizarra = pizarra;
    }

    @Override
    public void execute() {
        ar.cargar(pizarra);
    }

}
