package me.magnum.minecraftuuid;

import co.aikar.commands.BukkitCommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MinecraftUUID extends JavaPlugin {

    public static String pre = "&7[&aGetUUID&7] ";
    private static BukkitCommandManager commandManger;


    @Override
    public void onEnable() {
        registerCommands();
    }

    private void registerCommands() {
        commandManger = new BukkitCommandManager(this);
        commandManger.registerCommand(new GetID());

    }

}
