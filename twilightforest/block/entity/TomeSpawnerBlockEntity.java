// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import java.util.Iterator;
import java.util.Optional;
import twilightforest.entity.TFEntities;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.TomeSpawnerBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

public class TomeSpawnerBlockEntity extends BlockEntity
{
    private int elapsedTime;
    private String entityType;
    private int tomesLeft;
    private int spawnTime;
    private int playerDistance;
    
    public TomeSpawnerBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.TOME_SPAWNER.get(), pos, state);
        if (state.m_61143_((Property)TomeSpawnerBlock.SPAWNER)) {
            this.entityType = "twilightforest:death_tome";
            this.tomesLeft = 5;
            this.spawnTime = 400;
            this.playerDistance = 8;
        }
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final TomeSpawnerBlockEntity te) {
        if (!level.f_46443_ && level.m_46791_() != Difficulty.PEACEFUL) {
            if (te.tomesLeft > 10) {
                te.tomesLeft = 10;
            }
            if (te.isNearPlayer(level, pos)) {
                if (te.elapsedTime < te.spawnTime) {
                    ++te.elapsedTime;
                }
                else {
                    te.elapsedTime = 0;
                    te.attemptSpawnTome((ServerLevel)level, pos, false);
                }
            }
            if (te.tomesLeft <= 0) {
                te.invalidateCaps();
                level.m_46597_(pos, ((Block)TFBlocks.EMPTY_CANOPY_BOOKSHELF.get()).m_49966_());
            }
            else {
                level.m_46597_(pos, (BlockState)state.m_61124_((Property)TomeSpawnerBlock.BOOK_STAGES, (Comparable)te.tomesLeft));
            }
        }
    }
    
    public void attemptSpawnTome(final ServerLevel level, final BlockPos pos, final boolean fire) {
        final Optional<EntityType<?>> mob = EntityType.m_20632_(this.entityType);
        boolean spawnedOne = false;
        for (final Direction dir : Direction.Plane.HORIZONTAL) {
            if (level.m_46859_(pos.m_142300_(dir))) {
                for (int i = 0; i < 5; ++i) {
                    final double x = pos.m_142300_(dir).m_123341_() + (level.f_46441_.nextDouble() - level.f_46441_.nextDouble()) * 2.0;
                    final double y = pos.m_123342_() + (level.f_46441_.nextDouble() - level.f_46441_.nextDouble());
                    final double z = pos.m_142300_(dir).m_123343_() + (level.f_46441_.nextDouble() - level.f_46441_.nextDouble()) * 2.0;
                    if (level.m_45772_(mob.orElse(TFEntities.DEATH_TOME).m_20585_(x, y, z)) && mob.isPresent()) {
                        final Entity entity = mob.orElse(TFEntities.DEATH_TOME).m_20615_((Level)level);
                        entity.m_20035_(new BlockPos(x, y, z), entity.m_146908_(), entity.m_146909_());
                        if (fire) {
                            entity.m_20254_(10);
                        }
                        level.m_7967_(entity);
                        --this.tomesLeft;
                        spawnedOne = true;
                        break;
                    }
                }
            }
            if (spawnedOne) {
                break;
            }
        }
    }
    
    private boolean isNearPlayer(final Level pLevel, final BlockPos pPos) {
        return pLevel.m_45914_(pPos.m_123341_() + 0.5, pPos.m_123342_() + 0.5, pPos.m_123343_() + 0.5, (double)this.playerDistance);
    }
    
    public CompoundTag m_6945_(final CompoundTag tag) {
        super.m_6945_(tag);
        tag.m_128359_("EntityType", this.entityType);
        tag.m_128405_("MobSpawnsLeft", this.tomesLeft);
        tag.m_128405_("SpawnDelay", this.spawnTime);
        tag.m_128405_("MaxPlayerDistance", this.playerDistance);
        return tag;
    }
    
    public void m_142466_(final CompoundTag tag) {
        super.m_142466_(tag);
        this.entityType = tag.m_128461_("EntityType");
        this.tomesLeft = tag.m_128451_("MobSpawnsLeft");
        this.spawnTime = tag.m_128451_("SpawnDelay");
        this.playerDistance = tag.m_128451_("MaxPlayerDistance");
    }
}
