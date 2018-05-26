package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Assessment extends Model
{
    public double weight;
    public double chest;
    public double thigh;
    public double upperarm;
    public double waist;
    public double hips;

    public Assessment(double weight, double chest, double thigh, double upperarm, double waist, double hips)
    {
        this.weight = weight;
        this.chest = chest;
        this.thigh = thigh;
        this.upperarm = upperarm;
        this.waist = waist;
        this.hips = hips;
    }
}

