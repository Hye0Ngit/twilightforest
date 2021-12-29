// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.baked;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.BlockPartRotation;
import net.minecraft.client.renderer.block.model.ModelRotation;
import net.minecraft.client.renderer.block.model.BlockPartFace;
import net.minecraft.client.renderer.block.model.BlockFaceUV;
import org.lwjgl.util.vector.Vector3f;
import java.util.ArrayList;
import net.minecraft.client.renderer.block.model.BakedQuad;
import java.util.List;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.block.model.IBakedModel;

public class BakedMossModel implements IBakedModel
{
    private static final FaceBakery bakery;
    private static final String spriteString = "twilightforest:blocks/mosspatch";
    private static final TextureAtlasSprite mossTex;
    
    public List<BakedQuad> func_188616_a(@Nullable final IBlockState state, @Nullable final EnumFacing side, final long rand) {
        final List<BakedQuad> quads = new ArrayList<BakedQuad>();
        final List<BakedQuad> ups = new ArrayList<BakedQuad>();
        final List<BakedQuad> norths = new ArrayList<BakedQuad>();
        final List<BakedQuad> souths = new ArrayList<BakedQuad>();
        final List<BakedQuad> wests = new ArrayList<BakedQuad>();
        final List<BakedQuad> easts = new ArrayList<BakedQuad>();
        final int xMin = (int)(rand & 0x3L) + 1;
        final int xMax = (int)(rand >> 2 & 0x3L) + 1;
        final int zMin = (int)(rand >> 4 & 0x3L) + 1;
        final int zMax = (int)(rand >> 6 & 0x3L) + 1;
        final BakedQuad mainUp = makeMossQuad(8 - xMin, 8 - zMin, 8 + xMax, 8 + zMax, EnumFacing.UP, quads, ups);
        final BakedQuad mainNorth = makeMossQuad(8 - xMin, 8 - zMin, 8 + xMax, 8 + zMax, EnumFacing.NORTH, quads, norths);
        final BakedQuad mainSouth = makeMossQuad(8 - xMin, 8 - zMin, 8 + xMax, 8 + zMax, EnumFacing.SOUTH, quads, souths);
        final BakedQuad mainWest = makeMossQuad(8 - xMin, 8 - zMin, 8 + xMax, 8 + zMax, EnumFacing.WEST, quads, wests);
        final BakedQuad mainEast = makeMossQuad(8 - xMin, 8 - zMin, 8 + xMax, 8 + zMax, EnumFacing.EAST, quads, easts);
        final int num4 = (int)(rand >> 7 & 0x1L);
        final int num5 = (int)(rand >> 9 & 0x3L) + 1;
        final int num6 = (int)(rand >> 11 & 0x3L) + 1;
        final int num7 = (int)(rand >> 12 & 0x1L);
        final int num8 = (int)(rand >> 14 & 0x3L) + 1;
        final int num9 = (int)(rand >> 16 & 0x3L) + 1;
        final int num10 = (int)(rand >> 17 & 0x1L);
        final int num11 = (int)(rand >> 19 & 0x3L) + 1;
        final int num12 = (int)(rand >> 21 & 0x3L) + 1;
        final int num13 = (int)(rand >> 22 & 0x1L);
        final int num14 = (int)(rand >> 24 & 0x3L) + 1;
        final int num15 = (int)(rand >> 26 & 0x3L) + 1;
        return null;
    }
    
    private static BakedQuad makeMossQuad(final int xMin, final int zMin, final int xMax, final int zMax, final EnumFacing facing, final List<BakedQuad> generalQuads, final List<BakedQuad> faceQuads) {
        final BakedQuad toReturn = BakedMossModel.bakery.func_178414_a(new Vector3f((float)xMin, 0.0f, (float)zMin), new Vector3f((float)xMax, 1.0f, (float)zMax), new BlockPartFace((EnumFacing)null, -1, "twilightforest:blocks/mosspatch", new BlockFaceUV(new float[] { (float)(8 - xMin), (float)(8 - zMin), (float)(8 + xMax), (float)(8 + zMax) }, 0)), BakedMossModel.mossTex, facing, ModelRotation.X0_Y0, (BlockPartRotation)null, true, false);
        generalQuads.add(toReturn);
        faceQuads.add(toReturn);
        return toReturn;
    }
    
    public boolean func_177555_b() {
        return false;
    }
    
    public boolean func_177556_c() {
        return false;
    }
    
    public boolean func_188618_c() {
        return false;
    }
    
    public TextureAtlasSprite func_177554_e() {
        return null;
    }
    
    public ItemOverrideList func_188617_f() {
        return null;
    }
    
    static {
        bakery = new FaceBakery();
        mossTex = Minecraft.func_71410_x().func_147117_R().func_110572_b("twilightforest:blocks/mosspatch");
    }
}
