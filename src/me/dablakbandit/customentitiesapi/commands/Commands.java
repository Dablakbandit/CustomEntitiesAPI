package me.dablakbandit.customentitiesapi.commands;

import me.dablakbandit.customentitiesapi.entities.*;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String Label, String[] args) {
		if(s instanceof Player){			
			/*Skeleton s1 = (Skeleton) Bukkit.getWorlds().get(0).spawnEntity(((Player)s).getLocation(), EntityType.SKELETON);
			s1.getEquipment().setItemInHand(new ItemStack(Material.BOW));
			CustomEntitySkeleton s2 = CustomEntities.getCustomEntitySkeleton(s1);
			s2.removeGoalSelectorPathfinderGoalAll();
			s2.setGoalSelectorDefaultPathfinderGoals();
			s2.setDamageable(false);*/
			//Player player = (Player)s;
			CustomEntityVillager cev = CustomEntities.getNewCustomEntityVillager(((Player)s).getLocation());
			cev.setUntradeable();
			cev.setUnableToMove();
			cev.setUndamageable();
			cev.setUnpushable();
			cev.newGoalSelectorPathfinderGoalInteract(EntityName.ENTITYHUMAN, 3.0F, 1.0F);
			s.sendMessage("" + cev.getIAttribute(CustomIAttribute.MAX_HEALTH));
		}
		return false;
	}

}
