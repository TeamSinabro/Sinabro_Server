package Sinabro.sinabro.util;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public<T> SingleResponse<T> getSingleResponse(T data){
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.data = data;
        setSuccessResponse(singleResponse);

        return singleResponse;
    }


    void setSuccessResponse(CommonResponse response){
        response.status = 200;
        response.success = true;
        response.message = "SUCCESS";

    }
}
