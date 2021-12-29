// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockFence;

public class BlockTFFence extends BlockFence implements ModelRegisterCallback
{
    public BlockTFFence(final Material materialIn, final MapColor mapColorIn) {
        super(materialIn, mapColorIn);
    }
    
    public Block func_149672_a(final SoundType sound) {
        return super.func_149672_a(sound);
    }
}
