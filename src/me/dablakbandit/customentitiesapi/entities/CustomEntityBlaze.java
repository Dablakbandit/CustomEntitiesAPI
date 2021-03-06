package me.dablakbandit.customentitiesapi.entities;

import ja.ClassClassPath;
import ja.CtClass;
import ja.CtField;
import ja.CtNewMethod;
import me.dablakbandit.customentitiesapi.CustomEntitiesAPI;
import me.dablakbandit.customentitiesapi.NMSUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class CustomEntityBlaze extends CustomEntityMonster {

	public CustomEntityBlaze() {
		super("CustomEntityBlaze");
		if (ctClass == null)
			return;
		register();
	}

	public CustomEntityBlaze(Location location) {
		this();
		a();
		spawnEntity(location);
	}

	public CustomEntityBlaze(Entity e) {
		this();
		a();
		try {
			entity = customentity.cast(NMSUtils.getHandle(e));
		} catch (Exception e1) {
		}
	}

	public CustomEntityBlaze(Object o) {
		this();
		a();
		entity = o;
	}

	public static Class<?> getCustomEntityBlazeClass() {
		try {
			return Class.forName("temp.CustomEntityBlaze");
		} catch (Exception e) {
			return null;
		}
	}

	public void a() {
		try {
			customentity = Class.forName("temp.CustomEntityBlaze");
			helper = Class.forName("temp.CustomEntityBlazeHelper");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void register() {
		try {
			customentity = Class.forName("temp.CustomEntityBlaze");
		} catch (Exception e1) {
			try {
				cp.insertClassPath(new ClassClassPath(
						new CustomEntityBlazeHelper().getClass()));
				CtClass ces = cp
						.getAndRename(
								"me.dablakbandit.customentitiesapi.entities.CustomEntityBlazeHelper",
								"temp.CustomEntityBlazeHelper");
				ces.setSuperclass(cp.get("temp.CustomEntityMonsterHelper"));
				ces.toClass();
				CtClass EntityBlaze = cp.getCtClass("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityBlaze");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityBlaze");
				cp.importPackage("net.minecraft.server."
						+ NMSUtils.getVersion() + "EntityMonster");
				for (CtField f : fields) {
					ctClass.addField(f);
				}
				fields.clear();
				ctClass.setSuperclass(EntityBlaze);
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
			CustomEntitiesAPI.getInstance().registerEntity("EntityBlaze", 61,
					customentity);
	}
}
