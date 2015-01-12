package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityHorseHelper extends CustomEntityAnimalHelper {

	public static void setUnableToMove(Object horse) {
		removeGoalSelectorPathfinderGoalAll(horse);
	}

	public static void setAbleToMove(Object horse) {
		newGoalSelectorPathfinderGoalRandomStroll(horse, 0.7D);
	}

	public static void setAbleToMove(Object horse, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(horse, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object horse) {
		newGoalSelectorPathfinderGoalFloat(horse);
		newGoalSelectorPathfinderGoalPanic(horse, 1.2D);
		newGoalSelectorPathfinderGoalTame(horse, 1.2D);
		newGoalSelectorPathfinderGoalBreed(horse, 1.0D);
		newGoalSelectorPathfinderGoalFollowParent(horse, 1.0D);
		newGoalSelectorPathfinderGoalRandomStroll(horse, 1.0D);
		newGoalSelectorPathfinderGoalRandomStroll(horse, 0.7D);
		newGoalSelectorPathfinderGoalLookAtPlayer(horse, "EntityHuman", 6.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(horse);
	}

	public static void newGoalSelectorPathfinderGoalTame(Object horse, double d){
		try{
			Class<?> entityhorse = getNMSClass("EntityHorse");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(horse);

			Class<?> pathfindergoaltame = getNMSClass("PathfinderGoalTame");
			Object o = pathfindergoaltame.getConstructor(entityhorse, double.class)
					.newInstance(entityhorse.cast(horse), d);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
			.invoke(goalselector, 1, o);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void removeGoalSelectorPathfinderGoalTame(Object horse){
		removeGoalSelectorPathFinderGoal(horse, "PathfinderGoalTame");
	}
}
