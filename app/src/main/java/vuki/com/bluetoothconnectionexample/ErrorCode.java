package vuki.com.bluetoothconnectionexample;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by mvukosav on 15.7.2016..
 */
@StringDef({
        ErrorCode.NETWORK_CONNECTION_ERROR,
        ErrorCode.BLUETOOTH_IS_NOT_SUPPORTED,

})

@Retention(RetentionPolicy.SOURCE)
public @interface ErrorCode {
    String NETWORK_CONNECTION_ERROR = "network connection error";
    String BLUETOOTH_IS_NOT_SUPPORTED = "bluetooth is not supported";

}
