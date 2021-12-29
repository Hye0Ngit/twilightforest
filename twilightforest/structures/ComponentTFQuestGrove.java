// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.BlockStoneBrick;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import twilightforest.entity.passive.EntityTFQuestRam;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.block.BlockDispenser;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockButton;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;
import net.minecraft.block.state.IBlockState;

public class ComponentTFQuestGrove extends StructureTFComponentOld
{
    private static final int RADIUS = 13;
    private static final IBlockState MOSSY_STONEBRICK;
    private static final IBlockState CHISELED_STONEBRICK;
    protected boolean beastPlaced;
    protected boolean dispenserPlaced;
    
    public ComponentTFQuestGrove() {
        this.beastPlaced = false;
        this.dispenserPlaced = false;
    }
    
    public ComponentTFQuestGrove(final TFFeature feature, final World world, final Random rand, final int i, final int x, final int y, final int z) {
        super(feature, i);
        this.beastPlaced = false;
        this.dispenserPlaced = false;
        this.func_186164_a(EnumFacing.SOUTH);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -13, 0, -13, 26, 10, 26, EnumFacing.SOUTH);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (final EnumFacing e : EnumFacing.field_176754_o) {
            this.makeWallSide(world, rand, e, sbb);
        }
        for (int x = 10; x < 17; ++x) {
            for (int z = 10; z < 17; ++z) {
                if (x == 10 || x == 16 || z == 10 || z == 16) {
                    if (rand.nextInt(2) > 0) {
                        this.func_175811_a(world, ComponentTFQuestGrove.MOSSY_STONEBRICK, x, -1, z, sbb);
                    }
                }
                else if (x == 11 || x == 15 || z == 11 || z == 15) {
                    if (rand.nextInt(3) > 0) {
                        this.func_175811_a(world, ComponentTFQuestGrove.MOSSY_STONEBRICK, x, -1, z, sbb);
                    }
                }
                else {
                    this.func_175811_a(world, ComponentTFQuestGrove.MOSSY_STONEBRICK, x, -1, z, sbb);
                }
            }
        }
        this.func_175811_a(world, Blocks.field_150430_aB.func_176223_P().func_177226_a((IProperty)BlockButton.field_176387_N, (Comparable)EnumFacing.SOUTH), 13, 5, 19, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.MOSSY_STONEBRICK, 12, 7, 20, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.MOSSY_STONEBRICK, 13, 7, 20, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.MOSSY_STONEBRICK, 14, 7, 20, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.MOSSY_STONEBRICK, 12, 7, 21, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.MOSSY_STONEBRICK, 13, 7, 21, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.MOSSY_STONEBRICK, 14, 7, 21, sbb);
        if (!this.dispenserPlaced) {
            final int bx = this.func_74865_a(13, 20);
            final int by = this.func_74862_a(6);
            final int bz = this.func_74873_b(13, 20);
            final BlockPos pos = new BlockPos(bx, by, bz);
            if (sbb.func_175898_b((Vec3i)pos)) {
                this.dispenserPlaced = true;
                world.func_180501_a(pos, Blocks.field_150367_z.func_176223_P().func_177226_a((IProperty)BlockDispenser.field_176441_a, (Comparable)EnumFacing.NORTH), 4);
                final TileEntityDispenser ted = (TileEntityDispenser)world.func_175625_s(pos);
                for (int i = 0; i < 4; ++i) {
                    ted.func_70299_a(i, new ItemStack(Blocks.field_150325_L, 1, rand.nextInt(16)));
                }
            }
        }
        if (!this.beastPlaced) {
            final int bx = this.func_74865_a(13, 13);
            final int by = this.func_74862_a(0);
            final int bz = this.func_74873_b(13, 13);
            final BlockPos pos = new BlockPos(bx, by, bz);
            if (sbb.func_175898_b((Vec3i)pos)) {
                this.beastPlaced = true;
                final EntityTFQuestRam ram = new EntityTFQuestRam(world);
                ram.func_70107_b((double)bx, (double)by, (double)bz);
                ram.func_175449_a(pos, 13);
                ram.func_180482_a(world.func_175649_E(pos), (IEntityLivingData)null);
                world.func_72838_d((Entity)ram);
            }
        }
        return true;
    }
    
    private void makeWallSide(final World world, final Random rand, final EnumFacing direction, final StructureBoundingBox sbb) {
        final EnumFacing temp = this.func_186165_e();
        this.func_186164_a(direction);
        this.placeOuterArch(world, 3, -1, sbb);
        this.placeOuterArch(world, 11, -1, sbb);
        this.placeOuterArch(world, 19, -1, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 0, 0, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 0, 1, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 0, 2, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 0, 3, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 1, 3, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 2, 3, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 8, 3, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 9, 3, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 10, 3, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 16, 3, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 17, 3, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 18, 3, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 24, 3, 0, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 25, 3, 0, sbb);
        for (int x = 0; x < 9; ++x) {
            for (int y = 0; y < 9; ++y) {
                for (int z = 0; z < 2; ++z) {
                    if (x == 0 || x == 1 || x == 7 || x == 8 || y == 0 || y == 1 || y == 7 || y == 8) {
                        this.func_175811_a(world, ComponentTFQuestGrove.MOSSY_STONEBRICK, x + 9, y - 2, z + 5, sbb);
                    }
                }
            }
        }
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 6, 0, 6, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 6, 1, 6, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 6, 2, 6, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 6, 3, 6, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 6, 4, 6, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 7, 4, 6, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 8, 4, 6, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 18, 4, 6, sbb);
        this.func_175811_a(world, ComponentTFQuestGrove.CHISELED_STONEBRICK, 19, 4, 6, sbb);
        this.func_186164_a(temp);
    }
    
    private void placeOuterArch(final World world, final int ox, final int oy, final StructureBoundingBox sbb) {
        for (int x = 0; x < 5; ++x) {
            for (int y = 0; y < 6; ++y) {
                if (x == 0 || x == 4 || y == 0 || y == 5) {
                    this.func_175811_a(world, ComponentTFQuestGrove.MOSSY_STONEBRICK, x + ox, y + oy, 0, sbb);
                }
            }
        }
    }
    
    static {
        MOSSY_STONEBRICK = Blocks.field_150417_aV.func_176223_P().func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.MOSSY);
        CHISELED_STONEBRICK = Blocks.field_150417_aV.func_176223_P().func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.CHISELED);
    }
}
