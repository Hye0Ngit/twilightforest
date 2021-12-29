import java.util.List;
import java.io.File;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class mw extends gb
{
    public mw(final File file, final String s, final boolean flag) {
        super(file, s, flag);
    }
    
    public bl a(final xk worldprovider) {
        final File file = this.a();
        if (worldprovider instanceof WorldProviderTwilightForest) {
            final File file2 = new File(file, "DIM7");
            file2.mkdirs();
            return (bl)new or(file2);
        }
        if (worldprovider instanceof wg) {
            final File file2 = new File(file, "DIM-1");
            file2.mkdirs();
            return (bl)new or(file2);
        }
        if (worldprovider instanceof lm) {
            final File file3 = new File(file, "DIM1");
            file3.mkdirs();
            return (bl)new or(file3);
        }
        return (bl)new or(file);
    }
    
    public void a(final ev worldinfo, final List list) {
        worldinfo.a(19132);
        super.a(worldinfo, list);
    }
    
    public void e() {
        try {
            cy.a.a();
        }
        catch (InterruptedException interruptedexception) {
            interruptedexception.printStackTrace();
        }
        qy.a();
    }
}
