package me.dablakbandit.customentitiesapi.entities;

import ja.CtClass;

public abstract class CustomEntityTameableAnimal extends CustomEntityAnimal {

	public CustomEntityTameableAnimal(String name) {
		super(name);
		if (ctClass == null)
			return;
		try {
			try {
				Class.forName("temp.CustomEntityTameableAnimalHelper");
			} catch (Exception e) {
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityTameableAnimalHelper",
								"temp.CustomEntityTameableAnimalHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAnimalHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newGoalSelectorPathfinderGoalSitDefault(){
		try{
			helper.getMethod("newGoalSelectorPathfinderGoalSitDefault", Object.class).invoke(null, entity);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void newGoalSelectorPathfinderGoalFollowOwner(double d, float f1, float f2){
		try{
			helper.getMethod("newGoalSelectorPathfinderGoalFollowOwner", Object.class, double.class, float.class, float.class).invoke(null, entity, d, f1, f2);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
