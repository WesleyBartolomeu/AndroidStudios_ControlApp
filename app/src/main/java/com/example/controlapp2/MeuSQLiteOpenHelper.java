package com.example.controlapp2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MeuSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MeuBancoDeDados.db";

    public MeuSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criar as tabelas necessárias
        String SQL_CREATE_USUARIOS_TABLE = "CREATE TABLE usuarios (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "email TEXT NOT NULL, " +
                "senha TEXT NOT NULL" +
                ");";
        db.execSQL(SQL_CREATE_USUARIOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualizar o banco de dados para a nova versão, se necessário
    }

    // Método para adicionar um novo usuário ao banco de dados
    public void adicionarUsuario(String email, String senha) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("senha", senha);

        long resultado = db.insert("usuarios", null, values);
        db.close();
    }

    // Método para verificar se um usuário com determinado email e senha existe no banco de dados
    public boolean verificarLogin(String email, String senha) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                "_id"
        };
        String selection = "email = ? AND senha = ?";
        String[] selectionArgs = { email, senha };

        Cursor cursor = db.query(
                "usuarios",
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        boolean resultado = cursor.getCount() > 0;
        cursor.close();
        db.close();

        return resultado;
    }
}
