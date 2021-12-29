// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.gui.screens.MenuScreens;
import twilightforest.client.UncraftingGui;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;

public class TFContainers
{
    public static final DeferredRegister<MenuType<?>> CONTAINERS;
    public static final RegistryObject<MenuType<UncraftingContainer>> UNCRAFTING;
    
    @OnlyIn(Dist.CLIENT)
    public static void renderScreens() {
        MenuScreens.m_96206_((MenuType)TFContainers.UNCRAFTING.get(), UncraftingGui::new);
    }
    
    static {
        CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, "twilightforest");
        UNCRAFTING = TFContainers.CONTAINERS.register("uncrafting", () -> new MenuType(UncraftingContainer::fromNetwork));
    }
}
