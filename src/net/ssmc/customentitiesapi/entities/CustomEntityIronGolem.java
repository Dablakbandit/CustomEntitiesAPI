package net.ssmc.customentitiesapi.entities;

import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import ja.LoaderClassPath;
import net.ssmc.customentitiesapi.CustomEntitiesAPI;
import net.ssmc.customentitiesapi.NMSUtils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityIronGolem extends CustomEntityGolem{

	public CustomEntityIronGolem(){
		super("CustomEntityIronGolem");
		if(ctClass==null)return;
		register();
	}

	public CustomEntityIronGolem(Location location){
		this();
		a();
		spawnEntity(location);
		removeGoalSelectorPathfinderGoalMeleeAttack();
		newGoalSelectorPathfinderGoalMeleeAttackDefault();
	}

	public CustomEntityIronGolem(Entity e){
		this();
		a();
		entity = NMSUtils.getHandle(e);
	}

	public static Class<?> getCustomEntityIronGolemClass(){
		try {
			return Class.forName("temp.CustomEntityIronGolem");
		} catch (Exception e) {
			return null;
		}
	}

	private void register(){
		try{
			customentity = Class.forName("temp.CustomEntityIronGolem");
		}catch(Exception e1){
			try {
				cp.appendClassPath(new LoaderClassPath(CustomEntityIronGolem.class.getClassLoader()));
				CtClass ces = cp.getAndRename("net.ssmc.customentitiesapi.entities.CustomEntityIronGolemHelper", "temp.CustomEntityIronGolemHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityGolemHelper"));
				ces.toClass();
				CtClass entityirongolem = cp.getCtClass("net.minecraft.server." + NMSUtils.getVersion() + "EntityIronGolem");
				cp.importPackage("net.minecraft.server." + NMSUtils.getVersion() + "EntityIronGolem");
				cp.importPackage("temp");
				fields.add(new CtField(CtClass.booleanType, "pushable", ctClass));	
				for(CtField f : fields){
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(entityirongolem);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityIronGolemHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityIronGolemHelper.setAbleToMove(this, d);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityIronGolemHelper.setAbleToMove(this);"
						+ "}");
				for(String m : methods){
					ctClass.addMethod(CtNewMethod.make(m, ctClass));
				}
				methods.clear();
				customentity = ctClass.toClass();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(customentity!=null)CustomEntitiesAPI.getInstance().registerEntity("EntityIronGolem", 99, customentity);
	}

	public void a(){
		try{
			customentity = Class.forName("temp.CustomEntityIronGolem");
			helper = Class.forName("temp.CustomEntityIronGolemHelper");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void setPushable(){
		try {
			entity.getClass().getMethod("setPushable").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPushable(boolean value){
		if(value){
			setPushable();
		}else{
			setUnpushable();
		}
	}

	public void setUnpushable(){
		try {
			entity.getClass().getMethod("setUnpushable").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUnpushable(boolean value){
		if(value){
			setUnpushable();
		}else{
			setPushable();
		}
	}

	public void setAbleToMove(){
		try {
			entity.getClass().getMethod("setAbleToMove", double.class).invoke(entity, 1.0D);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setAbleToMove(boolean value){
		if(value){
			setAbleToMove();
		}else{
			setUnableToMove();
		}
	}

	public void setAbleToMove(double d){
		try {
			entity.getClass().getMethod("setAbleToMove", double.class).invoke(entity, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUnableToMove(){
		try {
			entity.getClass().getMethod("setUnableToMove").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setUnableToMove(boolean value){
		if(value){
			setUnableToMove();
		}else{
			setAbleToMove();
		}
	}

	public void spawnEntity(Location location){
		if(entity!=null)return;
		try {
			Object o = NMSUtils.getHandle(location.getWorld());
			Object newirongolem = helper.getMethod("createEntity", Object.class, Class.class, double.class, double.class, double.class, float.class, float.class)
					.invoke(null, o, customentity, location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
			o.getClass().getMethod("addEntity", NMSUtils.getNMSClass("Entity")).invoke(o, newirongolem);
			entity = newirongolem;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setGoalSelectorDefaultPathfinderGoals(){
		try {
			helper.getMethod("setGoalSelectorDefaultPathfinderGoals", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalOfferFlowerDefault(){
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalOfferFlower", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeGoalSelectorPathfinderGoalOfferFlower(){
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalOfferFlower", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newGoalSelectorPathfinderGoalMeleeAttackDefault(){
		newGoalSelectorPathfinderGoalMeleeAttack(1.0D, true);
	}
	
	public void newGoalSelectorPathfinderMoveTowardsTargetDefault(){
		newGoalSelectorPathfinderGoalMoveTowardsTarget(0.9D, 32.0F);
	}
	
	public void newGoalSelectorPathfinderMoveThroughVillagerDefault(){
		newGoalSelectorPathfinderGoalMoveThroughVillage(0.6D, true);
	}
	
	public void newGoalSelectorPathfinderMoveThroughRestrictionDefault(){
		newGoalSelectorPathfinderGoalMoveTowardsRestriction(1.0D);
	}
	
	public void newGoalSelectorPathfinderRandomStrollDefault(){
		newGoalSelectorPathfinderGoalRandomStroll(0.6D);
	}
	
	public void newGoalSelectorPathfinderLookAtPlayerDefault(){
		newGoalSelectorPathfinderGoalLookAtPlayer(EntityName.ENTITYPLAYER, 6.0F);
	}

	public boolean isPlayerCreated(){
		try {
			return (boolean) entity.getClass().getMethod("getPlayerCreated").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void setPlayerCreated(boolean flag){
		try {
			entity.getClass().getMethod("setPlayerCreated", boolean.class).invoke(entity, flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
