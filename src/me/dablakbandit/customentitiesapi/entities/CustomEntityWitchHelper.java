package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityWitchHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object witch) {
		removeGoalSelectorPathfinderGoalAll(witch);
	}

	public static void setAbleToMove(Object witch) {
		newGoalSelectorPathfinderGoalRandomStroll(witch, 1.0D);
	}

	public static void setAbleToMove(Object witch, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(witch, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object witch) {
		newGoalSelectorPathfinderGoalFloat(witch);
		newGoalSelectorPathfinderGoalArrowAttack(witch, 1.0D, 60, 60, 10.0F);
		newGoalSelectorPathfinderGoalRandomStroll(witch, 1.0D);
		newGoalSelectorPathfinderGoalLookAtPlayer(witch, "EntityHuman", 8.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(witch);
	}
	
	public static void newGoalSelectorPathfinderGoalArrowAttack(
			Object witch, double d, int i, int i1, float f) {
		try {
			Class<?> irangedentity = getNMSClass("IRangedEntity");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(witch);

			Class<?> pathfindergoalarrowattack = getNMSClass("PathfinderGoalArrowAttack");
			Object o = pathfindergoalarrowattack.getConstructor(irangedentity,
					double.class, int.class, int.class, float.class)
					.newInstance(irangedentity.cast(witch), d, i, i1, f);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 3, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalArrowAttack(
			Object witch) {
		removeGoalSelectorPathFinderGoal(witch, "PathfinderGoalArrowAttack");
	}
}
