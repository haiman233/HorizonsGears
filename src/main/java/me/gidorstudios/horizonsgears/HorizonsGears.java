package me.gidorstudios.horizonsgears;

import io.github.thebusybiscuit.slimefun4.api.items.ItemHandler;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
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

        NamespacedKey categoryId = new NamespacedKey(this, "a_horizons_gears");
        CustomItemStack categoryItem = new CustomItemStack(Material.NETHERITE_SWORD, "&bHorizon&8Reborned &3Pack.");

        ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);

        SlimefunItemStack CrystalitemStack = new SlimefunItemStack("HORIZON_CRYSTAL", Material.DIAMOND, "&7Horizon Crystal", "", "&3A shiny gem created by insane pressures.");

        SlimefunItemStack HorizonSworditemStack = new SlimefunItemStack("HORIZON_SWORD", Material.DIAMOND_SWORD, "&bHorizons &3Sword", "", "&7A powerful sword enchanted deep in the sea.");
        HorizonSworditemStack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
        HorizonSworditemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 7);
        HorizonSworditemStack.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);

        SlimefunItemStack HorizonHelmetitemStack = new SlimefunItemStack("HORIZON_HELMET", Material.DIAMOND_HELMET, "&bHorizons &3Helmet", "", "&7A powerful helmet crafted deep within the nether.");
        HorizonHelmetitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
        HorizonHelmetitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 7);
        HorizonHelmetitemStack.addUnsafeEnchantment(Enchantment.THORNS, 2);

        SlimefunItemStack HorizonChestitemStack = new SlimefunItemStack("HORIZON_CHESTPLATE", Material.DIAMOND_CHESTPLATE, "&bHorizons &3Chestplate", "", "&7A powerful chestplate crafted deep within the nether.");
        HorizonChestitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
        HorizonChestitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 7);

        SlimefunItemStack HorizonLeggingsitemStack = new SlimefunItemStack("HORIZON_LEGGINGS", Material.DIAMOND_LEGGINGS, "&bHorizons &3Leggings", "", "&7Powerful leggings crafted deep within the nether.");
        HorizonLeggingsitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
        HorizonLeggingsitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 7);

        SlimefunItemStack HorizonBootsitemStack = new SlimefunItemStack("HORIZON_BOOTS", Material.DIAMOND_BOOTS, "&bHorizons &3Boots", "", "&7Powerful boots crafted deep within the nether.");
        HorizonBootsitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 7);
        HorizonBootsitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 7);
        HorizonBootsitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 2);

        ItemStack[] cyrstalRecipe = {
                SlimefunItems.SYNTHETIC_DIAMOND,   new ItemStack(Material.DIAMOND),      SlimefunItems.CARBON_CHUNK,
                SlimefunItems.CARBONADO,           SlimefunItems.SYNTHETIC_SAPPHIRE,     SlimefunItems.DAMASCUS_STEEL_INGOT,
                null,                              null,                                 null
        };

        ItemStack[] helmetRecipe = {
                CrystalitemStack,                  CrystalitemStack,                           CrystalitemStack,
                CrystalitemStack,                  null,                                       CrystalitemStack,
                null,                              null,                                       null
        };

        ItemStack[] chestRecipe = {
                CrystalitemStack,                  null,                                       CrystalitemStack,
                CrystalitemStack,                  CrystalitemStack,                           CrystalitemStack,
                CrystalitemStack,                  CrystalitemStack,                           CrystalitemStack
        };

        ItemStack[] leggingsRecipe = {
                CrystalitemStack,                  CrystalitemStack,                           CrystalitemStack,
                CrystalitemStack,                  null,                                       CrystalitemStack,
                CrystalitemStack,                  null,                                       CrystalitemStack
        };

        ItemStack[] bootsRecipe = {
                null,                              null,                                       null,
                CrystalitemStack,                  null,                                       CrystalitemStack,
                CrystalitemStack,                  null,                                       CrystalitemStack
        };

        // A 3x3 shape representing our recipe
        ItemStack[] swordRecipe = {
                null,                                CrystalitemStack,               null,
                null,                               CrystalitemStack,                null,
                null,                              new ItemStack(Material.STICK),      null
        };

        SlimefunItem sfHItem = new SlimefunItem(itemGroup, HorizonHelmetitemStack, RecipeType.ENHANCED_CRAFTING_TABLE, helmetRecipe);
        sfHItem.register(this);

        SlimefunItem sfChItem = new SlimefunItem(itemGroup, HorizonChestitemStack, RecipeType.ENHANCED_CRAFTING_TABLE,  chestRecipe);
        sfChItem.register(this);

        SlimefunItem sfLItem = new SlimefunItem(itemGroup, HorizonLeggingsitemStack, RecipeType.ENHANCED_CRAFTING_TABLE, leggingsRecipe);
        sfLItem.register(this);

        SlimefunItem sfBItem = new SlimefunItem(itemGroup, HorizonBootsitemStack, RecipeType.ENHANCED_CRAFTING_TABLE, bootsRecipe);
        sfBItem.register(this);

        SlimefunItem sfCItem = new SlimefunItem(itemGroup, CrystalitemStack, RecipeType.PRESSURE_CHAMBER, cyrstalRecipe);
        sfCItem.register(this);

        SlimefunItem sfItem = new SlimefunItem(itemGroup, HorizonSworditemStack, RecipeType.ENHANCED_CRAFTING_TABLE, swordRecipe);
        sfItem.register(this);

        NamespacedKey researchKey = new NamespacedKey(this, "crystal_research");
        Research research = new Research(researchKey, 700, "Horizon Resources", 10);
        research.addItems(CrystalitemStack);
        research.register();

        NamespacedKey researchKeySword = new NamespacedKey(this, "hsword_research");
        Research researchSword = new Research(researchKeySword, 701, "Horizon Weapons", 15);
        researchSword.addItems(HorizonSworditemStack);
        researchSword.register();

        NamespacedKey researchKeyArmour = new NamespacedKey(this, "harmour_research");
        Research researchArmour = new Research(researchKeyArmour, 702, "Horizon Protections", 50);
        researchArmour.addItems(HorizonHelmetitemStack);
        researchArmour.addItems(HorizonChestitemStack);
        researchArmour.addItems(HorizonLeggingsitemStack);
        researchArmour.addItems(HorizonBootsitemStack);
        researchArmour.register();
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
