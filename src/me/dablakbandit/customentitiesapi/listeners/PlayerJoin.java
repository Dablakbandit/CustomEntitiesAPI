package me.dablakbandit.customentitiesapi.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		try{
			throw new Exception("");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@EventHandler
	public void onPlayerSpawn(EntitySpawnEvent event){
		if(event.getEntity() instanceof Player){
			try{
				throw new Exception("");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
