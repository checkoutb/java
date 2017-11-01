package com.wb.model.m2m;

import java.util.HashSet;
import java.util.Set;

public class M2MElderImpl extends M2MPersonImpl implements M2MElder {

    private Set<M2MPerson> junior = new HashSet<>();
    
    @Override
    public void setJunior(Set<M2MPerson> juniors) {
        this.junior = juniors;
    }

    @Override
    public Set<M2MPerson> getJunior() {
        return this.junior;
    }

    @Override
    public void addJunior(M2MPerson junior) {
        this.junior.add(junior);
    }

    @Override
    public void delJunior(M2MPerson junior) {
        this.junior.remove(junior);
    }

}
