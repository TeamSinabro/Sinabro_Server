package Sinabro.sinabro.util;

import lombok.Data;
import lombok.Getter;

@Getter
public class SingleResponse<T> extends CommonResponse{
    T data;
}
