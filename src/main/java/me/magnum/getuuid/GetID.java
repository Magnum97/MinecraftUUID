package me.magnum.getuuid;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import me.magnum.lib.CheckSender;
import me.magnum.lib.Common;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

import static me.magnum.getuuid.GetUUID.pre;

public class GetID extends BaseCommand {

    @SuppressWarnings("deprication")
    @CommandAlias("getid")
    @CommandCompletion("@Players")
    public void onGet(CommandSender sender, String user) {
        if (CheckSender.isCommand(sender)) {
            return;
        }
        OfflinePlayer p = Bukkit.getOfflinePlayer(user);
        if (p.hasPlayedBefore()) {
        String uuid = p.getUniqueId().toString();
        Common.tell(sender, pre + "&FUUID for " + user + " is " + uuid);
        }
        else Common.tell(sender,pre+"&f"+user+" &2has not played on this server.");

    }

}
