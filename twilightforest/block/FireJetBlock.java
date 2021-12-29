// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import twilightforest.block.entity.FireJetBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import twilightforest.data.FluidTagGenerator;
import net.minecraft.tags.Tag;
import twilightforest.data.BlockTagGenerator;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import java.util.Random;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import twilightforest.enums.FireJetVariant;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.BaseEntityBlock;

public class FireJetBlock extends BaseEntityBlock
{
    public static final EnumProperty<FireJetVariant> STATE;
    
    protected FireJetBlock(final BlockBehaviour.Properties props) {
        super(props);
        this.m_49959_((BlockState)this.m_49966_().m_61124_((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.IDLE));
    }
    
    public RenderShape m_7514_(final BlockState p_49232_) {
        return RenderShape.MODEL;
    }
    
    protected void m_7926_(final StateDefinition.Builder<Block, BlockState> builder) {
        super.m_7926_((StateDefinition.Builder)builder);
        builder.m_61104_(new Property[] { (Property)FireJetBlock.STATE });
    }
    
    @Nullable
    public BlockPathTypes getAiPathNodeType(final BlockState state, final BlockGetter world, final BlockPos pos, @Nullable final Mob entity) {
        return (state.m_61143_((Property)FireJetBlock.STATE) == FireJetVariant.IDLE) ? null : BlockPathTypes.DAMAGE_FIRE;
    }
    
    @Deprecated
    public void m_7455_(final BlockState state, final ServerLevel world, final BlockPos pos, final Random random) {
        if (!world.f_46443_ && state.m_61143_((Property)FireJetBlock.STATE) == FireJetVariant.IDLE) {
            final BlockPos lavaPos = this.findLavaAround((Level)world, pos.m_7495_());
            if (this.isLava((Level)world, lavaPos)) {
                world.m_46597_(lavaPos, Blocks.f_50016_.m_49966_());
                world.m_46597_(pos, (BlockState)state.m_61124_((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.POPPING));
            }
        }
    }
    
    private BlockPos findLavaAround(final Level world, final BlockPos pos) {
        if (this.isLava(world, pos)) {
            return pos;
        }
        for (int i = 0; i < 3; ++i) {
            final BlockPos randPos = pos.m_142082_(world.f_46441_.nextInt(3) - 1, 0, world.f_46441_.nextInt(3) - 1);
            if (this.isLava(world, randPos)) {
                return randPos;
            }
        }
        return pos;
    }
    
    private boolean isLava(final Level world, final BlockPos pos) {
        final BlockState state = world.m_8055_(pos);
        return state.m_60620_((Tag)BlockTagGenerator.FIRE_JET_FUEL) || state.m_60734_().m_5888_(state).m_76153_((Tag)FluidTagGenerator.FIRE_JET_FUEL);
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return new FireJetBlockEntity(pos, state);
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level level, final BlockState state, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)m_152132_((BlockEntityType)type, (BlockEntityType)TFBlockEntities.FLAME_JET.get(), FireJetBlockEntity::tick);
    }
    
    static {
        STATE = EnumProperty.m_61587_("state", (Class)FireJetVariant.class);
    }
}
