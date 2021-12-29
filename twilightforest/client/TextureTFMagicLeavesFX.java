// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.FMLTextureFX;

public class TextureTFMagicLeavesFX extends FMLTextureFX
{
    private static final String TERRAIN_PNG = "/twilightforest/terrain.png";
    private Minecraft mc;
    private int[] leafImageData;
    private int[] overlayImageData;
    private int overlayIndex;
    private int tickCounter;
    
    public TextureTFMagicLeavesFX(final Minecraft par1Minecraft) {
        super(115);
        this.leafImageData = new int[256];
        this.overlayImageData = new int[256];
        this.tickCounter = 0;
        this.mc = par1Minecraft;
        this.i = this.mc.o.b("/twilightforest/terrain.png");
        this.overlayIndex = this.e + 1;
        this.setup();
    }
    
    public void setup() {
        super.setup();
        this.leafImageData = new int[this.tileSizeSquare];
        this.overlayImageData = new int[this.tileSizeSquare];
        try {
            BufferedImage imageBuffer = ImageIO.read(this.mc.C.e().a("/twilightforest/terrain.png"));
            int tileX = this.e % 16 * this.tileSizeBase;
            int tileY = this.e / 16 * this.tileSizeBase;
            imageBuffer.getRGB(tileX, tileY, this.tileSizeBase, this.tileSizeBase, this.leafImageData, 0, this.tileSizeBase);
            imageBuffer = ImageIO.read(this.mc.C.e().a("/twilightforest/terrain.png"));
            tileX = this.overlayIndex % 16 * this.tileSizeBase;
            tileY = this.overlayIndex / 16 * this.tileSizeBase;
            imageBuffer.getRGB(tileX, tileY, this.tileSizeBase, this.tileSizeBase, this.overlayImageData, 0, this.tileSizeBase);
        }
        catch (Exception var5) {
            this.log.log(Level.WARNING, String.format("A problem occurred with the magic leaf texture: animation will be disabled", new Object[0]), var5);
            this.setErrored(true);
        }
    }
    
    public void a() {
        ++this.tickCounter;
        for (int y = 0; y < this.tileSizeBase; ++y) {
            for (int x = 0; x < this.tileSizeBase; ++x) {
                final int i = y * this.tileSizeBase + x;
                final int leafIndex = y * this.tileSizeBase + (x + this.tickCounter & this.tileSizeMask);
                final byte overByteR = (byte)(this.overlayImageData[leafIndex] >> 16 & 0xFF);
                final byte overByteG = (byte)(this.overlayImageData[leafIndex] >> 8 & 0xFF);
                final byte overByteB = (byte)(this.overlayImageData[leafIndex] >> 0 & 0xFF);
                final byte overByteA = (byte)(this.overlayImageData[leafIndex] >> 24 & 0xFF);
                if (overByteA == 0) {
                    this.d[i * 4 + 0] = (byte)(this.leafImageData[i] >> 16 & 0xFF);
                    this.d[i * 4 + 1] = (byte)(this.leafImageData[i] >> 8 & 0xFF);
                    this.d[i * 4 + 2] = (byte)(this.leafImageData[i] >> 0 & 0xFF);
                    this.d[i * 4 + 3] = (byte)(this.leafImageData[i] >> 24 & 0xFF);
                }
                else {
                    this.d[i * 4 + 0] = overByteR;
                    this.d[i * 4 + 1] = overByteG;
                    this.d[i * 4 + 2] = overByteB;
                    this.d[i * 4 + 3] = overByteA;
                }
            }
        }
    }
    
    public void a(final bap renderEngine) {
        GL11.glBindTexture(3553, this.i);
    }
}
