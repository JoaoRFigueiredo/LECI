public abstract class Value {
    private boolean isVector;
    private boolean isScalar;

    public boolean isVector() {
        return isVector;
    }
    
    public boolean isScalar(){
        return isScalar;
    }

    public abstract Value symmetric();
    public abstract Value add(Value f);
    public abstract Value sub(Value f);
    public abstract Value mul(Value f);
    public abstract Value intProd(Value f);
    

    public void setVector(boolean isVector) {
        this.isVector = isVector;
    }

    public void setScalar(boolean isScalar){
        this.isScalar = isScalar;
    }

	
}
