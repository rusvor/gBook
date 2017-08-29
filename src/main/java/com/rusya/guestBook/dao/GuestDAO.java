package com.rusya.guestBook.dao;

import com.rusya.guestBook.entity.Guest;

import java.util.List;


public interface GuestDAO {
    public int save(Guest guest);
    public List<Guest> showAll();
}
