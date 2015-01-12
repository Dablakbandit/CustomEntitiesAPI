package me.dablakbandit.customentitiesapi.entities;

public class CustomEntityTameableAnimalHelper extends CustomEntityAnimalHelper {

	public static void newGoalSelectorPathfinderGoalSit(Object tameableanimal){
		try{
			Class<?> entitytameableanimal = getNMSClass("EntityTameableAnimal");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(tameableanimal);

			Class<?> pathfindergoalsit = getNMSClass("PathfinderGoalSit");
			Object o = pathfindergoalsit.getConstructor(entitytameableanimal)
					.newInstance(entitytameableanimal.cast(tameableanimal));

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
			.invoke(goalselector, 2, o);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void newGoalSelectorPathfinderGoalFollowOwner(Object tameableanimal, double d, float f1, float f2){
		try{
			Class<?> entitytameableanimal = getNMSClass("EntityTameableAnimal");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(tameableanimal);

			Class<?> pathfindergoalfollowowner = getNMSClass("PathfinderGoalFollowOwner");
			Object o = pathfindergoalfollowowner.getConstructor(entitytameableanimal, double.class, float.class, float.class)
					.newInstance(entitytameableanimal.cast(tameableanimal), d, f1, f2);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal)
			.invoke(goalselector, 2, o);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
