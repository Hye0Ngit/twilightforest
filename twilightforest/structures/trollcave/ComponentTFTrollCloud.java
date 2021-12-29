// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFTrollCloud extends StructureTFComponentOld
{
    private int size;
    private int height;
    
    public ComponentTFTrollCloud() {
    }
    
    public ComponentTFTrollCloud(final TFFeature feature, final int index, final int x, final int y, final int z) {
        super(feature, index);
        this.func_186164_a(EnumFacing.SOUTH);
        this.size = 40;
        this.height = 20;
        final int radius = this.size / 2;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -radius, -this.height, -radius, this.size, this.height, this.size, EnumFacing.SOUTH);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("size", this.size);
        tagCompound.func_74768_a("height", this.height);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.size = tagCompound.func_74762_e("size");
        this.height = tagCompound.func_74762_e("height");
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.placeCloud(world, sbb, 0, 0, 0, this.size - 1, 6, this.size - 1);
        return true;
    }
    
    protected void placeCloud(final World world, final StructureBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        this.func_175804_a(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, Blocks.field_150399_cn.func_176223_P(), Blocks.field_150399_cn.func_176223_P(), false);
        this.func_175804_a(world, sbb, minX + 2, minY + 2, minZ + 2, maxX - 2, maxY - 1, maxZ - 2, Blocks.field_150371_ca.func_176223_P(), Blocks.field_150371_ca.func_176223_P(), false);
    }
}
