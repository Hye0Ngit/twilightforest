// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFTrollCloud extends StructureTFComponent
{
    private int size;
    private int height;
    
    public ComponentTFTrollCloud() {
    }
    
    public ComponentTFTrollCloud(final int index, final int x, final int y, final int z) {
        super(index);
        this.setCoordBaseMode(0);
        this.size = 40;
        this.height = 20;
        final int radius = this.size / 2;
        this.field_74887_e = StructureTFComponent.getComponentToAddBoundingBox(x, y, z, -radius, -this.height, -radius, this.size, this.height, this.size, 0);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound par1NBTTagCompound) {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.func_74768_a("size", this.size);
        par1NBTTagCompound.func_74768_a("height", this.height);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound par1NBTTagCompound) {
        super.func_143011_b(par1NBTTagCompound);
        this.size = par1NBTTagCompound.func_74762_e("size");
        this.height = par1NBTTagCompound.func_74762_e("height");
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeCloud(world, sbb, 0, 0, 0, this.size - 1, 6, this.size - 1);
        return true;
    }
    
    protected void placeCloud(final World world, final StructureBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        this.func_151556_a(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, (Block)Blocks.field_150399_cn, 0, (Block)Blocks.field_150399_cn, 0, false);
        this.func_151556_a(world, sbb, minX + 2, minY + 2, minZ + 2, maxX - 2, maxY - 1, maxZ - 2, Blocks.field_150371_ca, 0, Blocks.field_150371_ca, 0, false);
    }
}
