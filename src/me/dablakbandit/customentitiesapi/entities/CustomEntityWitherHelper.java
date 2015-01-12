package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityWitherHelper extends CustomEntityMonsterHelper {

	public static void setUnableToMove(Object wither) {
		removeGoalSelectorPathfinderGoalAll(wither);
	}

	public static void setAbleToMove(Object wither) {
		newGoalSelectorPathfinderGoalRandomStroll(wither, 1.0D);
	}

	public static void setAbleToMove(Object wither, double d) {
		newGoalSelectorPathfinderGoalRandomStroll(wither, d);
	}

	public static void setGoalSelectorDefaultPathfinderGoals(Object wither) {
		newGoalSelectorPathfinderGoalFloat(wither);
		newGoalSelectorPathfinderGoalArrowAttack(wither, 1.0D, 40, 40, 20.0F);
		newGoalSelectorPathfinderGoalRandomStroll(wither, 1.0D);
		newGoalSelectorPathfinderGoalLookAtPlayer(wither, "EntityHuman", 8.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(wither);
	}
	
	public static void newGoalSelectorPathfinderGoalArrowAttack(
			Object wither, double d, int i, int i1, float f) {
		try {
			Class<?> irangedentity = getNMSClass("IRangedEntity");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(wither);

			Class<?> pathfindergoalarrowattack = getNMSClass("PathfinderGoalArrowAttack");
			Object o = pathfindergoalarrowattack.getConstructor(irangedentity,
					double.class, int.class, int.class, float.class)
					.newInstance(irangedentity.cast(wither), d, i, i1, f);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
					.invoke(goalselector, 3, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalArrowAttack(
			Object wither) {
		removeGoalSelectorPathFinderGoal(wither, "PathfinderGoalArrowAttack");
	}
}
