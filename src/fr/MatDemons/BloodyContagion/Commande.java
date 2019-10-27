package fr.MatDemons.Contagion;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commande implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args){

        if(sender instanceof Player){
            Player p = (Player)sender;

            if(cmd.getName().equalsIgnoreCase("Bloodycontagion")){
                if(args.length == 0) {
                    p.performCommand("help contagion");
                }
                else{
                    String message = "";
                    switch(args[0]){
                        case "1":
                            p.performCommand("help contagion ");
                            break;
                        case "2":
                            p.performCommand("help contagion 2");
                            break;
                        case "start":
                            message = "comment on commence un contagion";
                            break;
                        case "stop":
                            message = "comment on arrete un contagion";
                            break;
                        case"create":
                            message = "comment on create un contagion";
                            break;
                        case "remove":
                            message = "comment on surprime un contagion";
                            break;
                        case "sethumain":
                            message = "comment on met la region de spawn des humain";
                            break;
                        case"setcoffre":
                            message = "comment on met un coffre de niveau";
                            break;
                        case"setlobby":
                            message = "comment on met le lobby";
                            break;
                    }
                    p.sendMessage(ChatColor.AQUA + message);
                }
            }
        }

        return false;
    }
}
