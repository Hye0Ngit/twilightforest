// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.IDataProvider;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent evt) {
        evt.getGenerator().func_200390_a((IDataProvider)new BlockstateGenerator(evt.getGenerator(), evt.getExistingFileHelper()));
        evt.getGenerator().func_200390_a((IDataProvider)new ItemModelGenerator(evt.getGenerator(), evt.getExistingFileHelper()));
        final BlockTagsProvider blocktags = new BlockTagGenerator(evt.getGenerator(), evt.getExistingFileHelper());
        evt.getGenerator().func_200390_a((IDataProvider)blocktags);
        evt.getGenerator().func_200390_a((IDataProvider)new FluidTagGenerator(evt.getGenerator(), evt.getExistingFileHelper()));
        evt.getGenerator().func_200390_a((IDataProvider)new ItemTagGenerator(evt.getGenerator(), blocktags, evt.getExistingFileHelper()));
        evt.getGenerator().func_200390_a((IDataProvider)new LootGenerator(evt.getGenerator()));
        evt.getGenerator().func_200390_a((IDataProvider)new StonecuttingGenerator(evt.getGenerator()));
        evt.getGenerator().func_200390_a((IDataProvider)new CraftingGenerator(evt.getGenerator()));
        evt.getGenerator().func_200390_a((IDataProvider)new TwilightWorldDataCompiler(evt.getGenerator()));
    }
}
