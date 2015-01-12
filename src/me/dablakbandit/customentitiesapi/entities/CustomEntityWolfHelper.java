package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityWolfHelper extends CustomEntityTameableAnimalHelper {

	public static void setUnableToMove(Object wolf) {
		removeGoalSelectorPathfinderGoalAll(wolf);
	}

	public static void setAbleToMove(Object wolf) {
		newGoalSelectorPathfinderGoalRandomStroll(wolf, 1.0D);
	}

	public static void setAbleToMove(Object wolf, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(wolf, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object wolf) {
		newGoalSelectorPathfinderGoalFloat(wolf);
		newGoalSelectorPathfinderGoalSit(wolf);
		newGoalSelectorPathfinderGoalLeapAtTarget(wolf, 0.4F);
		newGoalSelectorPathfinderGoalFollowOwner(wolf, 1.0D, 10.0F, 2.0F);
		newGoalSelectorPathfinderGoalBreed(wolf, 1.0D);
		newGoalSelectorPathfinderGoalRandomStroll(wolf, 1.0D);
		newGoalSelectorPathfinderGoalBeg(wolf, 8.0F);
		newGoalSelectorPathfinderGoalLookAtPlayer(wolf, "EntityHuman", 8.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(wolf);
	}
	
	public static void newGoalSelectorPathfinderGoalBeg(
			Object wolf, float f) {
		try {
			Class<?> entitywolf = getNMSClass("EntityWolf");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(wolf);

			Class<?> pathfindergoalbeg = getNMSClass("PathfinderGoalBeg");
			Object o = pathfindergoalbeg.getConstructor(entitywolf, float.class)
					.newInstance(entitywolf.cast(wolf), f);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 8, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalBeg(
			Object wolf) {
		removeGoalSelectorPathFinderGoal(wolf, "PathfinderGoalBeg");
	}
}
