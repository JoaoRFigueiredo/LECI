//package lab09.ex3;
import java.util.Collection;
import java.util.LinkedList;


public class Example {
    public static void main(String[] args) {
        Collection<String> collection = new LinkedList<>();
        Invoker invoker = new Invoker();

        // Adiciona um elemento na coleção
        String element = "hello";
        Command addCommand = new AddCommand<>(element, collection);
        invoker.add(addCommand);
        System.out.println(collection); // [hello]

        // Adiciona outro elemento na coleção
        String element2 = "world";
        Command addCommand2 = new AddCommand<>(element2, collection);
        invoker.add(addCommand2);
        System.out.println(collection); // [hello, world]

        // Desfaz a última operação de adição
        invoker.undo();
        System.out.println(collection); // [hello]

        // Remove o último elemento adicionado
        Command removeCommand = new RemoveCommand<>(element2, collection);
        invoker.add(removeCommand);
        System.out.println(collection); // [hello]

        // Desfaz a última operação de remoção
        invoker.undo();
        System.out.println(collection); // [hello, world]

        // Adiciona um terceiro elemento na coleção
        String element3 = "again";
        Command addCommand3 = new AddCommand<>(element3, collection);
        invoker.add(addCommand3);
        System.out.println(collection); // [hello, world, again]

        // Desfaz a última operação de adição novamente
        invoker.undo();
        System.out.println(collection); // [hello, world]

        // Remove um elemento existente na coleção
        Command removeCommand2 = new RemoveCommand<>(element, collection);
        invoker.add(removeCommand2);
        System.out.println(collection); // [world]

        // Desfaz a última operação de remoção
        invoker.undo();
        System.out.println(collection); // [hello, world]
    }
}
