package edu.greenriver.sdev.springfirstproject.models;

public class Candy
{
    private String type;
    private double cost;

    public Candy(String type, double cost)
    {
        this.type = type;
        this.cost = cost;
    }

    public String getType()
    {
        return type;
    }

    public double getCost()
    {
        return cost;
    }

    @Override
    public String toString()
    {
        return "Candy{" +
                "type='" + type + '\'' +
                ", cost=" + cost +
                '}';
    }
}
