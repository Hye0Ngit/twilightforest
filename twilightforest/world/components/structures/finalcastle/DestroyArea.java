// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import java.util.Iterator;
import java.util.ArrayList;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

public class DestroyArea
{
    BoundingBox destroyBox;
    
    public DestroyArea(final BoundingBox tower, final Random rand, final int y) {
        final int bx = tower.m_162395_() - 2 + rand.nextInt(tower.m_71056_());
        final int bz = tower.m_162398_() - 2 + rand.nextInt(tower.m_71058_());
        this.destroyBox = new BoundingBox(bx, y - 10, bz, bx + 4, y, bz + 4);
    }
    
    public boolean isEntirelyAbove(final int y) {
        return this.destroyBox.m_162396_() > y;
    }
    
    public boolean isVecInside(final BlockPos pos) {
        return this.destroyBox.m_71051_((Vec3i)pos);
    }
    
    public static DestroyArea createNonIntersecting(final BoundingBox tower, final Random rand, final int y, final ArrayList<DestroyArea> otherAreas) {
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
        return this.destroyBox.m_71019_(otherArea.destroyBox.m_162399_() + 1, otherArea.destroyBox.m_162395_() - 1, otherArea.destroyBox.m_162401_() + 1, otherArea.destroyBox.m_162398_() - 1);
    }
}
