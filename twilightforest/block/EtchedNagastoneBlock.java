// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import javax.annotation.Nullable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.DirectionalBlock;

public class EtchedNagastoneBlock extends DirectionalBlock
{
    protected EtchedNagastoneBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)((BlockState)this.f_49792_.m_61090_()).m_61124_((Property)EtchedNagastoneBlock.f_52588_, (Comparable)Direction.DOWN));
    }
    
    @Nullable
    public BlockState m_5573_(final BlockPlaceContext context) {
        return (BlockState)this.m_49966_().m_61124_((Property)EtchedNagastoneBlock.f_52588_, (Comparable)((context.m_43723_() != null && context.m_43723_().m_6144_()) ? context.m_7820_().m_122424_() : context.m_7820_()));
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)EtchedNagastoneBlock.f_52588_ });
    }
    
    public BlockState m_6843_(final BlockState state, final Rotation rot) {
        return (BlockState)state.m_61124_((Property)EtchedNagastoneBlock.f_52588_, (Comparable)rot.m_55954_((Direction)state.m_61143_((Property)EtchedNagastoneBlock.f_52588_)));
    }
    
    public BlockState m_6943_(final BlockState state, final Mirror mirrorIn) {
        return (BlockState)state.m_61124_((Property)EtchedNagastoneBlock.f_52588_, (Comparable)mirrorIn.m_54848_((Direction)state.m_61143_((Property)EtchedNagastoneBlock.f_52588_)));
    }
}
