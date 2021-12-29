// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import java.util.Iterator;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.ChunkCoordinates;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFTrollCaveConnect extends ComponentTFTrollCaveMain
{
    protected boolean[] openingTowards;
    
    public ComponentTFTrollCaveConnect() {
        this.openingTowards = new boolean[] { false, false, true, false };
    }
    
    public ComponentTFTrollCaveConnect(final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final int direction) {
        super(index);
        this.openingTowards = new boolean[] { false, false, true, false };
        this.size = caveSize;
        this.height = caveHeight;
        this.setCoordBaseMode(direction);
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1, direction);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74757_a("openingTowards0", this.openingTowards[0]);
        par1NBTTagCompound.func_74757_a("openingTowards1", this.openingTowards[1]);
        par1NBTTagCompound.func_74757_a("openingTowards2", this.openingTowards[2]);
        par1NBTTagCompound.func_74757_a("openingTowards3", this.openingTowards[3]);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.openingTowards[0] = par1NBTTagCompound.func_74767_n("openingTowards0");
        this.openingTowards[1] = par1NBTTagCompound.func_74767_n("openingTowards1");
        this.openingTowards[2] = par1NBTTagCompound.func_74767_n("openingTowards2");
        this.openingTowards[3] = par1NBTTagCompound.func_74767_n("openingTowards3");
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        if (this.func_74877_c() < 3) {
            for (int i = 0; i < 4; ++i) {
                final ChunkCoordinates dest = this.getValidOpening(rand, 2, i);
                if (rand.nextBoolean() || !this.makeGardenCave(list, rand, this.func_74877_c() + 1, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, 30, 15, i)) {
                    this.makeSmallerCave(list, rand, this.func_74877_c() + 1, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, 20, 15, i);
                }
            }
        }
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.isBoundingBoxOutOfHighlands(world, sbb)) {
            return false;
        }
        this.hollowCaveMiddle(world, sbb, rand, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        final Random decoRNG = new Random(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        for (int i = 0; i < 4; ++i) {
            if (!this.openingTowards[i]) {
                this.decorateWall(world, sbb, decoRNG, i);
            }
        }
        decoRNG.setSeed(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        for (int i = 0; i < 32; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.5f, true, dest.field_71574_a, 3, dest.field_71573_c, sbb);
        }
        for (int i = 0; i < 8; ++i) {
            final ChunkCoordinates dest = this.getCoordsInCave(decoRNG);
            this.generateBlockStalactite(world, decoRNG, Blocks.field_150348_b, 0.5f, false, dest.field_71574_a, 3, dest.field_71573_c, sbb);
        }
        decoRNG.setSeed(world.func_72905_C() + this.field_74887_e.field_78897_a * 321534781 ^ (long)(this.field_74887_e.field_78896_c * 756839));
        if (this.countExits() == 1 && decoRNG.nextInt(3) == 0) {
            this.makeTreasureCrate(world, decoRNG, sbb);
        }
        else if (decoRNG.nextInt(3) == 0) {
            this.makeMonolith(world, decoRNG, sbb);
        }
        return true;
    }
    
    protected void makeMonolith(final World world, final Random rand, final StructureBoundingBox sbb) {
        final int mid = this.size / 2;
        final int height = 7 + rand.nextInt(8);
        final int rotation = rand.nextInt(4);
        this.fillBlocksRotated(world, sbb, mid - 1, 0, mid - 1, mid - 1, height, mid - 1, Blocks.field_150343_Z, 0, rotation);
        this.fillBlocksRotated(world, sbb, mid + 0, 0, mid - 1, mid + 0, height - 2, mid - 1, Blocks.field_150343_Z, 0, rotation);
        this.fillBlocksRotated(world, sbb, mid - 1, 0, mid + 0, mid - 1, height - 2, mid + 0, Blocks.field_150343_Z, 0, rotation);
        this.fillBlocksRotated(world, sbb, mid + 0, 0, mid + 0, mid + 0, height - 4, mid + 0, Blocks.field_150343_Z, 0, rotation);
    }
    
    private int countExits() {
        int count = 0;
        for (int i = 0; i < this.openingTowards.length; ++i) {
            if (this.openingTowards[i]) {
                ++count;
            }
        }
        return count;
    }
    
    private void decorateWall(final World world, final StructureBoundingBox sbb, final Random decoRNG, final int rotation) {
        if (decoRNG.nextBoolean()) {
            this.decorateBracketMushrooms(world, sbb, decoRNG, rotation);
        }
        else if (decoRNG.nextBoolean()) {
            this.decorateStoneFormation(world, sbb, decoRNG, rotation);
            this.decorateStoneFormation(world, sbb, decoRNG, rotation);
        }
        else {
            this.decorateStoneProjection(world, sbb, decoRNG, rotation);
        }
    }
    
    private void decorateStoneFormation(final World world, final StructureBoundingBox sbb, final Random decoRNG, final int rotation) {
        int z = 5 + decoRNG.nextInt(7);
        int y;
        for (int startY = y = 1 + decoRNG.nextInt(2); y < this.height; y += 2) {
            final int width = 1;
            final int depth = 1 + ((decoRNG.nextInt(3) == 0) ? 1 : 0);
            this.makeSingleStoneFormation(world, sbb, decoRNG, rotation, z, y, width, depth);
            z += decoRNG.nextInt(4) - decoRNG.nextInt(4);
            if (z < 5 || z > this.size - 5) {
                z = 5 + decoRNG.nextInt(7);
            }
        }
    }
    
    private void makeSingleStoneFormation(final World world, final StructureBoundingBox sbb, final Random decoRNG, final int rotation, final int z, final int y, final int width, final int depth) {
        if (decoRNG.nextInt(8) == 0) {
            this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y - width, z - width, this.size - 1, y + width, z + width, Blocks.field_150343_Z, 0, rotation);
        }
        else if (decoRNG.nextInt(4) == 0) {
            this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y - width, z - width, this.size - 1, y + width, z + width, TFBlocks.trollSteinn, 0, rotation);
        }
        else {
            this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y - width, z - width, this.size - 1, y + width, z + width, Blocks.field_150348_b, 0, rotation);
        }
    }
    
    private void decorateStoneProjection(final World world, final StructureBoundingBox sbb, final Random decoRNG, final int rotation) {
        final int z = 7 + decoRNG.nextInt(3) - decoRNG.nextInt(3);
        final int y = 7 + decoRNG.nextInt(3) - decoRNG.nextInt(3);
        this.randomlyFillBlocksRotated(world, sbb, decoRNG, 0.25f, this.size - 9, y, z, this.size - 2, y + 3, z + 3, TFBlocks.trollSteinn, 0, Blocks.field_150348_b, 0, rotation);
        if (decoRNG.nextBoolean()) {
            this.randomlyFillBlocksRotated(world, sbb, decoRNG, 0.25f, this.size - 9, 1, z, this.size - 6, y - 1, z + 3, TFBlocks.trollSteinn, 0, Blocks.field_150348_b, 0, rotation);
        }
        else {
            this.randomlyFillBlocksRotated(world, sbb, decoRNG, 0.25f, this.size - 9, y + 4, z, this.size - 6, this.height - 2, z + 3, TFBlocks.trollSteinn, 0, Blocks.field_150348_b, 0, rotation);
        }
    }
    
    private void decorateBracketMushrooms(final World world, final StructureBoundingBox sbb, final Random decoRNG, final int rotation) {
        int z = 5 + decoRNG.nextInt(7);
        int y;
        for (int startY = y = 1 + decoRNG.nextInt(4); y < this.height; y += 2) {
            final int width = 1 + decoRNG.nextInt(2) + decoRNG.nextInt(2);
            final int depth = 1 + decoRNG.nextInt(2) + decoRNG.nextInt(2);
            final Block mushBlock = (decoRNG.nextInt(3) == 0) ? TFBlocks.hugeGloomBlock : (decoRNG.nextBoolean() ? Blocks.field_150420_aW : Blocks.field_150419_aX);
            this.makeSingleBracketMushroom(world, sbb, rotation, z, y, width, depth, mushBlock);
            z += decoRNG.nextInt(4) - decoRNG.nextInt(4);
            if (z < 5 || z > this.size - 5) {
                z = 5 + decoRNG.nextInt(7);
            }
        }
    }
    
    private void makeSingleBracketMushroom(final World world, final StructureBoundingBox sbb, final int rotation, final int z, final int y, final int width, final int depth, final Block mushBlock) {
        this.fillBlocksRotated(world, sbb, this.size - depth, y, z - (width - 1), this.size - 2, y, z + (width - 1), mushBlock, 5, rotation);
        this.fillBlocksRotated(world, sbb, this.size - (depth + 1), y, z - (width - 1), this.size - (depth + 1), y, z + (width - 1), mushBlock, this.getMushroomMetaFor(4, rotation), rotation);
        for (int d = 0; d < depth - 1; ++d) {
            this.placeBlockRotated(world, mushBlock, this.getMushroomMetaFor(2, rotation), this.size - (2 + d), y, z - width, rotation, sbb);
        }
        this.placeBlockRotated(world, mushBlock, this.getMushroomMetaFor(1, rotation), this.size - (depth + 1), y, z - width, rotation, sbb);
        for (int d = 0; d < depth - 1; ++d) {
            this.placeBlockRotated(world, mushBlock, this.getMushroomMetaFor(8, rotation), this.size - (2 + d), y, z + width, rotation, sbb);
        }
        this.placeBlockRotated(world, mushBlock, this.getMushroomMetaFor(7, rotation), this.size - (depth + 1), y, z + width, rotation, sbb);
    }
    
    private int getMushroomMetaFor(final int meta, final int rotation) {
        if (meta > 0 && meta < 10) {
            final int totalRot = (this.field_74885_f + rotation) % 4;
            Label_0182: {
                switch (totalRot) {
                    case 0: {
                        return meta;
                    }
                    case 1: {
                        switch (meta) {
                            case 1: {
                                return 3;
                            }
                            case 2: {
                                return 6;
                            }
                            case 4: {
                                return 2;
                            }
                            case 7: {
                                return 1;
                            }
                            case 8: {
                                return 4;
                            }
                            default: {
                                return 10 - meta % 10;
                            }
                        }
                        break;
                    }
                    case 2: {
                        return 10 - meta % 10;
                    }
                    case 3: {
                        switch (meta) {
                            case 1: {
                                return 7;
                            }
                            case 2: {
                                return 4;
                            }
                            case 4: {
                                return 8;
                            }
                            case 7: {
                                return 9;
                            }
                            case 8: {
                                return 6;
                            }
                            default: {
                                break Label_0182;
                            }
                        }
                        break;
                    }
                }
            }
            return 15;
        }
        return meta;
    }
    
    protected boolean makeGardenCave(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final int rotation) {
        final int direction = (this.getCoordBaseMode() + rotation) % 4;
        final ChunkCoordinates dest = this.offsetTowerCCoords(x, y, z, caveSize, direction);
        final ComponentTFTrollCaveMain cave = new ComponentTFTrollCaveGarden(index, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, caveSize, caveHeight, direction);
        final StructureComponent intersect = StructureComponent.func_74883_a((List)list, cave.func_74874_b());
        final StructureComponent otherGarden = this.findNearbyGarden(list, cave.func_74874_b());
        if ((intersect == null || intersect == this) && otherGarden == null) {
            list.add(cave);
            cave.func_74861_a(list.get(0), list, rand);
            return this.openingTowards[rotation] = true;
        }
        return false;
    }
    
    private StructureComponent findNearbyGarden(final List<StructureComponent> list, final StructureBoundingBox boundingBox) {
        final StructureBoundingBox structureBoundingBox;
        final StructureBoundingBox largeBox = structureBoundingBox = new StructureBoundingBox(boundingBox);
        structureBoundingBox.field_78897_a -= 30;
        final StructureBoundingBox structureBoundingBox2 = largeBox;
        structureBoundingBox2.field_78895_b -= 30;
        final StructureBoundingBox structureBoundingBox3 = largeBox;
        structureBoundingBox3.field_78896_c -= 30;
        final StructureBoundingBox structureBoundingBox4 = largeBox;
        structureBoundingBox4.field_78893_d += 30;
        final StructureBoundingBox structureBoundingBox5 = largeBox;
        structureBoundingBox5.field_78894_e += 30;
        final StructureBoundingBox structureBoundingBox6 = largeBox;
        structureBoundingBox6.field_78892_f += 30;
        for (final StructureComponent component : list) {
            if (component instanceof ComponentTFTrollCaveGarden && component.func_74874_b().func_78884_a(largeBox)) {
                return component;
            }
        }
        return null;
    }
    
    @Override
    protected boolean makeSmallerCave(final List<StructureComponent> list, final Random rand, final int index, final int x, final int y, final int z, final int caveSize, final int caveHeight, final int rotation) {
        return super.makeSmallerCave(list, rand, index, x, y, z, caveSize, caveHeight, rotation) && (this.openingTowards[rotation] = true);
    }
}
