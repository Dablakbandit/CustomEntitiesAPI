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
			CustomEntitySheep ces = CustomEntities.getNewCustomEntitySheep(((Player)s).getLocation());
            ces.removeGoalSelectorPathfinderGoalAll();//Clears entities GoalSelector(same as "ces.setUnableToMove();")
            ces.setPushable(false);//Makes the entity unpushable
            ces.newGoalSelectorPathfinderGoalEatTileDefault();//Makes the entity able to eat grass                 
           
            CustomEntityZombie cez = CustomEntities.getNewCustomEntityZombie(((Player)s).getLocation());
            cez.setUnableToMove();//Clears entities GoalSelector(same as "cez.removeGoalSelectorPathfinderGoalAll();")
            cez.setPushable(false);//Makes the entity unpushable
            cez.newGoalSelectorPathfinderGoalMeleeAttack(EntityName.ENTITYHUMAN, 1.0D, false);//Makes the entity attack Players
            cez.newGoalSelectorPathfinderGoalRandomStroll(5.0D);//Makes the entity walk randomly around x5 the speed
		}
		return false;
	}

}
