package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityPigHelper extends CustomEntityAnimalHelper {

	public static void setUnableToMove(Object pig) {
		removeGoalSelectorPathfinderGoalAll(pig);
	}

	public static void setAbleToMove(Object pig) {
		newGoalSelectorPathfinderGoalRandomStroll(pig, 1.0D);
	}

	public static void setAbleToMove(Object pig, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(pig, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object pig) {
		newGoalSelectorPathfinderGoalFloat(pig);
		newGoalSelectorPathfinderGoalPanic(pig, 1.25D);
		newGoalSelectorPathfinderGoalPassengerCarrotStick(pig, 0.3F);
		newGoalSelectorPathfinderGoalBreed(pig, 1.0D);
		newGoalSelectorPathfinderGoalTempt(pig, 1.2D, "CARROT_STICK", false);
		newGoalSelectorPathfinderGoalTempt(pig, 1.2D, "CARROT", false);
		newGoalSelectorPathfinderGoalFollowParent(pig, 1.1D);
		newGoalSelectorPathfinderGoalRandomStroll(pig, 1.0D);
		newGoalSelectorPathfinderGoalLookAtPlayer(pig, "EntityHuman", 6.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(pig);
	}
}
