package github.arumisia.random_mob_ore;


import github.arumisia.random_mob_ore.item.RMO_Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = Random_Mob_Ore.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RMO_ServerEvent {

    private static final Random RANDOM = new Random();

    private static final TagKey<Item> ORES_TAG = ItemTags.create(new ResourceLocation("forge", "ores"));

    private static final String DIAMOND_ORE_ID = "diamond_ore";

    private static final String ANCIENT_DEBRIS_ID = "ancient_debris";

    public RMO_ServerEvent() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void MobDead(LivingDropsEvent event) {
        LivingEntity entity = event.getEntity();

        if (entity.getKillCredit() instanceof Player player) {
            ItemStack heldItem = player.getMainHandItem();

            if (entity instanceof Player) { return; }

            if(heldItem.is(RMO_Item.RANDOM_SWORD.get())){
                List<Item> oreItems = entity.level()
                        .registryAccess()
                        .registryOrThrow(net.minecraft.core.registries.Registries.ITEM)
                        .stream()
                        .filter(item -> item.builtInRegistryHolder().is(ORES_TAG))
                        .collect(Collectors.toList());

                if (!oreItems.isEmpty()) {
                    Item oreItem = oreItems.get(RANDOM.nextInt(oreItems.size()));

                    String path = net.minecraft.core.registries.BuiltInRegistries.ITEM.getKey(oreItem).getPath();

                    ItemStack stack = new ItemStack(oreItem, 1);

                    if (path.contains(DIAMOND_ORE_ID)) {
                        if (RANDOM.nextFloat() >= 0.05F) {//5%
                            return;
                        }
                    }
                    if (path.contains(ANCIENT_DEBRIS_ID)) {
                        if (RANDOM.nextFloat() >= 0.05F) {
                            return;
                        }
                    }

                    ItemEntity drop = new ItemEntity(
                            entity.level(),
                            entity.getX(),
                            entity.getY(),
                            entity.getZ(),
                            stack
                    );
                    event.getDrops().add(drop);
                }
            }
        }
    }
}
