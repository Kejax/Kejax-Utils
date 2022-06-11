package kejax.utils;

import kejax.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigLocationUtil {

    private Main plugin;

    private String path;

    private Location location;
    private World world;

    private double x;
    private double y;
    private double z;

    private float yaw;
    private float pitch;

    public ConfigLocationUtil(Main plugin, Location location, String path) {
        this.path = path;
        this.world = location.getWorld();

        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();

        this.yaw = location.getYaw();
        this.pitch = location.getPitch();

        this.location = location;
    }

    public ConfigLocationUtil(Main plugin, String path) {
        this.plugin = plugin;
        this.path = path;
    }

    public void save() {
        FileConfiguration config = plugin.getConfig();
        config.set(path + ".world", world);
        config.set(path + ".x", x);
        config.set(path + ".y", y);
        config.set(path + ".z", z);
        config.set(path + ".yaw", yaw);
        config.set(path + ".pitch", pitch);
        plugin.saveConfig();
    }

    public Location load() {
        try {
            FileConfiguration config = plugin.getConfig();
            this.world = Bukkit.getWorld(config.getString(path + ".world"));
            this.x = config.getDouble(path + ".x");
            this.y = config.getDouble(path + ".y");
            this.z = config.getDouble(path + ".z");
            this.yaw = (float) config.getDouble(path + ".yaw");
            this.pitch = (float) config.getDouble(path + ".pitch");
            return new Location(world, x, y, z, yaw, pitch);
        } catch (Exception e) {
            return null;
        }
    }
}
