package edu.greenriver.sdev.springfirstproject.services;

import edu.greenriver.sdev.springfirstproject.models.Candy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//tell spring to register our service as a spring bean
@Service
public class CandyService
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

    public List<Candy> getAllCandy()
    {
        return candies;
    }

    //return all candy more than $2.50
    public List<Candy> getExpensiveCandy()
    {
        return candies
            .stream()
            .filter(candy -> candy.getCost() >= 2.50)
            .toList();
    }

    public List<Candy> getMoreExpensiveThan(double min)
    {
        return candies
            .stream()
            .filter(candy -> candy.getCost() >= min)
            .toList();
    }

    public Candy getFavorite()
    {
        return candies.get(0);
    }
}
