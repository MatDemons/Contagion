package fr.MatDemons.Contagion.utile;

        import org.bukkit.Material;

        import java.util.HashMap;

public class WeaponManager {

    public static HashMap<Material, Weapon> bloodyArmes = new HashMap<>();

    static {
        bloodyArmes.put(Material.DIAMOND_AXE,new Weapon(Material.DIAMOND_AXE, 50, 10, 750,5,15,4));
        bloodyArmes.put(Material.GOLD_AXE,new Weapon(Material.GOLD_AXE, 45, 10, 750,4,15,4));
        bloodyArmes.put(Material.IRON_AXE,new Weapon(Material.IRON_AXE, 40, 10, 750,3,15,4));
        bloodyArmes.put(Material.STONE_AXE,new Weapon(Material.STONE_AXE, 35, 10, 750,2,15,4));
        bloodyArmes.put(Material.WOOD_AXE,new Weapon(Material.WOOD_AXE, 30, 10, 750,1,15,4));

        bloodyArmes.put(Material.DIAMOND_HOE,new Weapon(Material.DIAMOND_HOE, 50, 10, 50,5,1,35));
        bloodyArmes.put(Material.GOLD_HOE,new Weapon(Material.GOLD_HOE, 45, 10, 50,4,1,35));
        bloodyArmes.put(Material.IRON_HOE,new Weapon(Material.IRON_HOE, 40, 10, 50,3,1,35));
        bloodyArmes.put(Material.STONE_HOE,new Weapon(Material.STONE_HOE, 35, 10, 50,2,1,35));
        bloodyArmes.put(Material.WOOD_HOE,new Weapon(Material.WOOD_HOE, 30, 10, 50,1,1,35));

        bloodyArmes.put(Material.DIAMOND_PICKAXE,new Weapon(Material.DIAMOND_PICKAXE, 100, 10, 1000,5,1,10));
        bloodyArmes.put(Material.GOLD_PICKAXE,new Weapon(Material.GOLD_PICKAXE, 80, 10, 1000,4,1,10));
        bloodyArmes.put(Material.IRON_PICKAXE,new Weapon(Material.IRON_PICKAXE, 60, 10, 1000,3,1,10));
        bloodyArmes.put(Material.STONE_PICKAXE,new Weapon(Material.STONE_PICKAXE, 40, 10, 1000,2,1,10));
        bloodyArmes.put(Material.WOOD_PICKAXE,new Weapon(Material.WOOD_PICKAXE, 20, 10, 1000,1,1,10));

        bloodyArmes.put(Material.DIAMOND_SPADE,new Weapon(Material.DIAMOND_SPADE, 50, 10, 250,5,1,16));
        bloodyArmes.put(Material.GOLD_SPADE,new Weapon(Material.GOLD_SPADE, 45, 10, 250,4,1,16));
        bloodyArmes.put(Material.IRON_SPADE,new Weapon(Material.IRON_SPADE, 40, 10, 250,3,1,16));
        bloodyArmes.put(Material.STONE_SPADE,new Weapon(Material.STONE_SPADE, 35, 10, 250,2,1,16));
        bloodyArmes.put(Material.WOOD_SPADE,new Weapon(Material.WOOD_SPADE, 30, 10, 250,1,1,16));

        bloodyArmes.put(Material.DIAMOND_SWORD,new Weapon(Material.DIAMOND_SWORD, 60, 10, 0,5,0,0));
        bloodyArmes.put(Material.GOLD_SWORD,new Weapon(Material.GOLD_SWORD, 50, 10, 0,4,0,0));
        bloodyArmes.put(Material.IRON_SWORD,new Weapon(Material.IRON_SWORD, 40, 10, 0,3,0,0));
        bloodyArmes.put(Material.STONE_SWORD,new Weapon(Material.STONE_SWORD, 35, 10, 0,2,0,0));
        bloodyArmes.put(Material.WOOD_SWORD,new Weapon(Material.WOOD_SWORD, 30, 10, 0,1,0,0));
    }

    public static double getDamage(Material mat) {
        return bloodyArmes.get(mat).getDommage();
    }

    public static WeaponType getType(Material mat) {
        for(WeaponType type : WeaponType.values()) {
            if (mat.toString().substring(mat.toString().indexOf("_")+1).equals(type.name())) {
                return type;
            }
        }
        return null;
    }
}
