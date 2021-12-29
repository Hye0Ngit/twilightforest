// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import twilightforest.world.TFGenerator;
import twilightforest.block.TFBlocks;
import net.minecraft.util.ChunkCoordinates;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class ComponentTFHollowTreeRoot extends ComponentTFHollowTreeMedBranch
{
    private int groundLevel;
    
    public ComponentTFHollowTreeRoot() {
        this.groundLevel = -1;
    }
    
    public ComponentTFHollowTreeRoot(final int i, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        super(i, sx, sy, sz, length, angle, tilt, leafy);
        this.groundLevel = -1;
        this.field_74887_e = new StructureBoundingBox(Math.min(this.src.field_71574_a, this.dest.field_71574_a), Math.min(this.src.field_71572_b, this.dest.field_71572_b), Math.min(this.src.field_71573_c, this.dest.field_71573_c), Math.max(this.src.field_71574_a, this.dest.field_71574_a), Math.max(this.src.field_71572_b, this.dest.field_71572_b), Math.max(this.src.field_71573_c, this.dest.field_71573_c));
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox sbb) {
        if (this.groundLevel < 0) {
            final int rootHeight = this.field_74887_e.field_78894_e - this.field_74887_e.field_78895_b;
            this.groundLevel = this.getSampledDirtLevel(world, sbb);
            if (this.groundLevel < 0) {
                return true;
            }
            this.src.field_71572_b = this.groundLevel + 5;
        }
        final ChunkCoordinates rSrc = new ChunkCoordinates(this.src.field_71574_a - this.field_74887_e.field_78897_a, this.src.field_71572_b - this.field_74887_e.field_78895_b, this.src.field_71573_c - this.field_74887_e.field_78896_c);
        final ChunkCoordinates rDest = new ChunkCoordinates(this.dest.field_71574_a - this.field_74887_e.field_78897_a, this.dest.field_71572_b - this.field_74887_e.field_78895_b, this.dest.field_71573_c - this.field_74887_e.field_78896_c);
        this.drawRootLine(world, sbb, rSrc.field_71574_a, rSrc.field_71572_b, rSrc.field_71573_c, rDest.field_71574_a, rDest.field_71572_b, rDest.field_71573_c, TFBlocks.root.field_71990_ca, 0);
        this.drawRootLine(world, sbb, rSrc.field_71574_a, rSrc.field_71572_b - 1, rSrc.field_71573_c, rDest.field_71574_a, rDest.field_71572_b - 1, rDest.field_71573_c, TFBlocks.root.field_71990_ca, 0);
        return true;
    }
    
    protected void drawRootLine(final World world, final StructureBoundingBox sbb, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2, final int blockValue, final int metaValue) {
        final ChunkCoordinates[] arr$;
        final ChunkCoordinates[] lineCoords = arr$ = TFGenerator.getBresehnamArrayCoords(x1, y1, z1, x2, y2, z2);
        for (final ChunkCoordinates coords : arr$) {
            final int blockThere = this.func_74866_a(world, coords.field_71574_a, coords.field_71572_b, coords.field_71573_c, sbb);
            final Block block = Block.field_71973_m[blockThere];
            if (!Block.func_71932_i(blockThere) || (block != null && block.field_72018_cp == Material.field_76247_b)) {
                this.func_74864_a(world, TFBlocks.log.field_71990_ca, 12, coords.field_71574_a, coords.field_71572_b, coords.field_71573_c, sbb);
            }
            else if (block == null || block.field_72018_cp != Material.field_76245_d) {
                this.func_74864_a(world, blockValue, metaValue, coords.field_71574_a, coords.field_71572_b, coords.field_71573_c, sbb);
            }
        }
    }
}
