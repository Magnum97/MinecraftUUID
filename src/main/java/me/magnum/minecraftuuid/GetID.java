package me.magnum.minecraftuuid;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.magnum.lib.CheckSender;
import me.magnum.lib.Common;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

import static me.magnum.minecraftuuid.GetUUID.pre;

@SuppressWarnings("unused")
public class GetID extends BaseCommand {

    @CommandAlias("getuuid|uuid|getid")
    @SuppressWarnings({"deprecation"})
    @CommandCompletion("@Players")
    @CommandPermission("uuid.get")
    public void onGet(CommandSender sender, String user) {
        if (CheckSender.isCommand(sender)) {
            return;
        }
        if (user.equalsIgnoreCase("help")) {
            onHelp(sender);
            return;
        }
        OfflinePlayer p = Bukkit.getOfflinePlayer(user);
        if (p.hasPlayedBefore()) {
            String uuid = p.getUniqueId().toString();
            Common.tell(sender, pre + "&FUUID for &e" + user + " &fis &e" + uuid);
        } else Common.tell(sender, pre + "&f" + user + " &2has not played on this server.");

    }

    private void onHelp(CommandSender sender) {
        Common.tell(sender,
                pre + "&F--------------------------------------------",
                pre + "&AHow to use GetUUID:",
                pre + "&ETo get a players UUID: &a/getuuid <username>",
                pre + "&F--------------------------------------------");
    }

}
