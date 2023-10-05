package aula06;



public class Conjunto {
    private int[] vetor;

    public Conjunto(){
        this.vetor = new int[0];
    }

    public int[] getVetor(){
        return vetor;
    }

    public boolean contains(int n){
        boolean isThere = false;
        for (int i = 0; i<vetor.length; i++){
            if(vetor[i] == n ){
                isThere = true;
            }
        }
        return isThere;
    }

    public void insert(int n){
        if(contains(n)) {return;}
        int nl = vetor.length +1;
        int[] nv = new int[nl];
        for (int i = 0; i<vetor.length; i++){
            nv[i] = vetor[i];
        }
        nv[nl-1] =n;
        vetor = nv;
    }

    public void remove(int n){
        if (!contains(n)){return;}
        int nl = vetor.length-1;
        int[] nv = new int[nl];
        boolean removedFlag = false;

        for (int i = 0; i<vetor.length; i++){
            if(vetor[i] == n){
                removedFlag = true;
                continue;
            }

            if(!removedFlag){
                nv[i] = vetor[i];
            }
            else{
                nv[i-1] = vetor[i];
            }
        }
        vetor = nv;
    }

    public void empty(){
        vetor = new int[0];
    }

    @Override
    public String toString(){
        String s = "";
        for (int n : vetor){
            s += n+" ";
        }
        return s;
    }

    public int size(){
        return vetor.length;
    }

    public Conjunto combine(Conjunto add){
        Conjunto nc = new Conjunto();
        int[] v1 = this.vetor;
        int[] v2 = add.getVetor();
        for(int i = 0; i<v1.length; i++){
            nc.insert(v1[i]);
        }

        for (int i = 0; i<v2.length; i++){
            nc.insert(v2[i]);
        }

        return nc;
    }

    public Conjunto subtract(Conjunto diff){
        Conjunto nc = new Conjunto();
        nc = this;
        for (int i =0; i<diff.size(); i++){
            int v = diff.getVetor()[i];
            if(this.contains(v)){
                nc.remove(v);
            }
        }
        return nc;
    }

    public Conjunto intersect(Conjunto inter){
        Conjunto nc = new Conjunto();
        for (int i =0; i<inter.size(); i++){
            int v = inter.getVetor()[i];
            if(this.contains(v)){
                nc.insert(v);
            }
        }
        return nc;
        
    }

}
