// package lab09.ex3;

import java.util.Collection;
//import java.util.LinkedList;

public class AddCommand<T> implements Command {
    private final T element;    
    private final Collection<T> collection;

    public AddCommand(T element, Collection<T> collection){
        this.element = element;
        this.collection = collection;
    }


    @Override
    public void Execute() {
        // TODO Auto-generated method stub
        collection.add(element);
    }

    @Override
    public void Undo() {
        // TODO Auto-generated method stub
        collection.remove(element);     
    }

    
}
