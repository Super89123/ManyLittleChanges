package org.super89.supermegamod.magic;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class FireBook implements Listener {
    public void spawnFireParticlesAroundPlayer(Player player) {
        World world = player.getWorld();
        double playerX = player.getLocation().getX();
        double playerY = player.getLocation().getY();
        double playerZ = player.getLocation().getZ();

        for (double x = playerX - 3; x <= playerX + 3; x++) {
            for (double y = playerY - 3; y <= playerY + 3; y++) {
                for (double z = playerZ - 3; z <= playerZ + 3; z++) {
                    Location loc = new Location(world, x, y, z);
                    world.spawnParticle(Particle.FLAME, loc, 1);
                }
            }
        }
    }
    @EventHandler
    public void onplayer(PlayerInteractEvent e){
        Player player = e.getPlayer();
        ItemStack itemStack = e.getItem();
        if(e.getItem() != null && e.getAction() == Action.RIGHT_CLICK_AIR && itemStack.getItemMeta().hasCustomModelData() && itemStack.getItemMeta().getCustomModelData() == 1011){
            spawnFireParticlesAroundPlayer(player);
            for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
                if (entity instanceof LivingEntity) {

                    entity.setFireTicks(100);
                    player.playSound(player, Sound.ENTITY_BLAZE_SHOOT, 100, 100);
                }
            }

        }

    }
}