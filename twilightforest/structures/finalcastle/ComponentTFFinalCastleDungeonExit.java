// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.block.BlockTFCastleMagic;
import twilightforest.block.BlockTFForceField;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.math.Vec3i;
import twilightforest.util.StructureBoundingBoxUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFCastleDoor;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import twilightforest.structures.StructureTFComponentOld;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFFinalCastleDungeonExit extends ComponentTFFinalCastleDungeonRoom31
{
    public ComponentTFFinalCastleDungeonExit() {
    }
    
    public ComponentTFFinalCastleDungeonExit(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final EnumFacing direction, final int level) {
        super(feature, rand, i, x, y, z, direction, level);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        final Rotation bestDir = this.findStairDirectionTowards(parent.func_74874_b().field_78897_a, parent.func_74874_b().field_78896_c);
        final ComponentTFFinalCastleDungeonSteps steps0 = new ComponentTFFinalCastleDungeonSteps(rand, 5, this.field_74887_e.field_78897_a + 15, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + 15, bestDir.func_185831_a(EnumFacing.SOUTH));
        list.add(steps0);
        steps0.func_74861_a(this, list, rand);
        if (this.level == 1) {
            steps0.buildLevelUnder(parent, list, rand, this.level + 1);
        }
        else {
            steps0.buildBossRoomUnder(parent, list, rand);
        }
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (!super.func_74875_a(world, rand, sbb)) {
            return false;
        }
        final IBlockState castleDoor = TFBlocks.castle_door.func_176223_P().func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, (Comparable)2);
        this.func_175804_a(world, sbb, 7, 0, 16, 7, 3, 18, castleDoor, ComponentTFFinalCastleDungeonExit.AIR, false);
        this.func_175804_a(world, sbb, 7, 4, 16, 7, 4, 18, this.deco.blockState, this.deco.blockState, false);
        return true;
    }
    
    public Rotation findStairDirectionTowards(final int x, final int z) {
        final Vec3i center = StructureBoundingBoxUtils.getCenter(this.field_74887_e);
        final int dx = center.func_177958_n() - x;
        final int dz = center.func_177952_p() - z;
        Rotation absoluteDir;
        if (Math.abs(dz) >= Math.abs(dx)) {
            absoluteDir = ((dz >= 0) ? Rotation.CLOCKWISE_180 : Rotation.NONE);
        }
        else {
            absoluteDir = ((dx >= 0) ? Rotation.COUNTERCLOCKWISE_90 : Rotation.CLOCKWISE_90);
        }
        return absoluteDir;
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
