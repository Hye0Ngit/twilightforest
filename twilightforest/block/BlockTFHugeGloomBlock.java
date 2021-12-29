// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.BlockHugeMushroom;

public class BlockTFHugeGloomBlock extends BlockHugeMushroom implements ModelRegisterCallback
{
    public BlockTFHugeGloomBlock() {
        super(Material.field_151575_d, MapColor.field_151676_q, TFBlocks.twilight_plant);
        this.func_149711_c(0.2f);
        this.func_149672_a(SoundType.field_185848_a);
        this.func_149715_a(0.3125f);
    }
}
