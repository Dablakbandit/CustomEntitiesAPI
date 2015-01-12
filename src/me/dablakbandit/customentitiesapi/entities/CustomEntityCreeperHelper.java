package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityCreeperHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object creeper) {
		removeGoalSelectorPathfinderGoalAll(creeper);
	}

	public static void setAbleToMove(Object creeper) {
		newGoalSelectorPathfinderGoalRandomStroll(creeper, 0.8D);
	}

	public static void setAbleToMove(Object creeper, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(creeper, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object creeper) {
		newGoalSelectorPathfinderGoalFloat(creeper);
		newGoalSelectorPathfinderGoalSwell(creeper);
		newGoalSelectorPathfinderGoalAvoidPlayer(creeper, "EntityOcelot", 6.0F, 1.0D, 1.2D);
		newGoalSelectorPathfinderGoalMeleeAttack(creeper, 1.0D, false);
		newGoalSelectorPathfinderGoalRandomStroll(creeper, 0.8D);
		newGoalSelectorPathfinderGoalLookAtPlayer(creeper, "EntityHuman", 8.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(creeper);
	}
	
	public static void newGoalSelectorPathfinderGoalSwell(Object creeper){
		try {
			Class<?> entitycreeper = getNMSClass("EntityCreeper");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(creeper);

			Class<?> pathfindergoalswell= getNMSClass("PathfinderGoalSwell");
			Object o = pathfindergoalswell.getConstructor(entitycreeper).newInstance(entitycreeper.cast(creeper));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 2, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
