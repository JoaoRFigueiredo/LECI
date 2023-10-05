<<<<<<< HEAD
// package lab03;
=======
//package lab03;
>>>>>>> 0031b8c6947045583c7ba859f34c76b0a7aca4bd

public class Aviao {
    
    private int[][] touristic;
    private int[][] executive;
    private int touristic_seats;
    private int executive_seats;


    public Aviao(String touristicD) {
        this.touristic = valDimensions(touristicD);
        this.touristic_seats = touristic.length * touristic[0].length;
    }

    public Aviao(String executiveD, String touristicD) {
        this.touristic = valDimensions(touristicD);
        this.executive = valDimensions(executiveD);
        this.touristic_seats = touristic.length * touristic[0].length;
        this.executive_seats = executive.length * executive[0].length;
    }
    public int getTouristic_seats() {
        return touristic_seats;
    }

    public void setTouristic_seats(int touristic_seats) {
        this.touristic_seats = touristic_seats;
    }

    public int getExecutive_seats() {
        return executive_seats;
    }

    public void setExecutive_seats(int executive_seats) {
        this.executive_seats = executive_seats;
    }


    // Validates the dimensions (row x columns) and creates the seat array
    public int[][] valDimensions(String dimString) {
        String[] temp = dimString.split("x");
        int[][] seats = new int[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])];

        return seats;
    }

    public int[][] getTouristic() {
        return touristic;
    }

    public int[][] getExecutive() {
        return executive;
    }
}
