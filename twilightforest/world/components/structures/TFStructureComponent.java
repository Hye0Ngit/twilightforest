// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Blocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.level.levelgen.feature.NoiseEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.util.ColorUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.world.level.block.Block;
import java.util.Set;
import twilightforest.world.registration.TFFeature;
import net.minecraft.world.level.levelgen.structure.StructurePiece;

@Deprecated
public abstract class TFStructureComponent extends StructurePiece implements TwilightFeature
{
    public TFStructureDecorator deco;
    public int spawnListIndex;
    @Deprecated
    private TFFeature feature;
    private static final Set<Block> BLOCKS_NEEDING_POSTPROCESSING;
    
    public TFStructureComponent(final StructurePieceType piece, final CompoundTag nbt) {
        super(piece, nbt);
        this.deco = null;
        this.spawnListIndex = 0;
        this.feature = TFFeature.NOTHING;
        this.spawnListIndex = nbt.m_128451_("si");
        this.deco = TFStructureDecorator.getDecoFor(nbt.m_128461_("deco"));
        this.f_73379_ = Rotation.NONE;
        this.f_73379_ = Rotation.values()[nbt.m_128451_("rot") % Rotation.values().length];
    }
    
    public TFStructureComponent(final StructurePieceType type, final int i, final BoundingBox boundingBox) {
        super(type, i, boundingBox);
        this.deco = null;
        this.spawnListIndex = 0;
        this.feature = TFFeature.NOTHING;
        this.f_73379_ = Rotation.NONE;
    }
    
    @Deprecated
    public TFStructureComponent(final StructurePieceType type, final TFFeature feature, final int i, final int x, final int y, final int z) {
        this(type, i, new BoundingBox(x, y, z, x, y, z));
        this.feature = feature;
    }
    
    @Deprecated
    public TFFeature getFeatureType() {
        return this.feature;
    }
    
    public void setFeature(final TFFeature type) {
        this.feature = type;
    }
    
    protected static boolean shouldDebug() {
        return false;
    }
    
    protected void setDebugCorners(final Level world) {
        if (this.f_73379_ == null) {
            this.f_73379_ = Rotation.NONE;
        }
        if (shouldDebug()) {
            final int i = this.f_73379_.ordinal() * 4;
            final DyeColor[] colors = DyeColor.values();
            world.m_46597_(new BlockPos(this.m_73547_().m_162395_(), this.m_73547_().m_162400_() + i, this.m_73547_().m_162398_()), ColorUtil.WOOL.getColor(colors[i]));
            world.m_46597_(new BlockPos(this.m_73547_().m_162399_(), this.m_73547_().m_162400_() + i + 1, this.m_73547_().m_162398_()), ColorUtil.WOOL.getColor(colors[1 + i]));
            world.m_46597_(new BlockPos(this.m_73547_().m_162395_(), this.m_73547_().m_162400_() + i + 2, this.m_73547_().m_162401_()), ColorUtil.WOOL.getColor(colors[2 + i]));
            world.m_46597_(new BlockPos(this.m_73547_().m_162399_(), this.m_73547_().m_162400_() + i + 3, this.m_73547_().m_162401_()), ColorUtil.WOOL.getColor(colors[3 + i]));
        }
    }
    
    protected void setDebugEntity(final WorldGenLevel world, final int x, final int y, final int z, final BoundingBox sbb, final String s) {
        this.setInvisibleTextEntity(world, x, y, z, sbb, s, shouldDebug(), 0.0f);
    }
    
    protected void setInvisibleTextEntity(final WorldGenLevel world, final int x, final int y, final int z, final BoundingBox sbb, final String s, final boolean forcePlace, final float additionalYOffset) {
        if (forcePlace) {
            final BlockPos pos = new BlockPos(this.m_73392_(x, z), this.m_73544_(y), this.m_73525_(x, z));
            if (sbb.m_71051_((Vec3i)pos)) {
                final ArmorStand armorStand = new ArmorStand(EntityType.f_20529_, (Level)world.m_6018_());
                armorStand.m_6593_((Component)new TextComponent(s));
                armorStand.m_7678_(pos.m_123341_() + 0.5, (double)(pos.m_123342_() + additionalYOffset), pos.m_123343_() + 0.5, 0.0f, 0.0f);
                armorStand.m_20331_(true);
                armorStand.m_6842_(true);
                armorStand.m_20340_(true);
                armorStand.m_20225_(true);
                armorStand.m_20242_(true);
                armorStand.m_20088_().m_135381_(ArmorStand.f_31524_, (Object)(byte)((byte)armorStand.m_20088_().m_135370_(ArmorStand.f_31524_) | 0x10));
                world.m_7967_((Entity)armorStand);
            }
        }
    }
    
    protected void m_73434_(final WorldGenLevel worldIn, BlockState blockstateIn, final int x, final int y, final int z, final BoundingBox boundingboxIn) {
        final BlockPos blockpos = new BlockPos(this.m_73392_(x, z), this.m_73544_(y), this.m_73525_(x, z));
        if (boundingboxIn.m_71051_((Vec3i)blockpos)) {
            if (this.f_73378_ != Mirror.NONE) {
                blockstateIn = blockstateIn.m_60715_(this.f_73378_);
            }
            if (this.f_73379_ != Rotation.NONE) {
                blockstateIn = blockstateIn.m_60717_(this.f_73379_);
            }
            worldIn.m_7731_(blockpos, blockstateIn, 2);
            final FluidState fluidstate = worldIn.m_6425_(blockpos);
            if (!fluidstate.m_76178_()) {
                worldIn.m_6217_().m_5945_(blockpos, (Object)fluidstate.m_76152_(), 0);
            }
            if (TFStructureComponent.BLOCKS_NEEDING_POSTPROCESSING.contains(blockstateIn.m_60734_())) {
                worldIn.m_46865_(blockpos).m_8113_(blockpos);
            }
        }
    }
    
    protected void setDebugEntity(final Level world, final BlockPos blockpos, final String s) {
        if (shouldDebug()) {
            final Sheep sheep = new Sheep(EntityType.f_20520_, world);
            sheep.m_6593_((Component)new TextComponent(s));
            sheep.m_21557_(true);
            sheep.m_7678_(blockpos.m_123341_() + 0.5, (double)(blockpos.m_123342_() + 10), blockpos.m_123343_() + 0.5, 0.0f, 0.0f);
            sheep.m_20331_(true);
            sheep.m_6842_(true);
            sheep.m_20340_(true);
            sheep.m_20225_(true);
            sheep.m_20242_(true);
            world.m_7967_((Entity)sheep);
        }
    }
    
    protected void m_142347_(final ServerLevel level, final CompoundTag tagCompound) {
        tagCompound.m_128405_("si", this.spawnListIndex);
        tagCompound.m_128359_("deco", TFStructureDecorator.getDecoString(this.deco));
        tagCompound.m_128405_("rot", this.f_73379_.ordinal());
    }
    
    public boolean isComponentProtected() {
        return true;
    }
    
    public NoiseEffect m_142318_() {
        return NoiseEffect.NONE;
    }
    
    static {
        BLOCKS_NEEDING_POSTPROCESSING = (Set)ImmutableSet.builder().add((Object)Blocks.f_50198_).add((Object)Blocks.f_50081_).add((Object)Blocks.f_50082_).add((Object)Blocks.f_50132_).add((Object)Blocks.f_50479_).add((Object)Blocks.f_50483_).add((Object)Blocks.f_50482_).add((Object)Blocks.f_50480_).add((Object)Blocks.f_50481_).add((Object)Blocks.f_50155_).add((Object)Blocks.f_50183_).add((Object)Blocks.f_50185_).add((Object)Blocks.f_50086_).add((Object)Blocks.f_50269_).add((Object)Blocks.f_50270_).add((Object)Blocks.f_50274_).add((Object)Blocks.f_50181_).add((Object)Blocks.f_50180_).add((Object)Blocks.f_50088_).add((Object)Blocks.f_50267_).add((Object)Blocks.f_50266_).add((Object)Blocks.f_50087_).add((Object)Blocks.f_50325_).add((Object)Blocks.f_50194_).add((Object)Blocks.f_49991_).add((Object)Blocks.f_49990_).add((Object)TFBlocks.CASTLE_BRICK_STAIRS.get()).add((Object)TFBlocks.BLUE_FORCE_FIELD.get()).add((Object)TFBlocks.GREEN_FORCE_FIELD.get()).add((Object)TFBlocks.PINK_FORCE_FIELD.get()).add((Object)TFBlocks.VIOLET_FORCE_FIELD.get()).add((Object)TFBlocks.ORANGE_FORCE_FIELD.get()).add((Object)TFBlocks.BROWN_THORNS.get()).add((Object)TFBlocks.GREEN_THORNS.get()).build();
    }
}
