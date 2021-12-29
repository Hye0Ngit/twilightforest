// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.BlockLeaves;
import net.minecraft.entity.EntityList;
import twilightforest.entity.EntityTFSwarmSpider;
import twilightforest.loot.TFTreasure;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLog;
import twilightforest.block.BlockTFLog;
import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFHollowTreeLeafDungeon extends StructureTFTreeComponent
{
    int radius;
    
    public ComponentTFHollowTreeLeafDungeon() {
    }
    
    protected ComponentTFHollowTreeLeafDungeon(final TFFeature feature, final int index, final int x, final int y, final int z, final int radius) {
        super(feature, index);
        this.func_186164_a(EnumFacing.SOUTH);
        this.field_74887_e = new StructureBoundingBox(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius);
        this.radius = radius;
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("leafRadius", this.radius);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.radius = tagCompound.func_74762_e("leafRadius");
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox sbb) {
        return this.addComponentParts(world, random, sbb, false);
    }
    
    @Override
    public boolean addComponentParts(final World world, final Random random, final StructureBoundingBox sbb, final boolean drawLeaves) {
        if (!drawLeaves) {
            this.drawHollowBlob(world, sbb, this.radius, this.radius, this.radius, 3, 2, TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE), false);
            this.placeTreasureAtCurrentPosition(world, random, this.radius + 2, this.radius - 1, this.radius, TFTreasure.tree_cache, sbb);
            this.setSpawner(world, this.radius, this.radius, this.radius, sbb, EntityList.func_191306_a((Class)EntityTFSwarmSpider.class));
        }
        else {
            this.drawHollowBlob(world, sbb, this.radius, this.radius, this.radius, 4, 2, TFBlocks.twilight_leaves.func_176223_P().func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false), true);
        }
        return true;
    }
    
    private void drawHollowBlob(final World world, final StructureBoundingBox sbb, final int sx, final int sy, final int sz, final int blobRadius, final int hollowRadius, final IBlockState blockState, final boolean isLeaves) {
        for (byte dx = 0; dx <= blobRadius; ++dx) {
            for (byte dy = 0; dy <= blobRadius; ++dy) {
                for (byte dz = 0; dz <= blobRadius; ++dz) {
                    byte dist = 0;
                    if (dx >= dy && dx >= dz) {
                        dist = (byte)(dx + (byte)(Math.max(dy, dz) * 0.5 + Math.min(dy, dz) * 0.25));
                    }
                    else if (dy >= dx && dy >= dz) {
                        dist = (byte)(dy + (byte)(Math.max(dx, dz) * 0.5 + Math.min(dx, dz) * 0.25));
                    }
                    else {
                        dist = (byte)(dz + (byte)(Math.max(dx, dy) * 0.5 + Math.min(dx, dy) * 0.25));
                    }
                    if (dist > hollowRadius && dist <= blobRadius) {
                        if (isLeaves) {
                            this.placeLeafBlock(world, blockState, sx + dx, sy + dy, sz + dz, sbb);
                            this.placeLeafBlock(world, blockState, sx + dx, sy + dy, sz - dz, sbb);
                            this.placeLeafBlock(world, blockState, sx - dx, sy + dy, sz + dz, sbb);
                            this.placeLeafBlock(world, blockState, sx - dx, sy + dy, sz - dz, sbb);
                            this.placeLeafBlock(world, blockState, sx + dx, sy - dy, sz + dz, sbb);
                            this.placeLeafBlock(world, blockState, sx + dx, sy - dy, sz - dz, sbb);
                            this.placeLeafBlock(world, blockState, sx - dx, sy - dy, sz + dz, sbb);
                            this.placeLeafBlock(world, blockState, sx - dx, sy - dy, sz - dz, sbb);
                        }
                        else {
                            this.func_175811_a(world, blockState, sx + dx, sy + dy, sz + dz, sbb);
                            this.func_175811_a(world, blockState, sx + dx, sy + dy, sz - dz, sbb);
                            this.func_175811_a(world, blockState, sx - dx, sy + dy, sz + dz, sbb);
                            this.func_175811_a(world, blockState, sx - dx, sy + dy, sz - dz, sbb);
                            this.func_175811_a(world, blockState, sx + dx, sy - dy, sz + dz, sbb);
                            this.func_175811_a(world, blockState, sx + dx, sy - dy, sz - dz, sbb);
                            this.func_175811_a(world, blockState, sx - dx, sy - dy, sz + dz, sbb);
                            this.func_175811_a(world, blockState, sx - dx, sy - dy, sz - dz, sbb);
                        }
                    }
                }
            }
        }
    }
}
