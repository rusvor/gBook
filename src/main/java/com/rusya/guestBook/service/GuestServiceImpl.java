package com.rusya.guestBook.service;

import com.rusya.guestBook.dao.GuestDAOImpl;
import com.rusya.guestBook.dto.GuestDTO;
import com.rusya.guestBook.entity.Guest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestDAOImpl guestDAO;
    @Override
    public void save(GuestDTO guestDTO) {
        Guest guest = new Guest();
        BeanUtils.copyProperties(guestDTO, guest);
        guestDAO.save(guest);
    }
  /*  @Override
    public void update(GuestDTO guestDTO) {
        Guest guest = new Guest();
        BeanUtils.copyProperties(guestDTO, guest);
        guestDAO.udate(guest);
    }*/
    @Override
    public List<GuestDTO> showAll() {
        List<GuestDTO> guestDtos = new ArrayList<GuestDTO>();
        List<Guest> guests = guestDAO.showAll();
        if(guests != null && !guests.isEmpty())
        {
            for (Guest guest : guests)
            {
                GuestDTO guestDTO = new GuestDTO();
                BeanUtils.copyProperties(guest, guestDTO);
                guestDtos.add(guestDTO);
            }
        }
        return guestDtos;
    }
}
