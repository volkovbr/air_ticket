package ru.netology.service;

import ru.netology.domaine.Ticket;

import java.util.Comparator;

public class TicketTravelComparator implements Comparator <Ticket>{
    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.getTravelTime() < o2.getTravelTime()) {
            return -1;
        } else if (o1.getTravelTime() > o2.getTravelTime()) {
            return 1;
        } else {
            return 0;
        }
    }
}