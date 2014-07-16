package cl.zonamovil.holamundo;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class HolaMundoActivity extends Activity {
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		//Abrimos la base de datos 'DBUsuarios' en modo escritura
		HolaMundoSQLiteHelper usdbh = 
        		new HolaMundoSQLiteHelper(this, "DBUsuarios", null, 1);
		
		
		
		SQLiteDatabase db = usdbh.getWritableDatabase();
		
		        
        if(db != null) {
        	Cursor c = db.rawQuery("SELECT * FROM Usuarios", null);
        	//Nos aseguramos de que existe al menos un registro
        	if (c.moveToFirst()) {
        		String usuario = c.getString(1);
        	    TextView txt = (TextView)findViewById(R.id.txt);
        	    txt.setText(usuario);
        	}
 
            //Cerramos la base de datos
            db.close();
        }
		
		
		if(savedInstanceState!=null){
			
			Log.i("HolaMundoActivity", "Bundle iniciado..");
			
		}else{
			
			Log.i("HolaMundoActivity", "Bundle null..");
			
		}
		
		
	}
	
	@Override
	public void onStart(){
		
		super.onStart();
		 Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
	}
	
	
	@Override
	public void onRestart(){
		
		super.onStart();
		 Toast.makeText(this, "onReStart", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onResume(){
		
		super.onResume();
		 Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onPause(){
		
		super.onPause();
		 Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onStop(){
		
		super.onStop();
		 Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onDestroy(){
		
		super.onDestroy();
		 Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
	}
	
	
	
	

}
