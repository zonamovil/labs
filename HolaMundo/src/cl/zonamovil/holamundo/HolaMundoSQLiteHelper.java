package cl.zonamovil.holamundo;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class HolaMundoSQLiteHelper extends SQLiteOpenHelper {

	//Sentencia SQL para crear la tabla de Usuarios
    String sqlCreate = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)";
	
	public HolaMundoSQLiteHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Creamos la tabla 'Usuarios'
				db.execSQL(sqlCreate);

				for (int i = 1; i <= 5; i++) {
					// Generamos los datos
					int codigo = i;
					String nombre = "Usuario" + i;

					// Insertamos los datos en la tabla Usuarios
					db.execSQL("INSERT INTO Usuarios (codigo, nombre) " + "VALUES ("
							+ codigo + ", '" + nombre + "')");
				}
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		//Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
 
        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
	}
	
	
		
	

	
	
	

}
