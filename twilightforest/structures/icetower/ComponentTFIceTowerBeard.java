// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.util.math.MathHelper;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.lichtower.ComponentTFTowerWing;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFIceTowerBeard extends StructureTFComponentOld
{
    protected int size;
    protected int height;
    
    public ComponentTFIceTowerBeard() {
    }
    
    public ComponentTFIceTowerBeard(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = Math.round(this.size * 1.414f);
        this.deco = wing.deco;
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
        for (int x = 0; x < this.size; ++x) {
            for (int z = 0; z < this.size; ++z) {
                for (int rHeight = Math.round(MathHelper.func_76129_c((float)(x * x + z * z))), y = 0; y < rHeight; ++y) {
                    this.func_175811_a(world, this.deco.blockState, x, this.height - y, z, sbb);
                }
            }
        }
        return true;
    }
}
