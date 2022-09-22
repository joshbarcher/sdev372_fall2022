package edu.greenriver.sdev.springfirstproject.controllers;

import edu.greenriver.sdev.springfirstproject.services.CandyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController
{
    //use dependency injection to acces our service
    private CandyService service;

    public WebController(CandyService service)
    {
        this.service = service;
    }

    //the methods below will define a route to a page

    //http://localhost:8081/home
    @GetMapping("home")
    public String getHomepage()
    {
        //the name of the view (in the templates directory)
        return "home_page";
    }

    //http://localhost:8081/favorite
    @GetMapping("favorite")
    public String getFavoriteCandy(Model model)
    {
        model.addAttribute("title", "My Favorite Candy");
        model.addAttribute("favorite", service.getFavorite());
        return "favorite_candy";
    }
}
