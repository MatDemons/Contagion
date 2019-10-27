package fr.MatDemons.Contagion.utile;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import java.util.Random;

public class ContagionTeleport {

    public static Location Teleportation(Entity e, int Centre_x, int Centre_z, int rayonMin, int rayonMax) {

        Random r = new Random();
        int rayon = rayonMin + r.nextInt( rayonMax - rayonMin);
        int angle = r.nextInt((int) (2*Math.PI) );

        int x = (int) (Centre_x + rayon*Math.cos(angle));
        int y = 255;
        int z = (int) (Centre_z + rayon*Math.sin(angle));
        World world = Bukkit.getWorld("world");

        if(e instanceof Player) {
            e.teleport(LocationHelper.getGroundLocation(new Location(world, x, y+2, z)));
        }
        return(LocationHelper.getGroundLocation(new Location(world,x,y,z)));
    }
}
