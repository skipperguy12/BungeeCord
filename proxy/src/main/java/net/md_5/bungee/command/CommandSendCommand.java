package net.md_5.bungee.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;
import com.explosivenetwork.ExplosiveMessenger.Server.*;
import com.explosivenetwork.ExplosiveMessenger.Packets.*;
import com.google.common.base.Joiner;
/**
 * Send a command to all connected servers
 */
public class CommandSendCommand extends Command
{

    public CommandSendCommand()
    {
        super( "sc", "bungeecord.command.sendcommand" );
    }

    @Override
    public void execute(CommandSender sender, String[] args)
    {
        ServerCommandPacket p = new ServerCommandPacket("all", Joiner.on(" ").join(args));
        Server.broadcast(p);
        sender.sendMessage("Broadcasted command.");
    }
}
