import java.util.ArrayList;
import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFLeaves extends bx
{
    protected BlockTFLeaves(final int i, final int j) {
        super(i, j);
    }
    
    public void a(final ge world, final int i, final int j, final int k, final Random random) {
        if (world.F) {
            return;
        }
        final int l = world.c(i, j, k);
        if ((l & 0x8) != 0x0 && (l & 0x4) == 0x0) {
            final byte byte0 = 4;
            final int i2 = byte0 + 1;
            final byte byte2 = 32;
            final int j2 = byte2 * byte2;
            final int k2 = byte2 / 2;
            if (this.a == null) {
                this.a = new int[byte2 * byte2 * byte2];
            }
            if (world.a(i - i2, j - i2, k - i2, i + i2, j + i2, k + i2)) {
                for (int l2 = -byte0; l2 <= byte0; ++l2) {
                    for (int k3 = -byte0; k3 <= byte0; ++k3) {
                        for (int i3 = -byte0; i3 <= byte0; ++i3) {
                            final int k4 = world.a(i + l2, j + k3, k + i3);
                            if (k4 == vz.J.bO || k4 == TFBlocks.wood.bO) {
                                this.a[(l2 + k2) * j2 + (k3 + k2) * byte2 + (i3 + k2)] = 0;
                            }
                            else if (k4 == vz.K.bO || k4 == TFBlocks.leaves.bO) {
                                this.a[(l2 + k2) * j2 + (k3 + k2) * byte2 + (i3 + k2)] = -2;
                            }
                            else {
                                this.a[(l2 + k2) * j2 + (k3 + k2) * byte2 + (i3 + k2)] = -1;
                            }
                        }
                    }
                }
                for (int i4 = 1; i4 <= 4; ++i4) {
                    for (int l3 = -byte0; l3 <= byte0; ++l3) {
                        for (int j3 = -byte0; j3 <= byte0; ++j3) {
                            for (int l4 = -byte0; l4 <= byte0; ++l4) {
                                if (this.a[(l3 + k2) * j2 + (j3 + k2) * byte2 + (l4 + k2)] == i4 - 1) {
                                    if (this.a[(l3 + k2 - 1) * j2 + (j3 + k2) * byte2 + (l4 + k2)] == -2) {
                                        this.a[(l3 + k2 - 1) * j2 + (j3 + k2) * byte2 + (l4 + k2)] = i4;
                                    }
                                    if (this.a[(l3 + k2 + 1) * j2 + (j3 + k2) * byte2 + (l4 + k2)] == -2) {
                                        this.a[(l3 + k2 + 1) * j2 + (j3 + k2) * byte2 + (l4 + k2)] = i4;
                                    }
                                    if (this.a[(l3 + k2) * j2 + (j3 + k2 - 1) * byte2 + (l4 + k2)] == -2) {
                                        this.a[(l3 + k2) * j2 + (j3 + k2 - 1) * byte2 + (l4 + k2)] = i4;
                                    }
                                    if (this.a[(l3 + k2) * j2 + (j3 + k2 + 1) * byte2 + (l4 + k2)] == -2) {
                                        this.a[(l3 + k2) * j2 + (j3 + k2 + 1) * byte2 + (l4 + k2)] = i4;
                                    }
                                    if (this.a[(l3 + k2) * j2 + (j3 + k2) * byte2 + (l4 + k2 - 1)] == -2) {
                                        this.a[(l3 + k2) * j2 + (j3 + k2) * byte2 + (l4 + k2 - 1)] = i4;
                                    }
                                    if (this.a[(l3 + k2) * j2 + (j3 + k2) * byte2 + (l4 + k2 + 1)] == -2) {
                                        this.a[(l3 + k2) * j2 + (j3 + k2) * byte2 + (l4 + k2 + 1)] = i4;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final int j4 = this.a[k2 * j2 + k2 * byte2 + k2];
            if (j4 >= 0) {
                world.d(i, j, k, l & 0xFFFFFFF7);
            }
            else {
                this.removeLeaves(world, i, j, k);
            }
        }
    }
    
    void removeLeaves(final ge world, final int i, final int j, final int k) {
        this.b(world, i, j, k, world.c(i, j, k), 0);
        world.e(i, j, k, 0);
    }
    
    public boolean a() {
        return vz.K.a();
    }
    
    public int a(final int i, final int j) {
        return vz.K.a(i, j);
    }
    
    public void addCreativeItems(final ArrayList itemList) {
        itemList.add(new kp((vz)this, 1, 0));
        itemList.add(new kp((vz)this, 1, 1));
        itemList.add(new kp((vz)this, 1, 2));
    }
}
