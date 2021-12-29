// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraft.world.gen.structure.MapGenStructureData;
import net.minecraft.world.gen.structure.StructureBoundingBox;
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
        return TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.field_75039_c).isStructureEnabled;
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
    
    public String func_143025_a() {
        return "TFFeature";
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
    
    public StructureBoundingBox getSBBAt(final int mapX, final int mapY, final int mapZ) {
        StructureBoundingBox boxFound = null;
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(mapX, mapZ, mapX, mapZ)) {
                for (final StructureComponent component : start.func_75073_b()) {
                    if (component.func_74874_b().func_78890_b(mapX, mapY, mapZ)) {
                        boxFound = component.func_74874_b();
                    }
                }
            }
        }
        return boxFound;
    }
    
    public boolean isBlockProtectedAt(final int mapX, final int mapY, final int mapZ) {
        boolean blockProtected = false;
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(mapX, mapZ, mapX, mapZ)) {
                for (final StructureComponent component : start.func_75073_b()) {
                    if (component.func_74874_b().func_78890_b(mapX, mapY, mapZ)) {
                        if (component instanceof StructureTFComponent) {
                            final StructureTFComponent tfComp = (StructureTFComponent)component;
                            blockProtected = tfComp.isComponentProtected();
                        }
                        else {
                            blockProtected = true;
                        }
                    }
                }
            }
        }
        return blockProtected;
    }
    
    public void setStructureConquered(final int mapX, final int mapY, final int mapZ, final boolean flag) {
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(mapX, mapZ, mapX, mapZ) && start instanceof StructureTFMajorFeatureStart) {
                final StructureTFMajorFeatureStart featureStart = (StructureTFMajorFeatureStart)start;
                featureStart.isConquered = flag;
                final MapGenStructureData data = (MapGenStructureData)ObfuscationReflectionHelper.getPrivateValue((Class)MapGenStructure.class, (Object)this, new String[] { "field_143029_e" });
                data.func_143043_a(featureStart.func_143021_a(start.func_143019_e(), start.func_143018_f()), start.func_143019_e(), start.func_143018_f());
                data.func_76186_a(true);
            }
        }
    }
    
    public boolean isStructureConquered(final int mapX, final int mapY, final int mapZ) {
        boolean active = false;
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(mapX, mapZ, mapX, mapZ) && start instanceof StructureTFMajorFeatureStart) {
                active = ((StructureTFMajorFeatureStart)start).isConquered;
            }
        }
        return active;
    }
}
