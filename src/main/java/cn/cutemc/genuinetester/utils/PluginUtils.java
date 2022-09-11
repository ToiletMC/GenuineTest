package cn.cutemc.genuinetester.utils;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginUtils {

    /**
     * 获取插件名称
     * @param plugin 插件对象
     * @return 插件名称
     */
    public static String getPluginName(JavaPlugin plugin) {
        return plugin.getName();
    }
}
