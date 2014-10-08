package net.ssmc.customentitiesapi.commands;

import net.ssmc.customentitiesapi.NMSUtils;
import net.ssmc.customentitiesapi.entities.*;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

public class Commands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String Label, String[] args) {
		if(s instanceof Player){
			IronGolem ig = (IronGolem) Bukkit.getWorlds().get(0).spawnEntity(((Player)s).getLocation(), EntityType.IRON_GOLEM);
			CustomEntities.getCustomEntityIronGolem(ig);
		}
		return false;
	}

}
