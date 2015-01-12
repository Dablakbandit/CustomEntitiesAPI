package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityOcelotHelper extends CustomEntityTameableAnimalHelper {

	public static void setUnableToMove(Object ocelot) {
		removeGoalSelectorPathfinderGoalAll(ocelot);
	}

	public static void setAbleToMove(Object ocelot) {
		newGoalSelectorPathfinderGoalRandomStroll(ocelot, 0.8D);
	}

	public static void setAbleToMove(Object ocelot, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(ocelot, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object ocelot) {
		newGoalSelectorPathfinderGoalFloat(ocelot);
		newGoalSelectorPathfinderGoalSit(ocelot);
		newGoalSelectorPathfinderGoalTempt(ocelot, 0.6D, "RAW_FISH", true);
		newGoalSelectorPathfinderGoalAvoidPlayer(ocelot, "EntityHuman", 16.0F, 0.8D, 1.33D);
		newGoalSelectorPathfinderGoalFollowOwner(ocelot, 1.0D, 10.0F, 5.0F);
		newGoalSelectorPathfinderGoalJumpOnBlock(ocelot, 1.33D);
		newGoalSelectorPathfinderGoalLeapAtTarget(ocelot, 0.3F);
		newGoalSelectorPathfinderGoalOcelotAttack(ocelot);
		newGoalSelectorPathfinderGoalBreed(ocelot, 0.8D);
		newGoalSelectorPathfinderGoalRandomStroll(ocelot, 0.8D);
		newGoalSelectorPathfinderGoalLookAtPlayer(ocelot, "EntityHuman", 10.0F);
	}
	
	public static void newGoalSelectorPathfinderGoalJumpOnBlock(Object ocelot, double d){
		try{
			Class<?> entityocelot = getNMSClass("EntityOcelot");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(ocelot);

			Class<?> pathfindergoaljumponblock = getNMSClass("PathfinderGoalJumpOnBlock");
			Object o = pathfindergoaljumponblock.getConstructor(entityocelot, double.class)
					.newInstance(entityocelot.cast(ocelot), d);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
			.invoke(goalselector, 2, o);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
