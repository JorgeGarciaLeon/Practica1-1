import java.io.*;
import java.util.ArrayList;

public class Alumno {

    //Variables de la clase
    ArrayList<String> NombreAlumnosAleatorio = new ArrayList<>();
    ArrayList<String> NombreAlumnosCompleto = new ArrayList<>();
    ArrayList<ArrayList<Double>> NotasAlumnos = new ArrayList<>();

    //Method
    public void MostrarNotasAlumnos(){
        try{

            //Cargamos el fichero
            File file = new File("Listado-de-nombres-aleatorios.csv");
            BufferedReader alumnos = new BufferedReader(new FileReader(file));

            //Cargamos todos los alumnos a la array
            String nombres;
            alumnos.readLine();
            while((nombres = alumnos.readLine())!= null){
                NombreAlumnosCompleto.add(nombres);
            }

            //Los nombres de los 10 alumnos aleatorios
            int num = 0;
            String nombreAlu = "";
            for (int q = 0; q < 10; q++) {
                num = (int) (Math.random()*NombreAlumnosCompleto.size());
                nombreAlu = NombreAlumnosCompleto.get(num);
                NombreAlumnosAleatorio.add(nombreAlu);
            }


            //Añadimos las 3 notas y la media de ambas
            double NotaMedia = 0;
            double nota = 0;

            for (int j = 0; j < 10; j++) {
                NotasAlumnos.add(new ArrayList<>());
                for (int k = 1; k <= 4; k++) {
                    if(k!=3){
                        nota = Math.random()*10;
                        NotasAlumnos.get(j).add(nota);
                        NotaMedia += nota;
                    }else{
                        NotaMedia = NotaMedia/3;
                        NotasAlumnos.get(j).add(NotaMedia);
                    }
                }
            }





        }catch (Exception e){
            System.out.println("Fallo al entrar al fichero");
        }
    }
}
