// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFHydra extends ajn
{
    public nn[] partArray;
    public dg body;
    public EntityTFHydraHead head1;
    public EntityTFHydraHead head2;
    public EntityTFHydraHead head3;
    public EntityTFHydraNeck neck1a;
    public EntityTFHydraNeck neck1b;
    public EntityTFHydraNeck neck1c;
    public EntityTFHydraNeck neck1d;
    public EntityTFHydraNeck neck2a;
    public EntityTFHydraNeck neck2b;
    public EntityTFHydraNeck neck2c;
    public EntityTFHydraNeck neck2d;
    public EntityTFHydraNeck neck3a;
    public EntityTFHydraNeck neck3b;
    public EntityTFHydraNeck neck3c;
    public EntityTFHydraNeck neck3d;
    public dg leftLeg;
    public dg rightLeg;
    public dg tail;
    nn currentTarget;
    
    public EntityTFHydra(final xd world) {
        super(world);
        this.currentTarget = null;
        this.partArray = new nn[] { (nn)(this.body = new dg((ajn)this, "body", 4.0f, 4.0f)), (nn)(this.head1 = new EntityTFHydraHead(this, "head1", 3.0f, 3.0f)), (nn)(this.head2 = new EntityTFHydraHead(this, "head2", 3.0f, 3.0f)), (nn)(this.head3 = new EntityTFHydraHead(this, "head3", 3.0f, 3.0f)), (nn)(this.leftLeg = new dg((ajn)this, "leg", 2.0f, 3.0f)), (nn)(this.rightLeg = new dg((ajn)this, "leg", 2.0f, 3.0f)), (nn)(this.tail = new dg((ajn)this, "tail", 4.0f, 4.0f)), (nn)(this.neck1a = new EntityTFHydraNeck(this, "neck1a", 2.0f, 2.0f)), (nn)(this.neck1b = new EntityTFHydraNeck(this, "neck1b", 2.0f, 2.0f)), (nn)(this.neck1c = new EntityTFHydraNeck(this, "neck1c", 2.0f, 2.0f)), (nn)(this.neck1d = new EntityTFHydraNeck(this, "neck1d", 2.0f, 2.0f)), (nn)(this.neck2a = new EntityTFHydraNeck(this, "neck2a", 2.0f, 2.0f)), (nn)(this.neck2b = new EntityTFHydraNeck(this, "neck2b", 2.0f, 2.0f)), (nn)(this.neck2c = new EntityTFHydraNeck(this, "neck2c", 2.0f, 2.0f)), (nn)(this.neck2d = new EntityTFHydraNeck(this, "neck2d", 2.0f, 2.0f)), (nn)(this.neck3a = new EntityTFHydraNeck(this, "neck3a", 2.0f, 2.0f)), (nn)(this.neck3b = new EntityTFHydraNeck(this, "neck3b", 2.0f, 2.0f)), (nn)(this.neck3c = new EntityTFHydraNeck(this, "neck3c", 2.0f, 2.0f)), (nn)(this.neck3d = new EntityTFHydraNeck(this, "neck3d", 2.0f, 2.0f)) };
        this.a(16.0f, 12.0f);
        this.ak = true;
        this.bm = "/twilightforest/hydra4.png";
        this.ab = true;
    }
    
    public EntityTFHydra(final xd world, final double x, final double y, final double z) {
        this(world);
        this.d(x, y, z);
    }
    
    public int d() {
        return 100;
    }
    
    public void e() {
        this.body.J_();
        this.head1.J_();
        this.head2.J_();
        this.head3.J_();
        this.neck1a.J_();
        this.neck1b.J_();
        this.neck1c.J_();
        this.neck1d.J_();
        this.neck2a.J_();
        this.neck2b.J_();
        this.neck2c.J_();
        this.neck2d.J_();
        this.neck3a.J_();
        this.neck3b.J_();
        this.neck3c.J_();
        this.neck3d.J_();
        if (this.bV > 0) {
            final double d = this.o + (this.bW - this.o) / this.bV;
            final double d2 = this.p + (this.bX - this.p) / this.bV;
            final double d3 = this.q + (this.bY - this.q) / this.bV;
            double d4;
            for (d4 = this.bZ - this.u; d4 < -180.0; d4 += 360.0) {}
            while (d4 >= 180.0) {
                d4 -= 360.0;
            }
            this.u += (float)(d4 / this.bV);
            this.v += (float)((this.ca - this.v) / this.bV);
            --this.bV;
            this.d(d, d2, d3);
            this.b(this.u, this.v);
        }
        lv.a("ai");
        if (this.aq()) {
            this.ch = false;
            this.ce = 0.0f;
            this.cf = 0.0f;
            this.cg = 0.0f;
        }
        else if (this.H_()) {
            if (this.b_()) {
                lv.a("newAi");
                this.s_();
                lv.b();
            }
            else {
                lv.a("oldAi");
                this.y_();
                lv.b();
                this.bf = this.u;
            }
        }
        lv.b();
        final boolean flag = this.H();
        final boolean flag2 = this.J();
        if (this.ch) {
            if (flag) {
                this.s += 0.03999999910593033;
            }
            else if (flag2) {
                this.s += 0.03999999910593033;
            }
            else if (this.z) {
                this.aD();
            }
        }
        this.ce *= 0.98f;
        this.cf *= 0.98f;
        this.cg *= 0.9f;
        final float f = this.bt;
        this.bt *= this.at();
        this.a_(this.ce, this.cf);
        this.bt = f;
        final dg body = this.body;
        final dg body2 = this.body;
        final float n = 6.0f;
        body2.J = n;
        body.I = n;
        final EntityTFHydraHead head1 = this.head1;
        final EntityTFHydraHead head2 = this.head1;
        final float n2 = 4.0f;
        head2.J = n2;
        head1.I = n2;
        final EntityTFHydraHead head3 = this.head2;
        final EntityTFHydraHead head4 = this.head2;
        final float n3 = 4.0f;
        head4.J = n3;
        head3.I = n3;
        final EntityTFHydraHead head5 = this.head3;
        final EntityTFHydraHead head6 = this.head3;
        final float n4 = 4.0f;
        head6.J = n4;
        head5.I = n4;
        final float angle = (this.bd + 180.0f) * 3.141593f / 180.0f;
        double dx = this.o - gk.a(angle) * 2.0;
        double dy = this.p;
        double dz = this.q + gk.b(angle) * 2.0;
        this.body.d(dx, dy, dz);
        this.k.a("mobSpell", this.body.o, this.body.p, this.body.q, 0.2, 0.2, 0.2);
        bo vector = bo.b(0.0, 0.0, 7.0);
        vector.a(1.0471976f);
        vector.b(-(this.bd + gk.a(this.V / 5.0f) * 10.0f) * 3.141593f / 180.0f);
        dx = this.o + vector.a;
        dy = this.p + vector.b + 3.0;
        dz = this.q + vector.c;
        this.head1.d(dx, dy, dz);
        this.k.a("mobSpell", this.head1.o, this.head1.p, this.head1.q, 0.2, 0.5, 0.8);
        vector = bo.b(0.0, 0.0, 9.0);
        vector.a(gk.a(this.V / 4.0f) * 10.0f * 3.141593f / 180.0f);
        vector.b(-(this.bd + 60.0f + gk.a(this.V / 10.0f) * 10.0f) * 3.141593f / 180.0f);
        dx = this.o + vector.a;
        dy = this.p + vector.b + 3.0;
        dz = this.q + vector.c;
        this.head2.d(dx, dy, dz);
        this.k.a("mobSpell", this.head2.o, this.head2.p, this.head2.q, 0.8, 0.5, 0.5);
        vector = bo.b(0.0, 0.0, 9.0);
        vector.a((20.0f - gk.a(this.V / 7.0f) * 27.0f) * 3.141593f / 180.0f);
        vector.b(-(this.bd - 60.0f) * 3.141593f / 180.0f);
        dx = this.o + vector.a;
        dy = this.p + vector.b + 3.0;
        dz = this.q + vector.c;
        this.head3.d(dx, dy, dz);
        this.k.a("mobSpell", this.head3.o, this.head3.p, this.head3.q, 0.3, 0.9, 0.1);
        vector = bo.b(0.0, 3.0, -1.0);
        vector.b(-this.bd * 3.141593f / 180.0f);
        this.setNeckPositon(1, this.o + vector.a, this.p + vector.b, this.q + vector.c, this.bd, 0.0f);
        vector = bo.b(-1.0, 3.0, 3.0);
        vector.b(-(this.bd + 90.0f) * 3.141593f / 180.0f);
        this.setNeckPositon(2, this.o + vector.a, this.p + vector.b, this.q + vector.c, this.bd, 0.0f);
        vector = bo.b(1.0, 3.0, 3.0);
        vector.b(-(this.bd - 90.0f) * 3.141593f / 180.0f);
        this.setNeckPositon(3, this.o + vector.a, this.p + vector.b, this.q + vector.c, this.bd, 0.0f);
    }
    
    protected void setNeckPositon(final int hi, final double startX, final double startY, final double startZ, final float startYaw, final float startPitch) {
        double endX = this.getHead(hi).o;
        double endY = this.getHead(hi).p;
        double endZ = this.getHead(hi).q;
        float endYaw = this.getHead(hi).u;
        float endPitch = this.getHead(hi).v;
        while (startYaw - endYaw < -180.0f) {
            endYaw -= 360.0f;
        }
        while (startYaw - endYaw >= 180.0f) {
            endYaw += 360.0f;
        }
        while (startPitch - endPitch < -180.0f) {
            endPitch -= 360.0f;
        }
        while (startPitch - endPitch >= 180.0f) {
            endPitch += 360.0f;
        }
        final bo vector = bo.b(0.0, 0.0, -1.25);
        vector.b(-endYaw * 3.141593f / 180.0f);
        endX += vector.a;
        endY += vector.b;
        endZ += vector.c;
        this.getNeck(hi, 1).d(startX, startY, startZ);
        this.getNeck(hi, 1).u = startYaw;
        this.getNeck(hi, 1).v = startPitch;
        this.getNeck(hi, 2).d(endX + (startX - endX) * 0.25, endY + (startY - endY) * 0.25, endZ + (startZ - endZ) * 0.25);
        this.getNeck(hi, 2).u = endYaw + (startYaw - endYaw) * 0.25f;
        this.getNeck(hi, 2).v = endPitch + (startPitch - endPitch) * 0.25f;
        this.getNeck(hi, 3).d(endX + (startX - endX) * 0.5, endY + (startY - endY) * 0.5, endZ + (startZ - endZ) * 0.5);
        this.getNeck(hi, 3).u = endYaw + (startYaw - endYaw) * 0.5f;
        this.getNeck(hi, 3).v = endPitch + (startPitch - endPitch) * 0.5f;
        this.getNeck(hi, 4).d(endX + (startX - endX) * 0.75, endY + (startY - endY) * 0.75, endZ + (startZ - endZ) * 0.75);
        this.getNeck(hi, 4).u = endYaw + (startYaw - endYaw) * 0.75f;
        this.getNeck(hi, 4).v = endPitch + (startPitch - endPitch) * 0.75f;
    }
    
    public EntityTFHydraHead getHead(final int i) {
        if (i == 1) {
            return this.head1;
        }
        if (i == 2) {
            return this.head2;
        }
        if (i == 3) {
            return this.head3;
        }
        return null;
    }
    
    public EntityTFHydraNeck getNeck(final int hi, final int s) {
        if (hi == 1) {
            if (s == 1) {
                return this.neck1a;
            }
            if (s == 2) {
                return this.neck1b;
            }
            if (s == 3) {
                return this.neck1c;
            }
            if (s == 4) {
                return this.neck1d;
            }
            return null;
        }
        else if (hi == 2) {
            if (s == 1) {
                return this.neck2a;
            }
            if (s == 2) {
                return this.neck2b;
            }
            if (s == 3) {
                return this.neck2c;
            }
            if (s == 4) {
                return this.neck2d;
            }
            return null;
        }
        else {
            if (hi != 3) {
                return null;
            }
            if (s == 1) {
                return this.neck3a;
            }
            if (s == 2) {
                return this.neck3b;
            }
            if (s == 3) {
                return this.neck3c;
            }
            if (s == 4) {
                return this.neck3d;
            }
            return null;
        }
    }
    
    protected void y_() {
        System.out.println("Calling updateEntityActionState");
        System.out.println("Current target = " + this.currentTarget);
        ++this.cd;
        final yw entityplayer = this.k.a((nn)this, -1.0);
        this.w();
        this.ce = 0.0f;
        this.cf = 0.0f;
        final float f = 32.0f;
        if (this.U.nextFloat() < 0.7f) {
            final yw entityplayer2 = this.k.a((nn)this, (double)f);
            if (entityplayer2 != null) {
                this.currentTarget = (nn)entityplayer2;
                this.ck = 100 + this.U.nextInt(20);
            }
            else {
                this.cg = (this.U.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.currentTarget != null) {
            this.a(this.currentTarget, 10.0f, (float)this.ak());
            if (this.ck-- <= 0 || this.currentTarget.G || this.currentTarget.f((nn)this) > f * f) {
                this.currentTarget = null;
            }
        }
        else {
            if (this.U.nextFloat() < 0.05f) {
                this.cg = (this.U.nextFloat() - 0.5f) * 20.0f;
            }
            this.u += this.cg;
            this.v = this.ci;
        }
        final boolean flag = this.H();
        final boolean flag2 = this.J();
        if (flag || flag2) {
            this.ch = (this.U.nextFloat() < 0.8f);
        }
    }
    
    public void a(final nn entity, final float f, final float f1) {
        super.a(entity, f, f1);
        this.faceEntity(this.head1, entity, f, f1);
        this.faceEntity(this.head2, entity, f, f1);
        this.faceEntity(this.head3, entity, f, f1);
        System.out.println("Looking at " + entity);
    }
    
    public void faceEntity(final EntityTFHydraPart head, final nn entity, final float f, final float f1) {
        final double xOffset = entity.o - head.o;
        final double yOffset = entity.q - head.q;
        double zOffset;
        if (entity instanceof acq) {
            final acq entityliving = (acq)entity;
            zOffset = head.p + 1.5 - (entityliving.p + entityliving.I());
        }
        else {
            zOffset = (entity.y.b + entity.y.e) / 2.0 - (head.p + 1.5);
        }
        final double distance = gk.a(xOffset * xOffset + yOffset * yOffset);
        final float xyAngle = (float)(Math.atan2(yOffset, xOffset) * 180.0 / 3.1415927410125732) - 90.0f;
        final float zdAngle = (float)(-(Math.atan2(zOffset, distance) * 180.0 / 3.1415927410125732));
        head.v = -updateRotation(head.v, zdAngle, f1);
        head.u = updateRotation(head.u, xyAngle, f);
        System.out.println("Updating head " + head + " with rotation " + zdAngle);
        System.out.println("Updating head " + head + " with rotation " + xyAngle);
    }
    
    private static float updateRotation(final float prevRotation, final float desiredRotation, final float constraint) {
        float f3;
        for (f3 = desiredRotation - prevRotation; f3 < -180.0f; f3 += 360.0f) {}
        while (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        if (f3 > constraint) {
            f3 = constraint;
        }
        if (f3 < -constraint) {
            f3 = -constraint;
        }
        return prevRotation + f3;
    }
    
    public int ak() {
        return 500;
    }
    
    public boolean a(final dg dragonpart, final md damagesource, final int i) {
        final float f = this.u * 3.141593f / 180.0f;
        final float f2 = gk.a(f);
        final float f3 = gk.b(f);
        if (damagesource.a() instanceof yw || damagesource == md.l) {
            this.e(damagesource, i);
        }
        return true;
    }
    
    public nn[] Z() {
        return this.partArray;
    }
    
    public boolean l_() {
        return false;
    }
    
    public boolean d_() {
        return false;
    }
    
    public void a(final md par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof yw) {
            ((yw)par1DamageSource.b()).a((ajw)TFAchievementPage.twilightHunter);
        }
    }
}
