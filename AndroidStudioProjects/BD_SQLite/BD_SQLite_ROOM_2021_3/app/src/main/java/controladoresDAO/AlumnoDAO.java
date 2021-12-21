package controladoresDAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import entidades.Alumno;

@Dao
public interface AlumnoDAO {
    //Altas
    @Insert
    public void insertarAlumno(Alumno alumno);

    //Bajas
    @Query("DELETE FROM Alumno WHERE numcontrol=:nc")
    public void eliminarPorNumControl(String nc);


    //Cambios
    @Query("UPDATE Alumno SET nombre=:no,primerAp=:pap WHERE numControl=:nc")
    public void modificarPorNumControl(String nc,String no,String pap);



    //Consultas
    @Query("SELECT * FROM Alumno")
    public List<Alumno> obtenerTodos();

    @Query("SELECT * FROM Alumno WHERE nombre LIKE :nc")
    public Alumno buscarPorNombre(String nc);
}
