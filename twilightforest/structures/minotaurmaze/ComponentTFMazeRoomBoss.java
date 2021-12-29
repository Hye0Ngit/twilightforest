// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFMinoshroom;
import twilightforest.TFTreasure;
import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;

public class ComponentTFMazeRoomBoss extends ComponentTFMazeRoom
{
    private boolean taurPlaced;
    
    public ComponentTFMazeRoomBoss() {
        this.taurPlaced = false;
    }
    
    public ComponentTFMazeRoomBoss(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
        this.taurPlaced = false;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.func_74866_a(world, 7, 1, 0, sbb) == 0) {
            this.func_74884_a(world, sbb, 6, 1, 0, 9, 4, 0, Block.field_72031_aZ.field_71990_ca, 0, false);
        }
        if (this.func_74866_a(world, 7, 1, 15, sbb) == 0) {
            this.func_74884_a(world, sbb, 6, 1, 15, 9, 4, 15, Block.field_72031_aZ.field_71990_ca, 0, false);
        }
        if (this.func_74866_a(world, 0, 1, 7, sbb) == 0) {
            this.func_74884_a(world, sbb, 0, 1, 6, 0, 4, 9, Block.field_72031_aZ.field_71990_ca, 0, false);
        }
        if (this.func_74866_a(world, 15, 1, 7, sbb) == 0) {
            this.func_74884_a(world, sbb, 15, 1, 6, 15, 4, 9, Block.field_72031_aZ.field_71990_ca, 0, false);
        }
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                final boolean mycelium = rand.nextInt(dist + 1) > 0;
                final boolean mushroom = rand.nextInt(dist) > 0;
                final boolean mushRed = rand.nextBoolean();
                if (mycelium) {
                    this.func_74864_a(world, Block.field_71994_by.field_71990_ca, 0, x, 0, z, sbb);
                }
                if (mushroom) {
                    this.func_74864_a(world, mushRed ? Block.field_72103_ag.field_71990_ca : Block.field_72109_af.field_71990_ca, 0, x, 1, z, sbb);
                }
            }
        }
        this.func_74872_a(world, sbb, 1, 1, 1, 3, 1, 3, Block.field_72001_bo.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 1, 2, 1, 1, 3, 4, Block.field_72001_bo.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 2, 2, 1, 4, 3, 1, Block.field_72001_bo.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 1, 4, 1, 3, 4, 3, Block.field_72001_bo.field_71990_ca, 14, 0, 0, false);
        this.placeTreasureAtCurrentPosition(world, rand, 3, 2, 3, TFTreasure.labyrinth_room, sbb);
        this.func_74872_a(world, sbb, 12, 1, 12, 14, 1, 14, Block.field_72001_bo.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 14, 2, 11, 14, 3, 14, Block.field_72001_bo.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 11, 2, 14, 14, 3, 14, Block.field_72001_bo.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 12, 4, 12, 14, 4, 14, Block.field_72001_bo.field_71990_ca, 14, 0, 0, false);
        this.placeTreasureAtCurrentPosition(world, rand, 12, 2, 12, TFTreasure.labyrinth_room, sbb);
        this.func_74872_a(world, sbb, 1, 1, 12, 3, 1, 14, Block.field_72000_bn.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 1, 2, 11, 1, 3, 14, Block.field_72000_bn.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 2, 2, 14, 4, 3, 14, Block.field_72000_bn.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 1, 4, 12, 3, 4, 14, Block.field_72000_bn.field_71990_ca, 14, 0, 0, false);
        this.placeTreasureAtCurrentPosition(world, rand, 3, 2, 12, TFTreasure.labyrinth_room, sbb);
        this.func_74872_a(world, sbb, 12, 1, 1, 14, 1, 3, Block.field_72000_bn.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 11, 2, 1, 14, 3, 1, Block.field_72000_bn.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 14, 2, 2, 14, 3, 4, Block.field_72000_bn.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 12, 4, 1, 14, 4, 3, Block.field_72000_bn.field_71990_ca, 14, 0, 0, false);
        this.placeTreasureAtCurrentPosition(world, rand, 12, 2, 3, TFTreasure.labyrinth_room, sbb);
        this.func_74872_a(world, sbb, 5, 4, 5, 7, 5, 7, Block.field_72000_bn.field_71990_ca, 14, 0, 0, false);
        this.func_74872_a(world, sbb, 8, 4, 8, 10, 5, 10, Block.field_72001_bo.field_71990_ca, 14, 0, 0, false);
        if (!this.taurPlaced) {
            final int bx = this.func_74865_a(7, 7);
            final int by = this.func_74862_a(1);
            final int bz = this.func_74873_b(7, 7);
            if (sbb.func_78890_b(bx, by, bz)) {
                this.taurPlaced = true;
                final EntityTFMinoshroom taur = new EntityTFMinoshroom(world);
                taur.func_70107_b((double)bx, (double)by, (double)bz);
                taur.func_110171_b(bx, by, bz, 7);
                world.func_72838_d((Entity)taur);
            }
        }
        return true;
    }
}
