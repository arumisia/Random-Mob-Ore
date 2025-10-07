package github.arumisia.random_mob_ore.enchant;

import github.arumisia.random_mob_ore.Random_Mob_Ore;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Random_Ore_Enchantment {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Random_Mob_Ore.MODID);

    public static final RegistryObject<Enchantment> RANDOM_ORE =
            ENCHANTMENTS.register("random_ore",Random_Ore::new);

    public static void register(IEventBus eventBus){
        ENCHANTMENTS.register(eventBus);
    }
}
