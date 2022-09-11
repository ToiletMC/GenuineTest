package cn.cutemc.genuinetester;

import cn.cutemc.genuinetester.utils.ConfigUtils;
import cn.cutemc.genuinetester.utils.ServerUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static cn.cutemc.genuinetester.utils.LoggerUtils.error;
import static cn.cutemc.genuinetester.utils.LoggerUtils.info;

public final class GenuineTester extends JavaPlugin {

    public static GenuineTester plugin = null;
    public static ArrayList<String> playerList;
    public static List<String> commands;

    @Override
    public void onEnable() {
        plugin = this;

        info("Loading command file...");

        try {
            commands = ConfigUtils.readCommandFile(this);
        } catch (IOException e) {
            error("插件在读取指令列表时遇到" + e.getMessage() + "详细请查看下面报错信息并反馈给lushangkan");
            throw new RuntimeException(e);
        }

        info("Loaded success!");
        info("Saving player list...");

        try {
            playerList = ServerUtils.savePlayerList(this);
        } catch (IOException e) {
            error("插件在保存玩家列表时遇到" + e.getMessage() + "详细请查看下面报错信息并反馈给lushangkan");
            throw new RuntimeException(e);
        }

        info("Welcome use GenuineTest, authorized to ToiletMC");


    }

    @Override
    public void onDisable() {
        info("GenuineTest was disabled!");
    }
}
