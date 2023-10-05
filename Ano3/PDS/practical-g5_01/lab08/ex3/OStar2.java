import java.awt.Color;

public class OStar2 extends StarType2{
    
    public OStar2() {
        super(5, new Color(225, 250, 250));
        this.description = "This is a long description of the O type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }
}
