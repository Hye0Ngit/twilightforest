// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFTowerBeard extends StructureTFComponentOld
{
    int size;
    int height;
    
    public ComponentTFTowerBeard() {
    }
    
    public ComponentTFTowerBeard(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size - 2;
        this.height = this.size / 2;
        this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a + 1, wing.func_74874_b().field_78895_b - this.height - 1, wing.func_74874_b().field_78896_c + 1, wing.func_74874_b().field_78893_d - 1, wing.func_74874_b().field_78895_b - 1, wing.func_74874_b().field_78892_f - 1);
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
        return this.makePyramidBeard(world, rand, sbb);
    }
    
    private boolean makePyramidBeard(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            final int max = this.size - y - 1;
            this.func_74882_a(world, sbb, min, this.height - y, min, max, this.height - y, max, false, rand, StructureTFComponentOld.getStrongholdStones());
        }
        return true;
    }
}
