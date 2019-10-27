package fr.MatDemons.Contagion.Scoreboard;

import fr.MatDemons.Contagion.Contagion;
import fr.MatDemons.Contagion.Events.PlayerJoin;
import fr.MatDemons.Contagion.game.ContagionATTEND;
import fr.MatDemons.Contagion.game.ContagionFIN;
import fr.MatDemons.Contagion.game.ContagionGAME;
import fr.MatDemons.Contagion.game.ContagionState;
import fr.MatDemons.Contagion.utile.BloodyPlayer;
import fr.MatDemons.Contagion.utile.BloodyPlayerList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static fr.MatDemons.Contagion.game.ContagionState.ATTEND;

public class ScoreBoardDisplayer {
	private static int time = 0;

	/**
	 * Initialise un scheduler qui va renvoyer tout les 5 tick le scoreBoard
	 * un seul scoreboard est généré puis donné a tout les joueurs
	 * Si on veut afficher des vars propres a chaque joueurs, il faut générer un
	 * scoreboard par players
	 */
	public static void initialize() {
		new BukkitRunnable() {

			@Override
			public void run() {
				refreshValuesBeforeDisplay();
				for (Player p : Bukkit.getOnlinePlayers()) {
					updateScoreBoard(p);
				}
			}
		}.runTaskTimer(Contagion.getInstance(), 0, 5);
	}

	private static void refreshValuesBeforeDisplay() {
		switch (ContagionState.getState()) {
			case ATTEND:
				time = ContagionATTEND.getTimer();
				break;
			case GAME:
				time = ContagionGAME.getTimer();
				break;
			case FIN:
				time = ContagionFIN.getTimer();
				break;
		}
	}

	public static void updateScoreBoard(Player p) {
		if (ContagionState.getState() == ATTEND) {
			updateScoreBoardWaiting(p);
		}
		else if(ContagionState.getState() == ContagionState.GAME) {
			updateScoreBoardInGame(p);
		}else{
			updateScoreBoardInFin(p);
		};
	}
	
	/**
	 * Scoreboard pour la phase de lobby wait
	 */
	public static void updateScoreBoardWaiting(Player p) {
		int playerCount = Bukkit.getOnlinePlayers().size();
		int slots = Bukkit.getServer().getMaxPlayers();

		String[] elements = new String[] {
				"  §6§lBloody§f§lBattle§r§o.net  ",
				"",
				"§7Jeu: §rContagion",
				"§7Joueurs: §a" + playerCount + "§7/§f" + slots,
				" ",
				"§7Debut dans: §r" + time + "s",
				"    "
		};
		ScoreboardUtil.unrankedSidebarDisplay(p, elements);
	}
	
	/**
	 * Scoreboard pour la phase IG
	 */
	public static void updateScoreBoardInGame(Player p) {
		int playerCount = Bukkit.getOnlinePlayers().size();
		int playerAlive = BloodyPlayerList.getBloodyPlayerlist().getAlivePlayerCount();
		int kill = BloodyPlayerList.getBloodyPlayerlist().getBloodyPlayer(p).getKill();
		String[] elements = new String[] {
				"  §6§lBloody§f§lBattle§r§o.net  ",
				"",
				"§7 Fin dans: §r" + time + "s",
				" ",
				"§7 Survivant §r( "+ playerAlive +"/"+ playerCount +")",
				"  ",
				"§7 Kill = §r" + kill,
				"   "

		};
		ScoreboardUtil.unrankedSidebarDisplay(p, elements);
	}

	public static void updateScoreBoardInFin(Player p) {

		String[] elements = new String[] {
				"  §6§lBloody§f§lBattle§r§o.net  ",
				" ",
				"§7Restart dans: §r" + time + "s",
				"  ",
				" ",
				" ",
				" ",
				" ",
				" "

		};
		ScoreboardUtil.unrankedSidebarDisplay(p, elements);
	}
	
}
