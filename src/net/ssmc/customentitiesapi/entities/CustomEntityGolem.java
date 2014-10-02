package net.ssmc.customentitiesapi.entities;

import ja.CtClass;

public class CustomEntityGolem extends CustomEntityCreature{

	public CustomEntityGolem(String name) {
		super(name);
		if(ctClass==null)return;
		try {
			try{
				Class.forName("temp.CustomEntityGolemHelper");
			} catch (Exception e) {
				CtClass ces = cp.getAndRename("net.ssmc.customentitiesapi.entities.CustomEntityGolemHelper", "temp.CustomEntityGolemHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityCreatureHelper"));
				ces.toClass();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
