package fr.MatDemons.Contagion.utile;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Skin {

        private static Map<String, String> changedSkins = new HashMap<>();

        public static void changeSkin(Player p, String name) {
            ReflectionUtils.RefClass classCraftPlayer = ReflectionUtils.getRefClass("{cb}.entity.CraftPlayer");
            ReflectionUtils.RefMethod methodGetHandle = classCraftPlayer.getMethod("getHandle");
            ReflectionUtils.RefClass classEntityPlayer = ReflectionUtils.getRefClass("{nms}.EntityPlayer");
            ReflectionUtils.RefField fieldPlayerConnection = classEntityPlayer.getField("playerConnection");
            ReflectionUtils.RefClass classPlayerConnection = ReflectionUtils.getRefClass("{nms}.PlayerConnection");
            ReflectionUtils.RefMethod methodSendPacket = classPlayerConnection.findMethodByName("sendPacket");

            ReflectionUtils.RefClass p29 = ReflectionUtils.getRefClass("{nms}.PacketPlayOutEntityDestroy");

            ReflectionUtils.RefClass p20 = ReflectionUtils.getRefClass("{nms}.PacketPlayOutNamedEntitySpawn");

            ReflectionUtils.RefConstructor pp20 = p20.getConstructor(ReflectionUtils.getRefClass("{nms}.EntityHuman"));

            ReflectionUtils.RefConstructor pp29 = p29.getConstructor(int[].class);

            int[] entityId;

            entityId = new int[1];

            entityId[0] = p.getEntityId();

            Object packetEntityDestroy = pp29.create(entityId);

            Object packetNamedEntitySpawn = pp20.create((ReflectionUtils.getRefClass("{cb}.entity.CraftPlayer")).getMethod("getHandle").of(p).call());

            ReflectionUtils.RefField f = p20.getField("b");

            ReflectionUtils.RefClass gp = ReflectionUtils.getRefClass("{nm}.util.com.mojang.authlib.GameProfile");

            ReflectionUtils.RefConstructor rc = gp.getConstructor(String.class, String.class); // String constructor

            Object gameProfile = rc.create(String.valueOf(p.getUniqueId()), p.getName()); // String constructor

            f.of(packetNamedEntitySpawn).set(gameProfile);

            changedSkins.put(p.getName(), name);

            p.setDisplayName(name);
            p.setPlayerListName(name);

            for (Player player : Bukkit.getOnlinePlayers()) {

                if(player != p) {
                    Object handle = methodGetHandle.of(player).call();
                    Object connection = fieldPlayerConnection.of(handle).get();

                    methodSendPacket.of(connection).call(packetEntityDestroy);
                    methodSendPacket.of(connection).call(packetNamedEntitySpawn);
                }
            }
        }

        public static void removeSkin(Player p) {
            ReflectionUtils.RefClass classCraftPlayer = ReflectionUtils.getRefClass("{cb}.entity.CraftPlayer");
            ReflectionUtils.RefMethod methodGetHandle = classCraftPlayer.getMethod("getHandle");
            ReflectionUtils.RefClass classEntityPlayer = ReflectionUtils.getRefClass("{nms}.EntityPlayer");
            ReflectionUtils.RefField fieldPlayerConnection = classEntityPlayer.getField("playerConnection");
            ReflectionUtils.RefClass classPlayerConnection = ReflectionUtils.getRefClass("{nms}.PlayerConnection");
            ReflectionUtils.RefMethod methodSendPacket = classPlayerConnection.findMethodByName("sendPacket");

            ReflectionUtils.RefClass p29 = ReflectionUtils.getRefClass("{nms}.PacketPlayOutEntityDestroy");

            ReflectionUtils.RefClass p20 = ReflectionUtils.getRefClass("{nms}.PacketPlayOutNamedEntitySpawn");

            ReflectionUtils.RefConstructor pp20 = p20.getConstructor(ReflectionUtils.getRefClass("{nms}.EntityHuman"));

            ReflectionUtils.RefConstructor pp29 = p29.getConstructor(int[].class);

            int[] entityId;

            entityId = new int[1];

            entityId[0] = p.getEntityId();

            Object packetEntityDestroy = pp29.create(entityId);

            Object packetNamedEntitySpawn = pp20.create((ReflectionUtils.getRefClass("{cb}.entity.CraftPlayer")).getMethod("getHandle").of(p).call());

            ReflectionUtils.RefField f = p20.getField("b");

            ReflectionUtils.RefClass gp = ReflectionUtils.getRefClass("{nm}.util.com.mojang.authlib.GameProfile");

            ReflectionUtils.RefConstructor rc = gp.getConstructor(String.class, String.class); // String constructor

            Object gameProfile = rc.create(String.valueOf(p.getUniqueId()), p.getName()); // String constructor

            f.of(packetNamedEntitySpawn).set(gameProfile);

            changedSkins.remove(p.getName());

            p.setDisplayName(p.getName());
            p.setPlayerListName(p.getName());

            for (Player player : Bukkit.getOnlinePlayers()) {

                if(player != p) {
                    Object handle = methodGetHandle.of(player).call();
                    Object connection = fieldPlayerConnection.of(handle).get();

                    methodSendPacket.of(connection).call(packetEntityDestroy);
                    methodSendPacket.of(connection).call(packetNamedEntitySpawn);
                }
            }
        }

    public static String getNewPlayerName(Player p) {
        if(changedSkins.containsKey(p.getName())) {
            return changedSkins.get(p.getName());
        }
        return null;
    }

    public static String getOldPlayerName(String name) {
        for(Map.Entry<String, String> entry : changedSkins.entrySet()) {
            if(entry.getValue().equals(name)) {
                return entry.getKey();
            }
        }
        return null;
    }
        //Quand faut rajouter
        //changeSkin(e.getPlayer(), getNewPlayerName(e.getPlayer()));

    //Quand faut enlever
      //  Player p = e.getPlayer();
      //  if (isDisguised(p)) {
      //      removeSkin(p);
      //  }

    public static boolean isDisguised(Player p) {
        return changedSkins.containsKey(p.getName());
    }
    }
