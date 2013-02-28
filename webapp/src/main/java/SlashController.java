package com.jeremyr.sw.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/slash")
public class SlashController {

        @RequestMapping(method = RequestMethod.GET)
        public String hello(ModelMap model) {

                model.addAttribute("message", "Hey there. How's it going, slash?");

                // this is somehow the name of the jsp file without the jsp
                return "slash";

        }
}

