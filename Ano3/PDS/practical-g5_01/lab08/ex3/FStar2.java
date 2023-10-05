import java.awt.Color;

public class FStar2 extends StarType2{
    
    public FStar2() {
        super(2, new Color(255, 255, 245));
        this.description = "This is a long description of the F type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }
}
