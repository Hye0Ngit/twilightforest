// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.state.IBlockState;
import twilightforest.block.BlockTFCastleDoor;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import twilightforest.block.BlockTFForceField;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFCastleMagic;
import twilightforest.block.TFBlocks;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFFinalCastleDungeonEntrance extends ComponentTFFinalCastleDungeonRoom31
{
    public boolean hasExit;
    
    public ComponentTFFinalCastleDungeonEntrance() {
        this.hasExit = false;
    }
    
    public ComponentTFFinalCastleDungeonEntrance(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final EnumFacing direction, final int level) {
        super(feature, rand, i, x, y, z, direction, level);
        this.hasExit = false;
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        this.deco = new StructureTFDecoratorCastle();
        this.deco.blockState = TFBlocks.castle_rune_brick.func_176223_P().func_177226_a((IProperty)BlockTFCastleMagic.COLOR, (Comparable)BlockTFCastleMagic.VALID_COLORS.get(2));
        this.deco.fenceState = TFBlocks.force_field.func_176223_P().func_177226_a((IProperty)BlockTFForceField.COLOR, (Comparable)BlockTFForceField.VALID_COLORS.get(1));
        super.func_74861_a(this, list, rand);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (!super.func_74875_a(world, rand, sbb)) {
            return false;
        }
        final IBlockState stairs = this.deco.stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.SOUTH);
        final IBlockState deadRock = TFBlocks.deadrock.func_176223_P();
        for (int y = 0; y <= this.height; ++y) {
            final int x = this.size / 2 - 2;
            final int z = this.size / 2 - y + 2;
            this.func_175804_a(world, sbb, x, 0, z, x + 4, y - 1, z, deadRock, deadRock, false);
            this.func_175804_a(world, sbb, x, y, z, x + 4, y, z, stairs, stairs, false);
            this.func_74878_a(world, sbb, x, y + 1, z, x + 4, y + 6, z);
        }
        final IBlockState castleDoor = TFBlocks.castle_door.func_176223_P().func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, (Comparable)2);
        this.func_175804_a(world, sbb, 23, 0, 12, 23, 3, 14, castleDoor, ComponentTFFinalCastleDungeonEntrance.AIR, false);
        this.func_175804_a(world, sbb, 23, 4, 12, 23, 4, 14, this.deco.blockState, this.deco.blockState, false);
        return true;
    }
    
    @Override
    protected EnumDyeColor getForceFieldColor(final Random decoRNG) {
        return BlockTFForceField.VALID_COLORS.get(1);
    }
    
    @Override
    protected EnumDyeColor getRuneColor(final EnumDyeColor fieldColor) {
        return BlockTFCastleMagic.VALID_COLORS.get(0);
    }
}
