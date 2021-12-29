// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.block.Block;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import twilightforest.client.ModelRegisterCallback;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockTFFluid extends BlockFluidClassic implements ModelRegisterCallback
{
    public BlockTFFluid(final Fluid fluid, final Material material) {
        super(fluid, material);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelLoader.setCustomStateMapper((Block)this, (IStateMapper)new SingleStateMapper(new ModelResourceLocation(this.getRegistryName(), "fluid")));
    }
}
