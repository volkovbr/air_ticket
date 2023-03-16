package ru.netology.manager;

import ru.netology.domaine.Ticket;
import ru.netology.repository.RepositoryTicket;

import java.util.Arrays;

public class ManagerTicket {
    private RepositoryTicket repo;

    public ManagerTicket(RepositoryTicket repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] find(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
