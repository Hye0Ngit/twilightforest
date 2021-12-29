// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.inventory;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.gui.ScreenManager;
import twilightforest.client.UncraftingGui;
import net.minecraftforge.fml.RegistryObject;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.registries.DeferredRegister;

public class TFContainers
{
    public static final DeferredRegister<ContainerType<?>> CONTAINERS;
    public static final RegistryObject<ContainerType<UncraftingContainer>> UNCRAFTING;
    
    @OnlyIn(Dist.CLIENT)
    public static void renderScreens() {
        ScreenManager.func_216911_a((ContainerType)TFContainers.UNCRAFTING.get(), UncraftingGui::new);
    }
    
    static {
        CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, "twilightforest");
        UNCRAFTING = TFContainers.CONTAINERS.register("uncrafting", () -> new ContainerType(UncraftingContainer::fromNetwork));
    }
}
