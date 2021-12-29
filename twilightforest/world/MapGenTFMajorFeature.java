// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Iterator;
import twilightforest.structures.StructureTFComponent;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.StructureTFMajorFeatureStart;
import net.minecraft.world.gen.structure.StructureStart;
import twilightforest.TFFeature;
import net.minecraft.world.gen.structure.MapGenStructure;

public class MapGenTFMajorFeature extends MapGenStructure
{
    protected boolean func_75047_a(final int chunkX, final int chunkZ) {
        return TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.field_75039_c).structureEnabled;
    }
    
    protected StructureStart func_75049_b(final int chunkX, final int chunkZ) {
        this.field_75038_b.setSeed(this.field_75039_c.func_72905_C());
        final long rand1 = this.field_75038_b.nextLong();
        final long rand2 = this.field_75038_b.nextLong();
        final long chunkXr1 = chunkX * rand1;
        final long chunkZr2 = chunkZ * rand2;
        this.field_75038_b.setSeed(chunkXr1 ^ chunkZr2 ^ this.field_75039_c.func_72905_C());
        this.field_75038_b.nextInt();
        return new StructureTFMajorFeatureStart(this.field_75039_c, this.field_75038_b, chunkX, chunkZ);
    }
    
    public int getSpawnListIndexAt(final int par1, final int par2, final int par3) {
        int highestFoundIndex = -1;
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(par1, par3, par1, par3)) {
                for (final StructureComponent component : start.func_75073_b()) {
                    if (component.func_74874_b().func_78890_b(par1, par2, par3)) {
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
