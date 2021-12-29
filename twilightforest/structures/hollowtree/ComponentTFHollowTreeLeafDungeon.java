// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.world.IBlockAccess;
import net.minecraft.block.Block;
import twilightforest.entity.TFCreatures;
import twilightforest.TFTreasure;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFHollowTreeLeafDungeon extends StructureTFComponent
{
    int radius;
    
    public ComponentTFHollowTreeLeafDungeon() {
    }
    
    protected ComponentTFHollowTreeLeafDungeon(final int index, final int x, final int y, final int z, final int radius) {
        super(index);
        this.setCoordBaseMode(0);
        this.field_74887_e = new StructureBoundingBox(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius);
        this.radius = radius;
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("leafRadius", this.radius);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.radius = par1NBTTagCompound.func_74762_e("leafRadius");
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random rand) {
        this.setCoordBaseMode(rand.nextInt(4));
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.drawBlockBlob(world, sbb, this.radius, this.radius, this.radius, 4, TFBlocks.leaves, 0, true);
        this.drawBlockBlob(world, sbb, this.radius, this.radius, this.radius, 3, TFBlocks.log, 12, false);
        this.drawBlockBlob(world, sbb, this.radius, this.radius, this.radius, 2, Blocks.field_150350_a, 0, false);
        this.placeTreasureAtCurrentPosition(world, rand, this.radius + 2, this.radius - 1, this.radius, TFTreasure.tree_cache, sbb);
        this.placeSpawnerAtCurrentPosition(world, rand, this.radius, this.radius, this.radius, TFCreatures.getSpawnerNameFor("Swarm Spider"), sbb);
        return true;
    }
    
    private void drawBlockBlob(final World world, final StructureBoundingBox sbb, final int sx, final int sy, final int sz, final int blobRadius, final Block blockID, final int metadata, final boolean isLeaves) {
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
                    if (dist <= blobRadius) {
                        if (isLeaves) {
                            this.placeLeafBlock(world, blockID, metadata, sx + dx, sy + dy, sz + dz, sbb);
                            this.placeLeafBlock(world, blockID, metadata, sx + dx, sy + dy, sz - dz, sbb);
                            this.placeLeafBlock(world, blockID, metadata, sx - dx, sy + dy, sz + dz, sbb);
                            this.placeLeafBlock(world, blockID, metadata, sx - dx, sy + dy, sz - dz, sbb);
                            this.placeLeafBlock(world, blockID, metadata, sx + dx, sy - dy, sz + dz, sbb);
                            this.placeLeafBlock(world, blockID, metadata, sx + dx, sy - dy, sz - dz, sbb);
                            this.placeLeafBlock(world, blockID, metadata, sx - dx, sy - dy, sz + dz, sbb);
                            this.placeLeafBlock(world, blockID, metadata, sx - dx, sy - dy, sz - dz, sbb);
                        }
                        else {
                            this.func_151550_a(world, blockID, metadata, sx + dx, sy + dy, sz + dz, sbb);
                            this.func_151550_a(world, blockID, metadata, sx + dx, sy + dy, sz - dz, sbb);
                            this.func_151550_a(world, blockID, metadata, sx - dx, sy + dy, sz + dz, sbb);
                            this.func_151550_a(world, blockID, metadata, sx - dx, sy + dy, sz - dz, sbb);
                            this.func_151550_a(world, blockID, metadata, sx + dx, sy - dy, sz + dz, sbb);
                            this.func_151550_a(world, blockID, metadata, sx + dx, sy - dy, sz - dz, sbb);
                            this.func_151550_a(world, blockID, metadata, sx - dx, sy - dy, sz + dz, sbb);
                            this.func_151550_a(world, blockID, metadata, sx - dx, sy - dy, sz - dz, sbb);
                        }
                    }
                }
            }
        }
    }
    
    protected void placeLeafBlock(final World world, final Block blockID, final int meta, final int x, final int y, final int z, final StructureBoundingBox sbb) {
        final int offX = this.func_74865_a(x, z);
        final int offY = this.func_74862_a(y);
        final int offZ = this.func_74873_b(x, z);
        if (sbb.func_78890_b(offX, offY, offZ)) {
            final Block whatsThere = world.func_147439_a(offX, offY, offZ);
            if (whatsThere == null || whatsThere.canBeReplacedByLeaves((IBlockAccess)world, offX, offY, offZ)) {
                world.func_147465_d(offX, offY, offZ, blockID, meta, 2);
            }
        }
    }
}
