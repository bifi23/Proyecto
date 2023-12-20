package Command;

import Pizarra.*;


import java.io.Serializable;

public class CommandDeleteElementElementosPizarra implements Command, Serializable {

    public ElementosPizarra ep;

    public CommandDeleteElementElementosPizarra(ElementosPizarra ep){
        this.ep = ep;
    }

    @Override
    public void execute() {
        ep.DeleteElement();
    }

}