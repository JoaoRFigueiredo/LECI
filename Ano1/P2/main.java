
// MAIN
public class main{
public static void main(String[] args) {

        FmRadioSet.addStationInfo(new RadioStationInfo("TSF", 105.3));
        FmRadioSet.addStationInfo(new RadioStationInfo("Comercial", 97.7));
        FmRadioSet.addStationInfo(new RadioStationInfo("Kiss", 88.8));

        FmRadioSet casio = new FmRadioSet(), 
                pionner = new FmRadioSet(), 
                sony = new FmRadioSet();
        
        casio.tune(97.7);
        casio.turnDownVolume();
        
        pionner.tune("TSF");
        
        sony.tune(casio.currentPlayingStation());
        sony.turnUpVolume();

        System.out.printf( "%s %d\n", casio.currentPlayingStation(), casio.currentVolume());
        System.out.printf( "%s %d\n", pionner.currentPlayingStation(), pionner.currentVolume());
        System.out.printf( "%s %d\n", sony.currentPlayingStation(), sony.currentVolume());

        casio.turnDownVolume();
        casio.tune(pionner.currentPlayingStation());
        System.out.printf( "%s %d\n", casio.currentPlayingStation(), casio.currentVolume());
        System.out.printf( "%s %d\n", pionner.currentPlayingStation(), pionner.currentVolume());
    }
}
