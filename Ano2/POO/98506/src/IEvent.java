import java.time.LocalDate;

public interface IEvent {
    Event addActivity(Activity activity); //return de event?
    LocalDate getDate();
    double getTotalCost();
}
