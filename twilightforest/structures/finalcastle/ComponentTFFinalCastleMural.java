// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFCastleMagic;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFFinalCastleMural extends StructureTFComponentOld
{
    private int height;
    private int width;
    private byte[][] mural;
    
    public ComponentTFFinalCastleMural() {
    }
    
    public ComponentTFFinalCastleMural(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final int width, final int height, final EnumFacing direction) {
        super(feature, i);
        this.func_186164_a(direction);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox2(x, y, z, 0, -height / 2, -width / 2, 1, height - 1, width - 1, direction);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.height = this.field_74887_e.func_78882_c();
        this.width = ((this.field_74885_f == EnumFacing.SOUTH || this.field_74885_f == EnumFacing.NORTH) ? this.field_74887_e.func_78880_d() : this.field_74887_e.func_78883_b());
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        if (this.mural == null) {
            this.mural = new byte[this.width][this.height];
            final int startX = this.width / 2 - 1;
            final int startY = 2;
            for (int x = -1; x < 2; ++x) {
                for (int y = -1; y < 2; ++y) {
                    this.mural[startX + x][startY + y] = 1;
                }
            }
            this.makeHorizontalTree(decoRNG, this.mural, startX + 1, startY, decoRNG.nextInt(this.width / 6) + this.width / 6, true);
            this.makeHorizontalTree(decoRNG, this.mural, startX - 1, startY, decoRNG.nextInt(this.width / 6) + this.width / 6, false);
            this.makeVerticalTree(decoRNG, this.mural, startX, startY + 1, decoRNG.nextInt(this.height / 6) + this.height / 6, true);
            this.makeStripes(decoRNG, this.mural);
        }
        final IBlockState castleMagic = TFBlocks.castle_rune_brick.func_176223_P().func_177226_a((IProperty)BlockTFCastleMagic.COLOR, (Comparable)BlockTFCastleMagic.VALID_COLORS.get(1));
        for (int x2 = 0; x2 < this.width; ++x2) {
            for (int y2 = 0; y2 < this.height; ++y2) {
                if (this.mural[x2][y2] > 0) {
                    this.func_175811_a(world, castleMagic, 0, y2, x2, sbb);
                }
            }
        }
        return true;
    }
    
    private void makeHorizontalTree(final Random decoRNG, final byte[][] mural, final int centerX, final int centerY, final int branchLength, final boolean positive) {
        this.fillHorizontalLine(mural, centerX, centerY, branchLength, positive);
        this.makeHorizontalBranch(mural, decoRNG, centerX, centerY, branchLength, positive, true);
        this.makeHorizontalBranch(mural, decoRNG, centerX, centerY, branchLength, positive, false);
    }
    
    private void makeVerticalTree(final Random decoRNG, final byte[][] mural, final int centerX, final int centerY, final int branchLength, final boolean positive) {
        this.fillVerticalLine(mural, centerX, centerY, branchLength, positive);
        this.makeVerticalBranch(mural, decoRNG, centerX, centerY, branchLength, positive, true);
        this.makeVerticalBranch(mural, decoRNG, centerX, centerY, branchLength, positive, false);
    }
    
    private boolean makeHorizontalBranch(final byte[][] mural, final Random rand, final int sx, final int sy, final int length, final boolean plusX, final boolean plusY) {
        final int downLine = length / 2 + 1 + rand.nextInt(Math.max(length / 2, 2));
        final int branchLength = rand.nextInt(this.width / 8) + this.width / 8;
        boolean clear = true;
        for (int i = 0; i <= branchLength; ++i) {
            final int cx = sx + (plusX ? (downLine - 1 + i) : (-(downLine - 1 + i)));
            final int cy = sy + (plusY ? 2 : -2);
            if (cx < 0 || cx >= this.width || cy < 0 || cy >= this.height || mural[cx][cy] > 0) {
                clear = false;
                break;
            }
        }
        if (clear) {
            final int bx = sx + (plusX ? downLine : (-downLine));
            int by = sy;
            this.fillVerticalLine(mural, bx, by, 1, plusY);
            by += (plusY ? 2 : -2);
            this.fillHorizontalLine(mural, bx, by, branchLength, plusX);
            if (bx > 0 && bx < this.width && by > 0 && by < this.height) {
                if (!this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, true) && !this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, true) && !this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, true)) {
                    this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, true);
                }
                if (!this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, false) && !this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, false) && !this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, false)) {
                    this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, false);
                }
            }
            return true;
        }
        return false;
    }
    
    private boolean makeVerticalBranch(final byte[][] mural, final Random rand, final int sx, final int sy, final int length, final boolean plusY, final boolean plusX) {
        final int downLine = length / 2 + 1 + rand.nextInt(Math.max(length / 2, 2));
        final int branchLength = rand.nextInt(this.height / 8) + this.height / 8;
        boolean clear = true;
        for (int i = 0; i <= branchLength; ++i) {
            final int cx = sx + (plusX ? 2 : -2);
            final int cy = sy + (plusY ? (downLine - 1 + i) : (-(downLine - 1 + i)));
            if (cx < 0 || cx >= this.width || cy < 0 || cy >= this.height || mural[cx][cy] > 0) {
                clear = false;
                break;
            }
        }
        if (clear) {
            int bx = sx;
            final int by = sy + (plusY ? downLine : (-downLine));
            this.fillHorizontalLine(mural, bx, by, 1, plusX);
            bx += (plusX ? 2 : -2);
            this.fillVerticalLine(mural, bx, by, branchLength, plusY);
            if (bx > 0 && bx < this.width && by > 0 && by < this.height) {
                if (!this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, true) && !this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, true) && !this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, true)) {
                    this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, true);
                }
                if (!this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, false) && !this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, false) && !this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, false)) {
                    this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, false);
                }
            }
            return true;
        }
        return false;
    }
    
    private void fillHorizontalLine(final byte[][] mural, final int sx, final int sy, final int length, final boolean positive) {
        int x = sx;
        final int y = sy;
        for (int i = 0; i <= length; ++i) {
            if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
                mural[x][y] = (byte)(positive ? 1 : 4);
                x += (positive ? 1 : -1);
            }
        }
    }
    
    private void fillVerticalLine(final byte[][] mural, final int sx, final int sy, final int length, final boolean positive) {
        final int x = sx;
        int y = sy;
        for (int i = 0; i <= length; ++i) {
            if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
                mural[x][y] = (byte)(positive ? 2 : 3);
                y += (positive ? 1 : -1);
            }
        }
    }
    
    private void makeStripes(final Random decoRNG, final byte[][] mural2) {
        for (int y = this.height - 2; y > this.height / 3; y -= 2 + decoRNG.nextInt(2)) {
            this.makeSingleStripe(mural2, y);
        }
    }
    
    private void makeSingleStripe(final byte[][] mural2, final int y) {
        for (int x = 0; x < this.width - 2 && this.mural[x + 1][y] == 0 && this.mural[x + 1][y + 1] == 0; ++x) {
            this.mural[x][y] = 1;
        }
        for (int x = this.width - 1; x > 2 && this.mural[x - 1][y] == 0 && this.mural[x - 1][y + 1] == 0; --x) {
            this.mural[x][y] = 1;
        }
    }
}
