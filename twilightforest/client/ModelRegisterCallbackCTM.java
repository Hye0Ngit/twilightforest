// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import java.util.Map;
import java.util.HashMap;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.block.Block;

public interface ModelRegisterCallbackCTM extends ModelRegisterCallback
{
    @SideOnly(Side.CLIENT)
    default void registerModel() {
        ModelLoader.setCustomStateMapper((Block)this, (IStateMapper)new CTMOptionalStateMapper(this.getIgnoredProperties()));
        this.registerItemModel();
    }
    
    @SideOnly(Side.CLIENT)
    default void registerItemModel() {
        final Block block = (Block)this;
        ModelLoader.setCustomModelResourceLocation(Item.func_150898_a(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }
    
    @SideOnly(Side.CLIENT)
    default IProperty<?>[] getIgnoredProperties() {
        return (IProperty<?>[])new IProperty[0];
    }
    
    @SideOnly(Side.CLIENT)
    public static class CTMOptionalStateMapper extends StateMapperBase
    {
        private final IProperty<?>[] IGNORED_PROPERTIES;
        
        public CTMOptionalStateMapper(final IProperty<?>... ignoredProperties) {
            this.IGNORED_PROPERTIES = ignoredProperties;
        }
        
        protected ModelResourceLocation func_178132_a(final IBlockState state) {
            final HashMap<IProperty<?>, Comparable<?>> properties = new HashMap<IProperty<?>, Comparable<?>>((Map<? extends IProperty<?>, ? extends Comparable<?>>)state.func_177228_b());
            for (final IProperty<?> ignored : this.IGNORED_PROPERTIES) {
                properties.remove(ignored);
            }
            final boolean ctm = Loader.isModLoaded("ctm");
            if (properties.isEmpty()) {
                return new ModelResourceLocation((ResourceLocation)Block.field_149771_c.func_177774_c((Object)state.func_177230_c()), ctm ? "ctm" : "normal");
            }
            return new ModelResourceLocation(ctm ? (Block.field_149771_c.func_177774_c((Object)state.func_177230_c()) + "_ctm") : ((ResourceLocation)Block.field_149771_c.func_177774_c((Object)state.func_177230_c())).toString(), this.func_178131_a((Map)properties));
        }
    }
}
