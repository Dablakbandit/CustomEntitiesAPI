package net.ssmc.customentitiesapi.entities;

public class EntityName {

	public static EntityName ENTITY = new EntityName("Entity");
	public static EntityAgeableName ENTITYAGEABLE = new EntityAgeableName("EntityAgeable");
	public static EntityAmbientName ENTITYAMBIENT = new EntityAmbientName("EntityAmbients");
	public static EntityAnimalName ENTITYANIMAL = new EntityAnimalName("EntityAnimal");
	public static EntityName ENTITYARROW = new EntityName("EntityArrow");
	public static EntityAmbientName ENTITYBAT = new EntityAmbientName("EntityBat");
	public static EntityMonsterName ENTITYBLAZE = new EntityMonsterName("EntityBlaze");
	public static EntityName ENTITYBOAT = new EntityName("EntityBoat");
	public static EntityMonsterName ENTITYCAVESPIDER = new EntityMonsterName("EntityCaveSpider");
	public static EntityAnimalName ENTITYCHICKEN = new EntityAnimalName("EntityChicken");
	public static EntityAnimalName ENTITYCOW = new EntityAnimalName("EntityCow");
	public static EntityMonsterName ENTITYCREEPER = new EntityMonsterName("EntityCreeper");
	public static EntityProjectileName ENTITYEGG = new EntityProjectileName("EntityEgg");
	public static EntityName ENTITYENDERCRYSTAL = new EntityName("EntityEnderCrystal");
	public static EntityInsentientName ENTITYENDERDRAGON = new EntityInsentientName("EntityEnderDragon");
	public static EntityProjectileName ENTITYENDERPEARL = new EntityProjectileName("EntityEnderPearl");
	public static EntityName ENTITYENDERSIGNAL = new EntityName("EntityEnderSignal");
	public static EntityMonsterName ENTITYENDERMAN = new EntityMonsterName("EntityEnderman");
	public static EntityName ENTITYEXPERIENCEORB = new EntityName("EntityExperienceOrb");
	public static EntityName ENTITYFALLINGBLOCK = new EntityName("EntityFallingBlock");
	public static EntityName ENTITYFIREWORKS = new EntityName("EntityFireworks");
	public static EntityName ENTITYFISHINGHOOK = new EntityName("EntityFishingHook");
	public static EntityFlyingName ENTITYGHAST = new EntityFlyingName("EntityGhast");
	public static EntityGolemName ENTITYGOLEM = new EntityGolemName("EntityGolem");
	public static EntityMonsterName ENTITYGIANTZOMBIE = new EntityMonsterName("EntityGiantZombie");
	public static EntityAnimalName ENTITYHORSE = new EntityAnimalName("EntityHorse");
	public static EntityHumanName ENTITYHUMAN = new EntityHumanName("EntityHuman");
	public static EntityInsentientName ENTITYINSENTIENT = new EntityInsentientName("EntityInsentient");
	public static EntityGolemName ENTITYIRONGOLEM = new EntityGolemName("EntityIronGolem");
	public static EntityName ENTITYITEM = new EntityName("EntityItem");
	public static EntityHangingName ENTITYITEMFRAME = new EntityHangingName("EntityItemFrame");
	public static EntityFireballName ENTITYLARGEFIRBALL = new EntityFireballName("EntityLargeFireball");
	public static EntityHangingName ENTITYLEASH = new EntityHangingName("EntityLeash");
	public static EntityWeatherName ENTITYLIGHTNING = new EntityWeatherName("EntityWeatherLightning");
	public static EntityLivingName ENTITYLIVING = new EntityLivingName("EntityWeatherLiving");
	public static EntitySlimeName ENTITYMAGMACUBE = new EntitySlimeName("EntityMagmaCube");
	public static EntityMinecartContainerName ENTITYMINECARTCHEST = new EntityMinecartContainerName("EntityCartChest");
	public static EntityMinecartAbstractName ENTITYMINECARTCOMMANDBLOCK = new EntityMinecartAbstractName("EntityMinecartCommandBlock");
	public static EntityMinecartAbstractName ENTITYMINECARTFURNACE = new EntityMinecartAbstractName("EntityMinecraftFurnace");
	public static EntityMinecartContainerName ENTITYMINECARTHOPPER = new EntityMinecartContainerName("EntityMinecartHopper");
	public static EntityMinecartAbstractName ENTITYMINECARTMOBSPAWNER = new EntityMinecartAbstractName("EntityMinecartMobSpawner");
	public static EntityMinecartAbstractName ENTITYMINECARTRIDEABLE = new EntityMinecartAbstractName("EntityMinecartRideable");
	public static EntityMinecartAbstractName ENTITYMINECARTTNT = new EntityMinecartAbstractName("EntityMinecartTNT");
	public static EntityMonsterName ENTITYMONSTER = new EntityMonsterName("EntityMonster");
	public static EntityAnimalName ENTITYMUSHROOMCOW = new EntityAnimalName("EntityMushroomCow");
	public static EntityTameableAnimalName ENTITYOCELOT = new EntityTameableAnimalName("EntityOcelot");
	public static EntityHangingName ENTITYPAINTING = new EntityHangingName("EntityPainting");
	public static EntityAnimalName ENTITYPIG = new EntityAnimalName("EntityPig");
	public static EntityMonsterName ENTITYPIGZOMBIE = new EntityMonsterName("EntityPigZombie");
	public static EntityHumanName ENTITYPLAYER = new EntityHumanName("EntityPlayer");
	public static EntityProjectileName ENTITYPOTION = new EntityProjectileName("EntityPotion");
	public static EntityAnimalName ENTITYSHEEP = new EntityAnimalName("EntitySheep");
	public static EntityMonsterName ENTITYSILVERFISH = new EntityMonsterName("EntitySilverfish");
	public static EntityMonsterName ENTITYSKELETON = new EntityMonsterName("EntitySkeleton");
	public static EntitySlimeName ENTITYSLIME = new EntitySlimeName("EntitySlime");
	public static EntityFireballName ENTITYSMALLFIREBALL = new EntityFireballName("EntitySmallFireball");
	public static EntityProjectileName ENTITYSNOWBALL = new EntityProjectileName("EntitySnowball");
	public static EntityGolemName ENTITYSNOWMAN = new EntityGolemName("EntitySnowman");
	public static EntityMonsterName ENTITYSPIDER = new EntityMonsterName("EntitySpider");
	public static EntityWaterAnimalName ENTITYSQUID = new EntityWaterAnimalName("EntitySquid");
	public static EntityName ENTITYTNTPRIMED = new EntityName("EntityTNTPrimed");
	public static EntityProjectileName ENTITYTHROWNEXPBOTTLE = new EntityProjectileName("EntityThrownExpBottle");
	public static EntityAgeableName ENTITYVILLAGER = new EntityAgeableName("EntityVillager");
	public static EntityMonsterName ENTITYWITCH = new EntityMonsterName("EntityWitch");
	public static EntityMonsterName ENTITYWITHER = new EntityMonsterName("EntityWither");
	public static EntityFireballName ENTITYWITHERSKULL = new EntityFireballName("EntityWitherSkull");
	public static EntityTameableAnimalName ENTITYWOLF = new EntityTameableAnimalName("EntityWolf");
	public static EntityMonsterName ENTITYZOMBIE = new EntityMonsterName("EntityZombie");

	private String name;

	private EntityName(String name){

	}

	public String getName(){
		return name;
	}
	
	static class EntityInsentientName extends EntityName{
		public EntityInsentientName(String name){
			super(name);
		}
	}
	
	static class EntityAmbientName extends EntityInsentientName{
		public EntityAmbientName(String name) {
			super(name);
		}
	}
	
	static class EntityLivingName extends EntityInsentientName{
		public EntityLivingName(String name){
			super(name);
		}
	}
	
	static class EntityCreatureName extends EntityInsentientName{
		public EntityCreatureName(String name) {
			super(name);
		}
	}
	
	static class EntityAgeableName extends EntityCreatureName{
		public EntityAgeableName(String name) {
			super(name);
		}
	}
	
	static class EntityAnimalName extends EntityAgeableName{
		public EntityAnimalName(String name) {
			super(name);
		}
	}
	
	static class EntityMonsterName extends EntityCreatureName{
		public EntityMonsterName(String name) {
			super(name);
		}	
	}
	
	static class EntityProjectileName extends EntityName{
		public EntityProjectileName(String name){
			super(name);
		}
	}
	
	static class EntityFlyingName extends EntityInsentientName{
		public EntityFlyingName(String name) {
			super(name);
		}
	}
	
	static class EntityGolemName extends EntityCreatureName{
		public EntityGolemName(String name) {
			super(name);
		}
	}
	
	static class EntityHangingName extends EntityName{
		public EntityHangingName(String name) {
			super(name);
		}
	}
	
	static class EntityFireballName extends EntityName{
		public EntityFireballName(String name) {
			super(name);
		}
	}
	
	static class EntitySlimeName extends EntityInsentientName{
		public EntitySlimeName(String name) {
			super(name);
		}
	}
	
	static class EntityWeatherName extends EntityName{
		public EntityWeatherName(String name) {
			super(name);
		}
	}
	
	static class EntityMinecartAbstractName extends EntityName{
		public EntityMinecartAbstractName(String name) {
			super(name);
		}
	}
	
	static class EntityMinecartContainerName extends EntityMinecartAbstractName{
		public EntityMinecartContainerName(String name) {
			super(name);
		}
	}
	
	static class EntityTameableAnimalName extends EntityAnimalName{
		public EntityTameableAnimalName(String name) {
			super(name);
		}
	}
	
	static class EntityHumanName extends EntityLivingName{
		public EntityHumanName(String name) {
			super(name);
		}
	}
	
	static class EntityWaterAnimalName extends EntityCreatureName{
		public EntityWaterAnimalName(String name) {
			super(name);
		}
	}
}
