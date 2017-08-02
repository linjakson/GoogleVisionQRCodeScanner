package online.jakson.googlevisionqrcodescanner2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class MainActivity extends AppCompatActivity {
    TextView barcodeResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barcodeResult = (TextView) findViewById(R.id.barcode_result);
    }

    public void scanBarcode(View v){
        Intent intent = new Intent(this, ScanBarcode.class);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==0) {
            if(requestCode== CommonStatusCodes.SUCCESS){
                if(data!=null){
                    Barcode barcode = data.getParcelableExtra("barcode");
                    barcodeResult.setText("Barcode 結果 : " + barcode.displayValue);
                } else {
                    barcodeResult.setText("掃不到BarCode");
                }
            }
        } else {

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
