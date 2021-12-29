// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockPlanks;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockFenceGate;

public class BlockTFFenceGate extends BlockFenceGate implements ModelRegisterCallback
{
    public BlockTFFenceGate(final BlockPlanks.EnumType plankEnum) {
        super(plankEnum);
    }
    
    public Block func_149672_a(final SoundType sound) {
        return super.func_149672_a(sound);
    }
}
