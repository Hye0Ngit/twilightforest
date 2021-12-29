// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;

public class NagastonePillarBlock extends DirectionalRotatedPillarBlock
{
    protected NagastonePillarBlock() {
        super(AbstractBlock.Properties.func_200945_a(Material.field_151576_e).func_235861_h_().func_200948_a(1.5f, 10.0f).func_200947_a(SoundType.field_185851_d));
        this.func_180632_j((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)NagastonePillarBlock.field_176298_M, (Comparable)Direction.Axis.Y)).func_206870_a((Property)NagastonePillarBlock.REVERSED, (Comparable)false));
    }
}
