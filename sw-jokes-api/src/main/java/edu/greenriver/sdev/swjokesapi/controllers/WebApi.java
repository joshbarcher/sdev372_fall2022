package edu.greenriver.sdev.swjokesapi.controllers;

import edu.greenriver.sdev.swjokesapi.model.Joke;
import edu.greenriver.sdev.swjokesapi.service.JokesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    This adds two annotations:
    - @Controller: to respond to HTTP requests
    - @ResponseBody: to return data from each method, not HTML page names
 */
@RestController
@RequestMapping("api/v1/joke")
public class WebApi
{
    private JokesService service;

    public WebApi(JokesService service)
    {
        this.service = service;
    }

    //GET request to http://localhost:8080/api/v1/joke
    @GetMapping("")
    public List<Joke> allJokes()
    {
        return service.allJokes();
    }

    //POST request to http://localhost:8080/api/v1/joke
    @PostMapping("")
    public Joke addAJoke(@RequestBody Joke tempJoke)
    {
        return service.addJoke(tempJoke.getJokeText());
    }

    @PutMapping("")
    public Joke editAJoke()
    {
        return null;
    }

    @DeleteMapping("")
    public void deleteAJoke()
    {

    }
}
