package net.ssmc.customentitiesapi.entities;

import java.lang.reflect.Field;

public class CustomEntityZombieHelper extends CustomEntityMonsterHelper{

	public static void setUnableToMove(Object zombie){
		removeGoalSelectorPathfinderGoalAll(zombie);
	}

	public static void setAbleToMove(Object zombie){
		newGoalSelectorPathfinderGoalRandomStroll(zombie, 1D);
	}

	public static void setAbleToMove(Object zombie, double d){
		newGoalSelectorPathfinderGoalRandomStroll(zombie, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object zombie){
		newGoalSelectorPathfinderGoalFloat(zombie);
		newGoalSelectorPathfinderGoalBreakDoor(zombie);
		newGoalSelectorPathfinderGoalMeleeAttack(zombie, "EntityHuman", 1.0D, false);
		try{
			Field world = zombie.getClass().getField("world");
			Object world1 = world.get(zombie);
			Field config = world1.getClass().getDeclaredField("spigotConfig");
			Object config1 = config.get(world1);
			Field f = config1.getClass().getField("zombieAggressiveTowardsVillager");
			Object value = f.get(config1);
			if((boolean)value){
				newGoalSelectorPathfinderGoalMeleeAttack(zombie, "EntityVillager", 1.0D, true);
			}
		}catch(Exception e){
			newGoalSelectorPathfinderGoalMeleeAttack(zombie, "EntityVillager", 1.0D, true);
		}
		newGoalSelectorPathfinderGoalMoveTowardsRestriction(zombie, 1.0D);
		newGoalSelectorPathfinderGoalMoveThroughVillage(zombie, 1.0D, true);
		newGoalSelectorPathfinderGoalRandomStroll(zombie, 0);
		newGoalSelectorPathfinderGoalLookAtPlayer(zombie, 8.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(zombie);
	}
	
}