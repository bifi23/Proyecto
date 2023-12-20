package Command;

import Pizarra.*;

import java.io.Serializable;

public class CommandAddClaseMetodoPizarra implements Command, Serializable {

    public ElementosPizarra ep;
    public Pizarra p;

    public CommandAddClaseMetodoPizarra(ElementosPizarra ep, Pizarra p){
        this.ep = ep;
        this.p = p;
    }

    @Override
    public void execute() {
        ep.AddClaseMetodo(p);
    }

}