package net.ssmc.customentitiesapi.entities;

public class CustomEntitySkeletonHelper extends CustomEntityMonsterHelper{

	public static void setUnableToMove(Object skeleton){
		removeGoalSelectorPathfinderGoalAll(skeleton);
	}

	public static void setAbleToMove(Object skeleton){
		newGoalSelectorPathfinderGoalRandomStroll(skeleton, 1D);
	}

	public static void setAbleToMove(Object skeleton, double d){
		newGoalSelectorPathfinderGoalRandomStroll(skeleton, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object skeleton){
		
	}
}
