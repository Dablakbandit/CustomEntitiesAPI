package me.dablakbandit.customentitiesapi.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener{

	@EventHandler
	public void onPlayerJoin(PlayerQuitEvent event){
		try{
			throw new Exception("");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerKickEvent event){
		try{
			event.setCancelled(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
