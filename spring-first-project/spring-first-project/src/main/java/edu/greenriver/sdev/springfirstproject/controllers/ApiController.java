package edu.greenriver.sdev.springfirstproject.controllers;

import edu.greenriver.sdev.springfirstproject.models.Candy;
import edu.greenriver.sdev.springfirstproject.services.CandyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//tell spring to register our rest controller as a spring bean
//this makes our class a RESTful api (controller)
@RestController
public class ApiController
{
    //the service is injected by the spring context (DI - dependency injection)
    private CandyService service;

    public ApiController(CandyService service)
    {
        this.service = service;
    }

    //http://localhost:8081/candies
    @GetMapping("candies")
    public List<Candy> getAllCandies()
    {
        return service.getAllCandy();
    }

    //http://localhost:8081/candies/expensive
    @GetMapping("candies/expensive")
    public List<Candy> getExpensiveCandy()
    {
        return service.getExpensiveCandy();
    }

    //http://localhost:8081/candies/favorite
    @GetMapping("candies/favorite")
    public Candy getFavoriteCandy()
    {
        return service.getFavorite();
    }

    //http://localhost:8081/candies/morethan/3.00
    @GetMapping("candies/morethan/{price}")
    public List<Candy> getMoreThan(@PathVariable double price)
    {
        return service.getMoreExpensiveThan(price);
    }
}
