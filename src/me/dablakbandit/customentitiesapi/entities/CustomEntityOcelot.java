package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityOcelot extends CustomEntityTameableAnimal {

	public CustomEntityOcelot() {
		super("CustomEntityOcelot");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityOcelot(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityOcelot(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityOcelot(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityOcelotClass() {
		try {
			return Class.forName("temp.CustomEntityOcelot");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityOcelot");
			helper = Class.forName("temp.CustomEntityOcelotHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityOcelot");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityOcelotHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityOcelotHelper",
								"temp.CustomEntityOcelotHelper");
				ces.setSuperclass(cp
						.get("temp.CustomEntityTameableAnimalHelper"));
				ces.toClass();
				CtClass EntityOcelot = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityOcelot");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityOcelot");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityTameableAnimal");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityOcelot);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityOcelotHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityOcelotHelper.setAbleToMove(this);" + "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityOcelotHelper.setAbleToMove(this, d);"
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityOcelot", 98,
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
	
	public void newGoalSelectorPathfinderGoalTempDefault(){
		newGoalSelectorPathfinderGoalTempt(0.6D, "RAW_FISH", true);
	}
	
	public void newGoalSelectorPathfinderGoalAvoidPlayerDefault(){
		newGoalSelectorPathfinderGoalAvoidPlayer(EntityName.ENTITYHUMAN, 16.0F, 0.8D, 1.33D);
	}
	
	public void newGoalSelectorPathfinderGoalFollowOwnerDefault(){
		newGoalSelectorPathfinderGoalFollowOwner(1.0D, 10.0F, 5.0F);
	}
	
	public void newGoalSelectorPathfinderGoalJumpOnBlockDefault(){
		newGoalSelectorPathfinderGoalJumpOnBlock(1.33D);
	}
	
	public void newGoalSelectorPathfinderGoalLeapAtTargetDefault(){
		newGoalSelectorPathfinderGoalLeapAtTarget(0.3F);
	}
	
	public void newGoalSelectorPathfinderGoalBreedDefault(){
		newGoalSelectorPathfinderGoalBreed(0.8D);
	}
	
	public void newGoalSelectorPathfinderGoalRandomStrollDefault(){
		newGoalSelectorPathfinderGoalRandomStroll(0.8D);
	}
	
	public void newGoalSelectorPathfinderGoalLookAtPlayerDefault(){
		newGoalSelectorPathfinderGoalLookAtPlayer(EntityName.ENTITYHUMAN, 10.0F);
	}
	
	public void newGoalSelectorPathfinderGoalJumpOnBlock(double d){
		try{
			helper.getMethod("newGoalSelectorPathfinderGoalJumpOnBlock", Object.class, double.class).invoke(null, entity, d);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
