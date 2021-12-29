// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.state.BlockState;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import java.util.Random;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.core.Direction;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import twilightforest.world.components.structures.TFStructureComponentOld;

public class FinalCastleMuralComponent extends TFStructureComponentOld
{
    private int height;
    private int width;
    private byte[][] mural;
    
    public FinalCastleMuralComponent(final ServerLevel level, final CompoundTag nbt) {
        super(FinalCastlePieces.TFFCMur, nbt);
    }
    
    public FinalCastleMuralComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int width, final int height, final Direction direction) {
        super(FinalCastlePieces.TFFCMur, feature, i, x, y, z);
        this.m_73519_(direction);
        this.f_73383_ = TFStructureComponentOld.getComponentToAddBoundingBox2(x, y, z, 0, -height / 2, -width / 2, 1, height - 1, width - 1, direction);
    }
    
    public boolean m_7832_(final WorldGenLevel world, final StructureFeatureManager manager, final ChunkGenerator generator, final Random rand, final BoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.height = this.f_73383_.m_71057_();
        this.width = ((this.m_73549_() == Direction.SOUTH || this.m_73549_() == Direction.NORTH) ? this.f_73383_.m_71058_() : this.f_73383_.m_71056_());
        final Random decoRNG = new Random(world.m_7328_() + this.f_73383_.m_162395_() * 321534781L ^ this.f_73383_.m_162398_() * 756839L);
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
        final BlockState castleMagic = ((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get()).m_49966_();
        for (int x2 = 0; x2 < this.width; ++x2) {
            for (int y2 = 0; y2 < this.height; ++y2) {
                if (this.mural[x2][y2] > 0) {
                    this.m_73434_(world, castleMagic, 0, y2, x2, sbb);
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
