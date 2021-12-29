// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import net.minecraft.state.BooleanProperty;
import net.minecraft.block.BlockState;
import javax.annotation.Nonnull;
import net.minecraft.block.HugeMushroomBlock;
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
import net.minecraft.state.properties.StairsShape;
import net.minecraft.state.properties.Half;
import net.minecraft.block.HorizontalFaceBlock;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.state.properties.SlabType;
import net.minecraft.block.SlabBlock;
import java.util.function.Consumer;
import twilightforest.block.CastleDoorBlock;
import twilightforest.block.SpecialMagicLogBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.block.DoorBlock;
import twilightforest.enums.FireJetVariant;
import twilightforest.block.FireJetBlock;
import twilightforest.block.EncasedSmokerBlock;
import net.minecraft.block.DirectionalBlock;
import twilightforest.block.DirectionalRotatedPillarBlock;
import twilightforest.block.NagastoneBlock;
import twilightforest.enums.NagastoneVariant;
import com.google.common.collect.UnmodifiableIterator;
import net.minecraft.block.SixWayBlock;
import net.minecraftforge.fml.RegistryObject;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import twilightforest.block.IronLadderBlock;
import net.minecraft.block.LadderBlock;
import net.minecraft.util.Direction;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import twilightforest.block.Experiment115Block;
import net.minecraft.state.Property;
import twilightforest.block.TFPortalBlock;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import twilightforest.TwilightForestMod;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;

public class BlockstateGenerator extends BlockStateProvider
{
    public BlockstateGenerator(final DataGenerator gen, final ExistingFileHelper exFileHelper) {
        super(gen, "twilightforest", exFileHelper);
    }
    
    protected void registerStatesAndModels() {
        this.tintedAndFlipped((Block)TFBlocks.tower_wood.get());
        this.simpleBlock((Block)TFBlocks.tower_wood_encased.get(), (ModelFile)this.cubeAllTinted(TFBlocks.tower_wood_encased.getId().func_110623_a(), TFBlocks.tower_wood_encased.getId().func_110623_a()));
        this.simpleBlock((Block)TFBlocks.tower_wood_cracked.get(), ConfiguredModel.builder().modelFile((ModelFile)this.cubeAllTinted(TFBlocks.tower_wood_cracked.getId().func_110623_a(), TFBlocks.tower_wood_cracked.getId().func_110623_a())).nextModel().modelFile((ModelFile)this.cubeAllTinted(TFBlocks.tower_wood_cracked.getId().func_110623_a() + "_flipped", TFBlocks.tower_wood_cracked.getId().func_110623_a(), true)).nextModel().modelFile((ModelFile)this.cubeAllTinted(TFBlocks.tower_wood_cracked.getId().func_110623_a() + "_alt", TFBlocks.tower_wood_cracked.getId().func_110623_a() + "_alt")).nextModel().modelFile((ModelFile)this.cubeAllTinted(TFBlocks.tower_wood_cracked.getId().func_110623_a() + "_alt_flipped", TFBlocks.tower_wood_cracked.getId().func_110623_a() + "_alt", true)).build());
        this.tintedAndFlipped((Block)TFBlocks.tower_wood_mossy.get());
        this.tintedAndFlipped((Block)TFBlocks.tower_wood_infested.get());
        this.builtinEntity((Block)TFBlocks.firefly.get(), "twilightforest:block/stone_twist/twist_blank");
        this.builtinEntity((Block)TFBlocks.moonworm.get(), "twilightforest:block/stone_twist/twist_blank");
        this.builtinEntity((Block)TFBlocks.cicada.get(), "twilightforest:block/stone_twist/twist_blank");
        this.builtinEntity((Block)TFBlocks.keepsake_casket.get(), "minecraft:block/netherite_block");
        final ModelFile portalModel = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/twilight_portal"));
        final ModelFile portalOverlayModel = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/twilight_portal_barrier"));
        ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)TFBlocks.twilight_portal.get()).part().modelFile(portalModel).addModel()).end().part().modelFile(portalOverlayModel).addModel()).condition((Property)TFPortalBlock.DISALLOW_RETURN, (Comparable[])new Boolean[] { true }).end();
        this.getVariantBuilder((Block)TFBlocks.experiment_115.get()).forAllStates(state -> {
            final int bitesTaken = (int)state.func_177229_b((Property)Experiment115Block.BITES_TAKEN);
            final String basePath = String.format("block/experiment115_%d_8", 8 - bitesTaken);
            ModelFile model;
            if (state.func_177229_b((Property)Experiment115Block.REGENERATE)) {
                model = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(basePath + "_regenerating", TwilightForestMod.prefix(basePath))).texture("top_2", "block/experiment115/experiment115_sprinkle");
            }
            else {
                model = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix(basePath));
            }
            return ConfiguredModel.builder().modelFile(model).build();
        });
        final MultiPartBlockStateBuilder ironLadder = this.getMultipartBuilder((Block)TFBlocks.iron_ladder.get());
        final ModelFile ironLadderLeft = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/iron_ladder_left"));
        final ModelFile ironLadderLeftConnected = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/iron_ladder_left_connection"));
        final ModelFile ironLadderRight = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/iron_ladder_right"));
        final ModelFile ironLadderRightConnected = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/iron_ladder_right_connection"));
        for (final Direction d : Direction.Plane.HORIZONTAL) {
            int rotY = 0;
            switch (d) {
                default: {
                    rotY = 0;
                    break;
                }
                case EAST: {
                    rotY = 90;
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
            }
            ((MultiPartBlockStateBuilder.PartBuilder)ironLadder.part().modelFile(ironLadderLeft).rotationY(rotY).addModel()).condition((Property)LadderBlock.field_176382_a, (Comparable[])new Direction[] { d }).condition((Property)IronLadderBlock.LEFT, (Comparable[])new Boolean[] { false }).end();
            ((MultiPartBlockStateBuilder.PartBuilder)ironLadder.part().modelFile(ironLadderLeftConnected).rotationY(rotY).addModel()).condition((Property)LadderBlock.field_176382_a, (Comparable[])new Direction[] { d }).condition((Property)IronLadderBlock.LEFT, (Comparable[])new Boolean[] { true }).end();
            ((MultiPartBlockStateBuilder.PartBuilder)ironLadder.part().modelFile(ironLadderRight).rotationY(rotY).addModel()).condition((Property)LadderBlock.field_176382_a, (Comparable[])new Direction[] { d }).condition((Property)IronLadderBlock.RIGHT, (Comparable[])new Boolean[] { false }).end();
            ((MultiPartBlockStateBuilder.PartBuilder)ironLadder.part().modelFile(ironLadderRightConnected).rotationY(rotY).addModel()).condition((Property)LadderBlock.field_176382_a, (Comparable[])new Direction[] { d }).condition((Property)IronLadderBlock.RIGHT, (Comparable[])new Boolean[] { true }).end();
        }
        this.towerBlocks();
        this.simpleBlock((Block)TFBlocks.fake_gold.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/gold_block")));
        this.simpleBlock((Block)TFBlocks.fake_diamond.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/diamond_block")));
        this.simpleBlock((Block)TFBlocks.naga_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.lich_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.minoshroom_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.hydra_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.yeti_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.snow_queen_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.knight_phantom_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.ur_ghast_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.quest_ram_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.naga_wall_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.lich_wall_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.minoshroom_wall_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.hydra_wall_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.yeti_wall_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.snow_queen_wall_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.knight_phantom_wall_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.ur_ghast_wall_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        this.simpleBlock((Block)TFBlocks.quest_ram_wall_trophy.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/skull")));
        final ModelFile shieldModel = (ModelFile)this.models().cubeTop(TFBlocks.stronghold_shield.getId().func_110623_a(), TwilightForestMod.prefix("block/shield_outside"), TwilightForestMod.prefix("block/shield_inside"));
        this.getVariantBuilder((Block)TFBlocks.stronghold_shield.get()).forAllStates(state -> {
            final Direction dir = (Direction)state.func_177229_b((Property)BlockStateProperties.field_208155_H);
            return ConfiguredModel.builder().uvLock(true).modelFile(shieldModel).rotationX((dir == Direction.DOWN) ? 180 : (dir.func_176740_k().func_176722_c() ? 90 : 0)).rotationY(dir.func_176740_k().func_200128_b() ? 0 : ((int)dir.func_185119_l() % 360)).build();
        });
        this.trophyPedestal();
        this.auroraBlocks();
        this.slider();
        this.simpleBlock((Block)TFBlocks.underbrick.get());
        this.simpleBlock((Block)TFBlocks.underbrick_cracked.get());
        this.simpleBlock((Block)TFBlocks.underbrick_mossy.get());
        this.simpleBlock((Block)TFBlocks.underbrick_floor.get());
        this.thorns();
        this.simpleBlock((Block)TFBlocks.thorn_rose.get(), (ModelFile)this.models().cross(TFBlocks.thorn_rose.getId().func_110623_a(), this.blockTexture((Block)TFBlocks.thorn_rose.get())));
        this.simpleBlock((Block)TFBlocks.thorn_leaves.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/oak_leaves")));
        this.simpleBlock((Block)TFBlocks.beanstalk_leaves.get(), (ModelFile)this.models().getExistingFile(new ResourceLocation("block/spruce_leaves")));
        this.simpleBlock((Block)TFBlocks.hollow_oak_sapling.get(), (ModelFile)this.models().cross(TFBlocks.hollow_oak_sapling.getId().func_110623_a(), this.blockTexture((Block)TFBlocks.hollow_oak_sapling.get())));
        final ModelFile deadrock = (ModelFile)this.models().cubeAll(TFBlocks.deadrock.getId().func_110623_a(), this.blockTexture((Block)TFBlocks.deadrock.get()));
        final ModelFile deadrockMirrored = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.deadrock.getId().func_110623_a() + "_mirrored", TwilightForestMod.prefix("block/util/cube_mirrored_all"))).texture("all", this.blockTexture((Block)TFBlocks.deadrock.get()));
        this.simpleBlock((Block)TFBlocks.deadrock.get(), ConfiguredModel.builder().modelFile(deadrock).nextModel().rotationY(180).modelFile(deadrock).nextModel().modelFile(deadrockMirrored).nextModel().rotationY(180).modelFile(deadrockMirrored).build());
        final ModelFile deadrockCracked = (ModelFile)this.models().cubeAll(TFBlocks.deadrock_cracked.getId().func_110623_a(), this.blockTexture((Block)TFBlocks.deadrock_cracked.get()));
        this.allRotations((Block)TFBlocks.deadrock_cracked.get(), deadrockCracked);
        final ModelFile deadrockWeathered = (ModelFile)this.models().cubeAll(TFBlocks.deadrock_weathered.getId().func_110623_a(), this.blockTexture((Block)TFBlocks.deadrock_weathered.get()));
        this.allRotations((Block)TFBlocks.deadrock_weathered.get(), deadrockWeathered);
        this.perFaceBlock((Block)TFBlocks.trollsteinn.get(), this.blockTexture((Block)TFBlocks.trollsteinn.get()), TwilightForestMod.prefix("block/" + TFBlocks.trollsteinn.getId().func_110623_a() + "_light"));
        this.simpleBlock((Block)TFBlocks.wispy_cloud.get());
        this.simpleBlock((Block)TFBlocks.fluffy_cloud.get());
        this.simpleBlock((Block)TFBlocks.giant_cobblestone.get(), (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.giant_cobblestone.getId().func_110623_a(), TwilightForestMod.prefix("block/util/giant_block"))).texture("all", this.blockTexture(Blocks.field_150347_e)));
        this.simpleBlock((Block)TFBlocks.giant_log.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.giant_log.getId().func_110623_a(), TwilightForestMod.prefix("block/util/giant_column"))).texture("side", this.blockTexture(Blocks.field_196617_K))).texture("end", new ResourceLocation("block/oak_log_top")));
        this.simpleBlock((Block)TFBlocks.giant_leaves.get(), (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.giant_leaves.getId().func_110623_a(), TwilightForestMod.prefix("block/util/giant_block"))).texture("all", this.blockTexture(Blocks.field_196642_W)));
        this.simpleBlock((Block)TFBlocks.giant_obsidian.get(), (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.giant_obsidian.getId().func_110623_a(), TwilightForestMod.prefix("block/util/giant_block"))).texture("all", this.blockTexture(Blocks.field_150343_Z)));
        this.simpleBlock((Block)TFBlocks.uberous_soil.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.uberous_soil.getId().func_110623_a(), TwilightForestMod.prefix("block/util/cube_all_2_layer"))).texture("all", this.blockTexture((Block)TFBlocks.uberous_soil.get()))).texture("all2", TwilightForestMod.prefix("block/" + TFBlocks.uberous_soil.getId().func_110623_a() + "_glow")));
        this.simpleBlock((Block)TFBlocks.huge_stalk.get(), (ModelFile)this.models().cubeColumn(TFBlocks.huge_stalk.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.huge_stalk.getId().func_110623_a()), TwilightForestMod.prefix("block/" + TFBlocks.huge_stalk.getId().func_110623_a() + "_top")));
        this.perFaceBlock((Block)TFBlocks.huge_mushgloom.get(), TwilightForestMod.prefix("block/huge_gloom_inside"), TwilightForestMod.prefix("block/huge_gloom_cap"));
        this.simpleBlock((Block)TFBlocks.huge_mushgloom_stem.get());
        this.simpleBlock((Block)TFBlocks.trollvidr.get(), (ModelFile)this.models().cross(TFBlocks.trollvidr.getId().func_110623_a(), this.blockTexture((Block)TFBlocks.trollvidr.get())));
        this.simpleBlock((Block)TFBlocks.unripe_trollber.get(), (ModelFile)this.models().cross(TFBlocks.unripe_trollber.getId().func_110623_a(), this.blockTexture((Block)TFBlocks.unripe_trollber.get())));
        final ModelFile trollber = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.trollber.getId().func_110623_a(), TwilightForestMod.prefix("block/util/cross_2_layer"))).texture("cross", this.blockTexture((Block)TFBlocks.trollber.get()))).texture("cross2", TwilightForestMod.prefix("block/" + TFBlocks.trollber.getId().func_110623_a() + "_glow"));
        this.simpleBlock((Block)TFBlocks.trollber.get(), trollber);
        this.lilyPad((Block)TFBlocks.huge_lilypad.get());
        this.simpleBlock((Block)TFBlocks.huge_waterlily.get(), (ModelFile)this.models().cross(TFBlocks.huge_waterlily.getId().func_110623_a(), this.blockTexture((Block)TFBlocks.huge_waterlily.get())));
        this.simpleBlock((Block)TFBlocks.castle_brick.get());
        this.simpleBlock((Block)TFBlocks.castle_brick_worn.get());
        this.simpleBlock((Block)TFBlocks.castle_brick_cracked.get());
        this.allRotations((Block)TFBlocks.castle_brick_roof.get(), this.cubeAll((Block)TFBlocks.castle_brick_roof.get()));
        this.simpleBlock((Block)TFBlocks.castle_brick_mossy.get());
        this.simpleBlock((Block)TFBlocks.castle_brick_frame.get());
        this.rotationallyCorrectColumn((Block)TFBlocks.castle_pillar_encased.get());
        this.rotationallyCorrectColumn((Block)TFBlocks.castle_pillar_bold.get());
        this.simpleBlock((Block)TFBlocks.castle_pillar_encased_tile.get(), (ModelFile)this.models().cubeAll(TFBlocks.castle_pillar_encased_tile.getId().func_110623_a(), TwilightForestMod.prefix("block/castle_pillar_encased_end")));
        this.simpleBlock((Block)TFBlocks.castle_pillar_bold_tile.get());
        this.stairsBlock((StairsBlock)TFBlocks.castle_stairs_brick.get(), TwilightForestMod.prefix("block/" + TFBlocks.castle_stairs_brick.getId().func_110623_a()));
        this.stairsBlock((StairsBlock)TFBlocks.castle_stairs_worn.get(), TwilightForestMod.prefix("block/" + TFBlocks.castle_stairs_worn.getId().func_110623_a()));
        this.stairsBlock((StairsBlock)TFBlocks.castle_stairs_cracked.get(), TwilightForestMod.prefix("block/" + TFBlocks.castle_stairs_cracked.getId().func_110623_a()));
        this.stairsBlock((StairsBlock)TFBlocks.castle_stairs_mossy.get(), TwilightForestMod.prefix("block/" + TFBlocks.castle_stairs_mossy.getId().func_110623_a()));
        this.stairsBlock((StairsBlock)TFBlocks.castle_stairs_encased.get(), TwilightForestMod.prefix("block/castle_pillar_encased_h"), TwilightForestMod.prefix("block/castleblock_tile"), TwilightForestMod.prefix("block/castle_brick_roof"));
        this.stairsBlock((StairsBlock)TFBlocks.castle_stairs_bold.get(), TwilightForestMod.prefix("block/castle_pillar_bold_tile"));
        final ConfiguredModel[] runeBrickModels = new ConfiguredModel[8];
        for (int i = 0; i < runeBrickModels.length; ++i) {
            runeBrickModels[i] = new ConfiguredModel((ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("castle_rune_brick_" + i, TwilightForestMod.prefix("block/util/cube_all_2_layer"))).texture("all", TwilightForestMod.prefix("block/castle_brick"))).texture("all2", TwilightForestMod.prefix("block/castleblock_magic_" + i)));
        }
        this.simpleBlock((Block)TFBlocks.castle_rune_brick_yellow.get(), runeBrickModels);
        this.simpleBlock((Block)TFBlocks.castle_rune_brick_purple.get(), runeBrickModels);
        this.simpleBlock((Block)TFBlocks.castle_rune_brick_pink.get(), runeBrickModels);
        this.simpleBlock((Block)TFBlocks.castle_rune_brick_blue.get(), runeBrickModels);
        this.logBlock((RotatedPillarBlock)TFBlocks.cinder_log.get());
        this.simpleBlock((Block)TFBlocks.cinder_wood.get(), (ModelFile)this.models().cubeAll(TFBlocks.cinder_wood.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.cinder_log.getId().func_110623_a())));
        final ModelFile furnaceOff = (ModelFile)this.models().getExistingFile(new ResourceLocation("block/furnace"));
        final ModelFile furnaceOn = (ModelFile)this.models().getExistingFile(new ResourceLocation("block/furnace_on"));
        this.horizontalBlock((Block)TFBlocks.cinder_furnace.get(), state -> state.func_177229_b((Property)AbstractFurnaceBlock.field_220091_b) ? furnaceOn : furnaceOff);
        this.castleDoor((Block)TFBlocks.castle_door_yellow.get());
        this.castleDoor((Block)TFBlocks.castle_door_purple.get());
        this.castleDoor((Block)TFBlocks.castle_door_pink.get());
        this.castleDoor((Block)TFBlocks.castle_door_blue.get());
        this.simpleBlockExisting((Block)TFBlocks.knightmetal_block.get());
        this.simpleBlockExisting((Block)TFBlocks.ironwood_block.get());
        this.simpleBlockExisting((Block)TFBlocks.fiery_block.get());
        this.simpleBlock((Block)TFBlocks.arctic_fur_block.get());
        final ModelFile steeleafBlock = (ModelFile)this.models().cubeAll(TFBlocks.steeleaf_block.getId().func_110623_a(), TwilightForestMod.prefix("block/" + TFBlocks.steeleaf_block.getId().func_110623_a()));
        this.allRotations((Block)TFBlocks.steeleaf_block.get(), steeleafBlock);
        final ModelFile carminiteBlock = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.carminite_block.getId().func_110623_a(), TwilightForestMod.prefix("block/util/cube_all_2_layer"))).texture("all", TwilightForestMod.prefix("block/" + TFBlocks.carminite_block.getId().func_110623_a()))).texture("all2", TwilightForestMod.prefix("block/" + TFBlocks.carminite_block.getId().func_110623_a() + "_overlay"));
        this.allRotations((Block)TFBlocks.carminite_block.get(), carminiteBlock);
        this.simpleBlock((Block)TFBlocks.twilight_portal_miniature_structure.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/miniature/portal")));
        this.simpleBlock((Block)TFBlocks.naga_courtyard_miniature_structure.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/miniature/naga_courtyard")));
        this.simpleBlock((Block)TFBlocks.lich_tower_miniature_structure.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/miniature/lich_tower")));
        this.mazestone();
        this.simpleBlock((Block)TFBlocks.hedge.get(), ConfiguredModel.builder().weight(10).modelFile((ModelFile)this.models().cubeAll(TFBlocks.hedge.getId().func_110623_a(), this.blockTexture((Block)TFBlocks.hedge.get()))).nextModel().weight(1).modelFile((ModelFile)this.models().cubeAll(TFBlocks.hedge.getId().func_110623_a() + "_rose", TwilightForestMod.prefix("block/" + TFBlocks.hedge.getId().func_110623_a() + "_rose"))).build());
        this.simpleBlock((Block)TFBlocks.boss_spawner_naga.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(new ResourceLocation("block/spawner"))) });
        this.simpleBlock((Block)TFBlocks.boss_spawner_lich.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(new ResourceLocation("block/spawner"))) });
        this.simpleBlock((Block)TFBlocks.boss_spawner_hydra.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(new ResourceLocation("block/spawner"))) });
        this.simpleBlock((Block)TFBlocks.boss_spawner_ur_ghast.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(new ResourceLocation("block/spawner"))) });
        this.simpleBlock((Block)TFBlocks.boss_spawner_knight_phantom.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(new ResourceLocation("block/spawner"))) });
        this.simpleBlock((Block)TFBlocks.boss_spawner_snow_queen.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(new ResourceLocation("block/spawner"))) });
        this.simpleBlock((Block)TFBlocks.boss_spawner_minoshroom.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(new ResourceLocation("block/spawner"))) });
        this.simpleBlock((Block)TFBlocks.boss_spawner_alpha_yeti.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(new ResourceLocation("block/spawner"))) });
        this.simpleBlock((Block)TFBlocks.boss_spawner_final_boss.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(new ResourceLocation("block/spawner"))) });
        this.simpleBlockExisting((Block)TFBlocks.firefly_jar.get());
        this.simpleBlockExisting((Block)TFBlocks.cicada_jar.get());
        this.registerPlantBlocks();
        this.simpleBlock((Block)TFBlocks.root.get());
        this.simpleBlock((Block)TFBlocks.liveroot_block.get());
        this.simpleBlock((Block)TFBlocks.uncrafting_table.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.uncrafting_table.getId().func_110623_a(), TwilightForestMod.prefix("block/util/cube_bottom_double_top"))).texture("top", TwilightForestMod.prefix("block/uncrafting_top"))).texture("glow", TwilightForestMod.prefix("block/uncrafting_glow"))).texture("bottom", new ResourceLocation("block/jungle_planks"))).texture("side", TwilightForestMod.prefix("block/uncrafting_side")));
        this.registerSmokersAndJets();
        this.axisBlock((RotatedPillarBlock)TFBlocks.stone_twist.get(), TwilightForestMod.prefix("block/stone_twist/twist_side"), TwilightForestMod.prefix("block/stone_twist/twist_end"));
        final ConfiguredModel[] lapisModels = new ConfiguredModel[4];
        this.registerWoodBlocks();
        this.registerNagastone();
        this.registerForceFields();
        this.simpleBlock((Block)TFBlocks.potted_twilight_oak_sapling.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_twilight_oak_sapling")));
        this.simpleBlock((Block)TFBlocks.potted_canopy_sapling.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_canopy_sapling")));
        this.simpleBlock((Block)TFBlocks.potted_mangrove_sapling.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_mangrove_sapling")));
        this.simpleBlock((Block)TFBlocks.potted_darkwood_sapling.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_darkwood_sapling")));
        this.simpleBlock((Block)TFBlocks.potted_hollow_oak_sapling.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_hollow_oak_sapling")));
        this.simpleBlock((Block)TFBlocks.potted_rainboak_sapling.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_rainboak_sapling")));
        this.simpleBlock((Block)TFBlocks.potted_time_sapling.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_time_sapling")));
        this.simpleBlock((Block)TFBlocks.potted_trans_sapling.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_trans_sapling")));
        this.simpleBlock((Block)TFBlocks.potted_mine_sapling.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_mine_sapling")));
        this.simpleBlock((Block)TFBlocks.potted_sort_sapling.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_sort_sapling")));
        this.simpleBlock((Block)TFBlocks.potted_mayapple.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_mayapple")));
        this.simpleBlock((Block)TFBlocks.potted_fiddlehead.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_fiddlehead")));
        this.simpleBlock((Block)TFBlocks.potted_mushgloom.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_mushgloom")));
        this.simpleBlock((Block)TFBlocks.potted_thorn.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_thorn")));
        this.simpleBlock((Block)TFBlocks.potted_green_thorn.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_green_thorn")));
        this.simpleBlock((Block)TFBlocks.potted_dead_thorn.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/potted_dead_thorn")));
        this.builtinEntity((Block)TFBlocks.twilight_oak_sign.get(), "twilightforest:block/wood/planks_twilight_oak_0");
        this.builtinEntity((Block)TFBlocks.twilight_wall_sign.get(), "twilightforest:block/wood/planks_twilight_oak_0");
        this.builtinEntity((Block)TFBlocks.canopy_sign.get(), "twilightforest:block/wood/planks_canopy_0");
        this.builtinEntity((Block)TFBlocks.canopy_wall_sign.get(), "twilightforest:block/wood/planks_canopy_0");
        this.builtinEntity((Block)TFBlocks.mangrove_sign.get(), "twilightforest:block/wood/planks_mangrove_0");
        this.builtinEntity((Block)TFBlocks.mangrove_wall_sign.get(), "twilightforest:block/wood/planks_mangrove_0");
        this.builtinEntity((Block)TFBlocks.darkwood_sign.get(), "twilightforest:block/wood/planks_darkwood_0");
        this.builtinEntity((Block)TFBlocks.darkwood_wall_sign.get(), "twilightforest:block/wood/planks_darkwood_0");
        this.builtinEntity((Block)TFBlocks.time_sign.get(), "twilightforest:block/wood/planks_time_0");
        this.builtinEntity((Block)TFBlocks.time_wall_sign.get(), "twilightforest:block/wood/planks_time_0");
        this.builtinEntity((Block)TFBlocks.trans_sign.get(), "twilightforest:block/wood/planks_trans_0");
        this.builtinEntity((Block)TFBlocks.trans_wall_sign.get(), "twilightforest:block/wood/planks_trans_0");
        this.builtinEntity((Block)TFBlocks.mine_sign.get(), "twilightforest:block/wood/planks_mine_0");
        this.builtinEntity((Block)TFBlocks.mine_wall_sign.get(), "twilightforest:block/wood/planks_mine_0");
        this.builtinEntity((Block)TFBlocks.sort_sign.get(), "twilightforest:block/wood/planks_sort_0");
        this.builtinEntity((Block)TFBlocks.sort_wall_sign.get(), "twilightforest:block/wood/planks_sort_0");
        this.casketStuff();
        this.stonePillar();
    }
    
    private void registerForceFields() {
        final ImmutableList<RegistryObject<Block>> forceFields = (ImmutableList<RegistryObject<Block>>)ImmutableList.of((Object)TFBlocks.force_field_pink, (Object)TFBlocks.force_field_blue, (Object)TFBlocks.force_field_green, (Object)TFBlocks.force_field_purple, (Object)TFBlocks.force_field_orange);
        for (final RegistryObject<Block> block : forceFields) {
            final ModelFile post = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(block.getId().func_110623_a() + "_post", TwilightForestMod.prefix("block/util/pane/post"))).texture("pane", TwilightForestMod.prefix("block/forcefield_white"))).texture("edge", "#pane");
            final ModelFile side = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(block.getId().func_110623_a() + "_side", TwilightForestMod.prefix("block/util/pane/side"))).texture("pane", TwilightForestMod.prefix("block/forcefield_white"))).texture("edge", "#pane");
            final ModelFile noside = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(block.getId().func_110623_a() + "_noside", TwilightForestMod.prefix("block/util/pane/noside"))).texture("pane", TwilightForestMod.prefix("block/forcefield_white"));
            final ModelFile sidealt = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(block.getId().func_110623_a() + "_side_alt", TwilightForestMod.prefix("block/util/pane/side_alt"))).texture("pane", TwilightForestMod.prefix("block/forcefield_white"))).texture("edge", "#pane");
            final ModelFile nosidealt = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(block.getId().func_110623_a() + "_noside_alt", TwilightForestMod.prefix("block/util/pane/noside_alt"))).texture("pane", TwilightForestMod.prefix("block/forcefield_white"));
            ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)block.get()).part().modelFile(post).uvLock(true).addModel()).end().part().modelFile(side).uvLock(true).addModel()).condition((Property)SixWayBlock.field_196488_a, (Comparable[])new Boolean[] { true }).end().part().modelFile(noside).uvLock(true).addModel()).condition((Property)SixWayBlock.field_196488_a, (Comparable[])new Boolean[] { false }).end().part().modelFile(side).uvLock(true).rotationY(90).addModel()).condition((Property)SixWayBlock.field_196490_b, (Comparable[])new Boolean[] { true }).end().part().modelFile(nosidealt).uvLock(true).addModel()).condition((Property)SixWayBlock.field_196490_b, (Comparable[])new Boolean[] { false }).end().part().modelFile(sidealt).uvLock(true).addModel()).condition((Property)SixWayBlock.field_196492_c, (Comparable[])new Boolean[] { true }).end().part().modelFile(nosidealt).uvLock(true).rotationY(90).addModel()).condition((Property)SixWayBlock.field_196492_c, (Comparable[])new Boolean[] { false }).end().part().modelFile(sidealt).uvLock(true).rotationY(90).addModel()).condition((Property)SixWayBlock.field_196495_y, (Comparable[])new Boolean[] { true }).end().part().modelFile(noside).uvLock(true).rotationY(270).addModel()).condition((Property)SixWayBlock.field_196495_y, (Comparable[])new Boolean[] { false }).end();
        }
    }
    
    private void registerNagastone() {
        final String baseName = TFBlocks.naga_stone.getId().func_110623_a();
        final ModelFile solid = (ModelFile)this.models().cubeBottomTop(baseName, TwilightForestMod.prefix("block/nagastone_long_side"), TwilightForestMod.prefix("block/nagastone_bottom_long"), TwilightForestMod.prefix("block/nagastone_turn_top"));
        final ModelFile down = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/naga_segment/down"));
        final ModelFile up = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/naga_segment/up"));
        final ModelFile horizontal = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/naga_segment/horizontal"));
        final ModelFile vertical = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/naga_segment/vertical"));
        this.getVariantBuilder((Block)TFBlocks.naga_stone.get()).forAllStates(s -> {
            switch ((NagastoneVariant)s.func_177229_b((Property)NagastoneBlock.VARIANT)) {
                case NORTH_DOWN: {
                    return ConfiguredModel.builder().modelFile(down).rotationY(270).build();
                }
                case SOUTH_DOWN: {
                    return ConfiguredModel.builder().modelFile(down).rotationY(90).build();
                }
                case WEST_DOWN: {
                    return ConfiguredModel.builder().modelFile(down).rotationY(180).build();
                }
                case EAST_DOWN: {
                    return ConfiguredModel.builder().modelFile(down).build();
                }
                case NORTH_UP: {
                    return ConfiguredModel.builder().modelFile(up).rotationY(270).build();
                }
                case SOUTH_UP: {
                    return ConfiguredModel.builder().modelFile(up).rotationY(90).build();
                }
                case EAST_UP: {
                    return ConfiguredModel.builder().modelFile(up).build();
                }
                case WEST_UP: {
                    return ConfiguredModel.builder().modelFile(up).rotationY(180).build();
                }
                case AXIS_X: {
                    return ConfiguredModel.builder().modelFile(horizontal).build();
                }
                case AXIS_Y: {
                    return ConfiguredModel.builder().modelFile(vertical).build();
                }
                case AXIS_Z: {
                    return ConfiguredModel.builder().modelFile(horizontal).rotationY(90).build();
                }
                default: {
                    return ConfiguredModel.builder().modelFile(solid).build();
                }
            }
        });
        this.horizontalBlock((Block)TFBlocks.naga_stone_head.get(), (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/" + TFBlocks.naga_stone_head.getId().func_110623_a())));
        this.nagastonePillar((Block)TFBlocks.nagastone_pillar.get(), "");
        this.nagastonePillar((Block)TFBlocks.nagastone_pillar_mossy.get(), "_mossy");
        this.nagastonePillar((Block)TFBlocks.nagastone_pillar_weathered.get(), "_weathered");
        this.etchedNagastone((Block)TFBlocks.etched_nagastone.get(), "");
        this.etchedNagastone((Block)TFBlocks.etched_nagastone_mossy.get(), "_mossy");
        this.etchedNagastone((Block)TFBlocks.etched_nagastone_weathered.get(), "_weathered");
        this.stairsBlock((StairsBlock)TFBlocks.nagastone_stairs_left.get(), TwilightForestMod.prefix("block/etched_nagastone_left"), TwilightForestMod.prefix("block/stone_tiles"), TwilightForestMod.prefix("block/nagastone_bare"));
        this.stairsBlock((StairsBlock)TFBlocks.nagastone_stairs_right.get(), TwilightForestMod.prefix("block/etched_nagastone_right"), TwilightForestMod.prefix("block/stone_tiles"), TwilightForestMod.prefix("block/nagastone_bare"));
        this.stairsBlock((StairsBlock)TFBlocks.nagastone_stairs_mossy_left.get(), TwilightForestMod.prefix("block/etched_nagastone_left_mossy"), TwilightForestMod.prefix("block/stone_tiles_mossy"), TwilightForestMod.prefix("block/nagastone_bare_mossy"));
        this.stairsBlock((StairsBlock)TFBlocks.nagastone_stairs_mossy_right.get(), TwilightForestMod.prefix("block/etched_nagastone_right_mossy"), TwilightForestMod.prefix("block/stone_tiles_mossy"), TwilightForestMod.prefix("block/nagastone_bare_mossy"));
        this.stairsBlock((StairsBlock)TFBlocks.nagastone_stairs_weathered_left.get(), TwilightForestMod.prefix("block/etched_nagastone_left_weathered"), TwilightForestMod.prefix("block/stone_tiles_weathered"), TwilightForestMod.prefix("block/nagastone_bare_weathered"));
        this.stairsBlock((StairsBlock)TFBlocks.nagastone_stairs_weathered_right.get(), TwilightForestMod.prefix("block/etched_nagastone_right_weathered"), TwilightForestMod.prefix("block/stone_tiles_weathered"), TwilightForestMod.prefix("block/nagastone_bare_weathered"));
    }
    
    private void nagastonePillar(final Block b, final String suffix) {
        final ResourceLocation side = TwilightForestMod.prefix("block/nagastone_pillar_side" + suffix);
        final ResourceLocation end = TwilightForestMod.prefix("block/nagastone_pillar_end" + suffix);
        final ResourceLocation alt = TwilightForestMod.prefix("block/nagastone_pillar_side" + suffix + "_alt");
        final ModelFile model = (ModelFile)this.models().cubeColumn(b.getRegistryName().func_110623_a(), side, end);
        final ModelFile reversed = (ModelFile)this.models().cubeColumn(b.getRegistryName().func_110623_a() + "_reversed", alt, end);
        this.getVariantBuilder(b).forAllStates(state -> {
            int rotX = 0;
            int rotY = 0;
            switch ((Direction.Axis)state.func_177229_b((Property)RotatedPillarBlock.field_176298_M)) {
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
            final ModelFile m = state.func_177229_b((Property)DirectionalRotatedPillarBlock.REVERSED) ? reversed : model;
            return ConfiguredModel.builder().rotationX(rotX).rotationY(rotY).modelFile(m).build();
        });
    }
    
    private void etchedNagastone(final Block b, final String suffix) {
        final ResourceLocation stoneTiles = TwilightForestMod.prefix("block/stone_tiles" + suffix);
        final ResourceLocation upTex = TwilightForestMod.prefix("block/etched_nagastone_up" + suffix);
        final ResourceLocation downTex = TwilightForestMod.prefix("block/etched_nagastone_down" + suffix);
        final ResourceLocation rightTex = TwilightForestMod.prefix("block/etched_nagastone_right" + suffix);
        final ResourceLocation leftTex = TwilightForestMod.prefix("block/etched_nagastone_left" + suffix);
        final ModelFile down = (ModelFile)this.models().cubeColumn(b.getRegistryName().func_110623_a(), downTex, stoneTiles);
        final ModelFile up = (ModelFile)this.models().cubeColumn(b.getRegistryName().func_110623_a() + "_up", upTex, stoneTiles);
        final ModelFile north = (ModelFile)((BlockModelBuilder)this.models().cube(b.getRegistryName().func_110623_a() + "_north", upTex, upTex, stoneTiles, stoneTiles, rightTex, leftTex)).texture("particle", "#down");
        final ModelFile south = (ModelFile)((BlockModelBuilder)this.models().cube(b.getRegistryName().func_110623_a() + "_south", downTex, downTex, stoneTiles, stoneTiles, leftTex, rightTex)).texture("particle", "#down");
        final ModelFile west = (ModelFile)((BlockModelBuilder)this.models().cube(b.getRegistryName().func_110623_a() + "_west", leftTex, rightTex, rightTex, leftTex, stoneTiles, stoneTiles)).texture("particle", "#down");
        final ModelFile east = (ModelFile)((BlockModelBuilder)this.models().cube(b.getRegistryName().func_110623_a() + "_east", rightTex, leftTex, leftTex, rightTex, stoneTiles, stoneTiles)).texture("particle", "#down");
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.DOWN).setModels(new ConfiguredModel[] { new ConfiguredModel(down) });
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.UP).setModels(new ConfiguredModel[] { new ConfiguredModel(up) });
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.NORTH).setModels(new ConfiguredModel[] { new ConfiguredModel(north) });
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.SOUTH).setModels(new ConfiguredModel[] { new ConfiguredModel(south) });
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.WEST).setModels(new ConfiguredModel[] { new ConfiguredModel(west) });
        this.getVariantBuilder(b).partialState().with((Property)DirectionalBlock.field_176387_N, (Comparable)Direction.EAST).setModels(new ConfiguredModel[] { new ConfiguredModel(east) });
    }
    
    private void casketStuff() {
        ((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("casket_obsidian", TwilightForestMod.prefix("block/casket_solid_template"))).texture("top", new ResourceLocation("block/obsidian"))).texture("side", new ResourceLocation("block/obsidian"));
        ((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("casket_stone", TwilightForestMod.prefix("block/casket_solid_template"))).texture("top", new ResourceLocation("block/stone"))).texture("side", new ResourceLocation("block/stone"));
        ((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent("casket_basalt", TwilightForestMod.prefix("block/casket_solid_template"))).texture("top", new ResourceLocation("block/basalt_top"))).texture("side", new ResourceLocation("block/basalt_side"));
    }
    
    private void registerSmokersAndJets() {
        this.simpleBlock((Block)TFBlocks.smoker.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/jet"))) });
        this.simpleBlock((Block)TFBlocks.fire_jet.get(), new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/jet"))) });
        final ModelFile smokerOff = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.encased_smoker.getId().func_110623_a(), TwilightForestMod.prefix("block/util/cube_bottom_top_3_layer"))).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_off"))).texture("side", TwilightForestMod.prefix("block/towerdev_smoker_off"))).texture("bottom", this.blockTexture((Block)TFBlocks.tower_wood_encased.get()))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_smoker_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_smoker_off_1"));
        final ModelFile smokerOn = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.encased_smoker.getId().func_110623_a() + "_on", TwilightForestMod.prefix("block/util/cube_bottom_top_3_layer"))).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_on"))).texture("side", TwilightForestMod.prefix("block/towerdev_firejet_on"))).texture("bottom", this.blockTexture((Block)TFBlocks.tower_wood_encased.get()))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_on_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_smoker_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_3/towerdev_ghasttraplid_on_2"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_smoker_on_1"));
        this.getVariantBuilder((Block)TFBlocks.encased_smoker.get()).partialState().with((Property)EncasedSmokerBlock.ACTIVE, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(smokerOff) });
        this.getVariantBuilder((Block)TFBlocks.encased_smoker.get()).partialState().with((Property)EncasedSmokerBlock.ACTIVE, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(smokerOn) });
        final ModelFile encasedJetOff = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.encased_fire_jet.getId().func_110623_a(), TwilightForestMod.prefix("block/util/cube_bottom_top_3_layer"))).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_off"))).texture("side", TwilightForestMod.prefix("block/towerdev_firejet_off"))).texture("bottom", this.blockTexture((Block)TFBlocks.tower_wood_encased.get()))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_firejet_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_firejet_off_1"));
        final ModelFile encasedJetOn = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.encased_fire_jet.getId().func_110623_a() + "_on", TwilightForestMod.prefix("block/util/cube_bottom_top_3_layer"))).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_on"))).texture("side", TwilightForestMod.prefix("block/towerdev_firejet_on"))).texture("bottom", this.blockTexture((Block)TFBlocks.tower_wood_encased.get()))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_on_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_firejet_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_3/towerdev_ghasttraplid_on_2"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_firejet_on_1"));
        this.getVariantBuilder((Block)TFBlocks.encased_fire_jet.get()).partialState().with((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.IDLE).setModels(new ConfiguredModel[] { new ConfiguredModel(encasedJetOff) });
        this.getVariantBuilder((Block)TFBlocks.encased_fire_jet.get()).partialState().with((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.POPPING).setModels(new ConfiguredModel[] { new ConfiguredModel(encasedJetOn) });
        this.getVariantBuilder((Block)TFBlocks.encased_fire_jet.get()).partialState().with((Property)FireJetBlock.STATE, (Comparable)FireJetVariant.FLAME).setModels(new ConfiguredModel[] { new ConfiguredModel(encasedJetOn) });
    }
    
    private void registerPlantBlocks() {
        this.simpleBlockExisting((Block)TFBlocks.moss_patch.get());
        this.simpleBlockExisting((Block)TFBlocks.mayapple.get());
        final ConfiguredModel[] cloverModels = new ConfiguredModel[4];
        for (int i = 0; i < 4; ++i) {
            final ModelFile model = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.clover_patch.getId().func_110623_a() + "_" + i, TwilightForestMod.prefix("block/util/flat_tex"))).texture("particle", TwilightForestMod.prefix("block/cloverpatch"))).texture("texture", TwilightForestMod.prefix("block/patch/clover_" + i))).texture("ctm", TwilightForestMod.prefix("block/patch/clover_" + i + "_ctm"));
            cloverModels[i] = new ConfiguredModel(model);
        }
        this.simpleBlock((Block)TFBlocks.clover_patch.get(), cloverModels);
        this.simpleBlock((Block)TFBlocks.fiddlehead.get(), (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.fiddlehead.getId().func_110623_a(), "block/tinted_cross")).texture("cross", this.blockTexture((Block)TFBlocks.fiddlehead.get())));
        this.simpleBlock((Block)TFBlocks.mushgloom.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.mushgloom.getId().func_110623_a(), TwilightForestMod.prefix("block/util/cross_2_layer"))).texture("cross", this.blockTexture((Block)TFBlocks.mushgloom.get()))).texture("cross2", TwilightForestMod.prefix("block/" + TFBlocks.mushgloom.getId().func_110623_a() + "_head")));
        this.simpleBlock((Block)TFBlocks.torchberry_plant.get(), (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.torchberry_plant.getId().func_110623_a(), TwilightForestMod.prefix("block/util/cross_2_layer"))).texture("cross", this.blockTexture((Block)TFBlocks.torchberry_plant.get()))).texture("cross2", TwilightForestMod.prefix("block/" + TFBlocks.torchberry_plant.getId().func_110623_a() + "_glow")));
        this.simpleBlockExisting((Block)TFBlocks.root_strand.get());
        this.simpleBlockExisting((Block)TFBlocks.fallen_leaves.get());
    }
    
    private void registerWoodBlocks() {
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.oak_log.get(), (RotatedPillarBlock)TFBlocks.stripped_oak_log.get(), (RotatedPillarBlock)TFBlocks.oak_wood.get(), (RotatedPillarBlock)TFBlocks.stripped_oak_wood.get(), (Block)TFBlocks.oak_sapling.get());
        this.plankBlocks("twilight_oak", (Block)TFBlocks.twilight_oak_planks.get(), (Block)TFBlocks.twilight_oak_slab.get(), (StairsBlock)TFBlocks.twilight_oak_stairs.get(), (Block)TFBlocks.twilight_oak_button.get(), (Block)TFBlocks.twilight_oak_fence.get(), (Block)TFBlocks.twilight_oak_gate.get(), (Block)TFBlocks.twilight_oak_plate.get(), (DoorBlock)TFBlocks.twilight_oak_door.get(), (TrapDoorBlock)TFBlocks.twilight_oak_trapdoor.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.oak_leaves.get(), "block/leaves", m -> {
            final BlockModelBuilder blockModelBuilder = (BlockModelBuilder)m.texture("all", "minecraft:block/oak_leaves");
            return;
        });
        final ResourceLocation rainboakSaplTex = TwilightForestMod.prefix("block/" + TFBlocks.rainboak_sapling.getId().func_110623_a());
        this.simpleBlock((Block)TFBlocks.rainboak_sapling.get(), (ModelFile)this.models().cross(TFBlocks.rainboak_sapling.getId().func_110623_a(), rainboakSaplTex));
        this.singleBlockBoilerPlate((Block)TFBlocks.rainboak_leaves.get(), "block/leaves", m -> {
            final BlockModelBuilder blockModelBuilder2 = (BlockModelBuilder)m.texture("all", "minecraft:block/oak_leaves");
            return;
        });
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.canopy_log.get(), (RotatedPillarBlock)TFBlocks.stripped_canopy_log.get(), (RotatedPillarBlock)TFBlocks.canopy_wood.get(), (RotatedPillarBlock)TFBlocks.stripped_canopy_wood.get(), (Block)TFBlocks.canopy_sapling.get());
        this.plankBlocks("canopy", (Block)TFBlocks.canopy_planks.get(), (Block)TFBlocks.canopy_slab.get(), (StairsBlock)TFBlocks.canopy_stairs.get(), (Block)TFBlocks.canopy_button.get(), (Block)TFBlocks.canopy_fence.get(), (Block)TFBlocks.canopy_gate.get(), (Block)TFBlocks.canopy_plate.get(), (DoorBlock)TFBlocks.canopy_door.get(), (TrapDoorBlock)TFBlocks.canopy_trapdoor.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.canopy_leaves.get(), "block/leaves", m -> {
            final BlockModelBuilder blockModelBuilder3 = (BlockModelBuilder)m.texture("all", "minecraft:block/spruce_leaves");
            return;
        });
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.mangrove_log.get(), (RotatedPillarBlock)TFBlocks.stripped_mangrove_log.get(), (RotatedPillarBlock)TFBlocks.mangrove_wood.get(), (RotatedPillarBlock)TFBlocks.stripped_mangrove_wood.get(), (Block)TFBlocks.mangrove_sapling.get());
        this.plankBlocks("mangrove", (Block)TFBlocks.mangrove_planks.get(), (Block)TFBlocks.mangrove_slab.get(), (StairsBlock)TFBlocks.mangrove_stairs.get(), (Block)TFBlocks.mangrove_button.get(), (Block)TFBlocks.mangrove_fence.get(), (Block)TFBlocks.mangrove_gate.get(), (Block)TFBlocks.mangrove_plate.get(), (DoorBlock)TFBlocks.mangrove_door.get(), (TrapDoorBlock)TFBlocks.mangrove_trapdoor.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.mangrove_leaves.get(), "block/leaves", m -> {
            final BlockModelBuilder blockModelBuilder4 = (BlockModelBuilder)m.texture("all", "minecraft:block/birch_leaves");
            return;
        });
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.dark_log.get(), (RotatedPillarBlock)TFBlocks.stripped_dark_log.get(), (RotatedPillarBlock)TFBlocks.dark_wood.get(), (RotatedPillarBlock)TFBlocks.stripped_dark_wood.get(), (Block)TFBlocks.darkwood_sapling.get());
        this.plankBlocks("darkwood", (Block)TFBlocks.dark_planks.get(), (Block)TFBlocks.dark_slab.get(), (StairsBlock)TFBlocks.dark_stairs.get(), (Block)TFBlocks.dark_button.get(), (Block)TFBlocks.dark_fence.get(), (Block)TFBlocks.dark_gate.get(), (Block)TFBlocks.dark_plate.get(), (DoorBlock)TFBlocks.dark_door.get(), (TrapDoorBlock)TFBlocks.dark_trapdoor.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.dark_leaves.get(), "block/leaves", m -> {
            final BlockModelBuilder blockModelBuilder5 = (BlockModelBuilder)m.texture("all", "block/darkwood_leaves");
            return;
        });
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.time_log.get(), (RotatedPillarBlock)TFBlocks.stripped_time_log.get(), (RotatedPillarBlock)TFBlocks.time_wood.get(), (RotatedPillarBlock)TFBlocks.stripped_time_wood.get(), (Block)TFBlocks.time_sapling.get());
        this.plankBlocks("time", (Block)TFBlocks.time_planks.get(), (Block)TFBlocks.time_slab.get(), (StairsBlock)TFBlocks.time_stairs.get(), (Block)TFBlocks.time_button.get(), (Block)TFBlocks.time_fence.get(), (Block)TFBlocks.time_gate.get(), (Block)TFBlocks.time_plate.get(), (DoorBlock)TFBlocks.time_door.get(), (TrapDoorBlock)TFBlocks.time_trapdoor.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.time_leaves.get(), "block/leaves", m -> {
            final BlockModelBuilder blockModelBuilder6 = (BlockModelBuilder)m.texture("all", "block/time_leaves");
            return;
        });
        this.magicLogCore((Block)TFBlocks.time_log_core.get());
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.transformation_log.get(), (RotatedPillarBlock)TFBlocks.stripped_transformation_log.get(), (RotatedPillarBlock)TFBlocks.transformation_wood.get(), (RotatedPillarBlock)TFBlocks.stripped_transformation_wood.get(), (Block)TFBlocks.transformation_sapling.get());
        this.plankBlocks("trans", (Block)TFBlocks.trans_planks.get(), (Block)TFBlocks.trans_slab.get(), (StairsBlock)TFBlocks.trans_stairs.get(), (Block)TFBlocks.trans_button.get(), (Block)TFBlocks.trans_fence.get(), (Block)TFBlocks.trans_gate.get(), (Block)TFBlocks.trans_plate.get(), (DoorBlock)TFBlocks.trans_door.get(), (TrapDoorBlock)TFBlocks.trans_trapdoor.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.transformation_leaves.get(), "block/leaves", m -> {
            final BlockModelBuilder blockModelBuilder7 = (BlockModelBuilder)m.texture("all", "block/transformation_leaves");
            return;
        });
        this.magicLogCore((Block)TFBlocks.transformation_log_core.get());
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.mining_log.get(), (RotatedPillarBlock)TFBlocks.stripped_mining_log.get(), (RotatedPillarBlock)TFBlocks.mining_wood.get(), (RotatedPillarBlock)TFBlocks.stripped_mining_wood.get(), (Block)TFBlocks.mining_sapling.get());
        this.plankBlocks("mine", (Block)TFBlocks.mine_planks.get(), (Block)TFBlocks.mine_slab.get(), (StairsBlock)TFBlocks.mine_stairs.get(), (Block)TFBlocks.mine_button.get(), (Block)TFBlocks.mine_fence.get(), (Block)TFBlocks.mine_gate.get(), (Block)TFBlocks.mine_plate.get(), (DoorBlock)TFBlocks.mine_door.get(), (TrapDoorBlock)TFBlocks.mine_trapdoor.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.mining_leaves.get(), "block/leaves", m -> {
            final BlockModelBuilder blockModelBuilder8 = (BlockModelBuilder)m.texture("all", "block/mining_leaves");
            return;
        });
        this.magicLogCore((Block)TFBlocks.mining_log_core.get());
        this.logWoodSapling((RotatedPillarBlock)TFBlocks.sorting_log.get(), (RotatedPillarBlock)TFBlocks.stripped_sorting_log.get(), (RotatedPillarBlock)TFBlocks.sorting_wood.get(), (RotatedPillarBlock)TFBlocks.stripped_sorting_wood.get(), (Block)TFBlocks.sorting_sapling.get());
        this.plankBlocks("sort", (Block)TFBlocks.sort_planks.get(), (Block)TFBlocks.sort_slab.get(), (StairsBlock)TFBlocks.sort_stairs.get(), (Block)TFBlocks.sort_button.get(), (Block)TFBlocks.sort_fence.get(), (Block)TFBlocks.sort_gate.get(), (Block)TFBlocks.sort_plate.get(), (DoorBlock)TFBlocks.sort_door.get(), (TrapDoorBlock)TFBlocks.sort_trapdoor.get());
        this.singleBlockBoilerPlate((Block)TFBlocks.sorting_leaves.get(), "block/leaves", m -> {
            final BlockModelBuilder blockModelBuilder9 = (BlockModelBuilder)m.texture("all", "block/sorting_leaves");
            return;
        });
        this.magicLogCore((Block)TFBlocks.sorting_log_core.get());
    }
    
    private void magicLogCore(final Block b) {
        final ResourceLocation topTex = TwilightForestMod.prefix("block/" + b.getRegistryName().func_110623_a().replace("_core", "_top"));
        final ModelFile off = (ModelFile)this.models().cubeColumn(b.getRegistryName().func_110623_a(), this.blockTexture(b), topTex);
        final ModelFile on = (ModelFile)this.models().cubeColumn(b.getRegistryName().func_110623_a() + "_on", TwilightForestMod.prefix("block/" + b.getRegistryName().func_110623_a() + "_on"), topTex);
        this.getVariantBuilder(b).forAllStates(s -> {
            final ModelFile f = s.func_177229_b((Property)SpecialMagicLogBlock.ACTIVE) ? on : off;
            final Direction.Axis axis = (Direction.Axis)s.func_177229_b((Property)RotatedPillarBlock.field_176298_M);
            final int rotX = (axis == Direction.Axis.X || axis == Direction.Axis.Z) ? 90 : 0;
            final int rotY = (axis == Direction.Axis.X) ? 90 : 0;
            return ConfiguredModel.builder().modelFile(f).rotationX(rotX).rotationY(rotY).build();
        });
    }
    
    private void rotationallyCorrectColumn(final Block b) {
        final ResourceLocation side = TwilightForestMod.prefix("block/" + b.getRegistryName().func_110623_a() + "_side");
        final ResourceLocation end = TwilightForestMod.prefix("block/" + b.getRegistryName().func_110623_a() + "_end");
        final ConfiguredModel yModel = new ConfiguredModel((ModelFile)this.models().cubeColumn(b.getRegistryName().func_110623_a(), side, end));
        final ConfiguredModel xModel = ConfiguredModel.builder().modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(b.getRegistryName().func_110623_a() + "_x", TwilightForestMod.prefix("block/util/cube_column_rotationally_correct_x"))).texture("side", side)).texture("end", end)).rotationX(90).rotationY(90).buildLast();
        final ConfiguredModel zModel = ConfiguredModel.builder().modelFile((ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(b.getRegistryName().func_110623_a() + "_z", TwilightForestMod.prefix("block/util/cube_column_rotationally_correct_z"))).texture("side", side)).texture("end", end)).rotationX(90).buildLast();
        this.getVariantBuilder(b).partialState().with((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Y).setModels(new ConfiguredModel[] { yModel }).partialState().with((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.X).setModels(new ConfiguredModel[] { xModel }).partialState().with((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Z).setModels(new ConfiguredModel[] { zModel });
    }
    
    private void castleDoor(final Block b) {
        final ModelFile overlay = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/castle_door_overlay"));
        final ModelFile main = (ModelFile)this.models().cubeAll(b.getRegistryName().func_110623_a(), TwilightForestMod.prefix("block/castle_door"));
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
        this.simpleBlock(b, (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().getBuilder(b.getRegistryName().func_110623_a())).parent((ModelFile)new ModelFile.UncheckedModelFile("builtin/entity"))).texture("particle", particle));
    }
    
    private void simpleBlockExisting(final Block b) {
        this.simpleBlock(b, new ConfiguredModel[] { new ConfiguredModel((ModelFile)this.models().getExistingFile(TwilightForestMod.prefix(b.getRegistryName().func_110623_a()))) });
    }
    
    private void singleBlockBoilerPlate(final Block b, final String parent, final Consumer<BlockModelBuilder> modelCustomizer) {
        final BlockModelBuilder bModel = (BlockModelBuilder)this.models().withExistingParent(b.getRegistryName().func_110623_a(), parent);
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
        this.simpleBlock(b, ConfiguredModel.builder().modelFile((ModelFile)this.cubeAllTinted(b.getRegistryName().func_110623_a(), b.getRegistryName().func_110623_a())).nextModel().modelFile((ModelFile)this.cubeAllTinted(b.getRegistryName().func_110623_a() + "_flipped", b.getRegistryName().func_110623_a(), true)).build());
    }
    
    private void logWoodSapling(final RotatedPillarBlock log, final RotatedPillarBlock slog, final RotatedPillarBlock wood, final RotatedPillarBlock swood, final Block sapling) {
        this.logBlock(log);
        this.logBlock(slog);
        final ResourceLocation sideTex = this.blockTexture((Block)log);
        this.axisBlock(wood, sideTex, sideTex);
        final ResourceLocation sSideTex = this.blockTexture((Block)slog);
        this.axisBlock(swood, sSideTex, sSideTex);
        final ResourceLocation saplingTex = TwilightForestMod.prefix("block/" + sapling.getRegistryName().func_110623_a());
        this.simpleBlock(sapling, (ModelFile)this.models().cross(sapling.getRegistryName().func_110623_a(), saplingTex));
    }
    
    private void plankBlocks(final String variant, final Block plank, final Block slab, final StairsBlock stair, final Block button, final Block fence, final Block gate, final Block plate, final DoorBlock door, final TrapDoorBlock trapdoor) {
        final String plankTexName = "planks_" + variant;
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + plankTexName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + plankTexName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + plankTexName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + plankTexName + "_3");
        final ConfiguredModel[] plankModels = ConfiguredModel.builder().weight(10).modelFile((ModelFile)this.models().cubeAll(plank.getRegistryName().func_110623_a(), tex0)).nextModel().weight(10).modelFile((ModelFile)this.models().cubeAll(plank.getRegistryName().func_110623_a() + "_1", tex2)).nextModel().weight(1).modelFile((ModelFile)this.models().cubeAll(plank.getRegistryName().func_110623_a() + "_2", tex3)).nextModel().weight(1).modelFile((ModelFile)this.models().cubeAll(plank.getRegistryName().func_110623_a() + "_3", tex4)).build();
        this.simpleBlock(plank, plankModels);
        final ConfiguredModel[] bottomSlabModels = ConfiguredModel.builder().weight(10).modelFile((ModelFile)this.models().slab(slab.getRegistryName().func_110623_a(), tex0, tex0, tex0)).nextModel().weight(10).modelFile((ModelFile)this.models().slab(slab.getRegistryName().func_110623_a() + "_1", tex2, tex2, tex2)).nextModel().weight(1).modelFile((ModelFile)this.models().slab(slab.getRegistryName().func_110623_a() + "_2", tex3, tex3, tex3)).nextModel().weight(1).modelFile((ModelFile)this.models().slab(slab.getRegistryName().func_110623_a() + "_3", tex4, tex4, tex4)).build();
        final ConfiguredModel[] topSlabModels = ConfiguredModel.builder().weight(10).uvLock(true).rotationX(180).modelFile(bottomSlabModels[0].model).nextModel().weight(10).uvLock(true).rotationX(180).modelFile(bottomSlabModels[1].model).nextModel().weight(1).uvLock(true).rotationX(180).modelFile(bottomSlabModels[2].model).nextModel().weight(1).uvLock(true).rotationX(180).modelFile(bottomSlabModels[3].model).build();
        this.getVariantBuilder(slab).partialState().with((Property)SlabBlock.field_196505_a, (Comparable)SlabType.BOTTOM).setModels(bottomSlabModels);
        this.getVariantBuilder(slab).partialState().with((Property)SlabBlock.field_196505_a, (Comparable)SlabType.TOP).setModels(topSlabModels);
        this.getVariantBuilder(slab).partialState().with((Property)SlabBlock.field_196505_a, (Comparable)SlabType.DOUBLE).setModels(plankModels);
        this.woodStairs(stair, plankTexName);
        this.woodButton(button, plankTexName);
        this.woodFence(fence, plankTexName);
        this.woodGate(gate, plankTexName);
        this.woodPlate(plate, plankTexName);
        this.doorBlock(door, TwilightForestMod.prefix("block/wood/door/" + variant + "_lower"), TwilightForestMod.prefix("block/wood/door/" + variant + "_upper"));
        this.trapdoorBlock(trapdoor, TwilightForestMod.prefix("block/wood/trapdoor/" + variant + "_trapdoor"), true);
    }
    
    private void woodGate(final Block gate, final String texName) {
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + texName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + texName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + texName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + texName + "_3");
        final ModelFile gate2 = (ModelFile)this.models().fenceGate(gate.getRegistryName().func_110623_a(), tex0);
        final ModelFile gate3 = (ModelFile)this.models().fenceGate(gate.getRegistryName().func_110623_a() + "_1", tex2);
        final ModelFile gate4 = (ModelFile)this.models().fenceGate(gate.getRegistryName().func_110623_a() + "_2", tex3);
        final ModelFile gate5 = (ModelFile)this.models().fenceGate(gate.getRegistryName().func_110623_a() + "_3", tex4);
        final ModelFile open0 = (ModelFile)this.models().fenceGateOpen(gate.getRegistryName().func_110623_a() + "_open", tex0);
        final ModelFile open2 = (ModelFile)this.models().fenceGateOpen(gate.getRegistryName().func_110623_a() + "_open_1", tex2);
        final ModelFile open3 = (ModelFile)this.models().fenceGateOpen(gate.getRegistryName().func_110623_a() + "_open_2", tex3);
        final ModelFile open4 = (ModelFile)this.models().fenceGateOpen(gate.getRegistryName().func_110623_a() + "_open_3", tex4);
        final ModelFile wall0 = (ModelFile)this.models().fenceGateWall(gate.getRegistryName().func_110623_a() + "_wall", tex0);
        final ModelFile wall2 = (ModelFile)this.models().fenceGateWall(gate.getRegistryName().func_110623_a() + "_wall_1", tex2);
        final ModelFile wall3 = (ModelFile)this.models().fenceGateWall(gate.getRegistryName().func_110623_a() + "_wall_2", tex3);
        final ModelFile wall4 = (ModelFile)this.models().fenceGateWall(gate.getRegistryName().func_110623_a() + "_wall_3", tex4);
        final ModelFile wallOpen0 = (ModelFile)this.models().fenceGateWallOpen(gate.getRegistryName().func_110623_a() + "_wall_open", tex0);
        final ModelFile wallOpen2 = (ModelFile)this.models().fenceGateWallOpen(gate.getRegistryName().func_110623_a() + "_wall_open_1", tex2);
        final ModelFile wallOpen3 = (ModelFile)this.models().fenceGateWallOpen(gate.getRegistryName().func_110623_a() + "_wall_open_2", tex3);
        final ModelFile wallOpen4 = (ModelFile)this.models().fenceGateWallOpen(gate.getRegistryName().func_110623_a() + "_wall_open_3", tex4);
        this.getVariantBuilder(gate).forAllStatesExcept(state -> {
            ModelFile model0 = gate0;
            ModelFile model2 = gate1;
            ModelFile model3 = gate2;
            ModelFile model4 = gate3;
            if (state.func_177229_b((Property)FenceGateBlock.field_176467_M)) {
                model0 = wall0;
                model2 = wall1;
                model3 = wall2;
                model4 = wall3;
            }
            if (state.func_177229_b((Property)FenceGateBlock.field_176466_a)) {
                model0 = ((model0 == wall0) ? wallOpen0 : open0);
                model2 = ((model2 == wall1) ? wallOpen1 : open1);
                model3 = ((model3 == wall2) ? wallOpen2 : open2);
                model4 = ((model4 == wall3) ? wallOpen3 : open3);
            }
            return ConfiguredModel.builder().weight(10).modelFile(model0).rotationY((int)((Direction)state.func_177229_b((Property)HorizontalBlock.field_185512_D)).func_185119_l()).uvLock(true).nextModel().weight(10).modelFile(model2).rotationY((int)((Direction)state.func_177229_b((Property)HorizontalBlock.field_185512_D)).func_185119_l()).uvLock(true).nextModel().weight(1).modelFile(model3).rotationY((int)((Direction)state.func_177229_b((Property)HorizontalBlock.field_185512_D)).func_185119_l()).uvLock(true).nextModel().weight(1).modelFile(model4).rotationY((int)((Direction)state.func_177229_b((Property)HorizontalBlock.field_185512_D)).func_185119_l()).uvLock(true).build();
        }, new Property[] { (Property)FenceGateBlock.field_176465_b });
    }
    
    private void woodFence(final Block fence, final String texName) {
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + texName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + texName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + texName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + texName + "_3");
        final ModelFile post0 = (ModelFile)this.models().fencePost(fence.getRegistryName().func_110623_a() + "_post", tex0);
        final ModelFile post2 = (ModelFile)this.models().fencePost(fence.getRegistryName().func_110623_a() + "_post_1", tex2);
        final ModelFile post3 = (ModelFile)this.models().fencePost(fence.getRegistryName().func_110623_a() + "_post_2", tex3);
        final ModelFile post4 = (ModelFile)this.models().fencePost(fence.getRegistryName().func_110623_a() + "_post_3", tex4);
        final ModelFile side0 = (ModelFile)this.models().fenceSide(fence.getRegistryName().func_110623_a() + "_side", tex0);
        final ModelFile side2 = (ModelFile)this.models().fenceSide(fence.getRegistryName().func_110623_a() + "_side_1", tex2);
        final ModelFile side3 = (ModelFile)this.models().fenceSide(fence.getRegistryName().func_110623_a() + "_side_2", tex3);
        final ModelFile side4 = (ModelFile)this.models().fenceSide(fence.getRegistryName().func_110623_a() + "_side_3", tex4);
        final MultiPartBlockStateBuilder builder = ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(fence).part().weight(10).modelFile(post0).nextModel().weight(10).modelFile(post2).nextModel().weight(1).modelFile(post3).nextModel().weight(1).modelFile(post4).addModel()).end();
        SixWayBlock.field_196491_B.forEach((dir, value) -> {
            if (dir.func_176740_k().func_176722_c()) {
                ((MultiPartBlockStateBuilder.PartBuilder)builder.part().weight(10).modelFile(side0).rotationY(((int)dir.func_185119_l() + 180) % 360).uvLock(true).nextModel().weight(10).modelFile(side1).rotationY(((int)dir.func_185119_l() + 180) % 360).uvLock(true).nextModel().weight(1).modelFile(side2).rotationY(((int)dir.func_185119_l() + 180) % 360).uvLock(true).nextModel().weight(1).modelFile(side3).rotationY(((int)dir.func_185119_l() + 180) % 360).uvLock(true).addModel()).condition((Property)value, (Comparable[])new Boolean[] { true });
            }
        });
    }
    
    private void woodPlate(final Block plate, final String texName) {
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + texName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + texName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + texName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + texName + "_3");
        final ConfiguredModel[] unpressed = ConfiguredModel.builder().weight(10).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().func_110623_a(), "pressure_plate_up")).texture("texture", tex0)).nextModel().weight(10).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().func_110623_a() + "_1", "pressure_plate_up")).texture("texture", tex2)).nextModel().weight(1).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().func_110623_a() + "_2", "pressure_plate_up")).texture("texture", tex3)).nextModel().weight(1).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().func_110623_a() + "_3", "pressure_plate_up")).texture("texture", tex4)).build();
        final ConfiguredModel[] pressed = ConfiguredModel.builder().weight(10).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().func_110623_a() + "_down", "pressure_plate_down")).texture("texture", tex0)).nextModel().weight(10).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().func_110623_a() + "_down_1", "pressure_plate_down")).texture("texture", tex2)).nextModel().weight(1).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().func_110623_a() + "_down_2", "pressure_plate_down")).texture("texture", tex3)).nextModel().weight(1).modelFile((ModelFile)((BlockModelBuilder)this.models().withExistingParent(plate.getRegistryName().func_110623_a() + "_down_3", "pressure_plate_down")).texture("texture", tex4)).build();
        this.getVariantBuilder(plate).partialState().with((Property)PressurePlateBlock.field_176580_a, (Comparable)false).setModels(unpressed);
        this.getVariantBuilder(plate).partialState().with((Property)PressurePlateBlock.field_176580_a, (Comparable)true).setModels(pressed);
    }
    
    private void woodButton(final Block button, final String texName) {
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + texName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + texName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + texName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + texName + "_3");
        final ModelFile unpressed0 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().func_110623_a(), "button")).texture("texture", tex0);
        final ModelFile pressed0 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().func_110623_a() + "_pressed", "button_pressed")).texture("texture", tex0);
        final ModelFile unpressed2 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().func_110623_a() + "_1", "button")).texture("texture", tex2);
        final ModelFile pressed2 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().func_110623_a() + "_pressed_1", "button_pressed")).texture("texture", tex2);
        final ModelFile unpressed3 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().func_110623_a() + "_2", "button")).texture("texture", tex3);
        final ModelFile pressed3 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().func_110623_a() + "_pressed_2", "button_pressed")).texture("texture", tex3);
        final ModelFile unpressed4 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().func_110623_a() + "_3", "button")).texture("texture", tex4);
        final ModelFile pressed4 = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(button.getRegistryName().func_110623_a() + "_pressed_3", "button_pressed")).texture("texture", tex4);
        this.getVariantBuilder(button).forAllStates(state -> {
            final ModelFile model0 = state.func_177229_b((Property)AbstractButtonBlock.field_176584_b) ? pressed0 : unpressed0;
            final ModelFile model2 = state.func_177229_b((Property)AbstractButtonBlock.field_176584_b) ? pressed1 : unpressed1;
            final ModelFile model3 = state.func_177229_b((Property)AbstractButtonBlock.field_176584_b) ? pressed2 : unpressed2;
            final ModelFile model4 = state.func_177229_b((Property)AbstractButtonBlock.field_176584_b) ? pressed3 : unpressed3;
            int rotX = 0;
            switch ((AttachFace)state.func_177229_b((Property)HorizontalFaceBlock.field_196366_M)) {
                case WALL: {
                    rotX = 90;
                    break;
                }
                case FLOOR: {
                    rotX = 0;
                    break;
                }
                case CEILING: {
                    rotX = 180;
                    break;
                }
            }
            int rotY = 0;
            if (state.func_177229_b((Property)HorizontalFaceBlock.field_196366_M) == AttachFace.CEILING) {
                switch ((Direction)state.func_177229_b((Property)HorizontalBlock.field_185512_D)) {
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
                switch ((Direction)state.func_177229_b((Property)HorizontalBlock.field_185512_D)) {
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
            final boolean uvlock = state.func_177229_b((Property)HorizontalFaceBlock.field_196366_M) == AttachFace.WALL;
            return ConfiguredModel.builder().weight(10).uvLock(uvlock).rotationX(rotX).rotationY(rotY).modelFile(model0).nextModel().weight(10).uvLock(uvlock).rotationX(rotX).rotationY(rotY).modelFile(model2).nextModel().weight(1).uvLock(uvlock).rotationX(rotX).rotationY(rotY).modelFile(model3).nextModel().weight(1).uvLock(uvlock).rotationX(rotX).rotationY(rotY).modelFile(model4).build();
        });
    }
    
    private void woodStairs(final StairsBlock block, final String texName) {
        final ResourceLocation tex0 = TwilightForestMod.prefix("block/wood/" + texName + "_0");
        final ResourceLocation tex2 = TwilightForestMod.prefix("block/wood/" + texName + "_1");
        final ResourceLocation tex3 = TwilightForestMod.prefix("block/wood/" + texName + "_2");
        final ResourceLocation tex4 = TwilightForestMod.prefix("block/wood/" + texName + "_3");
        final ModelFile main0 = (ModelFile)this.models().stairs(block.getRegistryName().func_110623_a(), tex0, tex0, tex0);
        final ModelFile main2 = (ModelFile)this.models().stairs(block.getRegistryName().func_110623_a() + "_1", tex2, tex2, tex2);
        final ModelFile main3 = (ModelFile)this.models().stairs(block.getRegistryName().func_110623_a() + "_2", tex3, tex3, tex3);
        final ModelFile main4 = (ModelFile)this.models().stairs(block.getRegistryName().func_110623_a() + "_3", tex4, tex4, tex4);
        final ModelFile inner0 = (ModelFile)this.models().stairsInner(block.getRegistryName().func_110623_a() + "_inner", tex0, tex0, tex0);
        final ModelFile inner2 = (ModelFile)this.models().stairsInner(block.getRegistryName().func_110623_a() + "_inner_1", tex2, tex2, tex2);
        final ModelFile inner3 = (ModelFile)this.models().stairsInner(block.getRegistryName().func_110623_a() + "_inner_2", tex3, tex3, tex3);
        final ModelFile inner4 = (ModelFile)this.models().stairsInner(block.getRegistryName().func_110623_a() + "_inner_3", tex4, tex4, tex4);
        final ModelFile outer0 = (ModelFile)this.models().stairsOuter(block.getRegistryName().func_110623_a() + "_outer", tex0, tex0, tex0);
        final ModelFile outer2 = (ModelFile)this.models().stairsOuter(block.getRegistryName().func_110623_a() + "_outer_1", tex2, tex2, tex2);
        final ModelFile outer3 = (ModelFile)this.models().stairsOuter(block.getRegistryName().func_110623_a() + "_outer_2", tex3, tex3, tex3);
        final ModelFile outer4 = (ModelFile)this.models().stairsOuter(block.getRegistryName().func_110623_a() + "_outer_3", tex4, tex4, tex4);
        this.getVariantBuilder((Block)block).forAllStatesExcept(state -> {
            final Direction facing = (Direction)state.func_177229_b((Property)StairsBlock.field_176309_a);
            final Half half = (Half)state.func_177229_b((Property)StairsBlock.field_176308_b);
            final StairsShape shape = (StairsShape)state.func_177229_b((Property)StairsBlock.field_176310_M);
            int yRot = (int)facing.func_176746_e().func_185119_l();
            if (shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT) {
                yRot += 270;
            }
            if (shape != StairsShape.STRAIGHT && half == Half.TOP) {
                yRot += 90;
            }
            final int yRot2 = yRot % 360;
            final boolean uvlock = yRot2 != 0 || half == Half.TOP;
            return ConfiguredModel.builder().weight(10).modelFile((shape == StairsShape.STRAIGHT) ? main0 : ((shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT) ? inner0 : outer0)).rotationX((half == Half.BOTTOM) ? 0 : 180).rotationY(yRot2).uvLock(uvlock).nextModel().weight(10).modelFile((shape == StairsShape.STRAIGHT) ? main1 : ((shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT) ? inner1 : outer1)).rotationX((half == Half.BOTTOM) ? 0 : 180).rotationY(yRot2).uvLock(uvlock).nextModel().weight(1).modelFile((shape == StairsShape.STRAIGHT) ? main2 : ((shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT) ? inner2 : outer2)).rotationX((half == Half.BOTTOM) ? 0 : 180).rotationY(yRot2).uvLock(uvlock).nextModel().weight(1).modelFile((shape == StairsShape.STRAIGHT) ? main3 : ((shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT) ? inner3 : outer3)).rotationX((half == Half.BOTTOM) ? 0 : 180).rotationY(yRot2).uvLock(uvlock).build();
        }, new Property[] { (Property)StairsBlock.field_204513_t });
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
        ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)TFBlocks.stone_twist_thin.get()).part().modelFile(main_x).uvLock(true).rotationX(90).rotationY(90).addModel()).condition((Property)WallPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).end().part().modelFile(top_x).rotationX(90).rotationY(90).addModel()).condition((Property)WallPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).condition((Property)SixWayBlock.field_196490_b, (Comparable[])new Boolean[] { false }).end().part().modelFile(bottom_x).rotationX(90).rotationY(90).addModel()).condition((Property)WallPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).condition((Property)SixWayBlock.field_196495_y, (Comparable[])new Boolean[] { false }).end().part().modelFile(main_y).uvLock(true).addModel()).condition((Property)WallPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).end().part().modelFile(top_y).addModel()).condition((Property)WallPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).condition((Property)SixWayBlock.field_196496_z, (Comparable[])new Boolean[] { false }).end().part().modelFile(bottom_y).addModel()).condition((Property)WallPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).condition((Property)SixWayBlock.field_196489_A, (Comparable[])new Boolean[] { false }).end().part().modelFile(main_z).uvLock(true).rotationX(90).addModel()).condition((Property)WallPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).end().part().modelFile(top_z).rotationX(90).addModel()).condition((Property)WallPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).condition((Property)SixWayBlock.field_196488_a, (Comparable[])new Boolean[] { false }).end().part().modelFile(bottom_z).rotationX(90).addModel()).condition((Property)WallPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).condition((Property)SixWayBlock.field_196492_c, (Comparable[])new Boolean[] { false }).end();
    }
    
    private void slider() {
        final ModelFile slider = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/slider"));
        final ModelFile horizSlider = (ModelFile)this.models().getExistingFile(TwilightForestMod.prefix("block/slider_horiz"));
        this.getVariantBuilder((Block)TFBlocks.slider.get()).forAllStates(state -> {
            switch ((Direction.Axis)state.func_177229_b((Property)SliderBlock.field_176298_M)) {
                case X: {
                    switch ((int)state.func_177229_b((Property)SliderBlock.DELAY)) {
                        default: {
                            return ConfiguredModel.builder().modelFile(horizSlider).rotationX(90).rotationY(90).build();
                        }
                    }
                    break;
                }
                default: {
                    switch ((int)state.func_177229_b((Property)SliderBlock.DELAY)) {
                        default: {
                            return ConfiguredModel.builder().modelFile(slider).build();
                        }
                    }
                    break;
                }
                case Z: {
                    switch ((int)state.func_177229_b((Property)SliderBlock.DELAY)) {
                        default: {
                            return ConfiguredModel.builder().modelFile(horizSlider).rotationX(90).build();
                        }
                    }
                    break;
                }
            }
        });
    }
    
    private void towerBlocks() {
        final ResourceLocation cube3 = TwilightForestMod.prefix("block/util/cube_all_3_layer");
        final ResourceLocation cubeBt3 = TwilightForestMod.prefix("block/util/cube_bottom_top_3_layer");
        final ResourceLocation cube2NoShade = TwilightForestMod.prefix("block/util/cube_all_2_layer_no_shade");
        final ResourceLocation fourCube = TwilightForestMod.prefix("block/util/4_cubed");
        final ModelFile reappear = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.reappearing_block.getId().func_110623_a(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_reappearing_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_reappearing_off_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_reappearing_off_2"));
        final ModelFile reappearActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.reappearing_block.getId().func_110623_a() + "_active", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_reappearing_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_reappearing_on_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_reappearing_on_2"));
        final ModelFile reappearVanished = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.reappearing_block.getId().func_110623_a() + "_vanished", fourCube)).texture("all", TwilightForestMod.prefix("block/towerdev_reappearing_trace_off"));
        final ModelFile reappearVanishedActive = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.reappearing_block.getId().func_110623_a() + "_vanished_active", fourCube)).texture("all", TwilightForestMod.prefix("block/towerdev_reappearing_trace_on"));
        this.getVariantBuilder((Block)TFBlocks.reappearing_block.get()).forAllStates(s -> {
            ModelFile model;
            if (s.func_177229_b((Property)VanishingBlock.VANISHED)) {
                model = (s.func_177229_b((Property)VanishingBlock.ACTIVE) ? reappearVanishedActive : reappearVanished);
            }
            else {
                model = (s.func_177229_b((Property)VanishingBlock.ACTIVE) ? reappearActive : reappear);
            }
            return ConfiguredModel.builder().modelFile(model).build();
        });
        final ModelFile vanish = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.vanishing_block.getId().func_110623_a(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_vanish_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_vanish_off_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_vanish_off_2"));
        final ModelFile vanishActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.vanishing_block.getId().func_110623_a() + "_active", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_vanish_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_vanish_on_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_vanish_on_2"));
        this.getVariantBuilder((Block)TFBlocks.vanishing_block.get()).partialState().with((Property)VanishingBlock.ACTIVE, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(vanish) });
        this.getVariantBuilder((Block)TFBlocks.vanishing_block.get()).partialState().with((Property)VanishingBlock.ACTIVE, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(vanishActive) });
        final ModelFile vanishLocked = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.locked_vanishing_block.getId().func_110623_a(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_lock_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_lock_on_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_lock_on_2"));
        final ModelFile vanishUnlocked = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.locked_vanishing_block.getId().func_110623_a() + "_unlocked", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_lock_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_lock_off_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_lock_off_2"));
        this.getVariantBuilder((Block)TFBlocks.locked_vanishing_block.get()).partialState().with((Property)LockedVanishingBlock.LOCKED, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(vanishLocked) });
        this.getVariantBuilder((Block)TFBlocks.locked_vanishing_block.get()).partialState().with((Property)LockedVanishingBlock.LOCKED, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(vanishUnlocked) });
        final ModelFile ghastTrap = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.ghast_trap.getId().func_110623_a(), cubeBt3)).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_off"))).texture("side", TwilightForestMod.prefix("block/towerdev_ghasttrap_off"))).texture("bottom", TwilightForestMod.prefix("block/tower_wood_encased"))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_ghasttrap_off_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_off_1"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttrap_off_2"));
        final ModelFile ghastTrapActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.ghast_trap.getId().func_110623_a() + "_active", cubeBt3)).texture("top", TwilightForestMod.prefix("block/towerdev_ghasttraplid_on"))).texture("side", TwilightForestMod.prefix("block/towerdev_ghasttrap_on"))).texture("bottom", TwilightForestMod.prefix("block/tower_wood_encased"))).texture("top2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttraplid_on_1"))).texture("side2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_ghasttrap_on_1"))).texture("top3", TwilightForestMod.prefix("block/tower_device_level_3/towerdev_ghasttraplid_on_2"))).texture("side3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_ghasttrap_on_2"));
        this.getVariantBuilder((Block)TFBlocks.ghast_trap.get()).partialState().with((Property)GhastTrapBlock.ACTIVE, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(ghastTrap) });
        this.getVariantBuilder((Block)TFBlocks.ghast_trap.get()).partialState().with((Property)GhastTrapBlock.ACTIVE, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(ghastTrapActive) });
        final ModelFile builder = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.carminite_builder.getId().func_110623_a(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_builder_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_builder_off_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_builder_off_2"));
        final ModelFile builderActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.carminite_builder.getId().func_110623_a() + "_active", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_builder_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_builder_on_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_builder_on_2"));
        final ModelFile builderTimeout = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.carminite_builder.getId().func_110623_a() + "_timeout", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_builder_timeout"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_builder_timeout_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_3/towerdev_builder_timeout_2"));
        this.getVariantBuilder((Block)TFBlocks.carminite_builder.get()).partialState().with((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_INACTIVE).setModels(new ConfiguredModel[] { new ConfiguredModel(builder) });
        this.getVariantBuilder((Block)TFBlocks.carminite_builder.get()).partialState().with((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_ACTIVE).setModels(new ConfiguredModel[] { new ConfiguredModel(builderActive) });
        this.getVariantBuilder((Block)TFBlocks.carminite_builder.get()).partialState().with((Property)BuilderBlock.STATE, (Comparable)TowerDeviceVariant.BUILDER_TIMEOUT).setModels(new ConfiguredModel[] { new ConfiguredModel(builderTimeout) });
        final ModelFile built = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.built_block.getId().func_110623_a(), cube2NoShade)).texture("all", TwilightForestMod.prefix("block/towerdev_built_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_builder_off_1"));
        final ModelFile builtActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.built_block.getId().func_110623_a() + "_active", cube2NoShade)).texture("all", TwilightForestMod.prefix("block/towerdev_built_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_builder_on_1"));
        this.getVariantBuilder((Block)TFBlocks.built_block.get()).partialState().with((Property)TranslucentBuiltBlock.ACTIVE, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(built) });
        this.getVariantBuilder((Block)TFBlocks.built_block.get()).partialState().with((Property)TranslucentBuiltBlock.ACTIVE, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(builtActive) });
        final ModelFile antibuilder = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.antibuilder.getId().func_110623_a(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_antibuilder"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_antibuilder_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_antibuilder_2"));
        this.simpleBlock((Block)TFBlocks.antibuilder.get(), antibuilder);
        final ModelFile antibuilt = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.antibuilt_block.getId().func_110623_a(), cube2NoShade)).texture("all", TwilightForestMod.prefix("block/towerdev_antibuilt"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_antibuilt_1"));
        this.simpleBlock((Block)TFBlocks.antibuilt_block.get(), antibuilt);
        final ModelFile reactor = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.carminite_reactor.getId().func_110623_a(), cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_reactor_off"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_reactor_off_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_reactor_off_2"));
        final ModelFile reactorActive = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.carminite_reactor.getId().func_110623_a() + "_active", cube3)).texture("all", TwilightForestMod.prefix("block/towerdev_reactor_on"))).texture("all2", TwilightForestMod.prefix("block/tower_device_level_1/towerdev_reactor_on_1"))).texture("all3", TwilightForestMod.prefix("block/tower_device_level_2/towerdev_reactor_on_2"));
        this.getVariantBuilder((Block)TFBlocks.carminite_reactor.get()).partialState().with((Property)CarminiteReactorBlock.ACTIVE, (Comparable)false).setModels(new ConfiguredModel[] { new ConfiguredModel(reactor) });
        this.getVariantBuilder((Block)TFBlocks.carminite_reactor.get()).partialState().with((Property)CarminiteReactorBlock.ACTIVE, (Comparable)true).setModels(new ConfiguredModel[] { new ConfiguredModel(reactorActive) });
        this.simpleBlock((Block)TFBlocks.reactor_debris.get(), (ModelFile)this.models().cubeAll(TFBlocks.reactor_debris.getId().func_110623_a(), new ResourceLocation("block/destroy_stage_9")));
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
        final String baseName = TFBlocks.trophy_pedestal.getId().func_110623_a();
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
        this.getVariantBuilder((Block)TFBlocks.trophy_pedestal.get()).partialState().with((Property)TrophyPedestalBlock.ACTIVE, (Comparable)false).setModels((ConfiguredModel[])latentModels.toArray(new ConfiguredModel[0]));
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
        this.getVariantBuilder((Block)TFBlocks.trophy_pedestal.get()).partialState().with((Property)TrophyPedestalBlock.ACTIVE, (Comparable)true).setModels((ConfiguredModel[])activeModels.toArray(new ConfiguredModel[0]));
    }
    
    private void thorns() {
        final boolean fixer = Direction.SOUTH.func_176740_k() == Direction.Axis.Z;
        final ModelFile green = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.green_thorns.getId().func_110623_a(), TwilightForestMod.prefix("block/thorns_main"))).texture("side", TwilightForestMod.prefix("block/green_thorns_side"))).texture("end", TwilightForestMod.prefix("block/green_thorns_top"));
        final ModelFile greenBottom = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.green_thorns.getId().func_110623_a() + "_bottom", TwilightForestMod.prefix("block/thorns_section_bottom"))).texture("side", TwilightForestMod.prefix("block/green_thorns_side"))).texture("end", TwilightForestMod.prefix("block/green_thorns_top"));
        final ModelFile greenTop = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.green_thorns.getId().func_110623_a() + "_top", TwilightForestMod.prefix("block/thorns_section_top"))).texture("side", TwilightForestMod.prefix("block/green_thorns_side"))).texture("end", TwilightForestMod.prefix("block/green_thorns_top"));
        ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)TFBlocks.green_thorns.get()).part().modelFile(green).addModel()).condition((Property)RotatedPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).end().part().modelFile(green).rotationX(90).addModel()).condition((Property)RotatedPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).end().part().modelFile(green).rotationX(90).rotationY(90).addModel()).condition((Property)RotatedPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).end().part().modelFile(greenTop).rotationX(90).addModel()).condition((Property)SixWayBlock.field_196496_z, (Comparable[])new Boolean[] { true }).end().part().modelFile(greenBottom).rotationX(90).addModel()).condition((Property)SixWayBlock.field_196489_A, (Comparable[])new Boolean[] { true }).end().part().modelFile(greenTop).rotationY(270).addModel()).condition((Property)SixWayBlock.field_196490_b, (Comparable[])new Boolean[] { true }).end().part().modelFile(greenBottom).rotationY(270).addModel()).condition((Property)SixWayBlock.field_196495_y, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? greenBottom : greenTop).rotationY(fixer ? 180 : 0).addModel()).condition((Property)SixWayBlock.field_196492_c, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? greenTop : greenBottom).rotationY(fixer ? 180 : 0).addModel()).condition((Property)SixWayBlock.field_196488_a, (Comparable[])new Boolean[] { true }).end();
        final ModelFile brown = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.brown_thorns.getId().func_110623_a(), TwilightForestMod.prefix("block/thorns_main"))).texture("side", TwilightForestMod.prefix("block/brown_thorns_side"))).texture("end", TwilightForestMod.prefix("block/brown_thorns_top"));
        final ModelFile brownBottom = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.brown_thorns.getId().func_110623_a() + "_bottom", TwilightForestMod.prefix("block/thorns_section_bottom"))).texture("side", TwilightForestMod.prefix("block/brown_thorns_side"))).texture("end", TwilightForestMod.prefix("block/brown_thorns_top"));
        final ModelFile brownTop = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.brown_thorns.getId().func_110623_a() + "_top", TwilightForestMod.prefix("block/thorns_section_top"))).texture("side", TwilightForestMod.prefix("block/brown_thorns_side"))).texture("end", TwilightForestMod.prefix("block/brown_thorns_top"));
        ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)TFBlocks.brown_thorns.get()).part().modelFile(brown).addModel()).condition((Property)RotatedPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).end().part().modelFile(brown).rotationX(90).addModel()).condition((Property)RotatedPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).end().part().modelFile(brown).rotationX(90).rotationY(90).addModel()).condition((Property)RotatedPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).end().part().modelFile(brownTop).rotationX(90).addModel()).condition((Property)SixWayBlock.field_196496_z, (Comparable[])new Boolean[] { true }).end().part().modelFile(brownBottom).rotationX(90).addModel()).condition((Property)SixWayBlock.field_196489_A, (Comparable[])new Boolean[] { true }).end().part().modelFile(brownTop).rotationY(270).addModel()).condition((Property)SixWayBlock.field_196490_b, (Comparable[])new Boolean[] { true }).end().part().modelFile(brownBottom).rotationY(270).addModel()).condition((Property)SixWayBlock.field_196495_y, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? brownBottom : brownTop).rotationY(fixer ? 180 : 0).addModel()).condition((Property)SixWayBlock.field_196492_c, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? brownTop : brownBottom).rotationY(fixer ? 180 : 0).addModel()).condition((Property)SixWayBlock.field_196488_a, (Comparable[])new Boolean[] { true }).end();
        final ModelFile burnt = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.burnt_thorns.getId().func_110623_a(), TwilightForestMod.prefix("block/thorns_main"))).texture("side", TwilightForestMod.prefix("block/burnt_thorns_side"))).texture("end", TwilightForestMod.prefix("block/burnt_thorns_top"));
        final ModelFile burntBottom = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.burnt_thorns.getId().func_110623_a() + "_bottom", TwilightForestMod.prefix("block/thorns_section_bottom"))).texture("side", TwilightForestMod.prefix("block/burnt_thorns_side"))).texture("end", TwilightForestMod.prefix("block/burnt_thorns_top"));
        final ModelFile burntTop = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.burnt_thorns.getId().func_110623_a() + "_top", TwilightForestMod.prefix("block/thorns_section_top"))).texture("side", TwilightForestMod.prefix("block/burnt_thorns_side"))).texture("end", TwilightForestMod.prefix("block/burnt_thorns_top"));
        ((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder((Block)TFBlocks.burnt_thorns.get()).part().modelFile(burnt).addModel()).condition((Property)RotatedPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Y }).end().part().modelFile(burnt).rotationX(90).addModel()).condition((Property)RotatedPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.Z }).end().part().modelFile(burnt).rotationX(90).rotationY(90).addModel()).condition((Property)RotatedPillarBlock.field_176298_M, (Comparable[])new Direction.Axis[] { Direction.Axis.X }).end().part().modelFile(burntTop).rotationX(90).addModel()).condition((Property)SixWayBlock.field_196496_z, (Comparable[])new Boolean[] { true }).end().part().modelFile(burntBottom).rotationX(90).addModel()).condition((Property)SixWayBlock.field_196489_A, (Comparable[])new Boolean[] { true }).end().part().modelFile(burntTop).rotationY(270).addModel()).condition((Property)SixWayBlock.field_196490_b, (Comparable[])new Boolean[] { true }).end().part().modelFile(burntBottom).rotationY(270).addModel()).condition((Property)SixWayBlock.field_196495_y, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? burntBottom : burntTop).rotationY(fixer ? 180 : 0).addModel()).condition((Property)SixWayBlock.field_196492_c, (Comparable[])new Boolean[] { true }).end().part().modelFile(fixer ? burntTop : burntBottom).rotationY(fixer ? 180 : 0).addModel()).condition((Property)SixWayBlock.field_196488_a, (Comparable[])new Boolean[] { true }).end();
    }
    
    private void auroraBlocks() {
        final int variants = 16;
        final ModelFile[] models = new ModelFile[variants];
        for (int i = 0; i < variants; ++i) {
            models[i] = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.aurora_block.getId().func_110623_a() + "_" + i, TwilightForestMod.prefix("block/util/tinted_cube_all"))).texture("all", TwilightForestMod.prefix("block/" + TFBlocks.aurora_block.getId().func_110623_a() + "_" + i));
        }
        for (int i = 0; i < variants; ++i) {
            this.getVariantBuilder((Block)TFBlocks.aurora_block.get()).partialState().with((Property)AuroraBrickBlock.VARIANT, (Comparable)i).setModels(ConfiguredModel.builder().weight(3).modelFile(models[i]).nextModel().weight(1).modelFile(models[(i + 1) % variants]).build());
        }
        final ModelFile pillarModel = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.aurora_pillar.getId().func_110623_a(), TwilightForestMod.prefix("block/util/tinted_cube_column"))).texture("end", TwilightForestMod.prefix("block/" + TFBlocks.aurora_pillar.getId().func_110623_a() + "_top"))).texture("side", this.blockTexture((Block)TFBlocks.aurora_pillar.get()));
        this.axisBlock((RotatedPillarBlock)TFBlocks.aurora_pillar.get(), pillarModel, pillarModel);
        final ModelFile slabModel = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.aurora_slab.getId().func_110623_a(), TwilightForestMod.prefix("block/util/tinted_slab"))).texture("bottom", TwilightForestMod.prefix("block/" + TFBlocks.aurora_pillar.getId().func_110623_a() + "_top"))).texture("top", TwilightForestMod.prefix("block/" + TFBlocks.aurora_pillar.getId().func_110623_a() + "_top"))).texture("side", TwilightForestMod.prefix("block/" + TFBlocks.aurora_slab.getId().func_110623_a() + "_side"));
        final ModelFile doubleSlabModel = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.aurora_slab.getId().func_110623_a() + "_double", TwilightForestMod.prefix("block/util/tinted_cube_column"))).texture("end", TwilightForestMod.prefix("block/" + TFBlocks.aurora_pillar.getId().func_110623_a() + "_top"))).texture("side", TwilightForestMod.prefix("block/" + TFBlocks.aurora_slab.getId().func_110623_a() + "_side"));
        this.getVariantBuilder((Block)TFBlocks.aurora_slab.get()).partialState().with((Property)SlabBlock.field_196505_a, (Comparable)SlabType.BOTTOM).setModels(new ConfiguredModel[] { new ConfiguredModel(slabModel) });
        this.getVariantBuilder((Block)TFBlocks.aurora_slab.get()).partialState().with((Property)SlabBlock.field_196505_a, (Comparable)SlabType.TOP).setModels(ConfiguredModel.builder().uvLock(true).rotationX(180).modelFile(slabModel).build());
        this.getVariantBuilder((Block)TFBlocks.aurora_slab.get()).partialState().with((Property)SlabBlock.field_196505_a, (Comparable)SlabType.DOUBLE).setModels(new ConfiguredModel[] { new ConfiguredModel(doubleSlabModel) });
        final ModelFile auroraGlass = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(TFBlocks.auroralized_glass.getId().func_110623_a(), TwilightForestMod.prefix("block/util/tinted_cube_all"))).texture("all", this.blockTexture((Block)TFBlocks.auroralized_glass.get()));
        this.simpleBlock((Block)TFBlocks.auroralized_glass.get(), auroraGlass);
    }
    
    private void mazestone() {
        final ResourceLocation plainTex = this.blockTexture((Block)TFBlocks.maze_stone.get());
        final ModelFile mazeStone = (ModelFile)this.models().cubeAll(TFBlocks.maze_stone.getId().func_110623_a(), plainTex);
        this.simpleBlock((Block)TFBlocks.maze_stone.get(), ConfiguredModel.builder().rotationX(90).rotationY(90).modelFile(mazeStone).nextModel().rotationX(270).rotationY(270).modelFile(mazeStone).build());
        this.simpleBlock((Block)TFBlocks.maze_stone_brick.get());
        final ModelFile chiseled = (ModelFile)this.models().cubeColumn(TFBlocks.maze_stone_chiseled.getId().func_110623_a(), this.blockTexture((Block)TFBlocks.maze_stone_chiseled.get()), plainTex);
        this.simpleBlock((Block)TFBlocks.maze_stone_chiseled.get(), chiseled);
        final ModelFile decorative = (ModelFile)this.models().cubeColumn(TFBlocks.maze_stone_decorative.getId().func_110623_a(), this.blockTexture((Block)TFBlocks.maze_stone_decorative.get()), plainTex);
        this.simpleBlock((Block)TFBlocks.maze_stone_decorative.get(), decorative);
        this.simpleBlock((Block)TFBlocks.maze_stone_cracked.get());
        this.simpleBlock((Block)TFBlocks.maze_stone_mossy.get());
        final ResourceLocation brickTex = this.blockTexture((Block)TFBlocks.maze_stone_brick.get());
        final ModelFile mosaic = (ModelFile)this.models().cubeColumn(TFBlocks.maze_stone_mosaic.getId().func_110623_a(), brickTex, this.blockTexture((Block)TFBlocks.maze_stone_mosaic.get()));
        this.simpleBlock((Block)TFBlocks.maze_stone_mosaic.get(), mosaic);
        final ModelFile border = (ModelFile)this.models().cubeColumn(TFBlocks.maze_stone_border.getId().func_110623_a(), brickTex, this.blockTexture((Block)TFBlocks.maze_stone_border.get()));
        this.simpleBlock((Block)TFBlocks.maze_stone_border.get(), border);
    }
    
    private void lilyPad(final Block b) {
        final String baseName = b.getRegistryName().func_110623_a();
        final ResourceLocation parent = new ResourceLocation("block/lily_pad");
        final ModelFile[] models = new ModelFile[4];
        for (int i = 0; i < models.length; ++i) {
            models[i] = (ModelFile)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(baseName + "_" + i, parent)).texture("texture", TwilightForestMod.prefix("block/huge_lilypad_" + i))).texture("particle", "#texture");
        }
        final Map<HugeLilypadPiece, ModelFile> north = (Map<HugeLilypadPiece, ModelFile>)ImmutableMap.of((Object)HugeLilypadPiece.NW, (Object)models[1], (Object)HugeLilypadPiece.NE, (Object)models[0], (Object)HugeLilypadPiece.SE, (Object)models[3], (Object)HugeLilypadPiece.SW, (Object)models[2]);
        final Map<HugeLilypadPiece, ModelFile> south = (Map<HugeLilypadPiece, ModelFile>)ImmutableMap.of((Object)HugeLilypadPiece.NW, (Object)models[3], (Object)HugeLilypadPiece.NE, (Object)models[2], (Object)HugeLilypadPiece.SE, (Object)models[1], (Object)HugeLilypadPiece.SW, (Object)models[0]);
        final Map<HugeLilypadPiece, ModelFile> west = (Map<HugeLilypadPiece, ModelFile>)ImmutableMap.of((Object)HugeLilypadPiece.NW, (Object)models[0], (Object)HugeLilypadPiece.NE, (Object)models[3], (Object)HugeLilypadPiece.SE, (Object)models[2], (Object)HugeLilypadPiece.SW, (Object)models[1]);
        final Map<HugeLilypadPiece, ModelFile> east = (Map<HugeLilypadPiece, ModelFile>)ImmutableMap.of((Object)HugeLilypadPiece.NW, (Object)models[2], (Object)HugeLilypadPiece.NE, (Object)models[1], (Object)HugeLilypadPiece.SE, (Object)models[0], (Object)HugeLilypadPiece.SW, (Object)models[3]);
        this.getVariantBuilder(b).forAllStates(state -> {
            int rotY = 0;
            Map<HugeLilypadPiece, ModelFile> m = null;
            switch ((Direction)state.func_177229_b((Property)HugeLilyPadBlock.FACING)) {
                default: {
                    rotY = 0;
                    m = north;
                    break;
                }
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
            }
            final ModelFile model = m.get(state.func_177229_b((Property)HugeLilyPadBlock.PIECE));
            return ConfiguredModel.builder().rotationY(rotY).modelFile(model).build();
        });
    }
    
    private void perFaceBlock(final Block b, final ResourceLocation inside, final ResourceLocation outside) {
        final ModelFile modelInside = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(b.getRegistryName().func_110623_a() + "_inside", TwilightForestMod.prefix("block/util/north_face"))).texture("texture", inside);
        final ModelFile modelOutside = (ModelFile)((BlockModelBuilder)this.models().withExistingParent(b.getRegistryName().func_110623_a() + "_outside", TwilightForestMod.prefix("block/util/north_face"))).texture("texture", outside);
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).addModel()).condition((Property)HugeMushroomBlock.field_196459_a, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).addModel()).condition((Property)HugeMushroomBlock.field_196459_a, (Comparable[])new Boolean[] { true }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).uvLock(true).rotationY(180).addModel()).condition((Property)HugeMushroomBlock.field_196463_c, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).uvLock(true).rotationY(180).addModel()).condition((Property)HugeMushroomBlock.field_196463_c, (Comparable[])new Boolean[] { true }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).uvLock(true).rotationY(270).addModel()).condition((Property)HugeMushroomBlock.field_196464_y, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).uvLock(true).rotationY(270).addModel()).condition((Property)HugeMushroomBlock.field_196464_y, (Comparable[])new Boolean[] { true }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).uvLock(true).rotationY(90).addModel()).condition((Property)HugeMushroomBlock.field_196461_b, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).uvLock(true).rotationY(90).addModel()).condition((Property)HugeMushroomBlock.field_196461_b, (Comparable[])new Boolean[] { true }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).uvLock(true).rotationX(270).addModel()).condition((Property)HugeMushroomBlock.field_196465_z, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).uvLock(true).rotationX(270).addModel()).condition((Property)HugeMushroomBlock.field_196465_z, (Comparable[])new Boolean[] { true }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelInside).uvLock(true).rotationX(90).addModel()).condition((Property)HugeMushroomBlock.field_196460_A, (Comparable[])new Boolean[] { false }).end();
        ((MultiPartBlockStateBuilder.PartBuilder)this.getMultipartBuilder(b).part().modelFile(modelOutside).uvLock(true).rotationX(90).addModel()).condition((Property)HugeMushroomBlock.field_196460_A, (Comparable[])new Boolean[] { true }).end();
    }
    
    @Nonnull
    public String func_200397_b() {
        return "TwilightForest blockstates and block models";
    }
}
