package net.ssmc.customentitiesapi.entities;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import ja.ClassPool;
import net.ssmc.customentitiesapi.NMSUtils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntities {	

	private static ClassPool cp= new ClassPool(true);

	public static ClassPool getClassPool(){
		return cp;
	}

	public static boolean isCustomEntitySheep(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntitySheep");
	}
	
	public static boolean isNormalEntitySheep(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() + "EntitySheep");
	}

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

	public static CustomEntitySheep getNewCustomEntitySheep(Location location){
		return new CustomEntitySheep(location);
	}

	public static boolean isCustomEntityZombie(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityZombie");
	}
	public static CustomEntityZombie getCustomEntityZombie(Entity e){
		System.out.print(NMSUtils.getHandle(e).getClass().getName());
		if(NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityZombie")){
			return new CustomEntityZombie(e);
		}else if(NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() +"EntityZombie")){
			CustomEntityZombie cez = new CustomEntityZombie(e.getLocation());
			clone(NMSUtils.getHandle(e), cez.getEntity());
			e.remove();
			return cez;
		}
		return null;
	}

	public static CustomEntityZombie getNewCustomEntityZombie(Location location){
		return new CustomEntityZombie(location);
	}

	public static boolean isCustomEntityVillager(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityVillager");
	}

	public static CustomEntityVillager getCustomEntityVillager(Entity e){
		if(NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityVillager")){
			return new CustomEntityVillager(e);
		}else if(NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() +"EntityVillager")){
			CustomEntityVillager cev = new CustomEntityVillager(e.getLocation());
			clone(NMSUtils.getHandle(e), cev.getEntity());
			e.remove();
			return cev;
		}
		return null;
	}

	public static CustomEntityVillager getNewCustomEntityVillager(Location location){
		return new CustomEntityVillager(location);
	}
	
	public static boolean isCustomEntityIronGolem(Entity e){
		return NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityIronGolem");
	}

	public static CustomEntityIronGolem getCustomEntityIronGolem(Entity e){
		if(NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntityIronGolem")){
			return new CustomEntityIronGolem(e);
		}else if(NMSUtils.getHandle(e).getClass().getName().equals("net.minecraft.server." + NMSUtils.getVersion() +"EntityIronGolem")){
			CustomEntityIronGolem ceig = new CustomEntityIronGolem(e.getLocation());
			clone(NMSUtils.getHandle(e), ceig.getEntity());
			e.remove();
			return ceig;
		}
		return null;
	}

	public static CustomEntityIronGolem getNewCustomEntityIronGolem(Location location){
		return new CustomEntityIronGolem(location);
	}
	
	private static void clone(Object oold, Object onew){
		Map<Class<?>, Map<String, Object>> fields = new HashMap<Class<?>, Map<String, Object>>();
		Class<?> c = oold.getClass();
		while(c!=null){
			Map<String, Object> fs = new HashMap<String, Object>();
			for(Field f : c.getDeclaredFields()){
				f.setAccessible(true);
				if(!f.getName().equals("dead")){
					try {
						fs.put(f.getName(), f.get(oold));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			c = c.getSuperclass();
		}
		for(Class<?> c1 : fields.keySet()){
			Map<String, Object> fs =fields.get(c1);
			for(String f : fs.keySet()){
				try {
					Field f1 = c1.getDeclaredField(f);
					f1.setAccessible(true);
					f1.set(c1.cast(onew), fs.get(f));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void createClasses(){
		try {
			new CustomEntityIronGolem();
			new CustomEntitySheep();
			new CustomEntityVillager();
			new CustomEntityZombie();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
