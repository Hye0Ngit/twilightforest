// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import twilightforest.TFFeature;
import net.minecraft.world.gen.structure.StructureComponent;

public abstract class StructureTFComponent extends StructureComponent
{
    public StructureTFDecorator deco;
    public int spawnListIndex;
    protected TFFeature feature;
    
    public StructureTFComponent() {
        this.deco = null;
        this.spawnListIndex = 0;
        this.feature = TFFeature.NOTHING;
        this.field_186169_c = Rotation.NONE;
    }
    
    public StructureTFComponent(final int i) {
        super(i);
        this.deco = null;
        this.spawnListIndex = 0;
        this.feature = TFFeature.NOTHING;
        this.field_186169_c = Rotation.NONE;
    }
    
    public StructureTFComponent(final TFFeature feature, final int i) {
        super(i);
        this.deco = null;
        this.spawnListIndex = 0;
        this.feature = TFFeature.NOTHING;
        this.feature = feature;
        this.field_186169_c = Rotation.NONE;
    }
    
    public TFFeature getFeatureType() {
        return this.feature;
    }
    
    protected static boolean shouldDebug() {
        return false;
    }
    
    protected void setDebugCorners(final World world) {
        if (this.field_186169_c == null) {
            this.field_186169_c = Rotation.NONE;
        }
        if (shouldDebug()) {
            final int i = this.field_186169_c.ordinal() * 4;
            world.func_175656_a(new BlockPos(this.func_74874_b().field_78897_a, this.func_74874_b().field_78894_e + i, this.func_74874_b().field_78896_c), Blocks.field_150325_L.func_176203_a(i));
            world.func_175656_a(new BlockPos(this.func_74874_b().field_78893_d, this.func_74874_b().field_78894_e + i + 1, this.func_74874_b().field_78896_c), Blocks.field_150325_L.func_176203_a(1 + i));
            world.func_175656_a(new BlockPos(this.func_74874_b().field_78897_a, this.func_74874_b().field_78894_e + i + 2, this.func_74874_b().field_78892_f), Blocks.field_150325_L.func_176203_a(2 + i));
            world.func_175656_a(new BlockPos(this.func_74874_b().field_78893_d, this.func_74874_b().field_78894_e + i + 3, this.func_74874_b().field_78892_f), Blocks.field_150325_L.func_176203_a(3 + i));
        }
    }
    
    protected void setDebugEntity(final World world, final int x, final int y, final int z, final StructureBoundingBox sbb, final String s) {
        this.setInvisibleTextEntity(world, x, y, z, sbb, s, shouldDebug(), 0.0f);
    }
    
    protected void setInvisibleTextEntity(final World world, final int x, final int y, final int z, final StructureBoundingBox sbb, final String s, final boolean forcePlace, final float additionalYOffset) {
        if (forcePlace) {
            final BlockPos pos = new BlockPos(this.func_74865_a(x, z), this.func_74862_a(y), this.func_74873_b(x, z));
            if (sbb.func_175898_b((Vec3i)pos)) {
                final EntityArmorStand armorStand = new EntityArmorStand(world);
                armorStand.func_96094_a(s);
                armorStand.func_70012_b(pos.func_177958_n() + 0.5, (double)(pos.func_177956_o() + additionalYOffset), pos.func_177952_p() + 0.5, 0.0f, 0.0f);
                armorStand.func_184224_h(true);
                armorStand.func_82142_c(true);
                armorStand.func_174805_g(true);
                armorStand.func_174810_b(true);
                armorStand.func_189654_d(true);
                armorStand.func_184212_Q().func_187227_b(EntityArmorStand.field_184801_a, (Object)(byte)((byte)armorStand.func_184212_Q().func_187225_a(EntityArmorStand.field_184801_a) | 0x10));
                world.func_72838_d((Entity)armorStand);
            }
        }
    }
    
    protected void setDebugEntity(final World world, final BlockPos blockpos, final String s) {
        if (shouldDebug()) {
            final EntitySheep sheep = new EntitySheep(world);
            sheep.func_96094_a(s);
            sheep.func_94061_f(true);
            sheep.func_70012_b(blockpos.func_177958_n() + 0.5, (double)(blockpos.func_177956_o() + 10), blockpos.func_177952_p() + 0.5, 0.0f, 0.0f);
            sheep.func_184224_h(true);
            sheep.func_82142_c(true);
            sheep.func_174805_g(true);
            sheep.func_174810_b(true);
            sheep.func_189654_d(true);
            world.func_72838_d((Entity)sheep);
        }
    }
    
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        tagCompound.func_74768_a("si", this.spawnListIndex);
        tagCompound.func_74778_a("deco", StructureTFDecorator.getDecoString(this.deco));
        tagCompound.func_74768_a("rot", this.field_186169_c.ordinal());
    }
    
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        this.spawnListIndex = tagCompound.func_74762_e("si");
        this.deco = StructureTFDecorator.getDecoFor(tagCompound.func_74779_i("deco"));
        this.field_186169_c = Rotation.values()[tagCompound.func_74762_e("rot") % Rotation.values().length];
    }
    
    public boolean isComponentProtected() {
        return true;
    }
}
