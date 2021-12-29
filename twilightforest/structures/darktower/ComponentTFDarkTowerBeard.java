// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.TowerWoodVariant;
import twilightforest.block.BlockTFTowerWood;
import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.lichtower.ComponentTFTowerWing;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFDarkTowerBeard extends StructureTFComponentOld
{
    protected int size;
    protected int height;
    
    public ComponentTFDarkTowerBeard() {
    }
    
    public ComponentTFDarkTowerBeard(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = this.size / 2;
        this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a, wing.func_74874_b().field_78895_b - this.height, wing.func_74874_b().field_78896_c, wing.func_74874_b().field_78893_d, wing.func_74874_b().field_78895_b, wing.func_74874_b().field_78892_f);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("beardSize", this.size);
        tagCompound.func_74768_a("beardHeight", this.height);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.size = tagCompound.func_74762_e("beardSize");
        this.height = tagCompound.func_74762_e("beardHeight");
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.makeDarkBeard(world, sbb, 0, 0, 0, this.size - 1, this.height - 1, this.size - 1);
        return true;
    }
    
    protected void makeDarkBeard(final World world, final StructureBoundingBox sbb, final int minX, final int minY, final int minZ, final int maxX, final int maxY, final int maxZ) {
        final IBlockState frameState = TFBlocks.tower_wood.func_176223_P().func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.ENCASED);
        for (int x = minX; x <= maxX; ++x) {
            for (int z = minZ; z <= maxZ; ++z) {
                if (x == minX || x == maxX || z == minZ || z == maxZ) {
                    int length = Math.min(Math.abs(x - this.height) - 1, Math.abs(z - this.height) - 1);
                    if (length == this.height - 1) {
                        ++length;
                    }
                    if (length == -1) {
                        length = 1;
                    }
                    for (int y = maxY; y >= this.height - length; --y) {
                        this.func_175811_a(world, frameState, x, y, z, sbb);
                    }
                }
            }
        }
    }
}
