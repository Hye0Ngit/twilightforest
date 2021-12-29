// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import twilightforest.entity.EntityTFArmoredGiant;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFGiantMiner;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFCloudCastle extends StructureTFComponent
{
    private boolean minerPlaced;
    private boolean warriorPlaced;
    
    public ComponentTFCloudCastle() {
        this.minerPlaced = false;
        this.warriorPlaced = false;
    }
    
    public ComponentTFCloudCastle(final int index, int x, int y, int z) {
        super(index);
        this.minerPlaced = false;
        this.warriorPlaced = false;
        this.setCoordBaseMode(0);
        x = x >> 2 << 2;
        y = y >> 2 << 2;
        z = z >> 2 << 2;
        this.spawnListIndex = 1;
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -8, 0, -8, 16, 16, 16, 0);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74757_a("minerPlaced", this.minerPlaced);
        par1NBTTagCompound.func_74757_a("warriorPlaced", this.warriorPlaced);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.minerPlaced = par1NBTTagCompound.func_74767_n("minerPlaced");
        this.warriorPlaced = par1NBTTagCompound.func_74767_n("warriorPlaced");
    }
    
    public void func_74861_a(final StructureComponent parent, final List list, final Random rand) {
        boolean plus = rand.nextBoolean();
        int offset = rand.nextInt(5) - rand.nextInt(5);
        final ComponentTFCloudTree treeX = new ComponentTFCloudTree(this.func_74877_c() + 1, this.field_74887_e.field_78897_a + (plus ? 16 : -16), 168, this.field_74887_e.field_78896_c - 8 + offset * 4);
        list.add(treeX);
        treeX.func_74861_a((StructureComponent)this, list, rand);
        plus = rand.nextBoolean();
        offset = rand.nextInt(5) - rand.nextInt(5);
        final ComponentTFCloudTree treeZ = new ComponentTFCloudTree(this.func_74877_c() + 1, this.field_74887_e.field_78897_a - 8 + offset * 4, 168, this.field_74887_e.field_78896_c + (plus ? 16 : -16));
        list.add(treeZ);
        treeZ.func_74861_a((StructureComponent)this, list, rand);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_151556_a(world, sbb, 0, -4, 0, 15, -1, 15, TFBlocks.fluffyCloud, 0, TFBlocks.fluffyCloud, 0, false);
        this.func_151556_a(world, sbb, 0, 0, 0, 15, 11, 15, TFBlocks.giantCobble, 0, TFBlocks.giantCobble, 0, false);
        this.func_151556_a(world, sbb, 0, 12, 0, 15, 15, 15, TFBlocks.giantLog, 0, TFBlocks.giantLog, 0, false);
        this.func_74878_a(world, sbb, 4, 0, 4, 11, 11, 11);
        this.func_74878_a(world, sbb, 0, 0, 4, 4, 7, 7);
        if (!this.minerPlaced) {
            final int bx = this.func_74865_a(6, 6);
            final int by = this.func_74862_a(0);
            final int bz = this.func_74873_b(6, 6);
            if (sbb.func_78890_b(bx, by, bz)) {
                this.minerPlaced = true;
                final EntityTFGiantMiner miner = new EntityTFGiantMiner(world);
                miner.func_70107_b((double)bx, (double)by, (double)bz);
                miner.makeNonDespawning();
                world.func_72838_d((Entity)miner);
            }
        }
        if (!this.warriorPlaced) {
            final int bx = this.func_74865_a(9, 9);
            final int by = this.func_74862_a(0);
            final int bz = this.func_74873_b(9, 9);
            if (sbb.func_78890_b(bx, by, bz)) {
                this.warriorPlaced = true;
                final EntityTFArmoredGiant warrior = new EntityTFArmoredGiant(world);
                warrior.func_70107_b((double)bx, (double)by, (double)bz);
                warrior.makeNonDespawning();
                world.func_72838_d((Entity)warrior);
            }
        }
        return true;
    }
}
