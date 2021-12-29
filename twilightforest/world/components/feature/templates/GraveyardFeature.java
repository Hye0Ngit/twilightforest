// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.feature.templates;

import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.world.level.LevelReader;
import twilightforest.world.registration.TFStructureProcessors;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import twilightforest.TwilightForestMod;
import java.util.List;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import java.util.Random;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.properties.StructureMode;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;
import twilightforest.entity.monster.Wraith;
import twilightforest.entity.TFEntities;
import twilightforest.loot.TFTreasure;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.ChestBlock;
import java.util.Collection;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.apache.commons.lang3.tuple.Pair;
import java.util.ArrayList;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.block.Blocks;
import java.util.Iterator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.levelgen.Heightmap;
import com.google.common.math.StatsAccumulator;
import net.minecraft.core.Vec3i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import com.mojang.serialization.Codec;
import net.minecraft.world.level.material.Material;
import com.google.common.collect.ImmutableSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class GraveyardFeature extends Feature<NoneFeatureConfiguration>
{
    private static final ResourceLocation GRAVEYARD;
    private static final ResourceLocation TRAP;
    private static final ImmutableSet<Material> MATERIAL_WHITELIST;
    
    public GraveyardFeature(final Codec<NoneFeatureConfiguration> config) {
        super((Codec)config);
    }
    
    private static boolean offsetToAverageGroundLevel(final WorldGenLevel world, final BlockPos.MutableBlockPos startPos, final Vec3i size) {
        final StatsAccumulator heights = new StatsAccumulator();
        for (int dx = 0; dx < size.m_123341_(); ++dx) {
            for (int dz = 0; dz < size.m_123343_(); ++dz) {
                final int x = startPos.m_123341_() + dx;
                final int z = startPos.m_123343_() + dz;
                int y;
                for (y = world.m_6924_(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z); y >= 0; --y) {
                    final BlockState state = world.m_8055_(new BlockPos(x, y, z));
                    if (isBlockNotOk(state)) {
                        return false;
                    }
                    if (isBlockOk(state)) {
                        break;
                    }
                }
                if (y < 0) {
                    return false;
                }
                heights.add((double)y);
            }
        }
        if (heights.populationStandardDeviation() > 2.0) {
            return false;
        }
        final int baseY = (int)Math.round(heights.mean());
        final int maxY = (int)heights.max();
        startPos.m_142448_(baseY);
        return isAreaClear((BlockGetter)world, startPos.m_6630_(maxY - baseY + 1), startPos.m_141952_(size));
    }
    
    private static boolean isAreaClear(final BlockGetter world, final BlockPos min, final BlockPos max) {
        for (final BlockPos pos : BlockPos.m_121940_(min, max)) {
            final Material material = world.m_8055_(pos).m_60767_();
            if (!material.m_76336_() && !GraveyardFeature.MATERIAL_WHITELIST.contains((Object)material) && !material.m_76332_()) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isBlockOk(final BlockState state) {
        final Material material = state.m_60767_();
        return material == Material.f_76278_ || material == Material.f_76314_ || material == Material.f_76315_ || material == Material.f_76317_;
    }
    
    private static boolean isBlockNotOk(final BlockState state) {
        final Material material = state.m_60767_();
        return material == Material.f_76305_ || material == Material.f_76307_ || state.m_60734_() == Blocks.f_50752_;
    }
    
    public boolean m_142674_(final FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        final WorldGenLevel world = ctx.m_159774_();
        final BlockPos pos = ctx.m_159777_();
        final Random rand = ctx.m_159776_();
        final int flags = 19;
        final Random random = world.m_5822_();
        final StructureManager templatemanager = world.m_6018_().m_142572_().m_129909_();
        final StructureTemplate base = templatemanager.m_74341_(GraveyardFeature.GRAVEYARD);
        if (base == null) {
            return false;
        }
        final List<Pair<GraveType, StructureTemplate>> graves = new ArrayList<Pair<GraveType, StructureTemplate>>();
        final StructureTemplate trap = templatemanager.m_74341_(GraveyardFeature.TRAP);
        if (trap == null) {
            return false;
        }
        for (final GraveType type : GraveType.VALUES) {
            final StructureTemplate grave = templatemanager.m_74341_(type.RL);
            if (grave == null) {
                return false;
            }
            graves.add((Pair<GraveType, StructureTemplate>)Pair.of((Object)type, (Object)grave));
        }
        final Rotation[] rotations = Rotation.values();
        final Rotation rotation = rotations[random.nextInt(rotations.length)];
        final Mirror[] mirrors = Mirror.values();
        final Mirror mirror = mirrors[random.nextInt(mirrors.length + 1) % mirrors.length];
        final Vec3i transformedSize = base.m_163808_(rotation);
        final Vec3i transformedGraveSize = ((StructureTemplate)graves.get(0).getValue()).m_163808_(rotation);
        final ChunkPos chunkpos = new ChunkPos(pos.m_142082_(-8, 0, -8));
        final ChunkPos chunkendpos = new ChunkPos(pos.m_142082_(-8, 0, -8).m_141952_(transformedSize));
        final BoundingBox structureboundingbox = new BoundingBox(chunkpos.m_45604_() + 8, 0, chunkpos.m_45605_() + 8, chunkendpos.m_45608_() + 8, 255, chunkendpos.m_45609_() + 8);
        final StructurePlaceSettings placementsettings = new StructurePlaceSettings().m_74377_(mirror).m_74379_(rotation).m_74381_(structureboundingbox).m_74390_(random);
        final BlockPos posSnap = chunkpos.m_45615_().m_142082_(8, pos.m_123342_() - 1, 8);
        final BlockPos.MutableBlockPos startPos = new BlockPos.MutableBlockPos(posSnap.m_123341_(), posSnap.m_123342_(), posSnap.m_123343_());
        if (!offsetToAverageGroundLevel(world, startPos, transformedSize)) {
            return false;
        }
        final BlockPos placementPos = base.m_74583_((BlockPos)startPos, mirror, rotation).m_142082_(1, -1, 0);
        final Vec3i size = transformedSize.m_142082_(-1, 0, -1);
        final Vec3i graveSize = transformedGraveSize.m_142082_(-1, 0, -1);
        base.m_74536_((ServerLevelAccessor)world, placementPos, placementPos, placementsettings.m_74383_((StructureProcessor)new WebTemplateProcessor()), random, flags);
        final List<StructureTemplate.StructureBlockInfo> data = new ArrayList<StructureTemplate.StructureBlockInfo>(base.m_74603_(placementPos, placementsettings, Blocks.f_50677_));
        final BlockPos start = startPos.m_142082_(1, 1, 0);
        final BlockPos end = start.m_142082_(size.m_123341_(), 0, size.m_123343_());
        for (int x = 1; x <= size.m_123341_() - 1; ++x) {
            for (int z = 1; z <= size.m_123343_() - 1; ++z) {
                if (world.m_46859_(start.m_142082_(x, 0, z)) && rand.nextInt(12) == 0) {
                    world.m_7731_(start.m_142082_(x, 0, z), Blocks.f_50033_.m_49966_(), flags);
                }
            }
        }
        final BlockPos inner = start.m_142082_(2, 0, 2);
        final BlockPos bound = end.m_142082_(-2, 0, -2);
        final BlockPos innerSize = new BlockPos(bound.m_123341_() - inner.m_123341_(), bound.m_123342_() - inner.m_123342_(), bound.m_123343_() - inner.m_123343_());
        final BlockPos fixed = inner.m_142082_(((rotation == Rotation.CLOCKWISE_180) ? graveSize.m_123341_() : 0) + ((mirror == Mirror.FRONT_BACK) ? (transformedGraveSize.m_123341_() - 1) : 0) * ((rotation == Rotation.CLOCKWISE_180) ? -1 : 1), 0, ((rotation == Rotation.COUNTERCLOCKWISE_90) ? graveSize.m_123343_() : 0) + ((mirror == Mirror.FRONT_BACK) ? (transformedGraveSize.m_123343_() - 1) : 0) * ((rotation == Rotation.COUNTERCLOCKWISE_90) ? -1 : 1));
        final BlockPos fixedSize = innerSize.m_142082_(-graveSize.m_123341_(), 0, -graveSize.m_123343_());
        final BlockPos chestloc = new BlockPos(random.nextInt(2) - ((mirror == Mirror.FRONT_BACK) ? 1 : 0), 1, 0).m_7954_(rotation);
        for (int x2 = 0; x2 <= fixedSize.m_123341_(); x2 += ((rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.COUNTERCLOCKWISE_90) ? 2 : 5)) {
            for (int z2 = 0; z2 <= fixedSize.m_123343_(); z2 += ((rotation == Rotation.NONE || rotation == Rotation.CLOCKWISE_180) ? 2 : 5)) {
                if (x2 != innerSize.m_123341_() / 2) {
                    if (z2 != innerSize.m_123343_() / 2) {
                        BlockPos placement = fixed.m_142082_(x2, -2, z2);
                        final Pair<GraveType, StructureTemplate> grave2 = graves.get(rand.nextInt(graves.size()));
                        ((StructureTemplate)grave2.getValue()).m_74536_((ServerLevelAccessor)world, placement, placement, placementsettings, random, flags);
                        data.addAll(((StructureTemplate)grave2.getValue()).m_74603_(placement, placementsettings, Blocks.f_50677_));
                        if (grave2.getKey() == GraveType.Full && random.nextBoolean()) {
                            if (random.nextInt(3) == 0) {
                                placement = placement.m_141952_((Vec3i)new BlockPos((mirror == Mirror.FRONT_BACK) ? 1 : -1, 0, (mirror == Mirror.LEFT_RIGHT) ? 1 : -1).m_7954_(rotation));
                                trap.m_74536_((ServerLevelAccessor)world, placement, placement, placementsettings, random, flags);
                            }
                            data.addAll(trap.m_74603_(placementPos, placementsettings, Blocks.f_50677_));
                            if (world.m_7731_(placement.m_141952_((Vec3i)chestloc), ((BlockState)Blocks.f_50325_.m_49966_().m_61124_((Property)ChestBlock.f_51478_, (Comparable)Direction.WEST)).m_60717_(rotation).m_60715_(mirror), flags)) {
                                TFTreasure.GRAVEYARD.generateChestContents(world, placement.m_141952_((Vec3i)chestloc));
                                world.m_7731_(placement.m_141952_((Vec3i)chestloc).m_7495_(), Blocks.f_50079_.m_49966_(), 3);
                            }
                            final Wraith wraith = new Wraith(TFEntities.WRAITH, (Level)world.m_6018_());
                            wraith.m_6034_((double)placement.m_123341_(), (double)placement.m_123342_(), (double)placement.m_123343_());
                            world.m_7967_((Entity)wraith);
                        }
                    }
                }
            }
        }
        data.forEach(info -> {
            if (info.f_74677_ != null && StructureMode.valueOf(info.f_74677_.m_128461_("mode")) == StructureMode.DATA) {
                final String s = info.f_74677_.m_128461_("metadata");
                final BlockPos p = info.f_74675_;
                if ("spawner".equals(s)) {
                    world.m_7471_(p, false);
                    if (random.nextInt(4) == 0 && world.m_7731_(p, Blocks.f_50085_.m_49966_(), 3)) {
                        final SpawnerBlockEntity ms = (SpawnerBlockEntity)world.m_7702_(p);
                        if (ms != null) {
                            ms.m_59801_().m_45462_((EntityType)TFEntities.RISING_ZOMBIE);
                        }
                    }
                }
            }
            return;
        });
        return true;
    }
    
    static {
        GRAVEYARD = TwilightForestMod.prefix("feature/graveyard/graveyard");
        TRAP = TwilightForestMod.prefix("feature/graveyard/grave_trap");
        MATERIAL_WHITELIST = ImmutableSet.of((Object)Material.f_76314_, (Object)Material.f_76315_, (Object)Material.f_76274_, (Object)Material.f_76320_, (Object)Material.f_76300_, (Object)Material.f_76278_, (Object[])new Material[0]);
    }
    
    private enum GraveType
    {
        Full(TwilightForestMod.prefix("feature/graveyard/grave_full")), 
        Upper(TwilightForestMod.prefix("feature/graveyard/grave_upper")), 
        Lower(TwilightForestMod.prefix("feature/graveyard/grave_lower"));
        
        private static final GraveType[] VALUES;
        private final ResourceLocation RL;
        
        private GraveType(final ResourceLocation rl) {
            this.RL = rl;
        }
        
        static {
            VALUES = values();
        }
    }
    
    public static class WebTemplateProcessor extends StructureProcessor
    {
        public static final WebTemplateProcessor INSTANCE;
        public static final Codec<WebTemplateProcessor> CODEC;
        
        private WebTemplateProcessor() {
        }
        
        protected StructureProcessorType<?> m_6953_() {
            return TFStructureProcessors.WEB;
        }
        
        @Nullable
        public StructureTemplate.StructureBlockInfo process(final LevelReader worldIn, final BlockPos pos, final BlockPos piecepos, final StructureTemplate.StructureBlockInfo p_process_3_, final StructureTemplate.StructureBlockInfo blockInfo, final StructurePlaceSettings settings, @Nullable final StructureTemplate template) {
            return (blockInfo.f_74676_.m_60734_() == Blocks.f_50440_) ? blockInfo : ((settings.m_74399_(pos).nextInt(5) == 0) ? new StructureTemplate.StructureBlockInfo(pos, Blocks.f_50033_.m_49966_(), (CompoundTag)null) : blockInfo);
        }
        
        static {
            INSTANCE = new WebTemplateProcessor();
            CODEC = Codec.unit(() -> WebTemplateProcessor.INSTANCE);
        }
    }
}
