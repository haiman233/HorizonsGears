package me.gidorstudios.horizonsgears;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class HorizonsGears extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        NamespacedKey categoryId = new NamespacedKey(this, "horizons_gears");
        CustomItemStack categoryItem = new CustomItemStack(Material.NETHERITE_SWORD, "&3Category for the Horizons weapons and armour pack.");

        ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);

        // The custom item for our SlimefunItem
        SlimefunItemStack itemStack = new SlimefunItemStack("HORIZON_SWORD", Material.DIAMOND_SWORD, "&bHorizon Sword", "", "&7A powerful sword enchanted deep in the sea.");

        // A 3x3 shape representing our recipe
        ItemStack[] recipe = {
                new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND),
                null,                               SlimefunItems.CARBONADO,            null,
                new ItemStack(Material.DIAMOND),    null,                               new ItemStack(Material.DIAMOND)
        };

        SlimefunItem sfItem = new SlimefunItem(itemGroup, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        sfItem.register(this);
        // Our item is now registered
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
