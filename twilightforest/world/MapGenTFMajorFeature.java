// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Iterator;
import twilightforest.structures.StructureTFComponent;
import twilightforest.structures.StructureTFMajorFeatureStart;
import twilightforest.TFFeature;

public class MapGenTFMajorFeature extends aim
{
    protected boolean a(final int chunkX, final int chunkZ) {
        return TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.c).structureEnabled;
    }
    
    protected ais b(final int chunkX, final int chunkZ) {
        this.b.setSeed(this.c.H());
        final long rand1 = this.b.nextLong();
        final long rand2 = this.b.nextLong();
        final long chunkXr1 = chunkX * rand1;
        final long chunkZr2 = chunkZ * rand2;
        this.b.setSeed(chunkXr1 ^ chunkZr2 ^ this.c.H());
        this.b.nextInt();
        return new StructureTFMajorFeatureStart(this.c, this.b, chunkX, chunkZ);
    }
    
    public int getSpawnListIndexAt(final int par1, final int par2, final int par3) {
        int highestFoundIndex = -1;
        for (final ais start : this.d.values()) {
            if (start.d() && start.a().a(par1, par3, par1, par3)) {
                for (final aiq component : start.b()) {
                    if (component.b().b(par1, par2, par3)) {
                        if (!(component instanceof StructureTFComponent)) {
                            return 0;
                        }
                        final StructureTFComponent tfComponent = (StructureTFComponent)component;
                        if (tfComponent.spawnListIndex <= highestFoundIndex) {
                            continue;
                        }
                        highestFoundIndex = tfComponent.spawnListIndex;
                    }
                }
            }
        }
        return highestFoundIndex;
    }
}
