package net.ssmc.customentitiesapi.entities;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import net.ssmc.customentitiesapi.NMSUtils;

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
		newGoalSelectorPathfinderGoalFloat(skeleton);
		newGoalSelectorPathfinderGoalRestrictSun(skeleton);
		newGoalSelectorPathfinderGoalFleeSun(skeleton, 1.0D);
		newGoalSelectorPathfinderGoalRandomStroll(skeleton, 1.0D);
		newGoalSelectorPathfinderGoalLookAtPlayer(skeleton, "EntityHuman", 8.0F);
		newGoalSelectorPathfinderGoalRandomLookaround(skeleton);
		//TODO
		try{
			Class<?> itemstack = getNMSClass("ItemStack");
			Class<?> entityinsentient= getNMSClass("EntityInsentient");

			Field equipment = entityinsentient.getDeclaredField("equipment");
			equipment.setAccessible(true);
			Object item = equipment.get(entityinsentient.cast(skeleton));

			Object i = unpack(item)[0];

			System.out.print(i.getClass());
			try{
				Class.forName("net.minecraft.server." + NMSUtils.getVersion() + "Items");
			}catch(Exception e){

			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static Object[] unpack(Object array) {
		Object[] array2 = new Object[Array.getLength(array)];
		for(int i=0;i<array2.length;i++)
			array2[i] = Array.get(array, i);
		return array2;
	}

	public static void newGoalSelectorPathFinferGoalArrowAttack(Object skeleton, double d, int i, int i1, float f){
		try{
			Class<?> irangedentity = getNMSClass("IRangedEntity");
			Class<?> pathfindergoal = getNMSClass("PathfinderGoal");

			Object goalselector = getGoalSelector(skeleton);

			Class<?> pathfindergoalarrowattack = getNMSClass("PathfinderGoalGoalArrowAttack");
			Object o = pathfindergoalarrowattack.getConstructor(irangedentity, double.class, int.class, int.class, float.class)
					.newInstance(irangedentity.cast(skeleton), d);

			goalselector.getClass().getMethod("a", int.class, pathfindergoal).invoke(goalselector, 3, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void removeGoalSelectorPathfinderGoalArrowAttack(Object creature){
		removeGoalSelectorPathFinderGoal(creature, "PathfinderGoalArrowAttack");
	}
}
