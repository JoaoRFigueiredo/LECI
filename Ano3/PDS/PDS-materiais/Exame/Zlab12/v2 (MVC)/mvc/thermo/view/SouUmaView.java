package view;

import javax.swing.JPanel;

import model.Thermometer;
import model.ThermometerListener;

public class SouUmaView extends JPanel implements ThermometerListener {
  private final Thermometer therm;

  public SouUmaView(Thermometer t) {
    therm = t;
  }

  @Override
  public void temperatureChanged() {
    // TODO Auto-generated method stub
    System.out.println("View mais melhorada: " + therm.getTemperature());
  }

}
