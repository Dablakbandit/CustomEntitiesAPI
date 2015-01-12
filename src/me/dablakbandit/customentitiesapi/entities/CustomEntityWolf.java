package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityWolf extends CustomEntityTameableAnimal {

	public CustomEntityWolf() {
		super("CustomEntityWolf");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityWolf(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityWolf(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityWolf(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityWolfClass() {
		try {
			return Class.forName("temp.CustomEntityWolf");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityWolf");
			helper = Class.forName("temp.CustomEntityWolfHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityWolf");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityWolfHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityWolfHelper",
								"temp.CustomEntityWolfHelper");
				ces.setSuperclass(cp
						.get("temp.CustomEntityTameableAnimalHelper"));
				ces.toClass();
				CtClass EntityWolf = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityWolf");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityWolf");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityTameableAnimal");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityWolf);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityWolfHelper.setUnableToMove(this);" + "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityWolfHelper.setAbleToMove(this);" + "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityWolfHelper.setAbleToMove(this, d);"
						+ "}");
				for (String m : methods) {
					ctClass.addMethod(CtNewMethod.make(m, ctClass));
				}
				methods.clear();
				customentity = ctClass.toClass();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (customentity != null)
			CustomEntitiesAPI.getInstance().registerEntity("EntityWolf", 95,
					customentity);
	}

	public void setGoalSelectorDefaultPathfinderGoals() {
		try {
			helper.getMethod("setGoalSelectorDefaultPathfinderGoals",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newGoalSelectorPathfinderGoalBeg(float f){
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalBeg",
					Object.class, float.class).invoke(null, entity, f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeGoalSelectorPathfinderGoalBeg(){
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalBeg",
					Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newGoalSelectorPathfinderGoalBegDefault(){
		newGoalSelectorPathfinderGoalBeg(8.0F);
	}
	
	public void newGoalSelectorPathfinderGoalLeapAtTargetDefault(){
		newGoalSelectorPathfinderGoalLeapAtTarget(0.4F);
	}
	
	public void newGoalSelectorPathfinderGoalMeleeAttackDefault(){
		newGoalSelectorPathfinderGoalMeleeAttack(1.0D, true);
	}
	
	public void newGoalSelectorPathfinderGoalFollowOwnerDefault(){
		newGoalSelectorPathfinderGoalFollowOwner(1.0D, 10.0F, 2.0F);
	}
	
	public void newGoalSelectorPathfinderGoalBreedDefault(){
		newGoalSelectorPathfinderGoalBreed(1.0D);
	}
	
	public void newGoalSelectorPathfinderGoalRandomStrollDefault(){
		newGoalSelectorPathfinderGoalRandomStroll(1.0D);
	}
	
	public void newGoalSelectorPathfinderGoalLookAtPlayerDefault(){
		newGoalSelectorPathfinderGoalLookAtPlayer(EntityName.ENTITYHUMAN, 8.0F);
	}
	
}
