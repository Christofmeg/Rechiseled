package com.supermartijn642.rechiseled.data;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Created 7/8/2021 by SuperMartijn642
 */
public class RechiseledItemModelProvider extends ItemModelProvider {

    public RechiseledItemModelProvider(GatherDataEvent e, ExistingFileHelper existingFileHelper){
        super(e.getGenerator(), "rechiseled", existingFileHelper);
    }

    @Override
    protected void registerModels(){
        ForgeRegistries.BLOCKS.getValues().stream()
            .filter(block -> block.getRegistryName().getNamespace().equals("rechiseled"))
            .forEach(
                block -> this.withExistingParent(
                    "item/" + block.getRegistryName().getPath(),
                    new ResourceLocation("rechiseled", "block/" + block.getRegistryName().getPath())
                )
            );
    }

    @Override
    public String getName(){
        return "Item Models: Rechiseled";
    }
}
