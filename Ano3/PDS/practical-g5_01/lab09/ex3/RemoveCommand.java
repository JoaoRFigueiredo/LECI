// package lab09.ex3;

import java.util.Collection;
//import java.util.LinkedList;

public class RemoveCommand<T> implements Command {
    private final T element;    
    private final Collection<T> collection;

    public RemoveCommand(T element, Collection<T> collection){
        this.element = element;
        this.collection = collection;
    }


    @Override
    public void Execute() {
        // TODO Auto-generated method stub
        collection.remove(element);
    }

    @Override
    public void Undo() {
        // TODO Auto-generated method stub
        collection.add(element);     
    }

    
}
