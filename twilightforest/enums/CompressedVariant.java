// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

public enum CompressedVariant implements IStringSerializable
{
    IRONWOOD(Material.field_151575_d, SoundType.field_185848_a), 
    FIERY(Material.field_151573_f, SoundType.field_185852_e, MapColor.field_193560_ab), 
    STEELLEAF(Material.field_151584_j, SoundType.field_185850_c), 
    ARCTIC_FUR(Material.field_151580_n, SoundType.field_185854_g), 
    CARMINITE(Material.field_151571_B, SoundType.field_185859_l, MapColor.field_151645_D);
    
    public final Material material;
    public final SoundType soundType;
    public final MapColor mapColor;
    
    private CompressedVariant(final Material material, final SoundType soundType) {
        this(material, soundType, material.func_151565_r());
    }
    
    private CompressedVariant(final Material material, final SoundType soundType, final MapColor mapColor) {
        this.material = material;
        this.soundType = soundType;
        this.mapColor = mapColor;
    }
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
