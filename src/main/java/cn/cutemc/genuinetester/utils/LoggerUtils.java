package cn.cutemc.genuinetester.utils;

import cn.cutemc.genuinetester.GenuineTester;
import org.bukkit.Color;

import java.util.logging.Logger;

public class LoggerUtils {

    //获取插件logger
    public static Logger logger = GenuineTester.plugin.getLogger();

    /**
     * 输出INFO
     * @param msg
     */
    public static void info(String msg) {
        String serverName = PluginUtils.getPluginName(GenuineTester.plugin);
        logger.info( "[" + "INFO" + "] " + msg);
    }

    /**
     * 输出INFO并加上插件名称
     * @param msg     The string message (or a key in the message catalog)
     * @param doNotShow 是否不显示插件名称
     */
    public static void info(String msg,Boolean doNotShow) {
        if (doNotShow) {
            logger.info(msg);
        } else {
            logger.info( "[" + "INFO" + "] " + msg);
        }
    }

    /**
     * 输出ERROR
     * @param msg
     */
    public static void error(String msg) {
        String serverName = PluginUtils.getPluginName(GenuineTester.plugin);
        logger.info( "[" + "ERROR" + "] " + msg);
    }

    /**
     * 输出ERROR并加上插件名称
     * @param msg     The string message (or a key in the message catalog)
     * @param doNotShow 是否不显示插件名称
     */
    public static void error(String msg,Boolean doNotShow) {
        if (doNotShow) {
            logger.info(msg);
        } else {
            logger.info( "[" + "ERROR" + "] " + msg);
        }
    }
}
