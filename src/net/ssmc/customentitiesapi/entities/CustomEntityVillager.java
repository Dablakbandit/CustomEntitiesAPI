package net.ssmc.customentitiesapi.entities;

import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import ja.LoaderClassPath;
import net.ssmc.customentitiesapi.CustomEntitiesAPI;
import net.ssmc.customentitiesapi.NMSUtils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityVillager extends CustomEntityAgeable{

	public CustomEntityVillager(){
		super("CustomEntityVillager");
		if(ctClass==null)return;
		register();
	}

	public CustomEntityVillager(Location location){
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityVillager(Entity e){
		this();
		a();
		try{
			entity = customentity.cast(NMSUtils.getHandle(e));
		}catch(Exception e1){

		}
	}
	
	public CustomEntityVillager(Object o){
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityVillagerClass(){
		try {
			return Class.forName("temp.CustomEntityVillager");
		} catch (Exception e) {
			return null;
		}
	}

	public void a(){
		try{
			customentity = Class.forName("temp.CustomEntityVillager");
			helper = Class.forName("temp.CustomEntityVillagerHelper");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void register(){
		try{
			customentity = Class.forName("temp.CustomEntityVillager");
		}catch(Exception e1){
			try {
				cp.appendClassPath(new LoaderClassPath(CustomEntityVillager.class.getClassLoader()));
				CtClass ces = cp.getAndRename("net.ssmc.customentitiesapi.entities.CustomEntityVillagerHelper", "temp.CustomEntityVillagerHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityAgeableHelper"));
				ces.toClass();
				CtClass EntityVillager = cp.getCtClass("net.minecraft.server." + NMSUtils.getVersion() + "EntityVillager");
				cp.importPackage("net.minecraft.server." + NMSUtils.getVersion() + "EntityVillager");
				cp.importPackage("net.minecraft.server." + NMSUtils.getVersion() + "EntityLiving");
				cp.importPackage("temp");
				fields.add(new CtField(CtClass.booleanType, "pushable", ctClass));	
				for(CtField f : fields){
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityVillager);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntityVillagerHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntityVillagerHelper.setAbleToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntityVillagerHelper.setAbleToMove(this, d);"
						+ "}");
				for(String m : methods){
					ctClass.addMethod(CtNewMethod.make(m, ctClass));
				}
				methods.clear();
				customentity = ctClass.toClass();
				System.out.print("Villagers overided");
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(customentity!=null)CustomEntitiesAPI.getInstance().registerEntity("EntityVillager", 120, customentity);
	}

	public void spawnEntity(Location location){
		if(entity!=null)return;
		try {
			Object o = NMSUtils.getHandle(location.getWorld());
			Object newvillager = helper.getMethod("createEntity", Object.class, Class.class, double.class, double.class, double.class, float.class, float.class)
					.invoke(null, o, customentity, location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
			o.getClass().getMethod("addEntity", NMSUtils.getNMSClass("Entity")).invoke(o, newvillager);
			entity = newvillager;
		} catch (Exception e) {
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

	public void newGoalSelectorPathfinderGoalAvoidPlayerDefault(){
		newGoalSelectorPathfinderGoalAvoidPlayer(EntityName.ENTITYZOMBIE, 8.0F, 0.6D, 0.6D);
	}

	public void newGoalSelectorPathfinderGoalTradeWithPlayerDefault(){
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalTradeWithPlayer", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalTradeWithPlayer(){
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalTradeWithPlayer", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalLookAtTradingPlayerDefault(){
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalLookAtTradingPlayer", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalLookAtTradingPlayer(){
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalLookAtTradingPlayer", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalOpenDoorDefault(){
		newGoalSelectorPathfinderGoalOpenDoor(true);
	}

	public void newGoalSelectorPathfinderGoalMoveTowardsRestrictionDefault(){
		newGoalSelectorPathfinderGoalMoveTowardsRestriction(0.6D);
	}

	public void newGoalSelectorPathfinderGoalMakeLoveDefault(){
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalMakeLove", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalMakeLove(){
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalMakeLove", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalTakeFlowerDefault(){
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalTakeFlower", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeGoalSelectorPathfinderGoalTakeFlower(){
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalTakeFlower", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalPlay(double d){
		try {
			helper.getMethod("newGoalSelectorPathfinderGoalPlay", Object.class, double.class).invoke(null, entity, d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalPlayDefault(){
		newGoalSelectorPathfinderGoalPlay(0.32D);
	}

	public void removeGoalSelectorPathfinderGoalPlay(){
		try {
			helper.getMethod("removeGoalSelectorPathfinderGoalPlay", Object.class).invoke(null, entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newGoalSelectorPathfinderGoalInteractDefault(){
		newGoalSelectorPathfinderGoalInteract(EntityName.ENTITYHUMAN, 3.0F, 1.0F);
		newGoalSelectorPathfinderGoalInteract(EntityName.ENTITYVILLAGER, 5.0F, 0.2F);
	}

	public void newGoalSelectorPathfinderGoalRandomStrollDefault(){
		newGoalSelectorPathfinderGoalRandomStroll(0.6D);
	}

	public void newGoalSelectorPathfinderGoalLookAtPlayerDefault(){
		newGoalSelectorPathfinderGoalLookAtPlayer(EntityName.ENTITYINSENTIENT, 8.0F);
	}

	public int getProfession(){
		try {
			return (int) entity.getClass().getMethod("getProfession").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void setProfession(int i){
		try {
			entity.getClass().getMethod("setProfession", int.class).invoke(entity, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
