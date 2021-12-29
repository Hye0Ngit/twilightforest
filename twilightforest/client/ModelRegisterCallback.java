// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public interface ModelRegisterCallback
{
    @SideOnly(Side.CLIENT)
    default void registerModel() {
        if (this instanceof Item) {
            ModelLoader.setCustomModelResourceLocation((Item)this, 0, new ModelResourceLocation(((Item)this).getRegistryName(), "inventory"));
        }
        else if (this instanceof Block) {
            ModelUtils.registerToState((Block)this, 0, ((Block)this).func_176223_P());
        }
    }
    
    public static class SingleStateMapper extends StateMapperBase
    {
        private final ModelResourceLocation location;
        
        public SingleStateMapper(final ModelResourceLocation location) {
            this.location = location;
        }
        
        protected ModelResourceLocation func_178132_a(final IBlockState state) {
            return this.location;
        }
    }
}
