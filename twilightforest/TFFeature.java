// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Arrays;
import twilightforest.worldgen.biomes.BiomeKeys;
import com.google.common.collect.ImmutableMap;
import twilightforest.structures.mushroomtower.MushroomTowerMainComponent;
import twilightforest.structures.finalcastle.FinalCastleMainComponent;
import twilightforest.structures.trollcave.TrollCaveMainComponent;
import twilightforest.structures.trollcave.TrollCavePieces;
import twilightforest.structures.YetiCaveComponent;
import twilightforest.structures.stronghold.StrongholdEntranceComponent;
import twilightforest.structures.darktower.DarkTowerMainComponent;
import twilightforest.structures.minotaurmaze.MazeRuinsComponent;
import twilightforest.structures.HydraLairComponent;
import twilightforest.structures.QuestGroveComponent;
import twilightforest.structures.icetower.IceTowerMainComponent;
import twilightforest.structures.lichtower.TowerMainComponent;
import twilightforest.structures.courtyard.NagaCourtyardMainComponent;
import twilightforest.structures.HedgeMazeComponent;
import twilightforest.structures.HollowHillComponent;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.Direction;
import java.util.Locale;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.nbt.StringNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;
import net.minecraft.world.IWorldReader;
import twilightforest.entity.KoboldEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.world.World;
import twilightforest.util.PlayerHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.EntityClassification;
import java.util.Collection;
import javax.annotation.Nullable;
import twilightforest.util.IntPair;
import java.util.Random;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.entity.EntityType;
import java.util.ArrayList;
import net.minecraft.world.biome.MobSpawnInfo;
import java.util.List;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.util.ResourceLocation;
import java.util.Map;

public enum TFFeature
{
    NOTHING(0, "no_feature", false, new ResourceLocation[0]) {
        {
            this.enableDecorations().disableStructure();
        }
    }, 
    SMALL_HILL(1, "small_hollow_hill", true, true, new ResourceLocation[0]) {
        {
            this.enableDecorations().enableTerrainAlterations();
            this.addMonster((EntityType<? extends LivingEntity>)EntityType.field_200748_an, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200725_aD, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.redcap, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.swarm_spider, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.kobold, 10, 4, 8);
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new HollowHillComponent(TFFeature.TFHill, this, 0, this.size, x, y - 2, z);
        }
    }, 
    MEDIUM_HILL(2, "medium_hollow_hill", true, true, new ResourceLocation[0]) {
        {
            this.enableDecorations().enableTerrainAlterations();
            this.addMonster((EntityType<? extends LivingEntity>)TFEntities.redcap, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.redcap_sapper, 1, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.kobold, 10, 4, 8).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200741_ag, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.swarm_spider, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200748_an, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200797_k, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.fire_beetle, 5, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.slime_beetle, 5, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200759_ay, 1, 1, 1);
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new HollowHillComponent(TFFeature.TFHill, this, 0, this.size, x, y - 5, z);
        }
    }, 
    LARGE_HILL(3, "large_hollow_hill", true, true, new ResourceLocation[0]) {
        {
            this.enableDecorations().enableTerrainAlterations();
            this.addMonster((EntityType<? extends LivingEntity>)TFEntities.redcap, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.redcap_sapper, 2, 1, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200741_ag, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200794_h, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200797_k, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200803_q, 1, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.wraith, 2, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.fire_beetle, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.slime_beetle, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.pinch_beetle, 10, 2, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200759_ay, 1, 1, 1);
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new HollowHillComponent(TFFeature.TFHill, this, 0, this.size, x, y - 5, z);
        }
    }, 
    HEDGE_MAZE(2, "hedge_maze", true, new ResourceLocation[0]) {
        {
            this.enableTerrainAlterations();
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new HedgeMazeComponent(this, 0, x, y, z);
        }
    }, 
    NAGA_COURTYARD(3, "naga_courtyard", true, new ResourceLocation[0]) {
        {
            this.enableTerrainAlterations();
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new NagaCourtyardMainComponent(this, rand, 0, x, y, z);
        }
    }, 
    LICH_TOWER(1, "lich_tower", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_naga") }) {
        {
            this.addMonster((EntityType<? extends LivingEntity>)EntityType.field_200725_aD, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200741_ag, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200797_k, 1, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200803_q, 1, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.death_tome, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200759_ay, 1, 1, 1);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final ListNBT bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.lichtower", 4);
            book.func_77983_a("pages", (INBT)bookPages);
            book.func_77983_a("author", (INBT)StringNBT.func_229705_a_("A Forgotten Explorer"));
            book.func_77983_a("title", (INBT)StringNBT.func_229705_a_("Notes on a Pointy Tower"));
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new TowerMainComponent(this, rand, 0, x, y, z);
        }
    }, 
    ICE_TOWER(2, "ice_tower", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_yeti") }) {
        {
            this.addMonster((EntityType<? extends LivingEntity>)TFEntities.snow_guardian, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.stable_ice_core, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.unstable_ice_core, 5, 4, 4);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final ListNBT bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.icetower", 3);
            book.func_77983_a("pages", (INBT)bookPages);
            book.func_77983_a("author", (INBT)StringNBT.func_229705_a_("A Forgotten Explorer"));
            book.func_77983_a("title", (INBT)StringNBT.func_229705_a_("Notes on Auroral Fortification"));
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new IceTowerMainComponent(this, rand, 0, x, y, z);
        }
    }, 
    QUEST_ISLAND(1, "quest_island", false, new ResourceLocation[0]) {
        {
            this.disableStructure();
        }
    }, 
    QUEST_GROVE(1, "quest_grove", true, new ResourceLocation[0]) {
        {
            this.enableTerrainAlterations();
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new QuestGroveComponent(this, 0, x, y, z);
        }
    }, 
    DRUID_GROVE(1, "druid_grove", false, new ResourceLocation[0]) {
        {
            this.disableStructure();
        }
    }, 
    FLOATING_RUINS(3, "floating_ruins", false, new ResourceLocation[0]) {
        {
            this.disableStructure();
        }
    }, 
    HYDRA_LAIR(2, "hydra_lair", true, true, new ResourceLocation[] { TwilightForestMod.prefix("progress_labyrinth") }) {
        {
            this.enableTerrainAlterations();
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final ListNBT bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.hydralair", 4);
            book.func_77983_a("pages", (INBT)bookPages);
            book.func_77983_a("author", (INBT)StringNBT.func_229705_a_("A Forgotten Explorer"));
            book.func_77983_a("title", (INBT)StringNBT.func_229705_a_("Notes on the Fire Swamp"));
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new HydraLairComponent(this, rand, 0, x, y, z);
        }
    }, 
    LABYRINTH(3, "labyrinth", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_lich") }) {
        {
            this.enableDecorations();
            this.addMonster((EntityType<? extends LivingEntity>)TFEntities.minotaur, 20, 2, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200794_h, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200797_k, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.maze_slime, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200803_q, 1, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.fire_beetle, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.slime_beetle, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.pinch_beetle, 10, 2, 4);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final ListNBT bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.labyrinth", 5);
            book.func_77983_a("pages", (INBT)bookPages);
            book.func_77983_a("author", (INBT)StringNBT.func_229705_a_("A Forgotten Explorer"));
            book.func_77983_a("title", (INBT)StringNBT.func_229705_a_("Notes on a Swampy Labyrinth"));
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new MazeRuinsComponent(this, 0, x, y, z);
        }
        
        @Override
        public GenerationStage.Decoration getDecorationStage() {
            return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
        }
    }, 
    DARK_TOWER(1, "dark_tower", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_knights") }) {
        {
            this.addMonster((EntityType<? extends LivingEntity>)TFEntities.tower_golem, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200741_ag, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200797_k, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200803_q, 2, 1, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200759_ay, 1, 1, 1).addMonster((EntityType<? extends LivingEntity>)TFEntities.mini_ghast, 10, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.tower_broodling, 10, 8, 8).addMonster((EntityType<? extends LivingEntity>)TFEntities.pinch_beetle, 10, 2, 4).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.tower_ghast, 10, 1, 4).addWaterCreature((EntityType<? extends LivingEntity>)EntityType.field_200749_ao, 10, 4, 4);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final ListNBT bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.darktower", 3);
            book.func_77983_a("pages", (INBT)bookPages);
            book.func_77983_a("author", (INBT)StringNBT.func_229705_a_("A Forgotten Explorer"));
            book.func_77983_a("title", (INBT)StringNBT.func_229705_a_("Notes on a Wooden Tower"));
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new DarkTowerMainComponent(this, rand, 0, x, y, z);
        }
    }, 
    KNIGHT_STRONGHOLD(3, "knight_stronghold", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_trophy_pedestal") }) {
        {
            this.enableDecorations().disableProtectionAura();
            this.addMonster((EntityType<? extends LivingEntity>)TFEntities.blockchain_goblin, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.goblin_knight_lower, 5, 1, 2).addMonster((EntityType<? extends LivingEntity>)TFEntities.helmet_crab, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.slime_beetle, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.redcap_sapper, 2, 1, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.kobold, 10, 4, 8).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200797_k, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200743_ai, 5, 4, 4);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final ListNBT bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.tfstronghold", 5);
            book.func_77983_a("pages", (INBT)bookPages);
            book.func_77983_a("author", (INBT)StringNBT.func_229705_a_("A Forgotten Explorer"));
            book.func_77983_a("title", (INBT)StringNBT.func_229705_a_("Notes on a Stronghold"));
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new StrongholdEntranceComponent(this, 0, x, y, z);
        }
        
        @Override
        public GenerationStage.Decoration getDecorationStage() {
            return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
        }
    }, 
    WORLD_TREE(3, "world_tree", false, new ResourceLocation[0]) {
        {
            this.disableStructure();
        }
    }, 
    YETI_CAVE(2, "yeti_lairs", true, true, new ResourceLocation[] { TwilightForestMod.prefix("progress_lich") }) {
        {
            this.enableDecorations().enableTerrainAlterations();
            this.addMonster((EntityType<? extends LivingEntity>)TFEntities.yeti, 10, 4, 4);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final ListNBT bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.yeticave", 3);
            book.func_77983_a("pages", (INBT)bookPages);
            book.func_77983_a("author", (INBT)StringNBT.func_229705_a_("A Forgotten Explorer"));
            book.func_77983_a("title", (INBT)StringNBT.func_229705_a_("Notes on an Icy Cave"));
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new YetiCaveComponent(this, rand, 0, x, y, z);
        }
    }, 
    TROLL_CAVE(4, "troll_lairs", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_merge") }) {
        {
            this.enableDecorations().enableTerrainAlterations().disableProtectionAura();
            this.addMonster((EntityType<? extends LivingEntity>)EntityType.field_200797_k, 5, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200741_ag, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.troll, 20, 4, 4).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200759_ay, 5, 1, 1).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.giant_miner, 10, 1, 1).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.armored_giant, 10, 1, 1);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final ListNBT bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.trollcave", 3);
            book.func_77983_a("pages", (INBT)bookPages);
            book.func_77983_a("author", (INBT)StringNBT.func_229705_a_("A Forgotten Explorer"));
            book.func_77983_a("title", (INBT)StringNBT.func_229705_a_("Notes on the Highlands"));
        }
        
        @Override
        public GenerationStage.Decoration getDecorationStage() {
            return GenerationStage.Decoration.UNDERGROUND_STRUCTURES;
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new TrollCaveMainComponent(TrollCavePieces.TFTCMai, this, 0, x, y, z);
        }
    }, 
    FINAL_CASTLE(4, "final_castle", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_troll") }) {
        {
            this.addMonster((EntityType<? extends LivingEntity>)TFEntities.kobold, 10, 4, 4).addMonster((EntityType<? extends LivingEntity>)TFEntities.adherent, 10, 1, 1).addMonster((EntityType<? extends LivingEntity>)TFEntities.harbinger_cube, 10, 1, 1).addMonster((EntityType<? extends LivingEntity>)EntityType.field_200803_q, 10, 1, 1).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.kobold, 10, 4, 4).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.adherent, 10, 1, 1).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.harbinger_cube, 10, 1, 1).addMonster(1, (EntityType<? extends LivingEntity>)TFEntities.armored_giant, 10, 1, 1).addMonster(2, (EntityType<? extends LivingEntity>)TFEntities.adherent, 10, 1, 1).addMonster(3, (EntityType<? extends LivingEntity>)EntityType.field_200792_f, 10, 1, 1);
        }
        
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new FinalCastleMainComponent(this, rand, 0, x, y, z);
        }
    }, 
    MUSHROOM_TOWER(2, "mushroom_tower", true, new ResourceLocation[0]) {
        @Override
        public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
            return new MushroomTowerMainComponent(this, rand, 0, x, y, z);
        }
    };
    
    private static final Map<ResourceLocation, TFFeature> BIOME_FEATURES;
    public static final IStructurePieceType TFHill;
    public static final IStructurePieceType TFHedge;
    public static final IStructurePieceType TFQuest1;
    public static final IStructurePieceType TFHydra;
    public static final IStructurePieceType TFYeti;
    public final int size;
    public final String name;
    public final boolean centerBounds;
    public boolean areChunkDecorationsEnabled;
    public boolean isStructureEnabled;
    public boolean isTerrainAltered;
    private final ResourceLocation[] requiredAdvancements;
    public boolean hasProtectionAura;
    private List<List<MobSpawnInfo.Spawners>> spawnableMonsterLists;
    private List<MobSpawnInfo.Spawners> ambientCreatureList;
    private List<MobSpawnInfo.Spawners> waterCreatureList;
    private long lastSpawnedHintMonsterTime;
    private static final String BOOK_AUTHOR = "A Forgotten Explorer";
    private static final TFFeature[] VALUES;
    private static final int maxSize;
    
    private TFFeature(final int size, final String name, final boolean featureGenerator, final ResourceLocation[] requiredAdvancements) {
        this(size, name, featureGenerator, false, requiredAdvancements);
    }
    
    private TFFeature(final int size, final String name, final boolean featureGenerator, final boolean centerBounds, final ResourceLocation[] requiredAdvancements) {
        this.size = size;
        this.name = name;
        this.areChunkDecorationsEnabled = false;
        this.isStructureEnabled = true;
        this.isTerrainAltered = false;
        this.spawnableMonsterLists = new ArrayList<List<MobSpawnInfo.Spawners>>();
        this.ambientCreatureList = new ArrayList<MobSpawnInfo.Spawners>();
        this.waterCreatureList = new ArrayList<MobSpawnInfo.Spawners>();
        this.hasProtectionAura = true;
        if (!name.equals("hydra_lair")) {
            this.ambientCreatureList.add(new MobSpawnInfo.Spawners(EntityType.field_200791_e, 10, 8, 8));
        }
        this.requiredAdvancements = requiredAdvancements;
        this.centerBounds = centerBounds;
    }
    
    static void init() {
    }
    
    public static int getCount() {
        return TFFeature.VALUES.length;
    }
    
    public static int getMaxSize() {
        return TFFeature.maxSize;
    }
    
    public static TFFeature getFeatureByName(final String name) {
        for (final TFFeature feature : TFFeature.VALUES) {
            if (feature.name.equalsIgnoreCase(name)) {
                return feature;
            }
        }
        return TFFeature.NOTHING;
    }
    
    public static TFFeature getFeatureByName(final ResourceLocation name) {
        if (name.func_110624_b().equalsIgnoreCase("twilightforest")) {
            return getFeatureByName(name.func_110623_a());
        }
        return TFFeature.NOTHING;
    }
    
    public static TFFeature getFeatureByID(final int id) {
        return (id < TFFeature.VALUES.length) ? TFFeature.VALUES[id] : TFFeature.NOTHING;
    }
    
    public static int getFeatureID(final int mapX, final int mapZ, final ISeedReader world) {
        return getFeatureAt(mapX, mapZ, world).ordinal();
    }
    
    public static TFFeature getFeatureAt(final int mapX, final int mapZ, final ISeedReader world) {
        return generateFeature(mapX >> 4, mapZ >> 4, world);
    }
    
    public static boolean isInFeatureChunk(final int mapX, final int mapZ) {
        final int chunkX = mapX >> 4;
        final int chunkZ = mapZ >> 4;
        final BlockPos cc = getNearestCenterXYZ(chunkX, chunkZ);
        return chunkX == cc.func_177958_n() >> 4 && chunkZ == cc.func_177952_p() >> 4;
    }
    
    public TFFeature enableDecorations() {
        this.areChunkDecorationsEnabled = true;
        return this;
    }
    
    public TFFeature disableStructure() {
        this.isStructureEnabled = false;
        return this;
    }
    
    public TFFeature enableTerrainAlterations() {
        this.isTerrainAltered = true;
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
        List<MobSpawnInfo.Spawners> monsterList;
        if (this.spawnableMonsterLists.size() > listIndex) {
            monsterList = this.spawnableMonsterLists.get(listIndex);
        }
        else {
            monsterList = new ArrayList<MobSpawnInfo.Spawners>();
            this.spawnableMonsterLists.add(listIndex, monsterList);
        }
        monsterList.add(new MobSpawnInfo.Spawners((EntityType)monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public TFFeature addWaterCreature(final EntityType<? extends LivingEntity> monsterClass, final int weight, final int minGroup, final int maxGroup) {
        this.waterCreatureList.add(new MobSpawnInfo.Spawners((EntityType)monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public static TFFeature getFeatureDirectlyAt(final int chunkX, final int chunkZ, final ISeedReader world) {
        if (isInFeatureChunk(chunkX << 4, chunkZ << 4)) {
            return getFeatureAt(chunkX << 4, chunkZ << 4, world);
        }
        return TFFeature.NOTHING;
    }
    
    public static TFFeature generateFeature(int chunkX, int chunkZ, final ISeedReader world) {
        chunkX = Math.round(chunkX / 16.0f) * 16;
        chunkZ = Math.round(chunkZ / 16.0f) * 16;
        final Biome biomeAt = world.func_226691_t_(new BlockPos((chunkX << 4) + 8, 0, (chunkZ << 4) + 8));
        return generateFeature(chunkX, chunkZ, biomeAt, world.func_72905_C());
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
        switch (new Random(seed + chunkX * 25117 + chunkZ * 151121).nextInt(16)) {
            default: {
                return TFFeature.SMALL_HILL;
            }
            case 6:
            case 7:
            case 8: {
                return TFFeature.MEDIUM_HILL;
            }
            case 9: {
                return TFFeature.LARGE_HILL;
            }
            case 10:
            case 11: {
                return TFFeature.HEDGE_MAZE;
            }
            case 12:
            case 13: {
                return TFFeature.NAGA_COURTYARD;
            }
            case 14:
            case 15: {
                return TFFeature.LICH_TOWER;
            }
        }
    }
    
    public static TFFeature getNearestFeature(final int cx, final int cz, final ISeedReader world) {
        return getNearestFeature(cx, cz, world, null);
    }
    
    public static TFFeature getNearestFeature(final int cx, final int cz, final ISeedReader world, @Nullable final IntPair center) {
        final int diam = TFFeature.maxSize * 2 + 1;
        final TFFeature[] features = new TFFeature[diam * diam];
        for (int rad = 1; rad <= TFFeature.maxSize; ++rad) {
            for (int x = -rad; x <= rad; ++x) {
                for (int z = -rad; z <= rad; ++z) {
                    final int idx = (x + TFFeature.maxSize) * diam + (z + TFFeature.maxSize);
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
    public static BlockPos findNearestFeaturePosBySpacing(final ISeedReader worldIn, final TFFeature feature, final BlockPos blockPos, final int p_191069_3_, final int p_191069_4_, final int p_191069_5_, final boolean p_191069_6_, final int p_191069_7_, final boolean findUnexplored) {
        final int i = blockPos.func_177958_n() >> 4;
        final int j = blockPos.func_177952_p() >> 4;
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
                        if (getFeatureAt(l2 << 4, i3 << 4, (ISeedReader)worldIn.func_201672_e()) == feature) {
                            if (!findUnexplored || !worldIn.func_217354_b(l2, i3)) {
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
    
    public static TFFeature getFeatureForRegion(final int chunkX, final int chunkZ, final ISeedReader world) {
        final int featureX = Math.round(chunkX / 16.0f) * 16;
        final int featureZ = Math.round(chunkZ / 16.0f) * 16;
        return generateFeature(featureX, featureZ, world);
    }
    
    public static TFFeature getFeatureForRegionPos(final int posX, final int posZ, final ISeedReader world) {
        return getFeatureForRegion(posX >> 4, posZ >> 4, world);
    }
    
    public static BlockPos getNearestCenterXYZ(final int cx, final int cz) {
        final int regionX = cx + 8 >> 4;
        final int regionZ = cz + 8 >> 4;
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
        return new BlockPos(ccx, 31, ccz);
    }
    
    public List<MobSpawnInfo.Spawners> getCombinedMonsterSpawnableList() {
        final List<MobSpawnInfo.Spawners> list = new ArrayList<MobSpawnInfo.Spawners>();
        this.spawnableMonsterLists.forEach(l -> {
            if (l != null) {
                list.addAll(l);
            }
            return;
        });
        return list;
    }
    
    public List<MobSpawnInfo.Spawners> getCombinedCreatureSpawnableList() {
        final List<MobSpawnInfo.Spawners> list = new ArrayList<MobSpawnInfo.Spawners>();
        list.addAll(this.ambientCreatureList);
        list.addAll(this.waterCreatureList);
        return list;
    }
    
    public List<MobSpawnInfo.Spawners> getSpawnableList(final EntityClassification creatureType) {
        switch (creatureType) {
            case MONSTER: {
                return this.getSpawnableMonsterList(0);
            }
            case AMBIENT: {
                return this.ambientCreatureList;
            }
            case WATER_CREATURE: {
                return this.waterCreatureList;
            }
            default: {
                return new ArrayList<MobSpawnInfo.Spawners>();
            }
        }
    }
    
    public List<MobSpawnInfo.Spawners> getSpawnableMonsterList(final int index) {
        if (index >= 0 && index < this.spawnableMonsterLists.size()) {
            return this.spawnableMonsterLists.get(index);
        }
        return new ArrayList<MobSpawnInfo.Spawners>();
    }
    
    public boolean doesPlayerHaveRequiredAdvancements(final PlayerEntity player) {
        return PlayerHelper.doesPlayerHaveRequiredAdvancements(player, this.requiredAdvancements);
    }
    
    public void trySpawnHintMonster(final World world, final PlayerEntity player) {
        this.trySpawnHintMonster(world, player, player.func_233580_cy_());
    }
    
    public void trySpawnHintMonster(final World world, final PlayerEntity player, final BlockPos pos) {
        final long currentTime = world.func_82737_E();
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
    
    private boolean didSpawnHintMonster(final World world, final PlayerEntity player, final BlockPos pos) {
        final int dx = world.field_73012_v.nextInt(16) - world.field_73012_v.nextInt(16);
        final int dy = world.field_73012_v.nextInt(4) - world.field_73012_v.nextInt(4);
        final int dz = world.field_73012_v.nextInt(16) - world.field_73012_v.nextInt(16);
        final KoboldEntity hinty = new KoboldEntity(TFEntities.kobold, world);
        hinty.func_174828_a(pos.func_177982_a(dx, dy, dz), 0.0f, 0.0f);
        if (hinty.func_205019_a((IWorldReader)world) && hinty.func_70635_at().func_75522_a((Entity)player)) {
            final ItemStack book = this.createHintBook();
            hinty.func_184201_a(EquipmentSlotType.MAINHAND, book);
            hinty.func_184642_a(EquipmentSlotType.MAINHAND, 1.0f);
            world.func_217376_c((Entity)hinty);
            return true;
        }
        return false;
    }
    
    public ItemStack createHintBook() {
        final ItemStack book = new ItemStack((IItemProvider)Items.field_151164_bB);
        this.addBookInformation(book, new ListNBT());
        return book;
    }
    
    protected void addBookInformation(final ItemStack book, final ListNBT bookPages) {
        addTranslatedPages(bookPages, "twilightforest.book.unknown", 2);
        book.func_77983_a("pages", (INBT)bookPages);
        book.func_77983_a("author", (INBT)StringNBT.func_229705_a_("A Forgotten Explorer"));
        book.func_77983_a("title", (INBT)StringNBT.func_229705_a_("Notes on the Unexplained"));
    }
    
    @Nullable
    public StructurePiece provideStructureStart(final Random rand, final int x, final int y, final int z) {
        return null;
    }
    
    public GenerationStage.Decoration getDecorationStage() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }
    
    private static void addTranslatedPages(final ListNBT bookPages, final String translationKey, final int pageCount) {
        for (int i = 1; i <= pageCount; ++i) {
            bookPages.add((Object)StringNBT.func_229705_a_(ITextComponent.Serializer.func_150696_a((ITextComponent)new TranslationTextComponent(translationKey + "." + i))));
        }
    }
    
    public static IStructurePieceType registerPiece(final String name, final IStructurePieceType piece) {
        return (IStructurePieceType)Registry.func_218322_a(Registry.field_218362_C, TwilightForestMod.prefix(name.toLowerCase(Locale.ROOT)), (Object)piece);
    }
    
    public final MutableBoundingBox getComponentToAddBoundingBox(int x, int y, int z, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ, @Nullable final Direction dir) {
        if (this.centerBounds) {
            x += (maxX + minX) / 4;
            y += (maxY + minY) / 4;
            z += (maxZ + minZ) / 4;
        }
        switch (dir) {
            default: {
                return new MutableBoundingBox(x + minX, y + minY, z + minZ, x + maxX + minX, y + maxY + minY, z + maxZ + minZ);
            }
            case WEST: {
                return new MutableBoundingBox(x - maxZ + minZ, y + minY, z + minX, x + minZ, y + maxY + minY, z + maxX + minX);
            }
            case NORTH: {
                return new MutableBoundingBox(x - maxX - minX, y + minY, z - maxZ - minZ, x - minX, y + maxY + minY, z - minZ);
            }
            case EAST: {
                return new MutableBoundingBox(x + minZ, y + minY, z - maxX, x + maxZ + minZ, y + maxY + minY, z + minX);
            }
        }
    }
    
    static {
        BIOME_FEATURES = (Map)new ImmutableMap.Builder().put((Object)BiomeKeys.DARK_FOREST.func_240901_a_(), (Object)TFFeature.KNIGHT_STRONGHOLD).put((Object)BiomeKeys.DARK_FOREST_CENTER.func_240901_a_(), (Object)TFFeature.DARK_TOWER).put((Object)BiomeKeys.DENSE_MUSHROOM_FOREST.func_240901_a_(), (Object)TFFeature.MUSHROOM_TOWER).put((Object)BiomeKeys.ENCHANTED_FOREST.func_240901_a_(), (Object)TFFeature.QUEST_GROVE).put((Object)BiomeKeys.FINAL_PLATEAU.func_240901_a_(), (Object)TFFeature.FINAL_CASTLE).put((Object)BiomeKeys.FIRE_SWAMP.func_240901_a_(), (Object)TFFeature.HYDRA_LAIR).put((Object)BiomeKeys.GLACIER.func_240901_a_(), (Object)TFFeature.ICE_TOWER).put((Object)BiomeKeys.HIGHLANDS.func_240901_a_(), (Object)TFFeature.TROLL_CAVE).put((Object)BiomeKeys.SNOWY_FOREST.func_240901_a_(), (Object)TFFeature.YETI_CAVE).put((Object)BiomeKeys.SWAMP.func_240901_a_(), (Object)TFFeature.LABYRINTH).put((Object)BiomeKeys.LAKE.func_240901_a_(), (Object)TFFeature.QUEST_ISLAND).build();
        TFHill = registerPiece("TFHill", HollowHillComponent::new);
        TFHedge = registerPiece("TFHedge", HedgeMazeComponent::new);
        TFQuest1 = registerPiece("TFQuest1", QuestGroveComponent::new);
        TFHydra = registerPiece("TFHydra", HydraLairComponent::new);
        TFYeti = registerPiece("TFYeti", YetiCaveComponent::new);
        VALUES = values();
        maxSize = Arrays.stream(TFFeature.VALUES).mapToInt(v -> v.size).max().orElse(0);
    }
}
