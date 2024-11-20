/*
 * The MIT License (MIT)
 *
 * Copyright © 2024 - OpenLogin Contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.nickuc.openlogin.bukkit.util;

import com.nickuc.openlogin.common.settings.Settings;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class TextComponentMessage {

    public static void sendPluginChoice(Player player) {
        TextComponent first = new TextComponent("      ");

        TextComponent nlogin = new TextComponent("nLogin");
        nlogin.setColor(ChatColor.YELLOW);
        HoverEvent nloginHover = new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§6nLogin §7is a §6proprietary §7authentication plugin,\n§7updated and maintained by §bnickuc.com§7. This means that you\n§7cannot view and modify the source code of the plugin.\n\n§eIf you still have questions, please contact us:\n§bnickuc.com/discord"));
        ClickEvent nloginClick = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/openlogin nlogin skip");
        nlogin.setHoverEvent(nloginHover);
        nlogin.setClickEvent(nloginClick);
        first.addExtra(nlogin);
        first.addExtra("              ");

        TextComponent openlogin = new TextComponent("OpeNLogin");
        openlogin.setColor(ChatColor.YELLOW);
        HoverEvent openloginHover = new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText("§bOpeNLogin §7is a §bopen source §7authentication plugin,\n§7updated and maintained by all OpeNLogin contributors.\n\n§cCurrently the plugin does not have as many resources as nLogin."));
        ClickEvent openloginClick = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/openlogin setup");
        openlogin.setHoverEvent(openloginHover);
        openlogin.setClickEvent(openloginClick);
        first.addExtra(openlogin);

        TextComponent second = new TextComponent("  ");

        TextComponent proprietary = new TextComponent("(proprietary)");
        proprietary.setColor(ChatColor.GOLD);
        proprietary.setHoverEvent(nloginHover);
        proprietary.setClickEvent(nloginClick);
        second.addExtra(proprietary);
        second.addExtra("      ");

        TextComponent opensource = new TextComponent("(open source)");
        opensource.setColor(ChatColor.AQUA);
        opensource.setHoverEvent(openloginHover);
        opensource.setClickEvent(openloginClick);
        second.addExtra(opensource);

        Player.Spigot spigot = player.spigot();
        spigot.sendMessage(first);
        spigot.sendMessage(second);
    }

    public static void sendServerGreeting(Player player) {
        // start (altered to remove the advertisements, now gives custom server greeting)
        player.sendMessage("");
        player.sendMessage(" §fWelcome to " + Settings.SERVER_NAME.asString() + ", " + player.getDisplayName() + "!");
        String[] s = Settings.SERVER_GREETING.asString().split("\n");
        for (String m : s){
            player.sendMessage(m);
        }
        player.sendMessage("");
    }

}
