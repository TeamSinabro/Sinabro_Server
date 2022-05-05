package Sinabro.sinabro.util;

import lombok.Data;
import lombok.Getter;

@Getter
public class CommonResponse {
     int status;
     boolean success;
     String message;
}
