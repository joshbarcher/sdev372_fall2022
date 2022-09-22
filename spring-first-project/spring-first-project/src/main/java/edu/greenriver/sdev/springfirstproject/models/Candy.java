package edu.greenriver.sdev.springfirstproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candy
{
    private String type;
    private double cost;
}
