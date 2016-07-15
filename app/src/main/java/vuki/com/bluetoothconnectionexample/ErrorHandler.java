package vuki.com.bluetoothconnectionexample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

/**
 * Created by mvukosav on 15.7.2016..
 */
public final class ErrorHandler {

    /**
     * Method for displaying alert dialog for given error code
     *
     * @param context   - context of calling activity
     * @param errorCode - code for given error
     */
    public static void reportError( Context context, @ErrorCode String errorCode ) {

        switch( errorCode ) {
            case ErrorCode.NETWORK_CONNECTION_ERROR:
                showErrorDialog( context, "Network error", "Network is not enabled", "Ok" );
                break;
            case ErrorCode.BLUETOOTH_IS_NOT_SUPPORTED:
                showErrorDialog( context, "Bluetooth error", "Bluetooth is not enabled", "Ok" );
                break;
            default:
                Log.e( "Error code", "Error code is: " + errorCode );
                break;
        }
    }

    private static void showErrorDialog( Context context, String title, String message, String positiveButtonMsg ) {
        AlertDialog.Builder adBuilder = new AlertDialog.Builder( context )
                .setTitle( title )
                .setMessage( message )
                .setPositiveButton( positiveButtonMsg, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialog, int which ) {
                        dialog.dismiss();
                    }
                } );

        AlertDialog alert = adBuilder.create();
        alert.show();
    }

}
