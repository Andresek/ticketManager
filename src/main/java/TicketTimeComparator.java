
import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int timeOfFlightFirst = t1.getTimeTo() - t1.getTimeFrom();
        int timeOfFlightSecond = t2.getTimeTo() - t2.getTimeFrom();

        if (timeOfFlightFirst < timeOfFlightSecond) {
            return -1;
        } else if (timeOfFlightFirst > timeOfFlightSecond) {
            return 1;
        } else {
            return 0;
        }
    }
}