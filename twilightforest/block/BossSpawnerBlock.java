// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import twilightforest.block.entity.spawner.BossSpawnerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.BlockGetter;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import twilightforest.enums.BossVariant;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.BaseEntityBlock;

public class BossSpawnerBlock extends BaseEntityBlock
{
    private static final VoxelShape CHUNGUS;
    private final BossVariant boss;
    
    protected BossSpawnerBlock(final BlockBehaviour.Properties props, final BossVariant variant) {
        super(props);
        this.boss = variant;
    }
    
    public RenderShape m_7514_(final BlockState p_49232_) {
        return RenderShape.MODEL;
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return this.boss.getType().m_155264_(pos, state);
    }
    
    public VoxelShape m_5940_(final BlockState state, final BlockGetter blockGetter, final BlockPos pos, final CollisionContext context) {
        return BossSpawnerBlock.CHUNGUS;
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level p_153212_, final BlockState p_153213_, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)m_152132_((BlockEntityType)type, (BlockEntityType)this.boss.getType(), BossSpawnerBlockEntity::tick);
    }
    
    public boolean canEntityDestroy(final BlockState state, final BlockGetter world, final BlockPos pos, final Entity entity) {
        return state.m_60800_(world, pos) >= 0.0f;
    }
    
    static {
        CHUNGUS = Block.m_49796_(-4.0, -4.0, -4.0, 20.0, 20.0, 20.0);
    }
}
