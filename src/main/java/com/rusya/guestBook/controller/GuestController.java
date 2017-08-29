package com.rusya.guestBook.controller;

import com.rusya.guestBook.dao.GuestDAO;
import com.rusya.guestBook.dto.GuestDTO;
import com.rusya.guestBook.entity.Guest;
import com.rusya.guestBook.service.GuestService;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class GuestController {
    private List<GuestDTO> guestList = new ArrayList<>();

    @Autowired
    private GuestService guestService;




    @RequestMapping(value = "/listGuest" , method = RequestMethod.GET)
    public ModelAndView listGuest()
    {
        return new ModelAndView("listGuest", "guests",
                guestService.showAll());
    }



    @RequestMapping(value = "/listGuest", method = RequestMethod.POST)
    public String addGuest( GuestDTO guestDTO,  ModelMap map, BindingResult result,
                            Model model, HttpServletRequest httpServletRequest)
    {
        this.guestService.save(guestDTO);
        map.put("listGuest", guestService.showAll() );
        return "listGuest";

    }
    @RequestMapping(value = "/listGuest", method = RequestMethod.GET)
    public String  addGuest(Model model)
    {
        GuestDTO guestDTO = new GuestDTO();
        model.addAttribute("guest", guestDTO);
        return "listGuest";
    }

}
