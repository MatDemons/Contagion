package fr.MatDemons.Contagion.utile;

import org.bukkit.Location;
import org.bukkit.Material;

public class LocationHelper {
 	public static Location getGroundLocation(Location l) {
        do {
    	    l.subtract(0,1,0);
	 } while (l.getBlock().getType().equals(Material.AIR));
        l.add(0,1,0);
      	return l;
    }
}