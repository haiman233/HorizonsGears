package me.gidorstudios.horizonsgears;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmorEffectListener implements Runnable {

    private final JavaPlugin plugin;

    public ArmorEffectListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            checkArmor(player);
        }
    }

    private void checkArmor(Player player) {
        checkArmorPiece(player,  Material.NETHERITE_HELMET, PotionEffectType.WATER_BREATHING, 1, "&7Rebirth &8Helmet", 0);
        checkArmorPiece(player,  Material.NETHERITE_CHESTPLATE, PotionEffectType.INCREASE_DAMAGE, 2, "&7Rebirth &8Chestplate", 1);
        checkArmorPiece(player,  Material.NETHERITE_LEGGINGS, PotionEffectType.JUMP, 1, "&7Rebirth &8Leggings", 2);
        checkArmorPiece(player,  Material.NETHERITE_BOOTS, PotionEffectType.SPEED, 2, "&7Rebirth &8Boots", 3);
    }

    private void checkArmorPiece(Player player, Material armorType, PotionEffectType effectType, int amplifier, String armorName, int armorSlot) {
        ItemStack armor = player.getInventory().getArmorContents()[armorSlot];
        if (armor != null && armor.getType() == armorType && hasCorrectName(armor, armorName)) {
            applyPotionEffect(player, effectType, amplifier);
        } else {
            removePotionEffect(player, effectType);
        }
    }


    private boolean hasCorrectName(ItemStack item, String name) {
        if (item != null && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null && meta.hasDisplayName()) {
                String displayName = ChatColor.stripColor(meta.getDisplayName()); // Remove color codes from display name
                return displayName.equals(name);
            }
        }
        return false;
    }


    private void applyPotionEffect(Player player, PotionEffectType effectType, int amplifier) {
        player.addPotionEffect(new PotionEffect(effectType, Integer.MAX_VALUE, amplifier, true, false));
    }

    private void removePotionEffect(Player player, PotionEffectType effectType) {
        player.removePotionEffect(effectType);
    }

    public void startScheduler() {
        Bukkit.getScheduler().runTaskTimer(plugin, this, 40L, 40L); // Check every minute (change the second argument to adjust frequency)
    }
}
