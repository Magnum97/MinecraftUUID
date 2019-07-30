package me.magnum.minecraftuuid;

import co.aikar.commands.BukkitCommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GetUUID extends JavaPlugin {
	
	static String pre = "&7[&aGetUUID&7] ";
	public static GetUUID plugin;
	
	
	@Override
	public void onEnable () {
		registerCommands();
	}
	
	private void registerCommands () {
		plugin = this;
		BukkitCommandManager commandManger = new BukkitCommandManager(plugin);
		commandManger.registerCommand(new GetID());
	}
}
