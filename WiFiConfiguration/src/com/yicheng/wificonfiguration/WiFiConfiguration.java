package com.yicheng.wificonfiguration;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WiFiConfiguration extends Activity {

	public String networkSSID = null;//"dreamit"; 
	public String networkPass = null;//"4bhStepsWinBizness97"; 

	public Button apartmentButton;
	public Button dreamitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wifi_configuration);
        
        apartmentButton = (Button)findViewById(R.id.ApartmentButton);
        dreamitButton = (Button)findViewById(R.id.DreamitButton);
        
        apartmentButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				networkSSID = "HOME-D832";
	        	networkPass = "33ADC9443E4DDADF";
				
				WifiConfiguration conf = new WifiConfiguration();
		        conf.SSID = "\"" + networkSSID + "\"";   // Please note the quotes. String should contain ssid in quotes
		        
		        /* for wep*/
		        //conf.wepKeys[0] = "\"" + networkPass + "\""; 
		        //conf.wepTxKeyIndex = 0;
		        //conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
		        //conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
		        
		        /* for wpa*/
		        conf.preSharedKey = "\""+ networkPass +"\"";
		        
		        /* for open network*/
		        //conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
		        
		        Context context = getApplicationContext();
		        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE); 
		        
		        wifiManager.setWifiEnabled(true);
		        
		        wifiManager.addNetwork(conf);
		        
		        List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
		        for( WifiConfiguration i : list ) {
		            if(i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
		                 wifiManager.disconnect();
		                 wifiManager.enableNetwork(i.networkId, true);
		                 wifiManager.reconnect();               
		                 
		                 WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		                 while (wifiInfo.getSSID() == null) {
		                     Log.i("WifiStatus", "Here I am");
		                     try {
								Thread.sleep(Time.SECOND);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                     wifiInfo = wifiManager.getConnectionInfo();
		                 }
		                 System.out.println("Connection established");
		                 Toast.makeText(context, "Connection established", 1000).show();
		                 
		                 break;
		            }           
		         }
			}
		});
        
        
        dreamitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				networkSSID = "dreamit"; 
				networkPass = "4bhStepsWinBizness97"; 
				
				WifiConfiguration conf = new WifiConfiguration();
		        conf.SSID = "\"" + networkSSID + "\"";   // Please note the quotes. String should contain ssid in quotes
		        
		        /* for wep*/
		        //conf.wepKeys[0] = "\"" + networkPass + "\""; 
		        //conf.wepTxKeyIndex = 0;
		        //conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
		        //conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
		        
		        /* for wpa*/
		        conf.preSharedKey = "\""+ networkPass +"\"";
		        
		        /* for open network*/
		        //conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
		        
		        Context context = getApplicationContext();
		        WifiManager wifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE); 
		        
		        wifiManager.setWifiEnabled(true);
		        
		        wifiManager.addNetwork(conf);
		        
		        List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
		        for( WifiConfiguration i : list ) {
		            if(i.SSID != null && i.SSID.equals("\"" + networkSSID + "\"")) {
		                 wifiManager.disconnect();
		                 wifiManager.enableNetwork(i.networkId, true);
		                 wifiManager.reconnect();               
		                 
		                 WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		                 while (wifiInfo.getSSID() == null) {
		                     Log.i("WifiStatus", "Here I am");
		                     try {
								Thread.sleep(Time.SECOND);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                     wifiInfo = wifiManager.getConnectionInfo();
		                 }
		                 System.out.println("Connection established");
		                 Toast.makeText(context, "Connection established", 1000).show();
		                 
		                 break;
		            }           
		         }
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.wi_fi_configuration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	
    	//public String networkSSID = null; // "NETGEAR22";
    	//public String networkPass = null; // "happyhill330";
    	
    	//public String networkSSID = "dreamit";
    	//public String networkPass = "4bhStepsWinBizness97";
    	
        int id = item.getItemId();
        if (id == R.id.dreamit) {
        	networkSSID = "dreamit";
        	networkPass = "4bhStepsWinBizness97";
            return true;
        } else if (id == R.id.apartment) {
        	networkSSID = "NETGEAR22";
        	networkPass = "happyhill330";
        	return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
