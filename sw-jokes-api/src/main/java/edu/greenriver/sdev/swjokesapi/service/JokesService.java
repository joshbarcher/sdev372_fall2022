package edu.greenriver.sdev.swjokesapi.service;

import edu.greenriver.sdev.swjokesapi.model.Joke;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JokesService
{
    private List<Joke> jokes = new ArrayList<>(List.of(
        new Joke("What did Han Solo say to the waiter who recommended the haddock? Never sell me the cods!"),
        new Joke("Why didn’t any of Luke Skywalker’s marriages last? He always followed Obi-Wan’s advice: " +
                 "'Use divorce, Luke.'"),
        new Joke("What was Lando’s nickname before he became a skilled pilot? Crashdo."),
        new Joke("Why does Princess Leia keep her hair tied up in buns? So it doesn’t Hang Solow."),
        new Joke("What is Admiral Ackbar's favorite type of music? Trap."),
        new Joke("What do you call a rebel princess who only shops at Whole Foods? Leia Organic."),
        new Joke("What do you call an eel that loves the new Star Wars trilogy? A More-Rey Eel."),
        new Joke("Where did Luke get his cybernetic hand? The second hand store.")
    ));

    //CREATE
    public Joke addJoke(String jokeText)
    {
        Joke added = new Joke(jokeText);
        jokes.add(added);
        return added;
    }

    //READ
    public List<Joke> allJokes()
    {
        return jokes;
    }

    //UPDATE
    public Joke updateJoke(UUID id, String newJokeText)
    {
        Optional<Joke> foundJoke = jokes.stream()
            .filter(joke -> joke.getId().equals(id))
            .findFirst();

        if (foundJoke.isPresent())
        {
            //update it
            Joke joke = foundJoke.get();
            joke.setJokeText(newJokeText);
            return joke;
        }
        else
        {
            //otherwise, return null
            return null;
        }
    }

    //DELETE
    public void deleteJoke(UUID id)
    {
        jokes.stream()
            .filter(joke -> !joke.getId().equals(id))
            .toList();
    }
}
