
public class RadioStationInfo {
    private String name = null;
    private double frequency;

    public RadioStationInfo(String nomeRDS, double frequenciaFM) {
	this.name = nomeRDS;
	this.frequency = frequenciaFM;
    }

    public String name() {
	return name;
    }

    public double frequency() {
	return frequency;
    }

}