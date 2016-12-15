package com.example.nix.multithread2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    Button create_Btn;
    Button load_Btn;
    Button clear_Btn;
    ListView listView_MA;
    ProgressBar progressBar_MA;
    File file;
    String fileName;
    FileOutputStream fileOutputStream;

    ArrayList<String> numberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileName = "numbers.txt";
        create_Btn = (Button) findViewById(R.id.Btn_Create);
        load_Btn = (Button) findViewById(R.id.Btn_Load);
        clear_Btn = (Button) findViewById(R.id.Btn_Clear);
        listView_MA = (ListView) findViewById(R.id.ListViewLayout);
        progressBar_MA = (ProgressBar) findViewById(R.id.progressBar);
        numberList = new ArrayList<String>(10);
        int counter = 0;

        //add numbers into an arraylist
        for(String addNumber: numberList){
            numberList.add(Integer.toString(counter));
            numberList.add("Thread.sleep(250);");
            counter++;
        }

        //storage path for internal file
        //http://stackoverflow.com/questions/14376807/how-to-read-write-string-from-a-file-in-android
        file = getFilesDir();

        //creating a file object
        file = new File(getApplicationContext().getFilesDir(),fileName);


        create_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFile();
            }
        });

        load_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFile();
            }
        });

        clear_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearList();
            }
        });
        }

        public void createFile(){
            try {
                FileOutputStream write2File = openFileOutput(fileName, Context.MODE_PRIVATE);
                int [] maxCount = new int[10];
                String temp;
                for(int count: maxCount){
                    maxCount[count] = count;
                    temp = Integer.toString(count);
                    write2File.write(count);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        public void loadFile(){

        }

        public void clearList(){

        }
}
