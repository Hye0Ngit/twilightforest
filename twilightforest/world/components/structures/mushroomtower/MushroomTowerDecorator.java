// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.mushroomtower;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import twilightforest.world.components.structures.TFStructureDecorator;

public class MushroomTowerDecorator extends TFStructureDecorator
{
    public MushroomTowerDecorator() {
        this.blockState = (BlockState)((BlockState)Blocks.f_50182_.m_49966_().m_61124_((Property)HugeMushroomBlock.f_54131_, (Comparable)false)).m_61124_((Property)HugeMushroomBlock.f_54132_, (Comparable)false);
        this.accentState = Blocks.f_50181_.m_49966_();
        this.fenceState = Blocks.f_50132_.m_49966_();
        this.stairState = Blocks.f_50269_.m_49966_();
        this.pillarState = (BlockState)((BlockState)Blocks.f_50182_.m_49966_().m_61124_((Property)HugeMushroomBlock.f_54131_, (Comparable)false)).m_61124_((Property)HugeMushroomBlock.f_54132_, (Comparable)false);
        this.floorState = Blocks.f_50705_.m_49966_();
    }
}
