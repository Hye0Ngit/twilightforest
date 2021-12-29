// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import twilightforest.entity.EntityTFArmoredGiant;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import twilightforest.entity.EntityTFGiantMiner;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.BlockPos;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFCloudCastle extends StructureTFComponentOld
{
    private boolean minerPlaced;
    private boolean warriorPlaced;
    
    public ComponentTFCloudCastle() {
        this.minerPlaced = false;
        this.warriorPlaced = false;
    }
    
    public ComponentTFCloudCastle(final TFFeature feature, final int index, int x, int y, int z) {
        super(feature, index);
        this.minerPlaced = false;
        this.warriorPlaced = false;
        this.func_186164_a(EnumFacing.SOUTH);
        x &= 0xFFFFFFFC;
        y &= 0xFFFFFFFC;
        z &= 0xFFFFFFFC;
        this.spawnListIndex = 1;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -8, 0, -8, 16, 16, 16, EnumFacing.SOUTH);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74757_a("minerPlaced", this.minerPlaced);
        tagCompound.func_74757_a("warriorPlaced", this.warriorPlaced);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.minerPlaced = tagCompound.func_74767_n("minerPlaced");
        this.warriorPlaced = tagCompound.func_74767_n("warriorPlaced");
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        boolean plus = rand.nextBoolean();
        int offset = rand.nextInt(5) - rand.nextInt(5);
        final ComponentTFCloudTree treeX = new ComponentTFCloudTree(this.func_74877_c() + 1, this.field_74887_e.field_78897_a + (plus ? 16 : -16), 168, this.field_74887_e.field_78896_c - 8 + offset * 4);
        list.add(treeX);
        treeX.func_74861_a((StructureComponent)this, (List)list, rand);
        plus = rand.nextBoolean();
        offset = rand.nextInt(5) - rand.nextInt(5);
        final ComponentTFCloudTree treeZ = new ComponentTFCloudTree(this.func_74877_c() + 1, this.field_74887_e.field_78897_a - 8 + offset * 4, 168, this.field_74887_e.field_78896_c + (plus ? 16 : -16));
        list.add(treeZ);
        treeZ.func_74861_a((StructureComponent)this, (List)list, rand);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175804_a(world, sbb, 0, -4, 0, 15, -1, 15, TFBlocks.fluffy_cloud.func_176223_P(), TFBlocks.fluffy_cloud.func_176223_P(), false);
        this.func_175804_a(world, sbb, 0, 0, 0, 15, 11, 15, TFBlocks.giant_cobblestone.func_176223_P(), TFBlocks.giant_cobblestone.func_176223_P(), false);
        this.func_175804_a(world, sbb, 0, 12, 0, 15, 15, 15, TFBlocks.giant_log.func_176223_P(), TFBlocks.giant_log.func_176223_P(), false);
        this.func_74878_a(world, sbb, 4, 0, 4, 11, 11, 11);
        this.func_74878_a(world, sbb, 0, 0, 4, 4, 7, 7);
        if (!this.minerPlaced) {
            final int bx = this.func_74865_a(6, 6);
            final int by = this.func_74862_a(0);
            final int bz = this.func_74873_b(6, 6);
            final BlockPos pos = new BlockPos(bx, by, bz);
            if (sbb.func_175898_b((Vec3i)pos)) {
                this.minerPlaced = true;
                final EntityTFGiantMiner miner = new EntityTFGiantMiner(world);
                miner.func_70107_b((double)bx, (double)by, (double)bz);
                miner.func_110163_bv();
                miner.func_180482_a(world.func_175649_E(pos), null);
                world.func_72838_d((Entity)miner);
            }
        }
        if (!this.warriorPlaced) {
            final int bx = this.func_74865_a(9, 9);
            final int by = this.func_74862_a(0);
            final int bz = this.func_74873_b(9, 9);
            final BlockPos pos = new BlockPos(bx, by, bz);
            if (sbb.func_175898_b((Vec3i)pos)) {
                this.warriorPlaced = true;
                final EntityTFArmoredGiant warrior = new EntityTFArmoredGiant(world);
                warrior.func_70107_b((double)bx, (double)by, (double)bz);
                warrior.func_110163_bv();
                warrior.func_180482_a(world.func_175649_E(pos), null);
                world.func_72838_d((Entity)warrior);
            }
        }
        return true;
    }
}
