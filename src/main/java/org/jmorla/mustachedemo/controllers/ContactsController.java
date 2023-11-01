package org.jmorla.mustachedemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactsController {
    

    @GetMapping("/contacts")
    public ModelAndView handleContacts() {
        return new ModelAndView("contacts");
    }
}
