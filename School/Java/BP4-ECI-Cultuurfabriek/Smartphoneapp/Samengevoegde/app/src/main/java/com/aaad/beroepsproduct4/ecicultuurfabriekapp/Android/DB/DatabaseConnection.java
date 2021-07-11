/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.DB;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.aaad.beroepsproduct4.ecicultuurfabriekapp.Android.Model.StandardDebugActions;

import org.apache.commons.lang3.time.StopWatch;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.transform.Result;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

/**
 *
 * @author swkoe
 */
public class DatabaseConnection extends AsyncTask<Void, Void, String> //implements Callable<Void>
{
    private HttpConnectionService myConnection;
    private boolean isConnected = false;
    private String apiPath = "http://10.0.2.2/PHPRestAPI/Controller/RestController.php";
    private JSONArray resultJsonArray;
    private String apiResponse = "";
    private HashMap<String, String> postDataParams;
    private Context mContext;
    private Activity mActivity;
    private ProgressDialog processDialog;
    //private StopWatch stopWatch;
    //private Boolean isWorkerThreadActive = true;
//    private String currentTable, currentSelection;

    public String getApiResponse() {
        return this.apiResponse;
    }

    public void setApiResponse(String apiResponse) {
        this.apiResponse = apiResponse;
    }

    public String getApiPath() {
        return this.apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }
    public AbstractMap.SimpleEntry<String, String> getContentType() {
        return this.contentType;
    }

    public void setContentType(AbstractMap.SimpleEntry<String, String> contentType) {
        this.contentType = contentType;
    }

    private AbstractMap.SimpleEntry<String, String> contentType;

    public HashMap<String, String> getPostDataParams() {
        return this.postDataParams;
    }

    public void setPostDataParams(HashMap<String, String> postDataParams) {
        this.postDataParams = postDataParams;
    }

//    public String getCurrentTable() {
//        return this.currentTable;
//    }
//
//    public void setCurrentTable(String currentTable) {
//        this.currentTable = currentTable;
//    }
//
//    public String getCurrentSelection() {
//        return this.currentSelection;
//    }
//
//    public void setCurrentSelection(String currentSelection) {
//        this.currentSelection = currentSelection;
//    }

    /**
     *
     *
     *
     */
    public DatabaseConnection(Context context, Activity activity)
    {
        mContext = context;
        mActivity = activity;
        postDataParams = new HashMap<String, String>();
        postDataParams.put("HTTP_ACCEPT", "application/json");
        setContentType(new AbstractMap.SimpleEntry<String, String>("connection", "close"));
        //stopWatch = new StopWatch();
        this.myConnection = new HttpConnectionService();
//        try
//        {
//            //myConnection = DriverManager.getConnection(sAddressIP, sUsername, sPassword);
//        }
//        catch (Exception ex)
//        {
//
//        }
    }

    public void connect()
    {
//        try
//        {
//            Class.forName(DRIVER);
//            myConnection.beginRequest();
//            if(myConnection.isClosed())
//            {
//                myConnection = DriverManager.getConnection(sAddressIP, sUsername, sPassword);
//            }
//            isConnected = true;

//        } catch (Exception e)
//        {
//            StandardDebugActions.error(e);
//            isConnected = false;
//        }
    }

    public boolean isConnected()
    {
        return isConnected;
    }

    public void readQuery(String sOutput)
    {
        try
        {
//            Class.forName(driver);
//            Statement myQuery = myConnection.createStatement();
//            result = myQuery.executeQuery(sOutput);
        }
        catch (Exception e)
        {
            StandardDebugActions.error(e);
        }
    }

    public void executeQuery(String sTabelNaam, String sSelectie)
    {
//            Class.forName(driver);
//            Statement myQuery = myConnection.createStatement();
//            myQuery.execute(sOutput);
    }

    public JSONArray getResult()
    {
        //return result;
        return this.resultJsonArray;
    }

    public void close()
    {
        try
        {
//            myConnection.endRequest();
//            myConnection.close();
//            isConnected = false;
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
//            isConnected = false;
        }
    }

    public void exit()
    {
        try
        {
//            myConnection.close();
//            isConnected = false;
        } catch (Exception e)
        {
            StandardDebugActions.error(e);
//            isConnected = false;
        }
    }

    @Override
    protected void onPreExecute() {
//        super.onPreExecute();
//        processDialog = new ProgressDialog(mContext);
//        processDialog.setMessage("Please  Wait ...");
//        processDialog.setCancelable(false);
//        processDialog.show();
    }


    @Override
    protected String doInBackground(Void...params)
    {
//        postDataParams = new HashMap<String, String>();
//        postDataParams.put("HTTP_ACCEPT", "application/json");
        String sResult = null;
        if(!isCancelled())
        {
//            for (int i = 0; i < 5; i++) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    // We were cancelled; stop sleeping!
//                }
//            }
//            return "Executed";
        //stopWatch.start();
            this.setApiResponse(this.myConnection.sendRequest(this.apiPath, this.postDataParams, this.contentType));
        //stopWatch.stop();
        }
//        try {
////            publishProgress((int) 100);
////            for (int i = 0; i < count; i++) {
////                totalSize += Downloader.downloadFile(urls[i]);
////                publishProgress((int) ((i / (float) count) * 100));
////                // Escape early if cancel() is called
////                if (isCancelled()) break;
////            }
//
//            isConnected = true;
//            resultJsonArray = new JSONArray(apiResponse);
//            //JSONObject resultJsonObject = new JSONObject(response);
//            //resultJsonArray = new JSONArray(response);
//        } catch (JSONException e) {
//            isConnected = false;
//            e.printStackTrace();
//        }

        return null;
        //return sResult;
       //return this.getApiResponse();
    }

//    @Override
//    // This is called each time you call publishProgress()
//    protected void onProgressUpdate(Integer... progress) {
////        setProgressPercent(progress[0]);
//    }


    // This is called when doInBackground() is finished
    @Override
    protected void onPostExecute(String result) {

        //super.onPostExecute(result);
        //this.setApiResponse(result);
        // The results of the above method
        // Processing the results here
//        myHandler.sendEmptyMessage(0);
        //this.setApiResponse(result);
//        if (processDialog.isShowing()) {
//            processDialog.dismiss();
//        }
        //this.cancel(false);
        //isWorkerThreadActive = false;
    }
//
//    @Override
//    protected void onCancelled(String result)
//    {
//
//    }

//    @Override
//    public Void call()
//    {
////        if(this.isCancelled())
////        {
////        }
//        this.execute();
//        try {
//            this.get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //this.cancel(true);
//        return null;
//    }

//    static Handler myHandler = new Handler() {
//
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 0:
//                    // calling to this function from other pleaces
//                    // The notice call method of doing things
//                    break;
//                default:
//                    break;
//            }
//        }
//    };
}
