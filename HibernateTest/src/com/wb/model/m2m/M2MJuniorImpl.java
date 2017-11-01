package com.wb.model.m2m;

import java.util.HashSet;
import java.util.Set;

public class M2MJuniorImpl extends M2MPersonImpl implements M2MJunior {

    private Set<M2MPerson> elder = new HashSet<>();
    
    @Override
    public void setElder(Set<M2MPerson> elders) {
        this.elder = elders;
    }

    @Override
    public Set<M2MPerson> getElder() {
        return this.elder;
    }

    @Override
    public void addElder(M2MPerson elder) {
        this.elder.add(elder);
    }

    @Override
    public void delElder(M2MPerson elder) {
        this.elder.remove(elder);
    }

}
