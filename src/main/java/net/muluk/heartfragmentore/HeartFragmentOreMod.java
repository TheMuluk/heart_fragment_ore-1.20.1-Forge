package net.muluk.heartfragmentore;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.muluk.heartfragmentore.block.ModBlocks;
import net.muluk.heartfragmentore.item.ModItems;
import sfiomn.legendarysurvivaloverhaul.registry.CreativeTabRegistry;

@Mod(HeartFragmentOreMod.MOD_ID)
public final class HeartFragmentOreMod {
    public static final String MOD_ID = "heartfragmentore";

    public HeartFragmentOreMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == CreativeTabRegistry.LEGENDARY_CREATURES_TAB.get()) {
            event.accept(ModBlocks.HEART_FRAGMENT_ORE);
            event.accept(ModBlocks.DEEPSLATE_HEART_FRAGMENT_ORE);
        }
    }
}
