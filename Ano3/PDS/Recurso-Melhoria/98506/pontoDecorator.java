abstract class pontoDecorator implements Geometria{
    protected Geometria g;
    
    @Override
    public void draw(){
        g.draw();
    }   

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }
}
