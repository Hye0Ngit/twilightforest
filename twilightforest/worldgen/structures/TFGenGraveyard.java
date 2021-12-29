// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen.structures;

import java.util.function.Function;
import net.minecraft.nbt.CompoundNBT;
import javax.annotation.Nullable;
import net.minecraft.world.IWorldReader;
import twilightforest.structures.TFStructureProcessors;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import twilightforest.structures.RandomizedTemplateProcessor;
import twilightforest.TwilightForestMod;
import net.minecraft.world.gen.feature.IFeatureConfig;
import java.util.List;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.state.properties.StructureMode;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import twilightforest.entity.WraithEntity;
import twilightforest.entity.TFEntities;
import twilightforest.loot.TFTreasure;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.ChestBlock;
import java.util.Collection;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.gen.feature.template.Template;
import org.apache.commons.lang3.tuple.Pair;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.block.Blocks;
import java.util.Iterator;
import net.minecraft.block.BlockState;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.gen.Heightmap;
import com.google.common.math.StatsAccumulator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import com.mojang.serialization.Codec;
import net.minecraft.block.material.Material;
import com.google.common.collect.ImmutableSet;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TFGenGraveyard extends Feature<NoFeatureConfig>
{
    private static final ResourceLocation GRAVEYARD;
    private static final ResourceLocation TRAP;
    private static final ImmutableSet<Material> MATERIAL_WHITELIST;
    
    public TFGenGraveyard(final Codec<NoFeatureConfig> config) {
        super((Codec)config);
    }
    
    private static boolean offsetToAverageGroundLevel(final ISeedReader world, final BlockPos.Mutable startPos, final BlockPos size) {
        final StatsAccumulator heights = new StatsAccumulator();
        for (int dx = 0; dx < size.func_177958_n(); ++dx) {
            for (int dz = 0; dz < size.func_177952_p(); ++dz) {
                final int x = startPos.func_177958_n() + dx;
                final int z = startPos.func_177952_p() + dz;
                int y;
                for (y = world.func_201676_a(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z); y >= 0; --y) {
                    final BlockState state = world.func_180495_p(new BlockPos(x, y, z));
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
        startPos.func_185336_p(baseY);
        return isAreaClear((IBlockReader)world, startPos.func_177981_b(maxY - baseY + 1), startPos.func_177971_a((Vector3i)size));
    }
    
    private static boolean isAreaClear(final IBlockReader world, final BlockPos min, final BlockPos max) {
        for (final BlockPos pos : BlockPos.func_218278_a(min, max)) {
            final Material material = world.func_180495_p(pos).func_185904_a();
            if (!material.func_76222_j() && !TFGenGraveyard.MATERIAL_WHITELIST.contains((Object)material) && !material.func_76224_d()) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isBlockOk(final BlockState state) {
        final Material material = state.func_185904_a();
        return material == Material.field_151576_e || material == Material.field_151578_c || material == Material.field_151577_b || material == Material.field_151595_p;
    }
    
    private static boolean isBlockNotOk(final BlockState state) {
        final Material material = state.func_185904_a();
        return material == Material.field_151586_h || material == Material.field_151587_i || state.func_177230_c() == Blocks.field_150357_h;
    }
    
    public boolean generate(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final NoFeatureConfig config) {
        final int flags = 19;
        final Random random = world.func_201674_k();
        final TemplateManager templatemanager = world.func_201672_e().func_73046_m().func_240792_aT_();
        final Template base = templatemanager.func_200219_b(TFGenGraveyard.GRAVEYARD);
        if (base == null) {
            return false;
        }
        final List<Pair<GraveType, Template>> graves = new ArrayList<Pair<GraveType, Template>>();
        final Template trap = templatemanager.func_200219_b(TFGenGraveyard.TRAP);
        if (trap == null) {
            return false;
        }
        for (final GraveType type : GraveType.VALUES) {
            final Template grave = templatemanager.func_200219_b(type.RL);
            if (grave == null) {
                return false;
            }
            graves.add((Pair<GraveType, Template>)Pair.of((Object)type, (Object)grave));
        }
        final Rotation[] rotations = Rotation.values();
        final Rotation rotation = rotations[random.nextInt(rotations.length)];
        final Mirror[] mirrors = Mirror.values();
        final Mirror mirror = mirrors[random.nextInt(mirrors.length + 1) % mirrors.length];
        final BlockPos transformedSize = base.func_186257_a(rotation);
        final BlockPos transformedGraveSize = ((Template)graves.get(0).getValue()).func_186257_a(rotation);
        final ChunkPos chunkpos = new ChunkPos(pos.func_177982_a(-8, 0, -8));
        final ChunkPos chunkendpos = new ChunkPos(pos.func_177982_a(-8, 0, -8).func_177971_a((Vector3i)transformedSize));
        final MutableBoundingBox structureboundingbox = new MutableBoundingBox(chunkpos.func_180334_c() + 8, 0, chunkpos.func_180333_d() + 8, chunkendpos.func_180332_e() + 8, 255, chunkendpos.func_180330_f() + 8);
        final PlacementSettings placementsettings = new PlacementSettings().func_186214_a(mirror).func_186220_a(rotation).func_186223_a(structureboundingbox).func_189950_a(random);
        final BlockPos posSnap = chunkpos.func_206849_h().func_177982_a(8, pos.func_177956_o() - 1, 8);
        final BlockPos.Mutable startPos = new BlockPos.Mutable(posSnap.func_177958_n(), posSnap.func_177956_o(), posSnap.func_177952_p());
        if (!offsetToAverageGroundLevel(world, startPos, transformedSize)) {
            return false;
        }
        final BlockPos placementPos = base.func_189961_a((BlockPos)startPos, mirror, rotation).func_177982_a(1, -1, 0);
        final BlockPos size = transformedSize.func_177982_a(-1, 0, -1);
        final BlockPos graveSize = transformedGraveSize.func_177982_a(-1, 0, -1);
        base.func_237146_a_((IServerWorld)world, placementPos, placementPos, placementsettings.func_215222_a((StructureProcessor)new WebTemplateProcessor(0.2f)), random, flags);
        final List<Template.BlockInfo> data = new ArrayList<Template.BlockInfo>(base.func_215381_a(placementPos, placementsettings, Blocks.field_185779_df));
        final BlockPos start = startPos.func_177982_a(1, 1, 0);
        final BlockPos end = start.func_177982_a(size.func_177958_n(), 0, size.func_177952_p());
        for (int x = 1; x <= size.func_177958_n() - 1; ++x) {
            for (int z = 1; z <= size.func_177952_p() - 1; ++z) {
                if (world.func_175623_d(start.func_177982_a(x, 0, z)) && rand.nextInt(12) == 0) {
                    world.func_180501_a(start.func_177982_a(x, 0, z), Blocks.field_196553_aF.func_176223_P(), flags);
                }
            }
        }
        final BlockPos inner = start.func_177982_a(2, 0, 2);
        final BlockPos bound = end.func_177982_a(-2, 0, -2);
        final BlockPos innerSize = new BlockPos(bound.func_177958_n() - inner.func_177958_n(), bound.func_177956_o() - inner.func_177956_o(), bound.func_177952_p() - inner.func_177952_p());
        final BlockPos fixed = inner.func_177982_a(((rotation == Rotation.CLOCKWISE_180) ? graveSize.func_177958_n() : 0) + ((mirror == Mirror.FRONT_BACK) ? (transformedGraveSize.func_177958_n() - 1) : 0) * ((rotation == Rotation.CLOCKWISE_180) ? -1 : 1), 0, ((rotation == Rotation.COUNTERCLOCKWISE_90) ? graveSize.func_177952_p() : 0) + ((mirror == Mirror.FRONT_BACK) ? (transformedGraveSize.func_177952_p() - 1) : 0) * ((rotation == Rotation.COUNTERCLOCKWISE_90) ? -1 : 1));
        final BlockPos fixedSize = innerSize.func_177982_a(-graveSize.func_177958_n(), 0, -graveSize.func_177952_p());
        final BlockPos chestloc = new BlockPos(random.nextInt(2) - ((mirror == Mirror.FRONT_BACK) ? 1 : 0), 1, 0).func_190942_a(rotation);
        for (int x2 = 0; x2 <= fixedSize.func_177958_n(); x2 += ((rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.COUNTERCLOCKWISE_90) ? 2 : 5)) {
            for (int z2 = 0; z2 <= fixedSize.func_177952_p(); z2 += ((rotation == Rotation.NONE || rotation == Rotation.CLOCKWISE_180) ? 2 : 5)) {
                if (x2 != innerSize.func_177958_n() / 2) {
                    if (z2 != innerSize.func_177952_p() / 2) {
                        BlockPos placement = fixed.func_177982_a(x2, -2, z2);
                        final Pair<GraveType, Template> grave2 = graves.get(rand.nextInt(graves.size()));
                        ((Template)grave2.getValue()).func_237146_a_((IServerWorld)world, placement, placement, placementsettings, random, flags);
                        data.addAll(((Template)grave2.getValue()).func_215381_a(placement, placementsettings, Blocks.field_185779_df));
                        if (grave2.getKey() == GraveType.Full && random.nextBoolean()) {
                            if (random.nextInt(3) == 0) {
                                placement = placement.func_177971_a((Vector3i)new BlockPos((mirror == Mirror.FRONT_BACK) ? 1 : -1, 0, (mirror == Mirror.LEFT_RIGHT) ? 1 : -1).func_190942_a(rotation));
                                trap.func_237146_a_((IServerWorld)world, placement, placement, placementsettings, random, flags);
                            }
                            data.addAll(trap.func_215381_a(placementPos, placementsettings, Blocks.field_185779_df));
                            if (world.func_180501_a(placement.func_177971_a((Vector3i)chestloc), ((BlockState)Blocks.field_150447_bR.func_176223_P().func_206870_a((Property)ChestBlock.field_176459_a, (Comparable)Direction.WEST)).func_185907_a(rotation).func_185902_a(mirror), flags)) {
                                TFTreasure.graveyard.generateChestContents(world, placement.func_177971_a((Vector3i)chestloc));
                                world.func_180501_a(placement.func_177971_a((Vector3i)chestloc).func_177977_b(), Blocks.field_150341_Y.func_176223_P(), 3);
                            }
                            final WraithEntity wraith = new WraithEntity(TFEntities.wraith, (World)world.func_201672_e());
                            wraith.func_70107_b((double)placement.func_177958_n(), (double)placement.func_177956_o(), (double)placement.func_177952_p());
                            world.func_217376_c((Entity)wraith);
                        }
                    }
                }
            }
        }
        data.forEach(info -> {
            if (info.field_186244_c != null && StructureMode.valueOf(info.field_186244_c.func_74779_i("mode")) == StructureMode.DATA) {
                final String s = info.field_186244_c.func_74779_i("metadata");
                final BlockPos p = info.field_186242_a;
                if ("spawner".equals(s)) {
                    world.func_217377_a(p, false);
                    if (random.nextInt(4) == 0 && world.func_180501_a(p, Blocks.field_150474_ac.func_176223_P(), 3)) {
                        final MobSpawnerTileEntity ms = (MobSpawnerTileEntity)world.func_175625_s(p);
                        if (ms != null) {
                            ms.func_145881_a().func_200876_a((EntityType)TFEntities.rising_zombie);
                        }
                    }
                }
            }
            return;
        });
        return true;
    }
    
    static {
        GRAVEYARD = TwilightForestMod.prefix("landscape/graveyard/graveyard");
        TRAP = TwilightForestMod.prefix("landscape/graveyard/grave_trap");
        MATERIAL_WHITELIST = ImmutableSet.of((Object)Material.field_151578_c, (Object)Material.field_151577_b, (Object)Material.field_151584_j, (Object)Material.field_151575_d, (Object)Material.field_151585_k, (Object)Material.field_151576_e, (Object[])new Material[0]);
    }
    
    private enum GraveType
    {
        Full(TwilightForestMod.prefix("landscape/graveyard/grave_full")), 
        Upper(TwilightForestMod.prefix("landscape/graveyard/grave_upper")), 
        Lower(TwilightForestMod.prefix("landscape/graveyard/grave_lower"));
        
        private static final GraveType[] VALUES;
        private final ResourceLocation RL;
        
        private GraveType(final ResourceLocation rl) {
            this.RL = rl;
        }
        
        static {
            VALUES = values();
        }
    }
    
    public static class WebTemplateProcessor extends RandomizedTemplateProcessor
    {
        public static final Codec<WebTemplateProcessor> codecWebProcessor;
        
        public WebTemplateProcessor(final float integrity) {
            super(integrity);
        }
        
        protected IStructureProcessorType<?> func_215192_a() {
            return TFStructureProcessors.WEB;
        }
        
        @Nullable
        public Template.BlockInfo process(final IWorldReader worldIn, final BlockPos pos, final BlockPos piecepos, final Template.BlockInfo p_process_3_, final Template.BlockInfo blockInfo, final PlacementSettings settings, @Nullable final Template template) {
            return (blockInfo.field_186243_b.func_177230_c() == Blocks.field_196658_i) ? blockInfo : ((settings.func_189947_a(pos).nextInt(5) == 0) ? new Template.BlockInfo(pos, Blocks.field_196553_aF.func_176223_P(), (CompoundNBT)null) : blockInfo);
        }
        
        static {
            codecWebProcessor = Codec.FLOAT.fieldOf("integrity").orElse((Object)1.0f).xmap((Function)WebTemplateProcessor::new, obj -> obj.integrity).codec();
        }
    }
}
