// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Arrays;
import twilightforest.structures.start.StructureStartMushroomTower;
import twilightforest.structures.mushroomtower.TFMushroomTowerPieces;
import twilightforest.structures.start.StructureStartFinalCastle;
import net.minecraft.entity.monster.EntityBlaze;
import twilightforest.entity.EntityTFHarbingerCube;
import twilightforest.entity.EntityTFAdherent;
import twilightforest.structures.finalcastle.TFFinalCastlePieces;
import twilightforest.structures.start.StructureStartTrollCave;
import twilightforest.entity.EntityTFArmoredGiant;
import twilightforest.entity.EntityTFGiantMiner;
import twilightforest.entity.EntityTFTroll;
import twilightforest.structures.trollcave.TFTrollCavePieces;
import twilightforest.entity.EntityTFYeti;
import twilightforest.structures.ComponentTFYetiCave;
import twilightforest.structures.start.StructureStartYetiCave;
import twilightforest.structures.start.StructureStartKnightStronghold;
import net.minecraft.entity.monster.EntitySlime;
import twilightforest.entity.EntityTFHelmetCrab;
import twilightforest.entity.EntityTFGoblinKnightLower;
import twilightforest.entity.EntityTFBlockGoblin;
import twilightforest.structures.stronghold.TFStrongholdPieces;
import twilightforest.structures.start.StructureStartDarkTower;
import net.minecraft.entity.passive.EntitySquid;
import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.entity.EntityTFTowerBroodling;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.EntityTFTowerGolem;
import twilightforest.structures.darktower.TFDarkTowerPieces;
import twilightforest.structures.start.StructureStartLabyrinth;
import twilightforest.entity.EntityTFMazeSlime;
import twilightforest.entity.EntityTFMinotaur;
import twilightforest.structures.minotaurmaze.TFMinotaurMazePieces;
import twilightforest.structures.ComponentTFHydraLair;
import twilightforest.structures.start.StructureStartHydraLair;
import twilightforest.structures.ComponentTFQuestGrove;
import twilightforest.structures.start.StructureStartQuestGrove;
import twilightforest.structures.start.StructureStartAuroraPalace;
import twilightforest.entity.EntityTFIceExploder;
import twilightforest.entity.EntityTFIceShooter;
import twilightforest.entity.EntityTFSnowGuardian;
import twilightforest.structures.icetower.TFIceTowerPieces;
import twilightforest.structures.start.StructureStartLichTower;
import twilightforest.entity.EntityTFDeathTome;
import twilightforest.structures.lichtower.TFLichTowerPieces;
import twilightforest.structures.start.StructureStartCourtyard;
import twilightforest.structures.courtyard.NagaCourtyardPieces;
import twilightforest.structures.ComponentTFHedgeMaze;
import twilightforest.structures.start.StructureStartHedgeMaze;
import twilightforest.entity.EntityTFPinchBeetle;
import twilightforest.entity.EntityTFWraith;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityWitch;
import twilightforest.entity.EntityTFSlimeBeetle;
import twilightforest.entity.EntityTFFireBeetle;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import twilightforest.entity.EntityTFRedcapSapper;
import twilightforest.entity.EntityTFSwarmSpider;
import twilightforest.entity.EntityTFRedcap;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntitySpider;
import twilightforest.structures.ComponentTFHollowHill;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import twilightforest.structures.start.StructureStartHollowHill;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import twilightforest.structures.start.StructureStartNothing;
import twilightforest.structures.start.StructureStartTFAbstract;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EntityEquipmentSlot;
import twilightforest.entity.EntityTFKobold;
import net.minecraft.entity.Entity;
import twilightforest.util.PlayerHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.gen.MapGenBase;
import twilightforest.util.IntPair;
import java.util.Random;
import twilightforest.biomes.TFBiomeBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import twilightforest.world.MapGenTFMajorFeature;
import net.minecraft.entity.passive.EntityBat;
import java.util.ArrayList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import java.util.List;

public enum TFFeature
{
    NOTHING(0, "no_feature", false, new ResourceLocation[0]) {
        {
            this.enableDecorations().disableStructure();
        }
    }, 
    SMALL_HILL(1, "small_hollow_hill", true, new ResourceLocation[0]) {
        {
            this.enableDecorations().enableTerrainAlterations();
            MapGenStructureIO.func_143034_b((Class)StructureStartHollowHill.class, "TFHill");
            MapGenStructureIO.func_143031_a((Class)ComponentTFHollowHill.class, "TFHill");
            this.addMonster((Class<? extends EntityLiving>)EntitySpider.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityZombie.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFRedcap.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFSwarmSpider.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFKobold.class, 10, 4, 8);
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartHollowHill(world, this, rand, chunkX, chunkZ);
        }
    }, 
    MEDIUM_HILL(2, "medium_hollow_hill", true, new ResourceLocation[0]) {
        {
            this.enableDecorations().enableTerrainAlterations();
            this.addMonster((Class<? extends EntityLiving>)EntityTFRedcap.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFRedcapSapper.class, 1, 1, 4).addMonster((Class<? extends EntityLiving>)EntityTFKobold.class, 10, 4, 8).addMonster((Class<? extends EntityLiving>)EntitySkeleton.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFSwarmSpider.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntitySpider.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityCreeper.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFFireBeetle.class, 5, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFSlimeBeetle.class, 5, 4, 4).addMonster((Class<? extends EntityLiving>)EntityWitch.class, 1, 1, 1);
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartHollowHill(world, this, rand, chunkX, chunkZ);
        }
    }, 
    LARGE_HILL(3, "large_hollow_hill", true, new ResourceLocation[0]) {
        {
            this.enableDecorations().enableTerrainAlterations();
            this.addMonster((Class<? extends EntityLiving>)EntityTFRedcap.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFRedcapSapper.class, 2, 1, 4).addMonster((Class<? extends EntityLiving>)EntitySkeleton.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityCaveSpider.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityCreeper.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityEnderman.class, 1, 1, 4).addMonster((Class<? extends EntityLiving>)EntityTFWraith.class, 2, 1, 4).addMonster((Class<? extends EntityLiving>)EntityTFFireBeetle.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFSlimeBeetle.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFPinchBeetle.class, 10, 2, 4).addMonster((Class<? extends EntityLiving>)EntityWitch.class, 1, 1, 1);
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartHollowHill(world, this, rand, chunkX, chunkZ);
        }
    }, 
    HEDGE_MAZE(2, "hedge_maze", true, new ResourceLocation[0]) {
        {
            this.enableTerrainAlterations();
            MapGenStructureIO.func_143034_b((Class)StructureStartHedgeMaze.class, "TFHedge");
            MapGenStructureIO.func_143031_a((Class)ComponentTFHedgeMaze.class, "TFHedge");
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartHedgeMaze(world, this, rand, chunkX, chunkZ);
        }
    }, 
    NAGA_COURTYARD(3, "naga_courtyard", true, new ResourceLocation[0]) {
        {
            this.enableTerrainAlterations();
            NagaCourtyardPieces.registerPieces();
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartCourtyard(world, this, rand, chunkX, chunkZ);
        }
    }, 
    LICH_TOWER(1, "lich_tower", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_naga") }) {
        {
            TFLichTowerPieces.registerPieces();
            this.addMonster((Class<? extends EntityLiving>)EntityZombie.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntitySkeleton.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityCreeper.class, 1, 4, 4).addMonster((Class<? extends EntityLiving>)EntityEnderman.class, 1, 1, 4).addMonster((Class<? extends EntityLiving>)EntityTFDeathTome.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityWitch.class, 1, 1, 1);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final NBTTagList bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.lichtower", 4);
            book.func_77983_a("pages", (NBTBase)bookPages);
            book.func_77983_a("author", (NBTBase)new NBTTagString("A Forgotten Explorer"));
            book.func_77983_a("title", (NBTBase)new NBTTagString("Notes on a Pointy Tower"));
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartLichTower(world, this, rand, chunkX, chunkZ);
        }
    }, 
    ICE_TOWER(2, "ice_tower", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_yeti") }) {
        {
            TFIceTowerPieces.registerPieces();
            this.addMonster((Class<? extends EntityLiving>)EntityTFSnowGuardian.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFIceShooter.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFIceExploder.class, 5, 4, 4);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final NBTTagList bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.icetower", 3);
            book.func_77983_a("pages", (NBTBase)bookPages);
            book.func_77983_a("author", (NBTBase)new NBTTagString("A Forgotten Explorer"));
            book.func_77983_a("title", (NBTBase)new NBTTagString("Notes on Auroral Fortification"));
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartAuroraPalace(world, this, rand, chunkX, chunkZ);
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
            MapGenStructureIO.func_143034_b((Class)StructureStartQuestGrove.class, "TFQuest1");
            MapGenStructureIO.func_143031_a((Class)ComponentTFQuestGrove.class, "TFQuest1");
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartQuestGrove(world, this, rand, chunkX, chunkZ);
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
    HYDRA_LAIR(2, "hydra_lair", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_labyrinth") }) {
        {
            this.enableTerrainAlterations();
            MapGenStructureIO.func_143034_b((Class)StructureStartHydraLair.class, "TFHydra");
            MapGenStructureIO.func_143031_a((Class)ComponentTFHydraLair.class, "TFHydra");
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final NBTTagList bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.hydralair", 4);
            book.func_77983_a("pages", (NBTBase)bookPages);
            book.func_77983_a("author", (NBTBase)new NBTTagString("A Forgotten Explorer"));
            book.func_77983_a("title", (NBTBase)new NBTTagString("Notes on the Fire Swamp"));
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartHydraLair(world, this, rand, chunkX, chunkZ);
        }
    }, 
    LABYRINTH(3, "labyrinth", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_lich") }) {
        {
            this.enableDecorations();
            TFMinotaurMazePieces.registerPieces();
            this.addMonster((Class<? extends EntityLiving>)EntityTFMinotaur.class, 20, 2, 4).addMonster((Class<? extends EntityLiving>)EntityCaveSpider.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityCreeper.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFMazeSlime.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityEnderman.class, 1, 1, 4).addMonster((Class<? extends EntityLiving>)EntityTFFireBeetle.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFSlimeBeetle.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFPinchBeetle.class, 10, 2, 4);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final NBTTagList bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.labyrinth", 5);
            book.func_77983_a("pages", (NBTBase)bookPages);
            book.func_77983_a("author", (NBTBase)new NBTTagString("A Forgotten Explorer"));
            book.func_77983_a("title", (NBTBase)new NBTTagString("Notes on a Swampy Labyrinth"));
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartLabyrinth(world, this, rand, chunkX, chunkZ);
        }
    }, 
    DARK_TOWER(1, "dark_tower", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_knights") }) {
        {
            TFDarkTowerPieces.registerPieces();
            this.addMonster((Class<? extends EntityLiving>)EntityTFTowerGolem.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntitySkeleton.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityCreeper.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityEnderman.class, 2, 1, 4).addMonster((Class<? extends EntityLiving>)EntityWitch.class, 1, 1, 1).addMonster((Class<? extends EntityLiving>)EntityTFMiniGhast.class, 10, 1, 4).addMonster((Class<? extends EntityLiving>)EntityTFTowerBroodling.class, 10, 8, 8).addMonster((Class<? extends EntityLiving>)EntityTFPinchBeetle.class, 10, 2, 4).addMonster(1, (Class<? extends EntityLiving>)EntityTFTowerGhast.class, 10, 1, 4).addWaterCreature((Class<? extends EntityLiving>)EntitySquid.class, 10, 4, 4);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final NBTTagList bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.darktower", 3);
            book.func_77983_a("pages", (NBTBase)bookPages);
            book.func_77983_a("author", (NBTBase)new NBTTagString("A Forgotten Explorer"));
            book.func_77983_a("title", (NBTBase)new NBTTagString("Notes on a Wooden Tower"));
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartDarkTower(world, this, rand, chunkX, chunkZ);
        }
    }, 
    KNIGHT_STRONGHOLD(3, "knight_stronghold", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_trophy_pedestal") }) {
        {
            this.enableDecorations().disableProtectionAura();
            TFStrongholdPieces.registerPieces();
            this.addMonster((Class<? extends EntityLiving>)EntityTFBlockGoblin.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFGoblinKnightLower.class, 5, 1, 2).addMonster((Class<? extends EntityLiving>)EntityTFHelmetCrab.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFSlimeBeetle.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFRedcapSapper.class, 2, 1, 4).addMonster((Class<? extends EntityLiving>)EntityTFKobold.class, 10, 4, 8).addMonster((Class<? extends EntityLiving>)EntityCreeper.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntitySlime.class, 5, 4, 4);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final NBTTagList bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.tfstronghold", 5);
            book.func_77983_a("pages", (NBTBase)bookPages);
            book.func_77983_a("author", (NBTBase)new NBTTagString("A Forgotten Explorer"));
            book.func_77983_a("title", (NBTBase)new NBTTagString("Notes on a Stronghold"));
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartKnightStronghold(world, this, rand, chunkX, chunkZ);
        }
    }, 
    WORLD_TREE(3, "world_tree", false, new ResourceLocation[0]) {
        {
            this.disableStructure();
        }
    }, 
    YETI_CAVE(2, "yeti_lairs", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_lich") }) {
        {
            this.enableDecorations().enableTerrainAlterations();
            MapGenStructureIO.func_143034_b((Class)StructureStartYetiCave.class, "TFYeti");
            MapGenStructureIO.func_143031_a((Class)ComponentTFYetiCave.class, "TFYeti");
            this.addMonster((Class<? extends EntityLiving>)EntityTFYeti.class, 10, 4, 4);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final NBTTagList bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.yeticave", 3);
            book.func_77983_a("pages", (NBTBase)bookPages);
            book.func_77983_a("author", (NBTBase)new NBTTagString("A Forgotten Explorer"));
            book.func_77983_a("title", (NBTBase)new NBTTagString("Notes on an Icy Cave"));
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartYetiCave(world, this, rand, chunkX, chunkZ);
        }
    }, 
    TROLL_CAVE(4, "troll_lairs", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_merge") }) {
        {
            this.enableDecorations().enableTerrainAlterations().disableProtectionAura();
            TFTrollCavePieces.registerPieces();
            this.addMonster((Class<? extends EntityLiving>)EntityCreeper.class, 5, 4, 4).addMonster((Class<? extends EntityLiving>)EntitySkeleton.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFTroll.class, 20, 4, 4).addMonster((Class<? extends EntityLiving>)EntityWitch.class, 5, 1, 1).addMonster(1, (Class<? extends EntityLiving>)EntityTFGiantMiner.class, 10, 1, 4).addMonster(1, (Class<? extends EntityLiving>)EntityTFArmoredGiant.class, 10, 1, 4);
        }
        
        @Override
        protected void addBookInformation(final ItemStack book, final NBTTagList bookPages) {
            addTranslatedPages(bookPages, "twilightforest.book.trollcave", 3);
            book.func_77983_a("pages", (NBTBase)bookPages);
            book.func_77983_a("author", (NBTBase)new NBTTagString("A Forgotten Explorer"));
            book.func_77983_a("title", (NBTBase)new NBTTagString("Notes on the Highlands"));
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartTrollCave(world, this, rand, chunkX, chunkZ);
        }
    }, 
    FINAL_CASTLE(4, "final_castle", true, new ResourceLocation[] { TwilightForestMod.prefix("progress_troll") }) {
        {
            TFFinalCastlePieces.registerFinalCastlePieces();
            this.addMonster((Class<? extends EntityLiving>)EntityTFKobold.class, 10, 4, 4).addMonster((Class<? extends EntityLiving>)EntityTFAdherent.class, 10, 1, 1).addMonster((Class<? extends EntityLiving>)EntityTFHarbingerCube.class, 10, 1, 1).addMonster((Class<? extends EntityLiving>)EntityEnderman.class, 10, 1, 1).addMonster(1, (Class<? extends EntityLiving>)EntityTFKobold.class, 10, 4, 4).addMonster(1, (Class<? extends EntityLiving>)EntityTFAdherent.class, 10, 1, 1).addMonster(1, (Class<? extends EntityLiving>)EntityTFHarbingerCube.class, 10, 1, 1).addMonster(1, (Class<? extends EntityLiving>)EntityTFArmoredGiant.class, 10, 1, 1).addMonster(2, (Class<? extends EntityLiving>)EntityTFAdherent.class, 10, 1, 1).addMonster(3, (Class<? extends EntityLiving>)EntityBlaze.class, 10, 1, 1);
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartFinalCastle(world, this, rand, chunkX, chunkZ);
        }
    }, 
    MUSHROOM_TOWER(2, "mushroom_tower", true, new ResourceLocation[0]) {
        {
            TFMushroomTowerPieces.registerPieces();
        }
        
        @Override
        public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
            return new StructureStartMushroomTower(world, this, rand, chunkX, chunkZ);
        }
    };
    
    public final int size;
    public final String name;
    private final boolean shouldHaveFeatureGenerator;
    public boolean areChunkDecorationsEnabled;
    public boolean isStructureEnabled;
    public boolean isTerrainAltered;
    private List<List<Biome.SpawnListEntry>> spawnableMonsterLists;
    private List<Biome.SpawnListEntry> ambientCreatureList;
    private List<Biome.SpawnListEntry> waterCreatureList;
    private final ResourceLocation[] requiredAdvancements;
    public boolean hasProtectionAura;
    private long lastSpawnedHintMonsterTime;
    private static final String BOOK_AUTHOR = "A Forgotten Explorer";
    private static final TFFeature[] VALUES;
    private static final int maxSize;
    
    private TFFeature(final int size, final String name, final boolean featureGenerator, final ResourceLocation[] requiredAdvancements) {
        this.size = size;
        this.name = name;
        this.areChunkDecorationsEnabled = false;
        this.isStructureEnabled = true;
        this.isTerrainAltered = false;
        this.spawnableMonsterLists = new ArrayList<List<Biome.SpawnListEntry>>();
        this.ambientCreatureList = new ArrayList<Biome.SpawnListEntry>();
        this.waterCreatureList = new ArrayList<Biome.SpawnListEntry>();
        this.hasProtectionAura = true;
        this.ambientCreatureList.add(new Biome.SpawnListEntry((Class)EntityBat.class, 10, 8, 8));
        this.requiredAdvancements = requiredAdvancements;
        this.shouldHaveFeatureGenerator = featureGenerator;
    }
    
    static void init() {
    }
    
    public static int getCount() {
        return TFFeature.VALUES.length;
    }
    
    public static int getMaxSize() {
        return TFFeature.maxSize;
    }
    
    @Nullable
    public MapGenTFMajorFeature createFeatureGenerator() {
        return this.shouldHaveFeatureGenerator ? new MapGenTFMajorFeature(this) : null;
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
    
    public static int getFeatureID(final int mapX, final int mapZ, final World world) {
        return getFeatureAt(mapX, mapZ, world).ordinal();
    }
    
    public static TFFeature getFeatureAt(final int mapX, final int mapZ, final World world) {
        return generateFeature(mapX >> 4, mapZ >> 4, world);
    }
    
    public static boolean isInFeatureChunk(final World world, final int mapX, final int mapZ) {
        final int chunkX = mapX >> 4;
        final int chunkZ = mapZ >> 4;
        final BlockPos cc = getNearestCenterXYZ(chunkX, chunkZ, world);
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
    
    public TFFeature addMonster(final Class<? extends EntityLiving> monsterClass, final int weight, final int minGroup, final int maxGroup) {
        this.addMonster(0, monsterClass, weight, minGroup, maxGroup);
        return this;
    }
    
    public TFFeature addMonster(final int listIndex, final Class<? extends EntityLiving> monsterClass, final int weight, final int minGroup, final int maxGroup) {
        List<Biome.SpawnListEntry> monsterList;
        if (this.spawnableMonsterLists.size() > listIndex) {
            monsterList = this.spawnableMonsterLists.get(listIndex);
        }
        else {
            monsterList = new ArrayList<Biome.SpawnListEntry>();
            this.spawnableMonsterLists.add(listIndex, monsterList);
        }
        monsterList.add(new Biome.SpawnListEntry((Class)monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public TFFeature addWaterCreature(final Class<? extends EntityLiving> monsterClass, final int weight, final int minGroup, final int maxGroup) {
        this.waterCreatureList.add(new Biome.SpawnListEntry((Class)monsterClass, weight, minGroup, maxGroup));
        return this;
    }
    
    public static TFFeature getFeatureDirectlyAt(final int chunkX, final int chunkZ, final World world) {
        if (isInFeatureChunk(world, chunkX << 4, chunkZ << 4)) {
            return getFeatureAt(chunkX << 4, chunkZ << 4, world);
        }
        return TFFeature.NOTHING;
    }
    
    public static TFFeature generateFeature(int chunkX, int chunkZ, final World world) {
        chunkX = Math.round(chunkX / 16.0f) * 16;
        chunkZ = Math.round(chunkZ / 16.0f) * 16;
        final Biome biomeAt = world.func_180494_b(new BlockPos((chunkX << 4) + 8, 0, (chunkZ << 4) + 8));
        if (biomeAt instanceof TFBiomeBase) {
            final TFFeature biomeFeature = ((TFBiomeBase)biomeAt).containedFeature;
            if (biomeFeature != TFFeature.NOTHING) {
                return biomeFeature;
            }
        }
        final int regionOffsetX = Math.abs((chunkX + 64 >> 4) % 8);
        final int regionOffsetZ = Math.abs((chunkZ + 64 >> 4) % 8);
        if ((regionOffsetX == 4 && regionOffsetZ == 5) || (regionOffsetX == 4 && regionOffsetZ == 3)) {
            return TFFeature.LICH_TOWER;
        }
        if ((regionOffsetX == 5 && regionOffsetZ == 4) || (regionOffsetX == 3 && regionOffsetZ == 4)) {
            return TFFeature.NAGA_COURTYARD;
        }
        switch (new Random(world.func_72905_C() + chunkX * 25117 + chunkZ * 151121).nextInt(16)) {
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
    
    public static TFFeature getNearestFeature(final int cx, final int cz, final World world) {
        return getNearestFeature(cx, cz, world, null);
    }
    
    public static TFFeature getNearestFeature(final int cx, final int cz, final World world, @Nullable final IntPair center) {
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
    public static BlockPos findNearestFeaturePosBySpacing(final World worldIn, final TFFeature feature, final BlockPos blockPos, final int p_191069_3_, final int p_191069_4_, final int p_191069_5_, final boolean p_191069_6_, final int p_191069_7_, final boolean findUnexplored) {
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
                        final Random random2 = worldIn.func_72843_D(l2, i3, p_191069_5_);
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
                        MapGenBase.func_191068_a(worldIn.func_72905_C(), random, l2, i3);
                        random.nextInt();
                        if (getFeatureAt(l2 << 4, i3 << 4, worldIn) == feature) {
                            if (!findUnexplored || !worldIn.func_190526_b(l2, i3)) {
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
    
    public static TFFeature getFeatureForRegion(final int chunkX, final int chunkZ, final World world) {
        final int featureX = Math.round(chunkX / 16.0f) * 16;
        final int featureZ = Math.round(chunkZ / 16.0f) * 16;
        return generateFeature(featureX, featureZ, world);
    }
    
    public static TFFeature getFeatureForRegionPos(final int posX, final int posZ, final World world) {
        return getFeatureForRegion(posX >> 4, posZ >> 4, world);
    }
    
    public static BlockPos getNearestCenterXYZ(final int cx, final int cz, final World world) {
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
    
    public List<Biome.SpawnListEntry> getSpawnableList(final EnumCreatureType creatureType) {
        switch (creatureType) {
            case MONSTER: {
                return this.getSpawnableList(EnumCreatureType.MONSTER, 0);
            }
            case AMBIENT: {
                return this.ambientCreatureList;
            }
            case WATER_CREATURE: {
                return this.waterCreatureList;
            }
            default: {
                return new ArrayList<Biome.SpawnListEntry>();
            }
        }
    }
    
    public List<Biome.SpawnListEntry> getSpawnableList(final EnumCreatureType creatureType, final int index) {
        if (creatureType != EnumCreatureType.MONSTER) {
            return this.getSpawnableList(creatureType);
        }
        if (index >= 0 && index < this.spawnableMonsterLists.size()) {
            return this.spawnableMonsterLists.get(index);
        }
        return new ArrayList<Biome.SpawnListEntry>();
    }
    
    public boolean doesPlayerHaveRequiredAdvancements(final EntityPlayer player) {
        return PlayerHelper.doesPlayerHaveRequiredAdvancements(player, this.requiredAdvancements);
    }
    
    public void trySpawnHintMonster(final World world, final EntityPlayer player) {
        this.trySpawnHintMonster(world, player, new BlockPos((Entity)player));
    }
    
    public void trySpawnHintMonster(final World world, final EntityPlayer player, final BlockPos pos) {
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
    
    private boolean didSpawnHintMonster(final World world, final EntityPlayer player, final BlockPos pos) {
        final int dx = world.field_73012_v.nextInt(16) - world.field_73012_v.nextInt(16);
        final int dy = world.field_73012_v.nextInt(4) - world.field_73012_v.nextInt(4);
        final int dz = world.field_73012_v.nextInt(16) - world.field_73012_v.nextInt(16);
        final EntityTFKobold hinty = new EntityTFKobold(world);
        hinty.func_174828_a(pos.func_177982_a(dx, dy, dz), 0.0f, 0.0f);
        if (hinty.func_70058_J() && hinty.func_70635_at().func_75522_a((Entity)player)) {
            final ItemStack book = this.createHintBook();
            hinty.func_184201_a(EntityEquipmentSlot.MAINHAND, book);
            hinty.func_184642_a(EntityEquipmentSlot.MAINHAND, 1.0f);
            world.func_72838_d((Entity)hinty);
            return true;
        }
        return false;
    }
    
    public ItemStack createHintBook() {
        final ItemStack book = new ItemStack(Items.field_151164_bB);
        this.addBookInformation(book, new NBTTagList());
        return book;
    }
    
    protected void addBookInformation(final ItemStack book, final NBTTagList bookPages) {
        addTranslatedPages(bookPages, "twilightforest.book.unknown", 2);
        book.func_77983_a("pages", (NBTBase)bookPages);
        book.func_77983_a("author", (NBTBase)new NBTTagString("A Forgotten Explorer"));
        book.func_77983_a("title", (NBTBase)new NBTTagString("Notes on the Unexplained"));
    }
    
    public StructureStartTFAbstract provideStructureStart(final World world, final Random rand, final int chunkX, final int chunkZ) {
        return new StructureStartNothing(world, rand, chunkX, chunkZ);
    }
    
    private static void addTranslatedPages(final NBTTagList bookPages, final String translationKey, final int pageCount) {
        for (int i = 1; i <= pageCount; ++i) {
            bookPages.func_74742_a((NBTBase)new NBTTagString(ITextComponent.Serializer.func_150696_a((ITextComponent)new TextComponentTranslation(translationKey + "." + i, new Object[0]))));
        }
    }
    
    static {
        VALUES = values();
        maxSize = Arrays.stream(TFFeature.VALUES).mapToInt(v -> v.size).max().orElse(0);
    }
}
