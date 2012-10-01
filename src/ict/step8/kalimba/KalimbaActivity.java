package ict.step8.kalimba;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v4.app.NavUtils;

public class KalimbaActivity extends Activity implements OnClickListener{

	public MediaPlayer[] mp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TypedArray notes = getResources().obtainTypedArray(R.array.notes);
        TypedArray buttons = getResources().obtainTypedArray(R.array.buttons);
        this.mp = new MediaPlayer[notes.length()];
        
        for(int i = 0;i <notes.length();i++ ){
        	mp[i]=MediaPlayer.create(this,notes.getResourceId(i, -1));
        }
        
        for(int i = 0;i<buttons.length();i++){
        	this.findViewById(buttons.getResourceId(i, -1)).setOnClickListener(this);
        }
        
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_kalimba, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		
		TypedArray buttons = getResources().obtainTypedArray(R.array.buttons);
		
		for(int i =0;i < buttons.length();i++){
			if(buttons.getResourceId(i, -1)==v.getId()){
				mp[i].seekTo(0);
				mp[i].start();
				break;
			}
		}
		
	}

    
}
