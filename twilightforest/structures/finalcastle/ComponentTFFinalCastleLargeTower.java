// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.block.BlockTFCastleMagic;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFCastleDoor;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;
import twilightforest.structures.lichtower.ComponentTFTowerWing;

public class ComponentTFFinalCastleLargeTower extends ComponentTFTowerWing
{
    public ComponentTFFinalCastleLargeTower() {
    }
    
    public ComponentTFFinalCastleLargeTower(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i);
        this.func_186164_a(rotation);
        this.size = 13;
        this.height = 61;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -6, 0, -6, 12, 60, 12, EnumFacing.SOUTH);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        final ComponentTFFinalCastleRoof9Crenellated roof = new ComponentTFFinalCastleRoof9Crenellated(this.getFeatureType(), rand, 4, this);
        list.add(roof);
        roof.func_74861_a(this, list, rand);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        this.func_74882_a(world, sbb, 0, 0, 0, 12, 59, 12, false, rand, this.deco.randomBlocks);
        for (int numBranches = 6 + decoRNG.nextInt(4), i = 0; i < numBranches; ++i) {
            this.makeGlyphBranches(world, decoRNG, this.getGlyphMeta(), sbb);
        }
        for (int i = 1; i < 4; ++i) {
            this.func_74882_a(world, sbb, i, 0 - i * 2, i, 8 - i, 1 - i * 2, 8 - i, false, rand, this.deco.randomBlocks);
        }
        this.func_175811_a(world, this.deco.blockState, 4, -7, 4, sbb);
        final IBlockState castleDoor = TFBlocks.castle_door.func_176223_P().func_177226_a((IProperty)BlockTFCastleDoor.LOCK_INDEX, (Comparable)0);
        this.func_175804_a(world, sbb, 0, 1, 1, 0, 4, 3, castleDoor, ComponentTFFinalCastleLargeTower.AIR, false);
        this.placeSignAtCurrentPosition(world, 6, 1, 6, "Parkour area 1", "Unique monster?", sbb);
        return true;
    }
    
    public EnumDyeColor getGlyphMeta() {
        return BlockTFCastleMagic.VALID_COLORS.get(0);
    }
}
