/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.kpro.core.service.implementation.PersistenceService;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import no.ntnu.kpro.core.service.interfaces.PersistenceService;

/**
 *
 * @author aleksandersjafjell
 */
public class LocalPrivateStorage implements PersistenceService {

    /**
     * Saves a new file if it does not exist, and overwrites old if it does.
     * @param fileName Name of file to be saved.
     * @param content File content.
     * @returns true if file saved successfully, else false.
     */
    public boolean saveToStorage(String fileName, String content, Context context) {
        try{
            FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.close();
            return true;
        }catch (java.io.IOException e){
            Log.d("LocalPrivateStorage", e.getStackTrace().toString());
            return false;
        }
    }    
    public boolean saveToStorage(String fileName, String folder, String content, Context context) {
        try{
            File file = new File(folder, fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.close();
            return true;
        }catch (java.io.IOException e){
            Log.d("LocalPrivateStorage", e.getStackTrace().toString());
            return false;
        }
    }  

    /**
     * 
     * @param fileName
     * @return 
     */
    public BufferedReader readFromStorage(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader output = new BufferedReader(fr);
            return output;
        } catch (FileNotFoundException e) {
           Log.d("LocalPrivateStorage", e.getStackTrace().toString());
        }
        return null;
    }
    public BufferedReader readFromStorage(String fileName, String folder, Context context) {
        try {
            File dir = context.getDir(folder, context.MODE_PRIVATE);
            File file = new File(dir, fileName);
            FileReader fr = new FileReader(file);
            BufferedReader output = new BufferedReader(fr);
            return output;
        } catch (FileNotFoundException e) {
           Log.d("LocalPrivateStorage", e.getStackTrace().toString());
        }
        return null;
    }

    public boolean authorize(String userName, String password) {
        return true;
    }

    public boolean isAuthorized() {
        return true;
    }
    
    /**
     * deletes a given file from storage. 
     * @param fileName name of the file to delete
     * @return true if the file was successfully deleted, else false.
     */
    public boolean removeFile(String fileName, Context context) {
        return context.deleteFile(fileName);
    }


}
