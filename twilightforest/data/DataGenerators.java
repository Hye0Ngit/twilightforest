// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest", bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent evt) {
        final DataGenerator generator = evt.getGenerator();
        final ExistingFileHelper helper = evt.getExistingFileHelper();
        generator.m_123914_((DataProvider)new AdvancementGenerator(generator, helper));
        generator.m_123914_((DataProvider)new PatchouliAdvancementGenerator(generator, helper));
        generator.m_123914_((DataProvider)new BlockstateGenerator(generator, helper));
        generator.m_123914_((DataProvider)new ItemModelGenerator(generator, helper));
        final BlockTagsProvider blocktags = new BlockTagGenerator(generator, helper);
        generator.m_123914_((DataProvider)blocktags);
        generator.m_123914_((DataProvider)new FluidTagGenerator(generator, helper));
        generator.m_123914_((DataProvider)new ItemTagGenerator(generator, blocktags, helper));
        generator.m_123914_((DataProvider)new EntityTagGenerator(generator, helper));
        generator.m_123914_((DataProvider)new CustomTagGenerator.EnchantmentTagGenerator(generator, helper));
        generator.m_123914_((DataProvider)new LootGenerator(generator));
        generator.m_123914_((DataProvider)new StonecuttingGenerator(generator));
        generator.m_123914_((DataProvider)new CraftingGenerator(generator));
        generator.m_123914_((DataProvider)new TwilightWorldDataCompiler(generator));
    }
}
