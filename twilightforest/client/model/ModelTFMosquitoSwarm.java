// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import java.util.Random;

public class ModelTFMosquitoSwarm extends bbl
{
    bcr core;
    bcr node1;
    bcr node2;
    bcr node3;
    bcr node4;
    bcr node5;
    bcr node6;
    Random rand;
    
    public ModelTFMosquitoSwarm() {
        this.rand = new Random();
        (this.core = new bcr((bbl)this, this.rand.nextInt(28), this.rand.nextInt(28))).a(-4.0f, 0.0f, -2.0f, 1, 1, 1);
        this.core.a(0.0f, -4.0f, 0.0f);
        (this.node1 = new bcr((bbl)this, this.rand.nextInt(28), this.rand.nextInt(28))).a(-5.5f, -5.0f, -13.0f, 1, 1, 1);
        this.node1.a(2.0f, -1.0f, -6.0f);
        this.core.a(this.node1);
        (this.node2 = new bcr((bbl)this, this.rand.nextInt(28), this.rand.nextInt(28))).a(-5.5f, -13.0f, -5.0f, 1, 1, 1);
        this.node2.a(0.0f, -7.0f, -1.0f);
        this.core.a(this.node2);
        (this.node3 = new bcr((bbl)this, this.rand.nextInt(28), this.rand.nextInt(28))).a(-13.0f, -5.0f, -5.0f, 1, 1, 1);
        this.node3.a(5.0f, -2.0f, -1.0f);
        this.core.a(this.node3);
        (this.node4 = new bcr((bbl)this, this.rand.nextInt(28), this.rand.nextInt(28))).a(-5.5f, -5.0f, -13.0f, 1, 1, 1);
        this.node4.a(2.0f, -1.0f, -6.0f);
        this.core.a(this.node4);
        (this.node5 = new bcr((bbl)this, this.rand.nextInt(28), this.rand.nextInt(28))).a(-5.5f, -13.0f, -5.0f, 1, 1, 1);
        this.node5.a(0.0f, -7.0f, -1.0f);
        this.core.a(this.node5);
        (this.node6 = new bcr((bbl)this, this.rand.nextInt(28), this.rand.nextInt(28))).a(-13.0f, -5.0f, -5.0f, 1, 1, 1);
        this.node6.a(5.0f, -2.0f, -1.0f);
        this.core.a(this.node6);
        this.addBugsToNodes(this.node1);
        this.addBugsToNodes(this.node2);
        this.addBugsToNodes(this.node3);
        this.addBugsToNodes(this.node4);
        this.addBugsToNodes(this.node5);
        this.addBugsToNodes(this.node6);
    }
    
    public void a(final nm par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.core.a(par7 / 2.0f);
    }
    
    public void addBugsToNodes(final bcr node) {
        for (int bugs = 16, i = 0; i < bugs; ++i) {
            final asz vec = asz.a(11.0, 0.0, 0.0);
            final float rotateY = i * (360.0f / bugs) * 3.141593f / 180.0f;
            vec.b(rotateY);
            final bcr bug = new bcr((bbl)this, this.rand.nextInt(28), this.rand.nextInt(28));
            final float bugX = (this.rand.nextFloat() - this.rand.nextFloat()) * 4.0f;
            final float bugY = (this.rand.nextFloat() - this.rand.nextFloat()) * 4.0f;
            final float bugZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 4.0f;
            bug.a(bugX, bugY, bugZ, 1, 1, 1);
            bug.a((float)vec.c, (float)vec.d, (float)vec.e);
            bug.g = rotateY;
            node.a(bug);
        }
    }
    
    public void a(final oe par1EntityLiving, final float par2, final float par3, final float time) {
        this.core.g = (par1EntityLiving.ac + time) / 5.0f;
        this.core.f = lr.a((par1EntityLiving.ac + time) / 5.0f) / 4.0f;
        this.core.h = lr.b((par1EntityLiving.ac + time) / 5.0f) / 4.0f;
        this.node1.g = (par1EntityLiving.ac + time) / 2.0f;
        this.node1.f = lr.a((par1EntityLiving.ac + time) / 6.0f) / 2.0f;
        this.node1.h = lr.b((par1EntityLiving.ac + time) / 5.0f) / 4.0f;
        this.node2.g = lr.a((par1EntityLiving.ac + time) / 2.0f) / 3.0f;
        this.node2.f = (par1EntityLiving.ac + time) / 5.0f;
        this.node2.h = lr.b((par1EntityLiving.ac + time) / 5.0f) / 4.0f;
        this.node3.g = lr.a((par1EntityLiving.ac + time) / 7.0f) / 3.0f;
        this.node3.f = lr.b((par1EntityLiving.ac + time) / 4.0f) / 2.0f;
        this.node3.h = (par1EntityLiving.ac + time) / 5.0f;
        this.node4.f = (par1EntityLiving.ac + time) / 2.0f;
        this.node4.h = lr.a((par1EntityLiving.ac + time) / 6.0f) / 2.0f;
        this.node4.g = lr.a((par1EntityLiving.ac + time) / 5.0f) / 4.0f;
        this.node5.h = lr.a((par1EntityLiving.ac + time) / 2.0f) / 3.0f;
        this.node5.g = lr.b((par1EntityLiving.ac + time) / 5.0f) / 4.0f;
        this.node5.f = lr.b((par1EntityLiving.ac + time) / 5.0f) / 4.0f;
        this.node6.h = lr.b((par1EntityLiving.ac + time) / 7.0f) / 3.0f;
        this.node6.f = lr.b((par1EntityLiving.ac + time) / 4.0f) / 2.0f;
        this.node6.g = (par1EntityLiving.ac + time) / 5.0f;
    }
}
