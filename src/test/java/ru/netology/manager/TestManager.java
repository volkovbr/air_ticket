package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domaine.Ticket;
import ru.netology.repository.RepositoryTicket;

public class TestManager {
    public RepositoryTicket repo = new RepositoryTicket();
    public ManagerTicket man = new ManagerTicket(repo);

    Ticket ticket1 = new Ticket(1, 2000, "AAAA", "BBBB", 75);
    Ticket ticket2 = new Ticket(2, 1000, "AAAA", "BBBB", 60);
    Ticket ticket3 = new Ticket(3, 5000, "DDDD", "CCCC", 300);
    Ticket ticket4 = new Ticket(4, 1100, "BBBB", "AAAA", 120);
    Ticket ticket5 = new Ticket(5, 3000, "AAAA", "BBBB", 90);
    Ticket ticket6 = new Ticket(6, 700, "AAAA", "BBBB", 120);
    Ticket ticket7 = new Ticket(7, 1500, "DDDD", "CCCC", 300);
    Ticket ticket8 = new Ticket(8, 1800, "DDDD", "TTTT", 120);
    Ticket ticket9 = new Ticket(9, 700, "AAAA", "BBBB", 60);

    @Test
    public void testAdd() {
        man.add(ticket1);
        man.add(ticket2);
        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.getTickets();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicket() {
        man.add(ticket1);
        man.add(ticket2);
        man.add(ticket3);
        man.add(ticket4);
        man.add(ticket5);
        man.add(ticket6);
        man.add(ticket7);
        man.add(ticket8);
        man.add(ticket9);
        Ticket[] expected = {ticket2,ticket9, ticket1, ticket5, ticket6};
        Ticket[] actual = man.find("AAAA", "BBBB");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindZeroTicket() {
        man.add(ticket1);
        man.add(ticket2);
        man.add(ticket3);
        man.add(ticket4);
        man.add(ticket5);
        man.add(ticket6);
        man.add(ticket7);
        man.add(ticket8);
        Ticket[] expected = {};
        Ticket[] actual = man.find("AAAA", "CCCC");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindOneTicket() {
        man.add(ticket1);
        man.add(ticket2);
        man.add(ticket3);
        man.add(ticket4);
        man.add(ticket5);
        man.add(ticket6);
        man.add(ticket7);
        man.add(ticket8);
        Ticket[] expected = {ticket4};
        Ticket[] actual = man.find("BBBB", "AAAA");
        Assertions.assertArrayEquals(expected, actual);
    }

}
