package fr.MatDemons.Contagion.utile;


import org.bukkit.Material;

public class Weapon {
    private org.bukkit.Material mat;
    private Double Dommage;
    private Double vitesse;
    private Double cooldownInMillis;
    private Double weight;
    private int ammo;
    private int numberofprojectile;

    public Weapon(org.bukkit.Material mat, double Dommage, double vitesse, double cooldown, double weight,int numberofprojectile, int ammo)
    {
        this.mat = mat;
        this.Dommage = Dommage;
        this.vitesse = vitesse;
        this.cooldownInMillis = cooldown;
        this.weight = weight;
        this.numberofprojectile = numberofprojectile;
        this.ammo = ammo;
    }

    public Material getMat(){
        return this.mat;
    }

    public Double getDommage(){
        return this.vitesse;
    }

    public  Material getMaterial(){
        return this.mat;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getnumberofprojectile(){
        return this.numberofprojectile;
    }

    public double getCooldownInMillis(){ return this.cooldownInMillis;}

    public Integer getAmmo() {
        return this.ammo;
    }
}
