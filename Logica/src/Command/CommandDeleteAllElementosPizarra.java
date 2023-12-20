package Command;
import Pizarra.*;




import java.io.Serializable;

public class CommandDeleteAllElementosPizarra implements Command, Serializable {

    public ElementosPizarra ep;
    public Pizarra p;

    public CommandDeleteAllElementosPizarra(ElementosPizarra ep, Pizarra p){
        this.ep = ep;
        this.p = p;
    }

    @Override
    public void execute() {
        ep.DeleteAll(p);
    }

}