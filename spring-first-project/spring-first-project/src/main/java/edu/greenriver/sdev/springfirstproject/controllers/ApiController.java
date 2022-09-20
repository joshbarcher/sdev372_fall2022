package edu.greenriver.sdev.springfirstproject.controllers;

import edu.greenriver.sdev.springfirstproject.models.Candy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//this makes our class a RESTful api (controller)
@RestController
public class ApiController
{
    private List<Candy> candies = List.of(
        new Candy("Reese Cups", 3.99),
        new Candy("Skittles", 1.99),
        new Candy("Twix", 2.99),
        new Candy("Kit Kat", 3.99),
        new Candy("Gummy Bears", 2.49),
        new Candy("Laffy Taffy", 3.19),
        new Candy("Kinder Buenos", 5.99)
    );

    //http://localhost:8081/candies
    @GetMapping("candies")
    public List<Candy> getAllCandies()
    {
        return candies;
    }
}
