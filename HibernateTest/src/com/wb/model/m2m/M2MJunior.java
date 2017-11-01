package com.wb.model.m2m;

import java.util.Set;

public interface M2MJunior extends M2MPerson {

    void setElder(Set<M2MPerson> elders);
    
    Set<M2MPerson> getElder();
    
    void addElder(M2MPerson elder);
    
    void delElder(M2MPerson elder);
}
