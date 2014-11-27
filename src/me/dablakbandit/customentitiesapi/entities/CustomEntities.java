package me.dablakbandit.customentitiesapi.entities;

import ja.ClassPool;
import me.dablakbandit.customentitiesapi.NMSUtils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntities {	

	private static ClassPool cp= new ClassPool(true);

	private static void clone(Object oold, Object onew){
		
		try{
			Class<?> entity = NMSUtils.getNMSClass("Entity");
			entity.getMethod("a", entity, boolean.class).invoke(entity.cast(onew), entity.cast(oold), true);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//Not working full clone resorted to a basic clone ^
		/*Map<Class<?>, Map<String, Object>> fields = new HashMap<Class<?>, Map<String, Object>>();
		Class<?> c = oold.getClass();
		for(int i = 0; i<6; i++){
			Map<String, Object> fs1 = new HashMap<String, Object>();
			for(Field f : c.getDeclaredFields()){
				f.setAccessible(true);
				if(!Modifier.isFinal(f.getModifiers())&&!f.getName().equals("dead")){
					try {
						fs1.put(f.getName(), f.get(oold));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			fields.put(c, fs1);
			c = c.getSuperclass();
		}
		for(Class<?> c1 : fields.keySet()){
			Map<String, Object> fs =fields.get(c1);
			for(String f : fs.keySet()){
				try {
					try{
						Field f1 = c1.getDeclaredField(f);
						f1.setAccessible(true);
						f1.set(c1.cast(onew), fs.get(f));
					}catch(Exception e1){

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Field[] fi = c.getDeclaredFields();
		for(int i = 0; i < fi.length; i++){
			Field f = fi[i];
			f.setAccessible(true);
		}*/
	}

	public static void createClasses(){
		try {
			new CustomEntityIronGolem();
			new CustomEntitySheep();
			new CustomEntitySkeleton();
			new CustomEntityVillager();
			new CustomEntityZombie();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ClassPool getClassPool(){
		return cp;
	}
	/*
	 * =========================================================================================
	 * ==========================[Get instance of a CustomEntity]===============================
	 * =========================================================================================
	 */

	/***
	 * Gets the CustomEntityIronGolem or clones and gets rid of the Minecraft EntityIronGolem with a copy as a CustomEntityIronGolem
	 * @param e Bukkit Entity
	 * @return Instance of a CustomEntityIronGolem
	 * @see CustomEntityIronGolem
	 */
	public static CustomEntityIronGolem getCustomEntityIronGolem(Entity e){
		if(isCustomEntityIronGolem(e)){
			return new CustomEntityIronGolem(e);
		}else if(isNormalEntityIronGolem(e)){
			CustomEntityIronGolem ceig = new CustomEntityIronGolem(e.getLocation());
			clone(NMSUtils.getHandle(e), ceig.getEntity());
			e.remove();
			return ceig;
		}
		return null;
	}

	/***
	 * Gets the CustomEntitySheep or clones and gets rid of the Minecraft EntitySheep with a copy as a CustomEntitySheep
	 * @param e Bukkit Entity
	 * @return Instance of a CustomEntitySheep
	 * @see CustomEntitySheep
	 */
	public static CustomEntitySheep getCustomEntitySheep(Entity e){
		if(isCustomEntitySheep(e)){
			return new CustomEntitySheep(e);
		}else if(isNormalEntitySheep(e)){
			CustomEntitySheep ces = new CustomEntitySheep(e.getLocation());
			clone(NMSUtils.getHandle(e), ces.getEntity());
			e.remove();
			return ces;
		}
		return null;
	}

	/***
	 * Gets the CustomEntitySkeleton or clones and gets rid of the Minecraft EntitySkeleton with a copy as a CustomEntitySkeleton
	 * @param e Bukkit Entity
	 * @return Instance of a CustomEntitySkeleton
	 * @see CustomEntitySkeleton
	 */
	public static CustomEntitySkeleton getCustomEntitySkeleton(Entity e){
		if(isCustomEntitySkeleton(e)){
			return new CustomEntitySkeleton(e);
		}else if(isNormalEntitySkeleton(e)){
			CustomEntitySkeleton ces = new CustomEntitySkeleton(e.getLocation());
			clone(NMSUtils.getHandle(e), ces.getEntity());
			e.remove();
			return ces;
		}
		return null;
	}

	/***
	 * Gets the CustomEntityVillager or clones and gets rid of the Minecraft EntityVillager with a copy as a CustomEntityVillager
	 * @param e Bukkit Entity
	 * @return Instance of a CustomEntityVillager
	 * @see CustomEntityVillager
	 */
	public static CustomEntityVillager getCustomEntityVillager(Entity e){
		if(isCustomEntityVillager(e)){
			return new CustomEntityVillager(e);
		}else if(isNormalEntityVillager(e)){
			CustomEntityVillager cev = new CustomEntityVillager(e.getLocation());
			clone(NMSUtils.getHandle(e), cev.getEntity());
			e.remove();
			return cev;
		}
		return null;
	}

	/***
	 * Gets the CustomEntityZombie or clones and gets rid of the Minecraft EntityZombie with a copy as a CustomEntityZombie
	 * @param e Bukkit Entity
	 * @return Instance of a CustomEntityZombie
	 * @see CustomEntityZombie
	 */
	public static CustomEntityZombie getCustomEntityZombie(Entity e){
		System.out.print(NMSUtils.getHandle(e).getClass().getName());
		if(isCustomEntityZombie(e)){
			return new CustomEntityZombie(e);
		}else if(isNormalEntityZombie(e)){
			CustomEntityZombie cez = new CustomEntityZombie(e.getLocation());
			clone(NMSUtils.getHandle(e), cez.getEntity());
			e.remove();
			return cez;
		}
		return null;
	}

	/*
	 * =========================================================================================
	 * ========================[Get new instance of a CustomEntity]=============================
	 * =========================================================================================
	 */

	/**
	 * 
	 * @param location Bukkit Location
	 * @return New instance of a CustomEntityIronGolem
	 * @see CustomEntityIronGolem
	 */
	public static CustomEntityIronGolem getNewCustomEntityIronGolem(Location location){
		return new CustomEntityIronGolem(location);
	}

	/**
	 * 
	 * @param location Bukkit Location
	 * @return New instance of a CustomEntitySheep
	 * @see CustomEntitySheep
	 */
	public static CustomEntitySheep getNewCustomEntitySheep(Location location){
		return new CustomEntitySheep(location);
	}

	/**
	 * 
	 * @param location Bukkit Location
	 * @return New instance of a CustomEntitySkeleton
	 * @see CustomEntitySkeleton
	 */
	public static CustomEntitySkeleton getNewCustomEntitySkeleton(Location location){
		return new CustomEntitySkeleton(location);
	}

	/**
	 * 
	 * @param location Bukkit Location
	 * @return New instance of a CustomEntityVillager
	 * @see CustomEntityVillager
	 */
	public static CustomEntityVillager getNewCustomEntityVillager(Location location){
		return new CustomEntityVillager(location);
	}

	/**
	 * 
	 * @param location Bukkit Location
	 * @return New instance of a CustomEntityZombie
	 * @see CustomEntityZombie
	 */
	public static CustomEntityZombie getNewCustomEntityZombie(Location location){
		return new CustomEntityZombie(location);
	}

	/*
	 * =========================================================================================
	 * ==========================[Check instance of CustomEntity]===============================
	 * =========================================================================================
	 */

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is made by CustomEntitiesAPI
	 */
	public static boolean isCustomEntityIronGolem(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityIronGolem");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is made by CustomEntitiesAPI
	 */
	public static boolean isCustomEntitySheep(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntitySheep");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is made by CustomEntitiesAPI
	 */
	public static boolean isCustomEntitySkeleton(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntitySkeleton");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is made by CustomEntitiesAPI
	 */
	public static boolean isCustomEntityVillager(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityVillager");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is made by CustomEntitiesAPI
	 */
	public static boolean isCustomEntityZombie(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityZombie");
	}

	/*
	 * =========================================================================================
	 * ==========================[Check instance of Normal Entity]==============================
	 * =========================================================================================
	 */

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is a Minecraft Entity
	 */
	public static boolean isNormalEntityIronGolem(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityIronGolem");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is a Minecraft Entity
	 */
	public static boolean isNormalEntitySheep(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntitySheep");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is a Minecraft Entity
	 */
	public static boolean isNormalEntitySkeleton(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntitySkeleton");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is a Minecraft Entity
	 */
	public static boolean isNormalEntityVillager(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityVillager");
	}

	/**
	 * 
	 * @param e Bukkit Entity
	 * @return If the Entity is a Minecraft Entity
	 */
	public static boolean isNormalEntityZombie(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntityZombie");
	}
}
