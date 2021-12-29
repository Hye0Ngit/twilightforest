// 
// Decompiled by Procyon v0.6-prerelease
// 

package thaumcraft.api.aspects;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import thaumcraft.api.ThaumcraftApiHelper;
import net.minecraft.item.ItemStack;
import java.util.LinkedHashMap;
import java.io.Serializable;

public class AspectList implements Serializable
{
    public LinkedHashMap<Aspect, Integer> aspects;
    
    public AspectList(final ItemStack stack) {
        this.aspects = new LinkedHashMap<Aspect, Integer>();
        try {
            final AspectList temp = ThaumcraftApiHelper.getObjectAspects(stack);
            if (temp != null) {
                for (final Aspect tag : temp.getAspects()) {
                    this.add(tag, temp.getAmount(tag));
                }
            }
        }
        catch (Exception ex) {}
    }
    
    public AspectList() {
        this.aspects = new LinkedHashMap<Aspect, Integer>();
    }
    
    public AspectList copy() {
        final AspectList out = new AspectList();
        for (final Aspect a : this.getAspects()) {
            out.add(a, this.getAmount(a));
        }
        return out;
    }
    
    public int size() {
        return this.aspects.size();
    }
    
    public int visSize() {
        int q = 0;
        for (final Aspect as : this.aspects.keySet()) {
            q += this.getAmount(as);
        }
        return q;
    }
    
    public Aspect[] getAspects() {
        final Aspect[] q = { null };
        return this.aspects.keySet().toArray(q);
    }
    
    public Aspect[] getPrimalAspects() {
        final AspectList t = new AspectList();
        for (final Aspect as : this.aspects.keySet()) {
            if (as.isPrimal()) {
                t.add(as, 1);
            }
        }
        final Aspect[] q = { null };
        return t.aspects.keySet().toArray(q);
    }
    
    public Aspect[] getAspectsSorted() {
        try {
            final Aspect[] out = this.aspects.keySet().toArray(new Aspect[0]);
            boolean change = false;
            do {
                change = false;
                for (int a = 0; a < out.length - 1; ++a) {
                    final Aspect e1 = out[a];
                    final Aspect e2 = out[a + 1];
                    if (e1 != null && e2 != null && e1.getTag().compareTo(e2.getTag()) > 0) {
                        out[a] = e2;
                        out[a + 1] = e1;
                        change = true;
                        break;
                    }
                }
            } while (change);
            return out;
        }
        catch (Exception e3) {
            return this.getAspects();
        }
    }
    
    public Aspect[] getAspectsSortedAmount() {
        try {
            final Aspect[] out = this.aspects.keySet().toArray(new Aspect[1]);
            boolean change = false;
            do {
                change = false;
                for (int a = 0; a < out.length - 1; ++a) {
                    final int e1 = this.getAmount(out[a]);
                    final int e2 = this.getAmount(out[a + 1]);
                    if (e1 > 0 && e2 > 0 && e2 > e1) {
                        final Aspect ea = out[a];
                        final Aspect eb = out[a + 1];
                        out[a] = eb;
                        out[a + 1] = ea;
                        change = true;
                        break;
                    }
                }
            } while (change);
            return out;
        }
        catch (Exception e3) {
            return this.getAspects();
        }
    }
    
    public int getAmount(final Aspect key) {
        return (this.aspects.get(key) == null) ? 0 : this.aspects.get(key);
    }
    
    public boolean reduce(final Aspect key, final int amount) {
        if (this.getAmount(key) >= amount) {
            final int am = this.getAmount(key) - amount;
            this.aspects.put(key, am);
            return true;
        }
        return false;
    }
    
    public AspectList remove(final Aspect key, final int amount) {
        final int am = this.getAmount(key) - amount;
        if (am <= 0) {
            this.aspects.remove(key);
        }
        else {
            this.aspects.put(key, am);
        }
        return this;
    }
    
    public AspectList remove(final Aspect key) {
        this.aspects.remove(key);
        return this;
    }
    
    public AspectList add(final Aspect aspect, int amount) {
        if (this.aspects.containsKey(aspect)) {
            final int oldamount = this.aspects.get(aspect);
            amount += oldamount;
        }
        this.aspects.put(aspect, amount);
        return this;
    }
    
    public AspectList merge(final Aspect aspect, int amount) {
        if (this.aspects.containsKey(aspect)) {
            final int oldamount = this.aspects.get(aspect);
            if (amount < oldamount) {
                amount = oldamount;
            }
        }
        this.aspects.put(aspect, amount);
        return this;
    }
    
    public AspectList add(final AspectList in) {
        for (final Aspect a : in.getAspects()) {
            this.add(a, in.getAmount(a));
        }
        return this;
    }
    
    public AspectList merge(final AspectList in) {
        for (final Aspect a : in.getAspects()) {
            this.merge(a, in.getAmount(a));
        }
        return this;
    }
    
    public void readFromNBT(final NBTTagCompound nbttagcompound) {
        this.aspects.clear();
        final NBTTagList tlist = nbttagcompound.func_150295_c("Aspects", 10);
        for (int j = 0; j < tlist.func_74745_c(); ++j) {
            final NBTTagCompound rs = tlist.func_150305_b(j);
            if (rs.func_74764_b("key")) {
                this.add(Aspect.getAspect(rs.func_74779_i("key")), rs.func_74762_e("amount"));
            }
        }
    }
    
    public void readFromNBT(final NBTTagCompound nbttagcompound, final String label) {
        this.aspects.clear();
        final NBTTagList tlist = nbttagcompound.func_150295_c(label, 10);
        for (int j = 0; j < tlist.func_74745_c(); ++j) {
            final NBTTagCompound rs = tlist.func_150305_b(j);
            if (rs.func_74764_b("key")) {
                this.add(Aspect.getAspect(rs.func_74779_i("key")), rs.func_74762_e("amount"));
            }
        }
    }
    
    public void writeToNBT(final NBTTagCompound nbttagcompound) {
        final NBTTagList tlist = new NBTTagList();
        nbttagcompound.func_74782_a("Aspects", (NBTBase)tlist);
        for (final Aspect aspect : this.getAspects()) {
            if (aspect != null) {
                final NBTTagCompound f = new NBTTagCompound();
                f.func_74778_a("key", aspect.getTag());
                f.func_74768_a("amount", this.getAmount(aspect));
                tlist.func_74742_a((NBTBase)f);
            }
        }
    }
    
    public void writeToNBT(final NBTTagCompound nbttagcompound, final String label) {
        final NBTTagList tlist = new NBTTagList();
        nbttagcompound.func_74782_a(label, (NBTBase)tlist);
        for (final Aspect aspect : this.getAspects()) {
            if (aspect != null) {
                final NBTTagCompound f = new NBTTagCompound();
                f.func_74778_a("key", aspect.getTag());
                f.func_74768_a("amount", this.getAmount(aspect));
                tlist.func_74742_a((NBTBase)f);
            }
        }
    }
}
