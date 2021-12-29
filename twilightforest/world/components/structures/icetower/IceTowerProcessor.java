// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.icetower;

import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.AuroraBrickBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePiece;

public class IceTowerProcessor extends StructurePiece.BlockSelector
{
    public void m_7889_(final Random random, final int x, final int y, final int z, final boolean wall) {
        if (!wall) {
            this.f_73553_ = Blocks.f_50016_.m_49966_();
        }
        else {
            this.f_73553_ = (BlockState)((Block)TFBlocks.AURORA_BLOCK.get()).m_49966_().m_61124_((Property)AuroraBrickBlock.VARIANT, (Comparable)(Math.abs(x + z) % 16));
        }
    }
}
