// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.features;

import javax.annotation.Nullable;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.structures.RandomizedTemplateProcessor;
import twilightforest.TwilightForestMod;
import java.util.List;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.EntityList;
import twilightforest.entity.EntityTFRisingZombie;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFWraith;
import twilightforest.loot.TFTreasure;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.BlockChest;
import net.minecraft.world.gen.structure.template.ITemplateProcessor;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.world.gen.structure.template.Template;
import org.apache.commons.lang3.tuple.Pair;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.init.Blocks;
import java.util.Iterator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.Vec3i;
import com.google.common.math.StatsAccumulator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import com.google.common.collect.ImmutableSet;
import net.minecraft.util.ResourceLocation;
import twilightforest.world.feature.TFGenerator;

public class TFGenGraveyard extends TFGenerator
{
    private static final ResourceLocation GRAVEYARD;
    private static final ResourceLocation TRAP;
    private static final ImmutableSet<Material> MATERIAL_WHITELIST;
    
    private static boolean offsetToAverageGroundLevel(final World world, final BlockPos.MutableBlockPos startPos, final BlockPos size) {
        final StatsAccumulator heights = new StatsAccumulator();
        for (int dx = 0; dx < size.func_177958_n(); ++dx) {
            for (int dz = 0; dz < size.func_177952_p(); ++dz) {
                final int x = startPos.func_177958_n() + dx;
                final int z = startPos.func_177952_p() + dz;
                int y;
                for (y = world.func_189649_b(x, z); y >= 0; --y) {
                    final IBlockState state = world.func_180495_p(new BlockPos(x, y, z));
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
        return isAreaClear((IBlockAccess)world, startPos.func_177981_b(maxY - baseY + 1), startPos.func_177971_a((Vec3i)size));
    }
    
    private static boolean isAreaClear(final IBlockAccess world, final BlockPos min, final BlockPos max) {
        for (final BlockPos pos : BlockPos.func_177975_b(min, max)) {
            final Material material = world.func_180495_p(pos).func_185904_a();
            if (!material.func_76222_j() && !TFGenGraveyard.MATERIAL_WHITELIST.contains((Object)material) && !material.func_76224_d()) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isBlockOk(final IBlockState state) {
        final Material material = state.func_185904_a();
        return material == Material.field_151576_e || material == Material.field_151578_c || material == Material.field_151577_b || material == Material.field_151595_p;
    }
    
    private static boolean isBlockNotOk(final IBlockState state) {
        final Material material = state.func_185904_a();
        return material == Material.field_151586_h || material == Material.field_151587_i || state.func_177230_c() == Blocks.field_150357_h;
    }
    
    public boolean func_180709_b(final World world, final Random rand, final BlockPos pos) {
        final int flags = 20;
        final Random random = world.func_175726_f(pos).func_76617_a(987234911L);
        final MinecraftServer minecraftserver = world.func_73046_m();
        final TemplateManager templatemanager = world.func_72860_G().func_186340_h();
        final Template base = templatemanager.func_186237_a(minecraftserver, TFGenGraveyard.GRAVEYARD);
        final List<Pair<GraveType, Template>> graves = new ArrayList<Pair<GraveType, Template>>();
        final Template trap = templatemanager.func_186237_a(minecraftserver, TFGenGraveyard.TRAP);
        for (final GraveType type : GraveType.VALUES) {
            graves.add((Pair<GraveType, Template>)Pair.of((Object)type, (Object)templatemanager.func_186237_a(minecraftserver, type.RL)));
        }
        final Rotation[] rotations = Rotation.values();
        final Rotation rotation = rotations[random.nextInt(rotations.length)];
        final Mirror[] mirrors = Mirror.values();
        final Mirror mirror = mirrors[random.nextInt(mirrors.length + 1) % mirrors.length];
        final BlockPos transformedSize = base.func_186257_a(rotation);
        final BlockPos transformedGraveSize = ((Template)graves.get(0).getValue()).func_186257_a(rotation);
        final ChunkPos chunkpos = new ChunkPos(pos.func_177982_a(-8, 0, -8));
        final ChunkPos chunkendpos = new ChunkPos(pos.func_177982_a(-8, 0, -8).func_177971_a((Vec3i)transformedSize));
        final StructureBoundingBox structureboundingbox = new StructureBoundingBox(chunkpos.func_180334_c() + 8, 0, chunkpos.func_180333_d() + 8, chunkendpos.func_180332_e() + 8, 255, chunkendpos.func_180330_f() + 8);
        final PlacementSettings placementsettings = new PlacementSettings().func_186214_a(mirror).func_186220_a(rotation).func_186223_a(structureboundingbox).func_189950_a(random);
        final BlockPos posSnap = chunkpos.func_180331_a(8, pos.func_177956_o() - 1, 8);
        final BlockPos.MutableBlockPos startPos = new BlockPos.MutableBlockPos(posSnap);
        if (!offsetToAverageGroundLevel(world, startPos, transformedSize)) {
            return false;
        }
        final BlockPos placementPos = base.func_189961_a((BlockPos)startPos, mirror, rotation).func_177982_a(1, -1, 0);
        final BlockPos size = transformedSize.func_177982_a(-1, 0, -1);
        final BlockPos graveSize = transformedGraveSize.func_177982_a(-1, 0, -1);
        base.func_189960_a(world, placementPos, (ITemplateProcessor)new WebTemplateProcessor(placementPos, placementsettings), placementsettings, flags);
        final BlockPos start = startPos.func_177982_a(1, 1, 0);
        final BlockPos end = start.func_177982_a(size.func_177958_n(), 0, size.func_177952_p());
        for (int x = 1; x <= size.func_177958_n() - 1; ++x) {
            for (int z = 1; z <= size.func_177952_p() - 1; ++z) {
                if (world.func_175623_d(start.func_177982_a(x, 0, z)) && rand.nextInt(12) == 0) {
                    world.func_180501_a(start.func_177982_a(x, 0, z), Blocks.field_150321_G.func_176223_P(), flags);
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
                        final BlockPos placement = fixed.func_177982_a(x2, -2, z2);
                        final Pair<GraveType, Template> grave = graves.get(rand.nextInt(graves.size()));
                        ((Template)grave.getValue()).func_189962_a(world, placement, placementsettings, flags);
                        if (grave.getKey() == GraveType.Full && random.nextBoolean()) {
                            if (random.nextInt(3) == 0) {
                                trap.func_189962_a(world, placement.func_177971_a((Vec3i)new BlockPos((mirror == Mirror.FRONT_BACK) ? 1 : -1, 0, (mirror == Mirror.LEFT_RIGHT) ? 1 : -1).func_190942_a(rotation)), placementsettings, flags);
                            }
                            if (world.func_180501_a(placement.func_177971_a((Vec3i)chestloc), Blocks.field_150447_bR.func_176223_P().func_177226_a((IProperty)BlockChest.field_176459_a, (Comparable)EnumFacing.WEST).func_185907_a(rotation).func_185902_a(mirror), flags)) {
                                TFTreasure.graveyard.generateChestContents(world, placement.func_177971_a((Vec3i)chestloc));
                            }
                            final EntityTFWraith wraith = new EntityTFWraith(world);
                            wraith.func_70634_a((double)placement.func_177958_n(), (double)placement.func_177956_o(), (double)placement.func_177952_p());
                            world.func_72838_d((Entity)wraith);
                        }
                        ((Template)grave.getValue()).func_186258_a(placement, placementsettings).forEach((p, s) -> {
                            if ("spawner".equals(s)) {
                                if (random.nextInt(4) == 0) {
                                    if (world.func_180501_a(p, Blocks.field_150474_ac.func_176223_P(), flags)) {
                                        final TileEntityMobSpawner ms = (TileEntityMobSpawner)world.func_175625_s(p);
                                        if (ms != null) {
                                            ms.func_145881_a().func_190894_a(EntityList.func_191306_a((Class)EntityTFRisingZombie.class));
                                        }
                                    }
                                }
                                else {
                                    world.func_175698_g(p);
                                }
                            }
                            return;
                        });
                    }
                }
            }
        }
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
    
    public class WebTemplateProcessor extends RandomizedTemplateProcessor
    {
        public WebTemplateProcessor(final BlockPos pos, final PlacementSettings settings) {
            super(pos, settings);
        }
        
        @Nullable
        public Template.BlockInfo func_189943_a(final World worldIn, final BlockPos pos, final Template.BlockInfo blockInfo) {
            return (blockInfo.field_186243_b.func_177230_c() == Blocks.field_150349_c) ? blockInfo : ((this.random.nextInt(5) == 0) ? new Template.BlockInfo(pos, Blocks.field_150321_G.func_176223_P(), (NBTTagCompound)null) : blockInfo);
        }
    }
}
