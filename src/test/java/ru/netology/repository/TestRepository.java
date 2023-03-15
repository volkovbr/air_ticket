package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domaine.Ticket;
import ru.netology.manager.ManagerTicket;

public class TestRepository {
    public RepositoryTicket repo = new RepositoryTicket();

    Ticket ticket1 = new Ticket(1, 1000, "AAAA", "BBBB", 120);
    Ticket ticket2 = new Ticket(2, 2000, "AAAA", "BBBB", 60);
    Ticket ticket3 = new Ticket(3, 1500, "BBBB", "CCCC", 300);
    Ticket ticket4 = new Ticket(4, 1100, "BBBB", "AAAA", 120);
    Ticket ticket5 = new Ticket();
    Ticket ticket6 = new Ticket();
    Ticket ticket7 = new Ticket();
    Ticket ticket8 = new Ticket();
    Ticket ticket9 = new Ticket();
    Ticket ticket10 = new Ticket();
    Ticket ticket11 = new Ticket();
    Ticket ticket12 = new Ticket();
    Ticket ticket13 = new Ticket();
    Ticket ticket14 = new Ticket();


    @Test
    public void testSave() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.getTickets();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.RemoveById(2);
        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = repo.getTickets();
        Assertions.assertArrayEquals(expected, actual);
    }

}
