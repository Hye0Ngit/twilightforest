// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.BlockElementRotation;
import net.minecraft.client.resources.model.ModelState;
import net.minecraftforge.client.model.SimpleModelState;
import net.minecraft.client.renderer.block.model.BlockElementFace;
import net.minecraft.client.renderer.block.model.BlockFaceUV;
import java.util.ArrayList;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.PatchBlock;
import net.minecraft.client.renderer.block.model.BakedQuad;
import java.util.List;
import java.util.Random;
import net.minecraft.core.Direction;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.resources.model.BakedModel;

record PatchModel(ResourceLocation location, TextureAtlasSprite texture, boolean shaggify) implements BakedModel {
    private static final FaceBakery BAKERY;
    private static final Vector3f MIN;
    private static final Vector3f MAX;
    
    private void setVectors(final AABB bb) {
        PatchModel.MIN.m_122245_((float)bb.f_82288_, (float)bb.f_82289_, (float)bb.f_82290_);
        PatchModel.MAX.m_122245_((float)bb.f_82291_, (float)bb.f_82292_, (float)bb.f_82293_);
    }
    
    private void setVectors(final AABB bb, final boolean north, final boolean east, final boolean south, final boolean west) {
        PatchModel.MIN.m_122245_(west ? 0.0f : ((float)bb.f_82288_), (float)bb.f_82289_, north ? 0.0f : ((float)bb.f_82290_));
        PatchModel.MAX.m_122245_(east ? 16.0f : ((float)bb.f_82291_), (float)bb.f_82292_, south ? 16.0f : ((float)bb.f_82293_));
    }
    
    public List<BakedQuad> m_6840_(@Nullable final BlockState state, @Nullable final Direction side, final Random random) {
        if (state == null) {
            return this.getQuads(false, false, false, false, PatchBlock.AABBFromRandom(random), random);
        }
        return this.getQuads((boolean)state.m_61143_((Property)PatchBlock.NORTH), (boolean)state.m_61143_((Property)PatchBlock.EAST), (boolean)state.m_61143_((Property)PatchBlock.SOUTH), (boolean)state.m_61143_((Property)PatchBlock.WEST), PatchBlock.AABBFromRandom(random), random);
    }
    
    private List<BakedQuad> getQuads(final boolean north, final boolean east, final boolean south, final boolean west, final AABB bb, final Random random) {
        final List<BakedQuad> list = new ArrayList<BakedQuad>();
        this.setVectors(bb, north, east, south, west);
        this.quadsFromAABB(list);
        if (!this.shaggify()) {
            return list;
        }
        this.setVectors(bb);
        if (PatchModel.MIN.m_122239_() > 0.0f) {
            final float originalMaxZ = PatchModel.MAX.m_122269_();
            long seed = random.nextLong();
            seed = seed * seed * 42317861L + seed * 7L;
            final int num0 = (int)(seed >> 12 & 0x3L) + 1;
            final int num2 = (int)(seed >> 15 & 0x3L) + 1;
            final int num3 = (int)(seed >> 18 & 0x3L) + 1;
            final int num4 = (int)(seed >> 21 & 0x3L) + 1;
            PatchModel.MAX.setX(PatchModel.MIN.m_122239_());
            PatchModel.MIN.m_122272_(-1.0f, 0.0f, (float)num0);
            if (PatchModel.MAX.m_122269_() - (num2 + num3 + num4) > PatchModel.MIN.m_122269_()) {
                PatchModel.MAX.setZ(PatchModel.MIN.m_122269_() + num2);
                this.quadsFromAABB(list);
                PatchModel.MAX.setZ(originalMaxZ - num3);
                PatchModel.MIN.setZ(PatchModel.MAX.m_122269_() - num4);
                this.quadsFromAABB(list);
            }
            else {
                PatchModel.MAX.m_122272_(0.0f, 0.0f, (float)(-num3));
                this.quadsFromAABB(list);
            }
            this.setVectors(bb);
        }
        if (PatchModel.MAX.m_122239_() < 16.0f) {
            final float originalMaxZ = PatchModel.MAX.m_122269_();
            long seed = random.nextLong();
            seed = seed * seed * 42317861L + seed * 17L;
            final int num0 = (int)(seed >> 12 & 0x3L) + 1;
            final int num2 = (int)(seed >> 15 & 0x3L) + 1;
            final int num3 = (int)(seed >> 18 & 0x3L) + 1;
            final int num4 = (int)(seed >> 21 & 0x3L) + 1;
            PatchModel.MIN.setX(PatchModel.MAX.m_122239_());
            PatchModel.MAX.m_122272_(1.0f, 0.0f, 0.0f);
            PatchModel.MIN.m_122272_(0.0f, 0.0f, (float)num0);
            if (PatchModel.MAX.m_122269_() - (num2 + num3 + num4) > PatchModel.MIN.m_122269_()) {
                PatchModel.MAX.setZ(PatchModel.MIN.m_122269_() + num2);
                this.quadsFromAABB(list);
                PatchModel.MAX.setZ(originalMaxZ - num3);
                PatchModel.MIN.setZ(PatchModel.MAX.m_122269_() - num4);
                this.quadsFromAABB(list);
            }
            else {
                PatchModel.MAX.m_122272_(0.0f, 0.0f, (float)(-num3));
                this.quadsFromAABB(list);
            }
            this.setVectors(bb);
        }
        if (PatchModel.MIN.m_122269_() > 0.0f) {
            final float originalMaxX = PatchModel.MAX.m_122239_();
            long seed = random.nextLong();
            seed = seed * seed * 42317861L + seed * 23L;
            final int num0 = (int)(seed >> 12 & 0x3L) + 1;
            final int num2 = (int)(seed >> 15 & 0x3L) + 1;
            final int num3 = (int)(seed >> 18 & 0x3L) + 1;
            final int num4 = (int)(seed >> 21 & 0x3L) + 1;
            PatchModel.MAX.setZ(PatchModel.MIN.m_122269_());
            PatchModel.MIN.m_122272_((float)num0, 0.0f, -1.0f);
            PatchModel.MAX.setX(PatchModel.MIN.m_122239_() + num2);
            this.quadsFromAABB(list);
            PatchModel.MAX.setX(originalMaxX - num3);
            PatchModel.MIN.setX(PatchModel.MAX.m_122239_() - num4);
            this.quadsFromAABB(list);
            this.setVectors(bb);
        }
        if (PatchModel.MAX.m_122269_() < 16.0f) {
            final float originalMaxX = PatchModel.MAX.m_122239_();
            long seed = random.nextLong();
            seed = seed * seed * 42317861L + seed * 11L;
            final int num0 = (int)(seed >> 12 & 0x3L) + 1;
            final int num2 = (int)(seed >> 15 & 0x3L) + 1;
            final int num3 = (int)(seed >> 18 & 0x3L) + 1;
            final int num4 = (int)(seed >> 21 & 0x3L) + 1;
            PatchModel.MIN.setZ(PatchModel.MAX.m_122269_());
            PatchModel.MAX.m_122272_(0.0f, 0.0f, 1.0f);
            PatchModel.MIN.m_122272_((float)num0, 0.0f, 0.0f);
            PatchModel.MAX.setX(PatchModel.MIN.m_122239_() + num2);
            this.quadsFromAABB(list);
            PatchModel.MAX.setX(originalMaxX - num3);
            PatchModel.MIN.setX(PatchModel.MAX.m_122239_() - num4);
            this.quadsFromAABB(list);
            this.setVectors(bb);
        }
        return list;
    }
    
    private void quadsFromAABB(final List<BakedQuad> quads) {
        quads.add(this.quadFromVectors(PatchModel.MIN, PatchModel.MAX, Direction.UP));
        quads.add(this.quadFromVectors(PatchModel.MIN, PatchModel.MAX, Direction.NORTH));
        quads.add(this.quadFromVectors(PatchModel.MIN, PatchModel.MAX, Direction.EAST));
        quads.add(this.quadFromVectors(PatchModel.MIN, PatchModel.MAX, Direction.SOUTH));
        quads.add(this.quadFromVectors(PatchModel.MIN, PatchModel.MAX, Direction.WEST));
    }
    
    private BakedQuad quadFromVectors(final Vector3f min, final Vector3f max, final Direction direction) {
        final Direction direction2 = null;
        final int n = 0;
        final String string = this.texture().m_118413_().toString();
        BlockFaceUV blockFaceUV = switch (direction) {
            case NORTH -> new BlockFaceUV(new float[] { max.m_122239_(), min.m_122269_() + 1.0f, min.m_122239_(), min.m_122269_() }, 0);
            case EAST -> new BlockFaceUV(new float[] { max.m_122239_(), min.m_122269_(), max.m_122239_() - 1.0f, max.m_122269_() }, 90);
            case SOUTH -> new BlockFaceUV(new float[] { min.m_122239_(), max.m_122269_(), max.m_122239_(), max.m_122269_() - 1.0f }, 0);
            case WEST -> new BlockFaceUV(new float[] { min.m_122239_(), max.m_122269_(), min.m_122239_() + 1.0f, min.m_122269_() }, 90);
            default -> new BlockFaceUV(new float[] { min.m_122239_(), min.m_122269_(), max.m_122239_(), max.m_122269_() }, 0);
        };
        final BlockElementFace face = new BlockElementFace(direction2, n, string, blockFaceUV);
        return PatchModel.BAKERY.m_111600_(min, max, face, this.texture(), direction, (ModelState)SimpleModelState.IDENTITY, (BlockElementRotation)null, true, this.location);
    }
    
    public boolean m_7541_() {
        return false;
    }
    
    public boolean m_7539_() {
        return false;
    }
    
    public boolean m_7547_() {
        return false;
    }
    
    public boolean m_7521_() {
        return false;
    }
    
    public TextureAtlasSprite m_6160_() {
        return this.texture;
    }
    
    public ItemOverrides m_7343_() {
        return ItemOverrides.f_111734_;
    }
    
    static {
        BAKERY = new FaceBakery();
        MIN = new Vector3f(0.0f, 0.0f, 0.0f);
        MAX = new Vector3f(0.0f, 0.0f, 0.0f);
    }
}
