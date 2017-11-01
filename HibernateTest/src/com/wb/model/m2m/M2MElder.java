package com.wb.model.m2m;

import java.util.Set;

public interface M2MElder extends M2MPerson {

    void setJunior(Set<M2MPerson> juniors);
    
    Set<M2MPerson> getJunior();
    
    void addJunior(M2MPerson junior);
    
    void delJunior(M2MPerson junior);
    
}
