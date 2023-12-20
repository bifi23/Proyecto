package Command;

import Pizarra.*;


import java.io.Serializable;

public class CommandAddClaseAtributoPizarra implements Command, Serializable {

    public ElementosPizarra ep;
    public Pizarra p;

    public CommandAddClaseAtributoPizarra(ElementosPizarra ep, Pizarra p){
        this.ep = ep;
        this.p = p;
    }

    @Override
    public void execute() {
        ep.AddClaseAtrbuto(p);
    }

}