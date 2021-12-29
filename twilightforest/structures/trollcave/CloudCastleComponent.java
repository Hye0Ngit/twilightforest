// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import twilightforest.entity.ArmoredGiantEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import twilightforest.entity.GiantMinerEntity;
import twilightforest.entity.TFEntities;
import net.minecraft.util.math.vector.Vector3i;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class CloudCastleComponent extends TFStructureComponentOld
{
    private boolean minerPlaced;
    private boolean warriorPlaced;
    
    public CloudCastleComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(TrollCavePieces.TFClCa, nbt);
        this.minerPlaced = false;
        this.warriorPlaced = false;
        this.minerPlaced = nbt.func_74767_n("minerPlaced");
        this.warriorPlaced = nbt.func_74767_n("warriorPlaced");
    }
    
    public CloudCastleComponent(final TFFeature feature, final int index, int x, int y, int z) {
        super(TrollCavePieces.TFClCa, feature, index);
        this.minerPlaced = false;
        this.warriorPlaced = false;
        this.func_186164_a(Direction.SOUTH);
        x &= 0xFFFFFFFC;
        y &= 0xFFFFFFFC;
        z &= 0xFFFFFFFC;
        this.spawnListIndex = 1;
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -8, -4, -8, 64, 16, 64, Direction.SOUTH);
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74757_a("minerPlaced", this.minerPlaced);
        tagCompound.func_74757_a("warriorPlaced", this.warriorPlaced);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        boolean plus = rand.nextBoolean();
        int offset = rand.nextInt(5) - rand.nextInt(5);
        final CloudTreeComponent treeX = new CloudTreeComponent(this.getFeatureType(), this.func_74877_c() + 1, this.field_74887_e.field_78897_a + 8 + (plus ? 32 : -16), 168, this.field_74887_e.field_78896_c + offset * 4);
        list.add(treeX);
        treeX.func_74861_a((StructurePiece)this, (List)list, rand);
        plus = rand.nextBoolean();
        offset = rand.nextInt(5) - rand.nextInt(5);
        final CloudTreeComponent treeZ = new CloudTreeComponent(this.getFeatureType(), this.func_74877_c() + 1, this.field_74887_e.field_78897_a + offset * 4, 168, this.field_74887_e.field_78896_c + 8 + (plus ? 32 : -16));
        list.add(treeZ);
        treeZ.func_74861_a((StructurePiece)this, (List)list, rand);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_175804_a(world, sbb, 8, 0, 8, 23, 3, 23, ((Block)TFBlocks.fluffy_cloud.get()).func_176223_P(), ((Block)TFBlocks.fluffy_cloud.get()).func_176223_P(), false);
        this.func_175804_a(world, sbb, 8, 4, 8, 23, 15, 23, ((Block)TFBlocks.giant_cobblestone.get()).func_176223_P(), ((Block)TFBlocks.giant_cobblestone.get()).func_176223_P(), false);
        this.func_175804_a(world, sbb, 8, 16, 8, 23, 19, 23, ((Block)TFBlocks.giant_log.get()).func_176223_P(), ((Block)TFBlocks.giant_log.get()).func_176223_P(), false);
        this.func_74878_a(world, sbb, 12, 4, 12, 19, 15, 19);
        this.func_74878_a(world, sbb, 8, 4, 12, 12, 11, 15);
        if (!this.minerPlaced) {
            final int bx = this.func_74865_a(14, 14);
            final int by = this.func_74862_a(4);
            final int bz = this.func_74873_b(14, 14);
            final BlockPos pos = new BlockPos(bx, by, bz);
            if (sbb.func_175898_b((Vector3i)pos)) {
                this.minerPlaced = true;
                final GiantMinerEntity miner = new GiantMinerEntity(TFEntities.giant_miner, (World)world.func_201672_e());
                miner.func_70107_b((double)bx, (double)by, (double)bz);
                miner.func_110163_bv();
                miner.func_213386_a((IServerWorld)world, world.func_175649_E(pos), SpawnReason.STRUCTURE, null, null);
                world.func_217376_c((Entity)miner);
            }
        }
        if (!this.warriorPlaced) {
            final int bx = this.func_74865_a(17, 17);
            final int by = this.func_74862_a(4);
            final int bz = this.func_74873_b(17, 17);
            final BlockPos pos = new BlockPos(bx, by, bz);
            if (sbb.func_175898_b((Vector3i)pos)) {
                this.warriorPlaced = true;
                final ArmoredGiantEntity warrior = new ArmoredGiantEntity(TFEntities.armored_giant, (World)world.func_201672_e());
                warrior.func_70107_b((double)bx, (double)by, (double)bz);
                warrior.func_110163_bv();
                warrior.func_213386_a((IServerWorld)world, world.func_175649_E(pos), SpawnReason.STRUCTURE, null, null);
                world.func_217376_c((Entity)warrior);
            }
        }
        return true;
    }
}
