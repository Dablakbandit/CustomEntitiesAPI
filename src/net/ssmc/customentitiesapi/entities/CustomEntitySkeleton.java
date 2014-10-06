package net.ssmc.customentitiesapi.entities;

import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import ja.LoaderClassPath;
import net.ssmc.customentitiesapi.CustomEntitiesAPI;
import net.ssmc.customentitiesapi.NMSUtils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntitySkeleton extends CustomEntityMonster{

	public CustomEntitySkeleton(){
		super("CustomEntitySkeleton");
		if(ctClass==null)return;
		register();
	}

	public CustomEntitySkeleton(Location location){
		this();
		a();
		spawnEntity(location);
		removeGoalSelectorPathfinderGoalMeleeAttack();
		//TODO
		//newGoalSelectorPathfinderGoalMeleeAttackDefault();
	}

	public CustomEntitySkeleton(Entity e){
		this();
		a();
		entity = NMSUtils.getHandle(e);
	}
	
	public CustomEntitySkeleton(Object o){
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntitySkeletonClass(){
		try {
			return Class.forName("temp.CustomEntitySkeleton");
		} catch (Exception e) {
			return null;
		}
	}

	private void register(){
		try{
			customentity = Class.forName("temp.CustomEntitySkeleton");
		}catch(Exception e1){
			try {
				cp.appendClassPath(new LoaderClassPath(CustomEntitySkeleton.class.getClassLoader()));
				CtClass ces = cp.getAndRename("net.ssmc.customentitiesapi.entities.CustomEntitySkeletonHelper", "temp.CustomEntitySkeletonHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityMonsterHelper"));
				ces.toClass();
				CtClass EntitySkeleton = cp.getCtClass("net.minecraft.server." + NMSUtils.getVersion() + "EntitySkeleton");
				cp.importPackage("net.minecraft.server." + NMSUtils.getVersion() + "EntitySkeleton");
				cp.importPackage("net.minecraft.server." + NMSUtils.getVersion() + "EntityLiving");
				cp.importPackage("temp");
				fields.add(new CtField(CtClass.booleanType, "pushable", ctClass));	
				for(CtField f : fields){
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntitySkeleton);
				methods.add("public void setUnableToMove(){"
						+ "CustomEntitySkeletonHelper.setUnableToMove(this);"
						+ "}");
				methods.add("public void setAbleToMove(){"
						+ "CustomEntitySkeletonHelper.setAbleToMove(this);"
						+ "}");

				methods.add("public void setAbleToMove(double d){"
						+ "CustomEntitySkeletonHelper.setAbleToMove(this, d);"
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
		if(customentity!=null)CustomEntitiesAPI.getInstance().registerEntity("EntitySkeleton", 54, customentity);
	}

	public void a(){
		try{
			customentity = Class.forName("temp.CustomEntitySkeleton");
			helper = Class.forName("temp.CustomEntitySkeletonHelper");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void spawnEntity(Location location){
		if(entity!=null)return;
		try {
			Object o = NMSUtils.getHandle(location.getWorld());
			Object newzombie = helper.getMethod("createEntity", Object.class, Class.class, double.class, double.class, double.class, float.class, float.class)
					.invoke(null, o, customentity, location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
			o.getClass().getMethod("addEntity", NMSUtils.getNMSClass("Entity")).invoke(o, newzombie);
			entity = newzombie;
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
}
