package github.arumisia.random_mob_ore.item;


import github.arumisia.random_mob_ore.Random_Mob_Ore;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class RMO_TAB {

    public static final DeferredRegister<CreativeModeTab> TABS
            = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Random_Mob_Ore.MODID);

    public static final RegistryObject<CreativeModeTab> RMO_TAB = TABS.register("rmo_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.rmo_tab"))
                    .icon(RMO_Item.RANDOM_SWORD.get()::getDefaultInstance)
                    .displayItems((p_270258_, p_259752_) -> {
                        p_259752_.accept(RMO_Item.RANDOM_SWORD.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }
}
