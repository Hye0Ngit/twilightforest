// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import java.util.Iterator;
import java.util.ArrayList;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class DestroyArea
{
    StructureBoundingBox destroyBox;
    
    public DestroyArea(final StructureBoundingBox tower, final Random rand, final int y) {
        final int bx = tower.field_78897_a - 2 + rand.nextInt(tower.func_78883_b());
        final int bz = tower.field_78896_c - 2 + rand.nextInt(tower.func_78880_d());
        this.destroyBox = new StructureBoundingBox(bx, y - 10, bz, bx + 4, y, bz + 4);
    }
    
    public boolean isEntirelyAbove(final int y) {
        return this.destroyBox.field_78895_b > y;
    }
    
    public boolean isVecInside(final BlockPos pos) {
        return this.destroyBox.func_175898_b((Vec3i)pos);
    }
    
    public static DestroyArea createNonIntersecting(final StructureBoundingBox tower, final Random rand, final int y, final ArrayList<DestroyArea> otherAreas) {
        final int attempts = 100;
        DestroyArea area = null;
        for (int i = 0; i < attempts && area == null; ++i) {
            final DestroyArea testArea = new DestroyArea(tower, rand, y);
            if (otherAreas.size() == 0) {
                area = testArea;
            }
            else {
                for (final DestroyArea otherArea : otherAreas) {
                    if (otherArea == null || !testArea.intersectsWith(otherArea)) {
                        area = testArea;
                    }
                }
            }
        }
        return area;
    }
    
    private boolean intersectsWith(final DestroyArea otherArea) {
        return this.destroyBox.func_78885_a(otherArea.destroyBox.field_78897_a - 1, otherArea.destroyBox.field_78896_c - 1, otherArea.destroyBox.field_78893_d + 1, otherArea.destroyBox.field_78893_d + 1);
    }
}
