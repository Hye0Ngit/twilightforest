// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.block.TFBlocks;

public class TileEntityTFTowerBuilder extends asm
{
    private static final int RANGE = 16;
    int ticksRunning;
    int blockedCounter;
    int ticksStopped;
    public boolean makingBlocks;
    int blocksMade;
    protected t lastBlockCoords;
    protected int nextFacing;
    protected ue trackedPlayer;
    protected int blockBuiltID;
    protected int blockBuiltMeta;
    
    public TileEntityTFTowerBuilder() {
        this.ticksRunning = 0;
        this.blockedCounter = 0;
        this.ticksStopped = 0;
        this.makingBlocks = false;
        this.blocksMade = 0;
        this.blockBuiltID = TFBlocks.towerTranslucent.cF;
        this.blockBuiltMeta = 2;
    }
    
    public void startBuilding() {
        this.makingBlocks = true;
        this.blocksMade = 0;
        this.lastBlockCoords = new t(this.l, this.m, this.n);
    }
    
    public boolean canUpdate() {
        return true;
    }
    
    public void h() {
        if (!this.k.I && this.makingBlocks) {
            if (this.trackedPlayer == null) {
                this.trackedPlayer = this.findClosestValidPlayer();
            }
            this.nextFacing = this.findNextFacing();
            ++this.ticksRunning;
            if (this.ticksRunning % 10 == 0 && this.lastBlockCoords != null && this.nextFacing != -1) {
                final int nextX = this.lastBlockCoords.a + s.b[this.nextFacing];
                final int nextY = this.lastBlockCoords.b + s.c[this.nextFacing];
                final int nextZ = this.lastBlockCoords.c + s.d[this.nextFacing];
                if (this.blocksMade <= 16 && this.k.c(nextX, nextY, nextZ)) {
                    this.k.f(nextX, nextY, nextZ, this.blockBuiltID, this.blockBuiltMeta, 3);
                    this.k.e(1001, nextX, nextY, nextZ, 0);
                    this.lastBlockCoords.a = nextX;
                    this.lastBlockCoords.b = nextY;
                    this.lastBlockCoords.c = nextZ;
                    this.blockedCounter = 0;
                    ++this.blocksMade;
                }
                else {
                    ++this.blockedCounter;
                }
            }
            if (this.blockedCounter > 0) {
                this.makingBlocks = false;
                this.trackedPlayer = null;
                this.ticksStopped = 0;
            }
        }
        else if (!this.k.I && !this.makingBlocks) {
            this.trackedPlayer = null;
            if (++this.ticksStopped == 60) {
                this.k.f(this.l, this.m, this.n, TFBlocks.towerDevice.cF, 8, 3);
                this.k.a(this.l, this.m, this.n, TFBlocks.towerDevice.cF, 4);
            }
        }
    }
    
    private boolean isInBounds(final int nextX, final int nextY, final int nextZ) {
        return nextX > this.l - 16 && nextX < this.l + 16 && nextY > this.m - 16 && nextY < this.m + 16 && nextZ > this.n - 16 && nextZ < this.n + 16;
    }
    
    private int findNextFacing() {
        if (this.trackedPlayer != null) {
            final int pitch = lr.c(this.trackedPlayer.B * 4.0f / 360.0f + 1.5) & 0x3;
            if (pitch == 0) {
                return 1;
            }
            if (pitch == 2) {
                return 0;
            }
            final int direction = lr.c(this.trackedPlayer.A * 4.0f / 360.0f + 0.5) & 0x3;
            switch (direction) {
                case 0: {
                    return 3;
                }
                case 1: {
                    return 4;
                }
                case 2: {
                    return 2;
                }
                case 3: {
                    return 5;
                }
            }
        }
        return -1;
    }
    
    private ue findClosestValidPlayer() {
        return this.k.a(this.l + 0.5, this.m + 0.5, this.n + 0.5, 16.0);
    }
}
