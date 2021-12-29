import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFTeleporter extends ua
{
    public boolean b(final fq world, final se entity) {
        final int c = 200;
        double d = -1.0;
        int i = 0;
        int j = 0;
        int k = 0;
        final int l = iy.b(entity.bm);
        final int i2 = iy.b(entity.bo);
        for (int j2 = l - c; j2 <= l + c; ++j2) {
            final double d2 = j2 + 0.5 - entity.bm;
            for (int j3 = i2 - c; j3 <= i2 + c; ++j3) {
                final double d3 = j3 + 0.5 - entity.bo;
                for (int k2 = world.c - 1; k2 >= 0; --k2) {
                    if (this.isBlockPortal(world, j2, k2, j3)) {
                        while (this.isBlockPortal(world, j2, k2 - 1, j3)) {
                            --k2;
                        }
                        final double d4 = k2 + 0.5 - entity.bn;
                        final double d5 = d2 * d2 + d4 * d4 + d3 * d3;
                        if (d < 0.0 || d5 < d) {
                            d = d5;
                            i = j2;
                            j = k2;
                            k = j3;
                        }
                    }
                }
            }
        }
        if (d >= 0.0) {
            final int k3 = i;
            final int l2 = j;
            final int i3 = k;
            double d6 = k3 + 0.5;
            final double d7 = l2 + 0.5;
            double d8 = i3 + 0.5;
            if (this.isBlockPortal(world, k3 - 1, l2, i3)) {
                d6 -= 0.5;
            }
            if (this.isBlockPortal(world, k3 + 1, l2, i3)) {
                d6 += 0.5;
            }
            if (this.isBlockPortal(world, k3, l2, i3 - 1)) {
                d8 -= 0.5;
            }
            if (this.isBlockPortal(world, k3, l2, i3 + 1)) {
                d8 += 0.5;
            }
            entity.c(d6, d7, d8, entity.bs, 0.0f);
            final double bp = 0.0;
            entity.br = bp;
            entity.bq = bp;
            entity.bp = bp;
            return true;
        }
        return false;
    }
    
    public boolean isBlockPortal(final fq world, final int x, final int y, final int z) {
        return world.d(x, y, z) == ls.A;
    }
    
    public boolean c(final fq world, final se entity) {
        final byte byte0 = 16;
        double weight = -1.0;
        final int ex = iy.b(entity.bm);
        final int ey = iy.b(entity.bn);
        final int ez = iy.b(entity.bo);
        int px = ex;
        int py = ey;
        int pz = ez;
        int k1 = 0;
        final int l1 = world.w.nextInt(4);
        for (int i2 = ex - byte0; i2 <= ex + byte0; ++i2) {
            final double d1 = i2 + 0.5 - entity.bm;
            for (int j3 = ez - byte0; j3 <= ez + byte0; ++j3) {
                final double d2 = j3 + 0.5 - entity.bo;
                world.getClass();
            Label_0423:
                for (int k2 = 127; k2 >= 0; --k2) {
                    if (world.f(i2, k2, j3)) {
                        while (k2 > 0 && world.f(i2, k2 - 1, j3)) {
                            --k2;
                        }
                        for (int k3 = l1; k3 < l1 + 4; ++k3) {
                            int l2 = k3 % 2;
                            int i3 = 1 - l2;
                            if (k3 % 4 >= 2) {
                                l2 = -l2;
                                i3 = -i3;
                            }
                            for (int j4 = 0; j4 < 3; ++j4) {
                                for (int k4 = 0; k4 < 4; ++k4) {
                                    for (int l3 = -1; l3 < 4; ++l3) {
                                        final int j5 = i2 + (k4 - 1) * l2 + j4 * i3;
                                        final int l4 = k2 + l3;
                                        final int j6 = j3 + (k4 - 1) * i3 - j4 * l2;
                                        if (l3 < 0 && !world.d(j5, l4, j6).a()) {
                                            continue Label_0423;
                                        }
                                        if (l3 >= 0 && !world.f(j5, l4, j6)) {
                                            continue Label_0423;
                                        }
                                    }
                                }
                            }
                            final double d3 = k2 + 0.5 - entity.bn;
                            final double d4 = d1 * d1 + d3 * d3 + d2 * d2;
                            if (weight < 0.0 || d4 < weight) {
                                weight = d4;
                                px = i2;
                                py = k2;
                                pz = j3;
                                k1 = k3 % 4;
                            }
                        }
                    }
                }
            }
        }
        if (weight < 0.0) {
            for (int j7 = ex - byte0; j7 <= ex + byte0; ++j7) {
                final double d5 = j7 + 0.5 - entity.bm;
                for (int k5 = ez - byte0; k5 <= ez + byte0; ++k5) {
                    final double d6 = k5 + 0.5 - entity.bo;
                    world.getClass();
                Label_0766:
                    for (int l5 = 127; l5 >= 0; --l5) {
                        if (world.f(j7, l5, k5)) {
                            while (l5 > 0 && world.f(j7, l5 - 1, k5)) {
                                --l5;
                            }
                            for (int l6 = l1; l6 < l1 + 2; ++l6) {
                                final int i4 = l6 % 2;
                                final int j8 = 1 - i4;
                                for (int k6 = 0; k6 < 4; ++k6) {
                                    for (int l7 = -1; l7 < 4; ++l7) {
                                        final int i5 = j7 + (k6 - 1) * i4;
                                        final int k7 = l5 + l7;
                                        final int i6 = k5 + (k6 - 1) * j8;
                                        if (l7 < 0 && !world.d(i5, k7, i6).a()) {
                                            continue Label_0766;
                                        }
                                        if (l7 >= 0 && !world.f(i5, k7, i6)) {
                                            continue Label_0766;
                                        }
                                    }
                                }
                                final double d7 = l5 + 0.5 - entity.bn;
                                final double d8 = d5 * d5 + d7 * d7 + d6 * d6;
                                if (weight < 0.0 || d8 < weight) {
                                    weight = d8;
                                    px = j7;
                                    py = l5;
                                    pz = k5;
                                    k1 = l6 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        final int k8 = k1;
        final int portalX = px;
        final int portalY = py;
        final int portalZ = pz;
        int i7 = k8 % 2;
        int j9 = 1 - i7;
        if (k8 % 4 >= 2) {
            i7 = -i7;
            j9 = -j9;
        }
        this.makePortalAt(world, portalX, portalY, portalZ);
        return true;
    }
    
    private void makePortalAt(final fq world, final int px, int py, final int pz) {
        if (py < 30) {
            py = 30;
        }
        world.getClass();
        if (py > 118) {
            world.getClass();
            py = 118;
        }
        --py;
        world.t = true;
        world.b(px - 1, py + 0, pz - 1, ud.w.bO);
        world.b(px + 0, py + 0, pz - 1, ud.w.bO);
        world.b(px + 1, py + 0, pz - 1, ud.w.bO);
        world.b(px + 2, py + 0, pz - 1, ud.w.bO);
        world.b(px - 1, py + 0, pz + 0, ud.w.bO);
        world.b(px + 2, py + 0, pz + 0, ud.w.bO);
        world.b(px - 1, py + 0, pz + 1, ud.w.bO);
        world.b(px + 2, py + 0, pz + 1, ud.w.bO);
        world.b(px - 1, py + 0, pz + 2, ud.w.bO);
        world.b(px + 0, py + 0, pz + 2, ud.w.bO);
        world.b(px + 1, py + 0, pz + 2, ud.w.bO);
        world.b(px + 2, py + 0, pz + 2, ud.w.bO);
        world.b(px + 0, py - 1, pz + 0, ud.x.bO);
        world.b(px + 1, py - 1, pz + 0, ud.x.bO);
        world.b(px + 0, py - 1, pz + 1, ud.x.bO);
        world.b(px + 1, py - 1, pz + 1, ud.x.bO);
        world.b(px + 0, py + 0, pz + 0, TFBlocks.portal.bO);
        world.b(px + 1, py + 0, pz + 0, TFBlocks.portal.bO);
        world.b(px + 0, py + 0, pz + 1, TFBlocks.portal.bO);
        world.b(px + 1, py + 0, pz + 1, TFBlocks.portal.bO);
        for (int dx = -1; dx <= 2; ++dx) {
            for (int dz = -1; dz <= 2; ++dz) {
                for (int dy = 1; dy <= 5; ++dy) {
                    world.b(px + dx, py + dy, pz + dz, 0);
                }
            }
        }
        world.a(px - 1, py + 1, pz - 1, this.randNatureBlockID(world.w), 2);
        world.a(px + 0, py + 1, pz - 1, this.randNatureBlockID(world.w), 2);
        world.a(px + 1, py + 1, pz - 1, this.randNatureBlockID(world.w), 2);
        world.a(px + 2, py + 1, pz - 1, this.randNatureBlockID(world.w), 2);
        world.a(px - 1, py + 1, pz + 0, this.randNatureBlockID(world.w), 2);
        world.a(px + 2, py + 1, pz + 0, this.randNatureBlockID(world.w), 2);
        world.a(px - 1, py + 1, pz + 1, this.randNatureBlockID(world.w), 2);
        world.a(px + 2, py + 1, pz + 1, this.randNatureBlockID(world.w), 2);
        world.a(px - 1, py + 1, pz + 2, this.randNatureBlockID(world.w), 2);
        world.a(px + 0, py + 1, pz + 2, this.randNatureBlockID(world.w), 2);
        world.a(px + 1, py + 1, pz + 2, this.randNatureBlockID(world.w), 2);
        world.a(px + 2, py + 1, pz + 2, this.randNatureBlockID(world.w), 2);
        world.t = false;
    }
    
    public int randNatureBlockID(final Random random) {
        final int[] block = { ud.ah.bO, ud.ai.bO, ud.Z.bO, ud.ag.bO, ud.af.bO };
        return block[random.nextInt(block.length)];
    }
}
