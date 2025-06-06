package me.gidorstudios.horizonsgears;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class HorizonsGears extends JavaPlugin implements SlimefunAddon {
    private ArmorEffectListener armorEffectListener;
    @Override
    public void onEnable() {
        // Read something from your config.yml
        Config cfg = new Config(this);

        NamespacedKey categoryId = new NamespacedKey(this, "a_horizons_gears");
        CustomItemStack categoryItem = new CustomItemStack(Material.NETHERITE_SWORD, "&b地平线&8装备");

        ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);

        SlimefunItemStack CrystalitemStack = new SlimefunItemStack("HORIZON_CRYSTAL", Material.DIAMOND, "&7地平线水晶", "", "&3巨大的压力造就了这颗闪亮的宝石");

        SlimefunItemStack HorizonSworditemStack = new SlimefunItemStack("HORIZON_SWORD", Material.DIAMOND_SWORD, "&b地平线&3之剑", "", "&7一把强大的剑在大海深处被施了魔法");
        HorizonSworditemStack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
        HorizonSworditemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 5);

        SlimefunItemStack HorizonHelmetitemStack = new SlimefunItemStack("HORIZON_HELMET", Material.DIAMOND_HELMET, "&b地平线&3头盔", "", "&7由下界深处制造的强大头盔");
        HorizonHelmetitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
        HorizonHelmetitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 5);

        SlimefunItemStack HorizonChestitemStack = new SlimefunItemStack("HORIZON_CHESTPLATE", Material.DIAMOND_CHESTPLATE, "&b地平线&3胸甲", "", "&7由下界深处制造的强大胸甲");
        HorizonChestitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
        HorizonChestitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 4);

        SlimefunItemStack HorizonLeggingsitemStack = new SlimefunItemStack("HORIZON_LEGGINGS", Material.DIAMOND_LEGGINGS, "&b地平线&3护腿", "", "&7由下界深处制造的强大护腿");
        HorizonLeggingsitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
        HorizonLeggingsitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 4);

        SlimefunItemStack HorizonBootsitemStack = new SlimefunItemStack("HORIZON_BOOTS", Material.DIAMOND_BOOTS, "&b地平线&3靴子", "", "&7由下界深处制造的强大靴子");
        HorizonBootsitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
        HorizonBootsitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 4);

// rebirth stuff
        SlimefunItemStack RebirthCrystalitemStack = new SlimefunItemStack("REBIRTH_CRYSTAL", Material.NETHERITE_INGOT, "&8重铸下界合金锭", "", "&7只有冶炼大师才能达到99%的纯度");

        SlimefunItemStack RebirthSworditemStack = new SlimefunItemStack("REBIRTH_SWORD", Material.NETHERITE_SWORD, "&7再生&8之剑", "", "&4精工制造");
        RebirthSworditemStack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
        RebirthSworditemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        RebirthSworditemStack.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);

        SlimefunItemStack RebirthHelmetitemStack = new SlimefunItemStack("REBIRTH_HELMET", Material.NETHERITE_HELMET, "&7再生&8头盔", "", "&4精工制造");
        RebirthHelmetitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        RebirthHelmetitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        RebirthHelmetitemStack.addUnsafeEnchantment(Enchantment.THORNS, 1);

        SlimefunItemStack RebirthChestitemStack = new SlimefunItemStack("REBIRTH_CHESTPLATE", Material.NETHERITE_CHESTPLATE, "&7再生&8胸甲", "", "&4精工制造");
        RebirthChestitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
        RebirthChestitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 5);

        SlimefunItemStack RebirthLeggingsitemStack = new SlimefunItemStack("REBIRTH_LEGGINGS", Material.NETHERITE_LEGGINGS, "&7再生&8护腿", "", "&4精工制造");
        RebirthLeggingsitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
        RebirthLeggingsitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 5);

        SlimefunItemStack RebirthBootsitemStack = new SlimefunItemStack("REBIRTH_BOOTS", Material.NETHERITE_BOOTS, "&7再生&8靴子", "", "&4精工制造");
        RebirthBootsitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
        RebirthBootsitemStack.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        RebirthBootsitemStack.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 1);

        ItemStack[] rebirthRecipe = {
                new ItemStack(Material.OBSIDIAN),   new ItemStack(Material.NETHERITE_INGOT),     new ItemStack(Material.OBSIDIAN),
                new ItemStack(Material.NETHERITE_INGOT),           CrystalitemStack,                      new ItemStack(Material.NETHERITE_INGOT),
                new ItemStack(Material.OBSIDIAN),             new ItemStack(Material.NETHERITE_INGOT),      new ItemStack(Material.OBSIDIAN),
        };


        ItemStack[] crystalRecipe = {
                SlimefunItems.COMPRESSED_CARBON,   new ItemStack(Material.DIAMOND),      SlimefunItems.CARBON,
                SlimefunItems.CARBONADO,           SlimefunItems.SYNTHETIC_SAPPHIRE,     SlimefunItems.STEEL_INGOT,
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

        ItemStack[] RbootsRecipe = {
                null,                              RebirthCrystalitemStack,                   null,
                RebirthCrystalitemStack,           HorizonBootsitemStack,            RebirthCrystalitemStack,
                null,                              RebirthCrystalitemStack,               null
        };

        ItemStack[] RleggRecipe = {
                null,                              RebirthCrystalitemStack,                   null,
                RebirthCrystalitemStack,           HorizonLeggingsitemStack,            RebirthCrystalitemStack,
                null,                              RebirthCrystalitemStack,               null
        };

        ItemStack[] RchestRecipe = {
                null,                              RebirthCrystalitemStack,                   null,
                RebirthCrystalitemStack,           HorizonChestitemStack,            RebirthCrystalitemStack,
                null,                              RebirthCrystalitemStack,               null
        };

        ItemStack[] RhelmetRecipe = {
                null,                              RebirthCrystalitemStack,                   null,
                RebirthCrystalitemStack,           HorizonHelmetitemStack,            RebirthCrystalitemStack,
                null,                              RebirthCrystalitemStack,               null
        };

        // A 3x3 shape representing our recipe
        ItemStack[] swordRecipe = {
                null,                                CrystalitemStack,               null,
                null,                               CrystalitemStack,                null,
                null,                              new ItemStack(Material.BLAZE_ROD),      null
        };

        ItemStack[] RswordRecipe = {
                null,                                RebirthCrystalitemStack,               null,
                null,                               RebirthCrystalitemStack,                null,
                null,                              HorizonSworditemStack,                   null
        };

        // horizon items
        SlimefunItem sfHItem = new SlimefunItem(itemGroup, HorizonHelmetitemStack, RecipeType.ENHANCED_CRAFTING_TABLE, helmetRecipe);
        sfHItem.register(this);

        SlimefunItem sfChItem = new SlimefunItem(itemGroup, HorizonChestitemStack, RecipeType.ENHANCED_CRAFTING_TABLE,  chestRecipe);
        sfChItem.register(this);

        SlimefunItem sfLItem = new SlimefunItem(itemGroup, HorizonLeggingsitemStack, RecipeType.ENHANCED_CRAFTING_TABLE, leggingsRecipe);
        sfLItem.register(this);

        SlimefunItem sfBItem = new SlimefunItem(itemGroup, HorizonBootsitemStack, RecipeType.ENHANCED_CRAFTING_TABLE, bootsRecipe);
        sfBItem.register(this);

        SlimefunItem sfCItem = new SlimefunItem(itemGroup, CrystalitemStack, RecipeType.SMELTERY, crystalRecipe);
        sfCItem.register(this);

        SlimefunItem sfItem = new SlimefunItem(itemGroup, HorizonSworditemStack, RecipeType.ENHANCED_CRAFTING_TABLE, swordRecipe);
        sfItem.register(this);

        // rebirth items

        SlimefunItem RsfHItem = new SlimefunItem(itemGroup, RebirthHelmetitemStack, RecipeType.ARMOR_FORGE, RhelmetRecipe);
        RsfHItem.register(this);

        SlimefunItem RsfChItem = new SlimefunItem(itemGroup, RebirthChestitemStack, RecipeType.ARMOR_FORGE,  RchestRecipe);
        RsfChItem.register(this);

        SlimefunItem RsfLItem = new SlimefunItem(itemGroup, RebirthLeggingsitemStack, RecipeType.ARMOR_FORGE, RleggRecipe);
        RsfLItem.register(this);

        SlimefunItem RsfBItem = new SlimefunItem(itemGroup, RebirthBootsitemStack, RecipeType.ARMOR_FORGE, RbootsRecipe);
        RsfBItem.register(this);

        SlimefunItem RsfCItem = new SlimefunItem(itemGroup, RebirthCrystalitemStack, RecipeType.MAGIC_WORKBENCH, rebirthRecipe);
        RsfCItem.register(this);

        SlimefunItem RsfItem = new SlimefunItem(itemGroup, RebirthSworditemStack, RecipeType.MAGIC_WORKBENCH, RswordRecipe);
        RsfItem.register(this);

        NamespacedKey researchKey = new NamespacedKey(this, "crystal_research");
        Research research = new Research(researchKey, 700, "地平线资源", 10);
        research.addItems(CrystalitemStack);
        research.register();

        NamespacedKey researchKeyR = new NamespacedKey(this, "crystal_research_2");
        Research researchR = new Research(researchKeyR, 703, "更好的地平线资源", 40);
        researchR.addItems(RebirthCrystalitemStack);
        researchR.register();

        NamespacedKey researchKeySword = new NamespacedKey(this, "hsword_research");
        Research researchSword = new Research(researchKeySword, 701, "地平线武器", 15);
        researchSword.addItems(HorizonSworditemStack);
        researchSword.register();

        NamespacedKey researchKeyArmour = new NamespacedKey(this, "harmour_research");
        Research researchArmour = new Research(researchKeyArmour, 702, "地平线护甲", 50);
        researchArmour.addItems(HorizonHelmetitemStack);
        researchArmour.addItems(HorizonChestitemStack);
        researchArmour.addItems(HorizonLeggingsitemStack);
        researchArmour.addItems(HorizonBootsitemStack);
        researchArmour.register();

        NamespacedKey researchKeyArmourR = new NamespacedKey(this, "rarmour_research");
        Research researchArmourR = new Research(researchKeyArmourR, 704, "地平线护甲 II", 75);
        researchArmourR.addItems(RebirthHelmetitemStack);
        researchArmourR.addItems(RebirthChestitemStack);
        researchArmourR.addItems(RebirthLeggingsitemStack);
        researchArmourR.addItems(RebirthBootsitemStack);
        researchArmourR.register();

        NamespacedKey RresearchKeySword = new NamespacedKey(this, "rsword_research");
        Research RresearchSword = new Research(RresearchKeySword, 705, "地平线武器 II", 35);
        RresearchSword.addItems(RebirthSworditemStack);
        RresearchSword.register();
        // Our item is now registered

       // armorEffectListener = new ArmorEffectListener(this);
        //armorEffectListener.startScheduler();

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
