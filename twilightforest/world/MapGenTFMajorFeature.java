// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.util.StructureBoundingBoxUtils;
import com.google.common.base.Predicates;
import net.minecraft.util.EntitySelectors;
import twilightforest.advancements.TFAdvancements;
import net.minecraft.entity.player.EntityPlayerMP;
import twilightforest.structures.start.StructureStartTFFeatureAbstract;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Collections;
import net.minecraft.world.biome.Biome;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import java.util.Iterator;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import twilightforest.structures.StructureTFComponent;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.TwilightForestMod;
import net.minecraft.world.gen.structure.StructureStart;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import twilightforest.TFFeature;
import net.minecraft.world.gen.structure.MapGenStructure;

public class MapGenTFMajorFeature extends MapGenStructure
{
    private final TFFeature FEATURE;
    
    public MapGenTFMajorFeature() {
        this.FEATURE = TFFeature.NOTHING;
    }
    
    public MapGenTFMajorFeature(final TFFeature feature) {
        this.FEATURE = feature;
    }
    
    public TFFeature getFeature() {
        return (this.FEATURE != null) ? this.FEATURE : TFFeature.NOTHING;
    }
    
    public String func_143025_a() {
        return this.getFeature().name.toLowerCase();
    }
    
    @Nullable
    public BlockPos func_180706_b(final World worldIn, final BlockPos pos, final boolean findUnexplored) {
        this.field_75039_c = worldIn;
        return func_191069_a(worldIn, (MapGenStructure)this, pos, 20, 11, 10387313, true, 100, findUnexplored);
    }
    
    protected boolean func_75047_a(final int chunkX, final int chunkZ) {
        return this.FEATURE.isStructureEnabled && TFFeature.getFeatureDirectlyAt(chunkX, chunkZ, this.field_75039_c) == this.FEATURE;
    }
    
    protected StructureStart func_75049_b(final int chunkX, final int chunkZ) {
        this.field_75038_b.setSeed(this.field_75039_c.func_72905_C());
        final long rand1 = this.field_75038_b.nextLong();
        final long rand2 = this.field_75038_b.nextLong();
        final long chunkXr1 = chunkX * rand1;
        final long chunkZr2 = chunkZ * rand2;
        this.field_75038_b.setSeed(chunkXr1 ^ chunkZr2 ^ this.field_75039_c.func_72905_C());
        this.field_75038_b.nextInt();
        TwilightForestMod.LOGGER.debug("{} @ chunk [{}, {}]", (Object)this.FEATURE, (Object)chunkX, (Object)chunkZ);
        return this.getFeature().provideStructureStart(this.field_75039_c, this.field_75038_b, chunkX, chunkZ);
    }
    
    public int getSpawnListIndexAt(final BlockPos pos) {
        int highestFoundIndex = -1;
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(pos.func_177958_n(), pos.func_177952_p(), pos.func_177958_n(), pos.func_177952_p())) {
                for (final StructureComponent component : start.func_186161_c()) {
                    if (component.func_74874_b().func_175898_b((Vec3i)pos)) {
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
    
    @Nullable
    public List<Biome.SpawnListEntry> getPossibleCreatures(final EnumCreatureType creatureType, final BlockPos pos) {
        if (creatureType == EnumCreatureType.MONSTER && this.isStructureConquered(pos)) {
            return Collections.emptyList();
        }
        final int spawnListIndex = this.getSpawnListIndexAt(pos);
        if (spawnListIndex >= 0) {
            return this.getFeature().getSpawnableList(creatureType, spawnListIndex);
        }
        return null;
    }
    
    @Nullable
    public StructureBoundingBox getSBBAt(final BlockPos pos) {
        StructureBoundingBox boxFound = null;
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(pos.func_177958_n(), pos.func_177952_p(), pos.func_177958_n(), pos.func_177952_p())) {
                for (final StructureComponent component : start.func_186161_c()) {
                    if (component.func_74874_b().func_175898_b((Vec3i)pos)) {
                        boxFound = component.func_74874_b();
                    }
                }
            }
        }
        return boxFound;
    }
    
    public TFFeature getFeatureAt(final BlockPos pos) {
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(pos.func_177958_n(), pos.func_177952_p(), pos.func_177958_n(), pos.func_177952_p())) {
                for (final StructureComponent component : start.func_186161_c()) {
                    if (component.func_74874_b().func_175898_b((Vec3i)pos) && component instanceof StructureTFComponent) {
                        return ((StructureTFComponent)component).getFeatureType();
                    }
                }
            }
        }
        return TFFeature.NOTHING;
    }
    
    public boolean isBlockProtectedAt(final BlockPos pos) {
        boolean blockProtected = false;
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(pos.func_177958_n(), pos.func_177952_p(), pos.func_177958_n(), pos.func_177952_p())) {
                for (final StructureComponent component : start.func_186161_c()) {
                    if (component.func_74874_b().func_175898_b((Vec3i)pos)) {
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
    
    public void setStructureConquered(final BlockPos pos, final boolean flag) {
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(pos.func_177958_n(), pos.func_177952_p(), pos.func_177958_n(), pos.func_177952_p()) && start instanceof StructureStartTFFeatureAbstract) {
                final StructureStartTFFeatureAbstract featureStart = (StructureStartTFFeatureAbstract)start;
                featureStart.isConquered = flag;
                this.field_143029_e.func_143043_a(featureStart.func_143021_a(start.func_143019_e(), start.func_143018_f()), start.func_143019_e(), start.func_143018_f());
                this.field_143029_e.func_76186_a(true);
                if (!flag) {
                    continue;
                }
                for (final EntityPlayerMP player : this.getPlayersInsideStructure(start)) {
                    TFAdvancements.STRUCTURE_CLEARED.trigger(player, this.FEATURE.name);
                }
            }
        }
    }
    
    private List<EntityPlayerMP> getPlayersInsideStructure(final StructureStart start) {
        return this.field_75039_c.func_175661_b((Class)EntityPlayerMP.class, Predicates.and(EntitySelectors.field_94557_a, p -> p.func_174813_aQ().func_72326_a(StructureBoundingBoxUtils.toAABB(start.func_75071_a()))));
    }
    
    public boolean isStructureConquered(final BlockPos pos) {
        boolean conquered = false;
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(pos.func_177958_n(), pos.func_177952_p(), pos.func_177958_n(), pos.func_177952_p()) && start instanceof StructureStartTFFeatureAbstract) {
                conquered = ((StructureStartTFFeatureAbstract)start).isConquered;
            }
        }
        return conquered;
    }
    
    public boolean isStructureLocked(final BlockPos pos, final int lockIndex) {
        boolean locked = false;
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(pos.func_177958_n(), pos.func_177952_p(), pos.func_177958_n(), pos.func_177952_p()) && start instanceof StructureStartTFFeatureAbstract) {
                locked = ((StructureStartTFFeatureAbstract)start).isLocked(lockIndex);
            }
        }
        return locked;
    }
    
    public boolean isBlockInFullStructure(final int mapX, final int mapZ) {
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(mapX, mapZ, mapX, mapZ)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isBlockNearFullStructure(final int mapX, final int mapZ, final int range) {
        final StructureBoundingBox rangeBB = new StructureBoundingBox(mapX - range, mapZ - range, mapX + range, mapZ + range);
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78884_a(rangeBB)) {
                return true;
            }
        }
        return false;
    }
    
    @Nullable
    public StructureBoundingBox getFullSBBAt(final int mapX, final int mapZ) {
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78885_a(mapX, mapZ, mapX, mapZ)) {
                return start.func_75071_a();
            }
        }
        return null;
    }
    
    @Nullable
    public StructureBoundingBox getFullSBBNear(final int mapX, final int mapZ, final int range) {
        final StructureBoundingBox rangeBB = new StructureBoundingBox(mapX - range, mapZ - range, mapX + range, mapZ + range);
        for (final StructureStart start : this.field_75053_d.values()) {
            if (start.func_75069_d() && start.func_75071_a().func_78884_a(rangeBB)) {
                return start.func_75071_a();
            }
        }
        return null;
    }
}
