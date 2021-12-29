// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Rotation;
import twilightforest.enums.BossVariant;
import twilightforest.block.BlockTFBossSpawner;
import twilightforest.block.TFBlocks;
import twilightforest.loot.TFTreasure;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFMazeRoomBoss extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomBoss() {
    }
    
    public ComponentTFMazeRoomBoss(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.func_175807_a(world, 7, 1, 0, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 6, 1, 0, 9, 4, 0, Blocks.field_180407_aO.func_176223_P(), ComponentTFMazeRoomBoss.AIR, false);
        }
        if (this.func_175807_a(world, 7, 1, 15, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 6, 1, 15, 9, 4, 15, Blocks.field_180407_aO.func_176223_P(), ComponentTFMazeRoomBoss.AIR, false);
        }
        if (this.func_175807_a(world, 0, 1, 7, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 0, 1, 6, 0, 4, 9, Blocks.field_180407_aO.func_176223_P(), ComponentTFMazeRoomBoss.AIR, false);
        }
        if (this.func_175807_a(world, 15, 1, 7, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 15, 1, 6, 15, 4, 9, Blocks.field_180407_aO.func_176223_P(), ComponentTFMazeRoomBoss.AIR, false);
        }
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                final boolean mycelium = rand.nextInt(dist + 1) > 0;
                final boolean mushroom = rand.nextInt(dist) > 0;
                final boolean mushRed = rand.nextBoolean();
                if (mycelium) {
                    this.func_175811_a(world, Blocks.field_150391_bh.func_176223_P(), x, 0, z, sbb);
                }
                if (mushroom) {
                    this.func_175811_a(world, (mushRed ? Blocks.field_150337_Q : Blocks.field_150338_P).func_176223_P(), x, 1, z, sbb);
                }
            }
        }
        final IBlockState redMushroom = Blocks.field_150419_aX.func_176223_P().func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.ALL_OUTSIDE);
        final IBlockState brownMushroom = Blocks.field_150420_aW.func_176223_P().func_177226_a((IProperty)BlockHugeMushroom.field_176380_a, (Comparable)BlockHugeMushroom.EnumType.ALL_OUTSIDE);
        this.func_175804_a(world, sbb, 1, 1, 1, 3, 1, 3, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 1, 2, 1, 1, 3, 4, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 2, 2, 1, 4, 3, 1, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 1, 4, 1, 3, 4, 3, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.placeTreasureAtCurrentPosition(world, rand, 3, 2, 3, TFTreasure.labyrinth_room, sbb);
        this.func_175804_a(world, sbb, 12, 1, 12, 14, 1, 14, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 14, 2, 11, 14, 3, 14, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 11, 2, 14, 14, 3, 14, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 12, 4, 12, 14, 4, 14, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.placeTreasureAtCurrentPosition(world, rand, 12, 2, 12, TFTreasure.labyrinth_room, sbb);
        this.func_175804_a(world, sbb, 1, 1, 12, 3, 1, 14, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 1, 2, 11, 1, 3, 14, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 2, 2, 14, 4, 3, 14, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 1, 4, 12, 3, 4, 14, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.placeTreasureAtCurrentPosition(world, rand, 3, 2, 12, TFTreasure.labyrinth_room, sbb);
        this.func_175804_a(world, sbb, 12, 1, 1, 14, 1, 3, brownMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 11, 2, 1, 14, 3, 1, brownMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 14, 2, 2, 14, 3, 4, brownMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 12, 4, 1, 14, 4, 3, brownMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.placeTreasureAtCurrentPosition(world, rand, 12, 2, 3, TFTreasure.labyrinth_room, sbb);
        this.func_175804_a(world, sbb, 5, 4, 5, 7, 5, 7, brownMushroom, ComponentTFMazeRoomBoss.AIR, false);
        this.func_175804_a(world, sbb, 8, 4, 8, 10, 5, 10, redMushroom, ComponentTFMazeRoomBoss.AIR, false);
        final IBlockState taurSpawner = TFBlocks.boss_spawner.func_176223_P().func_177226_a((IProperty)BlockTFBossSpawner.VARIANT, (Comparable)BossVariant.MINOSHROOM);
        this.setBlockStateRotated(world, taurSpawner, 7, 1, 7, Rotation.NONE, sbb);
        return true;
    }
}
