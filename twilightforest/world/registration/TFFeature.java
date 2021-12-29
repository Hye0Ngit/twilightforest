// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import twilightforest.world.registration.biomes.BiomeKeys;
import com.google.common.collect.ImmutableMap;
import twilightforest.world.components.structures.mushroomtower.MushroomTowerMainComponent;
import twilightforest.world.components.structures.finalcastle.FinalCastleMainComponent;
import twilightforest.world.components.structures.trollcave.TrollCaveMainComponent;
import twilightforest.world.components.structures.trollcave.TrollCavePieces;
import twilightforest.world.components.structures.icetower.IceTowerMainComponent;
import twilightforest.world.components.structures.YetiCaveComponent;
import twilightforest.world.components.structures.stronghold.StrongholdEntranceComponent;
import twilightforest.world.components.structures.darktower.DarkTowerMainComponent;
import twilightforest.world.components.structures.minotaurmaze.MazeRuinsComponent;
import twilightforest.world.components.structures.HydraLairComponent;
import twilightforest.world.components.structures.lichtower.TowerMainComponent;
import twilightforest.world.components.structures.courtyard.CourtyardMain;
import twilightforest.world.components.structures.QuestGrove;
import twilightforest.world.components.structures.HedgeMazeComponent;
import twilightforest.world.components.structures.HollowHillComponent;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.core.Direction;
import twilightforest.TwilightForestMod;
import java.util.Locale;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelReader;
import twilightforest.entity.monster.Kobold;
import twilightforest.entity.TFEntities;
import net.minecraft.world.level.Level;
import twilightforest.util.PlayerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobCategory;
import java.util.Collection;
import javax.annotation.Nullable;
import twilightforest.util.IntPair;
import java.util.Random;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import java.util.ArrayList;
import net.minecraft.world.level.biome.MobSpawnSettings;
import java.util.List;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.resources.ResourceLocation;
import java.util.Map;

public class TFFeature
{
    public static final TFFeature NOTHING;
    public static final TFFeature SMALL_HILL;
    public static final TFFeature MEDIUM_HILL;
    public static final TFFeature LARGE_HILL;
    public static final TFFeature HEDGE_MAZE;
    public static final TFFeature QUEST_GROVE;
    public static final TFFeature NAGA_COURTYARD;
    public static final TFFeature LICH_TOWER;
    public static final TFFeature HYDRA_LAIR;
    public static final TFFeature LABYRINTH;
    public static final TFFeature DARK_TOWER;
    public static final TFFeature KNIGHT_STRONGHOLD;
    public static final TFFeature YETI_CAVE;
    public static final TFFeature ICE_TOWER;
    public static final TFFeature TROLL_CAVE;
    public static final TFFeature FINAL_CASTLE;
    public static final TFFeature MUSHROOM_TOWER;
    public static final TFFeature QUEST_ISLAND;
    private static final Map<ResourceLocation, TFFeature> BIOME_FEATURES;
    public static final StructurePieceType TFHill;
    public static final StructurePieceType TFHedge;
    public static final StructurePieceType TFQuestGrove;
    public static final StructurePieceType TFHydra;
    public static final StructurePieceType TFYeti;
    public final int size;
    public final String name;
    public final boolean centerBounds;
    public boolean surfaceDecorationsAllowed;
    public boolean undergroundDecoAllowed;
    public boolean isStructureEnabled;
    public boolean requiresTerraforming;
    private final ResourceLocation[] requiredAdvancements;
    public boolean hasProtectionAura;
    protected boolean adjustToTerrainHeight;
    private static int maxPossibleSize;
    private List<List<MobSpawnSettings.SpawnerData>> spawnableMonsterLists;
    private List<MobSpawnSettings.SpawnerData> ambientCreatureList;
    private List<MobSpawnSettings.SpawnerData> waterCreatureList;
    private long lastSpawnedHintMonsterTime;
    private static final String BOOK_AUTHOR = "A Forgotten Explorer";
    
    TFFeature(final int size, final String name, final boolean featureGenerator, final ResourceLocation... requiredAdvancements) {
        this(size, name, featureGenerator, false, requiredAdvancements);
    }
    
    TFFeature(final int size, final String name, final boolean featureGenerator, final boolean centerBounds, final ResourceLocation... requiredAdvancements) {
        this.surfaceDecorationsAllowed = false;
        this.undergroundDecoAllowed = true;
        this.isStructureEnabled = true;
        this.requiresTerraforming = false;
        this.hasProtectionAura = true;
        this.adjustToTerrainHeight = false;
        this.spawnableMonsterLists = new ArrayList<List<MobSpawnSettings.SpawnerData>>();
        this.ambientCreatureList = new ArrayList<MobSpawnSettings.SpawnerData>();
        this.waterCreatureList = new ArrayList<MobSpawnSettings.SpawnerData>();
        this.size = size;
        this.name = name;
        this.requiredAdvancements = requiredAdvancements;
        this.centerBounds = centerBounds;
        TFFeature.maxPossibleSize = Math.max(this.size, TFFeature.maxPossibleSize);
    }
    
    static void init() {
    }
    
    public static int getMaxSize() {
        return TFFeature.maxPossibleSize;
    }
    
    public boolean shouldAdjustToTerrain() {
        return this.adjustToTerrainHeight;
    }
    
    public static TFFeature getFeatureAt(final int regionX, final int regionZ, final WorldGenLevel world) {
        return generateFeature(regionX >> 4, regionZ >> 4, world);
    }
    
    public static boolean isInFeatureChunk(final int regionX, final int regionZ) {
        final int chunkX = regionX >> 4;
        final int chunkZ = regionZ >> 4;
        final BlockPos cc = getNearestCenterXYZ(chunkX, chunkZ);
        return chunkX == cc.m_123341_() >> 4 && chunkZ == cc.m_123343_() >> 4;
    }
    
    public TFFeature enableDecorations() {
        this.surfaceDecorationsAllowed = true;
        return this;
    }
    
    public TFFeature disableStructure() {
        this.enableDecorations();
        this.isStructureEnabled = false;
        return this;
    }
    
    public TFFeature enableTerrainAlterations() {
        this.requiresTerraforming = true;
        return this;
    }
    
    public TFFeature disableProtectionAura() {
        this.hasProtectionAura = false;
        return this;
    }
    
    public TFFeature addMonster(final EntityType<? extends LivingEntity> monsterClass, final int weight, final int minGroup, final int maxGroup) {
        this.addMonster(0, monsterClass, weight, minGroup, maxGroup);
        return this;
    }
    
    public TFFeature addMonster(final int listIndex, final EntityType<? extends LivingEntity> monsterClass, final int weight, final int minGroup, final int maxGroup) {
        List<MobSpawnSettings.SpawnerData> monsterList;
        if (this.spawnableMonsterLists.size() > listIndex) {
            monsterList = this.spawnableMonsterLists.get(listIndex);
        }
        else {
            monsterList = new ArrayList<MobSpawnSettings.SpawnerData>();
            this.spawnableMonsterLists.add(listIndex, monsterList);
        }
        monsterList.add(new MobSpawnSettings.SpawnerData((EntityType)monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public TFFeature addWaterCreature(final EntityType<? extends LivingEntity> monsterClass, final int weight, final int minGroup, final int maxGroup) {
        this.waterCreatureList.add(new MobSpawnSettings.SpawnerData((EntityType)monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public static TFFeature getFeatureDirectlyAt(final int chunkX, final int chunkZ, final WorldGenLevel world) {
        if (isInFeatureChunk(chunkX << 4, chunkZ << 4)) {
            return getFeatureAt(chunkX << 4, chunkZ << 4, world);
        }
        return TFFeature.NOTHING;
    }
    
    public static TFFeature generateFeature(int chunkX, int chunkZ, final WorldGenLevel world) {
        chunkX = Math.round(chunkX / 16.0f) * 16;
        chunkZ = Math.round(chunkZ / 16.0f) * 16;
        final Biome biomeAt = world.m_46857_(new BlockPos((chunkX << 4) + 8, 0, (chunkZ << 4) + 8));
        return generateFeature(chunkX, chunkZ, biomeAt, world.m_7328_());
    }
    
    public static TFFeature generateFeature(int chunkX, int chunkZ, final Biome biome, final long seed) {
        chunkX = Math.round(chunkX / 16.0f) * 16;
        chunkZ = Math.round(chunkZ / 16.0f) * 16;
        final TFFeature biomeFeature = TFFeature.BIOME_FEATURES.get(biome.getRegistryName());
        if (biomeFeature != null) {
            return biomeFeature;
        }
        final int regionOffsetX = Math.abs((chunkX + 64 >> 4) % 8);
        final int regionOffsetZ = Math.abs((chunkZ + 64 >> 4) % 8);
        if ((regionOffsetX == 4 && regionOffsetZ == 5) || (regionOffsetX == 4 && regionOffsetZ == 3)) {
            return TFFeature.LICH_TOWER;
        }
        if ((regionOffsetX == 5 && regionOffsetZ == 4) || (regionOffsetX == 3 && regionOffsetZ == 4)) {
            return TFFeature.NAGA_COURTYARD;
        }
        return switch (new Random(seed + chunkX * 25117L + chunkZ * 151121L).nextInt(16)) {
            case 6,  7,  8 -> TFFeature.MEDIUM_HILL;
            case 9 -> TFFeature.LARGE_HILL;
            case 10,  11 -> TFFeature.HEDGE_MAZE;
            case 12,  13 -> TFFeature.NAGA_COURTYARD;
            case 14,  15 -> TFFeature.LICH_TOWER;
            default -> TFFeature.SMALL_HILL;
        };
    }
    
    public static TFFeature getNearestFeature(final int cx, final int cz, final WorldGenLevel world) {
        return getNearestFeature(cx, cz, world, null);
    }
    
    public static TFFeature getNearestFeature(final int cx, final int cz, final WorldGenLevel world, @Nullable final IntPair center) {
        final int maxSize = getMaxSize();
        final int diam = maxSize * 2 + 1;
        final TFFeature[] features = new TFFeature[diam * diam];
        for (int rad = 1; rad <= maxSize; ++rad) {
            for (int x = -rad; x <= rad; ++x) {
                for (int z = -rad; z <= rad; ++z) {
                    final int idx = (x + maxSize) * diam + (z + maxSize);
                    TFFeature directlyAt = features[idx];
                    if (directlyAt == null) {
                        directlyAt = (features[idx] = getFeatureDirectlyAt(x + cx, z + cz, world));
                    }
                    if (directlyAt.size == rad) {
                        if (center != null) {
                            center.x = (x << 4) + 8;
                            center.z = (z << 4) + 8;
                        }
                        return directlyAt;
                    }
                }
            }
        }
        return TFFeature.NOTHING;
    }
    
    @Nullable
    public static BlockPos findNearestFeaturePosBySpacing(final WorldGenLevel worldIn, final TFFeature feature, final BlockPos blockPos, final int p_191069_3_, final int p_191069_4_, final int p_191069_5_, final boolean p_191069_6_, final int p_191069_7_, final boolean findUnexplored) {
        final int i = blockPos.m_123341_() >> 4;
        final int j = blockPos.m_123343_() >> 4;
        int k = 0;
        final Random random = new Random();
        while (k <= p_191069_7_) {
            for (int l = -k; l <= k; ++l) {
                final boolean flag = l == -k || l == k;
                for (int i2 = -k; i2 <= k; ++i2) {
                    final boolean flag2 = i2 == -k || i2 == k;
                    if (flag || flag2) {
                        int j2 = i + p_191069_3_ * l;
                        int k2 = j + p_191069_3_ * i2;
                        if (j2 < 0) {
                            j2 -= p_191069_3_ - 1;
                        }
                        if (k2 < 0) {
                            k2 -= p_191069_3_ - 1;
                        }
                        int l2 = j2 / p_191069_3_;
                        int i3 = k2 / p_191069_3_;
                        final Random random2 = new Random();
                        l2 *= p_191069_3_;
                        i3 *= p_191069_3_;
                        if (p_191069_6_) {
                            l2 += (random2.nextInt(p_191069_3_ - p_191069_4_) + random2.nextInt(p_191069_3_ - p_191069_4_)) / 2;
                            i3 += (random2.nextInt(p_191069_3_ - p_191069_4_) + random2.nextInt(p_191069_3_ - p_191069_4_)) / 2;
                        }
                        else {
                            l2 += random2.nextInt(p_191069_3_ - p_191069_4_);
                            i3 += random2.nextInt(p_191069_3_ - p_191069_4_);
                        }
                        random.nextInt();
                        if (getFeatureAt(l2 << 4, i3 << 4, (WorldGenLevel)worldIn.m_6018_()) == feature) {
                            if (!findUnexplored || !worldIn.m_7232_(l2, i3)) {
                                return new BlockPos((l2 << 4) + 8, 64, (i3 << 4) + 8);
                            }
                        }
                        else if (k == 0) {
                            break;
                        }
                    }
                }
                if (k == 0) {
                    break;
                }
            }
            ++k;
        }
        return null;
    }
    
    public static TFFeature getFeatureForRegion(final int chunkX, final int chunkZ, final WorldGenLevel world) {
        final int featureX = Math.round(chunkX / 16.0f) * 16;
        final int featureZ = Math.round(chunkZ / 16.0f) * 16;
        return generateFeature(featureX, featureZ, world);
    }
    
    public static TFFeature getFeatureForRegionPos(final int posX, final int posZ, final WorldGenLevel world) {
        return getFeatureForRegion(posX >> 4, posZ >> 4, world);
    }
    
    public static BlockPos getNearestCenterXYZ(final int chunkX, final int chunkZ) {
        final int regionX = chunkX + 8 >> 4;
        final int regionZ = chunkZ + 8 >> 4;
        long seed = (long)(regionX * 3129871) ^ regionZ * 116129781L;
        seed = seed * seed * 42317861L + seed * 7L;
        final int num0 = (int)(seed >> 12 & 0x3L);
        final int num2 = (int)(seed >> 15 & 0x3L);
        final int num3 = (int)(seed >> 18 & 0x3L);
        final int num4 = (int)(seed >> 21 & 0x3L);
        final int centerX = 8 + num0 - num2;
        final int centerZ = 8 + num3 - num4;
        int ccz;
        if (regionZ >= 0) {
            ccz = (regionZ * 16 + centerZ - 8) * 16 + 8;
        }
        else {
            ccz = (regionZ * 16 + (16 - centerZ) - 8) * 16 + 9;
        }
        int ccx;
        if (regionX >= 0) {
            ccx = (regionX * 16 + centerX - 8) * 16 + 8;
        }
        else {
            ccx = (regionX * 16 + (16 - centerX) - 8) * 16 + 9;
        }
        return new BlockPos(ccx, 0, ccz);
    }
    
    public List<MobSpawnSettings.SpawnerData> getCombinedMonsterSpawnableList() {
        final List<MobSpawnSettings.SpawnerData> list = new ArrayList<MobSpawnSettings.SpawnerData>();
        this.spawnableMonsterLists.forEach(l -> {
            if (l != null) {
                list.addAll(l);
            }
            return;
        });
        return list;
    }
    
    public List<MobSpawnSettings.SpawnerData> getCombinedCreatureSpawnableList() {
        final List<MobSpawnSettings.SpawnerData> list = new ArrayList<MobSpawnSettings.SpawnerData>();
        list.addAll(this.ambientCreatureList);
        list.addAll(this.waterCreatureList);
        return list;
    }
    
    public List<MobSpawnSettings.SpawnerData> getSpawnableList(final MobCategory creatureType) {
        return switch (creatureType) {
            case MONSTER -> this.getSpawnableMonsterList(0);
            case AMBIENT -> this.ambientCreatureList;
            case WATER_CREATURE -> this.waterCreatureList;
            default -> new ArrayList<MobSpawnSettings.SpawnerData>();
        };
    }
    
    public List<MobSpawnSettings.SpawnerData> getSpawnableMonsterList(final int index) {
        if (index >= 0 && index < this.spawnableMonsterLists.size()) {
            return this.spawnableMonsterLists.get(index);
        }
        return new ArrayList<MobSpawnSettings.SpawnerData>();
    }
    
    public boolean doesPlayerHaveRequiredAdvancements(final Player player) {
        return PlayerHelper.doesPlayerHaveRequiredAdvancements(player, this.requiredAdvancements);
    }
    
    public void trySpawnHintMonster(final Level world, final Player player) {
        this.trySpawnHintMonster(world, player, player.m_142538_());
    }
    
    public void trySpawnHintMonster(final Level world, final Player player, final BlockPos pos) {
        final long currentTime = world.m_46467_();
        if (currentTime < this.lastSpawnedHintMonsterTime) {
            this.lastSpawnedHintMonsterTime = 0L;
        }
        if (currentTime - this.lastSpawnedHintMonsterTime > 1200L) {
            for (int i = 0; i < 20; ++i) {
                if (this.didSpawnHintMonster(world, player, pos)) {
                    this.lastSpawnedHintMonsterTime = currentTime;
                    break;
                }
            }
        }
    }
    
    private boolean didSpawnHintMonster(final Level world, final Player player, final BlockPos pos) {
        final int dx = world.f_46441_.nextInt(16) - world.f_46441_.nextInt(16);
        final int dy = world.f_46441_.nextInt(4) - world.f_46441_.nextInt(4);
        final int dz = world.f_46441_.nextInt(16) - world.f_46441_.nextInt(16);
        final Kobold hinty = new Kobold(TFEntities.KOBOLD, world);
        hinty.m_20035_(pos.m_142082_(dx, dy, dz), 0.0f, 0.0f);
        if (hinty.m_6914_((LevelReader)world) && hinty.m_21574_().m_148306_((Entity)player)) {
            final ItemStack book = this.createHintBook();
            hinty.m_8061_(EquipmentSlot.MAINHAND, book);
            hinty.m_21409_(EquipmentSlot.MAINHAND, 1.0f);
            world.m_7967_((Entity)hinty);
            return true;
        }
        return false;
    }
    
    public ItemStack createHintBook() {
        final ItemStack book = new ItemStack((ItemLike)Items.f_42615_);
        this.addBookInformation(book, new ListTag());
        return book;
    }
    
    protected void addBookInformation(final ItemStack book, final ListTag bookPages) {
        addTranslatedPages(bookPages, "twilightforest.book.unknown", 2);
        book.m_41700_("pages", (Tag)bookPages);
        book.m_41700_("author", (Tag)StringTag.m_129297_("A Forgotten Explorer"));
        book.m_41700_("title", (Tag)StringTag.m_129297_("Notes on the Unexplained"));
    }
    
    @Nullable
    public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
        return null;
    }
    
    public GenerationStep.Decoration getDecorationStage() {
        return GenerationStep.Decoration.SURFACE_STRUCTURES;
    }
    
    private static void addTranslatedPages(final ListTag bookPages, final String translationKey, final int pageCount) {
        for (int i = 1; i <= pageCount; ++i) {
            bookPages.add((Object)StringTag.m_129297_(Component.Serializer.m_130703_((Component)new TranslatableComponent(translationKey + "." + i))));
        }
    }
    
    public static StructurePieceType registerPiece(final String name, final StructurePieceType piece) {
        return (StructurePieceType)Registry.m_122965_(Registry.f_122843_, TwilightForestMod.prefix(name.toLowerCase(Locale.ROOT)), (Object)piece);
    }
    
    public final BoundingBox getComponentToAddBoundingBox(int x, int y, int z, final int minX, final int minY, final int minZ, final int spanX, final int spanY, final int spanZ, @Nullable final Direction dir) {
        if (this.centerBounds) {
            x += (spanX + minX) / 4;
            y += (spanY + minY) / 4;
            z += (spanZ + minZ) / 4;
        }
        return switch (dir) {
            case WEST -> new BoundingBox(x - spanZ + minZ, y + minY, z + minX, x + minZ, y + spanY + minY, z + spanX + minX);
            case NORTH -> new BoundingBox(x - spanX - minX, y + minY, z - spanZ - minZ, x - minX, y + spanY + minY, z - minZ);
            case EAST -> new BoundingBox(x + minZ, y + minY, z - spanX, x + spanZ + minZ, y + spanY + minY, z + minX);
            default -> new BoundingBox(x + minX, y + minY, z + minZ, x + spanX + minX, y + spanY + minY, z + spanZ + minZ);
        };
    }
    
    public static boolean isTheseFeatures(final TFFeature feature, final TFFeature... predicates) {
        for (final TFFeature predicate : predicates) {
            if (feature == predicate) {
                return true;
            }
        }
        return false;
    }
    
    static {
        NOTHING = new TFFeature("no_feature", false, new ResourceLocation[0]) {
            {
                this.enableDecorations().disableStructure();
            }
        };
        SMALL_HILL = new TFFeature("small_hollow_hill", true, true, new ResourceLocation[0]) {
            {
                this.enableDecorations().enableTerrainAlterations();
                this.undergroundDecoAllowed = false;
                this.addMonster((EntityType<? extends LivingEntity>)EntityType.f_20479_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20501_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.REDCAP, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.SWARM_SPIDER, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.KOBOLD, 10, 4, 8);
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new HollowHillComponent(TFFeature.TFHill, this, 0, this.size, x - 3, y - 2, z - 3);
            }
        };
        MEDIUM_HILL = new TFFeature("medium_hollow_hill", true, true, new ResourceLocation[0]) {
            {
                this.enableDecorations().enableTerrainAlterations();
                this.undergroundDecoAllowed = false;
                this.addMonster((EntityType<? extends LivingEntity>)TFEntities.REDCAP, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.REDCAP_SAPPER, 1, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.KOBOLD, 10, 4, 8).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20524_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.SWARM_SPIDER, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20479_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20558_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.FIRE_BEETLE, 5, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.SLIME_BEETLE, 5, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20495_, 1, 1, 1);
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new HollowHillComponent(TFFeature.TFHill, this, 0, this.size, x - 7, y - 5, z - 7);
            }
        };
        LARGE_HILL = new TFFeature("large_hollow_hill", true, true, new ResourceLocation[0]) {
            {
                this.enableDecorations().enableTerrainAlterations();
                this.undergroundDecoAllowed = false;
                this.addMonster((EntityType<? extends LivingEntity>)TFEntities.REDCAP, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.REDCAP_SAPPER, 2, 1, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20524_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20554_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20558_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20566_, 1, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.WRAITH, 2, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.FIRE_BEETLE, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.SLIME_BEETLE, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.PINCH_BEETLE, 10, 2, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20495_, 1, 1, 1);
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new HollowHillComponent(TFFeature.TFHill, this, 0, this.size, x - 11, y - 5, z - 11);
            }
        };
        HEDGE_MAZE = new TFFeature("hedge_maze", true, new ResourceLocation[0]) {
            {
                this.enableTerrainAlterations();
                this.adjustToTerrainHeight = true;
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new HedgeMazeComponent(this, 0, x + 1, y + 4, z + 1);
            }
        };
        QUEST_GROVE = new TFFeature("quest_grove", true, new ResourceLocation[0]) {
            {
                this.enableTerrainAlterations();
                this.adjustToTerrainHeight = true;
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return (StructurePiece)new QuestGrove(structureManager, new BlockPos(x - 12, y, z - 12));
            }
        };
        NAGA_COURTYARD = new TFFeature("naga_courtyard", true, new ResourceLocation[0]) {
            {
                this.enableTerrainAlterations();
                this.adjustToTerrainHeight = true;
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new CourtyardMain(this, rand, 0, x + 1, y + 1, z + 1, structureManager);
            }
        };
        LICH_TOWER = new TFFeature("lich_tower", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_naga") }) {
            {
                this.addMonster((EntityType<? extends LivingEntity>)EntityType.f_20501_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20524_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20558_, 1, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20566_, 1, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.DEATH_TOME, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20495_, 1, 1, 1);
                this.adjustToTerrainHeight = true;
            }
            
            @Override
            protected void addBookInformation(final ItemStack book, final ListTag bookPages) {
                TFFeature.addTranslatedPages(bookPages, "twilightforest.book.lichtower", 4);
                book.m_41700_("pages", (Tag)bookPages);
                book.m_41700_("author", (Tag)StringTag.m_129297_("A Forgotten Explorer"));
                book.m_41700_("title", (Tag)StringTag.m_129297_("Notes on a Pointy Tower"));
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new TowerMainComponent(this, rand, 0, x, y, z);
            }
        };
        HYDRA_LAIR = new TFFeature("hydra_lair", true, true, new ResourceLocation[] { TwilightForestMod.prefix("progress_labyrinth") }) {
            {
                this.enableTerrainAlterations();
                this.undergroundDecoAllowed = false;
            }
            
            @Override
            protected void addBookInformation(final ItemStack book, final ListTag bookPages) {
                TFFeature.addTranslatedPages(bookPages, "twilightforest.book.hydralair", 4);
                book.m_41700_("pages", (Tag)bookPages);
                book.m_41700_("author", (Tag)StringTag.m_129297_("A Forgotten Explorer"));
                book.m_41700_("title", (Tag)StringTag.m_129297_("Notes on the Fire Swamp"));
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new HydraLairComponent(this, rand, 0, x - 7, y, z - 7);
            }
        };
        LABYRINTH = new TFFeature("labyrinth", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_lich") }) {
            {
                this.enableDecorations();
                this.undergroundDecoAllowed = false;
                this.addMonster((EntityType<? extends LivingEntity>)TFEntities.MINOTAUR, 20, 2, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20554_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20558_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.MAZE_SLIME, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20566_, 1, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.FIRE_BEETLE, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.SLIME_BEETLE, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.PINCH_BEETLE, 10, 2, 4);
            }
            
            @Override
            protected void addBookInformation(final ItemStack book, final ListTag bookPages) {
                TFFeature.addTranslatedPages(bookPages, "twilightforest.book.labyrinth", 5);
                book.m_41700_("pages", (Tag)bookPages);
                book.m_41700_("author", (Tag)StringTag.m_129297_("A Forgotten Explorer"));
                book.m_41700_("title", (Tag)StringTag.m_129297_("Notes on a Swampy Labyrinth"));
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new MazeRuinsComponent(this, 0, x, y, z);
            }
            
            @Override
            public GenerationStep.Decoration getDecorationStage() {
                return GenerationStep.Decoration.UNDERGROUND_STRUCTURES;
            }
        };
        DARK_TOWER = new TFFeature("dark_tower", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_knights") }) {
            {
                this.addMonster((EntityType<? extends LivingEntity>)TFEntities.CARMINITE_GOLEM, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20524_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20558_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20566_, 2, 1, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20495_, 1, 1, 1).addMonster((EntityType<? extends LivingEntity>)TFEntities.CARMINITE_GHASTLING, 10, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.CARMINITE_BROODLING, 10, 8, 8).addMonster((EntityType<? extends LivingEntity>)TFEntities.PINCH_BEETLE, 10, 2, 4).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.CARMINITE_GHASTGUARD, 10, 1, 4).addWaterCreature((EntityType<? extends LivingEntity>)EntityType.f_20480_, 10, 4, 4);
                this.adjustToTerrainHeight = true;
            }
            
            @Override
            protected void addBookInformation(final ItemStack book, final ListTag bookPages) {
                TFFeature.addTranslatedPages(bookPages, "twilightforest.book.darktower", 3);
                book.m_41700_("pages", (Tag)bookPages);
                book.m_41700_("author", (Tag)StringTag.m_129297_("A Forgotten Explorer"));
                book.m_41700_("title", (Tag)StringTag.m_129297_("Notes on a Wooden Tower"));
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new DarkTowerMainComponent(this, rand, 0, x, y, z);
            }
        };
        KNIGHT_STRONGHOLD = new TFFeature("knight_stronghold", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_trophy_pedestal") }) {
            {
                this.enableDecorations().disableProtectionAura();
                this.undergroundDecoAllowed = false;
                this.addMonster((EntityType<? extends LivingEntity>)TFEntities.BLOCKCHAIN_GOBLIN, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.LOWER_GOBLIN_KNIGHT, 5, 1, 2).addMonster((EntityType<? extends LivingEntity>)TFEntities.HELMET_CRAB, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.SLIME_BEETLE, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.REDCAP_SAPPER, 2, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.KOBOLD, 10, 4, 8).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20558_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20526_, 5, 4, 4);
            }
            
            @Override
            protected void addBookInformation(final ItemStack book, final ListTag bookPages) {
                TFFeature.addTranslatedPages(bookPages, "twilightforest.book.tfstronghold", 5);
                book.m_41700_("pages", (Tag)bookPages);
                book.m_41700_("author", (Tag)StringTag.m_129297_("A Forgotten Explorer"));
                book.m_41700_("title", (Tag)StringTag.m_129297_("Notes on a Stronghold"));
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new StrongholdEntranceComponent(this, 0, x, chunkGenerator.m_6337_() + 7, z);
            }
            
            @Override
            public GenerationStep.Decoration getDecorationStage() {
                return GenerationStep.Decoration.UNDERGROUND_STRUCTURES;
            }
        };
        YETI_CAVE = new TFFeature("yeti_lairs", true, true, new ResourceLocation[] { TwilightForestMod.prefix("progress_lich") }) {
            {
                this.enableDecorations().enableTerrainAlterations();
                this.undergroundDecoAllowed = false;
                this.addMonster((EntityType<? extends LivingEntity>)TFEntities.YETI, 10, 4, 4);
            }
            
            @Override
            protected void addBookInformation(final ItemStack book, final ListTag bookPages) {
                TFFeature.addTranslatedPages(bookPages, "twilightforest.book.yeticave", 3);
                book.m_41700_("pages", (Tag)bookPages);
                book.m_41700_("author", (Tag)StringTag.m_129297_("A Forgotten Explorer"));
                book.m_41700_("title", (Tag)StringTag.m_129297_("Notes on an Icy Cave"));
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new YetiCaveComponent(this, rand, 0, x, y, z);
            }
        };
        ICE_TOWER = new TFFeature("ice_tower", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_yeti") }) {
            {
                this.addMonster((EntityType<? extends LivingEntity>)TFEntities.SNOW_GUARDIAN, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.STABLE_ICE_CORE, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.UNSTABLE_ICE_CORE, 5, 4, 4);
            }
            
            @Override
            protected void addBookInformation(final ItemStack book, final ListTag bookPages) {
                TFFeature.addTranslatedPages(bookPages, "twilightforest.book.icetower", 3);
                book.m_41700_("pages", (Tag)bookPages);
                book.m_41700_("author", (Tag)StringTag.m_129297_("A Forgotten Explorer"));
                book.m_41700_("title", (Tag)StringTag.m_129297_("Notes on Auroral Fortification"));
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new IceTowerMainComponent(this, rand, 0, x, y, z);
            }
        };
        TROLL_CAVE = new TFFeature("troll_lairs", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_merge") }) {
            {
                this.enableDecorations().enableTerrainAlterations().disableProtectionAura();
                this.addMonster((EntityType<? extends LivingEntity>)EntityType.f_20558_, 5, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20524_, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.TROLL, 20, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20495_, 5, 1, 1).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.GIANT_MINER, 10, 1, 1).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.ARMORED_GIANT, 10, 1, 1);
            }
            
            @Override
            protected void addBookInformation(final ItemStack book, final ListTag bookPages) {
                TFFeature.addTranslatedPages(bookPages, "twilightforest.book.trollcave", 3);
                book.m_41700_("pages", (Tag)bookPages);
                book.m_41700_("author", (Tag)StringTag.m_129297_("A Forgotten Explorer"));
                book.m_41700_("title", (Tag)StringTag.m_129297_("Notes on the Highlands"));
            }
            
            @Override
            public GenerationStep.Decoration getDecorationStage() {
                return GenerationStep.Decoration.UNDERGROUND_STRUCTURES;
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new TrollCaveMainComponent(TrollCavePieces.TFTCMai, this, 0, x, y, z);
            }
        };
        FINAL_CASTLE = new TFFeature("final_castle", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_troll") }) {
            {
                this.addMonster((EntityType<? extends LivingEntity>)TFEntities.KOBOLD, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.ADHERENT, 10, 1, 1).addMonster((EntityType<? extends LivingEntity>)TFEntities.HARBINGER_CUBE, 10, 1, 1).addMonster((EntityType<? extends LivingEntity>)EntityType.f_20566_, 10, 1, 1).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.KOBOLD, 10, 4, 4).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.ADHERENT, 10, 1, 1).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.HARBINGER_CUBE, 10, 1, 1).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.ARMORED_GIANT, 10, 1, 1).addMonster(2, (EntityType<? extends LivingEntity>)TFEntities.ADHERENT, 10, 1, 1).addMonster(3, (EntityType<? extends LivingEntity>)EntityType.f_20551_, 10, 1, 1);
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new FinalCastleMainComponent(this, rand, 0, x, y, z);
            }
        };
        MUSHROOM_TOWER = new TFFeature("mushroom_tower", true, new ResourceLocation[0]) {
            {
                this.disableStructure();
                this.adjustToTerrainHeight = true;
            }
            
            @Override
            public StructurePiece provideStructureStart(final StructureManager structureManager, final ChunkGenerator chunkGenerator, final Random rand, final int x, final int y, final int z) {
                return new MushroomTowerMainComponent(this, rand, 0, x, y, z);
            }
        };
        QUEST_ISLAND = new TFFeature("quest_island", false, new ResourceLocation[0]) {
            {
                this.disableStructure();
            }
        };
        BIOME_FEATURES = (Map)new ImmutableMap.Builder().put((Object)BiomeKeys.DARK_FOREST.m_135782_(), (Object)TFFeature.KNIGHT_STRONGHOLD).put((Object)BiomeKeys.DARK_FOREST_CENTER.m_135782_(), (Object)TFFeature.DARK_TOWER).put((Object)BiomeKeys.ENCHANTED_FOREST.m_135782_(), (Object)TFFeature.QUEST_GROVE).put((Object)BiomeKeys.FINAL_PLATEAU.m_135782_(), (Object)TFFeature.FINAL_CASTLE).put((Object)BiomeKeys.FIRE_SWAMP.m_135782_(), (Object)TFFeature.HYDRA_LAIR).put((Object)BiomeKeys.GLACIER.m_135782_(), (Object)TFFeature.ICE_TOWER).put((Object)BiomeKeys.HIGHLANDS.m_135782_(), (Object)TFFeature.TROLL_CAVE).put((Object)BiomeKeys.SNOWY_FOREST.m_135782_(), (Object)TFFeature.YETI_CAVE).put((Object)BiomeKeys.SWAMP.m_135782_(), (Object)TFFeature.LABYRINTH).build();
        TFHill = registerPiece("TFHill", HollowHillComponent::new);
        TFHedge = registerPiece("TFHedge", HedgeMazeComponent::new);
        TFQuestGrove = registerPiece("TFQuest1", QuestGrove::new);
        TFHydra = registerPiece("TFHydra", HydraLairComponent::new);
        TFYeti = registerPiece("TFYeti", YetiCaveComponent::new);
    }
}
