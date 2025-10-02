package github.arumisia.random_mob_ore.item;

import github.arumisia.random_mob_ore.Random_Mob_Ore;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RMO_Item {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Random_Mob_Ore.MODID);

    public static final RegistryObject<Item> RANDOM_SWORD = ITEMS.register("random_sword",
            () -> new SwordItem(Tiers.IRON, 3, -2.4F, new Item.Properties()
                    .durability(300)
                    .rarity(Rarity.COMMON)
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
