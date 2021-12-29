// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import javax.annotation.Nonnull;
import net.minecraftforge.client.model.generators.ModelBuilder;
import javax.annotation.Nullable;
import twilightforest.block.HollowLogClimbable;
import twilightforest.block.HollowLogVertical;
import twilightforest.block.HollowLogHorizontal;
import net.minecraft.world.level.block.HugeMushroomBlock;
import twilightforest.block.AbstractLightableBlock;
import twilightforest.block.CandelabraBlock;
import java.util.Map;
import twilightforest.block.HugeLilyPadBlock;
import com.google.common.collect.ImmutableMap;
import twilightforest.enums.HugeLilypadPiece;
import twilightforest.block.AuroraBrickBlock;
import java.util.List;
import twilightforest.block.TrophyPedestalBlock;
import java.util.Arrays;
import java.util.ArrayList;
import twilightforest.block.CarminiteReactorBlock;
import twilightforest.block.TranslucentBuiltBlock;
import twilightforest.enums.TowerDeviceVariant;
import twilightforest.block.BuilderBlock;
import twilightforest.block.GhastTrapBlock;
import twilightforest.block.LockedVanishingBlock;
import twilightforest.block.VanishingBlock;
import twilightforest.block.SliderBlock;
import twilightforest.block.WallPillarBlock;
import twilightforest.enums.BanisterShape;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.SlabBlock;
import java.util.function.Consumer;
import twilightforest.block.CastleDoorBlock;
import twilightforest.block.SpecialMagicLogBlock;
import twilightforest.enums.HollowLogVariants;
import twilightforest.block.BanisterBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.DoorBlock;
import twilightforest.block.TorchberryPlantBlock;
import twilightforest.enums.FireJetVariant;
import twilightforest.block.FireJetBlock;
import twilightforest.block.EncasedSmokerBlock;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import twilightforest.enums.BlockLoggingEnum;
import twilightforest.block.KeepsakeCasketBlock;
import net.minecraft.world.level.block.DirectionalBlock;
import twilightforest.block.DirectionalRotatedPillarBlock;
import twilightforest.block.NagastoneBlock;
import twilightforest.enums.NagastoneVariant;
import com.google.common.collect.UnmodifiableIterator;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraftforge.fmllegacy.RegistryObject;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import twilightforest.block.TomeSpawnerBlock;
import twilightforest.block.UncraftingTableBlock;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.resources.ResourceLocation;
import twilightforest.block.IronLadderBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.core.Direction;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import twilightforest.block.Experiment115Block;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.TFPortalBlock;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import twilightforest.TwilightForestMod;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;

public class BlockstateGenerator extends BlockStateProvider
{
    public BlockstateGenerator(final DataGenerator gen, final ExistingFileHelper exFileHelper) {
        super(gen, "twilightforest", exFileHelper);
    }
    
    protected void registerStatesAndModels() {
        this.tintedAndFlipped((Block)TFBlocks.TOWERWOOD.get());
        this.simpleBlock((Block)TFBlocks.ENCASED_TOWERWOOD.get(), (ModelFile)this.cubeAllTinted(TFBlocks.ENCASED_TOWERWOOD.getId().m_135815_(), TFBlocks.ENCASED_TOWERWOOD.getId().m_135815_()));
        this.simpleBlock((Block)TFBlocks.CRACKED_TOWERWOOD.get(), ConfiguredModel.builder().modelFile((ModelFile)this.cubeAllTinted(TFBlocks.CRACKED_TOWERWOOD.getId().m_135815_(), TFBlocks.CRACKED_TOWERWOOD.getId().m_135815_())).nextModel().modelFile((ModelFile)this.cubeAllTinted(TFBlocks.CRACKED_TOWERWOOD.getId().m_135815_() + "_flipped", TFBlocks.CRACKED_TOWERWOOD.getId().m_135815_(), true)).nextModel().modelFile((ModelFile)this.cubeAllTinted(TFBlocks.CRACKED_TOWERWOOD.getId().m_135815_() + "_alt", TFBlocks.CRACKED_TOWERWOOD.getId().m_135815_() + "_alt")).nextModel().modelFile((ModelFile)this.cubeAllTinted(TFBlocks.CRACKED_TOWERWOOD.getId().m_135815_() + "_alt_flipped", TFBlocks.CRACKED_TOWERWOOD.getId().m_135815_() + "_alt", true)).build());
        this.tintedAndFlipped((Block)TFBlocks.MOSSY_TOWERWOOD.get());
        this.tintedAndFlipped((Block)TFBlocks.INFESTED_TOWERWOOD.get());
        this.builtinEntity((Block)TFBlocks.FIREFLY.get(), "twilightforest:block/stone_twist/twist_blank");
        this.builtinEntity((Block)TFBlocks.MOONWORM.get(), "twilightforest:block/stone_twist/twist_blank");
        this.builtinEntity((Block)TFBlocks.CICADA.get(), "twilightforest:block/stone_twist/twist_blank");
        final ModelFile portalModel = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/twilight_portal"));
        final ModelFile portalOverlayModel = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/twilight_portal_barrier"));
        ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)TFBlocks.TWILIGHT_PORTAL.get()).part().modelFile(portalModel).addModel()).end().part().modelFile(portalOverlayModel).addModel()).condition((Property)TFPortalBlock.DISALLOW_RETURN, (Comparable[])new Boolean[] { true }).end();
        this.getVariantBuilder((Block)TFBlocks.EXPERIMENT_115.get()).forAllStates(state -> {
            final int bitesTaken = (int)state.m_61143_((Property)Experiment115Block.BITES_TAKEN);
            final String basePath = String.format("block/experiment115_%d_8", 8 - bitesTaken);
            ModelFile model;
            if (state.m_61143_((Property)Experiment115Block.REGENERATE)) {
                model = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(basePath + "_regenerating", TwilightForestMod.prefix(basePath))).texture("top_2", "block/experiment115/experiment115_sprinkle");
            }
            else {
                model = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix(basePath));
            }
            return ConfiguredModel.builder().modelFile(model).build();
        });
        final MultiPartBlockStateBuilder ironLadder = this.getMultipartBuilder((Block)TFBlocks.IRON_LADDER.get());
        final ModelFile ironLadderLeft = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/iron_ladder_left"));
        final ModelFile ironLadderLeftConnected = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/iron_ladder_left_connection"));
        final ModelFile ironLadderRight = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/iron_ladder_right"));
        final ModelFile ironLadderRightConnected = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/iron_ladder_right_connection"));
        for (final Direction d : Direction.Plane.HORIZONTAL) {
            int n = switch (d) {
                default -> 0;
                case EAST -> 90;
                case SOUTH -> 180;
                case WEST -> 270;
            };
            final int rotY = n;
            ((MultiPartBlockStateBuilder.PartBuilder)ironLadder.part().modelFile(ironLadderLeft).rotationY(rotY).addModel()).condition((Property)LadderBlock.f_54337_, (Comparable[])new Direction[] { d }).condition((Property)IronLadderBlock.LEFT, (Comparable[])new Boolean[] { false }).end();
            ((MultiPartBlockStateBuilder.PartBuilder)ironLadder.part().modelFile(ironLadderLeftConnected).rotationY(rotY).addModel()).condition((Property)LadderBlock.f_54337_, (Comparable[])new Direction[] { d }).condition((Property)IronLadderBlock.LEFT, (Comparable[])new Boolean[] { true }).end();
            ((MultiPartBlockStateBuilder.PartBuilder)ironLadder.part().modelFile(ironLadderRight).rotationY(rotY).addModel()).condition((Property)LadderBlock.f_54337_, (Comparable[])new Direction[] { d }).condition((Property)IronLadderBlock.RIGHT, (Comparable[])new Boolean[] { false }).end();
            ((MultiPartBlockStateBuilder.PartBuilder)ironLadder.part().modelFile(ironLadderRightConnected).rotationY(rotY).addModel()).condition((Property)LadderBlock.f_54337_, (Comparable[])new Direction[] { d }).condition((Property)IronLadderBlock.RIGHT, (Comparable[])new Boolean[] { true }).end();
        }
        this.towerBlocks();
        this.simpleBlock((Block)TFBlocks.FAKE_GOLD.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/gold_block")));
        this.simpleBlock((Block)TFBlocks.FAKE_DIAMOND.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/diamond_block")));
        this.simpleBlock((Block)TFBlocks.NAGA_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.LICH_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.MINOSHROOM_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.HYDRA_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.ALPHA_YETI_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.SNOW_QUEEN_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.KNIGHT_PHANTOM_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.UR_GHAST_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.QUEST_RAM_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.NAGA_WALL_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.LICH_WALL_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.MINOSHROOM_WALL_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.HYDRA_WALL_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.ALPHA_YETI_WALL_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.SNOW_QUEEN_WALL_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.KNIGHT_PHANTOM_WALL_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.UR_GHAST_WALL_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.QUEST_RAM_WALL_TROPHY.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.ZOMBIE_SKULL_CANDLE.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.ZOMBIE_WALL_SKULL_CANDLE.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.SKELETON_SKULL_CANDLE.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.SKELETON_WALL_SKULL_CANDLE.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.WITHER_SKELE_SKULL_CANDLE.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.WITHER_SKELE_WALL_SKULL_CANDLE.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.CREEPER_SKULL_CANDLE.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.CREEPER_WALL_SKULL_CANDLE.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.PLAYER_SKULL_CANDLE.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.PLAYER_WALL_SKULL_CANDLE.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        final ModelFile shieldModel = (ModelFile)this.models().cubeTop(TFBlocks.STRONGHOLD_SHIELD.getId().m_135815_(), TwilightForestMod.prefix("block/shield_outside"), TwilightForestMod.prefix("block/shield_inside"));
        this.getVariantBuilder((Block)TFBlocks.STRONGHOLD_SHIELD.get()).forAllStates(state -> {
            final Direction dir = (Direction)state.m_61143_((Property)BlockStateProperties.f_61372_);
            return ConfiguredModel.builder().uvLock(true).modelFile(shieldModel).rotationX((dir == Direction.DOWN) ? 180 : (dir.m_122434_().m_122479_() ? 90 : 0)).rotationY(dir.m_122434_().m_122478_() ? 0 : ((int)dir.m_122435_() % 360)).build();
        });
        this.trophyPedestal();
        this.auroraBlocks();
        this.slider();
        this.simpleBlock((Block)TFBlocks.UNDERBRICK.get());
        this.simpleBlock((Block)TFBlocks.CRACKED_UNDERBRICK.get());
        this.simpleBlock((Block)TFBlocks.MOSSY_UNDERBRICK.get());
        this.simpleBlock((Block)TFBlocks.UNDERBRICK_FLOOR.get());
        this.thorns();
        this.simpleBlock((Block)TFBlocks.THORN_ROSE.get(), (ModelFile)this.models().cross(TFBlocks.THORN_ROSE.getId().m_135815_(), this.blockTexture((Block)TFBlocks.THORN_ROSE.get())));
        this.simpleBlock((Block)TFBlocks.THORN_LEAVES.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/oak_leaves")));
        this.simpleBlock((Block)TFBlocks.BEANSTALK_LEAVES.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/spruce_leaves")));
        this.simpleBlock((Block)TFBlocks.HOLLOW_OAK_SAPLING.get(), (ModelFile)this.models().cross(TFBlocks.HOLLOW_OAK_SAPLING.getId().m_135815_(), this.blockTexture((Block)TFBlocks.HOLLOW_OAK_SAPLING.get())));
        final ModelFile deadrock = (ModelFile)this.models().cubeAll(TFBlocks.DEADROCK.getId().m_135815_(), this.blockTexture((Block)TFBlocks.DEADROCK.get()));
        final ModelFile deadrockMirrored = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.DEADROCK.getId().m_135815_() + "_mirrored", TwilightForestMod.prefix("block/util/cube_mirrored_all"))).texture("all", this.blockTexture((Block)TFBlocks.DEADROCK.get()));
        this.simpleBlock((Block)TFBlocks.DEADROCK.get(), ConfiguredModel.builder().modelFile(deadrock).nextModel().rotationY(180).modelFile(deadrock).nextModel().modelFile(deadrockMirrored).nextModel().rotationY(180).modelFile(deadrockMirrored).build());
        final ModelFile deadrockCracked = (ModelFile)this.models().cubeAll(TFBlocks.CRACKED_DEADROCK.getId().m_135815_(), this.blockTexture((Block)TFBlocks.CRACKED_DEADROCK.get()));
        this.allRotations((Block)TFBlocks.CRACKED_DEADROCK.get(), deadrockCracked);
        final ModelFile deadrockWeathered = (ModelFile)this.models().cubeAll(TFBlocks.WEATHERED_DEADROCK.getId().m_135815_(), this.blockTexture((Block)TFBlocks.WEATHERED_DEADROCK.get()));
        this.allRotations((Block)TFBlocks.WEATHERED_DEADROCK.get(), deadrockWeathered);
        this.perFaceBlock((Block)TFBlocks.TROLLSTEINN.get(), this.blockTexture((Block)TFBlocks.TROLLSTEINN.get()), TwilightForestMod.prefix("block/" + TFBlocks.TROLLSTEINN.getId().m_135815_() + "_light"));
        this.simpleBlock((Block)TFBlocks.WISPY_CLOUD.get());
        this.simpleBlock((Block)TFBlocks.FLUFFY_CLOUD.get());
        this.simpleBlock((Block)TFBlocks.GIANT_COBBLESTONE.get(), (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.GIANT_COBBLESTONE.getId().m_135815_(), TwilightForestMod.prefix("block/util/giant_block"))).texture("all", this.blockTexture(Blocks.f_50652_)));
        this.simpleBlock((Block)TFBlocks.GIANT_LOG.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.GIANT_LOG.getId().m_135815_(), TwilightForestMod.prefix("block/util/giant_column"))).texture("side", this.blockTexture(Blocks.f_49999_))).texture("end", new ResourceLocation("block/oak_log_top")));
        this.simpleBlock((Block)TFBlocks.GIANT_LEAVES.get(), (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.GIANT_LEAVES.getId().m_135815_(), TwilightForestMod.prefix("block/util/giant_block"))).texture("all", this.blockTexture(Blocks.f_50050_)));
        this.simpleBlock((Block)TFBlocks.GIANT_OBSIDIAN.get(), (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.GIANT_OBSIDIAN.getId().m_135815_(), TwilightForestMod.prefix("block/util/giant_block"))).texture("all", this.blockTexture(Blocks.f_50080_)));
        this.simpleBlock((Block)TFBlocks.UBEROUS_SOIL.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.UBEROUS_SOIL.getId().m_135815_(), "block/template_farmland")).texture("top", this.blockTexture((Block)TFBlocks.UBEROUS_SOIL.get()))).texture("dirt", this.blockTexture((Block)TFBlocks.UBEROUS_SOIL.get())));
        this.axisBlock((RotatedPillarBlock)TFBlocks.HUGE_STALK.get(), TwilightForestMod.prefix("block/huge_stalk"), TwilightForestMod.prefix("block/huge_stalk_top"));
        this.perFaceBlock((Block)TFBlocks.HUGE_MUSHGLOOM.get(), TwilightForestMod.prefix("block/huge_gloom_inside"), TwilightForestMod.prefix("block/huge_gloom_cap"));
        this.perFaceBlock((Block)TFBlocks.HUGE_MUSHGLOOM_STEM.get(), TwilightForestMod.prefix("block/huge_gloom_inside"), TwilightForestMod.prefix("block/huge_mushgloom_stem"));
        this.simpleBlock((Block)TFBlocks.TROLLVIDR.get(), (ModelFile)this.models().cross(TFBlocks.TROLLVIDR.getId().m_135815_(), this.blockTexture((Block)TFBlocks.TROLLVIDR.get())));
        this.simpleBlock((Block)TFBlocks.UNRIPE_TROLLBER.get(), (ModelFile)this.models().cross(TFBlocks.UNRIPE_TROLLBER.getId().m_135815_(), this.blockTexture((Block)TFBlocks.UNRIPE_TROLLBER.get())));
        final ModelFile trollber = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.TROLLBER.getId().m_135815_(), TwilightForestMod.prefix("block/util/cross_2_layer"))).texture("cross", this.blockTexture((Block)TFBlocks.TROLLBER.get()))).texture("cross2", TwilightForestMod.prefix("block/" + TFBlocks.TROLLBER.getId().m_135815_() + "_glow"));
        this.simpleBlock((Block)TFBlocks.TROLLBER.get(), trollber);
        this.lilyPad((Block)TFBlocks.HUGE_LILY_PAD.get());
        this.simpleBlock((Block)TFBlocks.HUGE_WATER_LILY.get(), (ModelFile)this.models().cross(TFBlocks.HUGE_WATER_LILY.getId().m_135815_(), this.blockTexture((Block)TFBlocks.HUGE_WATER_LILY.get())));
        this.simpleBlock((Block)TFBlocks.CASTLE_BRICK.get());
        this.simpleBlock((Block)TFBlocks.WORN_CASTLE_BRICK.get());
        this.simpleBlock((Block)TFBlocks.CRACKED_CASTLE_BRICK.get());
        this.allRotations((Block)TFBlocks.CASTLE_ROOF_TILE.get(), this.cubeAll((Block)TFBlocks.CASTLE_ROOF_TILE.get()));
        this.simpleBlock((Block)TFBlocks.MOSSY_CASTLE_BRICK.get());
        this.simpleBlock((Block)TFBlocks.THICK_CASTLE_BRICK.get());
        this.rotationallyCorrectColumn((Block)TFBlocks.ENCASED_CASTLE_BRICK_PILLAR.get());
        this.rotationallyCorrectColumn((Block)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get());
        this.simpleBlock((Block)TFBlocks.ENCASED_CASTLE_BRICK_TILE.get(), (ModelFile)this.models().cubeAll(TFBlocks.ENCASED_CASTLE_BRICK_TILE.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.ENCASED_CASTLE_BRICK_PILLAR.getId().m_135815_() + "_end")));
        this.simpleBlock((Block)TFBlocks.BOLD_CASTLE_BRICK_TILE.get());
        this.stairsBlock((StairBlock)TFBlocks.CASTLE_BRICK_STAIRS.get(), TwilightForestMod.prefix("block/" + TFBlocks.CASTLE_BRICK_STAIRS.getId().m_135815_()));
        this.stairsBlock((StairBlock)TFBlocks.WORN_CASTLE_BRICK_STAIRS.get(), TwilightForestMod.prefix("block/" + TFBlocks.WORN_CASTLE_BRICK.getId().m_135815_()));
        this.stairsBlock((StairBlock)TFBlocks.CRACKED_CASTLE_BRICK_STAIRS.get(), TwilightForestMod.prefix("block/" + TFBlocks.CRACKED_CASTLE_BRICK_STAIRS.getId().m_135815_()));
        this.stairsBlock((StairBlock)TFBlocks.MOSSY_CASTLE_BRICK_STAIRS.get(), TwilightForestMod.prefix("block/" + TFBlocks.MOSSY_CASTLE_BRICK_STAIRS.getId().m_135815_()));
        this.stairsBlock((StairBlock)TFBlocks.ENCASED_CASTLE_BRICK_STAIRS.get(), TwilightForestMod.prefix("block/" + TFBlocks.ENCASED_CASTLE_BRICK_PILLAR.getId().m_135815_() + "_h"), TwilightForestMod.prefix("block/castleblock_tile"), TwilightForestMod.prefix("block/" + TFBlocks.CASTLE_ROOF_TILE.getId().m_135815_()));
        this.stairsBlock((StairBlock)TFBlocks.BOLD_CASTLE_BRICK_STAIRS.get(), TwilightForestMod.prefix("block/" + TFBlocks.BOLD_CASTLE_BRICK_TILE.getId().m_135815_()));
        final ConfiguredModel[] runeBrickModels = new ConfiguredModel[8];
        for (int i = 0; i < runeBrickModels.length; ++i) {
            runeBrickModels[i] = new ConfiguredModel((ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("castle_rune_brick_" + i, TwilightForestMod.prefix("block/util/cube_all_2_layer"))).texture("all", TwilightForestMod.prefix("block/castle_brick"))).texture("all2", TwilightForestMod.prefix("block/castleblock_magic_" + i)));
        }
        this.simpleBlock((Block)TFBlocks.YELLOW_CASTLE_RUNE_BRICK.get(), runeBrickModels);
        this.simpleBlock((Block)TFBlocks.VIOLET_CASTLE_RUNE_BRICK.get(), runeBrickModels);
        this.simpleBlock((Block)TFBlocks.PINK_CASTLE_RUNE_BRICK.get(), runeBrickModels);
        this.simpleBlock((Block)TFBlocks.BLUE_CASTLE_RUNE_BRICK.get(), runeBrickModels);
        this.logBlock((RotatedPillarBlock)TFBlocks.CINDER_LOG.get());
        this.simpleBlock((Block)TFBlocks.CINDER_WOOD.get(), (ModelFile)this.models().cubeAll(TFBlocks.CINDER_WOOD.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.CINDER_LOG.getId().m_135815_())));
        final ModelFile furnaceOff = (ModelFile)this.models().getExistingFile(new ResourceLocation("block/furnace"));
        final ModelFile furnaceOn = (ModelFile)this.models().getExistingFile(new ResourceLocation("block/furnace_on"));
        this.horizontalBlock((Block)TFBlocks.CINDER_FURNACE.get(), state -> state.m_61143_((Property)AbstractFurnaceBlock.f_48684_) ? furnaceOn : furnaceOff);
        this.castleDoor((Block)TFBlocks.YELLOW_CASTLE_DOOR.get());
        this.castleDoor((Block)TFBlocks.VIOLET_CASTLE_DOOR.get());
        this.castleDoor((Block)TFBlocks.PINK_CASTLE_DOOR.get());
        this.castleDoor((Block)TFBlocks.BLUE_CASTLE_DOOR.get());
        this.simpleBlockExisting((Block)TFBlocks.KNIGHTMETAL_BLOCK.get());
        this.simpleBlockExisting((Block)TFBlocks.IRONWOOD_BLOCK.get());
        this.simpleBlockExisting((Block)TFBlocks.FIERY_BLOCK.get());
        this.simpleBlock((Block)TFBlocks.ARCTIC_FUR_BLOCK.get());
        final ModelFile steeleafBlock = (ModelFile)this.models().cubeAll(TFBlocks.STEELEAF_BLOCK.getId().m_135815_(), TwilightForestMod.prefix("block/" + TFBlocks.STEELEAF_BLOCK.getId().m_135815_()));
        this.allRotations((Block)TFBlocks.STEELEAF_BLOCK.get(), steeleafBlock);
        final ModelFile carminiteBlock = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.CARMINITE_BLOCK.getId().m_135815_(), TwilightForestMod.prefix("block/util/cube_all_2_layer"))).texture("all", TwilightForestMod.prefix("block/" + TFBlocks.CARMINITE_BLOCK.getId().m_135815_()))).texture("all2", TwilightForestMod.prefix("block/" + TFBlocks.CARMINITE_BLOCK.getId().m_135815_() + "_overlay"));
        this.allRotations((Block)TFBlocks.CARMINITE_BLOCK.get(), carminiteBlock);
        this.simpleBlock((Block)TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/miniature/portal")));
        this.simpleBlock((Block)TFBlocks.NAGA_COURTYARD_MINIATURE_STRUCTURE.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/miniature/naga_courtyard")));
        this.simpleBlock((Block)TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/miniature/lich_tower")));
        this.mazestone();
        this.simpleBlock((Block)TFBlocks.HEDGE.get(), ConfiguredModel.builder().weight(10).modelFile((ModelFile)this.models().cubeAll(TFBlocks.HEDGE.getId().m_135815_(), this.blockTexture((Block)TFBlocks.HEDGE.get()))).nextModel().weight(1).modelFile((ModelFile)this.models().cubeAll(TFBlocks.HEDGE.getId().m_135815_() + "_rose", TwilightForestMod.prefix("block/" + TFBlocks.HEDGE.getId().m_135815_() + "_rose"))).build());
        final ModelFile bigSpawner = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("boss_spawner", "block/block")).texture("particle", "#all")).texture("all", TwilightForestMod.prefix("block/boss_spawner"))).element().from(-4.0f, -4.0f, -4.0f).to(20.0f, 20.0f, 20.0f).allFaces((dir, builder) -> builder.uvs(2.0f, 2.0f, 14.0f, 14.0f).texture("#all")).end();
        this.simpleBlock((Block)TFBlocks.NAGA_BOSS_SPAWNER.get(), bigSpawner);
        this.simpleBlock((Block)TFBlocks.LICH_BOSS_SPAWNER.get(), bigSpawner);
        this.simpleBlock((Block)TFBlocks.HYDRA_BOSS_SPAWNER.get(), bigSpawner);
        this.simpleBlock((Block)TFBlocks.UR_GHAST_BOSS_SPAWNER.get(), bigSpawner);
        this.simpleBlock((Block)TFBlocks.KNIGHT_PHANTOM_BOSS_SPAWNER.get(), bigSpawner);
        this.simpleBlock((Block)TFBlocks.SNOW_QUEEN_BOSS_SPAWNER.get(), bigSpawner);
        this.simpleBlock((Block)TFBlocks.MINOSHROOM_BOSS_SPAWNER.get(), bigSpawner);
        this.simpleBlock((Block)TFBlocks.ALPHA_YETI_BOSS_SPAWNER.get(), bigSpawner);
        this.simpleBlock((Block)TFBlocks.FINAL_BOSS_BOSS_SPAWNER.get(), bigSpawner);
        this.simpleBlockExisting((Block)TFBlocks.FIREFLY_JAR.get());
        this.simpleBlockExisting((Block)TFBlocks.FIREFLY_SPAWNER.get());
        this.simpleBlockExisting((Block)TFBlocks.CICADA_JAR.get());
        this.registerPlantBlocks();
        this.simpleBlock((Block)TFBlocks.ROOT_BLOCK.get());
        this.simpleBlock((Block)TFBlocks.LIVEROOT_BLOCK.get());
        this.simpleBlock((Block)TFBlocks.MANGROVE_ROOT.get());
        final ModelFile glowing = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.UNCRAFTING_TABLE.getId().m_135815_() + "_glowing", TwilightForestMod.prefix("block/util/cube_bottom_double_top_and_sides"))).texture("top", TwilightForestMod.prefix("block/uncrafting_top"))).texture("glow", TwilightForestMod.prefix("block/uncrafting_glow"))).texture("sideglow", TwilightForestMod.prefix("block/uncrafting_glow_side"))).texture("bottom", new ResourceLocation("block/jungle_planks"))).texture("side", TwilightForestMod.prefix("block/uncrafting_side"));
        final ModelFile notglowing = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.UNCRAFTING_TABLE.getId().m_135815_(), TwilightForestMod.prefix("block/util/cube_bottom_double_top"))).texture("top", TwilightForestMod.prefix("block/uncrafting_top"))).texture("glow", TwilightForestMod.prefix("block/uncrafting_glow"))).texture("bottom", new ResourceLocation("block/jungle_planks"))).texture("side", TwilightForestMod.prefix("block/uncrafting_side"));
        this.getVariantBuilder((Block)TFBlocks.UNCRAFTING_TABLE.get()).forAllStates(s -> ConfiguredModel.builder().modelFile(((boolean)s.m_61143_((Property)UncraftingTableBlock.POWERED)) ? glowing : notglowing).build());
        this.registerSmokersAndJets();
        this.axisBlock((RotatedPillarBlock)TFBlocks.TWISTED_STONE.get(), TwilightForestMod.prefix("block/stone_twist/twist_side"), TwilightForestMod.prefix("block/stone_twist/twist_end"));
        this.axisBlock((RotatedPillarBlock)TFBlocks.BOLD_STONE_PILLAR.get(), TwilightForestMod.prefix("block/stone_pillar_side"), TwilightForestMod.prefix("block/stone_pillar_end"));
        this.simpleBlock((Block)TFBlocks.EMPTY_CANOPY_BOOKSHELF.get(), (ModelFile)this.models().cubeColumn("empty_canopy_bookshelf", TwilightForestMod.prefix("block/wood/bookshelf_spawner/bookshelf_empty"), TwilightForestMod.prefix("block/wood/planks_canopy_0")));
        this.simpleBlock((Block)TFBlocks.CANOPY_BOOKSHELF.get(), ConfiguredModel.builder().weight(3).modelFile((ModelFile)this.models().cubeColumn("canopy_bookshelf", TwilightForestMod.prefix("block/wood/bookshelf_canopy"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).nextModel().modelFile((ModelFile)this.models().cubeColumn("canopy_bookshelf_1", TwilightForestMod.prefix("block/wood/bookshelf_canopy_1"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).nextModel().modelFile((ModelFile)this.models().cubeColumn("canopy_bookshelf_2", TwilightForestMod.prefix("block/wood/bookshelf_canopy_2"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).nextModel().modelFile((ModelFile)this.models().cubeColumn("canopy_bookshelf_3", TwilightForestMod.prefix("block/wood/bookshelf_canopy_3"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).build());
        this.getVariantBuilder((Block)TFBlocks.DEATH_TOME_SPAWNER.get()).forAllStatesExcept(s -> {
            switch ((int)s.m_61143_((Property)TomeSpawnerBlock.BOOK_STAGES)) {
                case 1: {
                    return ConfiguredModel.builder().modelFile((ModelFile)this.models().cubeColumn("block/death_tome_spawner_1", TwilightForestMod.prefix("block/wood/bookshelf_spawner/bookshelf_1"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).build();
                }
                case 2: {
                    return ConfiguredModel.builder().modelFile((ModelFile)this.models().cubeColumn("block/death_tome_spawner_2", TwilightForestMod.prefix("block/wood/bookshelf_spawner/bookshelf_2"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).build();
                }
                case 3: {
                    return ConfiguredModel.builder().modelFile((ModelFile)this.models().cubeColumn("block/death_tome_spawner_3", TwilightForestMod.prefix("block/wood/bookshelf_spawner/bookshelf_3"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).build();
                }
                case 4: {
                    return ConfiguredModel.builder().modelFile((ModelFile)this.models().cubeColumn("block/death_tome_spawner_4", TwilightForestMod.prefix("block/wood/bookshelf_spawner/bookshelf_4"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).build();
                }
                case 5: {
                    return ConfiguredModel.builder().modelFile((ModelFile)this.models().cubeColumn("block/death_tome_spawner_5", TwilightForestMod.prefix("block/wood/bookshelf_spawner/bookshelf_5"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).build();
                }
                case 6: {
                    return ConfiguredModel.builder().modelFile((ModelFile)this.models().cubeColumn("block/death_tome_spawner_6", TwilightForestMod.prefix("block/wood/bookshelf_spawner/bookshelf_6"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).build();
                }
                case 7: {
                    return ConfiguredModel.builder().modelFile((ModelFile)this.models().cubeColumn("block/death_tome_spawner_7", TwilightForestMod.prefix("block/wood/bookshelf_spawner/bookshelf_7"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).build();
                }
                case 8: {
                    return ConfiguredModel.builder().modelFile((ModelFile)this.models().cubeColumn("block/death_tome_spawner_8", TwilightForestMod.prefix("block/wood/bookshelf_spawner/bookshelf_8"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).build();
                }
                case 9: {
                    return ConfiguredModel.builder().modelFile((ModelFile)this.models().cubeColumn("block/death_tome_spawner_9", TwilightForestMod.prefix("block/wood/bookshelf_spawner/bookshelf_9"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).build();
                }
                default: {
                    return ConfiguredModel.builder().modelFile((ModelFile)this.models().cubeColumn("block/death_tome_spawner_10", TwilightForestMod.prefix("block/wood/bookshelf_canopy"), TwilightForestMod.prefix("block/wood/planks_canopy_0"))).build();
                }
            }
        }, new Property[] { (Property)TomeSpawnerBlock.SPAWNER });
        this.registerWoodBlocks();
        this.registerNagastone();
        this.registerForceFields();
        this.simpleBlock((Block)TFBlocks.POTTED_TWILIGHT_OAK_SAPLING.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_twilight_oak_sapling")));
        this.simpleBlock((Block)TFBlocks.POTTED_CANOPY_SAPLING.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_canopy_sapling")));
        this.simpleBlock((Block)TFBlocks.POTTED_MANGROVE_SAPLING.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_mangrove_sapling")));
        this.simpleBlock((Block)TFBlocks.POTTED_DARKWOOD_SAPLING.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_darkwood_sapling")));
        this.simpleBlock((Block)TFBlocks.POTTED_HOLLOW_OAK_SAPLING.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_hollow_oak_sapling")));
        this.simpleBlock((Block)TFBlocks.POTTED_RAINBOW_OAK_SAPLING.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_rainboak_sapling")));
        this.simpleBlock((Block)TFBlocks.POTTED_TIME_SAPLING.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_time_sapling")));
        this.simpleBlock((Block)TFBlocks.POTTED_TRANSFORMATION_SAPLING.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_trans_sapling")));
        this.simpleBlock((Block)TFBlocks.POTTED_MINING_SAPLING.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_mine_sapling")));
        this.simpleBlock((Block)TFBlocks.POTTED_SORTING_SAPLING.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_sort_sapling")));
        this.simpleBlock((Block)TFBlocks.POTTED_MAYAPPLE.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_mayapple")));
        this.simpleBlock((Block)TFBlocks.POTTED_FIDDLEHEAD.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_fiddlehead")));
        this.simpleBlock((Block)TFBlocks.POTTED_MUSHGLOOM.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_mushgloom")));
        this.simpleBlock((Block)TFBlocks.POTTED_THORN.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_thorn")));
        this.simpleBlock((Block)TFBlocks.POTTED_GREEN_THORN.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_green_thorn")));
        this.simpleBlock((Block)TFBlocks.POTTED_DEAD_THORN.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_dead_thorn")));
        this.builtinEntity((Block)TFBlocks.TWILIGHT_OAK_SIGN.get(), "twilightforest:block/wood/planks_twilight_oak_0");
        this.builtinEntity((Block)TFBlocks.TWILIGHT_WALL_SIGN.get(), "twilightforest:block/wood/planks_twilight_oak_0");
        this.builtinEntity((Block)TFBlocks.CANOPY_SIGN.get(), "twilightforest:block/wood/planks_canopy_0");
        this.builtinEntity((Block)TFBlocks.CANOPY_WALL_SIGN.get(), "twilightforest:block/wood/planks_canopy_0");
        this.builtinEntity((Block)TFBlocks.MANGROVE_SIGN.get(), "twilightforest:block/wood/planks_mangrove_0");
        this.builtinEntity((Block)TFBlocks.MANGROVE_WALL_SIGN.get(), "twilightforest:block/wood/planks_mangrove_0");
        this.builtinEntity((Block)TFBlocks.DARKWOOD_SIGN.get(), "twilightforest:block/wood/planks_darkwood_0");
        this.builtinEntity((Block)TFBlocks.DARKWOOD_WALL_SIGN.get(), "twilightforest:block/wood/planks_darkwood_0");
        this.builtinEntity((Block)TFBlocks.TIME_SIGN.get(), "twilightforest:block/wood/planks_time_0");
        this.builtinEntity((Block)TFBlocks.TIME_WALL_SIGN.get(), "twilightforest:block/wood/planks_time_0");
        this.builtinEntity((Block)TFBlocks.TRANSFORMATION_SIGN.get(), "twilightforest:block/wood/planks_trans_0");
        this.builtinEntity((Block)TFBlocks.TRANSFORMATION_WALL_SIGN.get(), "twilightforest:block/wood/planks_trans_0");
        this.builtinEntity((Block)TFBlocks.MINING_SIGN.get(), "twilightforest:block/wood/planks_mine_0");
        this.builtinEntity((Block)TFBlocks.MINING_WALL_SIGN.get(), "twilightforest:block/wood/planks_mine_0");
        this.builtinEntity((Block)TFBlocks.SORTING_SIGN.get(), "twilightforest:block/wood/planks_sort_0");
        this.builtinEntity((Block)TFBlocks.SORTING_WALL_SIGN.get(), "twilightforest:block/wood/planks_sort_0");
        this.builtinEntity((Block)TFBlocks.TWILIGHT_OAK_CHEST.get(), "twilightforest:block/wood/planks_twilight_oak_0");
        this.builtinEntity((Block)TFBlocks.CANOPY_CHEST.get(), "twilightforest:block/wood/planks_canopy_0");
        this.builtinEntity((Block)TFBlocks.MANGROVE_CHEST.get(), "twilightforest:block/wood/planks_mangrove_0");
        this.builtinEntity((Block)TFBlocks.DARKWOOD_CHEST.get(), "twilightforest:block/wood/planks_darkwood_0");
        this.builtinEntity((Block)TFBlocks.TIME_CHEST.get(), "twilightforest:block/wood/planks_time_0");
        this.builtinEntity((Block)TFBlocks.TRANSFORMATION_CHEST.get(), "twilightforest:block/wood/planks_trans_0");
        this.builtinEntity((Block)TFBlocks.MINING_CHEST.get(), "twilightforest:block/wood/planks_mine_0");
        this.builtinEntity((Block)TFBlocks.SORTING_CHEST.get(), "twilightforest:block/wood/planks_sort_0");
        this.casketStuff();
        this.stonePillar();
        this.candelabra();
    }
    
    private void registerForceFields() {
        final ImmutableList<RegistryObject<Block>> forceFields = (ImmutableList<RegistryObject<Block>>)ImmutableList.of((Object)TFBlocks.PINK_FORCE_FIELD, (Object)TFBlocks.BLUE_FORCE_FIELD, (Object)TFBlocks.GREEN_FORCE_FIELD, (Object)TFBlocks.VIOLET_FORCE_FIELD, (Object)TFBlocks.ORANGE_FORCE_FIELD);
        for (RegistryObject<Block> block : forceFields) {
            final ModelFile post = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(block.getId().m_135815_() + "_post", TwilightForestMod.prefix("block/util/pane/post"))).texture("pane", TwilightForestMod.prefix("block/forcefield_white"))).texture("edge", "#pane");
            final ModelFile side = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(block.getId().m_135815_() + "_side", TwilightForestMod.prefix("block/util/pane/side"))).texture("pane", TwilightForestMod.prefix("block/forcefield_white"))).texture("edge", "#pane");
            final ModelFile noside = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(block.getId().m_135815_() + "_noside", TwilightForestMod.prefix("block/util/pane/noside"))).texture("pane", TwilightForestMod.prefix("block/forcefield_white"));
            final ModelFile sidealt = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(block.getId().m_135815_() + "_side_alt", TwilightForestMod.prefix("block/util/pane/side_alt"))).texture("pane", TwilightForestMod.prefix("block/forcefield_white"))).texture("edge", "#pane");
            final ModelFile nosidealt = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(block.getId().m_135815_() + "_noside_alt", TwilightForestMod.prefix("block/util/pane/noside_alt"))).texture("pane", TwilightForestMod.prefix("block/forcefield_white"));
            ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)block.get()).part().modelFile(post).uvLock(true).addModel()).end().part().modelFile(side).uvLock(true).addModel()).condition((Property)PipeBlock.f_55148_, (Comparable[])new Boolean[] { true }).end().part().modelFile(noside).uvLock(true).addModel()).condition((Property)PipeBlock.f_55148_, (Comparable[])new Boolean[] { false }).end().part().modelFile(side).uvLock(true).rotationY(90).addModel()).condition((Property)PipeBlock.f_55149_, (Comparable[])new Boolean[] { true }).end().part().modelFile(nosidealt).uvLock(true).addModel()).condition((Property)PipeBlock.f_55149_, (Comparable[])new Boolean[] { false }).end().part().modelFile(sidealt).uvLock(true).addModel()).condition((Property)PipeBlock.f_55150_, (Comparable[])new Boolean[] { true }).end().part().modelFile(nosidealt).uvLock(true).rotationY(90).addModel()).condition((Property)PipeBlock.f_55150_, (Comparable[])new Boolean[] { false }).end().part().modelFile(sidealt).uvLock(true).rotationY(90).addModel()).condition((Property)PipeBlock.f_55151_, (Comparable[])new Boolean[] { true }).end().part().modelFile(noside).uvLock(true).rotationY(270).addModel()).condition((Property)PipeBlock.f_55151_, (Comparable[])new Boolean[] { false }).end();
        }
    }
    
    private void registerNagastone() {
        final String baseName = TFBlocks.NAGASTONE.getId().m_135815_();
        final ModelFile solid = (ModelFile)this.models().cubeBottomTop(baseName, TwilightForestMod.prefix("block/nagastone_long_side"), TwilightForestMod.prefix("block/nagastone_bottom_long"), TwilightForestMod.prefix("block/nagastone_turn_top"));
        final ModelFile down = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/naga_segment/down"));
        final ModelFile up = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/naga_segment/up"));
        final ModelFile horizontal = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/naga_segment/horizontal"));
        final ModelFile vertical = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/naga_segment/vertical"));
        this.getVariantBuilder((Block)TFBlocks.NAGASTONE.get()).forAllStates(s -> {
            switch ((NagastoneVariant)s.m_61143_((Property)NagastoneBlock.VARIANT)) {
                case NORTH_DOWN: {
                    ConfiguredModel.builder().modelFile(down).rotationY(270).build();
                    break;
                }
                case SOUTH_DOWN: {
                    ConfiguredModel.builder().modelFile(down).rotationY(90).build();
                    break;
                }
                case WEST_DOWN: {
                    ConfiguredModel.builder().modelFile(down).rotationY(180).build();
                    break;
                }
                case EAST_DOWN: {
                    ConfiguredModel.builder().modelFile(down).build();
                    break;
                }
                case NORTH_UP: {
                    ConfiguredModel.builder().modelFile(up).rotationY(270).build();
                    break;
                }
                case SOUTH_UP: {
                    ConfiguredModel.builder().modelFile(up).rotationY(90).build();
                    break;
                }
                case EAST_UP: {
                    ConfiguredModel.builder().modelFile(up).build();
                    break;
                }
                case WEST_UP: {
                    ConfiguredModel.builder().modelFile(up).rotationY(180).build();
                    break;
                }
                case AXIS_X: {
                    ConfiguredModel.builder().modelFile(horizontal).build();
                    break;
                }
                case AXIS_Y: {
                    ConfiguredModel.builder().modelFile(vertical).build();
                    break;
                }
                case AXIS_Z: {
                    ConfiguredModel.builder().modelFile(horizontal).rotationY(90).build();
                    break;
                }
                case SOLID: {
                    ConfiguredModel.builder().modelFile(solid).build();
                    break;
                }
                default: {
                    throw new IncompatibleClassChangeError();
                }
            }
            return;
        });
        this.horizontalBlock((Block)TFBlocks.NAGASTONE_HEAD.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/" + TFBlocks.NAGASTONE_HEAD.getId().m_135815_())));
        this.nagastonePillar((Block)TFBlocks.NAGASTONE_PILLAR.get(), "");
        this.nagastonePillar((Block)TFBlocks.MOSSY_NAGASTONE_PILLAR.get(), "_mossy");
        this.nagastonePillar((Block)TFBlocks.CRACKED_NAGASTONE_PILLAR.get(), "_weathered");
        this.etchedNagastone((Block)TFBlocks.ETCHED_NAGASTONE.get(), "");
        this.etchedNagastone((Block)TFBlocks.MOSSY_ETCHED_NAGASTONE.get(), "_mossy");
        this.etchedNagastone((Block)TFBlocks.CRACKED_ETCHED_NAGASTONE.get(), "_weathered");
        this.stairsBlock((StairBlock)TFBlocks.NAGASTONE_STAIRS_LEFT.get(), TwilightForestMod.prefix("block/etched_nagastone_left"), TwilightForestMod.prefix("block/stone_tiles"), TwilightForestMod.prefix("block/nagastone_bare"));
        this.stairsBlock((StairBlock)TFBlocks.NAGASTONE_STAIRS_RIGHT.get(), TwilightForestMod.prefix("block/etched_nagastone_right"), TwilightForestMod.prefix("block/stone_tiles"), TwilightForestMod.prefix("block/nagastone_bare"));
        this.stairsBlock((StairBlock)TFBlocks.MOSSY_NAGASTONE_STAIRS_LEFT.get(), TwilightForestMod.prefix("block/etched_nagastone_left_mossy"), TwilightForestMod.prefix("block/stone_tiles_mossy"), TwilightForestMod.prefix("block/nagastone_bare_mossy"));
        this.stairsBlock((StairBlock)TFBlocks.MOSSY_NAGASTONE_STAIRS_RIGHT.get(), TwilightForestMod.prefix("block/etched_nagastone_right_mossy"), TwilightForestMod.prefix("block/stone_tiles_mossy"), TwilightForestMod.prefix("block/nagastone_bare_mossy"));
        this.stairsBlock((StairBlock)TFBlocks.CRACKED_NAGASTONE_STAIRS_LEFT.get(), TwilightForestMod.prefix("block/etched_nagastone_left_weathered"), TwilightForestMod.prefix("block/stone_tiles_weathered"), TwilightForestMod.prefix("block/nagastone_bare_weathered"));
        this.stairsBlock((StairBlock)TFBlocks.CRACKED_NAGASTONE_STAIRS_RIGHT.get(), TwilightForestMod.prefix("block/etched_nagastone_right_weathered"), TwilightForestMod.prefix("block/stone_tiles_weathered"), TwilightForestMod.prefix("block/nagastone_bare_weathered"));
    }
    
    private void nagastonePillar(final Block b, final String suffix) {
        final ResourceLocation side = TwilightForestMod.prefix("block/nagastone_pillar_side" + suffix);
        final ResourceLocation end = TwilightForestMod.prefix("block/nagastone_pillar_end" + suffix);
        final ResourceLocation alt = TwilightForestMod.prefix("block/nagastone_pillar_side" + suffix + "_alt");
        final ModelFile model = (ModelFile)this.models().cubeColumn(b.getRegistryName().m_135815_(), side, end);
        final ModelFile reversed = (ModelFile)this.models().cubeColumn(b.getRegistryName().m_135815_() + "_reversed", alt, end);
        this.getVariantBuilder(b).forAllStates(state -> {
            int rotX = 0;
            int rotY = 0;
            switch ((Direction.Axis)state.m_61143_((Property)RotatedPillarBlock.f_55923_)) {
                default: {
                    rotY = (rotX = 270);
                    break;
                }
                case Y: {
                    break;
                }
                case Z: {
                    rotX = 270;
                    break;
                }
            }
            final ModelFile m = state.m_61143_((Property)DirectionalRotatedPillarBlock.REVERSED) ? reversed : model;
            return ConfiguredModel.builder().rotationX(rotX).rotationY(rotY).modelFile(m).build();
        });
    }
    
    private void etchedNagastone(final Block b, final String suffix) {
        final ResourceLocation stoneTiles = TwilightForestMod.prefix("block/stone_tiles" + suffix);
        final ResourceLocation upTex = TwilightForestMod.prefix("block/etched_nagastone_up" + suffix);
        final ResourceLocation downTex = TwilightForestMod.prefix("block/etched_nagastone_down" + suffix);
        final ResourceLocation rightTex = TwilightForestMod.prefix("block/etched_nagastone_right" + suffix);
        final ResourceLocation leftTex = TwilightForestMod.prefix("block/etched_nagastone_left" + suffix);
        final ModelFile down = (ModelFile)this.models().cubeColumn(b.getRegistryName().m_135815_(), downTex, stoneTiles);
        final ModelFile up = (ModelFile)this.models().cubeColumn(b.getRegistryName().m_135815_() + "_up", upTex, stoneTiles);
        final ModelFile north = (ModelFile)((BlockModelBuilder)this.models().cube(b.getRegistryName().m_135815_() + "_north", upTex, upTex, stoneTiles, stoneTiles, rightTex, leftTex)).texture("particle", "#down");
        final ModelFile south = (ModelFile)((BlockModelBuilder)this.models().cube(b.getRegistryName().m_135815_() + "_south", downTex, downTex, stoneTiles, stoneTiles, leftTex, rightTex)).texture("particle", "#down");
        final ModelFile west = (ModelFile)((BlockModelBuilder)this.models().cube(b.getRegistryName().m_135815_() + "_west", leftTex, rightTex, rightTex, leftTex, stoneTiles, stoneTiles)).texture("particle", "#down");
        final ModelFile east = (ModelFile)((BlockModelBuilder)this.models().cube(b.getRegistryName().m_135815_() + "_east", rightTex, leftTex, leftTex, rightTex, stoneTiles, stoneTiles)).texture("particle", "#down");
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.f_52588_, (Comparable)Direction.DOWN).setModels(new ConfiguredModel[] { new ConfiguredModel(down) });
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.f_52588_, (Comparable)Direction.UP).setModels(new ConfiguredModel[] { new ConfiguredModel(up) });
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.f_52588_, (Comparable)Direction.NORTH).setModels(new ConfiguredModel[] { new ConfiguredModel(north) });
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.f_52588_, (Comparable)Direction.SOUTH).setModels(new ConfiguredModel[] { new ConfiguredModel(south) });
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.f_52588_, (Comparable)Direction.WEST).setModels(new ConfiguredModel[] { new ConfiguredModel(west) });
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.f_52588_, (Comparable)Direction.EAST).setModels(new ConfiguredModel[] { new ConfiguredModel(east) });
    }
    
    private void casketStuff() {
        final VariantBlockStateBuilder builder = this.getVariantBuilder((Block)TFBlocks.KEEPSAKE_CASKET.get());
        final BlockModelBuilder empty = (BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(((KeepsakeCasketBlock)TFBlocks.KEEPSAKE_CASKET.get()).getRegistryName().m_135815_())).parent((ModelFile)new ModelFile.UncheckedModelFile("builtin/entity"))).texture("particle", "minecraft:block/netherite_block");
        final BlockModelBuilder obsidian = (BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("casket_obsidian", TwilightForestMod.prefix("block/casket_solid_template"))).texture("top", new ResourceLocation("block/obsidian"))).texture("side", new ResourceLocation("block/obsidian"));
        final BlockModelBuilder stone = (BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("casket_stone", TwilightForestMod.prefix("block/casket_solid_template"))).texture("top", new ResourceLocation("block/stone"))).texture("side", new ResourceLocation("block/stone"));
        final BlockModelBuilder basalt = (BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("casket_basalt", TwilightForestMod.prefix("block/casket_solid_template"))).texture("top", new ResourceLocation("block/basalt_top"))).texture("side", new ResourceLocation("block/basalt_side"));
        builder.partialState().with((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.AIR).setModels(new ConfiguredModel[] { new ConfiguredModel((ModelFile)empty) });
        builder.partialState().with((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.WATER).setModels(new ConfiguredModel[] { new ConfiguredModel((ModelFile)empty) });
        builder.partialState().with((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.LAVA).setModels(new ConfiguredModel[] { new ConfiguredModel((ModelFile)empty) });
        builder.partialState().with((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.OBSIDIAN).setModels(new ConfiguredModel[] { new ConfiguredModel((ModelFile)obsidian) });
        builder.partialState().with((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.STONE).setModels(new ConfiguredModel[] { new ConfiguredModel((ModelFile)stone) });
        builder.partialState().with((Property)BlockLoggingEnum.MULTILOGGED, (Comparable)BlockLoggingEnum.BASALT).setModels(new ConfiguredModel[] { new ConfiguredModel((ModelFile)basalt) });
    }
    
    private void registerSmokersAndJets() {
        this.simpleBlock((Block)TFBlocks.SMOKER.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/jet"))) });
        this.simpleBlock((Block)TFBlocks.FIRE_JET.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/jet"))) });
        final ModelFile smokerOff = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.ENCASED_SMOKER.getId().m_135815_(), TwilightForestMod.prefix("block/util/cube_bottom_top_3_layer"))).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_off"))).texture("side", TwilightForestMod.prefix("block/towerdev_smoker_off"))).texture("bottom", this.blockTexture((Block)TFBlocks.ENCASED_TOWERWOOD.get()))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_smoker_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_smoker_off_1"));
        final ModelFile smokerOn = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.ENCASED_SMOKER.getId().m_135815_() + "_on", TwilightForestMod.prefix("block/util/cube_bottom_top_3_layer"))).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_on"))).texture("side", TwilightForestMod.prefix("block/towerdev_firejet_on"))).texture("bottom", this.blockTexture((Block)TFBlocks.ENCASED_TOWERWOOD.get()))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_on_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_smoker_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_3/towerdev_ghasttraplid_on_2"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_smoker_on_1"));
        this.getVariantBuilder((Block)TFBlocks.ENCASED_SMOKER.get()).partialState().with((Property)EncasedSmokerBlock.ACTIVE, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(smokerOff) });
        this.getVariantBuilder((Block)TFBlocks.ENCASED_SMOKER.get()).partialState().with((Property)EncasedSmokerBlock.ACTIVE, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(smokerOn) });
        final ModelFile encasedJetOff = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.ENCASED_FIRE_JET.getId().m_135815_(), TwilightForestMod.prefix("block/util/cube_bottom_top_3_layer"))).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_off"))).texture("side", TwilightForestMod.prefix("block/towerdev_firejet_off"))).texture("bottom", this.blockTexture((Block)TFBlocks.ENCASED_TOWERWOOD.get()))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_firejet_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_firejet_off_1"));
        final ModelFile encasedJetOn = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.ENCASED_FIRE_JET.getId().m_135815_() + "_on", TwilightForestMod.prefix("block/util/cube_bottom_top_3_layer"))).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_on"))).texture("side", TwilightForestMod.prefix("block/towerdev_firejet_on"))).texture("bottom", this.blockTexture((Block)TFBlocks.ENCASED_TOWERWOOD.get()))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_on_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_firejet_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_3/towerdev_ghasttraplid_on_2"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_firejet_on_1"));
        this.getVariantBuilder((Block)TFBlocks.ENCASED_FIRE_JET.get()).partialState().with((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.IDLE).setModels(new ConfiguredModel[] { new ConfiguredModel(encasedJetOff) });
        this.getVariantBuilder((Block)TFBlocks.ENCASED_FIRE_JET.get()).partialState().with((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.TIMEOUT).setModels(new ConfiguredModel[] { new ConfiguredModel(encasedJetOff) });
        this.getVariantBuilder((Block)TFBlocks.ENCASED_FIRE_JET.get()).partialState().with((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.POPPING).setModels(new ConfiguredModel[] { new ConfiguredModel(encasedJetOn) });
        this.getVariantBuilder((Block)TFBlocks.ENCASED_FIRE_JET.get()).partialState().with((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.FLAME).setModels(new ConfiguredModel[] { new ConfiguredModel(encasedJetOn) });
    }
    
    private void registerPlantBlocks() {
        this.simpleBlock((Block)TFBlocks.MOSS_PATCH.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)new ModelFile.UncheckedModelFile(TwilightForestMod.prefix("block/moss_patch"))) });
        this.simpleBlockExisting((Block)TFBlocks.MAYAPPLE.get());
        this.simpleBlock((Block)TFBlocks.CLOVER_PATCH.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)new ModelFile.UncheckedModelFile(TwilightForestMod.prefix("block/clover_patch"))) });
        this.simpleBlock((Block)TFBlocks.FIDDLEHEAD.get(), (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.FIDDLEHEAD.getId().m_135815_(), "block/tinted_cross")).texture("cross", this.blockTexture((Block)TFBlocks.FIDDLEHEAD.get())));
        this.simpleBlock((Block)TFBlocks.MUSHGLOOM.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.MUSHGLOOM.getId().m_135815_(), TwilightForestMod.prefix("block/util/cross_2_layer"))).texture("cross", this.blockTexture((Block)TFBlocks.MUSHGLOOM.get()))).texture("cross2", TwilightForestMod.prefix("block/" + TFBlocks.MUSHGLOOM.getId().m_135815_() + "_head")));
        final ModelFile berry = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.TORCHBERRY_PLANT.getId().m_135815_(), TwilightForestMod.prefix("block/util/cross_2_layer"))).texture("cross", this.blockTexture((Block)TFBlocks.TORCHBERRY_PLANT.get()))).texture("cross2", TwilightForestMod.prefix("block/" + TFBlocks.TORCHBERRY_PLANT.getId().m_135815_() + "_glow"));
        final ModelFile noBerry = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.TORCHBERRY_PLANT.getId().m_135815_() + "_no_berries", new ResourceLocation("block/cross"))).texture("cross", this.blockTexture((Block)TFBlocks.TORCHBERRY_PLANT.get()));
        this.getVariantBuilder((Block)TFBlocks.TORCHBERRY_PLANT.get()).forAllStates(s -> ConfiguredModel.builder().modelFile(((boolean)s.m_61143_((Property)TorchberryPlantBlock.HAS_BERRIES)) ? berry : noBerry).build());
        this.simpleBlockExisting((Block)TFBlocks.ROOT_STRAND.get());
        this.simpleBlockExisting((Block)TFBlocks.FALLEN_LEAVES.get());
    }
    
    private void registerWoodBlocks() {
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.TWILIGHT_OAK_LOG.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_TWILIGHT_OAK_LOG.get(), (RotatedPillarBlock)TFBlocks.TWILIGHT_OAK_WOOD.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_TWILIGHT_OAK_WOOD.get(), (Block)TFBlocks.TWILIGHT_OAK_SAPLING.get());
        this.plankBlocks("twilight_oak", (Block)TFBlocks.TWILIGHT_OAK_PLANKS.get(), (Block)TFBlocks.TWILIGHT_OAK_SLAB.get(), (StairBlock)TFBlocks.TWILIGHT_OAK_STAIRS.get(), (Block)TFBlocks.TWILIGHT_OAK_BUTTON.get(), (Block)TFBlocks.TWILIGHT_OAK_FENCE.get(), (Block)TFBlocks.TWILIGHT_OAK_GATE.get(), (Block)TFBlocks.TWILIGHT_OAK_PLATE.get(), (DoorBlock)TFBlocks.TWILIGHT_OAK_DOOR.get(), (TrapDoorBlock)TFBlocks.TWILIGHT_OAK_TRAPDOOR.get(), (BanisterBlock)TFBlocks.TWILIGHT_OAK_BANISTER.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.TWILIGHT_OAK_LEAVES.get(), "block/leaves", m -> m.texture("all", "minecraft:block/oak_leaves"));
        final ResourceLocation rainboakSaplTex = TwilightForestMod.prefix("block/" + TFBlocks.RAINBOW_OAK_SAPLING.getId().m_135815_());
        this.simpleBlock((Block)TFBlocks.RAINBOW_OAK_SAPLING.get(), (ModelFile)this.models().cross(TFBlocks.RAINBOW_OAK_SAPLING.getId().m_135815_(), rainboakSaplTex));
        this.singleBlockBoilerPlate((Block)TFBlocks.RAINBOW_OAK_LEAVES.get(), "block/leaves", m -> m.texture("all", "minecraft:block/oak_leaves"));
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.CANOPY_LOG.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_CANOPY_LOG.get(), (RotatedPillarBlock)TFBlocks.CANOPY_WOOD.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_CANOPY_WOOD.get(), (Block)TFBlocks.CANOPY_SAPLING.get());
        this.plankBlocks("canopy", (Block)TFBlocks.CANOPY_PLANKS.get(), (Block)TFBlocks.CANOPY_SLAB.get(), (StairBlock)TFBlocks.CANOPY_STAIRS.get(), (Block)TFBlocks.CANOPY_BUTTON.get(), (Block)TFBlocks.CANOPY_FENCE.get(), (Block)TFBlocks.CANOPY_GATE.get(), (Block)TFBlocks.CANOPY_PLATE.get(), (DoorBlock)TFBlocks.CANOPY_DOOR.get(), (TrapDoorBlock)TFBlocks.CANOPY_TRAPDOOR.get(), (BanisterBlock)TFBlocks.CANOPY_BANISTER.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.CANOPY_LEAVES.get(), "block/leaves", m -> m.texture("all", "minecraft:block/spruce_leaves"));
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.MANGROVE_LOG.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_MANGROVE_LOG.get(), (RotatedPillarBlock)TFBlocks.MANGROVE_WOOD.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_MANGROVE_WOOD.get(), (Block)TFBlocks.MANGROVE_SAPLING.get());
        this.plankBlocks("mangrove", (Block)TFBlocks.MANGROVE_PLANKS.get(), (Block)TFBlocks.MANGROVE_SLAB.get(), (StairBlock)TFBlocks.MANGROVE_STAIRS.get(), (Block)TFBlocks.MANGROVE_BUTTON.get(), (Block)TFBlocks.MANGROVE_FENCE.get(), (Block)TFBlocks.MANGROVE_GATE.get(), (Block)TFBlocks.MANGROVE_PLATE.get(), (DoorBlock)TFBlocks.MANGROVE_DOOR.get(), (TrapDoorBlock)TFBlocks.MANGROVE_TRAPDOOR.get(), (BanisterBlock)TFBlocks.MANGROVE_BANISTER.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.MANGROVE_LEAVES.get(), "block/leaves", m -> m.texture("all", "minecraft:block/birch_leaves"));
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.DARK_LOG.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_DARK_LOG.get(), (RotatedPillarBlock)TFBlocks.DARK_WOOD.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_DARK_WOOD.get(), (Block)TFBlocks.DARKWOOD_SAPLING.get());
        this.plankBlocks("darkwood", (Block)TFBlocks.DARK_PLANKS.get(), (Block)TFBlocks.DARK_SLAB.get(), (StairBlock)TFBlocks.DARK_STAIRS.get(), (Block)TFBlocks.DARK_BUTTON.get(), (Block)TFBlocks.DARK_FENCE.get(), (Block)TFBlocks.DARK_GATE.get(), (Block)TFBlocks.DARK_PLATE.get(), (DoorBlock)TFBlocks.DARK_DOOR.get(), (TrapDoorBlock)TFBlocks.DARK_TRAPDOOR.get(), (BanisterBlock)TFBlocks.DARKWOOD_BANISTER.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.DARK_LEAVES.get(), "block/leaves", m -> m.texture("all", "block/darkwood_leaves"));
        this.singleBlockBoilerPlate((Block)TFBlocks.HARDENED_DARK_LEAVES.get(), "block/leaves", m -> m.texture("all", "block/darkwood_leaves"));
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.TIME_LOG.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_TIME_LOG.get(), (RotatedPillarBlock)TFBlocks.TIME_WOOD.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_TIME_WOOD.get(), (Block)TFBlocks.TIME_SAPLING.get());
        this.plankBlocks("time", (Block)TFBlocks.TIME_PLANKS.get(), (Block)TFBlocks.TIME_SLAB.get(), (StairBlock)TFBlocks.TIME_STAIRS.get(), (Block)TFBlocks.TIME_BUTTON.get(), (Block)TFBlocks.TIME_FENCE.get(), (Block)TFBlocks.TIME_GATE.get(), (Block)TFBlocks.TIME_PLATE.get(), (DoorBlock)TFBlocks.TIME_DOOR.get(), (TrapDoorBlock)TFBlocks.TIME_TRAPDOOR.get(), (BanisterBlock)TFBlocks.TIME_BANISTER.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.TIME_LEAVES.get(), "block/leaves", m -> m.texture("all", "block/time_leaves"));
        this.magicLogCore((Block)TFBlocks.TIME_LOG_CORE.get());
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.TRANSFORMATION_LOG.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_TRANSFORMATION_LOG.get(), (RotatedPillarBlock)TFBlocks.TRANSFORMATION_WOOD.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_TRANSFORMATION_WOOD.get(), (Block)TFBlocks.TRANSFORMATION_SAPLING.get());
        this.plankBlocks("trans", (Block)TFBlocks.TRANSFORMATION_PLANKS.get(), (Block)TFBlocks.TRANSFORMATION_SLAB.get(), (StairBlock)TFBlocks.TRANSFORMATION_STAIRS.get(), (Block)TFBlocks.TRANSFORMATION_BUTTON.get(), (Block)TFBlocks.TRANSFORMATION_FENCE.get(), (Block)TFBlocks.TRANSFORMATION_GATE.get(), (Block)TFBlocks.TRANSFORMATION_PLATE.get(), (DoorBlock)TFBlocks.TRANSFORMATION_DOOR.get(), (TrapDoorBlock)TFBlocks.TRANSFORMATION_TRAPDOOR.get(), (BanisterBlock)TFBlocks.TRANSFORMATION_BANISTER.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.TRANSFORMATION_LEAVES.get(), "block/leaves", m -> m.texture("all", "block/transformation_leaves"));
        this.magicLogCore((Block)TFBlocks.TRANSFORMATION_LOG_CORE.get());
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.MINING_LOG.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_MINING_LOG.get(), (RotatedPillarBlock)TFBlocks.MINING_WOOD.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_MINING_WOOD.get(), (Block)TFBlocks.MINING_SAPLING.get());
        this.plankBlocks("mine", (Block)TFBlocks.MINING_PLANKS.get(), (Block)TFBlocks.MINING_SLAB.get(), (StairBlock)TFBlocks.MINING_STAIRS.get(), (Block)TFBlocks.MINING_BUTTON.get(), (Block)TFBlocks.MINING_FENCE.get(), (Block)TFBlocks.MINING_GATE.get(), (Block)TFBlocks.MINING_PLATE.get(), (DoorBlock)TFBlocks.MINING_DOOR.get(), (TrapDoorBlock)TFBlocks.MINING_TRAPDOOR.get(), (BanisterBlock)TFBlocks.MINING_BANISTER.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.MINING_LEAVES.get(), "block/leaves", m -> m.texture("all", "block/mining_leaves"));
        this.magicLogCore((Block)TFBlocks.MINING_LOG_CORE.get());
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.SORTING_LOG.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_SORTING_LOG.get(), (RotatedPillarBlock)TFBlocks.SORTING_WOOD.get(), (RotatedPillarBlock)TFBlocks.STRIPPED_SORTING_WOOD.get(), (Block)TFBlocks.SORTING_SAPLING.get());
        this.plankBlocks("sort", (Block)TFBlocks.SORTING_PLANKS.get(), (Block)TFBlocks.SORTING_SLAB.get(), (StairBlock)TFBlocks.SORTING_STAIRS.get(), (Block)TFBlocks.SORTING_BUTTON.get(), (Block)TFBlocks.SORTING_FENCE.get(), (Block)TFBlocks.SORTING_GATE.get(), (Block)TFBlocks.SORTING_PLATE.get(), (DoorBlock)TFBlocks.SORTING_DOOR.get(), (TrapDoorBlock)TFBlocks.SORTING_TRAPDOOR.get(), (BanisterBlock)TFBlocks.SORTING_BANISTER.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.SORTING_LEAVES.get(), "block/leaves", m -> m.texture("all", "block/sorting_leaves"));
        this.magicLogCore((Block)TFBlocks.SORTING_LOG_CORE.get());
        this.banisterVanilla((BanisterBlock)TFBlocks.OAK_BANISTER.get(), "oak_planks");
        this.banisterVanilla((BanisterBlock)TFBlocks.SPRUCE_BANISTER.get(), "spruce_planks");
        this.banisterVanilla((BanisterBlock)TFBlocks.BIRCH_BANISTER.get(), "birch_planks");
        this.banisterVanilla((BanisterBlock)TFBlocks.JUNGLE_BANISTER.get(), "jungle_planks");
        this.banisterVanilla((BanisterBlock)TFBlocks.ACACIA_BANISTER.get(), "acacia_planks");
        this.banisterVanilla((BanisterBlock)TFBlocks.DARK_OAK_BANISTER.get(), "dark_oak_planks");
        this.banisterVanilla((BanisterBlock)TFBlocks.CRIMSON_BANISTER.get(), "crimson_planks");
        this.banisterVanilla((BanisterBlock)TFBlocks.WARPED_BANISTER.get(), "warped_planks");
        final ResourceLocation MOSS = TwilightForestMod.prefix("block/mosspatch");
        final ResourceLocation MOSS_OVERHANG = TwilightForestMod.prefix("block/moss_overhang");
        final ResourceLocation TALL_GRASS = new ResourceLocation("block/grass");
        final ResourceLocation SNOW = new ResourceLocation("block/snow");
        final ResourceLocation SNOW_OVERHANG = TwilightForestMod.prefix("block/snow_overhang");
        final ModelFile EMPTY_LOG = (ModelFile)this.buildHorizontalHollowLog(false, false);
        final ModelFile LAYERED_LOG = (ModelFile)this.buildHorizontalHollowLog(true, false);
        final ModelFile MOSS_LOG_GRASS = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder("hollow_log_moss_grass")).parent((ModelFile)this.buildHorizontalHollowLog(true, true))).texture("carpet", MOSS)).texture("overhang", MOSS_OVERHANG)).texture("plant", TALL_GRASS);
        final ModelFile MOSS_LOG = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder("hollow_log_moss")).parent(LAYERED_LOG)).texture("carpet", MOSS)).texture("overhang", MOSS_OVERHANG);
        final ModelFile SNOW_LOG = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder("hollow_log_snow")).parent(LAYERED_LOG)).texture("carpet", SNOW)).texture("overhang", SNOW_OVERHANG);
        final ModelFile HOLLOW_LOG = (ModelFile)this.buildVerticalLog(null);
        final ModelFile VINE_LOG = (ModelFile)this.buildVerticalLog(HollowLogVariants.Climbable.VINE);
        final ModelFile LADDER_LOG = (ModelFile)this.buildVerticalLog(HollowLogVariants.Climbable.LADDER);
        this.hollowLogs(Blocks.f_49999_, Blocks.f_50010_, TFBlocks.HOLLOW_OAK_LOG_HORIZONTAL, TFBlocks.HOLLOW_OAK_LOG_VERTICAL, TFBlocks.HOLLOW_OAK_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(Blocks.f_50000_, Blocks.f_50005_, TFBlocks.HOLLOW_SPRUCE_LOG_HORIZONTAL, TFBlocks.HOLLOW_SPRUCE_LOG_VERTICAL, TFBlocks.HOLLOW_SPRUCE_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(Blocks.f_50001_, Blocks.f_50006_, TFBlocks.HOLLOW_BIRCH_LOG_HORIZONTAL, TFBlocks.HOLLOW_BIRCH_LOG_VERTICAL, TFBlocks.HOLLOW_BIRCH_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(Blocks.f_50002_, Blocks.f_50007_, TFBlocks.HOLLOW_JUNGLE_LOG_HORIZONTAL, TFBlocks.HOLLOW_JUNGLE_LOG_VERTICAL, TFBlocks.HOLLOW_JUNGLE_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(Blocks.f_50003_, Blocks.f_50008_, TFBlocks.HOLLOW_ACACIA_LOG_HORIZONTAL, TFBlocks.HOLLOW_ACACIA_LOG_VERTICAL, TFBlocks.HOLLOW_ACACIA_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(Blocks.f_50004_, Blocks.f_50009_, TFBlocks.HOLLOW_DARK_OAK_LOG_HORIZONTAL, TFBlocks.HOLLOW_DARK_OAK_LOG_VERTICAL, TFBlocks.HOLLOW_DARK_OAK_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(Blocks.f_50695_, Blocks.f_50696_, TFBlocks.HOLLOW_CRIMSON_STEM_HORIZONTAL, TFBlocks.HOLLOW_CRIMSON_STEM_VERTICAL, TFBlocks.HOLLOW_CRIMSON_STEM_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(Blocks.f_50686_, Blocks.f_50687_, TFBlocks.HOLLOW_WARPED_STEM_HORIZONTAL, TFBlocks.HOLLOW_WARPED_STEM_VERTICAL, TFBlocks.HOLLOW_WARPED_STEM_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(TFBlocks.TWILIGHT_OAK_LOG, TFBlocks.STRIPPED_TWILIGHT_OAK_LOG, TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_HORIZONTAL, TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_VERTICAL, TFBlocks.HOLLOW_TWILIGHT_OAK_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(TFBlocks.CANOPY_LOG, TFBlocks.STRIPPED_CANOPY_LOG, TFBlocks.HOLLOW_CANOPY_LOG_HORIZONTAL, TFBlocks.HOLLOW_CANOPY_LOG_VERTICAL, TFBlocks.HOLLOW_CANOPY_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(TFBlocks.MANGROVE_LOG, TFBlocks.STRIPPED_MANGROVE_LOG, TFBlocks.HOLLOW_MANGROVE_LOG_HORIZONTAL, TFBlocks.HOLLOW_MANGROVE_LOG_VERTICAL, TFBlocks.HOLLOW_MANGROVE_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(TFBlocks.DARK_LOG, TFBlocks.STRIPPED_DARK_LOG, TFBlocks.HOLLOW_DARK_LOG_HORIZONTAL, TFBlocks.HOLLOW_DARK_LOG_VERTICAL, TFBlocks.HOLLOW_DARK_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(TFBlocks.TIME_LOG, TFBlocks.STRIPPED_TIME_LOG, TFBlocks.HOLLOW_TIME_LOG_HORIZONTAL, TFBlocks.HOLLOW_TIME_LOG_VERTICAL, TFBlocks.HOLLOW_TIME_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(TFBlocks.TRANSFORMATION_LOG, TFBlocks.STRIPPED_TRANSFORMATION_LOG, TFBlocks.HOLLOW_TRANSFORMATION_LOG_HORIZONTAL, TFBlocks.HOLLOW_TRANSFORMATION_LOG_VERTICAL, TFBlocks.HOLLOW_TRANSFORMATION_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(TFBlocks.MINING_LOG, TFBlocks.STRIPPED_MINING_LOG, TFBlocks.HOLLOW_MINING_LOG_HORIZONTAL, TFBlocks.HOLLOW_MINING_LOG_VERTICAL, TFBlocks.HOLLOW_MINING_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
        this.hollowLogs(TFBlocks.SORTING_LOG, TFBlocks.STRIPPED_SORTING_LOG, TFBlocks.HOLLOW_SORTING_LOG_HORIZONTAL, TFBlocks.HOLLOW_SORTING_LOG_VERTICAL, TFBlocks.HOLLOW_SORTING_LOG_CLIMBABLE, EMPTY_LOG, MOSS_LOG, MOSS_LOG_GRASS, SNOW_LOG, HOLLOW_LOG, VINE_LOG, LADDER_LOG);
    }
    
    private void magicLogCore(final Block b) {
        final ResourceLocation topTex = TwilightForestMod.prefix("block/" + b.getRegistryName().m_135815_().replace("_core", "_top"));
        final ModelFile off = (ModelFile)this.models().cubeColumn(b.getRegistryName().m_135815_(), this.blockTexture(b), topTex);
        final ModelFile on = (ModelFile)this.models().cubeColumn(b.getRegistryName().m_135815_() + "_on", TwilightForestMod.prefix("block/" + b.getRegistryName().m_135815_() + "_on"), topTex);
        this.getVariantBuilder(b).forAllStates(s -> {
            final ModelFile f = s.m_61143_((Property)SpecialMagicLogBlock.ACTIVE) ? on : off;
            final Direction.Axis axis = (Direction.Axis)s.m_61143_((Property)RotatedPillarBlock.f_55923_);
            final int rotX = (axis == Direction.Axis.X || axis == Direction.Axis.Z) ? 90 : 0;
            final int rotY = (axis == Direction.Axis.X) ? 90 : 0;
            return ConfiguredModel.builder().modelFile(f).rotationX(rotX).rotationY(rotY).build();
        });
    }
    
    private void rotationallyCorrectColumn(final Block b) {
        final ResourceLocation side = TwilightForestMod.prefix("block/" + b.getRegistryName().m_135815_() + "_side");
        final ResourceLocation end = TwilightForestMod.prefix("block/" + b.getRegistryName().m_135815_() + "_end");
        final ConfiguredModel yModel = new ConfiguredModel((ModelFile)this.models().cubeColumn(b.getRegistryName().m_135815_(), side, end));
        final ConfiguredModel xModel = ConfiguredModel.builder().modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(b.getRegistryName().m_135815_() + "_x", TwilightForestMod.prefix("block/util/cube_column_rotationally_correct_x"))).texture("side", side)).texture("end", end)).rotationX(90).rotationY(90).buildLast();
        final ConfiguredModel zModel = ConfiguredModel.builder().modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(b.getRegistryName().m_135815_() + "_z", TwilightForestMod.prefix("block/util/cube_column_rotationally_correct_z"))).texture("side", side)).texture("end", end)).rotationX(90).buildLast();
        this.getVariantBuilder(b).partialState().with((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Y).setModels(new ConfiguredModel[] { yModel }).partialState().with((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.X).setModels(new ConfiguredModel[] { xModel }).partialState().with((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Z).setModels(new ConfiguredModel[] { zModel });
    }
    
    private void castleDoor(final Block b) {
        final ModelFile overlay = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/castle_door_overlay"));
        final ModelFile main = (ModelFile)this.models().cubeAll(b.getRegistryName().m_135815_(), TwilightForestMod.prefix("block/castle_door"));
        ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(overlay).addModel()).end().part().modelFile(main).addModel()).condition((Property)CastleDoorBlock.VANISHED, (Comparable[])new Boolean[] { false }).end();
    }
    
    private void allRotations(final Block b, final ModelFile model) {
        ConfiguredModel.Builder<?> builder = (ConfiguredModel.Builder<?>)ConfiguredModel.builder();
        final int[] array;
        final int[] rots = array = new int[] { 0, 90, 180, 270 };
        for (final int x : array) {
            for (final int y : rots) {
                builder = (ConfiguredModel.Builder<?>)builder.modelFile(model).rotationX(x).rotationY(y);
                if (x != rots[rots.length - 1] && y != rots[rots.length - 1]) {
                    builder = (ConfiguredModel.Builder<?>)builder.nextModel();
                }
            }
        }
        this.simpleBlock(b, builder.build());
    }
    
    private void builtinEntity(final Block b, final String particle) {
        this.simpleBlock(b, (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(b.getRegistryName().m_135815_())).parent((ModelFile)new ModelFile.UncheckedModelFile("builtin/entity"))).texture("particle", particle));
    }
    
    private void simpleBlockExisting(final Block b) {
        this.simpleBlock(b, new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(TwilightForestMod.prefix(b.getRegistryName().m_135815_()))) });
    }
    
    private void singleBlockBoilerPlate(final Block b, final String parent, final Consumer<BlockModelBuilder> modelCustomizer) {
        final BlockModelBuilder bModel = (BlockModelBuilder)this.models().withExistingParent(b.getRegistryName().m_135815_(), parent);
        modelCustomizer.accept(bModel);
        this.simpleBlock(b, (ModelFile)bModel);
    }
    
    private BlockModelBuilder cubeAllTinted(final String name, final String all, final boolean flipV) {
        final String parent = flipV ? "block/util/tinted_cube_all_flipped_v" : "block/util/tinted_cube_all";
        return (BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(name, TwilightForestMod.prefix(parent))).texture("all", "block/" + all);
    }
    
    private BlockModelBuilder cubeAllTinted(final String name, final String all) {
        return this.cubeAllTinted(name, all, false);
    }
    
    private void tintedAndFlipped(final Block b) {
        this.simpleBlock(b, ConfiguredModel.builder().modelFile((ModelFile)this.cubeAllTinted(b.getRegistryName().m_135815_(), b.getRegistryName().m_135815_())).nextModel().modelFile((ModelFile)this.cubeAllTinted(b.getRegistryName().m_135815_() + "_flipped", b.getRegistryName().m_135815_(), true)).build());
    }
    
    private void logWoodSapling(final RotatedPillarBlock log, final RotatedPillarBlock slog, final RotatedPillarBlock wood, final RotatedPillarBlock swood, final Block sapling) {
        this.logBlock(log);
        this.logBlock(slog);
        final ResourceLocation sideTex = this.blockTexture((Block)log);
        this.axisBlock(wood, sideTex, sideTex);
        final ResourceLocation sSideTex = this.blockTexture((Block)slog);
        this.axisBlock(swood, sSideTex, sSideTex);
        final ResourceLocation saplingTex = TwilightForestMod.prefix("block/" + sapling.getRegistryName().m_135815_());
        this.simpleBlock(sapling, (ModelFile)this.models().cross(sapling.getRegistryName().m_135815_(), saplingTex));
    }
    
    private void plankBlocks(final String variant, final Block plank, final Block slab, final StairBlock stair, final Block button, final Block fence, final Block gate, final Block plate, final DoorBlock door, final TrapDoorBlock trapdoor, final BanisterBlock banister) {
        final String plankTexName = "planks_" + variant;
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + plankTexName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + plankTexName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + plankTexName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + plankTexName + "_3");
        final ConfiguredModel[] plankModels = ConfiguredModel.builder().weight(10).modelFile((ModelFile)this.models().cubeAll(plank.getRegistryName().m_135815_(), tex0)).nextModel().weight(10).modelFile((ModelFile)this.models().cubeAll(plank.getRegistryName().m_135815_() + "_1", tex2)).nextModel().weight(1).modelFile((ModelFile)this.models().cubeAll(plank.getRegistryName().m_135815_() + "_2", tex3)).nextModel().weight(1).modelFile((ModelFile)this.models().cubeAll(plank.getRegistryName().m_135815_() + "_3", tex4)).build();
        this.simpleBlock(plank, plankModels);
        final ConfiguredModel[] bottomSlabModels = ConfiguredModel.builder().weight(10).modelFile((ModelFile)this.models().slab(slab.getRegistryName().m_135815_(), tex0, tex0, tex0)).nextModel().weight(10).modelFile((ModelFile)this.models().slab(slab.getRegistryName().m_135815_() + "_1", tex2, tex2, tex2)).nextModel().weight(1).modelFile((ModelFile)this.models().slab(slab.getRegistryName().m_135815_() + "_2", tex3, tex3, tex3)).nextModel().weight(1).modelFile((ModelFile)this.models().slab(slab.getRegistryName().m_135815_() + "_3", tex4, tex4, tex4)).build();
        final ConfiguredModel[] topSlabModels = ConfiguredModel.builder().weight(10).uvLock(true).rotationX(180).modelFile(bottomSlabModels[0].model).nextModel().weight(10).uvLock(true).rotationX(180).modelFile(bottomSlabModels[1].model).nextModel().weight(1).uvLock(true).rotationX(180).modelFile(bottomSlabModels[2].model).nextModel().weight(1).uvLock(true).rotationX(180).modelFile(bottomSlabModels[3].model).build();
        this.getVariantBuilder(slab).partialState().with((Property)SlabBlock.f_56353_, (Comparable)SlabType.BOTTOM).setModels(bottomSlabModels);
        this.getVariantBuilder(slab).partialState().with((Property)SlabBlock.f_56353_, (Comparable)SlabType.TOP).setModels(topSlabModels);
        this.getVariantBuilder(slab).partialState().with((Property)SlabBlock.f_56353_, (Comparable)SlabType.DOUBLE).setModels(plankModels);
        this.woodStairs(stair, plankTexName);
        this.woodButton(button, plankTexName);
        this.woodFence(fence, plankTexName);
        this.woodGate(gate, plankTexName);
        this.woodPlate(plate, plankTexName);
        this.doorBlock(door, TwilightForestMod.prefix("block/wood/door/" + variant + "_lower"), TwilightForestMod.prefix("block/wood/door/" + variant + "_upper"));
        this.trapdoorBlock(trapdoor, TwilightForestMod.prefix("block/wood/trapdoor/" + variant + "_trapdoor"), true);
        this.banister(banister, plankTexName);
    }
    
    private void woodGate(final Block gate, final String texName) {
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + texName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + texName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + texName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + texName + "_3");
        final ModelFile gate2 = (ModelFile)this.models().fenceGate(gate.getRegistryName().m_135815_(), tex0);
        final ModelFile gate3 = (ModelFile)this.models().fenceGate(gate.getRegistryName().m_135815_() + "_1", tex2);
        final ModelFile gate4 = (ModelFile)this.models().fenceGate(gate.getRegistryName().m_135815_() + "_2", tex3);
        final ModelFile gate5 = (ModelFile)this.models().fenceGate(gate.getRegistryName().m_135815_() + "_3", tex4);
        final ModelFile open0 = (ModelFile)this.models().fenceGateOpen(gate.getRegistryName().m_135815_() + "_open", tex0);
        final ModelFile open2 = (ModelFile)this.models().fenceGateOpen(gate.getRegistryName().m_135815_() + "_open_1", tex2);
        final ModelFile open3 = (ModelFile)this.models().fenceGateOpen(gate.getRegistryName().m_135815_() + "_open_2", tex3);
        final ModelFile open4 = (ModelFile)this.models().fenceGateOpen(gate.getRegistryName().m_135815_() + "_open_3", tex4);
        final ModelFile wall0 = (ModelFile)this.models().fenceGateWall(gate.getRegistryName().m_135815_() + "_wall", tex0);
        final ModelFile wall2 = (ModelFile)this.models().fenceGateWall(gate.getRegistryName().m_135815_() + "_wall_1", tex2);
        final ModelFile wall3 = (ModelFile)this.models().fenceGateWall(gate.getRegistryName().m_135815_() + "_wall_2", tex3);
        final ModelFile wall4 = (ModelFile)this.models().fenceGateWall(gate.getRegistryName().m_135815_() + "_wall_3", tex4);
        final ModelFile wallOpen0 = (ModelFile)this.models().fenceGateWallOpen(gate.getRegistryName().m_135815_() + "_wall_open", tex0);
        final ModelFile wallOpen2 = (ModelFile)this.models().fenceGateWallOpen(gate.getRegistryName().m_135815_() + "_wall_open_1", tex2);
        final ModelFile wallOpen3 = (ModelFile)this.models().fenceGateWallOpen(gate.getRegistryName().m_135815_() + "_wall_open_2", tex3);
        final ModelFile wallOpen4 = (ModelFile)this.models().fenceGateWallOpen(gate.getRegistryName().m_135815_() + "_wall_open_3", tex4);
        this.getVariantBuilder(gate).forAllStatesExcept(state -> {
            ModelFile model0 = gate0;
            ModelFile model2 = gate1;
            ModelFile model3 = gate2;
            ModelFile model4 = gate3;
            if (state.m_61143_((Property)FenceGateBlock.f_53343_)) {
                model0 = wall0;
                model2 = wall1;
                model3 = wall2;
                model4 = wall3;
            }
            if (state.m_61143_((Property)FenceGateBlock.f_53341_)) {
                model0 = ((model0 == wall0) ? wallOpen0 : open0);
                model2 = ((model2 == wall1) ? wallOpen1 : open1);
                model3 = ((model3 == wall2) ? wallOpen2 : open2);
                model4 = ((model4 == wall3) ? wallOpen3 : open3);
            }
            return ConfiguredModel.builder().weight(10).modelFile(model0).rotationY((int)((Direction)state.m_61143_((Property)HorizontalDirectionalBlock.f_54117_)).m_122435_()).uvLock(true).nextModel().weight(10).modelFile(model2).rotationY((int)((Direction)state.m_61143_((Property)HorizontalDirectionalBlock.f_54117_)).m_122435_()).uvLock(true).nextModel().weight(1).modelFile(model3).rotationY((int)((Direction)state.m_61143_((Property)HorizontalDirectionalBlock.f_54117_)).m_122435_()).uvLock(true).nextModel().weight(1).modelFile(model4).rotationY((int)((Direction)state.m_61143_((Property)HorizontalDirectionalBlock.f_54117_)).m_122435_()).uvLock(true).build();
        }, new Property[] { (Property)FenceGateBlock.f_53342_ });
    }
    
    private void woodFence(final Block fence, final String texName) {
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + texName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + texName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + texName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + texName + "_3");
        final ModelFile post0 = (ModelFile)this.models().fencePost(fence.getRegistryName().m_135815_() + "_post", tex0);
        final ModelFile post2 = (ModelFile)this.models().fencePost(fence.getRegistryName().m_135815_() + "_post_1", tex2);
        final ModelFile post3 = (ModelFile)this.models().fencePost(fence.getRegistryName().m_135815_() + "_post_2", tex3);
        final ModelFile post4 = (ModelFile)this.models().fencePost(fence.getRegistryName().m_135815_() + "_post_3", tex4);
        final ModelFile side0 = (ModelFile)this.models().fenceSide(fence.getRegistryName().m_135815_() + "_side", tex0);
        final ModelFile side2 = (ModelFile)this.models().fenceSide(fence.getRegistryName().m_135815_() + "_side_1", tex2);
        final ModelFile side3 = (ModelFile)this.models().fenceSide(fence.getRegistryName().m_135815_() + "_side_2", tex3);
        final ModelFile side4 = (ModelFile)this.models().fenceSide(fence.getRegistryName().m_135815_() + "_side_3", tex4);
        final MultiPartBlockStateBuilder builder = ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(fence).part().weight(10).modelFile(post0).nextModel().weight(10).modelFile(post2).nextModel().weight(1).modelFile(post3).nextModel().weight(1).modelFile(post4).addModel()).end();
        PipeBlock.f_55154_.forEach((dir, value) -> {
            if (dir.m_122434_().m_122479_()) {
                ((MultiPartBlockStateBuilder.PartBuilder)builder.part().weight(10).modelFile(side0).rotationY(((int)dir.m_122435_() + 180) % 360).uvLock(true).nextModel().weight(10).modelFile(side1).rotationY(((int)dir.m_122435_() + 180) % 360).uvLock(true).nextModel().weight(1).modelFile(side2).rotationY(((int)dir.m_122435_() + 180) % 360).uvLock(true).nextModel().weight(1).modelFile(side3).rotationY(((int)dir.m_122435_() + 180) % 360).uvLock(true).addModel()).condition((Property)value, (Comparable[])new Boolean[] { true });
            }
        });
    }
    
    private void woodPlate(final Block plate, final String texName) {
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + texName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + texName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + texName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + texName + "_3");
        final ConfiguredModel[] unpressed = ConfiguredModel.builder().weight(10).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().m_135815_(), "pressure_plate_up")).texture("texture", tex0)).nextModel().weight(10).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().m_135815_() + "_1", "pressure_plate_up")).texture("texture", tex2)).nextModel().weight(1).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().m_135815_() + "_2", "pressure_plate_up")).texture("texture", tex3)).nextModel().weight(1).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().m_135815_() + "_3", "pressure_plate_up")).texture("texture", tex4)).build();
        final ConfiguredModel[] pressed = ConfiguredModel.builder().weight(10).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().m_135815_() + "_down", "pressure_plate_down")).texture("texture", tex0)).nextModel().weight(10).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().m_135815_() + "_down_1", "pressure_plate_down")).texture("texture", tex2)).nextModel().weight(1).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().m_135815_() + "_down_2", "pressure_plate_down")).texture("texture", tex3)).nextModel().weight(1).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().m_135815_() + "_down_3", "pressure_plate_down")).texture("texture", tex4)).build();
        this.getVariantBuilder(plate).partialState().with((Property)PressurePlateBlock.f_55249_, (Comparable)false).setModels(unpressed);
        this.getVariantBuilder(plate).partialState().with((Property)PressurePlateBlock.f_55249_, (Comparable)true).setModels(pressed);
    }
    
    private void woodButton(final Block button, final String texName) {
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + texName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + texName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + texName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + texName + "_3");
        final ModelFile unpressed0 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().m_135815_(), "button")).texture("texture", tex0);
        final ModelFile pressed0 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().m_135815_() + "_pressed", "button_pressed")).texture("texture", tex0);
        final ModelFile unpressed2 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().m_135815_() + "_1", "button")).texture("texture", tex2);
        final ModelFile pressed2 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().m_135815_() + "_pressed_1", "button_pressed")).texture("texture", tex2);
        final ModelFile unpressed3 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().m_135815_() + "_2", "button")).texture("texture", tex3);
        final ModelFile pressed3 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().m_135815_() + "_pressed_2", "button_pressed")).texture("texture", tex3);
        final ModelFile unpressed4 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().m_135815_() + "_3", "button")).texture("texture", tex4);
        final ModelFile pressed4 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().m_135815_() + "_pressed_3", "button_pressed")).texture("texture", tex4);
        this.getVariantBuilder(button).forAllStates(state -> {
            final ModelFile model0 = state.m_61143_((Property)ButtonBlock.f_51045_) ? pressed0 : unpressed0;
            final ModelFile model2 = state.m_61143_((Property)ButtonBlock.f_51045_) ? pressed1 : unpressed1;
            final ModelFile model3 = state.m_61143_((Property)ButtonBlock.f_51045_) ? pressed2 : unpressed2;
            final ModelFile model4 = state.m_61143_((Property)ButtonBlock.f_51045_) ? pressed3 : unpressed3;
            switch ((AttachFace)state.m_61143_((Property)FaceAttachedHorizontalDirectionalBlock.f_53179_)) {
                case WALL: {
                    break;
                }
                case FLOOR: {
                    break;
                }
                case CEILING: {
                    break;
                }
                default: {
                    throw new IncompatibleClassChangeError();
                }
            }
            final int n;
            final int rotX = n;
            int rotY = 0;
            if (state.m_61143_((Property)FaceAttachedHorizontalDirectionalBlock.f_53179_) == AttachFace.CEILING) {
                switch ((Direction)state.m_61143_((Property)HorizontalDirectionalBlock.f_54117_)) {
                    case NORTH: {
                        rotY = 180;
                        break;
                    }
                    case SOUTH: {
                        rotY = 0;
                        break;
                    }
                    case WEST: {
                        rotY = 90;
                        break;
                    }
                    case EAST: {
                        rotY = 270;
                        break;
                    }
                }
            }
            else {
                switch ((Direction)state.m_61143_((Property)HorizontalDirectionalBlock.f_54117_)) {
                    case NORTH: {
                        rotY = 0;
                        break;
                    }
                    case SOUTH: {
                        rotY = 180;
                        break;
                    }
                    case WEST: {
                        rotY = 270;
                        break;
                    }
                    case EAST: {
                        rotY = 90;
                        break;
                    }
                }
            }
            final boolean uvlock = state.m_61143_((Property)FaceAttachedHorizontalDirectionalBlock.f_53179_) == AttachFace.WALL;
            return ConfiguredModel.builder().weight(10).uvLock(uvlock).rotationX(rotX).rotationY(rotY).modelFile(model0).nextModel().weight(10).uvLock(uvlock).rotationX(rotX).rotationY(rotY).modelFile(model2).nextModel().weight(1).uvLock(uvlock).rotationX(rotX).rotationY(rotY).modelFile(model3).nextModel().weight(1).uvLock(uvlock).rotationX(rotX).rotationY(rotY).modelFile(model4).build();
        });
    }
    
    private void woodStairs(final StairBlock block, final String texName) {
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + texName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + texName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + texName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + texName + "_3");
        final ModelFile main0 = (ModelFile)this.models().stairs(block.getRegistryName().m_135815_(), tex0, tex0, tex0);
        final ModelFile main2 = (ModelFile)this.models().stairs(block.getRegistryName().m_135815_() + "_1", tex2, tex2, tex2);
        final ModelFile main3 = (ModelFile)this.models().stairs(block.getRegistryName().m_135815_() + "_2", tex3, tex3, tex3);
        final ModelFile main4 = (ModelFile)this.models().stairs(block.getRegistryName().m_135815_() + "_3", tex4, tex4, tex4);
        final ModelFile inner0 = (ModelFile)this.models().stairsInner(block.getRegistryName().m_135815_() + "_inner", tex0, tex0, tex0);
        final ModelFile inner2 = (ModelFile)this.models().stairsInner(block.getRegistryName().m_135815_() + "_inner_1", tex2, tex2, tex2);
        final ModelFile inner3 = (ModelFile)this.models().stairsInner(block.getRegistryName().m_135815_() + "_inner_2", tex3, tex3, tex3);
        final ModelFile inner4 = (ModelFile)this.models().stairsInner(block.getRegistryName().m_135815_() + "_inner_3", tex4, tex4, tex4);
        final ModelFile outer0 = (ModelFile)this.models().stairsOuter(block.getRegistryName().m_135815_() + "_outer", tex0, tex0, tex0);
        final ModelFile outer2 = (ModelFile)this.models().stairsOuter(block.getRegistryName().m_135815_() + "_outer_1", tex2, tex2, tex2);
        final ModelFile outer3 = (ModelFile)this.models().stairsOuter(block.getRegistryName().m_135815_() + "_outer_2", tex3, tex3, tex3);
        final ModelFile outer4 = (ModelFile)this.models().stairsOuter(block.getRegistryName().m_135815_() + "_outer_3", tex4, tex4, tex4);
        this.getVariantBuilder((Block)block).forAllStatesExcept(state -> {
            final Direction facing = (Direction)state.m_61143_((Property)StairBlock.f_56841_);
            final Half half = (Half)state.m_61143_((Property)StairBlock.f_56842_);
            final StairsShape shape = (StairsShape)state.m_61143_((Property)StairBlock.f_56843_);
            int yRot = (int)facing.m_122427_().m_122435_();
            if (shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT) {
                yRot += 270;
            }
            if (shape != StairsShape.STRAIGHT && half == Half.TOP) {
                yRot += 90;
            }
            final int yRot2 = yRot % 360;
            final boolean uvlock = yRot2 != 0 || half == Half.TOP;
            return ConfiguredModel.builder().weight(10).modelFile((shape == StairsShape.STRAIGHT) ? main0 : ((shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT) ? inner0 : outer0)).rotationX((half == Half.BOTTOM) ? 0 : 180).rotationY(yRot2).uvLock(uvlock).nextModel().weight(10).modelFile((shape == StairsShape.STRAIGHT) ? main1 : ((shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT) ? inner1 : outer1)).rotationX((half == Half.BOTTOM) ? 0 : 180).rotationY(yRot2).uvLock(uvlock).nextModel().weight(1).modelFile((shape == StairsShape.STRAIGHT) ? main2 : ((shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT) ? inner2 : outer2)).rotationX((half == Half.BOTTOM) ? 0 : 180).rotationY(yRot2).uvLock(uvlock).nextModel().weight(1).modelFile((shape == StairsShape.STRAIGHT) ? main3 : ((shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT) ? inner3 : outer3)).rotationX((half == Half.BOTTOM) ? 0 : 180).rotationY(yRot2).uvLock(uvlock).build();
        }, new Property[] { (Property)StairBlock.f_56844_ });
    }
    
    private void banister(final BanisterBlock banister, final String texName) {
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + texName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + texName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + texName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + texName + "_3");
        this.getVariantBuilder((Block)banister).forAllStatesExcept(state -> {
            final Direction facing = (Direction)state.m_61143_((Property)BanisterBlock.f_54117_);
            final int yRot = (int)facing.m_122435_();
            final String extended = state.m_61143_((Property)BanisterBlock.EXTENDED) ? "_extended" : "";
            final String variant = ((BanisterShape)state.m_61143_((Property)BanisterBlock.SHAPE)).m_7912_() + extended;
            final String newModelName = banister.getRegistryName().m_135815_() + "_" + variant;
            final ConfiguredModel[] tall = ConfiguredModel.builder().weight(10).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(newModelName, TwilightForestMod.prefix("banister_" + variant))).texture("texture", tex0)).rotationY(yRot).nextModel().weight(10).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(newModelName + "_1", TwilightForestMod.prefix("banister_" + variant))).texture("texture", tex1)).rotationY(yRot).nextModel().weight(1).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(newModelName + "_2", TwilightForestMod.prefix("banister_" + variant))).texture("texture", tex2)).rotationY(yRot).nextModel().weight(1).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(newModelName + "_3", TwilightForestMod.prefix("banister_" + variant))).texture("texture", tex3)).rotationY(yRot).build();
            return tall;
        }, new Property[] { (Property)BanisterBlock.WATERLOGGED });
    }
    
    private void banisterVanilla(final BanisterBlock banister, final String texName) {
        final ResourceLocation tex0 = new ResourceLocation("block/" + texName);
        this.getVariantBuilder((Block)banister).forAllStatesExcept(state -> {
            final Direction facing = (Direction)state.m_61143_((Property)BanisterBlock.f_54117_);
            final int yRot = (int)facing.m_122435_();
            final String extended = state.m_61143_((Property)BanisterBlock.EXTENDED) ? "_extended" : "";
            final String variant = ((BanisterShape)state.m_61143_((Property)BanisterBlock.SHAPE)).m_7912_() + extended;
            final ConfiguredModel[] tall = ConfiguredModel.builder().modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(banister.getRegistryName().m_135815_() + "_" + variant, TwilightForestMod.prefix("banister_" + variant))).texture("texture", tex0)).rotationY(yRot).build();
            return tall;
        }, new Property[] { (Property)BanisterBlock.WATERLOGGED });
    }
    
    private void stonePillar() {
        final ModelFile main_x = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("pillar_main_x", TwilightForestMod.prefix("block/pillar/pillar_12_ctm"))).texture("side_x", TwilightForestMod.prefix("block/stone_twist/twist_x"))).texture("side_z", TwilightForestMod.prefix("block/stone_twist/twist_x"));
        final ModelFile bottom_x = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("pillar_bottom_x", TwilightForestMod.prefix("block/pillar/pillar_bottom"))).texture("bottom_x", TwilightForestMod.prefix("block/stone_twist/cap/y_y_bottom"))).texture("bottom_z", TwilightForestMod.prefix("block/stone_twist/cap/y_y_bottom"))).texture("bottom_cap", TwilightForestMod.prefix("block/stone_twist/cap/end_bottom_x"));
        final ModelFile top_x = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("pillar_top_x", TwilightForestMod.prefix("block/pillar/pillar_top"))).texture("top_x", TwilightForestMod.prefix("block/stone_twist/cap/y_y_top"))).texture("top_z", TwilightForestMod.prefix("block/stone_twist/cap/y_y_top"))).texture("top_cap", TwilightForestMod.prefix("block/stone_twist/cap/end_top_x"));
        final ModelFile main_y = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("pillar_main_y", TwilightForestMod.prefix("block/pillar/pillar_12_ctm"))).texture("side_x", TwilightForestMod.prefix("block/stone_twist/twist_y"))).texture("side_z", TwilightForestMod.prefix("block/stone_twist/twist_y"));
        final ModelFile bottom_y = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("pillar_bottom_y", TwilightForestMod.prefix("block/pillar/pillar_bottom"))).texture("bottom_x", TwilightForestMod.prefix("block/stone_twist/cap/y_y_bottom"))).texture("bottom_z", TwilightForestMod.prefix("block/stone_twist/cap/y_y_bottom"))).texture("bottom_cap", TwilightForestMod.prefix("block/stone_twist/cap/end_bottom_y"));
        final ModelFile top_y = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("pillar_top_y", TwilightForestMod.prefix("block/pillar/pillar_top"))).texture("top_x", TwilightForestMod.prefix("block/stone_twist/cap/y_y_top"))).texture("top_z", TwilightForestMod.prefix("block/stone_twist/cap/y_y_top"))).texture("top_cap", TwilightForestMod.prefix("block/stone_twist/cap/end_top_y"));
        final ModelFile main_z = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("pillar_main_z", TwilightForestMod.prefix("block/pillar/pillar_12_ctm"))).texture("side_x", TwilightForestMod.prefix("block/stone_twist/twist_x"))).texture("side_z", TwilightForestMod.prefix("block/stone_twist/twist_y"));
        final ModelFile bottom_z = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("pillar_bottom_z", TwilightForestMod.prefix("block/pillar/pillar_bottom"))).texture("bottom_x", TwilightForestMod.prefix("block/stone_twist/cap/y_y_bottom"))).texture("bottom_z", TwilightForestMod.prefix("block/stone_twist/cap/y_y_bottom"))).texture("bottom_cap", TwilightForestMod.prefix("block/stone_twist/cap/end_bottom_z"));
        final ModelFile top_z = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("pillar_top_z", TwilightForestMod.prefix("block/pillar/pillar_top"))).texture("top_x", TwilightForestMod.prefix("block/stone_twist/cap/y_y_top"))).texture("top_z", TwilightForestMod.prefix("block/stone_twist/cap/y_y_top"))).texture("top_cap", TwilightForestMod.prefix("block/stone_twist/cap/end_top_z"));
        ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)TFBlocks.TWISTED_STONE_PILLAR.get()).part().modelFile(main_x).uvLock(true).rotationX(90).rotationY(90).addModel()).condition((Property)WallPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).end().part().modelFile(top_x).rotationX(90).rotationY(90).addModel()).condition((Property)WallPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).condition((Property)PipeBlock.f_55149_, (Comparable[])new Boolean[] { false }).end().part().modelFile(bottom_x).rotationX(90).rotationY(90).addModel()).condition((Property)WallPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).condition((Property)PipeBlock.f_55151_, (Comparable[])new Boolean[] { false }).end().part().modelFile(main_y).uvLock(true).addModel()).condition((Property)WallPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).end().part().modelFile(top_y).addModel()).condition((Property)WallPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).condition((Property)PipeBlock.f_55152_, (Comparable[])new Boolean[] { false }).end().part().modelFile(bottom_y).addModel()).condition((Property)WallPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).condition((Property)PipeBlock.f_55153_, (Comparable[])new Boolean[] { false }).end().part().modelFile(main_z).uvLock(true).rotationX(90).addModel()).condition((Property)WallPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).end().part().modelFile(top_z).rotationX(90).addModel()).condition((Property)WallPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).condition((Property)PipeBlock.f_55148_, (Comparable[])new Boolean[] { false }).end().part().modelFile(bottom_z).rotationX(90).addModel()).condition((Property)WallPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).condition((Property)PipeBlock.f_55150_, (Comparable[])new Boolean[] { false }).end();
    }
    
    private void slider() {
        final ModelFile slider = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/slider"));
        final ModelFile horizSlider = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/slider_horiz"));
        this.getVariantBuilder((Block)TFBlocks.SLIDER.get()).forAllStates(state -> {
            switch ((Direction.Axis)state.m_61143_((Property)SliderBlock.f_55923_)) {
                case X: {
                    ConfiguredModel.builder().modelFile(horizSlider).rotationX(90).rotationY(90).build();
                    break;
                }
                case Z: {
                    ConfiguredModel.builder().modelFile(horizSlider).rotationX(90).build();
                    break;
                }
                default: {
                    ConfiguredModel.builder().modelFile(slider).build();
                    break;
                }
            }
            return;
        });
    }
    
    private void towerBlocks() {
        final ResourceLocation cube3 = TwilightForestMod.prefix("block/util/cube_all_3_layer");
        final ResourceLocation cubeBt3 = TwilightForestMod.prefix("block/util/cube_bottom_top_3_layer");
        final ResourceLocation cube2NoShade = TwilightForestMod.prefix("block/util/cube_all_2_layer_no_shade");
        final ResourceLocation fourCube = TwilightForestMod.prefix("block/util/4_cubed");
        final ModelFile reappear = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.REAPPEARING_BLOCK.getId().m_135815_(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_reappearing_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_reappearing_off_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_reappearing_off_2"));
        final ModelFile reappearActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.REAPPEARING_BLOCK.getId().m_135815_() + "_active", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_reappearing_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_reappearing_on_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_reappearing_on_2"));
        final ModelFile reappearVanished = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.REAPPEARING_BLOCK.getId().m_135815_() + "_vanished", fourCube)).texture("all", TwilightForestMod.prefix("block/towerdev_reappearing_trace_off"));
        final ModelFile reappearVanishedActive = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.REAPPEARING_BLOCK.getId().m_135815_() + "_vanished_active", fourCube)).texture("all", TwilightForestMod.prefix("block/towerdev_reappearing_trace_on"));
        this.getVariantBuilder((Block)TFBlocks.REAPPEARING_BLOCK.get()).forAllStates(s -> {
            ModelFile model;
            if (s.m_61143_((Property)VanishingBlock.VANISHED)) {
                model = (s.m_61143_((Property)VanishingBlock.ACTIVE) ? reappearVanishedActive : reappearVanished);
            }
            else {
                model = (s.m_61143_((Property)VanishingBlock.ACTIVE) ? reappearActive : reappear);
            }
            return ConfiguredModel.builder().modelFile(model).build();
        });
        final ModelFile vanish = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.VANISHING_BLOCK.getId().m_135815_(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_vanish_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_vanish_off_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_vanish_off_2"));
        final ModelFile vanishActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.VANISHING_BLOCK.getId().m_135815_() + "_active", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_vanish_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_vanish_on_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_vanish_on_2"));
        this.getVariantBuilder((Block)TFBlocks.VANISHING_BLOCK.get()).partialState().with((Property)VanishingBlock.ACTIVE, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(vanish) });
        this.getVariantBuilder((Block)TFBlocks.VANISHING_BLOCK.get()).partialState().with((Property)VanishingBlock.ACTIVE, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(vanishActive) });
        final ModelFile vanishLocked = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.LOCKED_VANISHING_BLOCK.getId().m_135815_(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_lock_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_lock_on_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_lock_on_2"));
        final ModelFile vanishUnlocked = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.LOCKED_VANISHING_BLOCK.getId().m_135815_() + "_unlocked", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_lock_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_lock_off_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_lock_off_2"));
        this.getVariantBuilder((Block)TFBlocks.LOCKED_VANISHING_BLOCK.get()).partialState().with((Property)LockedVanishingBlock.LOCKED, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(vanishLocked) });
        this.getVariantBuilder((Block)TFBlocks.LOCKED_VANISHING_BLOCK.get()).partialState().with((Property)LockedVanishingBlock.LOCKED, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(vanishUnlocked) });
        final ModelFile ghastTrap = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.GHAST_TRAP.getId().m_135815_(), cubeBt3)).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_off"))).texture("side", TwilightForestMod.prefix("block/towerdev_ghasttrap_off"))).texture("bottom", TwilightForestMod.prefix("block/encased_towerwood"))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_ghasttrap_off_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttrap_off_2"));
        final ModelFile ghastTrapActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.GHAST_TRAP.getId().m_135815_() + "_active", cubeBt3)).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_on"))).texture("side", TwilightForestMod.prefix("block/towerdev_ghasttrap_on"))).texture("bottom", TwilightForestMod.prefix("block/encased_towerwood"))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_on_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_ghasttrap_on_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_3/towerdev_ghasttraplid_on_2"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttrap_on_2"));
        this.getVariantBuilder((Block)TFBlocks.GHAST_TRAP.get()).partialState().with((Property)GhastTrapBlock.ACTIVE, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(ghastTrap) });
        this.getVariantBuilder((Block)TFBlocks.GHAST_TRAP.get()).partialState().with((Property)GhastTrapBlock.ACTIVE, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(ghastTrapActive) });
        final ModelFile builder = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.CARMINITE_BUILDER.getId().m_135815_(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_builder_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_builder_off_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_builder_off_2"));
        final ModelFile builderActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.CARMINITE_BUILDER.getId().m_135815_() + "_active", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_builder_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_builder_on_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_builder_on_2"));
        final ModelFile builderTimeout = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.CARMINITE_BUILDER.getId().m_135815_() + "_timeout", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_builder_timeout"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_builder_timeout_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_3/towerdev_builder_timeout_2"));
        this.getVariantBuilder((Block)TFBlocks.CARMINITE_BUILDER.get()).partialState().with((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE).setModels(new ConfiguredModel[] { new ConfiguredModel(builder) });
        this.getVariantBuilder((Block)TFBlocks.CARMINITE_BUILDER.get()).partialState().with((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_ACTIVE).setModels(new ConfiguredModel[] { new ConfiguredModel(builderActive) });
        this.getVariantBuilder((Block)TFBlocks.CARMINITE_BUILDER.get()).partialState().with((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_TIMEOUT).setModels(new ConfiguredModel[] { new ConfiguredModel(builderTimeout) });
        final ModelFile built = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.BUILT_BLOCK.getId().m_135815_(), cube2NoShade)).texture("all", TwilightForestMod.prefix("block/towerdev_built_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_builder_off_1"));
        final ModelFile builtActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.BUILT_BLOCK.getId().m_135815_() + "_active", cube2NoShade)).texture("all", TwilightForestMod.prefix("block/towerdev_built_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_builder_on_1"));
        this.getVariantBuilder((Block)TFBlocks.BUILT_BLOCK.get()).partialState().with((Property)TranslucentBuiltBlock.ACTIVE, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(built) });
        this.getVariantBuilder((Block)TFBlocks.BUILT_BLOCK.get()).partialState().with((Property)TranslucentBuiltBlock.ACTIVE, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(builtActive) });
        final ModelFile antibuilder = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.ANTIBUILDER.getId().m_135815_(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_antibuilder"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_antibuilder_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_antibuilder_2"));
        this.simpleBlock((Block)TFBlocks.ANTIBUILDER.get(), antibuilder);
        final ModelFile antibuilt = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.ANTIBUILT_BLOCK.getId().m_135815_(), cube2NoShade)).texture("all", TwilightForestMod.prefix("block/towerdev_antibuilt"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_antibuilt_1"));
        this.simpleBlock((Block)TFBlocks.ANTIBUILT_BLOCK.get(), antibuilt);
        final ModelFile reactor = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.CARMINITE_REACTOR.getId().m_135815_(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_reactor_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_reactor_off_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_reactor_off_2"));
        final ModelFile reactorActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.CARMINITE_REACTOR.getId().m_135815_() + "_active", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_reactor_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_reactor_on_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_reactor_on_2"));
        this.getVariantBuilder((Block)TFBlocks.CARMINITE_REACTOR.get()).partialState().with((Property)CarminiteReactorBlock.ACTIVE, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(reactor) });
        this.getVariantBuilder((Block)TFBlocks.CARMINITE_REACTOR.get()).partialState().with((Property)CarminiteReactorBlock.ACTIVE, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(reactorActive) });
        this.simpleBlock((Block)TFBlocks.REACTOR_DEBRIS.get(), (ModelFile)this.models().cubeAll(TFBlocks.REACTOR_DEBRIS.getId().m_135815_(), new ResourceLocation("block/destroy_stage_9")));
    }
    
    private ModelFile pedestalModel(final String name, final String north, final String south, final String west, final String east, final boolean active) {
        final String suffix = active ? "" : "_latent";
        BlockModelBuilder ret = (BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(name, TwilightForestMod.prefix(active ? "block/util/pedestal_2_layer" : "block/util/pedestal"))).texture("end", TwilightForestMod.prefix("block/pedestal/top"))).texture("north", TwilightForestMod.prefix("block/pedestal/" + north + suffix))).texture("south", TwilightForestMod.prefix("block/pedestal/" + south + suffix))).texture("west", TwilightForestMod.prefix("block/pedestal/" + west + suffix))).texture("east", TwilightForestMod.prefix("block/pedestal/" + east + suffix));
        if (active) {
            ret = (BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)ret.texture("end2", TwilightForestMod.prefix("block/pedestal/top_glow"))).texture("north2", TwilightForestMod.prefix("block/pedestal/" + north + "_glow"))).texture("south2", TwilightForestMod.prefix("block/pedestal/" + south + "_glow"))).texture("west2", TwilightForestMod.prefix("block/pedestal/" + west + "_glow"))).texture("east2", TwilightForestMod.prefix("block/pedestal/" + east + "_glow"));
        }
        return (ModelFile)ret;
    }
    
    private void trophyPedestal() {
        final String baseName = TFBlocks.TROPHY_PEDESTAL.getId().m_135815_();
        final ModelFile latent0 = this.pedestalModel(baseName, "naga", "lich", "hydra", "ur-ghast", false);
        final ModelFile latent2 = this.pedestalModel(baseName + "_1", "snow_queen", "naga", "lich", "hydra", false);
        final ModelFile latent3 = this.pedestalModel(baseName + "_2", "ur-ghast", "snow_queen", "naga", "lich", false);
        final ModelFile latent4 = this.pedestalModel(baseName + "_3", "hydra", "ur-ghast", "snow_queen", "naga", false);
        final ModelFile latent5 = this.pedestalModel(baseName + "_4", "lich", "hydra", "ur-ghast", "snow_queen", false);
        final List<ConfiguredModel> latentModels = new ArrayList<ConfiguredModel>();
        for (final ModelFile f : Arrays.asList(latent0, latent2, latent3, latent4, latent5)) {
            latentModels.add(new ConfiguredModel(f, 0, 0, false));
            latentModels.add(new ConfiguredModel(f, 0, 90, false));
            latentModels.add(new ConfiguredModel(f, 0, 180, false));
            latentModels.add(new ConfiguredModel(f, 0, 270, false));
        }
        this.getVariantBuilder((Block)TFBlocks.TROPHY_PEDESTAL.get()).partialState().with((Property)TrophyPedestalBlock.ACTIVE, (Comparable)false).setModels((ConfiguredModel[])latentModels.toArray(new ConfiguredModel[0]));
        final ModelFile active0 = this.pedestalModel(baseName + "_active", "naga", "lich", "hydra", "ur-ghast", true);
        final ModelFile active2 = this.pedestalModel(baseName + "_active_1", "snow_queen", "naga", "lich", "hydra", true);
        final ModelFile active3 = this.pedestalModel(baseName + "_active_2", "ur-ghast", "snow_queen", "naga", "lich", true);
        final ModelFile active4 = this.pedestalModel(baseName + "_active_3", "hydra", "ur-ghast", "snow_queen", "naga", true);
        final ModelFile active5 = this.pedestalModel(baseName + "_active_4", "lich", "hydra", "ur-ghast", "snow_queen", true);
        final List<ConfiguredModel> activeModels = new ArrayList<ConfiguredModel>();
        for (final ModelFile f2 : Arrays.asList(active0, active2, active3, active4, active5)) {
            activeModels.add(new ConfiguredModel(f2, 0, 0, false));
            activeModels.add(new ConfiguredModel(f2, 0, 90, false));
            activeModels.add(new ConfiguredModel(f2, 0, 180, false));
            activeModels.add(new ConfiguredModel(f2, 0, 270, false));
        }
        this.getVariantBuilder((Block)TFBlocks.TROPHY_PEDESTAL.get()).partialState().with((Property)TrophyPedestalBlock.ACTIVE, (Comparable)true).setModels((ConfiguredModel[])activeModels.toArray(new ConfiguredModel[0]));
    }
    
    private void thorns() {
        final boolean fixer = Direction.SOUTH.m_122434_() == Direction.Axis.Z;
        final ModelFile green = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.GREEN_THORNS.getId().m_135815_(), TwilightForestMod.prefix("block/thorns_main"))).texture("side", TwilightForestMod.prefix("block/green_thorns_side"))).texture("end", TwilightForestMod.prefix("block/green_thorns_top"));
        final ModelFile greenBottom = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.GREEN_THORNS.getId().m_135815_() + "_bottom", TwilightForestMod.prefix("block/thorns_section_bottom"))).texture("side", TwilightForestMod.prefix("block/green_thorns_side"))).texture("end", TwilightForestMod.prefix("block/green_thorns_top"));
        final ModelFile greenTop = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.GREEN_THORNS.getId().m_135815_() + "_top", TwilightForestMod.prefix("block/thorns_section_top"))).texture("side", TwilightForestMod.prefix("block/green_thorns_side"))).texture("end", TwilightForestMod.prefix("block/green_thorns_top"));
        ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)TFBlocks.GREEN_THORNS.get()).part().modelFile(green).addModel()).condition((Property)RotatedPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).end().part().modelFile(green).rotationX(90).addModel()).condition((Property)RotatedPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).end().part().modelFile(green).rotationX(90).rotationY(90).addModel()).condition((Property)RotatedPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).end().part().modelFile(greenTop).rotationX(90).addModel()).condition((Property)PipeBlock.f_55152_, (Comparable[])new Boolean[] { true }).end().part().modelFile(greenBottom).rotationX(90).addModel()).condition((Property)PipeBlock.f_55153_, (Comparable[])new Boolean[] { true }).end().part().modelFile(greenTop).rotationY(270).addModel()).condition((Property)PipeBlock.f_55149_, (Comparable[])new Boolean[] { true }).end().part().modelFile(greenBottom).rotationY(270).addModel()).condition((Property)PipeBlock.f_55151_, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? greenBottom : greenTop).rotationY(fixer ? 180 : 0).addModel()).condition((Property)PipeBlock.f_55150_, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? greenTop : greenBottom).rotationY(fixer ? 180 : 0).addModel()).condition((Property)PipeBlock.f_55148_, (Comparable[])new Boolean[] { true }).end();
        final ModelFile brown = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.BROWN_THORNS.getId().m_135815_(), TwilightForestMod.prefix("block/thorns_main"))).texture("side", TwilightForestMod.prefix("block/brown_thorns_side"))).texture("end", TwilightForestMod.prefix("block/brown_thorns_top"));
        final ModelFile brownBottom = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.BROWN_THORNS.getId().m_135815_() + "_bottom", TwilightForestMod.prefix("block/thorns_section_bottom"))).texture("side", TwilightForestMod.prefix("block/brown_thorns_side"))).texture("end", TwilightForestMod.prefix("block/brown_thorns_top"));
        final ModelFile brownTop = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.BROWN_THORNS.getId().m_135815_() + "_top", TwilightForestMod.prefix("block/thorns_section_top"))).texture("side", TwilightForestMod.prefix("block/brown_thorns_side"))).texture("end", TwilightForestMod.prefix("block/brown_thorns_top"));
        ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)TFBlocks.BROWN_THORNS.get()).part().modelFile(brown).addModel()).condition((Property)RotatedPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).end().part().modelFile(brown).rotationX(90).addModel()).condition((Property)RotatedPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).end().part().modelFile(brown).rotationX(90).rotationY(90).addModel()).condition((Property)RotatedPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).end().part().modelFile(brownTop).rotationX(90).addModel()).condition((Property)PipeBlock.f_55152_, (Comparable[])new Boolean[] { true }).end().part().modelFile(brownBottom).rotationX(90).addModel()).condition((Property)PipeBlock.f_55153_, (Comparable[])new Boolean[] { true }).end().part().modelFile(brownTop).rotationY(270).addModel()).condition((Property)PipeBlock.f_55149_, (Comparable[])new Boolean[] { true }).end().part().modelFile(brownBottom).rotationY(270).addModel()).condition((Property)PipeBlock.f_55151_, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? brownBottom : brownTop).rotationY(fixer ? 180 : 0).addModel()).condition((Property)PipeBlock.f_55150_, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? brownTop : brownBottom).rotationY(fixer ? 180 : 0).addModel()).condition((Property)PipeBlock.f_55148_, (Comparable[])new Boolean[] { true }).end();
        final ModelFile burnt = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.BURNT_THORNS.getId().m_135815_(), TwilightForestMod.prefix("block/thorns_main"))).texture("side", TwilightForestMod.prefix("block/burnt_thorns_side"))).texture("end", TwilightForestMod.prefix("block/burnt_thorns_top"));
        final ModelFile burntBottom = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.BURNT_THORNS.getId().m_135815_() + "_bottom", TwilightForestMod.prefix("block/thorns_section_bottom"))).texture("side", TwilightForestMod.prefix("block/burnt_thorns_side"))).texture("end", TwilightForestMod.prefix("block/burnt_thorns_top"));
        final ModelFile burntTop = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.BURNT_THORNS.getId().m_135815_() + "_top", TwilightForestMod.prefix("block/thorns_section_top"))).texture("side", TwilightForestMod.prefix("block/burnt_thorns_side"))).texture("end", TwilightForestMod.prefix("block/burnt_thorns_top"));
        ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)TFBlocks.BURNT_THORNS.get()).part().modelFile(burnt).addModel()).condition((Property)RotatedPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).end().part().modelFile(burnt).rotationX(90).addModel()).condition((Property)RotatedPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).end().part().modelFile(burnt).rotationX(90).rotationY(90).addModel()).condition((Property)RotatedPillarBlock.f_55923_, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).end().part().modelFile(burntTop).rotationX(90).addModel()).condition((Property)PipeBlock.f_55152_, (Comparable[])new Boolean[] { true }).end().part().modelFile(burntBottom).rotationX(90).addModel()).condition((Property)PipeBlock.f_55153_, (Comparable[])new Boolean[] { true }).end().part().modelFile(burntTop).rotationY(270).addModel()).condition((Property)PipeBlock.f_55149_, (Comparable[])new Boolean[] { true }).end().part().modelFile(burntBottom).rotationY(270).addModel()).condition((Property)PipeBlock.f_55151_, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? burntBottom : burntTop).rotationY(fixer ? 180 : 0).addModel()).condition((Property)PipeBlock.f_55150_, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? burntTop : burntBottom).rotationY(fixer ? 180 : 0).addModel()).condition((Property)PipeBlock.f_55148_, (Comparable[])new Boolean[] { true }).end();
    }
    
    private void auroraBlocks() {
        final int variants = 16;
        final ModelFile[] models = new ModelFile[variants];
        for (int i = 0; i < variants; ++i) {
            models[i] = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.AURORA_BLOCK.getId().m_135815_() + "_" + i, TwilightForestMod.prefix("block/util/tinted_cube_all"))).texture("all", TwilightForestMod.prefix("block/" + TFBlocks.AURORA_BLOCK.getId().m_135815_() + "_" + i));
        }
        for (int i = 0; i < variants; ++i) {
            this.getVariantBuilder((Block)TFBlocks.AURORA_BLOCK.get()).partialState().with((Property)AuroraBrickBlock.VARIANT, (Comparable)i).setModels(ConfiguredModel.builder().weight(3).modelFile(models[i]).nextModel().weight(1).modelFile(models[(i + 1) % variants]).build());
        }
        final ModelFile pillarModel = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.AURORA_PILLAR.getId().m_135815_(), TwilightForestMod.prefix("block/util/tinted_cube_column"))).texture("end", TwilightForestMod.prefix("block/" + TFBlocks.AURORA_PILLAR.getId().m_135815_() + "_top"))).texture("side", this.blockTexture((Block)TFBlocks.AURORA_PILLAR.get()));
        this.axisBlock((RotatedPillarBlock)TFBlocks.AURORA_PILLAR.get(), pillarModel, pillarModel);
        final ModelFile slabModel = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.AURORA_SLAB.getId().m_135815_(), TwilightForestMod.prefix("block/util/tinted_slab"))).texture("bottom", TwilightForestMod.prefix("block/" + TFBlocks.AURORA_PILLAR.getId().m_135815_() + "_top"))).texture("top", TwilightForestMod.prefix("block/" + TFBlocks.AURORA_PILLAR.getId().m_135815_() + "_top"))).texture("side", TwilightForestMod.prefix("block/" + TFBlocks.AURORA_SLAB.getId().m_135815_() + "_side"));
        final ModelFile doubleSlabModel = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.AURORA_SLAB.getId().m_135815_() + "_double", TwilightForestMod.prefix("block/util/tinted_cube_column"))).texture("end", TwilightForestMod.prefix("block/" + TFBlocks.AURORA_PILLAR.getId().m_135815_() + "_top"))).texture("side", TwilightForestMod.prefix("block/" + TFBlocks.AURORA_SLAB.getId().m_135815_() + "_side"));
        this.getVariantBuilder((Block)TFBlocks.AURORA_SLAB.get()).partialState().with((Property)SlabBlock.f_56353_, (Comparable)SlabType.BOTTOM).setModels(new ConfiguredModel[] { new ConfiguredModel(slabModel) });
        this.getVariantBuilder((Block)TFBlocks.AURORA_SLAB.get()).partialState().with((Property)SlabBlock.f_56353_, (Comparable)SlabType.TOP).setModels(ConfiguredModel.builder().uvLock(true).rotationX(180).modelFile(slabModel).build());
        this.getVariantBuilder((Block)TFBlocks.AURORA_SLAB.get()).partialState().with((Property)SlabBlock.f_56353_, (Comparable)SlabType.DOUBLE).setModels(new ConfiguredModel[] { new ConfiguredModel(doubleSlabModel) });
        final ModelFile auroraGlass = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.AURORALIZED_GLASS.getId().m_135815_(), TwilightForestMod.prefix("block/util/tinted_cube_all"))).texture("all", this.blockTexture((Block)TFBlocks.AURORALIZED_GLASS.get()));
        this.simpleBlock((Block)TFBlocks.AURORALIZED_GLASS.get(), auroraGlass);
    }
    
    private void mazestone() {
        final ResourceLocation plainTex = this.blockTexture((Block)TFBlocks.MAZESTONE.get());
        final ModelFile mazeStone = (ModelFile)this.models().cubeAll(TFBlocks.MAZESTONE.getId().m_135815_(), plainTex);
        this.simpleBlock((Block)TFBlocks.MAZESTONE.get(), ConfiguredModel.builder().rotationX(90).rotationY(90).modelFile(mazeStone).nextModel().rotationX(270).rotationY(270).modelFile(mazeStone).build());
        this.simpleBlock((Block)TFBlocks.MAZESTONE_BRICK.get());
        final ModelFile chiseled = (ModelFile)this.models().cubeColumn(TFBlocks.CUT_MAZESTONE.getId().m_135815_(), this.blockTexture((Block)TFBlocks.CUT_MAZESTONE.get()), plainTex);
        this.simpleBlock((Block)TFBlocks.CUT_MAZESTONE.get(), chiseled);
        final ModelFile decorative = (ModelFile)this.models().cubeColumn(TFBlocks.DECORATIVE_MAZESTONE.getId().m_135815_(), this.blockTexture((Block)TFBlocks.DECORATIVE_MAZESTONE.get()), plainTex);
        this.simpleBlock((Block)TFBlocks.DECORATIVE_MAZESTONE.get(), decorative);
        this.simpleBlock((Block)TFBlocks.CRACKED_MAZESTONE.get());
        this.simpleBlock((Block)TFBlocks.MOSSY_MAZESTONE.get());
        final ResourceLocation brickTex = this.blockTexture((Block)TFBlocks.MAZESTONE_BRICK.get());
        final ModelFile mosaic = (ModelFile)this.models().cubeColumn(TFBlocks.MAZESTONE_MOSAIC.getId().m_135815_(), brickTex, this.blockTexture((Block)TFBlocks.MAZESTONE_MOSAIC.get()));
        this.simpleBlock((Block)TFBlocks.MAZESTONE_MOSAIC.get(), mosaic);
        final ModelFile border = (ModelFile)this.models().cubeColumn(TFBlocks.MAZESTONE_BORDER.getId().m_135815_(), brickTex, this.blockTexture((Block)TFBlocks.MAZESTONE_BORDER.get()));
        this.simpleBlock((Block)TFBlocks.MAZESTONE_BORDER.get(), border);
    }
    
    private void lilyPad(final Block b) {
        final String baseName = b.getRegistryName().m_135815_();
        final ResourceLocation parent = TwilightForestMod.prefix("block/huge_lily_pad");
        final ModelFile[] models = new ModelFile[4];
        for (int i = 0; i < models.length; ++i) {
            models[i] = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(baseName + "_" + i, parent)).texture("texture", TwilightForestMod.prefix("block/huge_lily_pad_" + i))).texture("particle", "#texture");
        }
        final Map<HugeLilypadPiece, ModelFile> north = (Map<HugeLilypadPiece, ModelFile>)ImmutableMap.of((Object)HugeLilypadPiece.NW, (Object)models[1], (Object)HugeLilypadPiece.NE, (Object)models[0], (Object)HugeLilypadPiece.SE, (Object)models[3], (Object)HugeLilypadPiece.SW, (Object)models[2]);
        final Map<HugeLilypadPiece, ModelFile> south = (Map<HugeLilypadPiece, ModelFile>)ImmutableMap.of((Object)HugeLilypadPiece.NW, (Object)models[3], (Object)HugeLilypadPiece.NE, (Object)models[2], (Object)HugeLilypadPiece.SE, (Object)models[1], (Object)HugeLilypadPiece.SW, (Object)models[0]);
        final Map<HugeLilypadPiece, ModelFile> west = (Map<HugeLilypadPiece, ModelFile>)ImmutableMap.of((Object)HugeLilypadPiece.NW, (Object)models[0], (Object)HugeLilypadPiece.NE, (Object)models[3], (Object)HugeLilypadPiece.SE, (Object)models[2], (Object)HugeLilypadPiece.SW, (Object)models[1]);
        final Map<HugeLilypadPiece, ModelFile> east = (Map<HugeLilypadPiece, ModelFile>)ImmutableMap.of((Object)HugeLilypadPiece.NW, (Object)models[2], (Object)HugeLilypadPiece.NE, (Object)models[1], (Object)HugeLilypadPiece.SE, (Object)models[0], (Object)HugeLilypadPiece.SW, (Object)models[3]);
        this.getVariantBuilder(b).forAllStates(state -> {
            int rotY = 0;
            Map<HugeLilypadPiece, ModelFile> m = null;
            switch ((Direction)state.m_61143_((Property)HugeLilyPadBlock.FACING)) {
                case SOUTH: {
                    rotY = 180;
                    m = south;
                    break;
                }
                case WEST: {
                    rotY = 270;
                    m = west;
                    break;
                }
                case EAST: {
                    rotY = 90;
                    m = east;
                    break;
                }
                default: {
                    rotY = 0;
                    m = north;
                    break;
                }
            }
            final ModelFile model = m.get(state.m_61143_((Property)HugeLilyPadBlock.PIECE));
            return ConfiguredModel.builder().rotationY(rotY).modelFile(model).build();
        });
    }
    
    private void candelabra() {
        final ModelFile candelabra = this.buildCandelabra(4, 5, 4);
        final ModelFile candelabraWall = this.buildWallCandelabra(4, 5, 4);
        final List<ModelFile> candelabras = new ArrayList<ModelFile>();
        final List<ModelFile> wallCandelabras = new ArrayList<ModelFile>();
        final int minHeight = 4;
        final int maxHeight = 5;
        for (int right = 4; right <= 5; ++right) {
            for (int center = 4; center <= 5; ++center) {
                for (int left = 4; left <= 5; ++left) {
                    candelabras.add(this.buildCandelabra(left, center, right));
                    wallCandelabras.add(this.buildWallCandelabra(left, center, right));
                }
            }
        }
        this.getVariantBuilder((Block)TFBlocks.CANDELABRA.get()).forAllStates(state -> {
            final Direction direction = (Direction)state.m_61143_((Property)CandelabraBlock.FACING);
            final boolean onWall = (boolean)state.m_61143_((Property)CandelabraBlock.ON_WALL);
            final boolean lit = state.m_61143_((Property)CandelabraBlock.LIGHTING) != AbstractLightableBlock.Lighting.NONE;
            ConfiguredModel.Builder<?> stateBuilder = (ConfiguredModel.Builder<?>)ConfiguredModel.builder();
            final Iterator<ModelFile> models = onWall ? wallCandelabras.iterator() : candelabras.iterator();
            while (models.hasNext()) {
                final ModelFile model = models.next();
                stateBuilder.modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(model.getLocation().toString() + "_plain" + (lit ? "_lit" : ""))).parent(model)).texture("candle", lit ? "minecraft:block/candle_lit" : "minecraft:block/candle")).rotationY((int)direction.m_122435_());
                if (models.hasNext()) {
                    stateBuilder = (ConfiguredModel.Builder<?>)stateBuilder.nextModel();
                }
            }
            return stateBuilder.build();
        });
    }
    
    private ModelFile buildCandelabra(final int leftHeight, final int centerHeight, final int rightHeight) {
        return (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("candelabra_" + leftHeight + "_" + centerHeight + "_" + rightHeight, "minecraft:block/block")).texture("particle", "#candelabra")).texture("candelabra", "block/candelabra")).element().from(0.0f, 1.0f, 8.0f).to(16.0f, 7.0f, 8.0f).face(Direction.NORTH).uvs(0.0f, 0.0f, 16.0f, 6.0f).texture("#candelabra").end().face(Direction.SOUTH).uvs(16.0f, 0.0f, 0.0f, 6.0f).texture("#candelabra").end().end()).element().from(8.0f, 1.0f, 5.0f).to(8.0f, 7.0f, 11.0f).face(Direction.EAST).uvs(0.0f, 6.0f, 6.0f, 12.0f).texture("#candelabra").end().face(Direction.WEST).uvs(6.0f, 6.0f, 0.0f, 12.0f).texture("#candelabra").end().end()).element().from(1.0f, 7.0f, 6.0f).to(5.0f, 8.0f, 10.0f).allFaces((direction, builder) -> builder.uvs(0.0f, 12.0f, 4.0f, direction.m_122434_().m_122479_() ? 13.0f : 16.0f).texture("#candelabra")).end()).element().from(6.0f, 7.0f, 6.0f).to(10.0f, 8.0f, 10.0f).allFaces((direction, builder) -> builder.uvs(0.0f, 12.0f, 4.0f, direction.m_122434_().m_122479_() ? 13.0f : 16.0f).texture("#candelabra")).end()).element().from(11.0f, 7.0f, 6.0f).to(15.0f, 8.0f, 10.0f).allFaces((direction, builder) -> builder.uvs(0.0f, 12.0f, 4.0f, direction.m_122434_().m_122479_() ? 13.0f : 16.0f).texture("#candelabra")).end()).element().from(6.0f, 0.0f, 6.0f).to(10.0f, 1.0f, 10.0f).allFaces((direction, builder) -> builder.uvs(0.0f, 12.0f, 4.0f, direction.m_122434_().m_122479_() ? 13.0f : 16.0f).texture("#candelabra")).end()).element().from(2.0f, 8.0f, 7.0f).to(4.0f, (float)(8 + leftHeight), 9.0f).face(Direction.NORTH).end().face(Direction.SOUTH).end().face(Direction.WEST).end().face(Direction.EAST).end().faces((direction, builder) -> builder.uvs(0.0f, 8.0f, 2.0f, (float)(8 + leftHeight)).texture("#candle")).face(Direction.UP).uvs(0.0f, 6.0f, 2.0f, 8.0f).texture("#candle").end().end()).element().from(7.0f, 8.0f, 7.0f).to(9.0f, (float)(8 + centerHeight), 9.0f).face(Direction.NORTH).end().face(Direction.SOUTH).end().face(Direction.WEST).end().face(Direction.EAST).end().faces((direction, builder) -> builder.uvs(0.0f, 8.0f, 2.0f, (float)(8 + centerHeight)).texture("#candle")).face(Direction.UP).uvs(0.0f, 6.0f, 2.0f, 8.0f).texture("#candle").end().end()).element().from(12.0f, 8.0f, 7.0f).to(14.0f, (float)(8 + rightHeight), 9.0f).face(Direction.NORTH).end().face(Direction.SOUTH).end().face(Direction.WEST).end().face(Direction.EAST).end().faces((direction, builder) -> builder.uvs(0.0f, 8.0f, 2.0f, (float)(8 + rightHeight)).texture("#candle")).face(Direction.UP).uvs(0.0f, 6.0f, 2.0f, 8.0f).texture("#candle").end().end()).element().from(2.5f, (float)(8 + leftHeight), 8.0f).to(3.5f, (float)(9 + leftHeight), 8.0f).rotation().angle(45.0f).axis(Direction.Axis.Y).origin(3.0f, (float)(8 + leftHeight), 8.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end()).element().from(2.5f, (float)(8 + leftHeight), 8.0f).to(3.5f, (float)(9 + leftHeight), 8.0f).rotation().angle(-45.0f).axis(Direction.Axis.Y).origin(3.0f, (float)(8 + leftHeight), 8.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end()).element().from(7.5f, (float)(8 + centerHeight), 8.0f).to(8.5f, (float)(9 + centerHeight), 8.0f).rotation().angle(45.0f).axis(Direction.Axis.Y).origin(8.0f, (float)(8 + centerHeight), 8.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end()).element().from(7.5f, (float)(8 + centerHeight), 8.0f).to(8.5f, (float)(9 + centerHeight), 8.0f).rotation().angle(-45.0f).axis(Direction.Axis.Y).origin(8.0f, (float)(8 + centerHeight), 8.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end()).element().from(12.5f, (float)(8 + rightHeight), 8.0f).to(13.5f, (float)(9 + rightHeight), 8.0f).rotation().angle(45.0f).axis(Direction.Axis.Y).origin(13.0f, (float)(8 + rightHeight), 8.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end()).element().from(12.5f, (float)(8 + rightHeight), 8.0f).to(13.5f, (float)(9 + rightHeight), 8.0f).rotation().angle(-45.0f).axis(Direction.Axis.Y).origin(13.0f, (float)(8 + rightHeight), 8.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end();
    }
    
    private ModelFile buildWallCandelabra(final int leftHeight, final int centerHeight, final int rightHeight) {
        return (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("candelabra_wall_" + leftHeight + "_" + centerHeight + "_" + rightHeight, "minecraft:block/block")).texture("particle", "#candelabra")).texture("candelabra", "block/candelabra")).element().from(0.0f, 1.0f, 12.0f).to(16.0f, 7.0f, 12.0f).face(Direction.NORTH).uvs(0.0f, 0.0f, 16.0f, 6.0f).texture("#candelabra").end().face(Direction.SOUTH).uvs(16.0f, 0.0f, 0.0f, 6.0f).texture("#candelabra").end().end()).element().from(8.0f, 1.0f, 9.0f).to(8.0f, 7.0f, 15.0f).face(Direction.EAST).uvs(0.0f, 6.0f, 6.0f, 12.0f).texture("#candelabra").end().face(Direction.WEST).uvs(6.0f, 6.0f, 0.0f, 12.0f).texture("#candelabra").end().end()).element().from(1.0f, 7.0f, 10.0f).to(5.0f, 8.0f, 14.0f).allFaces((direction, builder) -> builder.uvs(0.0f, 12.0f, 4.0f, direction.m_122434_().m_122479_() ? 13.0f : 16.0f).texture("#candelabra")).end()).element().from(6.0f, 7.0f, 10.0f).to(10.0f, 8.0f, 14.0f).allFaces((direction, builder) -> builder.uvs(0.0f, 12.0f, 4.0f, direction.m_122434_().m_122479_() ? 13.0f : 16.0f).texture("#candelabra")).end()).element().from(11.0f, 7.0f, 10.0f).to(15.0f, 8.0f, 14.0f).allFaces((direction, builder) -> builder.uvs(0.0f, 12.0f, 4.0f, direction.m_122434_().m_122479_() ? 13.0f : 16.0f).texture("#candelabra")).end()).element().from(6.0f, 2.0f, 15.0f).to(10.0f, 6.0f, 16.0f).allFaces((direction, builder) -> builder.uvs((direction.m_122434_() == Direction.Axis.X) ? 3.0f : 0.0f, 12.0f, 4.0f, (direction.m_122434_() == Direction.Axis.Y) ? 13.0f : 16.0f).texture("#candelabra")).end()).element().from(2.0f, 8.0f, 11.0f).to(4.0f, (float)(8 + leftHeight), 13.0f).face(Direction.NORTH).end().face(Direction.SOUTH).end().face(Direction.WEST).end().face(Direction.EAST).end().faces((direction, builder) -> builder.uvs(0.0f, 8.0f, 2.0f, (float)(8 + leftHeight)).texture("#candle")).face(Direction.UP).uvs(0.0f, 6.0f, 2.0f, 8.0f).texture("#candle").end().end()).element().from(7.0f, 8.0f, 11.0f).to(9.0f, (float)(8 + centerHeight), 13.0f).face(Direction.NORTH).end().face(Direction.SOUTH).end().face(Direction.WEST).end().face(Direction.EAST).end().faces((direction, builder) -> builder.uvs(0.0f, 8.0f, 2.0f, (float)(8 + centerHeight)).texture("#candle")).face(Direction.UP).uvs(0.0f, 6.0f, 2.0f, 8.0f).texture("#candle").end().end()).element().from(12.0f, 8.0f, 11.0f).to(14.0f, (float)(8 + rightHeight), 13.0f).face(Direction.NORTH).end().face(Direction.SOUTH).end().face(Direction.WEST).end().face(Direction.EAST).end().faces((direction, builder) -> builder.uvs(0.0f, 8.0f, 2.0f, (float)(8 + rightHeight)).texture("#candle")).face(Direction.UP).uvs(0.0f, 6.0f, 2.0f, 8.0f).texture("#candle").end().end()).element().from(2.5f, (float)(8 + leftHeight), 12.0f).to(3.5f, (float)(9 + leftHeight), 12.0f).rotation().angle(45.0f).axis(Direction.Axis.Y).origin(3.0f, (float)(8 + leftHeight), 12.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end()).element().from(2.5f, (float)(8 + leftHeight), 12.0f).to(3.5f, (float)(9 + leftHeight), 12.0f).rotation().angle(-45.0f).axis(Direction.Axis.Y).origin(3.0f, (float)(8 + leftHeight), 12.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end()).element().from(7.5f, (float)(8 + centerHeight), 12.0f).to(8.5f, (float)(9 + centerHeight), 12.0f).rotation().angle(45.0f).axis(Direction.Axis.Y).origin(8.0f, (float)(8 + centerHeight), 12.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end()).element().from(7.5f, (float)(8 + centerHeight), 12.0f).to(8.5f, (float)(9 + centerHeight), 12.0f).rotation().angle(-45.0f).axis(Direction.Axis.Y).origin(8.0f, (float)(8 + centerHeight), 12.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end()).element().from(12.5f, (float)(8 + rightHeight), 12.0f).to(13.5f, (float)(9 + rightHeight), 12.0f).rotation().angle(45.0f).axis(Direction.Axis.Y).origin(13.0f, (float)(8 + rightHeight), 12.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end()).element().from(12.5f, (float)(8 + rightHeight), 12.0f).to(13.5f, (float)(9 + rightHeight), 12.0f).rotation().angle(-45.0f).axis(Direction.Axis.Y).origin(13.0f, (float)(8 + rightHeight), 12.0f).end().face(Direction.NORTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().face(Direction.SOUTH).uvs(0.0f, 5.0f, 1.0f, 6.0f).texture("#candle").end().end();
    }
    
    private void perFaceBlock(final Block b, final ResourceLocation inside, final ResourceLocation outside) {
        final ModelFile modelInside = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(b.getRegistryName().m_135815_() + "_inside", new ResourceLocation("block/template_single_face"))).texture("texture", inside);
        final ModelFile modelOutside = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(b.getRegistryName().m_135815_() + "_outside", new ResourceLocation("block/template_single_face"))).texture("texture", outside);
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).addModel()).condition((Property)HugeMushroomBlock.f_54127_, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).addModel()).condition((Property)HugeMushroomBlock.f_54127_, (Comparable[])new Boolean[] { true }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).uvLock(true).rotationY(180).addModel()).condition((Property)HugeMushroomBlock.f_54129_, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).uvLock(true).rotationY(180).addModel()).condition((Property)HugeMushroomBlock.f_54129_, (Comparable[])new Boolean[] { true }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).uvLock(true).rotationY(270).addModel()).condition((Property)HugeMushroomBlock.f_54130_, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).uvLock(true).rotationY(270).addModel()).condition((Property)HugeMushroomBlock.f_54130_, (Comparable[])new Boolean[] { true }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).uvLock(true).rotationY(90).addModel()).condition((Property)HugeMushroomBlock.f_54128_, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).uvLock(true).rotationY(90).addModel()).condition((Property)HugeMushroomBlock.f_54128_, (Comparable[])new Boolean[] { true }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).uvLock(true).rotationX(270).addModel()).condition((Property)HugeMushroomBlock.f_54131_, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).uvLock(true).rotationX(270).addModel()).condition((Property)HugeMushroomBlock.f_54131_, (Comparable[])new Boolean[] { true }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).uvLock(true).rotationX(90).addModel()).condition((Property)HugeMushroomBlock.f_54132_, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).uvLock(true).rotationX(90).addModel()).condition((Property)HugeMushroomBlock.f_54132_, (Comparable[])new Boolean[] { true }).end();
    }
    
    private void hollowLogs(final Block originalLog, final Block strippedLog, final RegistryObject<HollowLogHorizontal> horizontalHollowLog, final RegistryObject<HollowLogVertical> verticalHollowLog, final RegistryObject<HollowLogClimbable> climbableHollowLog, final ModelFile emptyLog, final ModelFile mossLog, final ModelFile grassLog, final ModelFile snowLog, final ModelFile hollowLog, final ModelFile vineLog, final ModelFile ladderLog) {
        final ResourceLocation top = new ResourceLocation("block/" + originalLog.getRegistryName().m_135815_() + "_top");
        final ResourceLocation side = new ResourceLocation("block/" + originalLog.getRegistryName().m_135815_());
        final ResourceLocation inner = new ResourceLocation("block/" + strippedLog.getRegistryName().m_135815_());
        this.getVariantBuilder((Block)horizontalHollowLog.get()).forAllStates(state -> {
            ConfiguredModel.builder();
            BlockModelBuilder blockModelBuilder = switch ((HollowLogVariants.Horizontal)state.m_61143_((Property)HollowLogHorizontal.VARIANT)) {
                case MOSS -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(horizontalHollowLog.getId().m_135815_() + "_moss")).parent(mossLog);
                case MOSS_AND_GRASS -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(horizontalHollowLog.getId().m_135815_() + "_moss_grass")).parent(grassLog);
                case SNOW -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(horizontalHollowLog.getId().m_135815_() + "_snow")).parent(snowLog);
                default -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(horizontalHollowLog.getId().m_135815_())).parent(emptyLog);
            };
            final ConfiguredModel.Builder builder;
            return builder.modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)blockModelBuilder.texture("top", top)).texture("side", side)).texture("inner", inner)).rotationY((state.m_61143_((Property)HollowLogHorizontal.HORIZONTAL_AXIS) == Direction.Axis.X) ? 90 : 0).build();
        });
        this.simpleBlock((Block)verticalHollowLog.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(verticalHollowLog.getId().m_135815_())).parent(hollowLog)).texture("top", top)).texture("side", side)).texture("inner", inner));
        this.getVariantBuilder((Block)climbableHollowLog.get()).forAllStates(state -> {
            ConfiguredModel.builder();
            BlockModelBuilder blockModelBuilder2 = switch ((HollowLogVariants.Climbable)state.m_61143_((Property)HollowLogClimbable.VARIANT)) {
                case VINE -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(climbableHollowLog.getId().m_135815_() + "_vine")).parent(vineLog);
                case LADDER,  LADDER_WATERLOGGED -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(climbableHollowLog.getId().m_135815_() + "_ladder")).parent(ladderLog);
                default -> throw new IncompatibleClassChangeError();
            };
            final ConfiguredModel.Builder builder2;
            return builder2.modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)blockModelBuilder2.texture("top", top)).texture("side", side)).texture("inner", inner)).rotationY((int)((Direction)state.m_61143_((Property)HollowLogClimbable.f_54117_)).m_122435_()).uvLock(true).build();
        });
    }
    
    private void hollowLogs(final RegistryObject<RotatedPillarBlock> originalLog, final RegistryObject<RotatedPillarBlock> strippedLog, final RegistryObject<HollowLogHorizontal> horizontalHollowLog, final RegistryObject<HollowLogVertical> verticalHollowLog, final RegistryObject<HollowLogClimbable> climbableHollowLog, final ModelFile emptyLog, final ModelFile mossLog, final ModelFile grassLog, final ModelFile snowLog, final ModelFile hollowLog, final ModelFile vineLog, final ModelFile ladderLog) {
        final ResourceLocation top = TwilightForestMod.prefix("block/" + originalLog.getId().m_135815_() + "_top");
        final ResourceLocation side = TwilightForestMod.prefix("block/" + originalLog.getId().m_135815_());
        final ResourceLocation inner = TwilightForestMod.prefix("block/" + strippedLog.getId().m_135815_());
        this.getVariantBuilder((Block)horizontalHollowLog.get()).forAllStates(state -> {
            ConfiguredModel.builder();
            BlockModelBuilder blockModelBuilder = switch ((HollowLogVariants.Horizontal)state.m_61143_((Property)HollowLogHorizontal.VARIANT)) {
                case MOSS -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(horizontalHollowLog.getId().m_135815_() + "_moss")).parent(mossLog);
                case MOSS_AND_GRASS -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(horizontalHollowLog.getId().m_135815_() + "_moss_grass")).parent(grassLog);
                case SNOW -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(horizontalHollowLog.getId().m_135815_() + "_snow")).parent(snowLog);
                default -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(horizontalHollowLog.getId().m_135815_())).parent(emptyLog);
            };
            final ConfiguredModel.Builder builder;
            return builder.modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)blockModelBuilder.texture("top", top)).texture("side", side)).texture("inner", inner)).rotationY((state.m_61143_((Property)HollowLogHorizontal.HORIZONTAL_AXIS) == Direction.Axis.X) ? 90 : 0).build();
        });
        this.simpleBlock((Block)verticalHollowLog.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(verticalHollowLog.getId().m_135815_())).parent(hollowLog)).texture("top", top)).texture("side", side)).texture("inner", inner));
        this.getVariantBuilder((Block)climbableHollowLog.get()).forAllStates(state -> {
            ConfiguredModel.builder();
            BlockModelBuilder blockModelBuilder2 = switch ((HollowLogVariants.Climbable)state.m_61143_((Property)HollowLogClimbable.VARIANT)) {
                case VINE -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(climbableHollowLog.getId().m_135815_() + "_vine")).parent(vineLog);
                case LADDER,  LADDER_WATERLOGGED -> (BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(climbableHollowLog.getId().m_135815_() + "_ladder")).parent(ladderLog);
                default -> throw new IncompatibleClassChangeError();
            };
            final ConfiguredModel.Builder builder2;
            return builder2.modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)blockModelBuilder2.texture("top", top)).texture("side", side)).texture("inner", inner)).rotationY((int)((Direction)state.m_61143_((Property)HollowLogClimbable.f_54117_)).m_122435_()).uvLock(true).build();
        });
    }
    
    private BlockModelBuilder buildVerticalLog(@Nullable final HollowLogVariants.Climbable variant) {
        final BlockModelBuilder model = (BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent((variant == null) ? "vertical_hollow_log" : ("vertical_hollow_log_" + variant.m_7912_()), "minecraft:block/block")).texture("particle", "#side")).element().from(0.0f, 0.0f, 0.0f).to(2.0f, 16.0f, 16.0f).allFaces((dir, builder) -> builder.cullface(dir).texture((dir == Direction.EAST) ? "#inner" : ((dir.m_122434_() == Direction.Axis.Y) ? "#top" : "#side"))).face(Direction.EAST).cullface((Direction)null).end().end()).element().from(14.0f, 0.0f, 0.0f).to(16.0f, 16.0f, 16.0f).allFaces((dir, builder) -> builder.cullface(dir).texture((dir == Direction.WEST) ? "#inner" : ((dir.m_122434_() == Direction.Axis.Y) ? "#top" : "#side"))).face(Direction.WEST).cullface((Direction)null).end().end()).element().from(2.0f, 0.0f, 0.0f).to(14.0f, 16.0f, 2.0f).allFaces((dir, builder) -> builder.cullface(dir).texture((dir == Direction.SOUTH) ? "#inner" : ((dir.m_122434_() == Direction.Axis.Y) ? "#top" : "#side"))).face(Direction.SOUTH).cullface((Direction)null).end().end()).element().from(2.0f, 0.0f, 14.0f).to(14.0f, 16.0f, 16.0f).allFaces((dir, builder) -> builder.cullface(dir).texture((dir == Direction.NORTH) ? "#inner" : ((dir.m_122434_() == Direction.Axis.Y) ? "#top" : "#side"))).face(Direction.NORTH).cullface((Direction)null).end().end();
        if (variant != null) {
            ((BlockModelBuilder)model.element().from(2.0f, 0.0f, 2.8f).to(14.0f, 16.0f, 2.8f).face(Direction.NORTH).end().face(Direction.SOUTH).end().faces((dir, builder) -> builder.texture("#climbable").tintindex(1)).shade(false).end()).texture("climbable", "minecraft:block/" + variant.m_7912_());
        }
        return model;
    }
    
    private BlockModelBuilder buildHorizontalHollowLog(final boolean carpet, boolean grass) {
        final int height = carpet ? 3 : 2;
        final int heightInv = 16 - height;
        grass &= carpet;
        final BlockModelBuilder model = (BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(carpet ? (grass ? "horizontal_hollow_log_plant" : "horizontal_hollow_log_carpet") : "horizontal_hollow_log", "minecraft:block/block")).texture("particle", "#side")).element().from(0.0f, 0.0f, 0.0f).to(16.0f, (float)height, 16.0f).allFaces((dir, builder) -> builder.uvs(0.0f, (dir.m_122434_() == Direction.Axis.Y) ? 0.0f : ((float)heightInv), 16.0f, 16.0f).cullface((dir == Direction.UP) ? null : dir).texture((carpet && dir == Direction.UP) ? "#carpet" : ((dir.m_122434_() == Direction.Axis.Z) ? "#top" : ((dir == Direction.UP) ? "#inner" : "#side")))).face(Direction.EAST).uvs((float)heightInv, 0.0f, 16.0f, 16.0f).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).end().face(Direction.WEST).uvs(0.0f, 0.0f, (float)height, 16.0f).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).end().face(Direction.DOWN).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).end().end()).element().from(0.0f, 14.0f, 0.0f).to(16.0f, 16.0f, 16.0f).allFaces((dir, builder) -> builder.uvs(0.0f, 0.0f, 16.0f, (dir.m_122434_() == Direction.Axis.Y) ? 16.0f : 2.0f).cullface((dir == Direction.DOWN) ? null : dir).texture((dir.m_122434_() == Direction.Axis.Z) ? "#top" : ((dir == Direction.DOWN) ? "#inner" : "#side"))).face(Direction.EAST).uvs(0.0f, 0.0f, 2.0f, 16.0f).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).end().face(Direction.WEST).uvs(14.0f, 0.0f, 16.0f, 16.0f).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).end().face(Direction.DOWN).rotation(ModelBuilder.FaceRotation.UPSIDE_DOWN).end().end()).element().from(0.0f, (float)height, 0.0f).to(2.0f, 14.0f, 16.0f).face(Direction.NORTH).uvs(14.0f, 2.0f, 16.0f, (float)heightInv).end().face(Direction.SOUTH).uvs(0.0f, 2.0f, 2.0f, (float)heightInv).end().face(Direction.EAST).uvs(2.0f, 0.0f, (float)heightInv, 16.0f).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).end().face(Direction.WEST).uvs((float)height, 0.0f, 14.0f, 16.0f).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).end().faces((dir, builder) -> builder.cullface((dir == Direction.EAST) ? null : dir).texture((dir.m_122434_() == Direction.Axis.Z) ? "#top" : ((dir == Direction.EAST) ? "#inner" : "#side"))).end()).element().from(14.0f, (float)height, 0.0f).to(16.0f, 14.0f, 16.0f).face(Direction.NORTH).uvs(0.0f, 2.0f, 2.0f, (float)heightInv).end().face(Direction.SOUTH).uvs(14.0f, 2.0f, 16.0f, (float)heightInv).end().face(Direction.EAST).uvs(2.0f, 0.0f, (float)heightInv, 16.0f).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).end().face(Direction.WEST).uvs((float)height, 0.0f, 14.0f, 16.0f).rotation(ModelBuilder.FaceRotation.COUNTERCLOCKWISE_90).end().faces((dir, builder) -> builder.cullface((dir == Direction.WEST) ? null : dir).texture((dir.m_122434_() == Direction.Axis.Z) ? "#top" : ((dir == Direction.WEST) ? "#inner" : "#side"))).end();
        if (carpet) {
            model.element().from(0.0f, 0.0f, 0.0f).to(16.0f, (float)height, 16.0f).face(Direction.NORTH).end().face(Direction.SOUTH).end().faces((dir, builder) -> builder.uvs(0.0f, (float)(16 - height), 16.0f, 16.0f).texture("#overhang"));
        }
        if (grass) {
            model.element().from(0.8f, (float)height, 8.0f).to(15.2f, 14.0f, 8.0f).rotation().origin(8.0f, 8.0f, 8.0f).axis(Direction.Axis.Y).angle(45.0f).rescale(true).end().shade(false).face(Direction.NORTH).end().face(Direction.SOUTH).end().faces((direction, faceBuilder) -> faceBuilder.uvs(0.0f, (float)height, 16.0f, 14.0f).texture("#plant").tintindex(1));
            model.element().from(8.0f, (float)height, 0.8f).to(8.0f, 14.0f, 15.2f).rotation().origin(8.0f, 8.0f, 8.0f).axis(Direction.Axis.Y).angle(45.0f).rescale(true).end().shade(false).face(Direction.WEST).end().face(Direction.EAST).end().faces((direction, faceBuilder) -> faceBuilder.uvs(0.0f, (float)height, 16.0f, 14.0f).texture("#plant").tintindex(1));
        }
        return model;
    }
    
    @Nonnull
    public String m_6055_() {
        return "TwilightForest blockstates and block models";
    }
}
