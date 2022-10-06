package edu.greenriver.sdev.swjokesapi.controllers;

import edu.greenriver.sdev.swjokesapi.model.Joke;
import edu.greenriver.sdev.swjokesapi.model.Query;
import edu.greenriver.sdev.swjokesapi.service.JokesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Joke>> allJokes()
    {
        //return the response using a constructor
        return new ResponseEntity<>(service.allJokes(), HttpStatus.OK);
    }

    // how do we get inputs through a request
    // **************************************

    @GetMapping("query")
    public ResponseEntity<Object> filterJokes(@RequestBody Query query)
    {
        //we won't allow this end-point to be used with an empty query
        if (query.getQueryValue() == null || query.getQueryValue().isEmpty())
        {
            return new ResponseEntity<>("The query string cannot be empty/null", HttpStatus.BAD_REQUEST);
        }

        //an alternative using factory methods
        return ResponseEntity.ok(service.searchJokes(query.getQueryValue()));
    }

    // **************************************

    //POST request to http://localhost:8080/api/v1/joke
    @PostMapping("")
    public ResponseEntity<Object> addAJoke(@RequestBody Joke tempJoke)
    {
        //don't add an empty joke
        if (tempJoke.getJokeText() == null || tempJoke.getJokeText().isEmpty())
        {
            return new ResponseEntity<>("The joke text cannot be empty/null", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(service.addJoke(tempJoke.getJokeText()), HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Object> editAJoke(@RequestBody Joke tempJoke)
    {
        //make sure the id of the joke is found
        if (!service.jokeExists(tempJoke.getId()))
        {
            return new ResponseEntity<>("Joke does not exist!", HttpStatus.NOT_FOUND);
        }
        //don't add an empty joke
        else if (tempJoke.getJokeText() == null || tempJoke.getJokeText().isEmpty())
        {
            return new ResponseEntity<>("The joke text cannot be empty/null", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(service.updateJoke(tempJoke.getId(), tempJoke.getJokeText()), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteJoke(@RequestBody Joke tempJoke)
    {
        // make sure the id of the joke is found
        if (!service.jokeExists(tempJoke.getId()))
        {
            return new ResponseEntity<>("Joke does not exist!", HttpStatus.NOT_FOUND);
        }

        service.deleteJoke(tempJoke.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
