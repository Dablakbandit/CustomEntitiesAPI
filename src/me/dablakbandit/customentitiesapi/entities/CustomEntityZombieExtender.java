package me.dablakbandit.customentitiesapi.entities;

import java.lang.reflect.Field;

public abstract class CustomEntityZombieExtender extends CustomEntityMonster {

	public CustomEntityZombieExtender(String name) {
		super(name);
	}
	
	public void setGoalSelectorDefaultPathfinderGoals() {
		try {
			helper.getMethod("setGoalSelectorDefaultPathfinderGoals",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalMeleeAttackDefault() {
		try {
			try {
				Field f = entity.getClass().getField("world");
				Object world = f.get(entity);
				Field config = world.getClass()
						.getDeclaredField("spigotConfig");
				Object config1 = config.get(world);
				Field f1 = config1.getClass().getField(
						"zombieAggressiveTowardsVillager");
				Object value = f1.get(config1);
				if ((boolean) value) {
					newGoalSelectorPathfinderGoalMeleeAttack(1.0D, true);
				}
			} catch (Exception e) {
				newGoalSelectorPathfinderGoalMeleeAttack(1.0D, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalMoveTowardsRestrictionDefault() {
		newGoalSelectorPathfinderGoalMoveTowardsRestriction(1.0D);
	}

	public void newGoalSelectorPathfinderGoalMoveThroughVillageDefault() {
		newGoalSelectorPathfinderGoalMoveThroughVillage(1.0D, false);
	}

	public void newGoalSelectorPathfinderGoalRandomStrollDefault() {
		newGoalSelectorPathfinderGoalRandomStroll(1.0D);
	}

	public void newGoalSelectorPathfinderGoalLookAtPlayerDefault() {
		newGoalSelectorPathfinderGoalLookAtPlayer(8.0F);
	}
}
