package com.rusya.guestBook.service;

import com.rusya.guestBook.dto.GuestDTO;

import java.util.List;


public interface GuestService {
    public void save(GuestDTO guestDTO);
    public List<GuestDTO> showAll();

}
