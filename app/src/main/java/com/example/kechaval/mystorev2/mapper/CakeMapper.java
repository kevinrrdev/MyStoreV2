package com.example.kechaval.mystorev2.mapper;

import com.example.kechaval.mystorev2.mvp.model.Cake;
import com.example.kechaval.mystorev2.mvp.model.CakesResponse;
import com.example.kechaval.mystorev2.mvp.model.CakesResponseCakes;
import com.example.kechaval.mystorev2.mvp.model.Storage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by KeChaval on 12/07/2018.
 */

public class CakeMapper {



    @Inject
    public CakeMapper() {
    }

    public List<Cake> mapCakes(Storage storage, CakesResponse response){
        List<Cake> cakesList= new ArrayList<>();
        if (response!=null){
            CakesResponseCakes[] responseCakes= response.getCakes();
            if (responseCakes!=null){
                for (CakesResponseCakes cake: responseCakes){
                    Cake myCake= new Cake();
                    myCake.setId(cake.getId());
                    myCake.setTitle(cake.getTitle());
                    myCake.setDetailDescription(cake.getDetailDescription());
                    myCake.setPreviewDescription(cake.getPreviewDescription());
                    myCake.setImageUrl(cake.getImage());
                    storage.addCake(myCake);
                    cakesList.add(myCake);
                }
            }
        }
        return cakesList;
    }

}
