// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Blocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.Mirror;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import twilightforest.util.ColorUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.DyeColor;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.block.Block;
import java.util.Set;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.StructurePiece;

public abstract class TFStructureComponent extends StructurePiece
{
    public TFStructureDecorator deco;
    public int spawnListIndex;
    protected TFFeature feature;
    private static final Set<Block> BLOCKS_NEEDING_POSTPROCESSING;
    
    public TFStructureComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.deco = null;
        this.spawnListIndex = 0;
        this.feature = TFFeature.NOTHING;
        this.spawnListIndex = nbt.func_74762_e("si");
        this.deco = TFStructureDecorator.getDecoFor(nbt.func_74779_i("deco"));
        this.field_186169_c = Rotation.NONE;
        this.field_186169_c = Rotation.values()[nbt.func_74762_e("rot") % Rotation.values().length];
    }
    
    public TFStructureComponent(final IStructurePieceType type, final int i) {
        super(type, i);
        this.deco = null;
        this.spawnListIndex = 0;
        this.feature = TFFeature.NOTHING;
        this.field_186169_c = Rotation.NONE;
    }
    
    public TFStructureComponent(final IStructurePieceType type, final TFFeature feature, final int i) {
        this(type, i);
        this.feature = feature;
    }
    
    public TFFeature getFeatureType() {
        return this.feature;
    }
    
    protected static boolean shouldDebug() {
        return false;
    }
    
    protected void setDebugCorners(final World world) {
        if (this.field_186169_c == null) {
            this.field_186169_c = Rotation.NONE;
        }
        if (shouldDebug()) {
            final int i = this.field_186169_c.ordinal() * 4;
            final DyeColor[] colors = DyeColor.values();
            world.func_175656_a(new BlockPos(this.func_74874_b().field_78897_a, this.func_74874_b().field_78894_e + i, this.func_74874_b().field_78896_c), ColorUtil.WOOL.getColor(colors[i]));
            world.func_175656_a(new BlockPos(this.func_74874_b().field_78893_d, this.func_74874_b().field_78894_e + i + 1, this.func_74874_b().field_78896_c), ColorUtil.WOOL.getColor(colors[1 + i]));
            world.func_175656_a(new BlockPos(this.func_74874_b().field_78897_a, this.func_74874_b().field_78894_e + i + 2, this.func_74874_b().field_78892_f), ColorUtil.WOOL.getColor(colors[2 + i]));
            world.func_175656_a(new BlockPos(this.func_74874_b().field_78893_d, this.func_74874_b().field_78894_e + i + 3, this.func_74874_b().field_78892_f), ColorUtil.WOOL.getColor(colors[3 + i]));
        }
    }
    
    protected void setDebugEntity(final ISeedReader world, final int x, final int y, final int z, final MutableBoundingBox sbb, final String s) {
        this.setInvisibleTextEntity(world, x, y, z, sbb, s, shouldDebug(), 0.0f);
    }
    
    protected void setInvisibleTextEntity(final ISeedReader world, final int x, final int y, final int z, final MutableBoundingBox sbb, final String s, final boolean forcePlace, final float additionalYOffset) {
        if (forcePlace) {
            final BlockPos pos = new BlockPos(this.func_74865_a(x, z), this.func_74862_a(y), this.func_74873_b(x, z));
            if (sbb.func_175898_b((Vector3i)pos)) {
                final ArmorStandEntity armorStand = new ArmorStandEntity(EntityType.field_200789_c, (World)world.func_201672_e());
                armorStand.func_200203_b((ITextComponent)new StringTextComponent(s));
                armorStand.func_70012_b(pos.func_177958_n() + 0.5, (double)(pos.func_177956_o() + additionalYOffset), pos.func_177952_p() + 0.5, 0.0f, 0.0f);
                armorStand.func_184224_h(true);
                armorStand.func_82142_c(true);
                armorStand.func_174805_g(true);
                armorStand.func_174810_b(true);
                armorStand.func_189654_d(true);
                armorStand.func_184212_Q().func_187227_b(ArmorStandEntity.field_184801_a, (Object)(byte)((byte)armorStand.func_184212_Q().func_187225_a(ArmorStandEntity.field_184801_a) | 0x10));
                world.func_217376_c((Entity)armorStand);
            }
        }
    }
    
    protected void func_175811_a(final ISeedReader worldIn, BlockState blockstateIn, final int x, final int y, final int z, final MutableBoundingBox boundingboxIn) {
        final BlockPos blockpos = new BlockPos(this.func_74865_a(x, z), this.func_74862_a(y), this.func_74873_b(x, z));
        if (boundingboxIn.func_175898_b((Vector3i)blockpos)) {
            if (this.field_186168_b != Mirror.NONE) {
                blockstateIn = blockstateIn.func_185902_a(this.field_186168_b);
            }
            if (this.field_186169_c != Rotation.NONE) {
                blockstateIn = blockstateIn.func_185907_a(this.field_186169_c);
            }
            worldIn.func_180501_a(blockpos, blockstateIn, 2);
            final FluidState fluidstate = worldIn.func_204610_c(blockpos);
            if (!fluidstate.func_206888_e()) {
                worldIn.func_205219_F_().func_205360_a(blockpos, (Object)fluidstate.func_206886_c(), 0);
            }
            if (TFStructureComponent.BLOCKS_NEEDING_POSTPROCESSING.contains(blockstateIn.func_177230_c())) {
                worldIn.func_217349_x(blockpos).func_201594_d(blockpos);
            }
        }
    }
    
    protected void setDebugEntity(final World world, final BlockPos blockpos, final String s) {
        if (shouldDebug()) {
            final SheepEntity sheep = new SheepEntity(EntityType.field_200737_ac, world);
            sheep.func_200203_b((ITextComponent)new StringTextComponent(s));
            sheep.func_94061_f(true);
            sheep.func_70012_b(blockpos.func_177958_n() + 0.5, (double)(blockpos.func_177956_o() + 10), blockpos.func_177952_p() + 0.5, 0.0f, 0.0f);
            sheep.func_184224_h(true);
            sheep.func_82142_c(true);
            sheep.func_174805_g(true);
            sheep.func_174810_b(true);
            sheep.func_189654_d(true);
            world.func_217376_c((Entity)sheep);
        }
    }
    
    protected void func_143011_b(final CompoundNBT tagCompound) {
        tagCompound.func_74768_a("si", this.spawnListIndex);
        tagCompound.func_74778_a("deco", TFStructureDecorator.getDecoString(this.deco));
        tagCompound.func_74768_a("rot", this.field_186169_c.ordinal());
    }
    
    public boolean isComponentProtected() {
        return true;
    }
    
    static {
        BLOCKS_NEEDING_POSTPROCESSING = (Set)ImmutableSet.builder().add((Object)Blocks.field_150386_bk).add((Object)Blocks.field_150478_aa).add((Object)Blocks.field_196591_bQ).add((Object)Blocks.field_180407_aO).add((Object)Blocks.field_180408_aP).add((Object)Blocks.field_180406_aS).add((Object)Blocks.field_180405_aT).add((Object)Blocks.field_180404_aQ).add((Object)Blocks.field_180403_aR).add((Object)Blocks.field_150468_ap).add((Object)Blocks.field_150411_aY).add((Object)Blocks.field_150410_aZ).add((Object)Blocks.field_150476_ad).add((Object)Blocks.field_150485_bF).add((Object)Blocks.field_150487_bG).add((Object)Blocks.field_150463_bK).add((Object)Blocks.field_150419_aX).add((Object)Blocks.field_150420_aW).add((Object)Blocks.field_150488_af).add((Object)Blocks.field_150473_bD).add((Object)Blocks.field_150479_bC).add((Object)Blocks.field_150486_ae).add((Object)Blocks.field_150447_bR).add((Object)Blocks.field_150390_bg).add((Object)Blocks.field_150353_l).add((Object)Blocks.field_150355_j).add((Object)TFBlocks.castle_stairs_brick.get()).add((Object)TFBlocks.force_field_blue.get()).add((Object)TFBlocks.force_field_green.get()).add((Object)TFBlocks.force_field_pink.get()).add((Object)TFBlocks.force_field_purple.get()).add((Object)TFBlocks.force_field_orange.get()).add((Object)TFBlocks.brown_thorns.get()).add((Object)TFBlocks.green_thorns.get()).build();
    }
}
