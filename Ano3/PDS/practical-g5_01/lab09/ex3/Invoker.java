// package lab09.ex3;
import java.util.Collection;
import java.util.LinkedList;

public class Invoker {
    private final Collection<Command> commands = new LinkedList<>();



    public void add(Command command){
        commands.add(command);
        command.Execute();
    }

    public void undo(){
        if(!commands.isEmpty()){
            Command command = ((LinkedList<Command>) commands).removeLast();
            command.Undo();
        }
    }


}
