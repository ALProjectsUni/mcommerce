package com.clientui.clientui.exceptions;

import com.clientui.clientui.beans.ProductBean;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    public Exception decode(String invoqueur, Response reponse)
    {
        if(reponse.status() == 400)
        {
            return new ProductBadRequestException(
                    "Requete incorrecte "
            );
        }
        return defaultErrorDecoder.decode(invoqueur, reponse);
    }
}
