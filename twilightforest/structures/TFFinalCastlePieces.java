// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import java.util.ArrayList;
import net.minecraft.world.IBlockAccess;
import twilightforest.biomes.TFBiomeBase;
import twilightforest.structures.lichtower.ComponentTFTowerWing;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Iterator;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.ChunkCoordinates;
import twilightforest.TFFeature;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public class TFFinalCastlePieces
{
    public static void registerFinalCastlePieces() {
        MapGenStructureIO.func_143031_a((Class)Main.class, "TFFCMain");
        MapGenStructureIO.func_143031_a((Class)StairTower.class, "TFFCStTo");
        MapGenStructureIO.func_143031_a((Class)LargeTower.class, "TFFCLaTo");
        MapGenStructureIO.func_143031_a((Class)Mural.class, "TFFCMur");
        MapGenStructureIO.func_143031_a((Class)Foundation48.class, "TFFCToF48");
        MapGenStructureIO.func_143031_a((Class)Roof48Crenellated.class, "TFFCRo48Cr");
        MapGenStructureIO.func_143031_a((Class)BossGazebo.class, "TFFCBoGaz");
        MapGenStructureIO.func_143031_a((Class)MazeTower13.class, "TFFCSiTo");
        MapGenStructureIO.func_143031_a((Class)DungeonSteps.class, "TFFCDunSt");
        MapGenStructureIO.func_143031_a((Class)DungeonEntrance.class, "TFFCDunEn");
        MapGenStructureIO.func_143031_a((Class)DungeonRoom31.class, "TFFCDunR31");
        MapGenStructureIO.func_143031_a((Class)DungeonExit.class, "TFFCDunEx");
        MapGenStructureIO.func_143031_a((Class)DungeonForgeRoom.class, "TFFCDunBoR");
        MapGenStructureIO.func_143031_a((Class)Roof9Crenellated.class, "TFFCRo9Cr");
        MapGenStructureIO.func_143031_a((Class)Roof13Crenellated.class, "TFFCRo13Cr");
        MapGenStructureIO.func_143031_a((Class)Roof13Conical.class, "TFFCRo13Con");
        MapGenStructureIO.func_143031_a((Class)Roof13Peaked.class, "TFFCRo13Pk");
        MapGenStructureIO.func_143031_a((Class)EntranceTower.class, "TFFCEnTo");
        MapGenStructureIO.func_143031_a((Class)EntranceSideTower.class, "TFFCEnSiTo");
        MapGenStructureIO.func_143031_a((Class)EntranceBottomTower.class, "TFFCEnBoTo");
        MapGenStructureIO.func_143031_a((Class)EntranceStairs.class, "TFFCEnSt");
        MapGenStructureIO.func_143031_a((Class)BellTower21.class, "TFFCBelTo");
        MapGenStructureIO.func_143031_a((Class)Bridge.class, "TFFCBri");
        MapGenStructureIO.func_143031_a((Class)Foundation13.class, "TFFCToF13");
        MapGenStructureIO.func_143031_a((Class)BellFoundation21.class, "TFFCBeF21");
        MapGenStructureIO.func_143031_a((Class)Foundation13Thorns.class, "TFFCFTh21");
        MapGenStructureIO.func_143031_a((Class)DamagedTower.class, "TFFCDamT");
        MapGenStructureIO.func_143031_a((Class)WreckedTower.class, "TFFCWrT");
    }
    
    public static class Main extends StructureTFComponent
    {
        public Main() {
        }
        
        public Main(final World world, final Random rand, final int i, int x, final int y, int z) {
            this.setCoordBaseMode(0);
            this.spawnListIndex = 1;
            x = x + 127 >> 8 << 8;
            z = z + 127 >> 8 << 8;
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -24, 120, -24, 48, 40, 48, 0);
            final ChunkCoordinates cc = TFFeature.getNearestCenterXYZ(x >> 4, z >> 4, world);
            final int cx = x >> 8 << 8;
            final int cz = z >> 8 << 8;
            System.out.println("Making castle at " + x + ", " + z + ". center is " + cc.field_71574_a + ", " + cc.field_71573_c);
            System.out.println("Natural center at " + cx + ", " + cz);
            if (this.deco == null) {
                this.deco = new StructureTFDecoratorCastle();
            }
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            final Foundation48 foundation = new Foundation48(rand, 4, this);
            list.add(foundation);
            foundation.func_74861_a(this, list, rand);
            final StructureTFComponent roof = new Roof48Crenellated(rand, 4, this);
            list.add(roof);
            roof.func_74861_a((StructureComponent)this, list, rand);
            final StructureTFComponent gazebo = new BossGazebo(rand, 5, this);
            list.add(gazebo);
            gazebo.func_74861_a((StructureComponent)this, list, rand);
            final StairTower tower0 = new StairTower(rand, 3, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78896_c, 2);
            list.add(tower0);
            tower0.func_74861_a(this, list, rand);
            final LargeTower tower2 = new LargeTower(rand, 3, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78896_c, 3);
            list.add(tower2);
            tower2.func_74861_a(this, list, rand);
            final StairTower tower3 = new StairTower(rand, 3, this.field_74887_e.field_78897_a, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78892_f, 1);
            list.add(tower3);
            tower3.func_74861_a(this, list, rand);
            final StairTower tower4 = new StairTower(rand, 3, this.field_74887_e.field_78893_d, this.field_74887_e.field_78895_b + 3, this.field_74887_e.field_78892_f, 0);
            list.add(tower4);
            tower4.func_74861_a(this, list, rand);
            ChunkCoordinates dest = new ChunkCoordinates(this.field_74887_e.field_78897_a - 4, this.field_74887_e.field_78894_e, this.field_74887_e.field_78896_c - 24);
            this.buildTowerMaze(list, rand, 48, 0, 24, 60, 0, 0, dest);
            dest = new ChunkCoordinates(this.field_74887_e.field_78893_d + 4, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 24);
            this.buildTowerMaze(list, rand, 0, 30, 24, 60, 2, 1, dest);
            final DungeonSteps steps0 = new DungeonSteps(rand, 5, this.field_74887_e.field_78897_a + 18, this.field_74887_e.field_78895_b + 1, this.field_74887_e.field_78896_c + 18, 0);
            list.add(steps0);
            steps0.func_74861_a(this, list, rand);
            final DungeonSteps steps2 = steps0.buildMoreStepsTowards(parent, list, rand, 3);
            final DungeonSteps steps3 = steps2.buildMoreStepsTowards(parent, list, rand, 3);
            final DungeonSteps steps4 = steps3.buildMoreStepsTowards(parent, list, rand, 3);
            final DungeonEntrance dRoom = steps4.buildLevelUnder(parent, list, rand, 1);
            final ChunkCoordinates mc = this.offsetTowerCCoords(48, 23, 25, 1, 0);
            final Mural mural0 = new Mural(rand, 7, mc.field_71574_a, mc.field_71572_b, mc.field_71573_c, 35, 30, 0);
            list.add(mural0);
            mural0.func_74861_a((StructureComponent)this, list, rand);
            final ChunkCoordinates mc2 = this.offsetTowerCCoords(48, 33, 24, -1, 0);
            final Mural mural2 = new Mural(rand, 7, mc2.field_71574_a, mc2.field_71572_b, mc.field_71573_c, 19, 12, 2);
            list.add(mural2);
            mural2.func_74861_a((StructureComponent)this, list, rand);
        }
        
        private void buildTowerMaze(final List list, final Random rand, final int x, final int y, final int z, final int howFar, final int direction, final int type, final ChunkCoordinates dest) {
            final LinkedList before = new LinkedList(list);
            final ChunkCoordinates tc = this.offsetTowerCCoords(x, y, z, howFar, direction);
            final MazeTower13 sTower = new MazeTower13(rand, 3, tc.field_71574_a, tc.field_71572_b, tc.field_71573_c, type, direction);
            final ChunkCoordinates bc = this.offsetTowerCCoords(x, y, z, 1, direction);
            final Bridge bridge = new Bridge(this.func_74877_c() + 1, bc.field_71574_a, bc.field_71572_b, bc.field_71573_c, howFar - 7, direction);
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
            list.add(sTower);
            sTower.buildTowards(this, list, rand, dest);
            if (this.isMazeComplete(list, type)) {
                System.out.println("Tower maze type " + type + " complete!");
            }
            else {
                System.out.println("Tower maze type " + type + " INCOMPLETE, retrying!");
                list.clear();
                list.addAll(before);
                this.buildTowerMaze(list, rand, x, y, z, howFar, direction, type, dest);
            }
        }
        
        private boolean isMazeComplete(final List list, final int type) {
            for (final StructureComponent structurecomponent : list) {
                if ((structurecomponent instanceof EntranceTower && type == 0) || (structurecomponent instanceof BellTower21 && type == 1)) {
                    return true;
                }
            }
            return false;
        }
        
        @Override
        protected ChunkCoordinates offsetTowerCCoords(final int x, final int y, final int z, final int howFar, final int direction) {
            int dx = this.func_74865_a(x, z);
            final int dy = this.func_74862_a(y);
            int dz = this.func_74873_b(x, z);
            switch (direction) {
                case 0: {
                    dx += howFar;
                    break;
                }
                case 1: {
                    dz += howFar;
                    break;
                }
                case 2: {
                    dx -= howFar;
                    break;
                }
                case 3: {
                    dz -= howFar;
                    break;
                }
            }
            return new ChunkCoordinates(dx, dy, dz);
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            this.func_74882_a(world, sbb, 0, 0, 0, 48, 40, 48, false, rand, this.deco.randomBlocks);
            this.func_74882_a(world, sbb, 13, 30, 1, 47, 30, 12, false, rand, this.deco.randomBlocks);
            this.func_151549_a(world, sbb, 13, 31, 12, 36, 31, 12, this.deco.fenceID, this.deco.fenceID, false);
            this.func_74882_a(world, sbb, 13, 30, 36, 47, 30, 47, false, rand, this.deco.randomBlocks);
            this.func_151549_a(world, sbb, 13, 31, 36, 36, 31, 36, this.deco.fenceID, this.deco.fenceID, false);
            this.func_74882_a(world, sbb, 1, 30, 1, 12, 30, 47, false, rand, this.deco.randomBlocks);
            this.func_151549_a(world, sbb, 12, 31, 12, 12, 31, 36, this.deco.fenceID, this.deco.fenceID, false);
            this.func_74882_a(world, sbb, 38, 25, 13, 47, 25, 35, false, rand, this.deco.randomBlocks);
            for (int i = 0; i < 5; ++i) {
                int y = 30 - i;
                this.makeMezzTopStairs(world, sbb, y, 10 + i, 3);
                this.makeMezzTopStairs(world, sbb, y, 38 - i, 1);
                y = 25 - i;
                final int x = 37 - i;
                this.func_151556_a(world, sbb, x, y, 14, x, y, 22, this.deco.stairID, this.getStairMeta(0), this.deco.stairID, this.getStairMeta(0), false);
                this.func_151556_a(world, sbb, x, y - 1, 14, x, y - 1, 22, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
                this.func_151556_a(world, sbb, x, y, 26, x, y, 34, this.deco.stairID, this.getStairMeta(0), this.deco.stairID, this.getStairMeta(0), false);
                this.func_151556_a(world, sbb, x, y - 1, 26, x, y - 1, 34, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
            }
            for (int x2 = 11; x2 < 47; x2 += 12) {
                for (int z = 11; z < 47; z += 12) {
                    this.func_151556_a(world, sbb, x2, 1, z, x2 + 2, 40, z + 2, this.deco.pillarID, this.deco.pillarMeta, this.deco.blockID, this.deco.blockMeta, false);
                    this.makePillarBase(world, sbb, x2, z, 1, 0);
                    this.makePillarBase(world, sbb, x2, z, 19, 4);
                    this.makePillarBase(world, sbb, x2, z, 21, 0);
                    this.makePillarBase(world, sbb, x2, z, 39, 4);
                }
            }
            for (int rotation = 0; rotation < 4; ++rotation) {
                for (int z = 11; z < 47; z += 12) {
                    if (z == 23) {
                        if (rotation == 0) {
                            continue;
                        }
                        if (rotation == 2) {
                            continue;
                        }
                    }
                    this.fillBlocksRotated(world, sbb, 1, 1, z, 1, 40, z + 2, this.deco.pillarID, this.deco.pillarMeta, rotation);
                    this.makeHalfPillarBase(world, sbb, rotation, 1, z, 0);
                    this.makeHalfPillarBase(world, sbb, rotation, 19, z, 4);
                    this.makeHalfPillarBase(world, sbb, rotation, 21, z, 0);
                    this.makeHalfPillarBase(world, sbb, rotation, 39, z, 4);
                }
            }
            this.func_74882_a(world, sbb, 1, 20, 1, 47, 20, 47, false, rand, this.deco.randomBlocks);
            final Block fieldBlock = TFBlocks.forceField;
            final int fieldMeta = 6;
            this.func_151556_a(world, sbb, 12, 1, 12, 24, 10, 12, fieldBlock, fieldMeta, fieldBlock, fieldMeta, false);
            this.func_151556_a(world, sbb, 12, 1, 12, 12, 10, 24, fieldBlock, fieldMeta, fieldBlock, fieldMeta, false);
            this.func_151556_a(world, sbb, 24, 1, 12, 24, 10, 24, fieldBlock, fieldMeta, fieldBlock, fieldMeta, false);
            this.func_151556_a(world, sbb, 12, 1, 24, 24, 10, 24, fieldBlock, fieldMeta, fieldBlock, fieldMeta, false);
            this.func_151556_a(world, sbb, 12, 10, 12, 24, 10, 24, fieldBlock, fieldMeta, fieldBlock, fieldMeta, false);
            this.func_151556_a(world, sbb, 17, 1, 12, 19, 4, 12, TFBlocks.castleDoor, 2, Blocks.field_150350_a, 0, false);
            this.func_151556_a(world, sbb, 17, 1, 24, 19, 4, 24, TFBlocks.castleDoor, 2, Blocks.field_150350_a, 0, false);
            this.makeSmallTowerStairs(world, sbb, 0);
            this.makeSmallTowerStairs(world, sbb, 1);
            this.makeSmallTowerStairs(world, sbb, 3);
            this.makeLargeTowerStairs(world, sbb, 2);
            this.func_151556_a(world, sbb, 48, 1, 23, 48, 4, 25, TFBlocks.castleDoor, 0, Blocks.field_150350_a, 0, false);
            this.func_151556_a(world, sbb, 0, 31, 23, 0, 34, 25, TFBlocks.castleDoor, 1, Blocks.field_150350_a, 0, false);
            return true;
        }
        
        private void makeSmallTowerStairs(final World world, final StructureBoundingBox sbb, final int rotation) {
            for (int y = 1; y < 4; ++y) {
                final int z = 40 + y;
                this.fillBlocksRotated(world, sbb, 1, 1, z, 4, y, z, this.deco.blockID, this.deco.blockMeta, rotation);
                this.fillBlocksRotated(world, sbb, 2, y, z, 3, y, z, this.deco.stairID, this.getStairMeta(1 + rotation), rotation);
            }
        }
        
        private void makeLargeTowerStairs(final World world, final StructureBoundingBox sbb, final int rotation) {
            for (int y = 1; y < 4; ++y) {
                final int z = 38 + y;
                this.fillBlocksRotated(world, sbb, 2, 1, z, 6, y, z, this.deco.blockID, this.deco.blockMeta, rotation);
                this.fillBlocksRotated(world, sbb, 3, y, z, 5, y, z, this.deco.stairID, this.getStairMeta(1 + rotation), rotation);
            }
        }
        
        private void makeMezzTopStairs(final World world, final StructureBoundingBox sbb, final int y, final int z, final int stairMeta) {
            this.func_151556_a(world, sbb, 38, y, z, 46, y, z, this.deco.stairID, this.getStairMeta(stairMeta), this.deco.stairID, this.getStairMeta(stairMeta), false);
            this.func_151556_a(world, sbb, 38, y - 1, z, 46, y - 1, z, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
            this.func_74878_a(world, sbb, 38, y + 1, z, 46, y + 3, z);
        }
        
        private void makeHalfPillarBase(final World world, final StructureBoundingBox sbb, final int rotation, final int y, final int z, final int metaBit) {
            this.fillBlocksRotated(world, sbb, 2, y, z - 1, 2, y, z + 3, this.deco.stairID, this.getStairMeta(2 + rotation) | metaBit, rotation);
            this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation) | metaBit, 1, y, z - 1, rotation, sbb);
            this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(3 + rotation) | metaBit, 1, y, z + 3, rotation, sbb);
        }
        
        private void makePillarBase(final World world, final StructureBoundingBox sbb, final int x, final int z, final int y, final int metaBit) {
            this.func_151556_a(world, sbb, x + 0, y, z + 3, x + 3, y, z + 3, this.deco.stairID, this.getStairMeta(3) | metaBit, Blocks.field_150350_a, 0, false);
            this.func_151556_a(world, sbb, x - 1, y, z - 1, x + 2, y, z - 1, this.deco.stairID, this.getStairMeta(1) | metaBit, Blocks.field_150350_a, 0, false);
            this.func_151556_a(world, sbb, x + 3, y, z - 1, x + 3, y, z + 2, this.deco.stairID, this.getStairMeta(2) | metaBit, Blocks.field_150350_a, 0, false);
            this.func_151556_a(world, sbb, x - 1, y, z + 0, x - 1, y, z + 3, this.deco.stairID, this.getStairMeta(0) | metaBit, Blocks.field_150350_a, 0, false);
        }
    }
    
    public static class Roof48Crenellated extends StructureTFComponent
    {
        public Roof48Crenellated() {
        }
        
        public Roof48Crenellated(final Random rand, final int i, final StructureTFComponent keep) {
            super(i);
            final int height = 5;
            this.setCoordBaseMode(keep.getCoordBaseMode());
            this.field_74887_e = new StructureBoundingBox(keep.func_74874_b().field_78897_a - 2, keep.func_74874_b().field_78894_e - 1, keep.func_74874_b().field_78896_c - 2, keep.func_74874_b().field_78893_d + 2, keep.func_74874_b().field_78894_e + height - 1, keep.func_74874_b().field_78892_f + 2);
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            this.func_151556_a(world, sbb, 2, 2, 2, 50, 2, 50, TFBlocks.castleMagic, 3, TFBlocks.castleMagic, 3, false);
            for (int rotation = 0; rotation < 4; ++rotation) {
                this.fillBlocksRotated(world, sbb, 3, 1, 1, 45, 3, 1, this.deco.blockID, this.deco.blockMeta, rotation);
                for (int i = 10; i < 41; i += 5) {
                    this.fillBlocksRotated(world, sbb, i, 1, 0, i + 2, 5, 2, this.deco.blockID, this.deco.blockMeta, rotation);
                    this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, i + 1, 0, 1, rotation, sbb);
                }
            }
            return true;
        }
    }
    
    public static class BossGazebo extends StructureTFComponent
    {
        public BossGazebo() {
        }
        
        public BossGazebo(final Random rand, final int i, final StructureTFComponent keep) {
            super(i);
            this.spawnListIndex = -1;
            this.setCoordBaseMode(keep.getCoordBaseMode());
            this.field_74887_e = new StructureBoundingBox(keep.func_74874_b().field_78897_a + 14, keep.func_74874_b().field_78894_e + 2, keep.func_74874_b().field_78896_c + 14, keep.func_74874_b().field_78893_d - 14, keep.func_74874_b().field_78894_e + 13, keep.func_74874_b().field_78892_f - 14);
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            this.deco = new StructureTFDecoratorCastle();
            this.deco.blockID = TFBlocks.castleMagic;
            this.deco.blockMeta = 1;
            this.deco.fenceID = TFBlocks.forceField;
            this.deco.fenceMeta = 10;
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            for (int rotation = 0; rotation < 4; ++rotation) {
                this.fillBlocksRotated(world, sbb, 0, 0, 0, 0, 10, 20, this.deco.fenceID, this.deco.fenceMeta, rotation);
            }
            this.func_151556_a(world, sbb, 0, 11, 0, 20, 11, 20, this.deco.fenceID, this.deco.fenceMeta, this.deco.fenceID, this.deco.fenceMeta, false);
            this.placeSignAtCurrentPosition(world, 10, 0, 10, "Final Boss Here", "You win!", sbb);
            return true;
        }
    }
    
    public static class Foundation48 extends StructureTFComponent
    {
        private int groundLevel;
        
        public Foundation48() {
            this.groundLevel = -1;
        }
        
        public Foundation48(final Random rand, final int i, final StructureTFComponent sideTower) {
            super(i);
            this.groundLevel = -1;
            this.setCoordBaseMode(sideTower.getCoordBaseMode());
            this.field_74887_e = new StructureBoundingBox(sideTower.func_74874_b().field_78897_a, sideTower.func_74874_b().field_78895_b, sideTower.func_74874_b().field_78896_c, sideTower.func_74874_b().field_78893_d, sideTower.func_74874_b().field_78895_b - 1, sideTower.func_74874_b().field_78892_f);
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            for (int x = 4; x < 45; ++x) {
                for (int z = 4; z < 45; ++z) {
                    this.func_151554_b(world, this.deco.blockID, this.deco.blockMeta, x, -1, z, sbb);
                }
            }
            final int mid = 16;
            for (int rotation = 0; rotation < 4; ++rotation) {
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 3, -2, 3, rotation, sbb);
                this.fillBlocksRotated(world, sbb, 2, -2, 1, 46, -1, 1, this.deco.blockID, this.deco.blockMeta, rotation);
                this.fillBlocksRotated(world, sbb, 2, -4, 2, 45, -1, 2, this.deco.blockID, this.deco.blockMeta, rotation);
                this.fillBlocksRotated(world, sbb, 4, -6, 3, 44, -1, 3, this.deco.blockID, this.deco.blockMeta, rotation);
                for (int i = 9; i < 45; i += 6) {
                    this.makePiling(world, sbb, mid, rotation, i);
                }
                this.makePiling(world, sbb, mid, rotation, 4);
                this.makePiling(world, sbb, mid, rotation, 44);
            }
            this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 21, -2, 0, 1, sbb);
            this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 21, -4, 1, 1, sbb);
            this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 21, -6, 2, 1, sbb);
            this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 27, -2, 0, 1, sbb);
            this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 27, -4, 1, 1, sbb);
            this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 27, -6, 2, 1, sbb);
            return true;
        }
        
        private void makePiling(final World world, final StructureBoundingBox sbb, final int mid, final int rotation, final int i) {
            this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, i, -7, 3, rotation, sbb);
            this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, i, -mid, 2, rotation, sbb);
            this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, i, -1, 0, rotation, sbb);
            this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, i, -3, 1, rotation, sbb);
            this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, i, -5, 2, rotation, sbb);
        }
    }
    
    public static class DungeonSteps extends StructureTFComponent
    {
        public DungeonSteps() {
        }
        
        public DungeonSteps(final Random rand, final int i, final int x, final int y, final int z, final int rotation) {
            this.spawnListIndex = 2;
            this.setCoordBaseMode(rotation);
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox2(x, y, z, -2, -15, -3, 5, 15, 20, rotation);
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
        }
        
        public DungeonSteps buildMoreStepsTowards(final StructureComponent parent, final List list, final Random rand, final int rotation) {
            final int direction = (rotation + this.field_74885_f) % 4;
            int sx = 2;
            final int sy = 0;
            int sz = 17;
            switch (rotation) {
                case 0: {
                    sz -= 5;
                    break;
                }
                case 1: {
                    sx -= 5;
                    break;
                }
                case 2: {
                    sz += 5;
                    break;
                }
                case 3: {
                    sx += 6;
                    break;
                }
            }
            final int dx = this.func_74865_a(sx, sz);
            final int dy = this.func_74862_a(sy);
            final int dz = this.func_74873_b(sx, sz);
            final DungeonSteps steps = new DungeonSteps(rand, this.field_74886_g + 1, dx, dy, dz, direction);
            list.add(steps);
            steps.func_74861_a(this, list, rand);
            return steps;
        }
        
        public DungeonEntrance buildLevelUnder(final StructureComponent parent, final List list, final Random rand, final int level) {
            final int dx = this.func_74865_a(2, 19);
            final int dy = this.func_74862_a(-7);
            final int dz = this.func_74873_b(2, 19);
            final DungeonEntrance room = new DungeonEntrance(rand, 8, dx, dy, dz, this.field_74885_f, level);
            list.add(room);
            room.func_74861_a(this, list, rand);
            return room;
        }
        
        public DungeonForgeRoom buildBossRoomUnder(final StructureComponent parent, final List list, final Random rand) {
            final int dx = this.func_74865_a(2, 19);
            final int dy = this.func_74862_a(-31);
            final int dz = this.func_74873_b(2, 19);
            final DungeonForgeRoom room = new DungeonForgeRoom(rand, 8, dx, dy, dz, this.field_74885_f);
            list.add(room);
            room.func_74861_a((StructureComponent)this, list, rand);
            return room;
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            for (int z = 0; z < 15; ++z) {
                final int y = 14 - z;
                this.func_151556_a(world, sbb, 0, y, z, 4, y, z, this.deco.stairID, this.getStairMeta(3), this.deco.stairID, this.getStairMeta(3), false);
                this.func_74878_a(world, sbb, 0, y + 1, z, 4, y + 6, z);
            }
            this.func_74878_a(world, sbb, 0, 0, 15, 4, 5, 19);
            return true;
        }
    }
    
    public static class DungeonEntrance extends DungeonRoom31
    {
        public boolean hasExit;
        
        public DungeonEntrance() {
            this.hasExit = false;
        }
        
        public DungeonEntrance(final Random rand, final int i, final int x, final int y, final int z, final int direction, final int level) {
            super(rand, i, x, y, z, direction, level);
            this.hasExit = false;
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            this.deco = new StructureTFDecoratorCastle();
            this.deco.blockID = TFBlocks.castleMagic;
            this.deco.blockMeta = 2;
            this.deco.fenceID = TFBlocks.forceField;
            this.deco.fenceMeta = 1;
            super.func_74861_a(this, list, rand);
        }
        
        @Override
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            super.func_74875_a(world, rand, sbb);
            for (int y = 0; y <= this.height; ++y) {
                final int x = this.size / 2 - 2;
                final int z = this.size / 2 - y + 2;
                this.func_151556_a(world, sbb, x, y, z, x + 4, y, z, this.deco.stairID, this.getStairMeta(3), this.deco.stairID, this.getStairMeta(3), false);
                this.func_151556_a(world, sbb, x, 0, z, x + 4, y - 1, z, TFBlocks.deadrock, 0, TFBlocks.deadrock, 0, false);
            }
            this.func_151556_a(world, sbb, 23, 0, 12, 23, 3, 14, TFBlocks.castleDoor, 2, Blocks.field_150350_a, 0, false);
            this.func_151556_a(world, sbb, 23, 4, 12, 23, 4, 14, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
            return true;
        }
        
        @Override
        protected int getForceFieldMeta(final Random decoRNG) {
            return 1;
        }
        
        @Override
        protected int getRuneMeta(final int fieldMeta) {
            return 0;
        }
    }
    
    public static class DungeonExit extends DungeonRoom31
    {
        public DungeonExit() {
        }
        
        public DungeonExit(final Random rand, final int i, final int x, final int y, final int z, final int direction, final int level) {
            super(rand, i, x, y, z, direction, level);
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
            final int bestDir = this.findStairDirectionTowards(parent.func_74874_b().field_78897_a, parent.func_74874_b().field_78896_c);
            final DungeonSteps steps0 = new DungeonSteps(rand, 5, this.field_74887_e.field_78897_a + 15, this.field_74887_e.field_78895_b + 0, this.field_74887_e.field_78896_c + 15, bestDir);
            list.add(steps0);
            steps0.func_74861_a(this, list, rand);
            if (this.level == 1) {
                steps0.buildLevelUnder(parent, list, rand, this.level + 1);
            }
            else {
                steps0.buildBossRoomUnder(parent, list, rand);
            }
        }
        
        @Override
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            super.func_74875_a(world, rand, sbb);
            this.func_151556_a(world, sbb, 7, 0, 16, 7, 3, 18, TFBlocks.castleDoor, 2, Blocks.field_150350_a, 0, false);
            this.func_151556_a(world, sbb, 7, 4, 16, 7, 4, 18, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
            return true;
        }
        
        public int findStairDirectionTowards(final int x, final int z) {
            final int cx = this.field_74887_e.func_78881_e();
            final int cz = this.field_74887_e.func_78891_g();
            final int dx = cx - x;
            final int dz = cz - z;
            int absoluteDir;
            if (Math.abs(dz) >= Math.abs(dx)) {
                absoluteDir = ((dz >= 0) ? 2 : 0);
            }
            else {
                absoluteDir = ((dx >= 0) ? 3 : 1);
            }
            return absoluteDir;
        }
        
        @Override
        protected int getForceFieldMeta(final Random decoRNG) {
            return 1;
        }
        
        @Override
        protected int getRuneMeta(final int fieldMeta) {
            return 0;
        }
    }
    
    public static class DungeonRoom31 extends ComponentTFTowerWing
    {
        public int level;
        
        public DungeonRoom31() {
        }
        
        public DungeonRoom31(final Random rand, final int i, final int x, final int y, final int z, final int direction, final int level) {
            super(i);
            this.setCoordBaseMode(direction);
            this.spawnListIndex = 2;
            this.size = 31;
            this.height = 7;
            this.level = level;
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -15, 0, -15, this.size - 1, this.height - 1, this.size - 1, 0);
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
            final int mySpread = this.func_74877_c() - parent.func_74877_c();
            final int maxSpread = (this.level == 1) ? 2 : 3;
            if (mySpread == maxSpread && !this.isExitBuildForLevel(parent)) {
                int direction = rand.nextInt(4);
                for (int i = 0; i < 8 && !this.isExitBuildForLevel(parent); ++i) {
                    direction = (direction + i) % 4;
                    if (this.addDungeonExit(parent, list, rand, direction)) {
                        this.setExitBuiltForLevel(parent, true);
                    }
                }
            }
            if (mySpread < maxSpread) {
                int direction = rand.nextInt(4);
                for (int i = 0; i < 12; ++i) {
                    direction = (direction + i) % 4;
                    this.addDungeonRoom(parent, list, rand, direction, this.level);
                }
            }
        }
        
        private boolean isExitBuildForLevel(final StructureComponent parent) {
            return parent instanceof DungeonEntrance && ((DungeonEntrance)parent).hasExit;
        }
        
        private void setExitBuiltForLevel(final StructureComponent parent, final boolean exit) {
            if (parent instanceof DungeonEntrance) {
                ((DungeonEntrance)parent).hasExit = exit;
            }
        }
        
        protected boolean addDungeonRoom(final StructureComponent parent, final List list, final Random rand, int rotation, final int level) {
            rotation = (this.field_74885_f + rotation) % 4;
            final ChunkCoordinates rc = this.getNewRoomCoords(rand, rotation);
            final DungeonRoom31 dRoom = new DungeonRoom31(rand, this.field_74886_g + 1, rc.field_71574_a, rc.field_71572_b, rc.field_71573_c, rotation, level);
            final StructureBoundingBox largerBB = new StructureBoundingBox(dRoom.func_74874_b());
            final int expand = 0;
            final StructureBoundingBox structureBoundingBox = largerBB;
            structureBoundingBox.field_78897_a -= expand;
            final StructureBoundingBox structureBoundingBox2 = largerBB;
            structureBoundingBox2.field_78896_c -= expand;
            final StructureBoundingBox structureBoundingBox3 = largerBB;
            structureBoundingBox3.field_78893_d += expand;
            final StructureBoundingBox structureBoundingBox4 = largerBB;
            structureBoundingBox4.field_78892_f += expand;
            final StructureComponent intersect = StructureTFComponent.findIntersectingExcluding(list, largerBB, this);
            if (intersect == null) {
                list.add(dRoom);
                dRoom.func_74861_a(parent, list, rand);
                return true;
            }
            return false;
        }
        
        protected boolean addDungeonExit(final StructureComponent parent, final List list, final Random rand, int rotation) {
            rotation = (this.field_74885_f + rotation) % 4;
            final ChunkCoordinates rc = this.getNewRoomCoords(rand, rotation);
            final DungeonExit dRoom = new DungeonExit(rand, this.field_74886_g + 1, rc.field_71574_a, rc.field_71572_b, rc.field_71573_c, rotation, this.level);
            final StructureComponent intersect = StructureTFComponent.findIntersectingExcluding(list, dRoom.func_74874_b(), this);
            if (intersect == null) {
                list.add(dRoom);
                dRoom.func_74861_a(this, list, rand);
                return true;
            }
            return false;
        }
        
        private ChunkCoordinates getNewRoomCoords(final Random rand, final int rotation) {
            int offset = rand.nextInt(15) - 9;
            if (rand.nextBoolean()) {
                offset += this.size;
            }
            switch (rotation) {
                default: {
                    return new ChunkCoordinates(this.field_74887_e.field_78893_d + 9, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + offset);
                }
                case 1: {
                    return new ChunkCoordinates(this.field_74887_e.field_78897_a + offset, this.field_74887_e.field_78895_b, this.field_74887_e.field_78892_f + 9);
                }
                case 2: {
                    return new ChunkCoordinates(this.field_74887_e.field_78897_a - 9, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c + offset);
                }
                case 3: {
                    return new ChunkCoordinates(this.field_74887_e.field_78897_a + offset, this.field_74887_e.field_78895_b, this.field_74887_e.field_78896_c - 9);
                }
            }
        }
        
        @Override
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            if (this.isBoundingBoxOutOfPlateau(world, sbb)) {
                return false;
            }
            final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
            this.func_74878_a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
            final int forceFieldMeta = this.getForceFieldMeta(decoRNG);
            final int runeMeta = this.getRuneMeta(forceFieldMeta);
            for (int rotation = 0; rotation < 4; ++rotation) {
                final int cs = 7;
                this.fillBlocksRotated(world, sbb, cs, 0, cs + 1, cs, this.height - 1, this.size - 2 - cs, TFBlocks.forceField, forceFieldMeta, rotation);
                for (int z = cs; z < this.size - 1 - cs; z += 4) {
                    this.fillBlocksRotated(world, sbb, cs, 0, z, cs, this.height - 1, z, TFBlocks.castleMagic, runeMeta, rotation);
                    final int y = ((z - cs) % 8 == 0) ? (decoRNG.nextInt(3) + 0) : (decoRNG.nextInt(3) + 4);
                    this.fillBlocksRotated(world, sbb, cs, y, z + 1, cs, y, z + 3, TFBlocks.castleMagic, runeMeta, rotation);
                }
            }
            return true;
        }
        
        private boolean isBoundingBoxOutOfPlateau(final World world, final StructureBoundingBox sbb) {
            final int minX = this.field_74887_e.field_78897_a - 1;
            final int minZ = this.field_74887_e.field_78896_c - 1;
            final int maxX = this.field_74887_e.field_78893_d + 1;
            final int maxZ = this.field_74887_e.field_78892_f + 1;
            for (int x = minX; x <= maxX; ++x) {
                for (int z = minZ; z <= maxZ; ++z) {
                    if (world.func_72807_a(x, z) != TFBiomeBase.highlandsCenter && world.func_72807_a(x, z) != TFBiomeBase.thornlands) {
                        return true;
                    }
                }
            }
            return false;
        }
        
        protected int getRuneMeta(final int forceFieldMeta) {
            return (forceFieldMeta == 4) ? 1 : 2;
        }
        
        protected int getForceFieldMeta(final Random decoRNG) {
            return decoRNG.nextInt(2) + 3;
        }
    }
    
    public static class DungeonForgeRoom extends StructureTFComponent
    {
        public DungeonForgeRoom() {
        }
        
        public DungeonForgeRoom(final Random rand, final int i, final int x, final int y, final int z, final int direction) {
            super(i);
            this.spawnListIndex = 3;
            this.setCoordBaseMode(direction);
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox2(x, y, z, -15, 0, -15, 50, 30, 50, direction);
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            this.func_74878_a(world, sbb, 0, 0, 0, 50, 30, 50);
            this.placeSignAtCurrentPosition(world, 25, 0, 25, "Mini-boss 2", "Gives talisman", sbb);
            return true;
        }
    }
    
    public static class StairTower extends ComponentTFTowerWing
    {
        public StairTower() {
        }
        
        public StairTower(final Random rand, final int i, final int x, final int y, final int z, final int rotation) {
            this.setCoordBaseMode(rotation);
            this.size = 9;
            this.height = 51;
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -4, 0, -4, 8, 50, 8, 0);
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
            final Roof9Crenellated roof = new Roof9Crenellated(rand, 4, this);
            list.add(roof);
            roof.func_74861_a(this, list, rand);
        }
        
        @Override
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
            this.func_74882_a(world, sbb, 0, 0, 0, 8, 49, 8, false, rand, this.deco.randomBlocks);
            for (int numBranches = 6 + decoRNG.nextInt(4), i = 0; i < numBranches; ++i) {
                this.makeGlyphBranches(world, decoRNG, this.getGlyphMeta(), sbb);
            }
            for (int i = 1; i < 4; ++i) {
                this.func_74882_a(world, sbb, i, 0 - i * 2, i, 8 - i, 1 - i * 2, 8 - i, false, rand, this.deco.randomBlocks);
            }
            this.func_151550_a(world, this.deco.blockID, this.deco.blockMeta, 4, -7, 4, sbb);
            this.func_151556_a(world, sbb, 0, 1, 1, 0, 3, 2, TFBlocks.castleDoor, this.getGlyphMeta(), Blocks.field_150350_a, 0, false);
            for (int f = 0; f < 5; ++f) {
                final int rotation = (f + 2) % 4;
                final int y = f * 3 + 1;
                for (int j = 0; j < 3; ++j) {
                    final int sx = 3 + j;
                    final int sy = y + j;
                    final int sz = 1;
                    this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), sx, sy, sz, rotation, sbb);
                    this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, sx, sy - 1, sz, rotation, sbb);
                    this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), sx, sy, sz + 1, rotation, sbb);
                    this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, sx, sy - 1, sz + 1, rotation, sbb);
                }
                this.fillBlocksRotated(world, sbb, 6, y + 2, 1, 7, y + 2, 2, this.deco.blockID, this.deco.blockMeta, rotation);
            }
            this.func_151556_a(world, sbb, 1, 18, 0, 2, 20, 0, TFBlocks.castleDoor, this.getGlyphMeta(), Blocks.field_150350_a, 0, false);
            this.func_151556_a(world, sbb, 1, 17, 1, 3, 17, 3, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
            this.func_151556_a(world, sbb, 1, 17, 4, 2, 17, 4, this.deco.stairID, this.getStairMeta(3), this.deco.stairID, this.getStairMeta(3), false);
            this.func_151556_a(world, sbb, 1, 16, 4, 2, 16, 4, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
            this.func_151556_a(world, sbb, 1, 16, 5, 2, 16, 5, this.deco.stairID, this.getStairMeta(3), this.deco.stairID, this.getStairMeta(3), false);
            this.func_151556_a(world, sbb, 1, 15, 5, 2, 15, 5, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
            this.func_151556_a(world, sbb, 1, 39, 0, 2, 41, 0, TFBlocks.castleDoor, this.getGlyphMeta(), Blocks.field_150350_a, 0, false);
            for (int f = 0; f < 7; ++f) {
                final int rotation = (f + 0) % 4;
                final int y = f * 3 + 18;
                for (int j = 0; j < 3; ++j) {
                    final int sx = 3 + j;
                    final int sy = y + j;
                    final int sz = 1;
                    this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), sx, sy, sz, rotation, sbb);
                    this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, sx, sy - 1, sz, rotation, sbb);
                    this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), sx, sy, sz + 1, rotation, sbb);
                    this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, sx, sy - 1, sz + 1, rotation, sbb);
                }
                this.fillBlocksRotated(world, sbb, 6, y + 2, 1, 7, y + 2, 2, this.deco.blockID, this.deco.blockMeta, rotation);
            }
            this.func_151556_a(world, sbb, 1, 38, 1, 3, 38, 5, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
            this.func_151556_a(world, sbb, 3, 39, 1, 3, 39, 5, this.deco.fenceID, this.deco.fenceMeta, this.deco.fenceID, this.deco.fenceMeta, false);
            return true;
        }
        
        public int getGlyphMeta() {
            return 1;
        }
    }
    
    public static class LargeTower extends ComponentTFTowerWing
    {
        public LargeTower() {
        }
        
        public LargeTower(final Random rand, final int i, final int x, final int y, final int z, final int rotation) {
            this.setCoordBaseMode(rotation);
            this.size = 13;
            this.height = 61;
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -6, 0, -6, 12, 60, 12, 0);
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
            final Roof9Crenellated roof = new Roof9Crenellated(rand, 4, this);
            list.add(roof);
            roof.func_74861_a(this, list, rand);
        }
        
        @Override
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
            this.func_74882_a(world, sbb, 0, 0, 0, 12, 59, 12, false, rand, this.deco.randomBlocks);
            for (int numBranches = 6 + decoRNG.nextInt(4), i = 0; i < numBranches; ++i) {
                this.makeGlyphBranches(world, decoRNG, this.getGlyphMeta(), sbb);
            }
            for (int i = 1; i < 4; ++i) {
                this.func_74882_a(world, sbb, i, 0 - i * 2, i, 8 - i, 1 - i * 2, 8 - i, false, rand, this.deco.randomBlocks);
            }
            this.func_151550_a(world, this.deco.blockID, this.deco.blockMeta, 4, -7, 4, sbb);
            this.func_151556_a(world, sbb, 0, 1, 1, 0, 4, 3, TFBlocks.castleDoor, 0, Blocks.field_150350_a, this.getGlyphMeta(), false);
            this.placeSignAtCurrentPosition(world, 6, 1, 6, "Parkour area 1", "Unique monster?", sbb);
            return true;
        }
        
        public int getGlyphMeta() {
            return 0;
        }
    }
    
    public static class Mural extends StructureTFComponent
    {
        private int height;
        private int width;
        private byte[][] mural;
        
        public Mural() {
        }
        
        public Mural(final Random rand, final int i, final int x, final int y, final int z, final int width, final int height, final int direction) {
            super(i);
            this.setCoordBaseMode(direction);
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox2(x, y, z, 0, -height / 2, -width / 2, 1, height - 1, width - 1, direction);
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            this.height = this.field_74887_e.func_78882_c();
            this.width = ((this.field_74885_f == 0 || this.field_74885_f == 2) ? this.field_74887_e.func_78880_d() : this.field_74887_e.func_78883_b());
            final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
            if (this.mural == null) {
                this.mural = new byte[this.width][this.height];
                final int startX = this.width / 2 - 1;
                final int startY = 2;
                for (int x = -1; x < 2; ++x) {
                    for (int y = -1; y < 2; ++y) {
                        this.mural[startX + x][startY + y] = 1;
                    }
                }
                this.makeHorizontalTree(decoRNG, this.mural, startX + 1, startY, decoRNG.nextInt(this.width / 6) + this.width / 6, true);
                this.makeHorizontalTree(decoRNG, this.mural, startX - 1, startY, decoRNG.nextInt(this.width / 6) + this.width / 6, false);
                this.makeVerticalTree(decoRNG, this.mural, startX, startY + 1, decoRNG.nextInt(this.height / 6) + this.height / 6, true);
                this.makeStripes(decoRNG, this.mural);
            }
            for (int x2 = 0; x2 < this.width; ++x2) {
                for (int y2 = 0; y2 < this.height; ++y2) {
                    if (this.mural[x2][y2] > 0) {
                        this.func_151550_a(world, TFBlocks.castleMagic, 1, 0, y2, x2, sbb);
                    }
                }
            }
            return true;
        }
        
        private void makeHorizontalTree(final Random decoRNG, final byte[][] mural, final int centerX, final int centerY, final int branchLength, final boolean positive) {
            this.fillHorizontalLine(mural, centerX, centerY, branchLength, positive);
            this.makeHorizontalBranch(mural, decoRNG, centerX, centerY, branchLength, positive, true);
            this.makeHorizontalBranch(mural, decoRNG, centerX, centerY, branchLength, positive, false);
        }
        
        private void makeVerticalTree(final Random decoRNG, final byte[][] mural, final int centerX, final int centerY, final int branchLength, final boolean positive) {
            this.fillVerticalLine(mural, centerX, centerY, branchLength, positive);
            this.makeVerticalBranch(mural, decoRNG, centerX, centerY, branchLength, positive, true);
            this.makeVerticalBranch(mural, decoRNG, centerX, centerY, branchLength, positive, false);
        }
        
        private boolean makeHorizontalBranch(final byte[][] mural, final Random rand, final int sx, final int sy, final int length, final boolean plusX, final boolean plusY) {
            final int downLine = length / 2 + 1 + rand.nextInt(Math.max(length / 2, 2));
            final int branchLength = rand.nextInt(this.width / 8) + this.width / 8;
            boolean clear = true;
            for (int i = 0; i <= branchLength; ++i) {
                final int cx = sx + (plusX ? (downLine - 1 + i) : (-(downLine - 1 + i)));
                final int cy = sy + (plusY ? 2 : -2);
                if (cx < 0 || cx >= this.width || cy < 0 || cy >= this.height || mural[cx][cy] > 0) {
                    clear = false;
                    break;
                }
            }
            if (clear) {
                final int bx = sx + (plusX ? downLine : (-downLine));
                int by = sy;
                this.fillVerticalLine(mural, bx, by, 1, plusY);
                by += (plusY ? 2 : -2);
                this.fillHorizontalLine(mural, bx, by, branchLength, plusX);
                if (bx > 0 && bx < this.width && by > 0 && by < this.height) {
                    if (!this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, true) && !this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, true) && !this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, true)) {
                        this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, true);
                    }
                    if (!this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, false) && !this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, false) && !this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, false)) {
                        this.makeHorizontalBranch(mural, rand, bx, by, branchLength, plusX, false);
                    }
                }
                return true;
            }
            return false;
        }
        
        private boolean makeVerticalBranch(final byte[][] mural, final Random rand, final int sx, final int sy, final int length, final boolean plusY, final boolean plusX) {
            final int downLine = length / 2 + 1 + rand.nextInt(Math.max(length / 2, 2));
            final int branchLength = rand.nextInt(this.height / 8) + this.height / 8;
            boolean clear = true;
            for (int i = 0; i <= branchLength; ++i) {
                final int cx = sx + (plusX ? 2 : -2);
                final int cy = sy + (plusY ? (downLine - 1 + i) : (-(downLine - 1 + i)));
                if (cx < 0 || cx >= this.width || cy < 0 || cy >= this.height || mural[cx][cy] > 0) {
                    clear = false;
                    break;
                }
            }
            if (clear) {
                int bx = sx;
                final int by = sy + (plusY ? downLine : (-downLine));
                this.fillHorizontalLine(mural, bx, by, 1, plusX);
                bx += (plusX ? 2 : -2);
                this.fillVerticalLine(mural, bx, by, branchLength, plusY);
                if (bx > 0 && bx < this.width && by > 0 && by < this.height) {
                    if (!this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, true) && !this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, true) && !this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, true)) {
                        this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, true);
                    }
                    if (!this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, false) && !this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, false) && !this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, false)) {
                        this.makeVerticalBranch(mural, rand, bx, by, branchLength, plusY, false);
                    }
                }
                return true;
            }
            return false;
        }
        
        private void fillHorizontalLine(final byte[][] mural, final int sx, final int sy, final int length, final boolean positive) {
            int x = sx;
            final int y = sy;
            for (int i = 0; i <= length; ++i) {
                if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
                    mural[x][y] = (byte)(positive ? 1 : 4);
                    x += (positive ? 1 : -1);
                }
            }
        }
        
        private void fillVerticalLine(final byte[][] mural, final int sx, final int sy, final int length, final boolean positive) {
            final int x = sx;
            int y = sy;
            for (int i = 0; i <= length; ++i) {
                if (x >= 0 && x < this.width && y >= 0 && y < this.height) {
                    mural[x][y] = (byte)(positive ? 2 : 3);
                    y += (positive ? 1 : -1);
                }
            }
        }
        
        private void makeStripes(final Random decoRNG, final byte[][] mural2) {
            for (int y = this.height - 2; y > this.height / 3; y -= 2 + decoRNG.nextInt(2)) {
                this.makeSingleStripe(mural2, y);
            }
        }
        
        private void makeSingleStripe(final byte[][] mural2, final int y) {
            for (int x = 0; x < this.width - 2 && this.mural[x + 1][y] == 0 && this.mural[x + 1][y + 1] == 0; ++x) {
                this.mural[x][y] = 1;
            }
            for (int x = this.width - 1; x > 2 && this.mural[x - 1][y] == 0 && this.mural[x - 1][y + 1] == 0; --x) {
                this.mural[x][y] = 1;
            }
        }
    }
    
    public static class MazeTower13 extends ComponentTFTowerWing
    {
        public static final int LOWEST_DOOR = 144;
        public static final int HIGHEST_DOOR = 222;
        public int type;
        
        public MazeTower13() {
        }
        
        public MazeTower13(final Random rand, final int i, final int x, final int y, final int z, final int type, final int direction) {
            super(i);
            this.setCoordBaseMode(direction);
            this.type = type;
            this.size = 13;
            final int floors = rand.nextInt(3) + 2;
            this.height = floors * 8 + 1;
            int entranceFloor = rand.nextInt(floors);
            if (y - entranceFloor * 8 < 144) {
                entranceFloor = 0;
            }
            if (y + (floors - entranceFloor) * 8 > 222) {
                entranceFloor = floors - 1;
            }
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -6, 0 - entranceFloor * 8, -6, this.size - 1, this.height, this.size - 1, 0);
            this.addOpening(0, entranceFloor * 8 + 1, this.size / 2, 2);
        }
        
        public MazeTower13(final Random rand, final int i, final int x, final int y, final int z, final int floors, final int entranceFloor, final int type, final int direction) {
            super(i);
            this.setCoordBaseMode(direction);
            this.type = type;
            this.size = 13;
            this.height = floors * 8 + 1;
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -6, 0 - entranceFloor * 8, -6, this.size - 1, this.height, this.size - 1, 0);
            this.addOpening(0, entranceFloor * 8 + 1, this.size / 2, 2);
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
            final Foundation13 foundation = new Foundation13(rand, 4, this);
            list.add(foundation);
            foundation.func_74861_a(this, list, rand);
            final StructureTFComponent roof = rand.nextBoolean() ? new Roof13Conical(rand, 4, this) : new Roof13Crenellated(rand, 4, this);
            list.add(roof);
            roof.func_74861_a((StructureComponent)this, list, rand);
        }
        
        public void buildTowards(final StructureComponent parent, final List list, final Random rand, final ChunkCoordinates dest) {
            this.func_74861_a(parent, list, rand);
            if (this.func_74877_c() < 15) {
                if (this.isWithinRange(dest.field_71574_a, dest.field_71573_c, this.field_74887_e.field_78897_a + 6, this.field_74887_e.field_78896_c + 6, 30)) {
                    final int howFar = 20;
                    if (this.buildEndTowerTowards(list, rand, dest, this.findBestDirectionTowards(dest), howFar) || this.buildEndTowerTowards(list, rand, dest, this.findSecondDirectionTowards(dest), howFar) || !this.buildEndTowerTowards(list, rand, dest, this.findThirdDirectionTowards(dest), howFar)) {}
                }
                else {
                    final int howFar = 14 + rand.nextInt(24);
                    int direction = this.findBestDirectionTowards(dest);
                    if (direction == 0 || !this.buildContinueTowerTowards(list, rand, dest, direction, howFar)) {
                        direction = this.findSecondDirectionTowards(dest);
                        if (direction == 0 || !this.buildContinueTowerTowards(list, rand, dest, direction, howFar)) {
                            direction = this.findThirdDirectionTowards(dest);
                            if ((direction != 0 && this.buildContinueTowerTowards(list, rand, dest, direction, howFar)) || !this.buildContinueTowerTowards(list, rand, dest, 0, howFar)) {}
                        }
                    }
                }
            }
            this.buildNonCriticalTowers(parent, list, rand);
        }
        
        protected void buildNonCriticalTowers(final StructureComponent parent, final List list, final Random rand) {
            int dir = rand.nextInt(4);
            if (!this.openingTowards[dir] && !this.buildDamagedTower(list, rand, dir)) {
                dir = (dir + rand.nextInt(4)) % 4;
                if (!this.buildDamagedTower(list, rand, dir)) {}
            }
        }
        
        private int findBestDirectionTowards(final ChunkCoordinates dest) {
            final int cx = this.field_74887_e.field_78897_a + 6;
            final int cz = this.field_74887_e.field_78896_c + 6;
            final int dx = cx - dest.field_71574_a;
            final int dz = cz - dest.field_71573_c;
            int absoluteDir = 0;
            if (Math.abs(dx) > Math.abs(dz)) {
                absoluteDir = ((dx >= 0) ? 2 : 0);
            }
            else {
                absoluteDir = ((dz >= 0) ? 3 : 1);
            }
            final int relativeDir = (absoluteDir + 4 - this.field_74885_f) % 4;
            return relativeDir;
        }
        
        private int findSecondDirectionTowards(final ChunkCoordinates dest) {
            final int cx = this.field_74887_e.field_78897_a + 6;
            final int cz = this.field_74887_e.field_78896_c + 6;
            final int dx = cx - dest.field_71574_a;
            final int dz = cz - dest.field_71573_c;
            int absoluteDir = 0;
            if (Math.abs(dx) < Math.abs(dz)) {
                absoluteDir = ((dx >= 0) ? 2 : 0);
            }
            else {
                absoluteDir = ((dz >= 0) ? 3 : 1);
            }
            final int relativeDir = (absoluteDir + 4 - this.field_74885_f) % 4;
            return relativeDir;
        }
        
        private int findThirdDirectionTowards(final ChunkCoordinates dest) {
            final int first = this.findBestDirectionTowards(dest);
            final int second = this.findSecondDirectionTowards(dest);
            if (first == 0 && second == 1) {
                return 3;
            }
            if (first == 1 && second == 3) {
                return 0;
            }
            return 1;
        }
        
        private boolean buildContinueTowerTowards(final List list, final Random rand, final ChunkCoordinates dest, int direction, final int howFar) {
            final ChunkCoordinates opening = this.getValidOpeningCC(rand, direction);
            final int adjustmentRange = 60;
            if (this.isWithinRange(dest.field_71574_a, dest.field_71573_c, this.field_74887_e.field_78897_a + 6, this.field_74887_e.field_78896_c + 6, adjustmentRange)) {
                opening.field_71572_b = this.adjustOpening(opening.field_71572_b, dest);
            }
            direction += this.field_74885_f;
            direction %= 4;
            final ChunkCoordinates tc = this.offsetTowerCCoords(opening.field_71574_a, opening.field_71572_b, opening.field_71573_c, howFar, direction);
            final StructureComponent start = list.get(0);
            final int centerX = start.func_74874_b().field_78897_a + 128 >> 8 << 8;
            final int centerZ = start.func_74874_b().field_78896_c + 128 >> 8 << 8;
            if (!this.isWithinRange(centerX, centerZ, tc.field_71574_a, tc.field_71573_c, 128)) {
                return false;
            }
            final MazeTower13 sTower = new MazeTower13(rand, this.func_74877_c() + 1, tc.field_71574_a, tc.field_71572_b, tc.field_71573_c, this.type, direction);
            final StructureBoundingBox structureBoundingBox;
            final StructureBoundingBox largerBB = structureBoundingBox = new StructureBoundingBox(sTower.func_74874_b());
            structureBoundingBox.field_78897_a -= 6;
            final StructureBoundingBox structureBoundingBox2 = largerBB;
            structureBoundingBox2.field_78896_c -= 6;
            final StructureBoundingBox structureBoundingBox3 = largerBB;
            structureBoundingBox3.field_78893_d += 6;
            final StructureBoundingBox structureBoundingBox4 = largerBB;
            structureBoundingBox4.field_78892_f += 6;
            largerBB.field_78895_b = 0;
            largerBB.field_78894_e = 255;
            final StructureComponent intersect = StructureComponent.func_74883_a(list, largerBB);
            if (intersect == null) {
                list.add(sTower);
                sTower.buildTowards(this, list, rand, dest);
                final ChunkCoordinates bc = this.offsetTowerCCoords(opening.field_71574_a, opening.field_71572_b, opening.field_71573_c, 1, direction);
                final Bridge bridge = new Bridge(this.func_74877_c() + 1, bc.field_71574_a, bc.field_71572_b, bc.field_71573_c, howFar - 7, direction);
                list.add(bridge);
                bridge.func_74861_a(this, list, rand);
                this.addOpening(opening.field_71574_a, opening.field_71572_b + 1, opening.field_71573_c, direction);
                return true;
            }
            return false;
        }
        
        protected boolean buildDamagedTower(final List list, final Random rand, int direction) {
            final ChunkCoordinates opening = this.getValidOpeningCC(rand, direction);
            direction += this.field_74885_f;
            direction %= 4;
            final int howFar = 14 + rand.nextInt(24);
            final ChunkCoordinates tc = this.offsetTowerCCoords(opening.field_71574_a, opening.field_71572_b, opening.field_71573_c, howFar, direction);
            final MazeTower13 eTower = this.makeNewDamagedTower(rand, direction, tc);
            final StructureBoundingBox structureBoundingBox;
            final StructureBoundingBox largerBB = structureBoundingBox = new StructureBoundingBox(eTower.func_74874_b());
            structureBoundingBox.field_78897_a -= 6;
            final StructureBoundingBox structureBoundingBox2 = largerBB;
            structureBoundingBox2.field_78896_c -= 6;
            final StructureBoundingBox structureBoundingBox3 = largerBB;
            structureBoundingBox3.field_78893_d += 6;
            final StructureBoundingBox structureBoundingBox4 = largerBB;
            structureBoundingBox4.field_78892_f += 6;
            final StructureComponent intersect = StructureComponent.func_74883_a(list, largerBB);
            if (intersect == null) {
                list.add(eTower);
                eTower.func_74861_a(this, list, rand);
                final ChunkCoordinates bc = this.offsetTowerCCoords(opening.field_71574_a, opening.field_71572_b, opening.field_71573_c, 1, direction);
                final Bridge bridge = new Bridge(this.func_74877_c() + 1, bc.field_71574_a, bc.field_71572_b, bc.field_71573_c, howFar - 7, direction);
                list.add(bridge);
                bridge.func_74861_a(this, list, rand);
                this.addOpening(opening.field_71574_a, opening.field_71572_b + 1, opening.field_71573_c, direction);
                return true;
            }
            return false;
        }
        
        protected MazeTower13 makeNewDamagedTower(final Random rand, final int direction, final ChunkCoordinates tc) {
            return new DamagedTower(rand, this.func_74877_c() + 1, tc.field_71574_a, tc.field_71572_b, tc.field_71573_c, direction);
        }
        
        private int adjustOpening(final int posY, final ChunkCoordinates dest) {
            int openY = posY;
            final int realOpeningY = this.func_74862_a(openY);
            if (realOpeningY - dest.field_71572_b < 12) {
                openY = this.height - 9;
            }
            else if (dest.field_71572_b - realOpeningY < 12) {
                openY = 0;
            }
            return openY;
        }
        
        private boolean buildEndTowerTowards(final List list, final Random rand, final ChunkCoordinates dest, int direction, final int howFar) {
            final ChunkCoordinates opening = this.getValidOpeningCC(rand, direction);
            opening.field_71572_b = this.adjustOpening(opening.field_71572_b, dest);
            direction += this.field_74885_f;
            direction %= 4;
            final ChunkCoordinates tc = this.offsetTowerCCoords(opening.field_71574_a, opening.field_71572_b, opening.field_71573_c, howFar, direction);
            MazeTower13 eTower;
            if (this.type == 0) {
                eTower = new EntranceTower(rand, this.func_74877_c() + 1, tc.field_71574_a, tc.field_71572_b, tc.field_71573_c, direction);
            }
            else {
                eTower = new BellTower21(rand, this.func_74877_c() + 1, tc.field_71574_a, tc.field_71572_b, tc.field_71573_c, direction);
            }
            final StructureBoundingBox structureBoundingBox;
            final StructureBoundingBox largerBB = structureBoundingBox = new StructureBoundingBox(eTower.func_74874_b());
            structureBoundingBox.field_78897_a -= 6;
            final StructureBoundingBox structureBoundingBox2 = largerBB;
            structureBoundingBox2.field_78896_c -= 6;
            final StructureBoundingBox structureBoundingBox3 = largerBB;
            structureBoundingBox3.field_78893_d += 6;
            final StructureBoundingBox structureBoundingBox4 = largerBB;
            structureBoundingBox4.field_78892_f += 6;
            final StructureComponent intersect = StructureComponent.func_74883_a(list, largerBB);
            if (intersect == null) {
                list.add(eTower);
                eTower.func_74861_a(this, list, rand);
                final ChunkCoordinates bc = this.offsetTowerCCoords(opening.field_71574_a, opening.field_71572_b, opening.field_71573_c, 1, direction);
                final Bridge bridge = new Bridge(this.func_74877_c() + 1, bc.field_71574_a, bc.field_71572_b, bc.field_71573_c, howFar - 7, direction);
                list.add(bridge);
                bridge.func_74861_a(this, list, rand);
                this.addOpening(opening.field_71574_a, opening.field_71572_b + 1, opening.field_71573_c, direction);
                return true;
            }
            return false;
        }
        
        private boolean isWithinRange(final int centerX, final int centerZ, final int posX, final int posZ, final int range) {
            final boolean inRange = Math.abs(centerX - posX) < range && Math.abs(centerZ - posZ) < range;
            if (!inRange) {}
            return inRange;
        }
        
        public ChunkCoordinates getValidOpeningCC(final Random rand, final int direction) {
            final int floors = this.height / 8;
            if (direction == 0 || direction == 2) {
                final int rx = (direction == 0) ? 12 : 0;
                final int rz = 6;
                final int ry = rand.nextInt(floors) * 8;
                return new ChunkCoordinates(rx, ry, rz);
            }
            if (direction == 1 || direction == 3) {
                final int rx = 6;
                final int rz = (direction == 1) ? 12 : 0;
                final int ry = rand.nextInt(floors) * 8;
                return new ChunkCoordinates(rx, ry, rz);
            }
            return new ChunkCoordinates(0, 0, 0);
        }
        
        @Override
        protected ChunkCoordinates offsetTowerCCoords(final int x, final int y, final int z, final int howFar, final int direction) {
            int dx = this.func_74865_a(x, z);
            final int dy = this.func_74862_a(y);
            int dz = this.func_74873_b(x, z);
            switch (direction) {
                case 0: {
                    dx += howFar;
                    break;
                }
                case 1: {
                    dz += howFar;
                    break;
                }
                case 2: {
                    dx -= howFar;
                    break;
                }
                case 3: {
                    dz -= howFar;
                    break;
                }
            }
            return new ChunkCoordinates(dx, dy, dz);
        }
        
        @Override
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
            this.func_74882_a(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, false, rand, this.deco.randomBlocks);
            for (int x = 0; x < this.size; ++x) {
                for (int z = 0; z < this.size; ++z) {
                    this.func_151554_b(world, this.deco.blockID, this.deco.blockMeta, x, -1, z, sbb);
                }
            }
            for (int numBranches = 2 + decoRNG.nextInt(4) + decoRNG.nextInt(3), i = 0; i < numBranches; ++i) {
                this.makeGlyphBranches(world, decoRNG, this.getGlyphMeta(), sbb);
            }
            this.addFloors(world, decoRNG, sbb);
            this.makeOpenings(world, sbb);
            return true;
        }
        
        public int getGlyphMeta() {
            return this.type;
        }
        
        private void addFloors(final World world, final Random rand, final StructureBoundingBox sbb) {
            final int floors = this.highestOpening / 8 + 1;
            for (int i = 1; i < floors; ++i) {
                this.func_151556_a(world, sbb, 1, i * 8, 1, 11, i * 8, 11, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
                this.addStairsDown(world, sbb, (i + 2) % 4, i * 8);
            }
            if (this.hasAccessibleRoof()) {
                this.addStairsDown(world, sbb, (floors + 2) % 4, this.height - 1);
            }
        }
        
        protected boolean hasAccessibleRoof() {
            return this.height - this.highestOpening < 9;
        }
        
        private void addStairsDown(final World world, final StructureBoundingBox sbb, final int rotation, final int y) {
            for (int i = 0; i < 4; ++i) {
                final int sx = 8 - i;
                final int sy = y - i;
                final int sz = 9;
                this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), sx, sy, sz, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, sx, sy - 1, sz, rotation, sbb);
                this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(0 + rotation), sx, sy, sz - 1, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, sx, sy - 1, sz - 1, rotation, sbb);
                this.fillAirRotated(world, sbb, sx, sy + 1, sz - 1, sx, sy + 3, sz, rotation);
            }
            this.fillBlocksRotated(world, sbb, 3, y - 4, 8, 4, y - 4, 9, this.deco.blockID, this.deco.blockMeta, rotation);
            for (int i = 0; i < 4; ++i) {
                final int sx = 4;
                final int sy = y - i - 4;
                final int sz = 7 - i;
                this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation), sx, sy, sz, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, sx, sy - 1, sz, rotation, sbb);
                this.placeBlockRotated(world, this.deco.stairID, this.getStairMeta(1 + rotation), sx - 1, sy, sz, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, sx - 1, sy - 1, sz, rotation, sbb);
                this.fillAirRotated(world, sbb, sx, sy + 1, sz, sx - 1, sy + 3, sz, rotation);
            }
        }
        
        @Override
        protected void makeDoorOpening(final World world, final int dx, final int dy, final int dz, final StructureBoundingBox sbb) {
            if (dx == 0 || dx == this.size - 1) {
                this.func_151556_a(world, sbb, dx, dy - 1, dz - 2, dx, dy + 4, dz + 2, this.deco.accentID, this.deco.accentMeta, Blocks.field_150350_a, 0, false);
                this.func_151556_a(world, sbb, dx, dy, dz - 1, dx, dy + 3, dz + 1, TFBlocks.castleDoor, this.getGlyphMeta(), Blocks.field_150350_a, 0, false);
            }
            if (dz == 0 || dz == this.size - 1) {
                this.func_151556_a(world, sbb, dx - 2, dy - 1, dz, dx + 2, dy + 4, dz, this.deco.accentID, this.deco.accentMeta, Blocks.field_150350_a, 0, false);
                this.func_151556_a(world, sbb, dx - 1, dy, dz, dx + 1, dy + 3, dz, TFBlocks.castleDoor, this.getGlyphMeta(), Blocks.field_150350_a, 0, false);
            }
        }
    }
    
    public static class EntranceTower extends MazeTower13
    {
        public EntranceTower() {
        }
        
        public EntranceTower(final Random rand, final int i, final int x, final int y, final int z, final int direction) {
            super(rand, i, x, y, z, 3, 2, 0, direction);
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
            final Foundation13 foundation = new Foundation13(rand, 4, this);
            list.add(foundation);
            foundation.func_74861_a(this, list, rand);
            final StructureTFComponent roof = new Roof13Peaked(rand, 4, this);
            list.add(roof);
            roof.func_74861_a((StructureComponent)this, list, rand);
            final int missingFloors = (this.field_74887_e.field_78895_b - 127) / 8;
            final int bottomFloors = missingFloors / 2;
            final int middleFloors = missingFloors - bottomFloors;
            int direction = 1;
            final int howFar = 20;
            if (!this.buildSideTower(list, rand, middleFloors + 1, direction, howFar)) {
                direction = 3;
                if (!this.buildSideTower(list, rand, middleFloors + 1, direction, howFar)) {
                    direction = 0;
                    if (!this.buildSideTower(list, rand, middleFloors + 1, direction, howFar)) {}
                }
            }
            final int brDirection = (direction + this.field_74885_f) % 4;
            final EntranceBottomTower eTower = new EntranceBottomTower(rand, this.func_74877_c() + 1, this.field_74887_e.field_78897_a + 6, this.field_74887_e.field_78895_b - middleFloors * 8, this.field_74887_e.field_78896_c + 6, bottomFloors + 1, bottomFloors, (brDirection + 2) % 4);
            list.add(eTower);
            eTower.func_74861_a(this, list, rand);
            final ChunkCoordinates validOpeningCC;
            final ChunkCoordinates opening = validOpeningCC = this.getValidOpeningCC(rand, direction);
            validOpeningCC.field_71572_b -= middleFloors * 8;
            final ChunkCoordinates bc = this.offsetTowerCCoords(opening.field_71574_a, opening.field_71572_b, opening.field_71573_c, 1, brDirection);
            final Bridge bridge = new Bridge(this.func_74877_c() + 1, bc.field_71574_a, bc.field_71572_b, bc.field_71573_c, howFar - 7, brDirection);
            list.add(bridge);
            bridge.func_74861_a(this, list, rand);
        }
        
        private boolean buildSideTower(final List list, final Random rand, final int middleFloors, int direction, final int howFar) {
            final ChunkCoordinates opening = this.getValidOpeningCC(rand, direction);
            direction += this.field_74885_f;
            direction %= 4;
            final ChunkCoordinates tc = this.offsetTowerCCoords(opening.field_71574_a, opening.field_71572_b, opening.field_71573_c, howFar, direction);
            final EntranceSideTower eTower = new EntranceSideTower(rand, this.func_74877_c() + 1, tc.field_71574_a, tc.field_71572_b, tc.field_71573_c, middleFloors, middleFloors - 1, direction);
            final StructureBoundingBox structureBoundingBox;
            final StructureBoundingBox largerBB = structureBoundingBox = new StructureBoundingBox(eTower.func_74874_b());
            structureBoundingBox.field_78897_a -= 6;
            final StructureBoundingBox structureBoundingBox2 = largerBB;
            structureBoundingBox2.field_78896_c -= 6;
            final StructureBoundingBox structureBoundingBox3 = largerBB;
            structureBoundingBox3.field_78893_d += 6;
            final StructureBoundingBox structureBoundingBox4 = largerBB;
            structureBoundingBox4.field_78892_f += 6;
            final StructureComponent intersect = StructureComponent.func_74883_a(list, largerBB);
            if (intersect == null) {
                list.add(eTower);
                eTower.func_74861_a(this, list, rand);
                final ChunkCoordinates bc = this.offsetTowerCCoords(opening.field_71574_a, opening.field_71572_b, opening.field_71573_c, 1, direction);
                final Bridge bridge = new Bridge(this.func_74877_c() + 1, bc.field_71574_a, bc.field_71572_b, bc.field_71573_c, howFar - 7, direction);
                list.add(bridge);
                bridge.func_74861_a(this, list, rand);
                this.addOpening(opening.field_71574_a, opening.field_71572_b + 1, opening.field_71573_c, direction);
                return true;
            }
            System.out.println("side entrance tower blocked");
            return false;
        }
        
        @Override
        public ChunkCoordinates getValidOpeningCC(final Random rand, final int direction) {
            if (direction == 0 || direction == 2) {
                final int rx = (direction == 0) ? 12 : 0;
                final int rz = 6;
                final int ry = 0;
                return new ChunkCoordinates(rx, ry, rz);
            }
            if (direction == 1 || direction == 3) {
                final int rx = 6;
                final int rz = (direction == 1) ? 12 : 0;
                final int ry = 0;
                return new ChunkCoordinates(rx, ry, rz);
            }
            return new ChunkCoordinates(0, 0, 0);
        }
    }
    
    public static class EntranceSideTower extends MazeTower13
    {
        public EntranceSideTower() {
        }
        
        public EntranceSideTower(final Random rand, final int i, final int x, final int y, final int z, final int floors, final int entranceFloor, final int direction) {
            super(rand, i, x, y, z, floors, entranceFloor, 0, direction);
            this.addOpening(0, 1, this.size / 2, 2);
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
            final Foundation13 foundation = new Foundation13(rand, 4, this);
            list.add(foundation);
            foundation.func_74861_a(this, list, rand);
            final StructureTFComponent roof = new Roof13Peaked(rand, 4, this);
            list.add(roof);
            roof.func_74861_a((StructureComponent)this, list, rand);
        }
    }
    
    public static class EntranceBottomTower extends MazeTower13
    {
        public EntranceBottomTower() {
        }
        
        public EntranceBottomTower(final Random rand, final int i, final int x, final int y, final int z, final int floors, final int entranceFloor, final int direction) {
            super(rand, i, x, y, z, floors, entranceFloor, 0, direction);
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
            this.addStairs(list, rand, this.func_74877_c() + 1, this.size - 1, 1, this.size / 2, 0);
            this.addStairs(list, rand, this.func_74877_c() + 1, 0, 1, this.size / 2, 2);
            this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, 0, 3);
            this.addStairs(list, rand, this.func_74877_c() + 1, this.size / 2, 1, this.size - 1, 1);
        }
        
        private boolean addStairs(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int rotation) {
            this.addOpening(x, y, z, rotation);
            final int direction = (this.getCoordBaseMode() + rotation) % 4;
            final ChunkCoordinates dx = this.offsetTowerCCoords(x, y, z, 0, direction);
            final EntranceStairs stairs = new EntranceStairs(index, dx.field_71574_a, dx.field_71572_b, dx.field_71573_c, direction);
            list.add(stairs);
            stairs.func_74861_a(list.get(0), list, rand);
            return true;
        }
        
        @Override
        protected boolean hasAccessibleRoof() {
            return false;
        }
    }
    
    public static class EntranceStairs extends StructureTFComponent
    {
        public EntranceStairs() {
        }
        
        public EntranceStairs(final int index, final int x, final int y, final int z, final int direction) {
            this.setCoordBaseMode(direction);
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox2(x, y, z, 0, -1, -5, 12, 0, 12, direction);
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            for (int size = 13, x = 1; x < size; ++x) {
                this.placeStairs(world, sbb, x, 1 - x, 5, 2);
                for (int z = 0; z <= x; ++z) {
                    if (z > 0 && z <= size / 2) {
                        this.placeStairs(world, sbb, x, 1 - x, 5 - z, 2);
                        this.placeStairs(world, sbb, x, 1 - x, 5 + z, 2);
                    }
                    if (x <= size / 2) {
                        this.placeStairs(world, sbb, z, 1 - x, 5 - x, 1);
                        this.placeStairs(world, sbb, z, 1 - x, 5 + x, 3);
                    }
                }
            }
            this.func_151554_b(world, this.deco.blockID, this.deco.blockMeta, 0, 0, 5, sbb);
            return true;
        }
        
        private void placeStairs(final World world, final StructureBoundingBox sbb, final int x, final int y, final int z, final int stairMeta) {
            if (this.func_151548_a(world, x, y, z, sbb).isReplaceable((IBlockAccess)world, x, y, z)) {
                this.func_151550_a(world, this.deco.stairID, this.getStairMeta(stairMeta), x, y, z, sbb);
                this.func_151554_b(world, this.deco.blockID, this.deco.blockMeta, x, y - 1, z, sbb);
            }
        }
    }
    
    public static class BellTower21 extends MazeTower13
    {
        private static final int FLOORS = 8;
        
        public BellTower21() {
        }
        
        public BellTower21(final Random rand, final int i, final int x, final int y, final int z, final int direction) {
            super(rand, i, x, y, z, 8, 1, 1, direction);
            this.size = 21;
            final int floors = 8;
            this.height = floors * 8 + 1;
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox2(x, y, z, -6, -8, -this.size / 2, this.size - 1, this.height, this.size - 1, direction);
            this.openings.clear();
            this.addOpening(0, 9, this.size / 2, 2);
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
            final BellFoundation21 foundation = new BellFoundation21(rand, 4, this);
            list.add(foundation);
            foundation.func_74861_a(this, list, rand);
            final StructureTFComponent roof = new Roof13Crenellated(rand, 4, this);
            list.add(roof);
            roof.func_74861_a((StructureComponent)this, list, rand);
        }
        
        @Override
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            super.func_74875_a(world, rand, sbb);
            final Block fieldBlock = TFBlocks.forceField;
            final int fieldMeta = 4;
            for (int rotation = 0; rotation < 4; ++rotation) {
                int y = 48;
                for (int x = 5; x < this.size - 4; x += 2) {
                    this.fillBlocksRotated(world, sbb, x, y, 0, x, y + 14, 0, fieldBlock, fieldMeta, rotation);
                }
                y = 24;
                for (int x = 1; x < this.size - 1; x += 8) {
                    this.fillBlocksRotated(world, sbb, x, y, 0, x, y + 14, 0, fieldBlock, fieldMeta, rotation);
                    this.fillBlocksRotated(world, sbb, x + 2, y, 0, x + 2, y + 14, 0, fieldBlock, fieldMeta, rotation);
                }
            }
            this.placeSignAtCurrentPosition(world, 7, 9, 8, "Parkour area 2", "mini-boss 1", sbb);
            return true;
        }
    }
    
    public static class DamagedTower extends MazeTower13
    {
        public DamagedTower() {
        }
        
        public DamagedTower(final Random rand, final int i, final int x, final int y, final int z, final int direction) {
            super(rand, i, x, y, z, 2, direction);
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
            final Foundation13 foundation = new Foundation13(rand, 0, this);
            list.add(foundation);
            foundation.func_74861_a(this, list, rand);
            final Foundation13 thorns = new Foundation13Thorns(rand, 0, this);
            list.add(thorns);
            thorns.func_74861_a(this, list, rand);
            this.buildNonCriticalTowers(parent, list, rand);
        }
        
        @Override
        protected MazeTower13 makeNewDamagedTower(final Random rand, final int direction, final ChunkCoordinates tc) {
            return new WreckedTower(rand, this.func_74877_c() + 1, tc.field_71574_a, tc.field_71572_b, tc.field_71573_c, direction);
        }
        
        @Override
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            super.func_74875_a(world, rand, sbb);
            final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
            this.destroyTower(world, decoRNG, sbb);
            return true;
        }
        
        public void destroyTower(final World world, final Random rand, final StructureBoundingBox sbb) {
            final ArrayList<DestroyArea> areas = this.makeInitialDestroyList(rand);
            boolean hitDeadRock = false;
            for (int y = this.field_74887_e.field_78894_e; !hitDeadRock && y > 64; --y) {
                for (int x = this.field_74887_e.field_78897_a - 2; x <= this.field_74887_e.field_78893_d + 2; ++x) {
                    for (int z = this.field_74887_e.field_78896_c - 2; z <= this.field_74887_e.field_78892_f + 2; ++z) {
                        if (sbb.func_78890_b(x, y, z)) {
                            if (world.func_147439_a(x, y, z) == TFBlocks.deadrock) {
                                hitDeadRock = true;
                            }
                            this.determineBlockDestroyed(world, areas, y, x, z);
                        }
                    }
                }
                DestroyArea removeArea = null;
                for (final DestroyArea dArea : areas) {
                    if (dArea == null || dArea.isEntirelyAbove(y)) {
                        removeArea = dArea;
                    }
                }
                if (removeArea != null) {
                    areas.remove(removeArea);
                    areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, y, areas));
                }
            }
        }
        
        protected ArrayList<DestroyArea> makeInitialDestroyList(final Random rand) {
            final ArrayList<DestroyArea> areas = new ArrayList<DestroyArea>(2);
            areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
            areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
            areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
            return areas;
        }
        
        protected void determineBlockDestroyed(final World world, final ArrayList<DestroyArea> areas, final int y, final int x, final int z) {
            for (final DestroyArea dArea : areas) {
                if (dArea != null && dArea.isVecInside(x, y, z)) {
                    world.func_147468_f(x, y, z);
                }
            }
        }
    }
    
    public static class DestroyArea
    {
        StructureBoundingBox destroyBox;
        
        public DestroyArea(final StructureBoundingBox tower, final Random rand, final int y) {
            final int bx = tower.field_78897_a - 2 + rand.nextInt(tower.func_78883_b());
            final int bz = tower.field_78896_c - 2 + rand.nextInt(tower.func_78880_d());
            this.destroyBox = new StructureBoundingBox(bx, y - 10, bz, bx + 4, y, bz + 4);
        }
        
        public boolean isEntirelyAbove(final int y) {
            return this.destroyBox.field_78895_b > y;
        }
        
        public boolean isVecInside(final int x, final int y, final int z) {
            return this.destroyBox.func_78890_b(x, y, z);
        }
        
        public static DestroyArea createNonIntersecting(final StructureBoundingBox tower, final Random rand, final int y, final ArrayList<DestroyArea> otherAreas) {
            final int attempts = 100;
            DestroyArea area = null;
            for (int i = 0; i < attempts && area == null; ++i) {
                final DestroyArea testArea = new DestroyArea(tower, rand, y);
                if (otherAreas.size() == 0) {
                    area = testArea;
                }
                else {
                    for (final DestroyArea otherArea : otherAreas) {
                        if (otherArea == null || !testArea.intersectsWith(otherArea)) {
                            area = testArea;
                        }
                    }
                }
            }
            return area;
        }
        
        private boolean intersectsWith(final DestroyArea otherArea) {
            return this.destroyBox.func_78885_a(otherArea.destroyBox.field_78897_a - 1, otherArea.destroyBox.field_78896_c - 1, otherArea.destroyBox.field_78893_d + 1, otherArea.destroyBox.field_78893_d + 1);
        }
    }
    
    public static class WreckedTower extends DamagedTower
    {
        public WreckedTower() {
        }
        
        public WreckedTower(final Random rand, final int i, final int x, final int y, final int z, final int direction) {
            super(rand, i, x, y, z, direction);
        }
        
        @Override
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
            final Foundation13 thorns = new Foundation13Thorns(rand, 0, this);
            list.add(thorns);
            thorns.func_74861_a(this, list, rand);
        }
        
        @Override
        public int getGlyphMeta() {
            return 1;
        }
        
        @Override
        protected void determineBlockDestroyed(final World world, final ArrayList<DestroyArea> areas, final int y, final int x, final int z) {
            boolean isInside = false;
            for (final DestroyArea dArea : areas) {
                if (dArea != null && dArea.isVecInside(x, y, z)) {
                    isInside = true;
                }
            }
            if (!isInside) {
                world.func_147468_f(x, y, z);
            }
        }
        
        @Override
        protected ArrayList<DestroyArea> makeInitialDestroyList(final Random rand) {
            final ArrayList<DestroyArea> areas = new ArrayList<DestroyArea>(2);
            areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
            areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
            areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
            areas.add(DestroyArea.createNonIntersecting(this.func_74874_b(), rand, this.func_74874_b().field_78894_e - 1, areas));
            return areas;
        }
    }
    
    public static class Bridge extends StructureTFComponent
    {
        public Bridge() {
        }
        
        public Bridge(final int i, final int x, final int y, final int z, final int length, final int direction) {
            this.setCoordBaseMode(direction);
            this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox2(x, y, z, 0, -1, -3, length - 1, 5, 6, direction);
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            final int length = (this.field_74885_f == 0 || this.field_74885_f == 2) ? (this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a) : (this.field_74887_e.field_78892_f - this.field_74887_e.field_78896_c);
            this.func_74882_a(world, sbb, 0, 0, 0, length, 1, 6, false, rand, this.deco.randomBlocks);
            this.func_74882_a(world, sbb, 0, 1, 0, length, 2, 0, false, rand, this.deco.randomBlocks);
            this.func_74882_a(world, sbb, 0, 1, 6, length, 2, 6, false, rand, this.deco.randomBlocks);
            for (int l3 = length / 3, i = 0; i < l3; ++i) {
                final int sl = l3 - (int)(MathHelper.func_76134_b((l3 - i) / (float)l3 * 1.6f) * l3);
                this.func_74882_a(world, sbb, i, -sl, 0, i, 0, 0, false, rand, this.deco.randomBlocks);
                this.func_74882_a(world, sbb, i, -sl, 6, i, 0, 6, false, rand, this.deco.randomBlocks);
                this.func_74882_a(world, sbb, length - i, -sl, 0, length - i, 0, 0, false, rand, this.deco.randomBlocks);
                this.func_74882_a(world, sbb, length - i, -sl, 6, length - i, 0, 6, false, rand, this.deco.randomBlocks);
            }
            this.func_151556_a(world, sbb, 0, 2, 1, 0, 7, 1, this.deco.pillarID, this.deco.pillarMeta, this.deco.pillarID, this.deco.pillarMeta, false);
            this.func_151556_a(world, sbb, 0, 2, 5, 0, 7, 5, this.deco.pillarID, this.deco.pillarMeta, this.deco.pillarID, this.deco.pillarMeta, false);
            this.func_151556_a(world, sbb, 0, 6, 2, 0, 6, 4, this.deco.accentID, this.deco.accentMeta, this.deco.accentID, this.deco.accentMeta, false);
            this.func_151550_a(world, this.deco.pillarID, this.deco.pillarMeta, 0, 7, 3, sbb);
            this.func_151556_a(world, sbb, length, 2, 1, length, 7, 1, this.deco.pillarID, this.deco.pillarMeta, this.deco.pillarID, this.deco.pillarMeta, false);
            this.func_151556_a(world, sbb, length, 2, 5, length, 7, 5, this.deco.pillarID, this.deco.pillarMeta, this.deco.pillarID, this.deco.pillarMeta, false);
            this.func_151556_a(world, sbb, length, 6, 2, length, 6, 4, this.deco.accentID, this.deco.accentMeta, this.deco.accentID, this.deco.accentMeta, false);
            this.func_151550_a(world, this.deco.pillarID, this.deco.pillarMeta, length, 7, 3, sbb);
            return true;
        }
    }
    
    public static class Roof9Crenellated extends StructureTFComponent
    {
        public Roof9Crenellated() {
        }
        
        public Roof9Crenellated(final Random rand, final int i, final StructureTFComponent sideTower) {
            super(i);
            final int height = 5;
            this.setCoordBaseMode(sideTower.getCoordBaseMode());
            this.field_74887_e = new StructureBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78894_e - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78894_e + height - 1, sideTower.func_74874_b().field_78892_f + 2);
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            for (int rotation = 0; rotation < 4; ++rotation) {
                this.fillBlocksRotated(world, sbb, 0, -1, 0, 2, 3, 2, this.deco.blockID, this.deco.blockMeta, rotation);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -2, 2, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -2, 1, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 2, -2, 1, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 3, 0, 1, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 3, 1, 1, rotation, sbb);
                this.fillBlocksRotated(world, sbb, 4, 0, 0, 5, 3, 2, this.deco.blockID, this.deco.blockMeta, rotation);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 6, 0, 1, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 6, 1, 1, rotation, sbb);
                this.fillBlocksRotated(world, sbb, 7, 0, 0, 8, 3, 2, this.deco.blockID, this.deco.blockMeta, rotation);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 9, 0, 1, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 9, 1, 1, rotation, sbb);
            }
            return true;
        }
    }
    
    public static class Roof13Conical extends StructureTFComponent
    {
        public int slope;
        
        public Roof13Conical() {
        }
        
        public Roof13Conical(final Random rand, final int i, final StructureTFComponent sideTower) {
            super(i);
            this.slope = 2 + rand.nextInt(3) + rand.nextInt(3);
            final int height = this.slope * 4;
            this.setCoordBaseMode(sideTower.getCoordBaseMode());
            this.field_74887_e = new StructureBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78894_e - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78894_e + height - 1, sideTower.func_74874_b().field_78892_f + 2);
        }
        
        @Override
        protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
            super.func_143012_a(par1NBTTagCompound);
            par1NBTTagCompound.func_74768_a("slope", this.slope);
        }
        
        @Override
        protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
            super.func_143011_b(par1NBTTagCompound);
            this.slope = par1NBTTagCompound.func_74762_e("slope");
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            for (int rotation = 0; rotation < 4; ++rotation) {
                this.fillBlocksRotated(world, sbb, 0, -1, 0, 3, 2, 3, this.deco.blockID, this.deco.blockMeta, rotation);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -2, 2, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -2, 1, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 2, -2, 1, rotation, sbb);
                this.fillBlocksRotated(world, sbb, 4, 0, 1, 12, 1, 1, this.deco.blockID, this.deco.blockMeta, rotation);
                for (int i = 3; i < 13; i += 2) {
                    this.fillBlocksRotated(world, sbb, i, -1, 1, i, 2, 1, this.deco.blockID, this.deco.blockMeta, rotation);
                }
                for (int i = 2; i < 9; ++i) {
                    final int base = 2 - this.slope;
                    if (i < 7) {
                        this.fillBlocksRotated(world, sbb, i - 1, (i - 1) * this.slope + base, i - 1, i, i * this.slope + base - 1, i, this.deco.blockID, this.deco.blockMeta, rotation);
                    }
                    else {
                        this.fillBlocksRotated(world, sbb, 16 - i, (i - 1) * this.slope + base, i, 16 - i, i * this.slope + base - 1, i, this.deco.roofID, this.deco.roofMeta, rotation);
                    }
                    this.fillBlocksRotated(world, sbb, i + 1, (i - 1) * this.slope + base, i, 15 - i, i * this.slope + base - 1, i, this.deco.roofID, this.deco.roofMeta, rotation);
                }
                this.fillBlocksRotated(world, sbb, 8, this.slope * 6 + 2, 8, 8, this.slope * 7 + 2, 8, this.deco.roofID, this.deco.roofMeta, rotation);
            }
            return true;
        }
    }
    
    public static class Roof13Crenellated extends StructureTFComponent
    {
        public Roof13Crenellated() {
        }
        
        public Roof13Crenellated(final Random rand, final int i, final StructureTFComponent sideTower) {
            super(i);
            final int height = 5;
            this.setCoordBaseMode(sideTower.getCoordBaseMode());
            this.field_74887_e = new StructureBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78894_e - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78894_e + height - 1, sideTower.func_74874_b().field_78892_f + 2);
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            final int size = this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a;
            for (int rotation = 0; rotation < 4; ++rotation) {
                this.fillBlocksRotated(world, sbb, 0, -1, 0, 3, 3, 3, this.deco.blockID, this.deco.blockMeta, rotation);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -2, 2, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -2, 1, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 2, -2, 1, rotation, sbb);
                this.fillBlocksRotated(world, sbb, 4, 0, 1, size - 4, 1, 1, this.deco.blockID, this.deco.blockMeta, rotation);
                for (int x = 5; x < size - 5; x += 4) {
                    this.fillBlocksRotated(world, sbb, x, 0, 0, x + 2, 3, 2, this.deco.blockID, this.deco.blockMeta, rotation);
                    this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, x + 1, -1, 1, rotation, sbb);
                    this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, x + 1, -2, 1, rotation, sbb);
                }
            }
            return true;
        }
    }
    
    public static class Roof13Peaked extends StructureTFComponent
    {
        public Roof13Peaked() {
        }
        
        public Roof13Peaked(final Random rand, final int i, final StructureTFComponent sideTower) {
            super(i);
            final int height = 18;
            this.setCoordBaseMode(sideTower.getCoordBaseMode());
            this.field_74887_e = new StructureBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78894_e - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78894_e + height - 1, sideTower.func_74874_b().field_78892_f + 2);
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            for (int i = 0; i < 3; ++i) {
                this.func_151556_a(world, sbb, 1, i, i, 15, i, i, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 1, i, 16 - i, 15, i, 16 - i, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
            }
            for (int i = 0; i < 3; ++i) {
                int dz = 3 + i;
                this.func_151556_a(world, sbb, 2, 5 + (i - 1) * 2, dz, 14, 4 + i * 2, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 1, 1, dz, 1, 5 + (i - 1) * 2, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 1, 5 + (i - 1) * 2, dz - 1, 1, 4 + i * 2, dz, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
                this.func_151556_a(world, sbb, 15, 1, dz, 15, 5 + (i - 1) * 2, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 15, 5 + (i - 1) * 2, dz - 1, 15, 4 + i * 2, dz, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
                dz = 13 - i;
                this.func_151556_a(world, sbb, 2, 5 + (i - 1) * 2, dz, 14, 4 + i * 2, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 1, 1, dz, 1, 5 + (i - 1) * 2, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 1, 5 + (i - 1) * 2, dz, 1, 4 + i * 2, dz + 1, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
                this.func_151556_a(world, sbb, 15, 1, dz, 15, 5 + (i - 1) * 2, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 15, 5 + (i - 1) * 2, dz, 15, 4 + i * 2, dz + 1, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
            }
            for (int i = 0; i < 3; ++i) {
                int dz = 6 + i;
                this.func_151556_a(world, sbb, 2, 12 + (i - 1) * 3, dz, 14, 11 + i * 3, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 1, 1, dz, 1, 12 + (i - 1) * 3, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 1, 12 + (i - 1) * 3, dz - 1, 1, 11 + i * 3, dz, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
                this.func_151556_a(world, sbb, 15, 1, dz, 15, 12 + (i - 1) * 3, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 15, 12 + (i - 1) * 3, dz - 1, 15, 11 + i * 3, dz, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
                dz = 10 - i;
                this.func_151556_a(world, sbb, 2, 12 + (i - 1) * 3, dz, 14, 11 + i * 3, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 1, 1, dz, 1, 12 + (i - 1) * 3, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 1, 12 + (i - 1) * 3, dz, 1, 11 + i * 3, dz + 1, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
                this.func_151556_a(world, sbb, 15, 1, dz, 15, 12 + (i - 1) * 3, dz, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
                this.func_151556_a(world, sbb, 15, 12 + (i - 1) * 3, dz, 15, 11 + i * 3, dz + 1, this.deco.blockID, this.deco.blockMeta, this.deco.blockID, this.deco.blockMeta, false);
            }
            this.func_151556_a(world, sbb, 1, 18, 8, 5, 18, 8, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
            this.func_151556_a(world, sbb, 11, 18, 8, 14, 18, 8, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
            this.func_151556_a(world, sbb, 0, 17, 8, 1, 19, 8, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
            this.func_151556_a(world, sbb, 15, 17, 8, 16, 19, 8, this.deco.roofID, this.deco.roofMeta, this.deco.roofID, this.deco.roofMeta, false);
            for (int rotation = 1; rotation < 4; rotation += 2) {
                this.fillBlocksRotated(world, sbb, 4, 0, 1, 12, 1, 1, this.deco.blockID, this.deco.blockMeta, rotation);
                for (int j = 3; j < 13; j += 2) {
                    this.fillBlocksRotated(world, sbb, j, -1, 1, j, 2, 1, this.deco.blockID, this.deco.blockMeta, rotation);
                }
            }
            for (int rotation = 0; rotation < 4; ++rotation) {
                this.fillBlocksRotated(world, sbb, 0, -1, 0, 3, 2, 3, this.deco.blockID, this.deco.blockMeta, rotation);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -2, 2, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -2, 1, rotation, sbb);
                this.placeBlockRotated(world, this.deco.blockID, this.deco.blockMeta, 2, -2, 1, rotation, sbb);
            }
            return true;
        }
    }
    
    public static class Foundation13 extends StructureTFComponent
    {
        protected int groundLevel;
        
        public Foundation13() {
            this.groundLevel = -1;
        }
        
        public Foundation13(final Random rand, final int i, final StructureTFComponent sideTower) {
            super(i);
            this.groundLevel = -1;
            this.setCoordBaseMode(sideTower.getCoordBaseMode());
            this.field_74887_e = new StructureBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78895_b - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78895_b, sideTower.func_74874_b().field_78892_f + 2);
        }
        
        public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
            if (parent != null && parent instanceof StructureTFComponent) {
                this.deco = ((StructureTFComponent)parent).deco;
            }
        }
        
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            if (this.groundLevel < 0) {
                this.groundLevel = this.getDeadrockLevel(world, sbb);
                if (this.groundLevel < 0) {
                    return true;
                }
            }
            final int height = this.field_74887_e.field_78894_e - this.groundLevel;
            final int mid = height / 2;
            final int size = this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a;
            for (int rotation = 0; rotation < 4; ++rotation) {
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -1, 1, rotation, sbb);
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 2, -1, 1, rotation, sbb);
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 2, -mid, 0, rotation, sbb);
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -1, 2, rotation, sbb);
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 0, -mid, 2, rotation, sbb);
                for (int x = 6; x < size - 3; x += 4) {
                    this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, x, -1, 1, rotation, sbb);
                    this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, x, -mid, 0, rotation, sbb);
                }
            }
            return true;
        }
        
        protected int getDeadrockLevel(final World world, final StructureBoundingBox sbb) {
            int groundLevel = 256;
            for (int y = 150; y > 0; --y) {
                final int cx = sbb.func_78881_e();
                final int cz = sbb.func_78891_g();
                final Block block = world.func_147439_a(cx, y, cz);
                if (block == TFBlocks.deadrock) {
                    groundLevel = y;
                    break;
                }
            }
            return groundLevel;
        }
    }
    
    public static class Foundation13Thorns extends Foundation13
    {
        public Foundation13Thorns() {
        }
        
        public Foundation13Thorns(final Random rand, final int i, final StructureTFComponent sideTower) {
            super(rand, i, sideTower);
            this.field_74887_e = new StructureBoundingBox(sideTower.func_74874_b().field_78897_a - 5, sideTower.func_74874_b().field_78894_e - 1, sideTower.func_74874_b().field_78896_c - 5, sideTower.func_74874_b().field_78893_d + 5, sideTower.func_74874_b().field_78894_e, sideTower.func_74874_b().field_78892_f + 5);
        }
        
        @Override
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
            for (int i = 0; i < 4; ++i) {
                this.makeThornVine(world, decoRNG, i, sbb);
            }
            return true;
        }
        
        private void makeThornVine(final World world, final Random decoRNG, final int rotation, final StructureBoundingBox sbb) {
            final int x = 3 + decoRNG.nextInt(13);
            final int z = 3 + decoRNG.nextInt(13);
            int y = this.field_74887_e.func_78882_c() + 5;
            int twist = decoRNG.nextInt(4);
            final int twistMod = 3 + decoRNG.nextInt(3);
            while (this.getBlockIDRotated(world, x, y, z, rotation, sbb) != TFBlocks.deadrock && this.func_74862_a(y) > 60) {
                this.placeBlockRotated(world, TFBlocks.thorns, 0, x, y, z, rotation, sbb);
                switch (twist) {
                    case 0: {
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x + 1, y, z, rotation, sbb);
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x, y, z + 1, rotation, sbb);
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x + 1, y, z + 1, rotation, sbb);
                        break;
                    }
                    case 1: {
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x + 1, y, z, rotation, sbb);
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x, y, z - 1, rotation, sbb);
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x + 1, y, z - 1, rotation, sbb);
                        break;
                    }
                    case 2: {
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x - 1, y, z, rotation, sbb);
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x, y, z - 1, rotation, sbb);
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x - 1, y, z - 1, rotation, sbb);
                        break;
                    }
                    case 3: {
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x - 1, y, z, rotation, sbb);
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x, y, z + 1, rotation, sbb);
                        this.placeBlockRotated(world, TFBlocks.thorns, 0, x - 1, y, z + 1, rotation, sbb);
                        break;
                    }
                }
                if (Math.abs(y % twistMod) == 1) {
                    this.makeThornBranch(world, x, y, z, rotation, sbb);
                }
                if (y % twistMod == 0) {
                    twist = ++twist % 4;
                }
                --y;
            }
        }
        
        private void makeThornBranch(final World world, final int x, final int y, final int z, final int rotation, final StructureBoundingBox sbb) {
            final Random rand = new Random(world.func_72905_C() + x * 321534781 ^ (long)(y * 756839 + z));
            final int dir = rand.nextInt(4);
            int dx = 0;
            int dz = 0;
            switch (dir) {
                case 0: {
                    dx = 1;
                    break;
                }
                case 1: {
                    dz = 1;
                    break;
                }
                case 2: {
                    dx = -1;
                    break;
                }
                case 3: {
                    dz = -1;
                    break;
                }
            }
            final int dist = 2 + rand.nextInt(3);
            final int destX = x + dist * dx;
            final int destZ = z + dist * dz;
            if (destX > 0 && destX < this.field_74887_e.func_78883_b() && destZ > 0 && destZ < this.field_74887_e.func_78880_d()) {
                for (int i = 0; i < dist; ++i) {
                    final int branchMeta = ((dir + rotation + this.field_74885_f) % 2 == 0) ? 5 : 9;
                    if (i > 0) {
                        this.placeBlockRotated(world, TFBlocks.thorns, branchMeta, x + dx * i, y, z + dz * i, rotation, sbb);
                    }
                    this.placeBlockRotated(world, TFBlocks.thorns, 1, destX, y + i, destZ, rotation, sbb);
                    if (i > dist / 2) {
                        this.placeBlockRotated(world, TFBlocks.thorns, branchMeta, x + dx * i, y + dist - 1, z + dz * i, rotation, sbb);
                    }
                }
            }
        }
    }
    
    public static class BellFoundation21 extends Foundation13
    {
        public BellFoundation21() {
        }
        
        public BellFoundation21(final Random rand, final int i, final StructureTFComponent sideTower) {
            super(rand, i, sideTower);
            this.field_74887_e = new StructureBoundingBox(sideTower.func_74874_b().field_78897_a - 2, sideTower.func_74874_b().field_78894_e - 1, sideTower.func_74874_b().field_78896_c - 2, sideTower.func_74874_b().field_78893_d + 2, sideTower.func_74874_b().field_78894_e, sideTower.func_74874_b().field_78892_f + 2);
        }
        
        @Override
        public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
            if (this.groundLevel < 0) {
                this.groundLevel = this.getDeadrockLevel(world, sbb);
            }
            final int height = this.field_74887_e.field_78894_e - this.groundLevel;
            final int mid = 16;
            final int low = 32;
            final int size = this.field_74887_e.field_78893_d - this.field_74887_e.field_78897_a;
            for (int rotation = 0; rotation < 4; ++rotation) {
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 2, -1, 1, rotation, sbb);
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 2, -mid, 0, rotation, sbb);
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -1, 2, rotation, sbb);
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 0, -mid, 2, rotation, sbb);
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -low, 1, rotation, sbb);
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 0, -low, 1, rotation, sbb);
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 1, -low, 0, rotation, sbb);
                this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, 0, -low, 0, rotation, sbb);
                for (int x = 6; x < size - 3; x += 4) {
                    this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, x, -1, 1, rotation, sbb);
                    this.fillToGroundRotated(world, this.deco.blockID, this.deco.blockMeta, x, -mid, 0, rotation, sbb);
                }
            }
            return true;
        }
    }
}
