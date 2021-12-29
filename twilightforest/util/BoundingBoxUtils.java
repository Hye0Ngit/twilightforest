// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.nbt.CompoundTag;
import javax.annotation.Nullable;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

public class BoundingBoxUtils
{
    @Deprecated
    public static Vec3i getCenter(final BoundingBox sbb) {
        return (Vec3i)sbb.m_162394_();
    }
    
    @Nullable
    public static BoundingBox getIntersectionOfSBBs(final BoundingBox box1, final BoundingBox box2) {
        if (!box1.m_71049_(box2)) {
            return null;
        }
        return new BoundingBox(Math.max(box1.m_162395_(), box2.m_162395_()), Math.max(box1.m_162396_(), box2.m_162396_()), Math.max(box1.m_162398_(), box2.m_162398_()), Math.min(box1.m_162399_(), box2.m_162399_()), Math.min(box1.m_162400_(), box2.m_162400_()), Math.min(box1.m_162401_(), box2.m_162401_()));
    }
    
    public static CompoundTag boundingBoxToNBT(final BoundingBox box) {
        return boundingBoxToExistingNBT(box, new CompoundTag());
    }
    
    public static CompoundTag boundingBoxToExistingNBT(final BoundingBox box, final CompoundTag tag) {
        tag.m_128405_("minX", box.m_162395_());
        tag.m_128405_("minY", box.m_162396_());
        tag.m_128405_("minZ", box.m_162398_());
        tag.m_128405_("maxX", box.m_162399_());
        tag.m_128405_("maxY", box.m_162400_());
        tag.m_128405_("maxZ", box.m_162401_());
        return tag;
    }
    
    public static BoundingBox NBTToBoundingBox(final CompoundTag nbt) {
        return new BoundingBox(nbt.m_128451_("minX"), nbt.m_128451_("minY"), nbt.m_128451_("minZ"), nbt.m_128451_("maxX"), nbt.m_128451_("maxY"), nbt.m_128451_("maxZ"));
    }
    
    public static BoundingBox clone(final BoundingBox box) {
        return new BoundingBox(box.m_162395_(), box.m_162396_(), box.m_162398_(), box.m_162399_(), box.m_162400_(), box.m_162401_());
    }
}
