package net.ssmc.customentitiesapi.entities;

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

	public static CustomEntitySheep getCustomEntitySheep(Entity e){
		if(NMSUtils.getHandle(e).getClass().getName().equals("temp.CustomEntitySheep")){
			return new CustomEntitySheep(e);
		}else if(NMSUtils.getHandle(e).getClass().getSimpleName().equals("EntitySheep")){
			CustomEntitySheep ces = new CustomEntitySheep(e.getLocation());
			//TODO edit the new entity to be like the old
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
		}else if(NMSUtils.getHandle(e).getClass().getSimpleName().equals("EntityZombie")){
			CustomEntityZombie cez = new CustomEntityZombie(e.getLocation());
			//TODO edit the new entity to be like the old
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
		}else if(NMSUtils.getHandle(e).getClass().getSimpleName().equals("EntityVillager")){
			CustomEntityVillager cev = new CustomEntityVillager(e.getLocation());
			//TODO edit the new entity to be like the old
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
		}else if(NMSUtils.getHandle(e).getClass().getSimpleName().equals("EntityIronGolem")){
			CustomEntityIronGolem ceig = new CustomEntityIronGolem(e.getLocation());
			//TODO edit the new entity to be like the old
			e.remove();
			return ceig;
		}
		return null;
	}

	public static CustomEntityIronGolem getNewCustomEntityIronGolem(Location location){
		return new CustomEntityIronGolem(location);
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
