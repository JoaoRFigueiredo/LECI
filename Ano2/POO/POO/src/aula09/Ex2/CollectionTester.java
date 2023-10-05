package aula09.Ex2;

import java.util.ArrayList;
import java.util.Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import java.util.TreeSet;

public class CollectionTester {
    public static void main(String[] args) {
        //int DIM = 5000;
        int[] dims = {1000, 5000, 10000, 20000, 40000, 100000};
        Collection<Integer> col1 = new ArrayList<>();
        Collection<Integer> col2 = new LinkedList<>();
        Collection<Integer> col3 = new HashSet<>();
        Collection<Integer> col4 = new TreeSet<>();
        
        
        System.out.printf("%-15s%-1d\t\t%-1d\t\t%-1d\t\t%-1d\t\t%-1d\t\t%-1d\n", "Collection", 1000, 5000, 10000, 20000, 40000, 100000);
        printTable(col1, dims);
        printTable(col2, dims);
        printTable(col3, dims);
        printTable(col4, dims);
    }

    private static double[] checkPerformance(Collection<Integer> col, int DIM) {
    double start, stop, delta;
    double add, search, remove;
    // Add
    start = System.nanoTime(); // clock snapshot before
    for(int i=0; i<DIM; i++ ) col.add( i );
    stop = System.nanoTime(); // clock snapshot after
    delta = (stop-start)/1e6; // convert to milliseconds
    add = delta;
    //System.out.println(col.size()+ ": Add to " + col.getClass().getSimpleName() +" took " + delta + "ms");
    // Search
    start = System.nanoTime(); // clock snapshot before
    for(int i=0; i<DIM; i++ ) {
        int n = (int) (Math.random()*DIM);
        if (!col.contains(n)) System.out.println("Not found???"+n);
    }
    stop = System.nanoTime(); // clock snapshot after
    delta = (stop-start)/1e6; // convert nanoseconds to milliseconds
    search = delta;
   // System.out.println(col.size()+ ": Search to " + col.getClass().getSimpleName() +" took " + delta + "ms");
    // Remove
    start = System.nanoTime(); // clock snapshot before
    Iterator<Integer> iterator = col.iterator();
    while (iterator.hasNext()) {
     iterator.next();
     iterator.remove();
    }
    stop = System.nanoTime(); // clock snapshot after
    delta = (stop-start)/1e6; // convert nanoseconds to milliseconds
    remove = delta;
    //System.out.println(col.size() + ": Remove from "+ col.getClass().getSimpleName() +" took " + delta + "ms");
    double[] arr = {add, search, remove};
    return arr;

    }

    private static void printTable(Collection<Integer> c, int[] dims){
        double[][] values = new double[3][dims.length];
        String[] arr = {"Add", "Search", "Remove"};

        

            for (int j = 0; j<dims.length; j++){
                double[] temp = checkPerformance(c, dims[j]);
                values[0][j] = temp[0];
                values[1][j] = temp[1];
                values[2][j] = temp[2];
            }
        

       
        System.out.println(c.getClass().getSimpleName());

        for(int i = 0; i<3; i++){
            System.out.printf("%-15s", arr[i]);
            for (int j = 0; j<values[i].length; j++){

                System.out.printf("%-7.3f\t\t", values[i][j]);
            }
            System.out.println();
        }

       
       

    }
}