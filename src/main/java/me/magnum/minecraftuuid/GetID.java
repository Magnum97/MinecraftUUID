package me.magnum.minecraftuuid;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import me.magnum.lib.CheckSender;
import me.magnum.lib.Common;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.magnum.minecraftuuid.GetUUID.pre;

@SuppressWarnings("unused")
public class GetID extends BaseCommand {
	
	@CommandAlias("getuuid|uuid|getid")
	@SuppressWarnings({"deprecation"})
	@CommandCompletion("@Players")
	public void onGet (CommandSender sender, String user) {
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
			if (!CheckSender.isPlayer(sender)) {
				Common.tell(sender, pre + "&FUUID for &e" + p.getName() + " &fis &e" + uuid);
				return;
			}
			Player player = (Player) sender;
			TextComponent msg = new TextComponent();
			TextComponent hover = new TextComponent();
			hover.setText("Click to copy UUID");
			ClickEvent ce = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, uuid);
			HoverEvent he = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hover).create());
			msg.setText(pre.replace('&', '§') + "§fUUID for §e" + p.getName() + " §fis §e" + uuid);
			msg.setHoverEvent(he);
			msg.setClickEvent(ce);
			player.spigot().sendMessage(msg);
		}
		else {
			Common.tell(sender, pre + "&f" + user + " &2has not played on this server.");
		}
		
	}
	
	private void onHelp (CommandSender sender) {
		Common.tell(sender,
		            pre + "&F--------------------------------------------",
		            pre + "&AHow to use GetUUID:",
		            pre + "&ETo get a players UUID: &a/getuuid <username>",
		            pre + "&F--------------------------------------------");
	}
	
}
