import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Berlin", "London", 1900, 9, 11);
    Ticket ticket2 = new Ticket("Berlin", "London", 2000, 17, 20);
    Ticket ticket3 = new Ticket("Tokio", "Berlin", 12000, 10, 20);
    Ticket ticket4 = new Ticket("Berlin", "London", 1800, 12, 13);
    Ticket ticket5 = new Ticket("Valencia", "Torino", 4400, 2, 4);

    @Test
    public void compareToWhenFirstTicketLessSecondTicket() {

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void compareToWhenSecondTicketOverFirstTicket() {

        int expected = 1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void searchWhenFoundSomeTickets() {

        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] expected = {ticket4, ticket1, ticket2};
        Ticket[] actual = repo.search("Berlin", "London");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void searchWhenFoundOneTicket() {

        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] expected = {ticket5};
        Ticket[] actual = repo.search("Valencia", "Torino");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void searchWhenFoundZeroTicket() {

        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = repo.search("london", "Torino");

        Assertions.assertArrayEquals(expected, actual);

    }



    @Test
    public void compareWhenFlightTimeFifthTicketLessThirdTicket() {

        AviaSouls repo = new AviaSouls();

        repo.add(ticket3);
        repo.add(ticket5);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = -1;
        int actual = timeComparator.compare(ticket5, ticket3);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void compareWhenFlightTimeEqually() {

        AviaSouls repo = new AviaSouls();

        repo.add(ticket5);
        repo.add(ticket1);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = 0;
        int actual = timeComparator.compare(ticket5, ticket1);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void compareWhenFlightTimeThirdTicketOverFirstTicket() {

        AviaSouls repo = new AviaSouls();

        repo.add(ticket3);
        repo.add(ticket1);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = 1;
        int actual = timeComparator.compare(ticket3, ticket1);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchAndSortByWhenFoundSomeTickets() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Comparator<Ticket> comp = new TicketTimeComparator();


        Ticket[] expected = {ticket4, ticket1, ticket2};
        Ticket[] actual = repo.searchAndSortBy("Berlin", "London", comp);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchAndSortByWhenFoundOneTicket() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Comparator<Ticket> comp = new TicketTimeComparator();


        Ticket[] expected = {ticket5};
        Ticket[] actual = repo.searchAndSortBy("Valencia", "Torino", comp);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchAndSortByWhenFoundZeroTicket() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Comparator<Ticket> comp = new TicketTimeComparator();


        Ticket[] expected = {};
        Ticket[] actual = repo.searchAndSortBy("Valencia", "Berlin", comp);

        Assertions.assertArrayEquals(expected, actual);

    }



}
