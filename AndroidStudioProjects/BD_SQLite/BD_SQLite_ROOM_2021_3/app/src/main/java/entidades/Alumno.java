package entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Alumno {
    @NonNull
    @PrimaryKey
    private String numcontrol;

    @NonNull
    @ColumnInfo(name="nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name="primerAp")
    private String primerAp;

    @NonNull
    @ColumnInfo(name="segundoAp")
    private String segudnoAp;

    @NonNull
    @ColumnInfo(name="edad")
    private byte edad;

    @NonNull
    @ColumnInfo(name="semestre")
    private byte semestre;

    @NonNull
    @ColumnInfo(name="carrera")
    private String carrera;

    @NonNull
    public String getNumcontrol() {
        return numcontrol;
    }

    public void setNumcontrol(@NonNull String numcontrol) {
        this.numcontrol = numcontrol;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getPrimerAp() {
        return primerAp;
    }

    public void setPrimerAp(@NonNull String primerAp) {
        this.primerAp = primerAp;
    }

    @NonNull
    public String getSegudnoAp() {
        return segudnoAp;
    }

    public void setSegudnoAp(@NonNull String segudnoAp) {
        this.segudnoAp = segudnoAp;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public byte getSemestre() {
        return semestre;
    }

    public void setSemestre(byte semestre) {
        this.semestre = semestre;
    }

    @NonNull
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(@NonNull String carrera) {
        this.carrera = carrera;
    }

    public Alumno(@NonNull String numcontrol, @NonNull String nombre, @NonNull String primerAp, @NonNull String segudnoAp, byte edad, byte semestre, @NonNull String carrera) {
        this.numcontrol = numcontrol;
        this.nombre = nombre;
        this.primerAp = primerAp;
        this.segudnoAp = segudnoAp;
        this.edad = edad;
        this.semestre = semestre;
        this.carrera = carrera;
    }
}
