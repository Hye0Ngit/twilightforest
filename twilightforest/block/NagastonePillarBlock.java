// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class NagastonePillarBlock extends DirectionalRotatedPillarBlock
{
    protected NagastonePillarBlock() {
        super(BlockBehaviour.Properties.m_60939_(Material.f_76278_).m_60999_().m_60913_(1.5f, 10.0f).m_60918_(SoundType.f_56742_));
        this.m_49959_((BlockState)((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)NagastonePillarBlock.f_55923_, (Comparable)Direction.Axis.Y)).m_61124_((Property)NagastonePillarBlock.REVERSED, (Comparable)false));
    }
}
