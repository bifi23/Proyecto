package Command;



import java.io.Serializable;
import Pizarra.*;

public class CommandAddClaseCompletaPizarra implements Command, Serializable {

    public ElementosPizarra ep;
    public Pizarra p;

    public CommandAddClaseCompletaPizarra(ElementosPizarra ep, Pizarra p){
        this.ep = ep;
        this.p = p;
    }

    @Override
    public void execute() {
        ep.AddClaseCompleta(p);
    }

}