// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.enums;

import java.util.Locale;
import net.minecraft.util.IStringSerializable;

public enum PlantVariant implements IStringSerializable
{
    MOSSPATCH, 
    MAYAPPLE, 
    CLOVERPATCH, 
    FIDDLEHEAD(true), 
    MUSHGLOOM, 
    FORESTGRASS(true), 
    DEADBUSH, 
    TORCHBERRY, 
    ROOT_STRAND, 
    FALLEN_LEAVES(true, true);
    
    public final boolean isColored;
    public final boolean isLeaves;
    
    private PlantVariant() {
        this(false);
    }
    
    private PlantVariant(final boolean isColored) {
        this(isColored, false);
    }
    
    private PlantVariant(final boolean isColored, final boolean isLeaves) {
        this.isColored = isColored;
        this.isLeaves = isLeaves;
    }
    
    public String func_176610_l() {
        return this.name().toLowerCase(Locale.ROOT);
    }
}
