package org.super89.supermegamod.magic;



import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;







public class PlayerDataController implements Listener {

    String bottle3 = "\uE026";
    String bottle2 = "\uE025";
    String bottle = "\uE024";





    private final Magic plugin;

    public PlayerDataController(Magic plugin){this.plugin=plugin;}

    String bottlefull3 = bottle3;
    String bottlefull2 = bottle2;
    String bottlefull = bottle;

    public int getNowPlayerMana(Player player) {
         NamespacedKey thristKey = new NamespacedKey(plugin, "thrist");
         NamespacedKey manaKey = new NamespacedKey(plugin, "mana");
         NamespacedKey kritKey = new NamespacedKey(plugin, "krit");
        PersistentDataContainer con = player.getPersistentDataContainer();
        return con.get(manaKey, PersistentDataType.INTEGER);
    }
    public void setNowPlayerMana(Player player, int mana) {
        NamespacedKey thristKey = new NamespacedKey(plugin, "thrist");
        NamespacedKey manaKey = new NamespacedKey(plugin, "mana");
        NamespacedKey kritKey = new NamespacedKey(plugin, "krit");
        PersistentDataContainer con = player.getPersistentDataContainer();
        con.set(manaKey, PersistentDataType.INTEGER, mana);
    }
    public void setNowPlayerThrist(Player player, int thrist) {
        NamespacedKey thristKey = new NamespacedKey(plugin, "thrist");
        NamespacedKey manaKey = new NamespacedKey(plugin, "mana");
        NamespacedKey kritKey = new NamespacedKey(plugin, "krit");
        PersistentDataContainer con = player.getPersistentDataContainer();
        con.set(thristKey, PersistentDataType.INTEGER, thrist);

    }
    public int getNowPlayerThrist(Player player) {
        NamespacedKey thristKey = new NamespacedKey(plugin, "thrist");
        NamespacedKey manaKey = new NamespacedKey(plugin, "mana");
        NamespacedKey kritKey = new NamespacedKey(plugin, "krit");
        PersistentDataContainer con = player.getPersistentDataContainer();
        return con.get(thristKey, PersistentDataType.INTEGER);
    }
    public int getNowPlayerState(Player player) {
        NamespacedKey thristKey = new NamespacedKey(plugin, "thrist");
        NamespacedKey manaKey = new NamespacedKey(plugin, "mana");
        NamespacedKey kritKey = new NamespacedKey(plugin, "krit");
        PersistentDataContainer con = player.getPersistentDataContainer();
        return con.get(kritKey, PersistentDataType.INTEGER);
    }


    public int getMaxPlayerMana(Player player) {
        return 100;
    }

        public void setNowPlayerPkm(Player player, int ostatokprm) {
            NamespacedKey thristKey = new NamespacedKey(plugin, "thrist");
            NamespacedKey manaKey = new NamespacedKey(plugin, "mana");
            NamespacedKey kritKey = new NamespacedKey(plugin.getPlugin(), "krit");
            PersistentDataContainer con = player.getPersistentDataContainer();

            con.set(kritKey, PersistentDataType.INTEGER, ostatokprm);
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        NamespacedKey thristKey = new NamespacedKey(plugin, "thrist");
        NamespacedKey manaKey = new NamespacedKey(plugin, "mana");
        NamespacedKey kritKey = new NamespacedKey(plugin, "krit");
        Player player = event.getPlayer();



        PersistentDataContainer con = player.getPersistentDataContainer();
        if (!player.hasPlayedBefore()) {
            con.set(thristKey, PersistentDataType.INTEGER, 20);
            con.set(manaKey, PersistentDataType.INTEGER, 0);
            con.set(kritKey, PersistentDataType.INTEGER, -1);
        }
        if(player.getName().equals("Super89") || player.getName().equals("Stylkye")){
            con.set(manaKey, PersistentDataType.INTEGER, 10000);
        }

    }
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event){
        ItemStack item = event.getItem();
        Player player = event.getPlayer();
        if(item.hasItemMeta() && item.getItemMeta() instanceof PotionMeta) {
            PotionMeta meta = (PotionMeta) item.getItemMeta();
            if(meta.getBasePotionType().equals(PotionType.WATER) || meta.getBasePotionType().equals(PotionType.AWKWARD) || meta.getBasePotionType().equals(PotionType.MUNDANE) && getNowPlayerThrist(player) < 20){
                player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 25 * 20, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 25 * 20, 2));
                setNowPlayerThrist(player, Math.min(getNowPlayerThrist(player) + 1, 20));

            }
            if(meta.hasCustomModelData() && meta.getCustomModelData() == 2030 && getNowPlayerThrist(player) < 20){
                setNowPlayerThrist(player, Math.min(getNowPlayerThrist(player) + 4, 20));
            }
            if(meta.hasCustomModelData() && meta.getCustomModelData() == 2031 && getNowPlayerThrist(player) < 20){
                setNowPlayerThrist(player, Math.min(getNowPlayerThrist(player) + 6, 20));
                player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 100 * 20, 10, false,false,false));
            }

        }
    }
    public String calculatePlayerThirst(Player player){
        switch (getNowPlayerThrist(player)){
            case 0:
                return bottlefull3+bottlefull3+bottlefull3+bottlefull3+bottlefull3+bottlefull3+bottlefull3+bottlefull3+bottlefull3+bottlefull3;
            case 1:
                return bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull2;
            case 2:
                return bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull;
            case 3:
                return bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull2+ bottlefull;
            case 4:
                return bottlefull3+ bottlefull3+ bottlefull3 +bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull+ bottlefull;
            case 5:
                return bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3 +bottlefull3 +bottlefull3 +bottlefull3+ bottlefull2+ bottlefull+ bottlefull;
            case 6:
                return bottlefull3+ bottlefull3 +bottlefull3 +bottlefull3 +bottlefull3 +bottlefull3+ bottlefull3+ bottlefull+ bottlefull +bottlefull;
            case 7:
                return bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3 +bottlefull3 +bottlefull3+bottlefull2+ bottlefull +bottlefull +bottlefull;
            case 8:
                return bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+bottlefull3+ bottlefull3+ bottlefull+ bottlefull+ bottlefull+ bottlefull;
            case 9:
                return bottlefull3 +bottlefull3+ bottlefull3 +bottlefull3+ bottlefull3+ bottlefull2 +bottlefull+ bottlefull+ bottlefull+bottlefull;
            case 10:
                return bottlefull3+bottlefull3 +bottlefull3 +bottlefull3 +bottlefull3+ bottlefull +bottlefull +bottlefull +bottlefull +bottlefull;
            case  11:
                return bottlefull3+ bottlefull3+bottlefull3+ bottlefull3+ bottlefull2+ bottlefull+ bottlefull+ bottlefull+ bottlefull +bottlefull;
            case  12:
                return bottlefull3+ bottlefull3+ bottlefull3+ bottlefull3+ bottlefull+ bottlefull +bottlefull+bottlefull+ bottlefull+ bottlefull;
            case 13:
                return bottlefull3+ bottlefull3+ bottlefull3+ bottlefull2+ bottlefull+ bottlefull+ bottlefull+ bottlefull+ bottlefull+ bottlefull;
            case 14:
                return bottlefull3+ bottlefull3+bottlefull3+ bottlefull+ bottlefull+ bottlefull+ bottlefull+ bottlefull+ bottlefull+ bottlefull;
            case 15:
                return bottlefull3+ bottlefull3+ bottlefull2+ bottlefull+ bottlefull +bottlefull+ bottlefull+ bottlefull+ bottlefull+bottlefull;
            case 16:
                return bottlefull3+ bottlefull3+bottlefull+ bottlefull+ bottlefull+bottlefull+ bottlefull +bottlefull+ bottlefull+ bottlefull;
            case 17:
                return bottlefull3+ bottlefull2+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull;
            case 18:
                return bottlefull3+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull;
            case 19:
               return bottlefull2+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull;
            default:
                return bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull+bottlefull;
        }

    }
    @EventHandler
    public void playerDeath(PlayerDeathEvent event){
        setNowPlayerThrist(event.getPlayer(), 20);
    }

}
